package androidx.media3.session;

import androidx.collection.ArrayMap;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class ConnectedControllersManager<T> {
    private final ArrayMap<T, MediaSession.ControllerInfo> controllerInfoMap = new ArrayMap<>();
    private final ArrayMap<MediaSession.ControllerInfo, ConnectedControllerRecord<T>> controllerRecords = new ArrayMap<>();
    private final Object lock = new Object();
    private final WeakReference<MediaSessionImpl> sessionImpl;

    public interface AsyncCommand {
        ListenableFuture<Void> run();
    }

    public ConnectedControllersManager(MediaSessionImpl mediaSessionImpl) {
        this.sessionImpl = new WeakReference<>(mediaSessionImpl);
    }

    public void addController(T t, MediaSession.ControllerInfo controllerInfo, SessionCommands sessionCommands, Player.Commands commands) {
        synchronized (this.lock) {
            MediaSession.ControllerInfo controller = getController(t);
            if (controller == null) {
                this.controllerInfoMap.put(t, controllerInfo);
                this.controllerRecords.put(controllerInfo, new ConnectedControllerRecord<>(t, new SequencedFutureManager(), sessionCommands, commands));
            } else {
                ConnectedControllerRecord connectedControllerRecord = (ConnectedControllerRecord) Assertions.checkStateNotNull(this.controllerRecords.get(controller));
                connectedControllerRecord.sessionCommands = sessionCommands;
                connectedControllerRecord.playerCommands = commands;
            }
        }
    }

    public void updateCommandsFromSession(MediaSession.ControllerInfo controllerInfo, SessionCommands sessionCommands, Player.Commands commands) {
        synchronized (this.lock) {
            ConnectedControllerRecord<T> connectedControllerRecord = this.controllerRecords.get(controllerInfo);
            if (connectedControllerRecord != null) {
                connectedControllerRecord.sessionCommands = sessionCommands;
                connectedControllerRecord.playerCommands = commands;
            }
        }
    }

    public Player.Commands getAvailablePlayerCommands(MediaSession.ControllerInfo controllerInfo) {
        synchronized (this.lock) {
            ConnectedControllerRecord<T> connectedControllerRecord = this.controllerRecords.get(controllerInfo);
            if (connectedControllerRecord == null) {
                return null;
            }
            return connectedControllerRecord.playerCommands;
        }
    }

    public void removeController(T t) {
        MediaSession.ControllerInfo controller = getController(t);
        if (controller != null) {
            removeController(controller);
        }
    }

    public void removeController(final MediaSession.ControllerInfo controllerInfo) {
        synchronized (this.lock) {
            ConnectedControllerRecord<T> remove = this.controllerRecords.remove(controllerInfo);
            if (remove == null) {
                return;
            }
            this.controllerInfoMap.remove(remove.controllerKey);
            remove.sequencedFutureManager.release();
            final MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
            if (mediaSessionImpl == null || mediaSessionImpl.isReleased()) {
                return;
            }
            Util.postOrRun(mediaSessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.ConnectedControllersManager$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ConnectedControllersManager.lambda$removeController$0(MediaSessionImpl.this, controllerInfo);
                }
            });
        }
    }

    static /* synthetic */ void lambda$removeController$0(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo) {
        if (mediaSessionImpl.isReleased()) {
            return;
        }
        mediaSessionImpl.onDisconnectedOnHandler(controllerInfo);
    }

    public ImmutableList<MediaSession.ControllerInfo> getConnectedControllers() {
        ImmutableList<MediaSession.ControllerInfo> copyOf;
        synchronized (this.lock) {
            copyOf = ImmutableList.copyOf((Collection) this.controllerInfoMap.values());
        }
        return copyOf;
    }

    public boolean isConnected(MediaSession.ControllerInfo controllerInfo) {
        boolean z;
        synchronized (this.lock) {
            z = this.controllerRecords.get(controllerInfo) != null;
        }
        return z;
    }

    public SequencedFutureManager getSequencedFutureManager(MediaSession.ControllerInfo controllerInfo) {
        ConnectedControllerRecord<T> connectedControllerRecord;
        synchronized (this.lock) {
            connectedControllerRecord = this.controllerRecords.get(controllerInfo);
        }
        if (connectedControllerRecord != null) {
            return connectedControllerRecord.sequencedFutureManager;
        }
        return null;
    }

    public SequencedFutureManager getSequencedFutureManager(T t) {
        ConnectedControllerRecord<T> connectedControllerRecord;
        synchronized (this.lock) {
            MediaSession.ControllerInfo controller = getController(t);
            connectedControllerRecord = controller != null ? this.controllerRecords.get(controller) : null;
        }
        if (connectedControllerRecord != null) {
            return connectedControllerRecord.sequencedFutureManager;
        }
        return null;
    }

    public boolean isSessionCommandAvailable(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand) {
        ConnectedControllerRecord<T> connectedControllerRecord;
        synchronized (this.lock) {
            connectedControllerRecord = this.controllerRecords.get(controllerInfo);
        }
        return connectedControllerRecord != null && connectedControllerRecord.sessionCommands.contains(sessionCommand);
    }

    public boolean isSessionCommandAvailable(MediaSession.ControllerInfo controllerInfo, int i) {
        ConnectedControllerRecord<T> connectedControllerRecord;
        synchronized (this.lock) {
            connectedControllerRecord = this.controllerRecords.get(controllerInfo);
        }
        return connectedControllerRecord != null && connectedControllerRecord.sessionCommands.contains(i);
    }

    public boolean isPlayerCommandAvailable(MediaSession.ControllerInfo controllerInfo, int i) {
        ConnectedControllerRecord<T> connectedControllerRecord;
        synchronized (this.lock) {
            connectedControllerRecord = this.controllerRecords.get(controllerInfo);
        }
        MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
        return connectedControllerRecord != null && connectedControllerRecord.playerCommands.contains(i) && mediaSessionImpl != null && mediaSessionImpl.getPlayerWrapper().getAvailableCommands().contains(i);
    }

    public MediaSession.ControllerInfo getController(T t) {
        MediaSession.ControllerInfo controllerInfo;
        synchronized (this.lock) {
            controllerInfo = this.controllerInfoMap.get(t);
        }
        return controllerInfo;
    }

    public void addToCommandQueue(MediaSession.ControllerInfo controllerInfo, AsyncCommand asyncCommand) {
        synchronized (this.lock) {
            ConnectedControllerRecord<T> connectedControllerRecord = this.controllerRecords.get(controllerInfo);
            if (connectedControllerRecord != null) {
                connectedControllerRecord.commandQueue.add(asyncCommand);
            }
        }
    }

    public void flushCommandQueue(MediaSession.ControllerInfo controllerInfo) {
        synchronized (this.lock) {
            ConnectedControllerRecord<T> connectedControllerRecord = this.controllerRecords.get(controllerInfo);
            if (connectedControllerRecord != null && !connectedControllerRecord.commandQueueIsFlushing && !connectedControllerRecord.commandQueue.isEmpty()) {
                connectedControllerRecord.commandQueueIsFlushing = true;
                flushCommandQueue(connectedControllerRecord);
            }
        }
    }

    private void flushCommandQueue(final ConnectedControllerRecord<T> connectedControllerRecord) {
        MediaSessionImpl mediaSessionImpl = this.sessionImpl.get();
        if (mediaSessionImpl == null) {
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        while (atomicBoolean.get()) {
            atomicBoolean.set(false);
            final AsyncCommand poll = connectedControllerRecord.commandQueue.poll();
            if (poll == null) {
                connectedControllerRecord.commandQueueIsFlushing = false;
                return;
            } else {
                final AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
                Util.postOrRun(mediaSessionImpl.getApplicationHandler(), mediaSessionImpl.callWithControllerForCurrentRequestSet(getController(connectedControllerRecord.controllerKey), new Runnable() { // from class: androidx.media3.session.ConnectedControllersManager$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConnectedControllersManager.this.m619xafd35b05(poll, atomicBoolean2, connectedControllerRecord, atomicBoolean);
                    }
                }));
                atomicBoolean2.set(false);
            }
        }
    }

    /* renamed from: lambda$flushCommandQueue$2$androidx-media3-session-ConnectedControllersManager, reason: not valid java name */
    /* synthetic */ void m619xafd35b05(AsyncCommand asyncCommand, final AtomicBoolean atomicBoolean, final ConnectedControllerRecord connectedControllerRecord, final AtomicBoolean atomicBoolean2) {
        asyncCommand.run().addListener(new Runnable() { // from class: androidx.media3.session.ConnectedControllersManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ConnectedControllersManager.this.m618x2298a984(atomicBoolean, connectedControllerRecord, atomicBoolean2);
            }
        }, MoreExecutors.directExecutor());
    }

    /* renamed from: lambda$flushCommandQueue$1$androidx-media3-session-ConnectedControllersManager, reason: not valid java name */
    /* synthetic */ void m618x2298a984(AtomicBoolean atomicBoolean, ConnectedControllerRecord connectedControllerRecord, AtomicBoolean atomicBoolean2) {
        synchronized (this.lock) {
            if (!atomicBoolean.get()) {
                flushCommandQueue(connectedControllerRecord);
            } else {
                atomicBoolean2.set(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class ConnectedControllerRecord<T> {
        public final Deque<AsyncCommand> commandQueue = new ArrayDeque();
        public boolean commandQueueIsFlushing;
        public final T controllerKey;
        public Player.Commands playerCommands;
        public final SequencedFutureManager sequencedFutureManager;
        public SessionCommands sessionCommands;

        public ConnectedControllerRecord(T t, SequencedFutureManager sequencedFutureManager, SessionCommands sessionCommands, Player.Commands commands) {
            this.controllerKey = t;
            this.sequencedFutureManager = sequencedFutureManager;
            this.sessionCommands = sessionCommands;
            this.playerCommands = commands;
        }
    }
}

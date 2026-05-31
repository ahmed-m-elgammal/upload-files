package com.rnfs;

import android.os.AsyncTask;
import android.os.Build;
import com.rnfs.DownloadParams;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public class Downloader extends AsyncTask<DownloadParams, long[], DownloadResult> {
    private AtomicBoolean mAbort = new AtomicBoolean(false);
    private DownloadParams mParam;
    DownloadResult res;

    protected void onPostExecute(Exception exc) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public DownloadResult doInBackground(DownloadParams... downloadParamsArr) {
        this.mParam = downloadParamsArr[0];
        this.res = new DownloadResult();
        new Thread(new Runnable() { // from class: com.rnfs.Downloader.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Downloader downloader = Downloader.this;
                    downloader.download(downloader.mParam, Downloader.this.res);
                    Downloader.this.mParam.onTaskCompleted.onTaskCompleted(Downloader.this.res);
                } catch (Exception e) {
                    Downloader.this.res.exception = e;
                    Downloader.this.mParam.onTaskCompleted.onTaskCompleted(Downloader.this.res);
                }
            }
        }).start();
        return this.res;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0244  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void download(com.rnfs.DownloadParams r31, com.rnfs.DownloadResult r32) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 584
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnfs.Downloader.download(com.rnfs.DownloadParams, com.rnfs.DownloadResult):void");
    }

    private long getContentLength(HttpURLConnection httpURLConnection) {
        long contentLengthLong;
        if (Build.VERSION.SDK_INT >= 24) {
            contentLengthLong = httpURLConnection.getContentLengthLong();
            return contentLengthLong;
        }
        return httpURLConnection.getContentLength();
    }

    protected void stop() {
        this.mAbort.set(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(long[]... jArr) {
        super.onProgressUpdate((Object[]) jArr);
        if (this.mParam.onDownloadProgress != null) {
            DownloadParams.OnDownloadProgress onDownloadProgress = this.mParam.onDownloadProgress;
            long[] jArr2 = jArr[0];
            onDownloadProgress.onDownloadProgress(jArr2[0], jArr2[1]);
        }
    }
}

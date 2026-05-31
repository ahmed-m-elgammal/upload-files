package org.apache.commons.fileupload;

import java.io.IOException;

/* loaded from: classes7.dex */
public interface FileItemIterator {
    boolean hasNext() throws FileUploadException, IOException;

    FileItemStream next() throws FileUploadException, IOException;
}

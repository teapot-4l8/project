package com.bumptech.glide.c.c;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferEncoder.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.c.d<ByteBuffer> {
    @Override // com.bumptech.glide.c.d
    public boolean a(ByteBuffer byteBuffer, File file, com.bumptech.glide.c.j jVar) {
        try {
            com.bumptech.glide.i.a.a(byteBuffer, file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e2);
            }
            return false;
        }
    }
}

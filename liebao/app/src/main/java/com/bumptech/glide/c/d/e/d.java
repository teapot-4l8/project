package com.bumptech.glide.c.d.e;

import android.util.Log;
import com.bumptech.glide.c.b.u;
import com.bumptech.glide.c.l;
import java.io.File;
import java.io.IOException;

/* compiled from: GifDrawableEncoder.java */
/* loaded from: classes.dex */
public class d implements l<c> {
    @Override // com.bumptech.glide.c.l
    public com.bumptech.glide.c.c a(com.bumptech.glide.c.j jVar) {
        return com.bumptech.glide.c.c.SOURCE;
    }

    @Override // com.bumptech.glide.c.d
    public boolean a(u<c> uVar, File file, com.bumptech.glide.c.j jVar) {
        try {
            com.bumptech.glide.i.a.a(uVar.d().c(), file);
            return true;
        } catch (IOException e2) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e2);
            }
            return false;
        }
    }
}

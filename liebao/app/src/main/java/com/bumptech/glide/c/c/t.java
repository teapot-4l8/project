package com.bumptech.glide.c.c;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamEncoder.java */
/* loaded from: classes.dex */
public class t implements com.bumptech.glide.c.d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final com.bumptech.glide.c.b.a.b f4971a;

    public t(com.bumptech.glide.c.b.a.b bVar) {
        this.f4971a = bVar;
    }

    @Override // com.bumptech.glide.c.d
    public boolean a(InputStream inputStream, File file, com.bumptech.glide.c.j jVar) {
        byte[] bArr = (byte[]) this.f4971a.a(65536, byte[].class);
        boolean z = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } catch (IOException e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            if (Log.isLoggable("StreamEncoder", 3)) {
                                Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            this.f4971a.a((com.bumptech.glide.c.b.a.b) bArr);
                            return z;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            this.f4971a.a((com.bumptech.glide.c.b.a.b) bArr);
                            throw th;
                        }
                    }
                    fileOutputStream2.close();
                    z = true;
                    fileOutputStream2.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e3) {
                e = e3;
            }
        } catch (IOException unused2) {
        }
        this.f4971a.a((com.bumptech.glide.c.b.a.b) bArr);
        return z;
    }
}

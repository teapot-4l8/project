package okhttp3;

import java.io.File;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* compiled from: RequestBody.java */
/* loaded from: classes.dex */
public abstract class ab {
    public abstract void a(c.d dVar);

    @Nullable
    public abstract v b();

    public long c() {
        return -1L;
    }

    public static ab a(@Nullable v vVar, String str) {
        Charset charset = okhttp3.internal.c.f7468e;
        if (vVar != null && (charset = vVar.b()) == null) {
            charset = okhttp3.internal.c.f7468e;
            vVar = v.b(vVar + "; charset=utf-8");
        }
        return a(vVar, str.getBytes(charset));
    }

    public static ab a(@Nullable final v vVar, final c.f fVar) {
        return new ab() { // from class: okhttp3.ab.1
            @Override // okhttp3.ab
            @Nullable
            public v b() {
                return v.this;
            }

            @Override // okhttp3.ab
            public long c() {
                return fVar.h();
            }

            @Override // okhttp3.ab
            public void a(c.d dVar) {
                dVar.b(fVar);
            }
        };
    }

    public static ab a(@Nullable v vVar, byte[] bArr) {
        return a(vVar, bArr, 0, bArr.length);
    }

    public static ab a(@Nullable final v vVar, final byte[] bArr, final int i, final int i2) {
        if (bArr == null) {
            throw new NullPointerException("content == null");
        }
        okhttp3.internal.c.a(bArr.length, i, i2);
        return new ab() { // from class: okhttp3.ab.2
            @Override // okhttp3.ab
            @Nullable
            public v b() {
                return v.this;
            }

            @Override // okhttp3.ab
            public long c() {
                return i2;
            }

            @Override // okhttp3.ab
            public void a(c.d dVar) {
                dVar.c(bArr, i, i2);
            }
        };
    }

    public static ab a(@Nullable final v vVar, final File file) {
        if (file == null) {
            throw new NullPointerException("file == null");
        }
        return new ab() { // from class: okhttp3.ab.3
            @Override // okhttp3.ab
            @Nullable
            public v b() {
                return v.this;
            }

            @Override // okhttp3.ab
            public long c() {
                return file.length();
            }

            @Override // okhttp3.ab
            public void a(c.d dVar) {
                c.s sVar = null;
                try {
                    sVar = c.l.a(file);
                    dVar.a(sVar);
                } finally {
                    okhttp3.internal.c.a(sVar);
                }
            }
        };
    }
}

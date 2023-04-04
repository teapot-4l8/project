package okhttp3.internal.a;

import c.g;
import c.r;
import java.io.IOException;

/* compiled from: FaultHidingSink.java */
/* loaded from: classes2.dex */
class e extends g {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7436a;

    protected void a(IOException iOException) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(r rVar) {
        super(rVar);
    }

    @Override // c.g, c.r
    public void a_(c.c cVar, long j) {
        if (this.f7436a) {
            cVar.i(j);
            return;
        }
        try {
            super.a_(cVar, j);
        } catch (IOException e2) {
            this.f7436a = true;
            a(e2);
        }
    }

    @Override // c.g, c.r, java.io.Flushable
    public void flush() {
        if (this.f7436a) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e2) {
            this.f7436a = true;
            a(e2);
        }
    }

    @Override // c.g, c.r, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f7436a) {
            return;
        }
        try {
            super.close();
        } catch (IOException e2) {
            this.f7436a = true;
            a(e2);
        }
    }
}

package androidx.core.g;

import android.util.Log;
import java.io.Writer;

/* compiled from: LogWriter.java */
@Deprecated
/* loaded from: classes.dex */
public class b extends Writer {

    /* renamed from: a  reason: collision with root package name */
    private final String f1593a;

    /* renamed from: b  reason: collision with root package name */
    private StringBuilder f1594b = new StringBuilder(128);

    public b(String str) {
        this.f1593a = str;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c2 = cArr[i + i3];
            if (c2 == '\n') {
                a();
            } else {
                this.f1594b.append(c2);
            }
        }
    }

    private void a() {
        if (this.f1594b.length() > 0) {
            Log.d(this.f1593a, this.f1594b.toString());
            StringBuilder sb = this.f1594b;
            sb.delete(0, sb.length());
        }
    }
}

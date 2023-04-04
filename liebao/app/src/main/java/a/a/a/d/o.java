package a.a.a.d;

import java.io.PrintStream;

/* compiled from: Compression.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: b  reason: collision with root package name */
    private boolean f327b = bo.b("verbosecompression");

    /* renamed from: a  reason: collision with root package name */
    private a[] f326a = new a[17];

    /* compiled from: Compression.java */
    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        bj f328a;

        /* renamed from: b  reason: collision with root package name */
        int f329b;

        /* renamed from: c  reason: collision with root package name */
        a f330c;

        private a() {
        }
    }

    public void a(int i, bj bjVar) {
        if (i > 16383) {
            return;
        }
        int hashCode = (bjVar.hashCode() & Integer.MAX_VALUE) % 17;
        a aVar = new a();
        aVar.f328a = bjVar;
        aVar.f329b = i;
        aVar.f330c = this.f326a[hashCode];
        this.f326a[hashCode] = aVar;
        if (this.f327b) {
            PrintStream printStream = System.err;
            printStream.println("Adding " + bjVar + " at " + i);
        }
    }

    public int a(bj bjVar) {
        int i = -1;
        for (a aVar = this.f326a[(bjVar.hashCode() & Integer.MAX_VALUE) % 17]; aVar != null; aVar = aVar.f330c) {
            if (aVar.f328a.equals(bjVar)) {
                i = aVar.f329b;
            }
        }
        if (this.f327b) {
            PrintStream printStream = System.err;
            printStream.println("Looking for " + bjVar + ", found " + i);
        }
        return i;
    }
}

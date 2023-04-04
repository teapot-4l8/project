package b.b.e.a;

import b.b.h;

/* compiled from: EmptyDisposable.java */
/* loaded from: classes.dex */
public enum c implements b.b.e.c.a<Object> {
    INSTANCE,
    NEVER;

    @Override // b.b.e.c.b
    public int a(int i) {
        return i & 2;
    }

    @Override // b.b.b.b
    public void a() {
    }

    @Override // b.b.e.c.e
    public boolean c() {
        return true;
    }

    @Override // b.b.e.c.e
    public void d() {
    }

    @Override // b.b.e.c.e
    public Object m_() {
        return null;
    }

    public static void a(h<?> hVar) {
        hVar.a(INSTANCE);
        hVar.b();
    }

    @Override // b.b.e.c.e
    public boolean a(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}

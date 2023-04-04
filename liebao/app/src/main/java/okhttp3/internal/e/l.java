package okhttp3.internal.e;

import java.util.List;

/* compiled from: PushObserver.java */
/* loaded from: classes2.dex */
public interface l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f7629a = new l() { // from class: okhttp3.internal.e.l.1
        @Override // okhttp3.internal.e.l
        public void a(int i, b bVar) {
        }

        @Override // okhttp3.internal.e.l
        public boolean a(int i, List<c> list) {
            return true;
        }

        @Override // okhttp3.internal.e.l
        public boolean a(int i, List<c> list, boolean z) {
            return true;
        }

        @Override // okhttp3.internal.e.l
        public boolean a(int i, c.e eVar, int i2, boolean z) {
            eVar.i(i2);
            return true;
        }
    };

    void a(int i, b bVar);

    boolean a(int i, c.e eVar, int i2, boolean z);

    boolean a(int i, List<c> list);

    boolean a(int i, List<c> list, boolean z);
}

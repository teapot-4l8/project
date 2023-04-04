package b.b.e.h;

/* compiled from: AppendOnlyLinkedArrayList.java */
/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    final int f3481a;

    /* renamed from: b  reason: collision with root package name */
    final Object[] f3482b;

    /* renamed from: c  reason: collision with root package name */
    Object[] f3483c;

    /* renamed from: d  reason: collision with root package name */
    int f3484d;

    /* compiled from: AppendOnlyLinkedArrayList.java */
    /* renamed from: b.b.e.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0074a<T> extends b.b.d.g<T> {
        @Override // b.b.d.g
        boolean a(T t);
    }

    public a(int i) {
        this.f3481a = i;
        Object[] objArr = new Object[i + 1];
        this.f3482b = objArr;
        this.f3483c = objArr;
    }

    public void a(T t) {
        int i = this.f3481a;
        int i2 = this.f3484d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.f3483c[i] = objArr;
            this.f3483c = objArr;
            i2 = 0;
        }
        this.f3483c[i2] = t;
        this.f3484d = i2 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0018, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(InterfaceC0074a<? super T> interfaceC0074a) {
        int i = this.f3481a;
        for (Object[] objArr = this.f3482b; objArr != null; objArr = objArr[i]) {
            for (int i2 = 0; i2 < i; i2++) {
                Object obj = objArr[i2];
                if (obj == null) {
                    break;
                } else if (interfaceC0074a.a(obj)) {
                    return;
                }
            }
        }
    }
}

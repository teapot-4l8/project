package b.b.e.h;

import b.b.h;
import java.io.Serializable;

/* compiled from: NotificationLite.java */
/* loaded from: classes.dex */
public enum e {
    COMPLETE;

    public static <T> Object a(T t) {
        return t;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    /* compiled from: NotificationLite.java */
    /* loaded from: classes.dex */
    static final class a implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        final Throwable f3488a;

        a(Throwable th) {
            this.f3488a = th;
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f3488a + "]";
        }

        public int hashCode() {
            return this.f3488a.hashCode();
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return b.b.e.b.b.a(this.f3488a, ((a) obj).f3488a);
            }
            return false;
        }
    }

    public static Object a() {
        return COMPLETE;
    }

    public static Object a(Throwable th) {
        return new a(th);
    }

    public static <T> boolean a(Object obj, h<? super T> hVar) {
        if (obj == COMPLETE) {
            hVar.b();
            return true;
        } else if (obj instanceof a) {
            hVar.a(((a) obj).f3488a);
            return true;
        } else {
            hVar.a_(obj);
            return false;
        }
    }
}

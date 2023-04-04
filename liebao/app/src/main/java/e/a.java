package e;

import e.c.w;
import e.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.ab;
import okhttp3.ad;

/* compiled from: BuiltInConverters.java */
/* loaded from: classes.dex */
final class a extends f.a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6986a = true;

    @Override // e.f.a
    @Nullable
    public e.f<ad, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (type == ad.class) {
            if (u.a(annotationArr, (Class<? extends Annotation>) w.class)) {
                return c.f7011a;
            }
            return C0177a.f6987a;
        } else if (type == Void.class) {
            return f.f7014a;
        } else {
            if (this.f6986a && type == kotlin.l.class) {
                try {
                    return e.f7013a;
                } catch (NoClassDefFoundError unused) {
                    this.f6986a = false;
                    return null;
                }
            }
            return null;
        }
    }

    @Override // e.f.a
    @Nullable
    public e.f<?, ab> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        if (ab.class.isAssignableFrom(u.a(type))) {
            return b.f7010a;
        }
        return null;
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes2.dex */
    static final class f implements e.f<ad, Void> {

        /* renamed from: a  reason: collision with root package name */
        static final f f7014a = new f();

        f() {
        }

        @Override // e.f
        public Void a(ad adVar) {
            adVar.close();
            return null;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes2.dex */
    static final class e implements e.f<ad, kotlin.l> {

        /* renamed from: a  reason: collision with root package name */
        static final e f7013a = new e();

        e() {
        }

        @Override // e.f
        public kotlin.l a(ad adVar) {
            adVar.close();
            return kotlin.l.f7210a;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes2.dex */
    static final class b implements e.f<ab, ab> {

        /* renamed from: a  reason: collision with root package name */
        static final b f7010a = new b();

        @Override // e.f
        public ab a(ab abVar) {
            return abVar;
        }

        b() {
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes2.dex */
    static final class c implements e.f<ad, ad> {

        /* renamed from: a  reason: collision with root package name */
        static final c f7011a = new c();

        @Override // e.f
        public ad a(ad adVar) {
            return adVar;
        }

        c() {
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0177a implements e.f<ad, ad> {

        /* renamed from: a  reason: collision with root package name */
        static final C0177a f6987a = new C0177a();

        C0177a() {
        }

        @Override // e.f
        public ad a(ad adVar) {
            try {
                return u.a(adVar);
            } finally {
                adVar.close();
            }
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* loaded from: classes2.dex */
    static final class d implements e.f<Object, String> {

        /* renamed from: a  reason: collision with root package name */
        static final d f7012a = new d();

        d() {
        }

        @Override // e.f
        /* renamed from: b */
        public String a(Object obj) {
            return obj.toString();
        }
    }
}

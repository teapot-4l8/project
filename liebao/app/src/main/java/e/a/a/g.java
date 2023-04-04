package e.a.a;

import b.b.i;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* compiled from: RxJava2CallAdapter.java */
/* loaded from: classes.dex */
final class g<R> implements e.c<R, Object> {

    /* renamed from: a  reason: collision with root package name */
    private final Type f7003a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final i f7004b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7005c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f7006d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f7007e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Type type, @Nullable i iVar, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.f7003a = type;
        this.f7004b = iVar;
        this.f7005c = z;
        this.f7006d = z2;
        this.f7007e = z3;
        this.f = z4;
        this.g = z5;
        this.h = z6;
        this.i = z7;
    }

    @Override // e.c
    public Type a() {
        return this.f7003a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    @Override // e.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(e.b<R> bVar) {
        b.b.e cVar;
        b.b.e aVar;
        i iVar;
        if (this.f7005c) {
            cVar = new b(bVar);
        } else {
            cVar = new c(bVar);
        }
        if (this.f7006d) {
            aVar = new f(cVar);
        } else {
            if (this.f7007e) {
                aVar = new a(cVar);
            }
            iVar = this.f7004b;
            if (iVar != null) {
                cVar = cVar.b(iVar);
            }
            if (!this.f) {
                return cVar.a(b.b.a.LATEST);
            }
            if (this.g) {
                return cVar.h();
            }
            if (this.h) {
                return cVar.g();
            }
            if (this.i) {
                return cVar.d();
            }
            return b.b.g.a.a(cVar);
        }
        cVar = aVar;
        iVar = this.f7004b;
        if (iVar != null) {
        }
        if (!this.f) {
        }
    }
}

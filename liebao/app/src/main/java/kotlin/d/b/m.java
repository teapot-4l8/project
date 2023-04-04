package kotlin.d.b;

import kotlin.reflect.KDeclarationContainer;

/* compiled from: PropertyReference1Impl.java */
/* loaded from: classes2.dex */
public class m extends l {

    /* renamed from: c  reason: collision with root package name */
    private final KDeclarationContainer f7158c;

    /* renamed from: d  reason: collision with root package name */
    private final String f7159d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7160e;

    public m(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        this.f7158c = kDeclarationContainer;
        this.f7159d = str;
        this.f7160e = str2;
    }

    @Override // kotlin.d.b.c
    public KDeclarationContainer e() {
        return this.f7158c;
    }

    @Override // kotlin.d.b.c, kotlin.reflect.KCallable
    public String getName() {
        return this.f7159d;
    }

    @Override // kotlin.d.b.c
    public String f() {
        return this.f7160e;
    }

    @Override // kotlin.reflect.KProperty1
    public Object get(Object obj) {
        return getGetter().call(obj);
    }
}

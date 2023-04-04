package kotlin.d.b;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty1;

/* compiled from: PropertyReference1.java */
/* loaded from: classes2.dex */
public abstract class l extends k implements KProperty1 {
    @Override // kotlin.d.b.c
    protected KCallable a() {
        return o.a(this);
    }

    @Override // kotlin.d.a.b
    public Object a(Object obj) {
        return get(obj);
    }

    @Override // kotlin.reflect.KProperty, kotlin.reflect.KProperty1
    public KProperty1.Getter getGetter() {
        return ((KProperty1) d()).getGetter();
    }

    @Override // kotlin.reflect.KProperty1
    public Object getDelegate(Object obj) {
        return ((KProperty1) d()).getDelegate(obj);
    }
}

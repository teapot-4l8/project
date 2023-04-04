package kotlin.reflect;

import kotlin.d.a.b;
import kotlin.l;
import kotlin.reflect.KMutableProperty;

/* compiled from: KProperty.kt */
/* loaded from: classes2.dex */
public interface KMutableProperty0<R> extends KMutableProperty<R>, KProperty0<R> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes2.dex */
    public interface Setter<R> extends b<R, l>, KMutableProperty.Setter<R> {
    }

    @Override // kotlin.reflect.KMutableProperty
    Setter<R> getSetter();

    void set(R r);
}

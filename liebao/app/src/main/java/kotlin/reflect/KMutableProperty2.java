package kotlin.reflect;

import kotlin.reflect.KMutableProperty;

/* compiled from: KProperty.kt */
/* loaded from: classes2.dex */
public interface KMutableProperty2<D, E, R> extends KMutableProperty<R>, KProperty2<D, E, R> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes2.dex */
    public interface Setter<D, E, R> extends KMutableProperty.Setter<R> {
    }

    @Override // kotlin.reflect.KMutableProperty
    Setter<D, E, R> getSetter();

    void set(D d2, E e2, R r);
}

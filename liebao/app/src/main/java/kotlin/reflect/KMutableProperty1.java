package kotlin.reflect;

import kotlin.d.a.c;
import kotlin.l;
import kotlin.reflect.KMutableProperty;

/* compiled from: KProperty.kt */
/* loaded from: classes2.dex */
public interface KMutableProperty1<T, R> extends KMutableProperty<R>, KProperty1<T, R> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes2.dex */
    public interface Setter<T, R> extends c<T, R, l>, KMutableProperty.Setter<R> {
    }

    @Override // kotlin.reflect.KMutableProperty
    Setter<T, R> getSetter();

    void set(T t, R r);
}

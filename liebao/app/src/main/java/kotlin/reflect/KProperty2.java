package kotlin.reflect;

import kotlin.d.a.c;
import kotlin.reflect.KProperty;

/* compiled from: KProperty.kt */
/* loaded from: classes2.dex */
public interface KProperty2<D, E, R> extends c<D, E, R>, KProperty<R> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes2.dex */
    public interface Getter<D, E, R> extends c<D, E, R>, KProperty.Getter<R> {
    }

    R get(D d2, E e2);

    Object getDelegate(D d2, E e2);

    @Override // kotlin.reflect.KProperty, kotlin.reflect.KProperty1
    Getter<D, E, R> getGetter();
}

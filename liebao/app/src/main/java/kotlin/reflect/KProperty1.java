package kotlin.reflect;

import kotlin.d.a.b;
import kotlin.reflect.KProperty;

/* compiled from: KProperty.kt */
/* loaded from: classes2.dex */
public interface KProperty1<T, R> extends b<T, R>, KProperty<R> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes2.dex */
    public interface Getter<T, R> extends b<T, R>, KProperty.Getter<R> {
    }

    R get(T t);

    Object getDelegate(T t);

    Getter<T, R> getGetter();
}

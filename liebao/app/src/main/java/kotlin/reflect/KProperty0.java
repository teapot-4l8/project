package kotlin.reflect;

import kotlin.d.a.a;
import kotlin.reflect.KProperty;

/* compiled from: KProperty.kt */
/* loaded from: classes2.dex */
public interface KProperty0<R> extends a<R>, KProperty<R> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes2.dex */
    public interface Getter<R> extends a<R>, KProperty.Getter<R> {
    }

    R get();

    Object getDelegate();

    @Override // kotlin.reflect.KProperty, kotlin.reflect.KProperty1
    Getter<R> getGetter();
}

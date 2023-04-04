package kotlin.reflect;

import kotlin.l;
import kotlin.reflect.KProperty;

/* compiled from: KProperty.kt */
/* loaded from: classes2.dex */
public interface KMutableProperty<R> extends KProperty<R> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes2.dex */
    public interface Setter<R> extends KFunction<l>, KProperty.Accessor<R> {
    }

    Setter<R> getSetter();
}

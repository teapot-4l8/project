package kotlin.reflect;

/* compiled from: KProperty.kt */
/* loaded from: classes2.dex */
public interface KProperty<R> extends KCallable<R> {

    /* compiled from: KProperty.kt */
    /* loaded from: classes2.dex */
    public interface Accessor<R> {
        KProperty<R> getProperty();
    }

    /* compiled from: KProperty.kt */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void isConst$annotations() {
        }

        public static /* synthetic */ void isLateinit$annotations() {
        }
    }

    /* compiled from: KProperty.kt */
    /* loaded from: classes2.dex */
    public interface Getter<R> extends KFunction<R>, Accessor<R> {
    }

    Getter<R> getGetter();

    boolean isConst();

    boolean isLateinit();
}

package kotlin.reflect;

/* compiled from: KParameter.kt */
/* loaded from: classes2.dex */
public interface KParameter extends KAnnotatedElement {

    /* compiled from: KParameter.kt */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void isVararg$annotations() {
        }
    }

    /* compiled from: KParameter.kt */
    /* loaded from: classes2.dex */
    public enum Kind {
        INSTANCE,
        EXTENSION_RECEIVER,
        VALUE
    }

    int getIndex();

    Kind getKind();

    String getName();

    KType getType();

    boolean isOptional();

    boolean isVararg();
}

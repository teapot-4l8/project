package kotlin.reflect;

import java.util.List;

/* compiled from: KType.kt */
/* loaded from: classes2.dex */
public interface KType extends KAnnotatedElement {

    /* compiled from: KType.kt */
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void arguments$annotations() {
        }

        public static /* synthetic */ void classifier$annotations() {
        }
    }

    List<KTypeProjection> getArguments();

    KClassifier getClassifier();

    boolean isMarkedNullable();
}

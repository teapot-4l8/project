package kotlin.reflect;

import java.util.List;

/* compiled from: KTypeParameter.kt */
/* loaded from: classes2.dex */
public interface KTypeParameter extends KClassifier {
    String getName();

    List<KType> getUpperBounds();

    KVariance getVariance();

    boolean isReified();
}

package kotlin.reflect;

import com.umeng.analytics.pro.d;
import kotlin.d.b.g;
import kotlin.d.b.i;

/* compiled from: KType.kt */
/* loaded from: classes2.dex */
public final class KTypeProjection {
    public static final Companion Companion = new Companion(null);
    private static final KTypeProjection STAR = new KTypeProjection(null, null);
    private final KType type;
    private final KVariance variance;

    public static /* synthetic */ KTypeProjection copy$default(KTypeProjection kTypeProjection, KVariance kVariance, KType kType, int i, Object obj) {
        if ((i & 1) != 0) {
            kVariance = kTypeProjection.variance;
        }
        if ((i & 2) != 0) {
            kType = kTypeProjection.type;
        }
        return kTypeProjection.copy(kVariance, kType);
    }

    public final KVariance component1() {
        return this.variance;
    }

    public final KType component2() {
        return this.type;
    }

    public final KTypeProjection copy(KVariance kVariance, KType kType) {
        return new KTypeProjection(kVariance, kType);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof KTypeProjection) {
                KTypeProjection kTypeProjection = (KTypeProjection) obj;
                return i.a(this.variance, kTypeProjection.variance) && i.a(this.type, kTypeProjection.type);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        KVariance kVariance = this.variance;
        int hashCode = (kVariance != null ? kVariance.hashCode() : 0) * 31;
        KType kType = this.type;
        return hashCode + (kType != null ? kType.hashCode() : 0);
    }

    public String toString() {
        return "KTypeProjection(variance=" + this.variance + ", type=" + this.type + ")";
    }

    public KTypeProjection(KVariance kVariance, KType kType) {
        this.variance = kVariance;
        this.type = kType;
    }

    public final KVariance getVariance() {
        return this.variance;
    }

    public final KType getType() {
        return this.type;
    }

    /* compiled from: KType.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final KTypeProjection getSTAR() {
            return KTypeProjection.STAR;
        }

        public final KTypeProjection invariant(KType kType) {
            i.b(kType, d.y);
            return new KTypeProjection(KVariance.INVARIANT, kType);
        }

        public final KTypeProjection contravariant(KType kType) {
            i.b(kType, d.y);
            return new KTypeProjection(KVariance.IN, kType);
        }

        public final KTypeProjection covariant(KType kType) {
            i.b(kType, d.y);
            return new KTypeProjection(KVariance.OUT, kType);
        }
    }
}

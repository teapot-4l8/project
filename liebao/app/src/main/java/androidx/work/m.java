package androidx.work;

import java.util.Set;
import java.util.UUID;

/* compiled from: WorkInfo.java */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private UUID f3070a;

    /* renamed from: b  reason: collision with root package name */
    private a f3071b;

    /* renamed from: c  reason: collision with root package name */
    private e f3072c;

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f3073d;

    /* renamed from: e  reason: collision with root package name */
    private int f3074e;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        if (this.f3074e == mVar.f3074e && this.f3070a.equals(mVar.f3070a) && this.f3071b == mVar.f3071b && this.f3072c.equals(mVar.f3072c)) {
            return this.f3073d.equals(mVar.f3073d);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f3070a.hashCode() * 31) + this.f3071b.hashCode()) * 31) + this.f3072c.hashCode()) * 31) + this.f3073d.hashCode()) * 31) + this.f3074e;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f3070a + "', mState=" + this.f3071b + ", mOutputData=" + this.f3072c + ", mTags=" + this.f3073d + '}';
    }

    /* compiled from: WorkInfo.java */
    /* loaded from: classes.dex */
    public enum a {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean a() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }
}

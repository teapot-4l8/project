package cn.jpush.android.f;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f4325a;

    /* renamed from: b  reason: collision with root package name */
    public long f4326b;

    public b(String str, long j) {
        this.f4325a = str;
        this.f4326b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f4326b == bVar.f4326b && C$r8$backportedMethods$utility$Objects$2$equals.equals(this.f4325a, bVar.f4325a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4325a, Long.valueOf(this.f4326b)});
    }
}

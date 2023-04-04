package cn.jiguang.ah;

import android.content.Intent;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f3701a;

    /* renamed from: b  reason: collision with root package name */
    public String f3702b;

    /* renamed from: c  reason: collision with root package name */
    public int f3703c;

    /* renamed from: d  reason: collision with root package name */
    public String f3704d;

    /* renamed from: e  reason: collision with root package name */
    public Intent f3705e;
    public int f;

    public b() {
    }

    public b(String str, String str2, int i) {
        this.f3701a = str;
        this.f3702b = str2;
        this.f3703c = i;
    }

    public final String toString() {
        return "JWakeTargetInfo{packageName='" + this.f3701a + "', serviceName='" + this.f3702b + "', targetVersion=" + this.f3703c + ", providerAuthority='" + this.f3704d + "', dActivityIntent=" + this.f3705e + ", cmd=" + this.f + '}';
    }
}

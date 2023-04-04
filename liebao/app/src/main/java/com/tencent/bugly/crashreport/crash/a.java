package com.tencent.bugly.crashreport.crash;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class a implements Comparable<a> {

    /* renamed from: a  reason: collision with root package name */
    public long f6041a = -1;

    /* renamed from: b  reason: collision with root package name */
    public long f6042b = -1;

    /* renamed from: c  reason: collision with root package name */
    public String f6043c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f6044d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6045e = false;
    public int f = 0;

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
        a aVar2 = aVar;
        if (aVar2 != null) {
            long j = this.f6042b - aVar2.f6042b;
            if (j <= 0) {
                return j < 0 ? -1 : 0;
            }
            return 1;
        }
        return 1;
    }
}

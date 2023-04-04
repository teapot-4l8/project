package cn.jiguang.ah;

import cn.jiguang.internal.JConstants;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f3696a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f3697b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f3698c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f3699d = true;

    /* renamed from: e  reason: collision with root package name */
    public long f3700e = JConstants.HOUR;
    public long f = JConstants.HOUR;
    public long g = JConstants.HOUR;
    public String h = "disable";
    public List<String> i;
    public List<String> j;

    public final String toString() {
        return "JWakeConfigInfo{wakeEnableByAppKey=" + this.f3696a + ", beWakeEnableByAppKey=" + this.f3697b + ", wakeEnableByUId=" + this.f3698c + ", beWakeEnableByUId=" + this.f3699d + ", wakeInterval=" + this.f3700e + ", wakeConfigInterval=" + this.f + ", wakeReportInterval=" + this.g + ", config='" + this.h + "', pkgList=" + this.i + ", blackPackageList=" + this.j + '}';
    }
}

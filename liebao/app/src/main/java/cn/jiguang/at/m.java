package cn.jiguang.at;

import cn.jiguang.api.ReportCallBack;
import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    int f3957a;

    /* renamed from: b  reason: collision with root package name */
    JSONObject f3958b;

    /* renamed from: c  reason: collision with root package name */
    byte[] f3959c;

    /* renamed from: d  reason: collision with root package name */
    File f3960d;

    /* renamed from: e  reason: collision with root package name */
    Set<String> f3961e;
    int f = -1;
    cn.jiguang.ar.h g;
    LinkedHashSet<cn.jiguang.ar.h> h;
    boolean i;
    transient ReportCallBack j;

    public final String toString() {
        return "TcpReportData{types=" + this.f3961e + ", seqId=" + this.f + ", ipPort=" + this.g + ", restUrls=" + this.h + '}';
    }
}

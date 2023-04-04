package com.speed.speed_library.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.speed.speed_library.R;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;

/* compiled from: SpeedSDKConfig.kt */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f5619a = new i();

    /* renamed from: b  reason: collision with root package name */
    private static String f5620b;

    /* renamed from: c  reason: collision with root package name */
    private static String f5621c;

    /* renamed from: d  reason: collision with root package name */
    private static Bitmap f5622d;

    static {
        String string = g.f5610b.a().getResources().getString(R.string.domain_api_default);
        kotlin.d.b.i.a((Object) string, "Global.context.resources…tring.domain_api_default)");
        f5620b = string;
        String string2 = g.f5610b.a().getResources().getString(R.string.domain_web_default);
        kotlin.d.b.i.a((Object) string2, "Global.context.resources…tring.domain_web_default)");
        f5621c = string2;
    }

    private i() {
    }

    public final String a() {
        return f5620b;
    }

    public final String b() {
        return f5621c;
    }

    public final Bitmap c() {
        return f5622d;
    }

    public final String d() {
        if (kotlin.d.b.i.a((Object) g.f5610b.Q(), (Object) "")) {
            String string = g.f5610b.a().getResources().getString(R.string.domain_qt);
            kotlin.d.b.i.a((Object) string, "Global.context.resources…tring(R.string.domain_qt)");
            return string;
        }
        return g.f5610b.Q();
    }

    public final void a(String str) {
        kotlin.d.b.i.b(str, "umengkey");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        UMConfigure.init(g.f5610b.a(), str, g.f5610b.b(), 1, "");
    }

    public final void b(String str) {
        kotlin.d.b.i.b(str, "buglyId");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        CrashReport.initCrashReport(g.f5610b.a(), str, true, new CrashReport.UserStrategy(g.f5610b.a()));
    }
}

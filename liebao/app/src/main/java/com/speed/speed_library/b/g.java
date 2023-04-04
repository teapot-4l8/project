package com.speed.speed_library.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import com.orhanobut.hawk.Hawk;
import com.speed.speed_library.R;
import com.speed.speed_library.model.BootStrapModel;
import com.speed.speed_library.model.CommonPoint;
import com.speed.speed_library.model.ConfigModel;
import com.speed.speed_library.model.DomainModel;
import com.speed.speed_library.model.Marquee;
import com.speed.speed_library.model.PointModel;
import com.speed.speed_library.model.Route;
import com.speed.speed_library.model.RouteInfoModel;
import com.speed.speed_library.model.RouteModel;
import com.speed.speed_library.model.UserModel;
import java.util.ArrayList;
import java.util.Iterator;
import wg.Wg;

/* compiled from: Global.kt */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a */
    public static Context f5609a;
    private static DomainModel f;
    private static UserModel g;
    private static int h;
    private static int i;
    private static int k;
    private static Marquee m;
    private static int n;

    /* renamed from: b */
    public static final g f5610b = new g();

    /* renamed from: c */
    private static String f5611c = "official";

    /* renamed from: d */
    private static String f5612d = "";

    /* renamed from: e */
    private static String f5613e = "";
    private static String j = "";
    private static String l = "";

    private g() {
    }

    public final Context a() {
        Context context = f5609a;
        if (context == null) {
            kotlin.d.b.i.b(com.umeng.analytics.pro.d.R);
        }
        return context;
    }

    public final void a(Context context) {
        kotlin.d.b.i.b(context, "<set-?>");
        f5609a = context;
    }

    public final void a(String str) {
        kotlin.d.b.i.b(str, "<set-?>");
        f5611c = str;
    }

    public final String b() {
        return f5611c;
    }

    public final void b(String str) {
        kotlin.d.b.i.b(str, "<set-?>");
        f5612d = str;
    }

    public final String c() {
        return f5612d;
    }

    public final void c(String str) {
        kotlin.d.b.i.b(str, "<set-?>");
        f5613e = str;
    }

    public final void a(int i2) {
        h = i2;
    }

    public final int d() {
        return h;
    }

    public final void b(int i2) {
        i = i2;
    }

    public final int e() {
        return i;
    }

    public final void c(int i2) {
        k = i2;
    }

    public final int f() {
        return k;
    }

    public final void d(String str) {
        kotlin.d.b.i.b(str, "<set-?>");
        l = str;
    }

    public final String g() {
        return l;
    }

    public final void a(Marquee marquee) {
        m = marquee;
    }

    public final Marquee h() {
        return m;
    }

    public final void d(int i2) {
        n = i2;
    }

    public final int i() {
        return n;
    }

    public final UserModel j() {
        return (UserModel) Hawk.get(d.f5595a.q(), null);
    }

    public final void a(UserModel userModel) {
        g = userModel;
        Hawk.put(d.f5595a.q(), g);
        e((userModel == null || (r3 = userModel.getPhone()) == null) ? "" : "");
    }

    public final void k() {
        g = null;
        Hawk.delete(d.f5595a.q());
    }

    public final void a(DomainModel domainModel) {
        kotlin.d.b.i.b(domainModel, "domain");
        f = domainModel;
        Hawk.put(d.f5595a.r(), f);
    }

    public final DomainModel l() {
        return (DomainModel) Hawk.get(d.f5595a.r(), null);
    }

    public final void m() {
        Hawk.delete(d.f5595a.r());
    }

    public final BootStrapModel n() {
        return (BootStrapModel) Hawk.get(d.f5595a.d(), null);
    }

    public final void a(BootStrapModel bootStrapModel) {
        kotlin.d.b.i.b(bootStrapModel, "startpage");
        Hawk.put(d.f5595a.d(), bootStrapModel);
    }

    public final void o() {
        Hawk.delete(d.f5595a.d());
    }

    public final void a(RouteModel routeModel) {
        Hawk.put(d.f5595a.z(), routeModel);
    }

    public final RouteModel p() {
        try {
            return (RouteModel) Hawk.get(d.f5595a.z(), null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void q() {
        Hawk.delete(d.f5595a.z());
    }

    public final void a(Route route) {
        Hawk.put(d.f5595a.A(), route);
    }

    public final Route r() {
        try {
            return (Route) Hawk.get(d.f5595a.A(), null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final void s() {
        Hawk.delete(d.f5595a.A());
    }

    public final void a(int i2, RouteInfoModel routeInfoModel) {
        Hawk.put(String.valueOf(i2), routeInfoModel);
    }

    public final RouteInfoModel e(int i2) {
        return (RouteInfoModel) Hawk.get(String.valueOf(i2), null);
    }

    public final void a(ConfigModel configModel) {
        Hawk.put(d.f5595a.s(), configModel);
    }

    // 不要让它返回空值
    public final ConfigModel t() {
        return (ConfigModel) Hawk.get(d.f5595a.s(), null); // 当d.f5595a.s()为空的时候 设置默认值为null
    }

    public final void f(int i2) {
        Hawk.put(d.f5595a.u(), Integer.valueOf(i2));
    }

    public final int u() {
        Object obj = Hawk.get(d.f5595a.u(), 0);
        kotlin.d.b.i.a(obj, "Hawk.get(HAWK_KEY_FEEDBACK_ID, 0)");
        return ((Number) obj).intValue();
    }

    public final void g(int i2) {
        Hawk.put(d.f5595a.v(), Integer.valueOf(i2));
    }

    public final int v() {
        Object obj = Hawk.get(d.f5595a.v(), 0);
        kotlin.d.b.i.a(obj, "Hawk.get(HAWK_KEY_NOTICE_ID, 0)");
        return ((Number) obj).intValue();
    }

    public final void h(int i2) {
        Hawk.put(d.f5595a.w(), Integer.valueOf(i2));
    }

    public final int w() {
        Object obj = Hawk.get(d.f5595a.w(), -1);
        kotlin.d.b.i.a(obj, "Hawk.get(HAWK_KEY_SHARE_ID, -1)");
        return ((Number) obj).intValue();
    }

    public final void i(int i2) {
        Hawk.put(d.f5595a.B(), Integer.valueOf(i2));
    }

    public final int x() {
        Object obj = Hawk.get(d.f5595a.B(), 3);
        kotlin.d.b.i.a(obj, "Hawk.get(HAWK_KEY_SMART_ROUTE, 3)");
        return ((Number) obj).intValue();
    }

    public final void j(int i2) {
        Hawk.put(d.f5595a.C(), Integer.valueOf(i2));
    }

    public final int y() {
        Object obj = Hawk.get(d.f5595a.C(), 0);
        kotlin.d.b.i.a(obj, "Hawk.get(HAWK_KEY_MANUAL_SMART_ROUTE, 0)");
        return ((Number) obj).intValue();
    }

    public final void e(String str) {
        kotlin.d.b.i.b(str, "account");
        Hawk.put(d.f5595a.D(), str);
    }

    public final void k(int i2) {
        Hawk.put(d.f5595a.x(), Integer.valueOf(((int) (System.currentTimeMillis() / 1000)) + (i2 * 3600)));
    }

    public final boolean z() {
        if (((Number) Hawk.get(d.f5595a.x(), 0)).longValue() > System.currentTimeMillis() / 1000) {
            return true;
        }
        Hawk.delete(d.f5595a.x());
        return false;
    }

    public final void l(int i2) {
        Hawk.put(d.f5595a.y(), Integer.valueOf(((int) (System.currentTimeMillis() / 1000)) + (i2 * 3600)));
    }

    public final boolean A() {
        if (((Number) Hawk.get(d.f5595a.y(), 0)).longValue() > System.currentTimeMillis() / 1000) {
            return true;
        }
        Hawk.delete(d.f5595a.y());
        return false;
    }

    public final String B() {
        if (TextUtils.isEmpty((CharSequence) Hawk.get(d.f5595a.E(), ""))) {
            String priAndPubKey = Wg.getPriAndPubKey();
            kotlin.d.b.i.a((Object) priAndPubKey, "keys");
            f(priAndPubKey);
        }
        Object obj = Hawk.get(d.f5595a.E(), "");
        kotlin.d.b.i.a(obj, "Hawk.get(HAWK_KEY_OWN_KEYS, \"\")");
        return (String) obj;
    }

    public final void f(String str) {
        kotlin.d.b.i.b(str, "keys");
        Hawk.put(d.f5595a.E(), str);
    }

    public final void m(int i2) {
        Hawk.put(d.f5595a.o(), Integer.valueOf(i2));
    }

    public final int C() {
        Object obj = Hawk.get(d.f5595a.o(), 0);
        kotlin.d.b.i.a(obj, "Hawk.get(HAWK_KEY_APP_DISCONNECTBT_SWITCH, 0)");
        return ((Number) obj).intValue();
    }

    public final void n(int i2) {
        Hawk.put(d.f5595a.p(), Integer.valueOf(i2));
    }

    public final int D() {
        ConfigModel t;
        if (f5610b.t() == null || (t = f5610b.t()) == null || t.is_show_use_music_backguard() != 0) {
            Object obj = Hawk.get(d.f5595a.p(), 0);
            kotlin.d.b.i.a(obj, "Hawk.get(HAWK_KEY_APP_USE_MUSIC, 0)");
            return ((Number) obj).intValue();
        }
        return 0;
    }

    public final void a(long j2) {
        Hawk.put(d.f5595a.t(), Long.valueOf(j2));
    }

    public final long E() {
        Object obj = Hawk.get(d.f5595a.t(), 0L);
        kotlin.d.b.i.a(obj, "Hawk.get(HAWK_KEY_CONNECT_TIME, 0)");
        return ((Number) obj).longValue();
    }

    public final void F() {
        Hawk.delete(d.f5595a.t());
    }

    public final String G() {
        Context context = f5609a;
        if (context == null) {
            kotlin.d.b.i.b(com.umeng.analytics.pro.d.R);
        }
        String registrationID = JPushInterface.getRegistrationID(context);
        return registrationID != null ? registrationID : "";
    }

    public final void g(String str) {
        kotlin.d.b.i.b(str, "model");
        Hawk.put(d.f5595a.F(), str);
    }

    public final String H() {
        Context context = f5609a;
        if (context == null) {
            kotlin.d.b.i.b(com.umeng.analytics.pro.d.R);
        }
        if (context.getResources().getString(R.string.config_have_china_model).equals("1")) {
            Object obj = Hawk.get(d.f5595a.F(), "");
            kotlin.d.b.i.a(obj, "Hawk.get(HAWK_KEY_SCENE_MODEL, \"\")");
            return (String) obj;
        }
        return "";
    }

    public final void a(String str, ArrayList<Integer> arrayList) {
        kotlin.d.b.i.b(str, "yearAndMoth");
        kotlin.d.b.i.b(arrayList, "list");
        Hawk.put(str, arrayList);
    }

    public final ArrayList<Integer> h(String str) {
        kotlin.d.b.i.b(str, "yearAndMoth");
        return (ArrayList) Hawk.get(str, null);
    }

    public final void a(PointModel pointModel) {
        kotlin.d.b.i.b(pointModel, "pointModel");
        Hawk.put(d.f5595a.G(), pointModel);
    }

    public final PointModel I() {
        return (PointModel) Hawk.get(d.f5595a.G(), null);
    }

    public final void J() {
        Hawk.delete(d.f5595a.G());
    }

    public final void b(PointModel pointModel) {
        kotlin.d.b.i.b(pointModel, "pointModel");
        Hawk.put(d.f5595a.H(), pointModel);
    }

    public final PointModel K() {
        return (PointModel) Hawk.get(d.f5595a.H(), null);
    }

    public final void L() {
        Hawk.delete(d.f5595a.H());
    }

    public final void a(ArrayList<CommonPoint> arrayList) {
        kotlin.d.b.i.b(arrayList, "listData");
        Hawk.put(d.f5595a.I(), arrayList);
    }

    public final ArrayList<CommonPoint> M() {
        return (ArrayList) Hawk.get(d.f5595a.I(), null);
    }

    public final void N() {
        Hawk.delete(d.f5595a.I());
    }

    public final void c(PointModel pointModel) {
        kotlin.d.b.i.b(pointModel, "pointModel");
        Hawk.put(d.f5595a.J(), pointModel);
    }

    public final PointModel O() {
        return (PointModel) Hawk.get(d.f5595a.J(), null);
    }

    public final void P() {
        Hawk.delete(d.f5595a.J());
    }

    public final void i(String str) {
        kotlin.d.b.i.b(str, "qt");
        Hawk.put(d.f5595a.L(), str);
    }

    public final String Q() {
        Object obj = Hawk.get(d.f5595a.L(), "");
        kotlin.d.b.i.a(obj, "Hawk.get(HAWK_KEY_DEFAULT_QT, \"\")");
        return (String) obj;
    }

    public final void R() {
        Hawk.delete(d.f5595a.L());
    }

    public final void j(String str) {
        kotlin.d.b.i.b(str, "domain");
        Hawk.put(d.f5595a.M(), str);
    }

    public final String S() {
        Object obj = Hawk.get(d.f5595a.M(), "");
        kotlin.d.b.i.a(obj, "Hawk.get(HAWK_KEY_DEFAULT_DOMAIN, \"\")");
        return (String) obj;
    }

    public final void T() {
        Hawk.delete(d.f5595a.M());
    }

    public final void o(int i2) {
        Hawk.put(d.f5595a.N(), Integer.valueOf(i2));
    }

    public final int U() {
        Object obj = Hawk.get(d.f5595a.N(), 0);
        kotlin.d.b.i.a(obj, "Hawk.get(HAWK_KEY_APP_AGENT_SWITCH, 0)");
        return ((Number) obj).intValue();
    }

    public final void b(ArrayList<String> arrayList) {
        kotlin.d.b.i.b(arrayList, "model");
        Hawk.put(d.f5595a.K(), arrayList);
    }

    public final ArrayList<String> V() {
        try {
            return (ArrayList) Hawk.get(d.f5595a.K(), null);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final ArrayList<String> W() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (f5610b.V() != null) {
            ArrayList<String> V = f5610b.V();
            if (V == null) {
                V = new ArrayList<>();
            }
            c cVar = c.f5594a;
            Context context = f5609a;
            if (context == null) {
                kotlin.d.b.i.b(com.umeng.analytics.pro.d.R);
            }
            for (PackageInfo packageInfo : cVar.a(context)) {
                arrayList.add(packageInfo.packageName);
            }
            Iterator<String> it = V.iterator();
            while (it.hasNext()) {
                arrayList.remove(it.next());
            }
            return arrayList;
        }
        c cVar2 = c.f5594a;
        Context context2 = f5609a;
        if (context2 == null) {
            kotlin.d.b.i.b(com.umeng.analytics.pro.d.R);
        }
        for (PackageInfo packageInfo2 : cVar2.a(context2)) {
            arrayList.add(packageInfo2.packageName);
        }
        return arrayList;
    }

    public final void X() {
        Hawk.put(d.f5595a.O(), 1);
    }

    public final int Y() {
        Object obj = Hawk.get(d.f5595a.O(), 0);
        kotlin.d.b.i.a(obj, "Hawk.get(\n            HA…,\n            0\n        )");
        return ((Number) obj).intValue();
    }

    public final String Z() {
        Object obj = Hawk.get("keyapi", "CWAFRE"); // Hawk 是一个简单的 key-value 数据库
        kotlin.d.b.i.a(obj, "Hawk.get(\"keyapi\", \"CWAFRE\")");
        return (String) obj;
    }

    public final String aa() {
        Object obj = Hawk.get("keydata", "pTzYn");
        kotlin.d.b.i.a(obj, "Hawk.get(\"keydata\", \"pTzYn\")");
        return (String) obj;
    }

    public final void ab() {
        Hawk.put(d.f5595a.P(), 1);
    }

    public final int ac() {
        Object obj = Hawk.get(d.f5595a.P(), 0);
        kotlin.d.b.i.a(obj, "Hawk.get(\n            HA…,\n            0\n        )");
        return ((Number) obj).intValue();
    }
}

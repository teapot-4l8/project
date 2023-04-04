package cn.jiguang.i;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jiguang.o.f;
import cn.jiguang.o.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b extends cn.jiguang.o.a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile b f4088d;

    /* renamed from: a  reason: collision with root package name */
    private Context f4089a;

    /* renamed from: b  reason: collision with root package name */
    private Set<String> f4090b;

    /* renamed from: c  reason: collision with root package name */
    private List<cn.jiguang.j.a> f4091c;

    public static b a() {
        if (f4088d == null) {
            synchronized (b.class) {
                f4088d = new b();
            }
        }
        return f4088d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(b bVar, Context context, Intent intent) {
        String dataString;
        int i;
        String str;
        String str2;
        String action = intent.getAction();
        if (action == null || TextUtils.isEmpty(action)) {
            cn.jiguang.ad.a.d("JAppMovement", "the action'" + action + "'is illegal");
        } else if ((action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REMOVED")) && (dataString = intent.getDataString()) != null && !TextUtils.isEmpty(dataString) && dataString.length() > 8 && dataString.startsWith("package:")) {
            String substring = dataString.substring(8);
            cn.jiguang.ad.a.a("JAppMovement", "receive the action'" + action + ",package:" + substring);
            boolean z = false;
            if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                i = cn.jiguang.k.a.a(cn.jiguang.k.a.a(context, substring));
                cn.jiguang.ad.a.a("JAppMovement", "report add app:" + substring);
                str = "add";
            } else {
                cn.jiguang.ad.a.a("JAppMovement", "report remove app:" + substring);
                i = -1000;
                str = "rmv";
            }
            bVar.a(substring, i, str, 0);
            Set<String> e2 = bVar.e();
            bVar.f4090b = e2;
            if (e2 != null && !e2.isEmpty()) {
                try {
                    boolean z2 = true;
                    if (action.equals("android.intent.action.PACKAGE_ADDED")) {
                        bVar.f4090b.add(substring);
                        z = true;
                    }
                    if (action.equals("android.intent.action.PACKAGE_REMOVED")) {
                        bVar.f4090b.remove(substring);
                    } else {
                        z2 = z;
                    }
                    if (z2 && bVar.f4090b != null) {
                        String a2 = cn.jiguang.k.a.a(bVar.f4090b);
                        if (!TextUtils.isEmpty(a2)) {
                            cn.jiguang.ad.a.a("JAppMovement", "update installedAppList cache:" + bVar.f4090b);
                            cn.jiguang.v.d.a(context, "bal.catch", a2);
                        }
                    }
                } catch (Throwable th) {
                    str2 = "cache appList add remove failed:" + th.getMessage();
                }
                cn.jiguang.ad.a.a("JAppMovement", "executeAction: [JAppMovement]");
                bVar.a(context, "JAppMovement");
                bVar.b(context, "JAppMovement");
            }
            str2 = "get cache appList failed";
            cn.jiguang.ad.a.d("JAppMovement", str2);
            cn.jiguang.ad.a.a("JAppMovement", "executeAction: [JAppMovement]");
            bVar.a(context, "JAppMovement");
            bVar.b(context, "JAppMovement");
        }
    }

    private void a(String str, int i, String str2, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("action", str2);
            jSONObject.put("appid", str);
            jSONObject.put("source", i2);
            if (i != -1000) {
                jSONObject.put("install_type", i);
            }
            cn.jiguang.d.a.a(this.f4089a, jSONObject, "app_add_rmv");
            i.a(this.f4089a, (Object) jSONObject);
        } catch (JSONException e2) {
            cn.jiguang.ad.a.d("JAppMovement", "package json exception:" + e2.getMessage());
        }
    }

    private static boolean a(int i, String str) {
        if (i == 1) {
            cn.jiguang.ad.a.d("JAppMovement", "the " + str + " app is system app,need dealAction all apps,to executeMovementAction JAppAll");
            return true;
        }
        return false;
    }

    private Set<String> e() {
        String b2 = cn.jiguang.v.d.b(this.f4089a, "bal.catch");
        if (TextUtils.isEmpty(b2) || b2 == null || TextUtils.isEmpty(b2)) {
            return null;
        }
        return cn.jiguang.k.a.a(b2);
    }

    @Override // cn.jiguang.o.a
    protected final String a(Context context) {
        this.f4089a = context;
        return "JAppMovement";
    }

    public final void a(Context context, Intent intent) {
        this.f4089a = context;
        cn.jiguang.ad.a.a("JAppMovement", "executeMovementAction: [JAppMovement] from broadcast");
        if (b()) {
            cn.jiguang.ap.b.a("JCommon", new c(this, context, intent));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void a(Context context, String str) {
        super.a(context, str);
        List<cn.jiguang.j.a> a2 = cn.jiguang.k.a.a(context, true);
        if (a2 == null || a2.isEmpty()) {
            cn.jiguang.ad.a.d("JAppMovement", "collect installedAppList failed");
            return;
        }
        cn.jiguang.ad.a.a("JAppMovement", "collect installedAppList success");
        if (a2.size() == 1 && a2.get(0).f4117b.equals(context.getPackageName())) {
            cn.jiguang.ad.a.d("JAppMovement", "installedAppList only has one app and this app is itself");
            return;
        }
        Set<String> e2 = e();
        this.f4090b = e2;
        if (e2 == null || e2.isEmpty()) {
            cn.jiguang.ad.a.d("JAppMovement", "current appList cache is empty,need collect appList first,to executeMovementAction JAppAll");
            a.a().c(context);
            return;
        }
        cn.jiguang.ad.a.a("JAppMovement", "get installedAppList cache:" + this.f4090b);
        this.f4091c = new ArrayList(a2);
        for (cn.jiguang.j.a aVar : a2) {
            if (this.f4090b.remove(aVar.f4117b)) {
                this.f4091c.remove(aVar);
            }
        }
        if (this.f4090b.isEmpty() && this.f4091c.isEmpty()) {
            cn.jiguang.ad.a.a("JAppMovement", "installedAppList has no change");
            return;
        }
        String a3 = cn.jiguang.k.a.a(a2);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        cn.jiguang.ad.a.a("JAppMovement", "update installedAppList cache:" + a2);
        cn.jiguang.v.d.a(context, "bal.catch", a3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void b(Context context, String str) {
        List<cn.jiguang.j.a> list = this.f4091c;
        if (list == null || list.isEmpty()) {
            cn.jiguang.ad.a.d("JAppMovement", "there are no add app data to report");
        } else {
            for (cn.jiguang.j.a aVar : this.f4091c) {
                if (a(aVar.f4120e, "add")) {
                    a.a().c(context);
                } else {
                    a(aVar.f4117b, aVar.f4120e, "add", 1);
                    super.b(context, str);
                }
            }
        }
        Set<String> set = this.f4090b;
        if (set == null || set.isEmpty()) {
            cn.jiguang.ad.a.d("JAppMovement", "there are no remove app data to report");
        } else {
            for (String str2 : this.f4090b) {
                if (a(-1000, "rmv")) {
                    a.a().c(context);
                } else {
                    a(str2, -1000, "rmv", 1);
                    super.b(context, str);
                }
            }
        }
        this.f4091c = null;
        this.f4090b = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final boolean b() {
        cn.jiguang.ad.a.a("JAppMovement", "for googlePlay:false");
        return true;
    }

    @Override // cn.jiguang.o.a
    protected final boolean c(Context context, String str) {
        return f.a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final boolean d(Context context, String str) {
        List<cn.jiguang.j.a> list = this.f4091c;
        if (list == null || list.isEmpty()) {
            Set<String> set = this.f4090b;
            return (set == null || set.isEmpty()) ? false : true;
        }
        return true;
    }
}

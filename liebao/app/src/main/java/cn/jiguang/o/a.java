package cn.jiguang.o;

import android.content.Context;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, Context context, String str) {
        boolean c2 = aVar.c(context, str);
        cn.jiguang.ad.a.a("JCommon", str + " isBusinessEnable:" + c2);
        if (c2) {
            aVar.a(context, str);
        }
        boolean d2 = aVar.d(context, str);
        cn.jiguang.ad.a.a("JCommon", str + " isReportEnable:" + d2);
        if (d2) {
            aVar.b(context, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, Context context, String str, Bundle bundle) {
        aVar.a(str, bundle);
        boolean d2 = aVar.d();
        cn.jiguang.ad.a.a("JCommon", str + " isActionBundleEnable:" + d2);
        if (d2) {
            aVar.a(context, str);
            aVar.b(context, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar, Context context, String str, JSONObject jSONObject) {
        aVar.a(jSONObject);
        if (jSONObject.optInt("cmd") != 45) {
            boolean c2 = aVar.c();
            cn.jiguang.ad.a.a("JCommon", str + " isActionCommandEnable:" + c2);
            if (c2) {
                aVar.a(context, str);
                aVar.b(context, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(a aVar, Context context, String str) {
        aVar.a(context, str);
        aVar.b(context, str);
    }

    private boolean e(Context context, String str) {
        boolean b2 = b();
        boolean c2 = c();
        boolean e2 = e(context);
        boolean z = b2 && c2 && e2;
        cn.jiguang.ad.a.a("JCommon", str + " isActionEnable:" + z + ",actionUserEnable:" + b2 + ",actionCommandEnable:" + c2 + ",actionUidEnable:" + e2);
        return z;
    }

    protected abstract String a(Context context);

    public final void a(Context context, Bundle bundle) {
        String a2 = a(context);
        cn.jiguang.ad.a.a("JCommon", "executeBundleAction: [" + a2 + "] from bundle");
        boolean b2 = b();
        cn.jiguang.ad.a.a("JCommon", a2 + " isActionUserEnable:" + b2);
        if (b2) {
            cn.jiguang.ap.b.a("JCommon", new b(this, context, a2, bundle));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context, String str) {
        f.c(context, str);
    }

    public final void a(Context context, JSONObject jSONObject) {
        String a2 = a(context);
        cn.jiguang.ad.a.a("JCommon", "executeJsonAction: [" + a2 + "] from cmd");
        boolean b2 = b();
        cn.jiguang.ad.a.a("JCommon", a2 + " isActionUserEnable:" + b2);
        if (b2) {
            cn.jiguang.ap.b.a("JCommon", new e(this, context, a2, jSONObject));
        }
    }

    protected void a(String str, Bundle bundle) {
        if (bundle != null) {
            cn.jiguang.ad.a.a("JCommon", str + " parseJson:" + bundle.toString());
        }
    }

    protected void a(JSONObject jSONObject) {
    }

    public final void b(Context context) {
        String a2 = a(context);
        cn.jiguang.ad.a.a("JCommon", "executeAction: [" + a2 + "] from heartBeat");
        if (e(context, a2)) {
            cn.jiguang.ap.b.a("JCommon", new d(this, context, a2));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(Context context, String str) {
        f.e(context, str);
    }

    public final void b(Context context, JSONObject jSONObject) {
        String a2 = a(context);
        cn.jiguang.ad.a.a("JCommon", "executeCommandActionSingle: [" + a2 + "] from cmd");
        boolean b2 = b();
        cn.jiguang.ad.a.a("JCommon", a2 + " isActionUserEnable:" + b2);
        if (b2) {
            cn.jiguang.ap.b.a(a2, new e(this, context, a2, jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        return true;
    }

    public final void c(Context context) {
        String a2 = a(context);
        cn.jiguang.ad.a.a("JCommon", "executeCommandAction: [" + a2 + "] from cmd");
        if (e(context, a2)) {
            cn.jiguang.ap.b.a("JCommon", new c(this, context, a2));
        }
    }

    protected boolean c() {
        return true;
    }

    protected boolean c(Context context, String str) {
        return f.b(context, str);
    }

    public final void d(Context context) {
        String a2 = a(context);
        cn.jiguang.ad.a.a("JCommon", "executeActionSingle: [" + a2 + "] from heartBeat");
        if (e(context, a2)) {
            cn.jiguang.ap.b.a(a2, new d(this, context, a2));
        }
    }

    protected boolean d() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(Context context, String str) {
        return f.b(context, str);
    }

    protected boolean e(Context context) {
        return cn.jiguang.d.a.d(context) > 0;
    }

    public Object f(Context context) {
        return null;
    }
}

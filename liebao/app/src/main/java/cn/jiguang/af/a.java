package cn.jiguang.af;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.d.b;
import cn.jiguang.o.f;
import cn.jiguang.o.i;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.umeng.analytics.pro.ak;
import com.umeng.analytics.pro.d;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends cn.jiguang.o.a {

    /* renamed from: b  reason: collision with root package name */
    private static volatile a f3680b;

    /* renamed from: a  reason: collision with root package name */
    private Context f3681a;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f3682c;

    /* renamed from: d  reason: collision with root package name */
    private String f3683d = "";

    /* renamed from: e  reason: collision with root package name */
    private int f3684e = 0;
    private int f = 0;
    private int g = 0;

    public static a a() {
        if (f3680b == null) {
            synchronized (a.class) {
                f3680b = new a();
            }
        }
        return f3680b;
    }

    private JSONObject a(String str, int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(i);
            jSONArray.put(i2);
            jSONObject2.put(str, jSONArray);
            jSONObject.put(d.y, ak.u);
            jSONObject.put("itime", b.b(this.f3681a));
            jSONObject.put("sdk", jSONObject2);
            return jSONObject;
        } catch (JSONException e2) {
            cn.jiguang.ad.a.d("JType", "package json exception: " + e2.getMessage());
            return null;
        }
    }

    @Override // cn.jiguang.o.a
    protected final String a(Context context) {
        this.f3681a = context;
        return "JType";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void a(Context context, String str) {
    }

    @Override // cn.jiguang.o.a
    protected final void a(String str, Bundle bundle) {
        this.f3682c = bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void b(Context context, String str) {
        JSONObject a2 = a(this.f3683d, this.f3684e, this.f);
        if (a2 == null) {
            cn.jiguang.ad.a.d("JType", "there are no data to report");
        } else {
            i.a(context, (Object) a2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x00ba, code lost:
        if (cn.jiguang.o.f.j(r0, r3).equals(r4 + "," + r5) == false) goto L11;
     */
    @Override // cn.jiguang.o.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final boolean d() {
        Bundle bundle = this.f3682c;
        boolean z = false;
        if (bundle == null) {
            return false;
        }
        this.f3683d = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        this.f3684e = this.f3682c.getInt("custom", 0);
        this.f = this.f3682c.getInt("dynamic", 0);
        this.g = this.f3682c.getInt("sdk_v", 0);
        cn.jiguang.ad.a.a("JType", "parseBundle type:" + this.f3683d + ",custom:" + this.f3684e + ",dynamic:" + this.f + ",sdkVersion:" + this.g);
        Context context = this.f3681a;
        String str = this.f3683d;
        int i = this.f3684e;
        int i2 = this.f;
        int i3 = this.g;
        if (!TextUtils.isEmpty(str) && i >= 0 && i2 >= 0) {
            int k = f.k(context, str);
            cn.jiguang.ad.a.a("JType", "[isTypeReportEnable],lastversion:" + k + ",curversion:" + i3 + ",type:" + str);
            if (k == i3) {
            }
            z = true;
        }
        if (z) {
            f.a(this.f3681a, this.f3683d, this.g);
            f.a(this.f3681a, this.f3683d, this.f3684e + "," + this.f);
        } else {
            cn.jiguang.ad.a.a("JType", "type [" + this.f3683d + "] data not change");
        }
        return z;
    }
}

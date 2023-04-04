package cn.jiguang.i;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.o.i;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a extends cn.jiguang.o.a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f4085c;

    /* renamed from: a  reason: collision with root package name */
    private Context f4086a;

    /* renamed from: b  reason: collision with root package name */
    private List<cn.jiguang.j.a> f4087b;

    public static a a() {
        if (f4085c == null) {
            synchronized (a.class) {
                f4085c = new a();
            }
        }
        return f4085c;
    }

    @Override // cn.jiguang.o.a
    protected final String a(Context context) {
        this.f4086a = context;
        return "JAppAll";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void a(Context context, String str) {
        List<cn.jiguang.j.a> a2 = cn.jiguang.k.a.a(context, true);
        this.f4087b = a2;
        if (a2 == null || a2.isEmpty()) {
            cn.jiguang.ad.a.d("JAppAll", "collect failed, installedAppList is empty");
            return;
        }
        cn.jiguang.ad.a.a("JAppAll", "collect success");
        String a3 = cn.jiguang.k.a.a(this.f4087b);
        if (TextUtils.isEmpty(a3)) {
            return;
        }
        cn.jiguang.ad.a.a("JAppAll", "save appList [" + a3 + "]");
        if (context != null && !TextUtils.isEmpty("bal.catch")) {
            try {
                synchronized ("bal.catch") {
                    File a4 = cn.jiguang.f.e.a(context, "bal.catch");
                    if (a4 != null) {
                        cn.jiguang.f.e.a(a4, "");
                    }
                }
            } catch (Throwable th) {
                cn.jiguang.ad.a.d("JCommonFileHelper", "cleanString throwable:" + th.getMessage());
            }
        }
        cn.jiguang.v.d.a(context, "bal.catch", a3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void b(Context context, String str) {
        ArrayList<JSONArray> a2;
        try {
        } catch (JSONException e2) {
            cn.jiguang.ad.a.d("JAppAll", "package json exception:" + e2.getMessage());
        }
        if (this.f4087b != null && !this.f4087b.isEmpty()) {
            List<cn.jiguang.j.a> list = this.f4087b;
            JSONArray jSONArray = new JSONArray();
            for (cn.jiguang.j.a aVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.NAME, aVar.f4116a);
                jSONObject.put("pkg", aVar.f4117b);
                jSONObject.put("ver_name", aVar.f4118c);
                jSONObject.put("ver_code", aVar.f4119d);
                jSONObject.put("install_type", aVar.f4120e);
                jSONArray.put(jSONObject);
            }
            if (jSONArray.length() != 0 && (a2 = cn.jiguang.k.a.a(jSONArray)) != null && !a2.isEmpty()) {
                int i = 0;
                int size = a2.size();
                while (i < size) {
                    JSONObject jSONObject2 = new JSONObject();
                    i++;
                    jSONObject2.put("slice_index", i);
                    jSONObject2.put("slice_count", size);
                    jSONObject2.put(JThirdPlatFormInterface.KEY_DATA, a2.get(i));
                    cn.jiguang.d.a.a(context, jSONObject2, "app_list");
                    i.a(context, (Object) jSONObject2);
                    super.b(context, str);
                }
                this.f4087b = null;
                return;
            }
            return;
        }
        cn.jiguang.ad.a.d("JAppAll", "there are no data to report");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final boolean b() {
        cn.jiguang.ad.a.a("JAppAll", "for googlePlay:false");
        return true;
    }
}

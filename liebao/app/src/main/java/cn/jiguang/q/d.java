package cn.jiguang.q;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import com.umeng.analytics.pro.ak;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class d extends cn.jiguang.o.a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile d f4208c;

    /* renamed from: a  reason: collision with root package name */
    private Context f4209a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f4210b;

    public static d a() {
        if (f4208c == null) {
            synchronized (d.class) {
                f4208c = new d();
            }
        }
        return f4208c;
    }

    @Override // cn.jiguang.o.a
    protected final String a(Context context) {
        this.f4209a = context;
        return "JDevicePhoneNumber";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void a(Context context, String str) {
    }

    @Override // cn.jiguang.o.a
    protected final void a(JSONObject jSONObject) {
        try {
            int optInt = jSONObject.optInt("cmd");
            JSONObject optJSONObject = jSONObject.optJSONObject("content");
            if (optInt != 51) {
                return;
            }
            this.f4210b = optJSONObject.optBoolean("uploadnumber", false);
            String optString = optJSONObject.optString("version", "");
            String optString2 = optJSONObject.optString("app_id", "");
            String optString3 = optJSONObject.optString("app_secret", "");
            JSONArray optJSONArray = optJSONObject.optJSONArray("carriers");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    if (jSONObject2 != null) {
                        String optString4 = jSONObject2.optString(ak.P, "");
                        String optString5 = jSONObject2.optString(ImagesContract.URL, "");
                        if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                            int a2 = cn.jiguang.u.a.a(optString4);
                            if (!optString5.startsWith("http://")) {
                                optString5 = "http://" + optString5;
                            }
                            if (!optString5.endsWith("/")) {
                                optString5 = optString5 + "/";
                            }
                            if (a2 != -1) {
                                Context context = this.f4209a;
                                if (a2 >= 0 && a2 < 3) {
                                    cn.jiguang.r.a.a(context, "number_url" + a2, optString5);
                                }
                            }
                            cn.jiguang.ad.a.a("JDevicePhoneNumber", "carrier:" + optString4 + " url:" + optString5 + " providerIndex:" + a2);
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(optString)) {
                cn.jiguang.r.a.a(this.f4209a, "number_version", optString);
            }
            if (TextUtils.isEmpty(optString2)) {
                cn.jiguang.r.a.a(this.f4209a, "number_appid", optString2);
            }
            if (TextUtils.isEmpty(optString3)) {
                cn.jiguang.r.a.a(this.f4209a, "number_appsecret", optString3);
            }
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JDevicePhoneNumber", "parse throwable:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void b(Context context, String str) {
        try {
            cn.jiguang.r.a.a(context, true);
            if (cn.jiguang.f.a.j(context).toUpperCase().startsWith("WIFI")) {
                cn.jiguang.ad.a.d("JDevicePhoneNumber", "collect failed because current networkType is  wifi");
            } else {
                new cn.jiguang.u.d(context).a();
            }
        } catch (Throwable th) {
            cn.jiguang.ad.a.d("JDevicePhoneNumber", "report throwable:" + th.getMessage());
        }
    }

    @Override // cn.jiguang.o.a
    protected final boolean c() {
        return this.f4210b;
    }
}

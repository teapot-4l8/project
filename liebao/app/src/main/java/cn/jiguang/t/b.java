package cn.jiguang.t;

import android.text.TextUtils;
import com.umeng.analytics.pro.ak;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f4220a;

    /* renamed from: b  reason: collision with root package name */
    public String f4221b;

    /* renamed from: c  reason: collision with root package name */
    public String f4222c;

    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            String str = "";
            jSONObject.put("imei", TextUtils.isEmpty(this.f4220a) ? "" : this.f4220a);
            jSONObject.put(ak.aa, TextUtils.isEmpty(this.f4222c) ? "" : this.f4222c);
            if (!TextUtils.isEmpty(this.f4221b)) {
                str = this.f4221b;
            }
            jSONObject.put("imsi", str);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final boolean b() {
        return TextUtils.isEmpty(this.f4220a) && TextUtils.isEmpty(this.f4221b);
    }

    public final String toString() {
        return "JDeviceSimInfo{imei='" + this.f4220a + "', imsi='" + this.f4221b + "', iccid='" + this.f4222c + "'}";
    }
}

package cn.jiguang.j;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public String f4116a;

    /* renamed from: b  reason: collision with root package name */
    public String f4117b;

    /* renamed from: c  reason: collision with root package name */
    public String f4118c;

    /* renamed from: d  reason: collision with root package name */
    public int f4119d;

    /* renamed from: e  reason: collision with root package name */
    public int f4120e;

    public final JSONObject a(int i) {
        try {
            JSONObject put = new JSONObject().put(AppMeasurementSdk.ConditionalUserProperty.NAME, this.f4116a);
            CharSequence charSequence = this.f4117b;
            if (128 < charSequence.length()) {
                charSequence = charSequence.subSequence(0, 128);
            }
            return put.put("pkg", charSequence).put("ver_name", this.f4118c).put("ver_code", this.f4119d).put("install_type", this.f4120e);
        } catch (JSONException unused) {
            return null;
        }
    }
}

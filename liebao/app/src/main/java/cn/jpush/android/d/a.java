package cn.jpush.android.d;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements Serializable {
    private static final long serialVersionUID = -942487107643335186L;

    /* renamed from: a  reason: collision with root package name */
    public String f4307a;

    /* renamed from: b  reason: collision with root package name */
    public String f4308b;

    public a() {
    }

    public a(d dVar) {
        this.f4307a = dVar.f4312c;
        this.f4308b = dVar.f;
    }

    public a(String str, String str2) {
        this.f4307a = str;
        this.f4308b = str2;
    }

    public static a a(JSONObject jSONObject) {
        return new a(jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID), jSONObject.optString("override_msg_id"));
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, this.f4307a);
            jSONObject.put("override_msg_id", this.f4308b);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (TextUtils.isEmpty(this.f4307a) || TextUtils.isEmpty(aVar.f4307a) || !TextUtils.equals(this.f4307a, aVar.f4307a)) {
                return false;
            }
            if (TextUtils.isEmpty(this.f4308b) && TextUtils.isEmpty(aVar.f4308b)) {
                return true;
            }
            return (TextUtils.isEmpty(this.f4308b) || TextUtils.isEmpty(aVar.f4308b) || !TextUtils.equals(this.f4308b, aVar.f4308b)) ? false : true;
        }
        return false;
    }

    public String toString() {
        return "msg_id = " + this.f4307a + ",  override_msg_id = " + this.f4308b;
    }
}

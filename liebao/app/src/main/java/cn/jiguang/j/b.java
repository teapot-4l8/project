package cn.jiguang.j;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f4121a;

    /* renamed from: b  reason: collision with root package name */
    public String f4122b;

    /* renamed from: c  reason: collision with root package name */
    public String f4123c;

    /* renamed from: d  reason: collision with root package name */
    public String f4124d;

    public final JSONObject a(int i) {
        try {
            JSONObject put = new JSONObject().put("uid", this.f4121a).put("pid", this.f4122b).put("ppid", this.f4123c);
            CharSequence charSequence = this.f4124d;
            if (128 < charSequence.length()) {
                charSequence = charSequence.subSequence(0, 128);
            }
            return put.put("proc_name", charSequence);
        } catch (JSONException unused) {
            return null;
        }
    }
}

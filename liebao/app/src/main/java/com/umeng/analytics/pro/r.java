package com.umeng.analytics.pro;

import android.content.Context;
import cn.jiguang.internal.JConstants;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DefconProcesser.java */
/* loaded from: classes2.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private static final int f6614a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f6615b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f6616c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f6617d = 3;

    /* renamed from: e  reason: collision with root package name */
    private final long f6618e;

    private r() {
        this.f6618e = JConstants.MIN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefconProcesser.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final r f6619a = new r();

        private a() {
        }
    }

    public static r a() {
        return a.f6619a;
    }

    public int a(Context context) {
        return Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "defcon", String.valueOf(0))).intValue();
    }

    private void a(JSONObject jSONObject, boolean z) {
        if (!z && jSONObject.has(d.n)) {
            jSONObject.remove(d.n);
        }
        if (jSONObject.has(d.L)) {
            jSONObject.remove(d.L);
        }
        if (jSONObject.has(d.O)) {
            jSONObject.remove(d.O);
        }
        if (jSONObject.has("ekv")) {
            jSONObject.remove("ekv");
        }
        if (jSONObject.has(d.T)) {
            jSONObject.remove(d.T);
        }
        if (jSONObject.has(d.L)) {
            jSONObject.remove(d.L);
        }
        if (jSONObject.has("userlevel")) {
            jSONObject.remove("userlevel");
        }
    }

    public void a(JSONObject jSONObject, Context context) {
        int a2 = a(context);
        if (a2 == 1) {
            a(jSONObject, true);
            i.a(context).b(false, true);
        } else if (a2 == 2) {
            jSONObject.remove(d.n);
            try {
                jSONObject.put(d.n, b());
            } catch (Exception unused) {
            }
            a(jSONObject, true);
            i.a(context).b(false, true);
        } else if (a2 == 3) {
            a(jSONObject, false);
            i.a(context).b(false, true);
        }
    }

    public void b(JSONObject jSONObject, Context context) {
        int a2 = a(context);
        if (a2 == 1) {
            if (jSONObject.has(d.L)) {
                jSONObject.remove(d.L);
            }
            if (jSONObject.has(d.n)) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray(d.n);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        if (jSONObject2.has(d.au)) {
                            jSONObject2.remove(d.au);
                        }
                        if (jSONObject2.has(d.av)) {
                            jSONObject2.remove(d.av);
                        }
                    }
                } catch (JSONException unused) {
                }
            }
            i.a(context).a(false, true);
        } else if (a2 == 2) {
            if (jSONObject.has(d.L)) {
                jSONObject.remove(d.L);
            }
            if (jSONObject.has(d.n)) {
                jSONObject.remove(d.n);
            }
            try {
                jSONObject.put(d.n, c());
            } catch (Exception unused2) {
            }
            i.a(context).a(false, true);
        } else if (a2 == 3) {
            if (jSONObject.has(d.L)) {
                jSONObject.remove(d.L);
            }
            jSONObject.remove(d.n);
            i.a(context).a(false, true);
        }
    }

    private JSONArray b() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", y.a().a(UMGlobalContext.getAppContext(null)));
            jSONObject.put(d.p, currentTimeMillis);
            jSONObject.put(d.f6501q, currentTimeMillis + JConstants.MIN);
            jSONObject.put("duration", JConstants.MIN);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }

    private JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", y.a().d(UMGlobalContext.getAppContext(null)));
            jSONObject.put(d.p, currentTimeMillis);
            jSONArray.put(jSONObject);
        } catch (JSONException unused) {
        }
        return jSONArray;
    }
}

package cn.jiguang.ao;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.analytics.page.PushSA;
import cn.jiguang.internal.JConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f3766c;

    /* renamed from: d  reason: collision with root package name */
    private static final Object f3767d = new Object();

    /* renamed from: a  reason: collision with root package name */
    private long f3768a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Set<String>> f3769b = new HashMap();

    private a() {
    }

    public static a a() {
        if (f3766c == null) {
            synchronized (f3767d) {
                if (f3766c == null) {
                    f3766c = new a();
                }
            }
        }
        return f3766c;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "normal";
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1245458676:
                if (str.equals(PushSA.REPORT_ACTIVE_LAUNCH)) {
                    c2 = 5;
                    break;
                }
                break;
            case -1177318867:
                if (str.equals("account")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -1091230153:
                if (str.equals("android_awake_target2")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1051289244:
                if (str.equals(com.umeng.analytics.pro.d.L)) {
                    c2 = 7;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c2 = 11;
                    break;
                }
                break;
            case -820729752:
                if (str.equals(PushSA.REPORT_ACTIVE_TERMINATE)) {
                    c2 = 6;
                    break;
                }
                break;
            case -693746763:
                if (str.equals("android_awake")) {
                    c2 = 1;
                    break;
                }
                break;
            case -31313123:
                if (str.equals("android_awake2")) {
                    c2 = 0;
                    break;
                }
                break;
            case 93223301:
                if (str.equals("awake")) {
                    c2 = 4;
                    break;
                }
                break;
            case 907150721:
                if (str.equals("detach_account")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1350272347:
                if (str.equals("android_awake_target")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1973539834:
                if (str.equals("identify_account")) {
                    c2 = '\b';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return "awake";
            case 5:
            case 6:
            case 7:
                return com.umeng.analytics.pro.d.L;
            case '\b':
            case '\t':
            case '\n':
                return "account";
            case 11:
                break;
            default:
                if (this.f3769b.containsKey(str)) {
                    return str;
                }
                break;
        }
        return "normal";
    }

    private void a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray optJSONArray = jSONObject.optJSONArray(next);
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            linkedHashSet.add(optJSONArray.getString(i));
                        }
                    }
                    hashMap.put(next, linkedHashSet);
                }
                if (hashMap.isEmpty()) {
                    return;
                }
                this.f3769b = hashMap;
            } catch (JSONException unused) {
            }
        }
    }

    public final a a(Context context) {
        try {
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.t())).longValue();
            if (this.f3768a == 0 || this.f3768a != longValue) {
                this.f3768a = longValue;
                String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.r());
                if (!TextUtils.isEmpty(str)) {
                    a(new JSONObject(str));
                }
            }
        } catch (Throwable unused) {
        }
        return this;
    }

    public final String a(Set<String> set) {
        if (set != null) {
            try {
                if (!set.isEmpty()) {
                    String str = null;
                    for (String str2 : set) {
                        String a2 = a(str2);
                        if (str == null) {
                            str = a2;
                        } else if (!str.equals(a2)) {
                            cn.jiguang.an.d.f("AddressGroupManager", "Report JSONArray belong more than one space, using normal-space");
                            return "normal";
                        }
                    }
                    return str;
                }
            } catch (Throwable unused) {
            }
        }
        return "normal";
    }

    public final void a(Context context, JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("sis_ips");
        long j = JConstants.HOUR;
        try {
            long j2 = jSONObject.getLong("ttl");
            if (j2 >= 0) {
                j = j2;
            }
        } catch (JSONException unused) {
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("ips");
        cn.jiguang.g.a[] aVarArr = new cn.jiguang.g.a[4];
        aVarArr[0] = cn.jiguang.g.a.s().a((cn.jiguang.g.a<String>) optJSONArray.toString());
        aVarArr[1] = cn.jiguang.g.a.u().a((cn.jiguang.g.a<Long>) Long.valueOf(j * 1000));
        aVarArr[2] = cn.jiguang.g.a.t().a((cn.jiguang.g.a<Long>) Long.valueOf(System.currentTimeMillis()));
        aVarArr[3] = cn.jiguang.g.a.r().a((cn.jiguang.g.a<String>) (optJSONObject != null ? optJSONObject.toString() : ""));
        cn.jiguang.g.b.a(context, aVarArr);
        a(optJSONObject);
    }

    public final a b(Context context) {
        boolean z;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            a(context);
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.u())).longValue();
            if (longValue < 0) {
                longValue = JConstants.HOUR;
            } else if (longValue < JConstants.MIN) {
                longValue = 60000;
            }
            if (longValue > 604800000) {
                longValue = 604800000;
            }
            SimpleDateFormat a2 = cn.jiguang.f.c.a("yyyy-MM-dd HH:mm:ss");
            cn.jiguang.an.d.b("AddressGroupManager", "lastUpdateTime=" + a2.format(new Date(this.f3768a)) + " now=" + a2.format(new Date(currentTimeMillis)) + " expire=" + (longValue / 1000));
            if (this.f3768a == 0 || this.f3768a + longValue < currentTimeMillis) {
                cn.jiguang.an.d.b("AddressGroupManager", "cache invalid, fetch new urls");
                if (this.f3769b != null && !this.f3769b.isEmpty()) {
                    z = false;
                    i.a(context, z);
                }
                z = true;
                i.a(context, z);
            }
        } catch (Throwable th) {
            cn.jiguang.an.d.f("AddressGroupManager", "refresh e" + th);
        }
        return this;
    }

    public final Set<String> b(Set<String> set) {
        if (set != null && !set.isEmpty()) {
            Set<String> set2 = null;
            for (String str : set) {
                Set<String> set3 = this.f3769b.get(a(str));
                if (set3 != null && !set3.isEmpty()) {
                    if (set2 == null) {
                        set2 = set3;
                    } else {
                        set2.retainAll(set3);
                    }
                    if (set2.isEmpty()) {
                    }
                }
            }
            return set2;
        }
        return this.f3769b.get("normal");
    }
}

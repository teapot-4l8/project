package b.a.c;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f3116a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f3117b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f3118c;

    /* renamed from: d  reason: collision with root package name */
    private Boolean f3119d;

    /* renamed from: e  reason: collision with root package name */
    private Long f3120e;
    private String f;
    private List g = new ArrayList();

    public static b b(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("wakeupStatsEnabled")) {
                bVar.a(Boolean.valueOf(jSONObject.optBoolean("wakeupStatsEnabled", true)));
            }
            if (jSONObject.has("aliveStatsEnabled")) {
                bVar.c(Boolean.valueOf(jSONObject.optBoolean("aliveStatsEnabled", true)));
            }
            if (jSONObject.has("registerStatsEnabled")) {
                bVar.b(Boolean.valueOf(jSONObject.optBoolean("registerStatsEnabled", true)));
            }
            if (jSONObject.has("eventStatsEnabled")) {
                bVar.c(Boolean.valueOf(jSONObject.optBoolean("eventStatsEnabled", true)));
            }
            if (jSONObject.has("reportPeriod")) {
                bVar.a(Long.valueOf(jSONObject.optLong("reportPeriod")));
            }
            if (jSONObject.has("installId")) {
                bVar.a(jSONObject.optString("installId"));
            }
        } catch (JSONException unused) {
        }
        return bVar;
    }

    private boolean d(Boolean bool) {
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public Boolean a() {
        return this.f3116a;
    }

    public void a(b bVar) {
        this.f3116a = bVar.a();
        this.f3117b = bVar.d();
        this.f3118c = bVar.c();
        this.f3119d = bVar.d();
        this.f3120e = bVar.g();
        this.f = bVar.h();
    }

    public void a(Boolean bool) {
        this.f3116a = bool;
    }

    public void a(Long l) {
        this.f3120e = l;
    }

    public void a(String str) {
        this.f = str;
    }

    public void b(Boolean bool) {
        this.f3118c = bool;
    }

    public boolean b() {
        return d(this.f3116a);
    }

    public Boolean c() {
        return this.f3118c;
    }

    public void c(Boolean bool) {
        this.f3119d = bool;
    }

    public Boolean d() {
        return this.f3119d;
    }

    public boolean e() {
        return d(this.f3119d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        Boolean bool = this.f3116a;
        if (bool == null ? bVar.f3116a == null : bool.equals(bVar.f3116a)) {
            Boolean bool2 = this.f3117b;
            if (bool2 == null ? bVar.f3117b == null : bool2.equals(bVar.f3117b)) {
                Boolean bool3 = this.f3118c;
                if (bool3 == null ? bVar.f3118c == null : bool3.equals(bVar.f3118c)) {
                    Boolean bool4 = this.f3119d;
                    if (bool4 == null ? bVar.f3119d == null : bool4.equals(bVar.f3119d)) {
                        Long l = this.f3120e;
                        if (l == null ? bVar.f3120e == null : l.equals(bVar.f3120e)) {
                            String str = this.f;
                            String str2 = bVar.f;
                            return str != null ? str.equals(str2) : str2 == null;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean f() {
        return d(this.f3118c);
    }

    public Long g() {
        return this.f3120e;
    }

    public String h() {
        return this.f;
    }

    public int hashCode() {
        Boolean bool = this.f3116a;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.f3117b;
        int hashCode2 = (hashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.f3118c;
        int hashCode3 = (hashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.f3119d;
        int hashCode4 = (hashCode3 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Long l = this.f3120e;
        int hashCode5 = (hashCode4 + (l != null ? l.hashCode() : 0)) * 31;
        String str = this.f;
        return hashCode5 + (str != null ? str.hashCode() : 0);
    }

    public void i() {
        for (a aVar : this.g) {
            aVar.a(this);
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wakeupStatsEnabled", this.f3116a);
            jSONObject.put("registerStatsEnabled", this.f3118c);
            jSONObject.put("eventStatsEnabled", this.f3119d);
            jSONObject.put("reportPeriod", this.f3120e);
            jSONObject.put("installId", this.f);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}

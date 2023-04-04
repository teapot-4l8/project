package b.a.h.a;

import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final IdentityHashMap f3218a = new IdentityHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap f3219b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final b.a.h.b.a f3220c = new b.a.h.b.a();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f3221d;

    public d(boolean z) {
        this.f3221d = z;
        b();
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f3221d ? this.f3220c.a(str) : URLEncoder.encode((String) this.f3219b.get(str), "utf-8");
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f3221d ? this.f3220c.b(str) : URLEncoder.encode(str, "utf-8");
    }

    private void b() {
        this.f3219b.put("cF", "certFinger");
        this.f3219b.put("aI", "apkInfo");
        this.f3219b.put("pp", "pb");
        this.f3219b.put("pbH", "pbHtml");
        this.f3219b.put("pbT", "pbText");
        this.f3219b.put("gR", "gReferrer");
        this.f3219b.put("mI", "matchId");
        this.f3219b.put("Pk", "pkg");
        this.f3219b.put("fin", "finger");
        this.f3219b.put("ul", ImagesContract.URL);
        this.f3219b.put("ts", "timestamp");
        this.f3219b.put("iI", "installId");
        this.f3219b.put("dI", "deviceId");
        this.f3219b.put("mA", "macAddress");
        this.f3219b.put("sN", "serialNumber");
        this.f3219b.put("andI", "androidId");
        this.f3219b.put("md", "model");
        this.f3219b.put("bI", "buildId");
        this.f3219b.put("bd", "brand");
        this.f3219b.put("buiD", "buildDisplay");
        this.f3219b.put("ver", "version");
        this.f3219b.put("verI", "versionCode");
        this.f3219b.put("wid", "width");
        this.f3219b.put("hei", "height");
        this.f3219b.put("apV", "apiVersion");
        this.f3219b.put("ioA", "iosAid");
        this.f3219b.put("im", "imei");
        this.f3219b.put("oa", "oaid");
        this.f3219b.put("ga", "gaid");
        this.f3219b.put("loI", "localIP");
        this.f3219b.put("im2", "imei2");
        this.f3219b.put("si", "simulator");
        this.f3219b.put("waU", "wakeupUrl");
        this.f3219b.put("verS", "versionName");
    }

    public Set a() {
        return this.f3218a.entrySet();
    }

    public void a(String str, String str2) {
        try {
            str = a(str);
            str2 = b(str2);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f3218a.put(new String(str), str2);
    }

    public void a(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            a((String) entry.getKey(), (String) entry.getValue());
        }
    }
}

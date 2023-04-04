package cn.jpush.android.b;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.api.ReportCallBack;
import cn.jpush.android.cache.Key;
import cn.jpush.android.cache.Sp;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.u.g;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    protected Context f4291a;

    /* renamed from: b  reason: collision with root package name */
    protected LinkedHashMap<String, b> f4292b;

    /* renamed from: c  reason: collision with root package name */
    protected int f4293c;

    public c(Context context) {
        this.f4293c = 100;
        this.f4291a = context.getApplicationContext();
        this.f4293c = cn.jpush.android.cache.a.d(context, 10);
        a(context);
        b(this.f4293c);
    }

    private static b a(cn.jpush.android.d.d dVar) {
        b bVar = new b();
        bVar.f4285a = dVar.Y;
        bVar.f4286b = dVar.Z;
        bVar.f4287c = dVar.aa;
        bVar.f4288d = dVar.ab;
        bVar.f4289e = dVar.ad;
        bVar.f = dVar.ae;
        bVar.g = dVar.af;
        bVar.h = dVar.ag;
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(Context context) {
        File a2;
        LinkedHashMap<String, b> linkedHashMap;
        try {
            a2 = cn.jpush.android.u.c.a(context, "jpush_geofence_v5");
        } catch (Throwable th) {
            Logger.dd("GeofenceAction", "recover geofence failed:" + th);
        }
        if (a2 == null || !a2.exists()) {
            int intValue = ((Integer) Sp.get(context, Key.PushVerCode())).intValue();
            if (intValue >= 318 && intValue <= 330) {
                LinkedHashMap linkedHashMap2 = (LinkedHashMap) cn.jpush.android.u.c.a(cn.jpush.android.u.c.a(context, "jpush_geofence_v3"));
                if (linkedHashMap2 != null && !linkedHashMap2.isEmpty()) {
                    Logger.d("GeofenceAction", "old geofences:" + linkedHashMap2);
                    LinkedHashMap<String, b> linkedHashMap3 = new LinkedHashMap<>();
                    for (Map.Entry entry : linkedHashMap2.entrySet()) {
                        linkedHashMap3.put(entry.getKey(), a((cn.jpush.android.d.d) entry.getValue()));
                    }
                    if (!linkedHashMap3.isEmpty()) {
                        this.f4292b = linkedHashMap3;
                        c();
                    }
                }
            } else if (intValue > 330 && intValue < 350) {
                linkedHashMap = (LinkedHashMap) cn.jpush.android.u.c.a(cn.jpush.android.u.c.a(context, "jpush_geofence_v4"));
            }
            Sp.set(context, Key.PushVerCode().set(Integer.valueOf(cn.jpush.android.l.a.f4374a)));
            if (this.f4292b == null) {
                this.f4292b = new LinkedHashMap<>();
            }
            d();
            Logger.dd("GeofenceAction", "Recover geofence size:" + this.f4292b.size());
        }
        linkedHashMap = b(context);
        this.f4292b = linkedHashMap;
        Sp.set(context, Key.PushVerCode().set(Integer.valueOf(cn.jpush.android.l.a.f4374a)));
        if (this.f4292b == null) {
        }
        d();
        Logger.dd("GeofenceAction", "Recover geofence size:" + this.f4292b.size());
    }

    private void a(Context context, b bVar) {
        try {
            Logger.d("GeofenceAction", "geofence report id=" + bVar.f4285a);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("geofence_id", bVar.f4285a);
            if (JCoreManager.onEvent(null, null, 26, null, null, jSONObject, "geo_fence") instanceof JSONObject) {
                JCoreManager.onEvent(context, JPushConstants.SDK_TYPE, 15, null, null, jSONObject, new ReportCallBack() { // from class: cn.jpush.android.b.c.1
                    @Override // cn.jiguang.api.ReportCallBack
                    public void onFinish(int i) {
                        Logger.d("GeofenceAction", "report with callback:" + i);
                    }
                });
            }
        } catch (Throwable th) {
            Logger.w("GeofenceAction", "report geofence error:" + th);
        }
    }

    private LinkedHashMap<String, b> b(Context context) {
        FileInputStream fileInputStream = null;
        if (context == null) {
            Logger.w("GeofenceAction", "unexcepted , context is null");
            return null;
        }
        LinkedHashMap<String, b> linkedHashMap = new LinkedHashMap<>();
        try {
            File a2 = cn.jpush.android.u.c.a(context, "jpush_geofence_v5");
            if (a2.exists()) {
                FileInputStream fileInputStream2 = new FileInputStream(a2);
                try {
                    JSONObject jSONObject = new JSONObject(new String(g.a((InputStream) fileInputStream2)));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        b a3 = b.a(context, jSONObject.getJSONObject(keys.next()));
                        if (a3 != null) {
                            linkedHashMap.put(a3.f4285a, a3);
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    try {
                        Logger.w("GeofenceAction", "load objects error:" + th.getMessage());
                        return linkedHashMap;
                    } finally {
                        g.a((Closeable) fileInputStream);
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
        return linkedHashMap;
    }

    private void b(int i) {
        int size = this.f4292b.size();
        if (size > i) {
            Logger.dd("GeofenceAction", "Geofence count= " + size + ",limit=" + i + ",need remove earliest");
            Iterator<b> it = this.f4292b.values().iterator();
            while (it.hasNext() && size > i) {
                b next = it.next();
                if (next != null) {
                    b(next);
                }
                it.remove();
                size--;
            }
        }
    }

    private void d() {
        Iterator<Map.Entry<String, b>> it = this.f4292b.entrySet().iterator();
        boolean z = false;
        while (it.hasNext()) {
            b value = it.next().getValue();
            if (value != null && value.f4289e * 1000 <= System.currentTimeMillis()) {
                z = true;
                Logger.dd("GeofenceAction", "Geofence " + value.f4285a + " is out of date!");
                it.remove();
                b(value);
            }
        }
        if (z) {
            c();
        }
    }

    private void e() {
        c();
        if (this.f4292b.size() == 0) {
            a();
        } else {
            b();
        }
    }

    private boolean e(b bVar) {
        if (bVar == null || TextUtils.isEmpty(bVar.f4285a) || bVar.f4286b == -1 || bVar.g < -90.0d || bVar.g > 90.0d || bVar.f < -180.0d || bVar.f > 180.0d) {
            Logger.ww("GeofenceAction", "The geofence is invalid, won't operate!");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    public void a(int i) {
        cn.jpush.android.cache.a.c(this.f4291a, i);
        this.f4293c = i;
        b(i);
    }

    public void a(long j) {
    }

    protected abstract void a(b bVar);

    protected abstract void a(b bVar, b bVar2);

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b remove = this.f4292b.remove(str);
        if (remove != null) {
            b(remove);
            e();
            return;
        }
        Logger.d("GeofenceAction", "geofence=" + str + " already not exists");
    }

    public void a(String str, JSONObject jSONObject) {
        String str2;
        if (TextUtils.isEmpty(str) || jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        Logger.dd("GeofenceAction", "Current geofence size:" + this.f4292b.size());
        b bVar = this.f4292b.get(str);
        if (bVar != null) {
            if (jSONObject.has(com.umeng.analytics.pro.d.y)) {
                str2 = bVar.i != jSONObject.optInt(com.umeng.analytics.pro.d.y, 1) ? "can not update geofence because type can't change" : "can not update geofence because type can't change";
            }
            bVar.b(jSONObject);
            if (bVar.f4289e * 1000 <= System.currentTimeMillis()) {
                this.f4292b.remove(str);
                b(bVar);
            } else {
                a(bVar, bVar);
            }
            e();
            return;
        }
        str2 = "can not update geofence because origin one not found";
        Logger.ww("GeofenceAction", str2);
    }

    public void b() {
    }

    protected abstract void b(b bVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        Logger.dd("GeofenceAction", "save geofence to file");
        LinkedHashMap<String, b> linkedHashMap = this.f4292b;
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            return;
        }
        try {
            File a2 = cn.jpush.android.u.c.a(this.f4291a, "jpush_geofence_v5");
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, b> entry : this.f4292b.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue().a());
            }
            cn.jpush.android.u.c.a(a2.getAbsolutePath(), jSONObject.toString());
        } catch (Throwable th) {
            Logger.ww("GeofenceAction", "save geo to file error:" + th.getMessage());
        }
    }

    public void c(b bVar) {
        Logger.dd("GeofenceAction", "Current geofence size:" + this.f4292b.size());
        if (e(bVar)) {
            b bVar2 = this.f4292b.get(bVar.f4285a);
            long j = bVar.f4289e * 1000;
            if (bVar2 != null) {
                if (j <= System.currentTimeMillis()) {
                    this.f4292b.remove(bVar.f4285a);
                    b(bVar2);
                } else {
                    bVar.a(bVar2);
                    this.f4292b.put(bVar.f4285a, bVar);
                    a(bVar2, bVar);
                }
            } else if (j <= System.currentTimeMillis()) {
                Logger.dd("GeofenceAction", "The geofence " + bVar.f4285a + " is out of date, will not create!");
                return;
            } else {
                b(this.f4293c - 1);
                this.f4292b.put(bVar.f4285a, bVar);
                a(bVar);
            }
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(b bVar) {
        if (bVar != null) {
            try {
                if (bVar.i == 2) {
                    a(this.f4291a, bVar);
                } else if (bVar.t != null) {
                    cn.jpush.android.d.b.a(this.f4291a, bVar.t);
                } else {
                    Logger.w("GeofenceAction", "there is no push entity, won't show notification");
                }
            } catch (Throwable th) {
                Logger.ww("GeofenceAction", "process geofence error:" + th);
            }
        }
    }
}

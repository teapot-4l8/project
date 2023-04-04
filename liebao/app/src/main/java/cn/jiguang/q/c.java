package cn.jiguang.q;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import cn.jiguang.o.i;
import com.umeng.analytics.pro.ak;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends cn.jiguang.o.a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f4205c;

    /* renamed from: a  reason: collision with root package name */
    private Context f4206a;

    /* renamed from: b  reason: collision with root package name */
    private JSONObject f4207b;

    public static c a() {
        if (f4205c == null) {
            synchronized (c.class) {
                f4205c = new c();
            }
        }
        return f4205c;
    }

    @Override // cn.jiguang.o.a
    protected final String a(Context context) {
        this.f4206a = context;
        return "JDeviceBattery";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void a(Context context, String str) {
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"), context.getPackageName() + cn.jiguang.a.a.f3639a, null);
            if (registerReceiver == null) {
                return;
            }
            int intExtra = registerReceiver.getIntExtra("level", -1);
            int intExtra2 = registerReceiver.getIntExtra("scale", -1);
            int intExtra3 = registerReceiver.getIntExtra("status", -1);
            if (intExtra3 == 1) {
                intExtra3 = 0;
            } else if (intExtra3 == 2) {
                intExtra3 = 2;
            } else if (intExtra3 == 3 || intExtra3 == 4) {
                intExtra3 = 1;
            } else if (intExtra3 == 5) {
                intExtra3 = 3;
            }
            int intExtra4 = registerReceiver.getIntExtra("voltage", -1);
            int intExtra5 = registerReceiver.getIntExtra("temperature", -1);
            if (this.f4207b == null) {
                this.f4207b = new JSONObject();
            }
            this.f4207b.put("level", intExtra);
            this.f4207b.put("scale", intExtra2);
            this.f4207b.put("status", intExtra3);
            this.f4207b.put("voltage", intExtra4);
            this.f4207b.put("temperature", intExtra5);
            cn.jiguang.ad.a.a("JDeviceBattery", "collect success:" + this.f4207b);
        } catch (JSONException e2) {
            cn.jiguang.ad.a.d("JDeviceBattery", "packageJson exception: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jiguang.o.a
    public final void b(Context context, String str) {
        JSONObject jSONObject = this.f4207b;
        if (jSONObject == null) {
            cn.jiguang.ad.a.d("JDeviceBattery", "there are no data to report");
            return;
        }
        cn.jiguang.d.a.a(context, jSONObject, ak.Z);
        i.a(context, (Object) this.f4207b);
        super.b(context, str);
        this.f4207b = null;
    }
}

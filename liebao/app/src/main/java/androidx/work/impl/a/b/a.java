package androidx.work.impl.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.work.h;

/* compiled from: BatteryChargingTracker.java */
/* loaded from: classes.dex */
public class a extends c<Boolean> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f2818d = h.a("BatteryChrgTracker");

    public a(Context context, androidx.work.impl.utils.b.a aVar) {
        super(context, aVar);
    }

    @Override // androidx.work.impl.a.b.d
    /* renamed from: a */
    public Boolean c() {
        Intent registerReceiver = this.f2825b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            h.a().e(f2818d, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        return Boolean.valueOf(a(registerReceiver));
    }

    @Override // androidx.work.impl.a.b.c
    public IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            intentFilter.addAction("android.os.action.DISCHARGING");
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        return intentFilter;
    }

    @Override // androidx.work.impl.a.b.c
    public void a(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        h.a().b(f2818d, String.format("Received %s", action), new Throwable[0]);
        char c2 = 65535;
        switch (action.hashCode()) {
            case -1886648615:
                if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    c2 = 3;
                    break;
                }
                break;
            case -54942926:
                if (action.equals("android.os.action.DISCHARGING")) {
                    c2 = 1;
                    break;
                }
                break;
            case 948344062:
                if (action.equals("android.os.action.CHARGING")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1019184907:
                if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        if (c2 == 0) {
            a((a) true);
        } else if (c2 == 1) {
            a((a) false);
        } else if (c2 == 2) {
            a((a) true);
        } else if (c2 != 3) {
        } else {
            a((a) false);
        }
    }

    private boolean a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            int intExtra = intent.getIntExtra("status", -1);
            if (intExtra == 2 || intExtra == 5) {
                return true;
            }
        } else if (intent.getIntExtra("plugged", 0) != 0) {
            return true;
        }
        return false;
    }
}

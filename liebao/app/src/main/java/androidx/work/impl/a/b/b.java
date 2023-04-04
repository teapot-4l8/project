package androidx.work.impl.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.h;

/* compiled from: BatteryNotLowTracker.java */
/* loaded from: classes.dex */
public class b extends c<Boolean> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f2819d = h.a("BatteryNotLowTracker");

    public b(Context context, androidx.work.impl.utils.b.a aVar) {
        super(context, aVar);
    }

    @Override // androidx.work.impl.a.b.d
    /* renamed from: a */
    public Boolean c() {
        Intent registerReceiver = this.f2825b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver == null) {
            h.a().e(f2819d, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        return Boolean.valueOf((registerReceiver.getIntExtra("plugged", 0) != 0 || registerReceiver.getIntExtra("status", -1) == 1 || ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)) > 0.15f) ? true : true);
    }

    @Override // androidx.work.impl.a.b.c
    public IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // androidx.work.impl.a.b.c
    public void a(Context context, Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        h.a().b(f2819d, String.format("Received %s", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        char c2 = 65535;
        int hashCode = action.hashCode();
        if (hashCode != -1980154005) {
            if (hashCode == 490310653 && action.equals("android.intent.action.BATTERY_LOW")) {
                c2 = 1;
            }
        } else if (action.equals("android.intent.action.BATTERY_OKAY")) {
            c2 = 0;
        }
        if (c2 == 0) {
            a((b) true);
        } else if (c2 != 1) {
        } else {
            a((b) false);
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzddt implements zzdhe<zzddu> {
    private final Context context;
    private final zzebs zzgka;

    public zzddt(zzebs zzebsVar, Context context) {
        this.zzgka = zzebsVar;
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzddu> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzddw
            private final zzddt zzheh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzheh = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzheh.zzauc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzddu zzauc() {
        double d2;
        Intent registerReceiver = this.context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            double intExtra2 = registerReceiver.getIntExtra("level", -1);
            double intExtra3 = registerReceiver.getIntExtra("scale", -1);
            Double.isNaN(intExtra2);
            Double.isNaN(intExtra3);
            d2 = intExtra2 / intExtra3;
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d2 = -1.0d;
        }
        return new zzddu(d2, z);
    }
}

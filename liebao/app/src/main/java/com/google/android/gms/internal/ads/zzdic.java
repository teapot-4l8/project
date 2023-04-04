package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdic implements zzdhe<zzdhz> {
    private final Context context;
    private final String packageName;
    private final zzebs zzgka;
    private final zzaum zzhhg;

    public zzdic(zzaum zzaumVar, Context context, String str, zzebs zzebsVar) {
        this.zzhhg = zzaumVar;
        this.context = context;
        this.packageName = str;
        this.zzgka = zzebsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdhz> zzatu() {
        return this.zzgka.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdib
            private final zzdic zzhhf;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhhf = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhhf.zzaus();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdhz zzaus() {
        JSONObject jSONObject = new JSONObject();
        zzaum zzaumVar = this.zzhhg;
        if (zzaumVar != null) {
            zzaumVar.zza(this.context, this.packageName, jSONObject);
        }
        return new zzdhz(jSONObject);
    }
}

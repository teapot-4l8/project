package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzajg;
import com.google.android.gms.internal.ads.zzbae;
import com.google.android.gms.internal.ads.zzww;
import java.io.File;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzan extends com.google.android.gms.internal.ads.zzau {
    private final Context context;

    public static com.google.android.gms.internal.ads.zzaf zzbl(Context context) {
        com.google.android.gms.internal.ads.zzaf zzafVar = new com.google.android.gms.internal.ads.zzaf(new com.google.android.gms.internal.ads.zzav(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzan(context, new com.google.android.gms.internal.ads.zzbd()));
        zzafVar.start();
        return zzafVar;
    }

    private zzan(Context context, com.google.android.gms.internal.ads.zzar zzarVar) {
        super(zzarVar);
        this.context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzau, com.google.android.gms.internal.ads.zzu
    public final com.google.android.gms.internal.ads.zzz zza(com.google.android.gms.internal.ads.zzab<?> zzabVar) {
        if (zzabVar.zzh() && zzabVar.getMethod() == 0) {
            if (Pattern.matches((String) zzww.zzra().zzd(zzabq.zzcvi), zzabVar.getUrl())) {
                zzww.zzqw();
                if (zzbae.zzf(this.context, 13400000)) {
                    com.google.android.gms.internal.ads.zzz zza = new zzajg(this.context).zza(zzabVar);
                    if (zza != null) {
                        String valueOf = String.valueOf(zzabVar.getUrl());
                        zzd.zzed(valueOf.length() != 0 ? "Got gmscore asset response: ".concat(valueOf) : new String("Got gmscore asset response: "));
                        return zza;
                    }
                    String valueOf2 = String.valueOf(zzabVar.getUrl());
                    zzd.zzed(valueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(valueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zza(zzabVar);
    }
}

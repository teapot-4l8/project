package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzatu;
import com.google.android.gms.internal.ads.zzaxo;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zza {
    private final Context context;
    private boolean zzbor;
    private zzaxo zzbos;
    private zzatu zzbot;

    public zza(Context context, zzaxo zzaxoVar, zzatu zzatuVar) {
        this.context = context;
        this.zzbos = zzaxoVar;
        this.zzbot = null;
        if (0 == 0) {
            this.zzbot = new zzatu();
        }
    }

    private final boolean zzkb() {
        zzaxo zzaxoVar = this.zzbos;
        return (zzaxoVar != null && zzaxoVar.zzxg().zzecb) || this.zzbot.zzdyl;
    }

    public final void recordClick() {
        this.zzbor = true;
    }

    public final boolean zzkc() {
        return !zzkb() || this.zzbor;
    }

    public final void zzbk(String str) {
        if (zzkb()) {
            if (str == null) {
                str = "";
            }
            zzaxo zzaxoVar = this.zzbos;
            if (zzaxoVar != null) {
                zzaxoVar.zza(str, null, 3);
            } else if (this.zzbot.zzdyl && this.zzbot.zzdym != null) {
                for (String str2 : this.zzbot.zzdym) {
                    if (!TextUtils.isEmpty(str2)) {
                        String replace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzr.zzkv();
                        com.google.android.gms.ads.internal.util.zzj.zzb(this.context, "", replace);
                    }
                }
            }
        }
    }
}

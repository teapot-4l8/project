package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdcp implements zzdhe<zzdcq> {
    private final Context context;
    private final zzazs zzbqn;
    private final zzdpm zzfzg;
    private final zzdhe<zzdhh> zzhdk;

    public zzdcp(zzddz<zzdhh> zzddzVar, zzdpm zzdpmVar, Context context, zzazs zzazsVar) {
        this.zzhdk = zzddzVar;
        this.zzfzg = zzdpmVar;
        this.context = context;
        this.zzbqn = zzazsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdcq> zzatu() {
        return zzebh.zzb(this.zzhdk.zzatu(), new zzdxw(this) { // from class: com.google.android.gms.internal.ads.zzdcs
            private final zzdcp zzhdp;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhdp = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj) {
                return this.zzhdp.zza((zzdhh) obj);
            }
        }, zzbat.zzekj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdcq zza(zzdhh zzdhhVar) {
        zzvt[] zzvtVarArr;
        String str;
        boolean z;
        String str2;
        float f;
        int i;
        int i2;
        zzvt[] zzvtVarArr2;
        int i3;
        int i4;
        int i5;
        DisplayMetrics displayMetrics;
        zzvt zzvtVar = this.zzfzg.zzbpy;
        if (zzvtVar.zzcis == null) {
            str = zzvtVar.zzadd;
            z = zzvtVar.zzcit;
        } else {
            str = null;
            boolean z2 = false;
            boolean z3 = false;
            z = false;
            for (zzvt zzvtVar2 : zzvtVar.zzcis) {
                if (!zzvtVar2.zzcit && !z2) {
                    str = zzvtVar2.zzadd;
                    z2 = true;
                }
                if (zzvtVar2.zzcit && !z3) {
                    z3 = true;
                    z = true;
                }
                if (z2 && z3) {
                    break;
                }
            }
        }
        Resources resources = this.context.getResources();
        if (resources == null || (displayMetrics = resources.getDisplayMetrics()) == null) {
            str2 = null;
            f = 0.0f;
            i = 0;
            i2 = 0;
        } else {
            float f2 = displayMetrics.density;
            int i6 = displayMetrics.widthPixels;
            i2 = displayMetrics.heightPixels;
            str2 = this.zzbqn.zzyl().zzzm();
            i = i6;
            f = f2;
        }
        StringBuilder sb = new StringBuilder();
        if (zzvtVar.zzcis != null) {
            boolean z4 = false;
            for (zzvt zzvtVar3 : zzvtVar.zzcis) {
                if (zzvtVar3.zzcit) {
                    z4 = true;
                } else {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    if (zzvtVar3.width == -1 && f != 0.0f) {
                        i4 = (int) (zzvtVar3.widthPixels / f);
                    } else {
                        i4 = zzvtVar3.width;
                    }
                    sb.append(i4);
                    sb.append("x");
                    if (zzvtVar3.height == -2 && f != 0.0f) {
                        i5 = (int) (zzvtVar3.heightPixels / f);
                        sb.append(i5);
                    }
                    i5 = zzvtVar3.height;
                    sb.append(i5);
                }
            }
            if (z4) {
                if (sb.length() != 0) {
                    i3 = 0;
                    sb.insert(0, "|");
                } else {
                    i3 = 0;
                }
                sb.insert(i3, "320x50");
            }
        }
        return new zzdcq(zzvtVar, str, z, sb.toString(), f, i, i2, str2, this.zzfzg.zzhdn);
    }
}

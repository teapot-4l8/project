package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzbsh;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdlk<R extends zzbsh<AdT>, AdT extends zzbpc> implements zzdmh<R, zzdrj<AdT>> {
    private final Executor executor = zzebv.zzbbe();
    private R zzhju;

    @Override // com.google.android.gms.internal.ads.zzdmh
    public final zzebt<zzdrj<AdT>> zza(zzdmm zzdmmVar, zzdmj<R> zzdmjVar) {
        zzebt<zzdpi> zzalu;
        zzbsg<R> zzc = zzdmjVar.zzc(zzdmmVar.zzhku);
        zzc.zza(new zzdmp(true));
        R zzahg = zzc.zzahg();
        this.zzhju = zzahg;
        final zzbqd zzahd = zzahg.zzahd();
        final zzdrj zzdrjVar = new zzdrj();
        if (zzdmmVar.zzhkt != null) {
            zzalu = zzahd.zza(zzdmmVar.zzhkt);
        } else {
            zzalu = zzahd.zzalu();
        }
        return zzebc.zzg(zzalu).zzb(new zzear(this, zzdrjVar, zzahd) { // from class: com.google.android.gms.internal.ads.zzdlj
            private final zzdlk zzhjr;
            private final zzdrj zzhjs;
            private final zzbqd zzhjt;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhjr = this;
                this.zzhjs = zzdrjVar;
                this.zzhjt = zzahd;
            }

            @Override // com.google.android.gms.internal.ads.zzear
            public final zzebt zzf(Object obj) {
                zzdrj zzdrjVar2 = this.zzhjs;
                zzbqd zzbqdVar = this.zzhjt;
                zzdpi zzdpiVar = (zzdpi) obj;
                zzdrjVar2.zzfbh = zzdpiVar;
                Iterator<zzdot> it = zzdpiVar.zzhnt.zzhnq.iterator();
                boolean z = false;
                boolean z2 = false;
                loop0: while (true) {
                    if (!it.hasNext()) {
                        z = z2;
                        break;
                    }
                    for (String str : it.next().zzhly) {
                        if (!str.contains("FirstPartyRenderer")) {
                            break loop0;
                        }
                        z2 = true;
                    }
                }
                if (!z) {
                    return zzebh.zzag(null);
                }
                return zzbqdVar.zzb(zzebh.zzag(zzdpiVar));
            }
        }, this.executor).zza(new zzdxw(zzdrjVar) { // from class: com.google.android.gms.internal.ads.zzdlm
            private final zzdrj zzhjy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhjy = zzdrjVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdxw
            public final Object apply(Object obj) {
                zzdrj zzdrjVar2 = this.zzhjy;
                zzdrjVar2.zzhrk = (AdT) obj;
                return zzdrjVar2;
            }
        }, this.executor);
    }

    @Override // com.google.android.gms.internal.ads.zzdmh
    public final /* synthetic */ Object zzavm() {
        return this.zzhju;
    }
}

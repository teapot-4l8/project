package com.google.android.gms.internal.ads;

import android.net.Uri;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzmv implements zzpb {
    private final Uri uri;
    private final zzon zzaoz;
    private final /* synthetic */ zzms zzbdv;
    private final zzmy zzbed;
    private final zzpi zzbee;
    private volatile boolean zzbey;
    private long zzbfa;
    private final zzkg zzbex = new zzkg();
    private boolean zzbez = true;
    private long zzco = -1;

    public zzmv(zzms zzmsVar, Uri uri, zzon zzonVar, zzmy zzmyVar, zzpi zzpiVar) {
        this.zzbdv = zzmsVar;
        this.uri = (Uri) zzpg.checkNotNull(uri);
        this.zzaoz = (zzon) zzpg.checkNotNull(zzonVar);
        this.zzbed = (zzmy) zzpg.checkNotNull(zzmyVar);
        this.zzbee = zzpiVar;
    }

    public final void zze(long j, long j2) {
        this.zzbex.position = j;
        this.zzbfa = j2;
        this.zzbez = true;
    }

    @Override // com.google.android.gms.internal.ads.zzpb
    public final void cancelLoad() {
        this.zzbey = true;
    }

    @Override // com.google.android.gms.internal.ads.zzpb
    public final boolean zzib() {
        return this.zzbey;
    }

    @Override // com.google.android.gms.internal.ads.zzpb
    public final void zzic() {
        int i = 0;
        while (i == 0 && !this.zzbey) {
            zzjx zzjxVar = null;
            try {
                long j = this.zzbex.position;
                long zza = this.zzaoz.zza(new zzos(this.uri, j, -1L, zzms.zzf(this.zzbdv)));
                this.zzco = zza;
                if (zza != -1) {
                    this.zzco = zza + j;
                }
                zzjx zzjxVar2 = new zzjx(this.zzaoz, j, this.zzco);
                try {
                    zzka zza2 = this.zzbed.zza(zzjxVar2, this.zzaoz.getUri());
                    if (this.zzbez) {
                        zza2.zzc(j, this.zzbfa);
                        this.zzbez = false;
                    }
                    while (i == 0 && !this.zzbey) {
                        this.zzbee.block();
                        i = zza2.zza(zzjxVar2, this.zzbex);
                        if (zzjxVar2.getPosition() > zzms.zzg(this.zzbdv) + j) {
                            j = zzjxVar2.getPosition();
                            this.zzbee.zziy();
                            zzms.zzi(this.zzbdv).post(zzms.zzh(this.zzbdv));
                        }
                    }
                    if (i == 1) {
                        i = 0;
                    } else {
                        this.zzbex.position = zzjxVar2.getPosition();
                    }
                    zzpt.zza(this.zzaoz);
                } catch (Throwable th) {
                    th = th;
                    zzjxVar = zzjxVar2;
                    if (i != 1 && zzjxVar != null) {
                        this.zzbex.position = zzjxVar.getPosition();
                    }
                    zzpt.zza(this.zzaoz);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }
}

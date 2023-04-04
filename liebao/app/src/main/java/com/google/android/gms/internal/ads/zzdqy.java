package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzuh;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzdqy implements zzdqz {
    private final ConcurrentHashMap<zzdri, zzdqw> zzhqa;
    private zzdrc zzhqb;
    private zzdra zzhqc = new zzdra();

    public zzdqy(zzdrc zzdrcVar) {
        this.zzhqa = new ConcurrentHashMap<>(zzdrcVar.zzhqq);
        this.zzhqb = zzdrcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdqz
    public final synchronized zzdrj<?> zza(zzdri zzdriVar) {
        zzdrj<?> zzdrjVar;
        zzdqw zzdqwVar = this.zzhqa.get(zzdriVar);
        zzdrjVar = null;
        if (zzdqwVar != null) {
            zzdrjVar = zzdqwVar.zzawo();
            if (zzdrjVar == null) {
                this.zzhqc.zzawx();
            }
            zza(zzdrjVar, zzdqwVar.zzaws());
        } else {
            this.zzhqc.zzaww();
            zza((zzdrj<?>) null, (zzdry) null);
        }
        return zzdrjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdqz
    public final synchronized boolean zza(zzdri zzdriVar, zzdrj<?> zzdrjVar) {
        boolean zzb;
        zzdqw zzdqwVar = this.zzhqa.get(zzdriVar);
        zzdrjVar.zzhrl = com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis();
        if (zzdqwVar == null) {
            zzdqwVar = new zzdqw(this.zzhqb.zzhqq, this.zzhqb.zzhqr * 1000);
            if (this.zzhqa.size() == this.zzhqb.zzhqp) {
                int i = zzdrb.zzhqj[this.zzhqb.zzhqu - 1];
                long j = Long.MAX_VALUE;
                zzdri zzdriVar2 = null;
                if (i == 1) {
                    for (Map.Entry<zzdri, zzdqw> entry : this.zzhqa.entrySet()) {
                        if (entry.getValue().getCreationTimeMillis() < j) {
                            j = entry.getValue().getCreationTimeMillis();
                            zzdriVar2 = entry.getKey();
                        }
                    }
                    if (zzdriVar2 != null) {
                        this.zzhqa.remove(zzdriVar2);
                    }
                } else if (i == 2) {
                    for (Map.Entry<zzdri, zzdqw> entry2 : this.zzhqa.entrySet()) {
                        if (entry2.getValue().zzawp() < j) {
                            j = entry2.getValue().zzawp();
                            zzdriVar2 = entry2.getKey();
                        }
                    }
                    if (zzdriVar2 != null) {
                        this.zzhqa.remove(zzdriVar2);
                    }
                } else if (i == 3) {
                    int i2 = Integer.MAX_VALUE;
                    for (Map.Entry<zzdri, zzdqw> entry3 : this.zzhqa.entrySet()) {
                        if (entry3.getValue().zzawq() < i2) {
                            i2 = entry3.getValue().zzawq();
                            zzdriVar2 = entry3.getKey();
                        }
                    }
                    if (zzdriVar2 != null) {
                        this.zzhqa.remove(zzdriVar2);
                    }
                }
                this.zzhqc.zzawz();
            }
            this.zzhqa.put(zzdriVar, zzdqwVar);
            this.zzhqc.zzawy();
        }
        zzb = zzdqwVar.zzb(zzdrjVar);
        this.zzhqc.zzaxa();
        zzdrd zzaxb = this.zzhqc.zzaxb();
        zzdry zzaws = zzdqwVar.zzaws();
        if (zzdrjVar != null) {
            zzdrjVar.zzhrj.zzalw().zzd((zzuh.zzb) ((zzena) zzuh.zzb.zznt().zza(zzuh.zzb.zza.zznr().zzb(zzuh.zzb.zzc.IN_MEMORY).zza(zzuh.zzb.zze.zznx().zzv(zzaxb.zzhqx).zzw(zzaxb.zzhqy).zzcd(zzaws.zzhsg))).zzbjv()));
        }
        dumpToLog();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdqz
    public final synchronized boolean zzb(zzdri zzdriVar) {
        zzdqw zzdqwVar = this.zzhqa.get(zzdriVar);
        if (zzdqwVar != null) {
            return zzdqwVar.size() < this.zzhqb.zzhqq;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdqz
    @Deprecated
    public final zzdri zza(zzvq zzvqVar, String str, zzwc zzwcVar) {
        return new zzdrl(zzvqVar, str, new zzaur(this.zzhqb.context).zzxd().zzdzl, this.zzhqb.zzhqs, zzwcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdqz
    public final zzdrc zzawv() {
        return this.zzhqb;
    }

    private final void zza(zzdrj<?> zzdrjVar, zzdry zzdryVar) {
        if (zzdrjVar != null) {
            zzdrjVar.zzhrj.zzalw().zzc((zzuh.zzb) ((zzena) zzuh.zzb.zznt().zza(zzuh.zzb.zza.zznr().zzb(zzuh.zzb.zzc.IN_MEMORY).zza(zzuh.zzb.zzd.zznv().zzu(zzdryVar.zzhsf).zzcc(zzdryVar.zzhsg))).zzbjv()));
        }
        dumpToLog();
    }

    private final void dumpToLog() {
        if (zzdrc.zzaxd()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzhqb.zzhqo);
            sb.append(" PoolCollection");
            sb.append(this.zzhqc.zzaxc());
            int i = 0;
            for (Map.Entry<zzdri, zzdqw> entry : this.zzhqa.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(entry.getKey().hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < entry.getValue().size(); i2++) {
                    sb.append("[O]");
                }
                for (int size = entry.getValue().size(); size < this.zzhqb.zzhqq; size++) {
                    sb.append("[ ]");
                }
                sb.append("\n");
                sb.append(entry.getValue().zzawr());
                sb.append("\n");
            }
            while (i < this.zzhqb.zzhqp) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            com.google.android.gms.ads.internal.util.zzd.zzdz(sb.toString());
        }
    }
}

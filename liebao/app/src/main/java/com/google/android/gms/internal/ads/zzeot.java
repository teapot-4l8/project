package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzeot<T> implements zzepi<T> {
    private final zzeon zzivy;
    private final boolean zzivz;
    private final zzeqa<?, ?> zziwi;
    private final zzemp<?> zziwj;

    private zzeot(zzeqa<?, ?> zzeqaVar, zzemp<?> zzempVar, zzeon zzeonVar) {
        this.zziwi = zzeqaVar;
        this.zzivz = zzempVar.zzj(zzeonVar);
        this.zziwj = zzempVar;
        this.zzivy = zzeonVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzeot<T> zza(zzeqa<?, ?> zzeqaVar, zzemp<?> zzempVar, zzeon zzeonVar) {
        return new zzeot<>(zzeqaVar, zzempVar, zzeonVar);
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final T newInstance() {
        return (T) this.zzivy.zzbjo().zzbju();
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final boolean equals(T t, T t2) {
        if (this.zziwi.zzay(t).equals(this.zziwi.zzay(t2))) {
            if (this.zzivz) {
                return this.zziwj.zzai(t).equals(this.zziwj.zzai(t2));
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final int hashCode(T t) {
        int hashCode = this.zziwi.zzay(t).hashCode();
        return this.zzivz ? (hashCode * 53) + this.zziwj.zzai(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zzg(T t, T t2) {
        zzepk.zza(this.zziwi, t, t2);
        if (this.zzivz) {
            zzepk.zza(this.zziwj, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza(T t, zzeqx zzeqxVar) {
        Iterator<Map.Entry<?, Object>> it = this.zziwj.zzai(t).iterator();
        while (it.hasNext()) {
            Map.Entry<?, Object> next = it.next();
            zzemv zzemvVar = (zzemv) next.getKey();
            if (zzemvVar.zzbjd() != zzequ.MESSAGE || zzemvVar.zzbje() || zzemvVar.zzbjf()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof zzenq) {
                zzeqxVar.zzc(zzemvVar.zzv(), ((zzenq) next).zzbkk().zzbgy());
            } else {
                zzeqxVar.zzc(zzemvVar.zzv(), next.getValue());
            }
        }
        zzeqa<?, ?> zzeqaVar = this.zziwi;
        zzeqaVar.zzc(zzeqaVar.zzay(t), zzeqxVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099 A[EDGE_INSN: B:58:0x0099->B:34:0x0099 ?: BREAK  , SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzepi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, byte[] bArr, int i, int i2, zzell zzellVar) {
        zzena zzenaVar = (zzena) t;
        zzeqd zzeqdVar = zzenaVar.zzitn;
        if (zzeqdVar == zzeqd.zzbly()) {
            zzeqdVar = zzeqd.zzblz();
            zzenaVar.zzitn = zzeqdVar;
        }
        ((zzena.zzd) t).zzbjw();
        zzena.zzf zzfVar = null;
        while (i < i2) {
            int zza = zzelm.zza(bArr, i, zzellVar);
            int i3 = zzellVar.zziov;
            if (i3 == 11) {
                int i4 = 0;
                zzelq zzelqVar = null;
                while (zza < i2) {
                    zza = zzelm.zza(bArr, zza, zzellVar);
                    int i5 = zzellVar.zziov;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzfVar != null) {
                                zzepb.zzble();
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                zza = zzelm.zze(bArr, zza, zzellVar);
                                zzelqVar = (zzelq) zzellVar.zziox;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        }
                        zza = zzelm.zza(i5, bArr, zza, i2, zzellVar);
                    } else if (i7 == 0) {
                        zza = zzelm.zza(bArr, zza, zzellVar);
                        i4 = zzellVar.zziov;
                        zzfVar = (zzena.zzf) this.zziwj.zza(zzellVar.zzioy, this.zzivy, i4);
                    } else if (i5 != 12) {
                    }
                }
                if (zzelqVar != null) {
                    zzeqdVar.zzd((i4 << 3) | 2, zzelqVar);
                }
                i = zza;
            } else if ((i3 & 7) == 2) {
                zzfVar = (zzena.zzf) this.zziwj.zza(zzellVar.zzioy, this.zzivy, i3 >>> 3);
                if (zzfVar != null) {
                    zzepb.zzble();
                    throw new NoSuchMethodError();
                }
                i = zzelm.zza(i3, bArr, zza, i2, zzeqdVar, zzellVar);
            } else {
                i = zzelm.zza(i3, bArr, zza, i2, zzellVar);
            }
        }
        if (i != i2) {
            throw zzenn.zzbkg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zza(T t, zzepc zzepcVar, zzemn zzemnVar) {
        boolean z;
        zzeqa<?, ?> zzeqaVar = this.zziwi;
        zzemp<?> zzempVar = this.zziwj;
        Object zzaz = zzeqaVar.zzaz(t);
        zzemt<?> zzaj = zzempVar.zzaj(t);
        do {
            try {
                if (zzepcVar.zzbip() == Integer.MAX_VALUE) {
                    return;
                }
                int tag = zzepcVar.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzelq zzelqVar = null;
                    while (zzepcVar.zzbip() != Integer.MAX_VALUE) {
                        int tag2 = zzepcVar.getTag();
                        if (tag2 == 16) {
                            i = zzepcVar.zzbia();
                            obj = zzempVar.zza(zzemnVar, this.zzivy, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzempVar.zza(zzepcVar, obj, zzemnVar, zzaj);
                            } else {
                                zzelqVar = zzepcVar.zzbhz();
                            }
                        } else if (!zzepcVar.zzbiq()) {
                            break;
                        }
                    }
                    if (zzepcVar.getTag() != 12) {
                        throw zzenn.zzbkd();
                    } else if (zzelqVar != null) {
                        if (obj != null) {
                            zzempVar.zza(zzelqVar, obj, zzemnVar, zzaj);
                        } else {
                            zzeqaVar.zza((zzeqa<?, ?>) zzaz, i, zzelqVar);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzempVar.zza(zzemnVar, this.zzivy, tag >>> 3);
                    if (zza != null) {
                        zzempVar.zza(zzepcVar, zza, zzemnVar, zzaj);
                    } else {
                        z = zzeqaVar.zza((zzeqa<?, ?>) zzaz, zzepcVar);
                        continue;
                    }
                } else {
                    z = zzepcVar.zzbiq();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzeqaVar.zzj(t, zzaz);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final void zzak(T t) {
        this.zziwi.zzak(t);
        this.zziwj.zzak(t);
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final boolean zzaw(T t) {
        return this.zziwj.zzai(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.ads.zzepi
    public final int zzau(T t) {
        zzeqa<?, ?> zzeqaVar = this.zziwi;
        int zzba = zzeqaVar.zzba(zzeqaVar.zzay(t)) + 0;
        return this.zzivz ? zzba + this.zziwj.zzai(t).zzbjb() : zzba;
    }
}

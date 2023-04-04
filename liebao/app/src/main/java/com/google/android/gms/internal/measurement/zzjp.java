package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhy;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
final class zzjp<T> implements zzkb<T> {
    private final zzjj zza;
    private final zzkt<?, ?> zzb;
    private final boolean zzc;
    private final zzhn<?> zzd;

    private zzjp(zzkt<?, ?> zzktVar, zzhn<?> zzhnVar, zzjj zzjjVar) {
        this.zzb = zzktVar;
        this.zzc = zzhnVar.zza(zzjjVar);
        this.zzd = zzhnVar;
        this.zza = zzjjVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> zzjp<T> zza(zzkt<?, ?> zzktVar, zzhn<?> zzhnVar, zzjj zzjjVar) {
        return new zzjp<>(zzktVar, zzhnVar, zzjjVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final T zza() {
        return (T) this.zza.zzbu().zzx();
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final boolean zza(T t, T t2) {
        if (this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            if (this.zzc) {
                return this.zzd.zza(t).equals(this.zzd.zza(t2));
            }
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zzb(T t, T t2) {
        zzkd.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzkd.zza(this.zzd, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zza(T t, zzlm zzlmVar) {
        Iterator<Map.Entry<?, Object>> zzd = this.zzd.zza(t).zzd();
        while (zzd.hasNext()) {
            Map.Entry<?, Object> next = zzd.next();
            zzht zzhtVar = (zzht) next.getKey();
            if (zzhtVar.zzc() != zzln.MESSAGE || zzhtVar.zzd() || zzhtVar.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof zzim) {
                zzlmVar.zza(zzhtVar.zza(), (Object) ((zzim) next).zza().zzc());
            } else {
                zzlmVar.zza(zzhtVar.zza(), next.getValue());
            }
        }
        zzkt<?, ?> zzktVar = this.zzb;
        zzktVar.zzb((zzkt<?, ?>) zzktVar.zzb(t), zzlmVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099 A[EDGE_INSN: B:58:0x0099->B:34:0x0099 ?: BREAK  , SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.zzkb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, byte[] bArr, int i, int i2, zzgo zzgoVar) {
        zzhy zzhyVar = (zzhy) t;
        zzks zzksVar = zzhyVar.zzb;
        if (zzksVar == zzks.zza()) {
            zzksVar = zzks.zzb();
            zzhyVar.zzb = zzksVar;
        }
        ((zzhy.zzd) t).zza();
        zzhy.zzf zzfVar = null;
        while (i < i2) {
            int zza = zzgl.zza(bArr, i, zzgoVar);
            int i3 = zzgoVar.zza;
            if (i3 == 11) {
                int i4 = 0;
                zzgp zzgpVar = null;
                while (zza < i2) {
                    zza = zzgl.zza(bArr, zza, zzgoVar);
                    int i5 = zzgoVar.zza;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3) {
                            if (zzfVar != null) {
                                zzjx.zza();
                                throw new NoSuchMethodError();
                            } else if (i7 == 2) {
                                zza = zzgl.zze(bArr, zza, zzgoVar);
                                zzgpVar = (zzgp) zzgoVar.zzc;
                            }
                        }
                        if (i5 != 12) {
                            break;
                        }
                        zza = zzgl.zza(i5, bArr, zza, i2, zzgoVar);
                    } else if (i7 == 0) {
                        zza = zzgl.zza(bArr, zza, zzgoVar);
                        i4 = zzgoVar.zza;
                        zzfVar = (zzhy.zzf) this.zzd.zza(zzgoVar.zzd, this.zza, i4);
                    } else if (i5 != 12) {
                    }
                }
                if (zzgpVar != null) {
                    zzksVar.zza((i4 << 3) | 2, zzgpVar);
                }
                i = zza;
            } else if ((i3 & 7) == 2) {
                zzfVar = (zzhy.zzf) this.zzd.zza(zzgoVar.zzd, this.zza, i3 >>> 3);
                if (zzfVar != null) {
                    zzjx.zza();
                    throw new NoSuchMethodError();
                }
                i = zzgl.zza(i3, bArr, zza, i2, zzksVar, zzgoVar);
            } else {
                i = zzgl.zza(i3, bArr, zza, i2, zzgoVar);
            }
        }
        if (i != i2) {
            throw zzij.zzg();
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zza(T t, zzjy zzjyVar, zzhl zzhlVar) {
        boolean z;
        zzkt<?, ?> zzktVar = this.zzb;
        zzhn<?> zzhnVar = this.zzd;
        Object zzc = zzktVar.zzc(t);
        zzhr<?> zzb = zzhnVar.zzb(t);
        do {
            try {
                if (zzjyVar.zza() == Integer.MAX_VALUE) {
                    return;
                }
                int zzb2 = zzjyVar.zzb();
                if (zzb2 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzgp zzgpVar = null;
                    while (zzjyVar.zza() != Integer.MAX_VALUE) {
                        int zzb3 = zzjyVar.zzb();
                        if (zzb3 == 16) {
                            i = zzjyVar.zzo();
                            obj = zzhnVar.zza(zzhlVar, this.zza, i);
                        } else if (zzb3 == 26) {
                            if (obj != null) {
                                zzhnVar.zza(zzjyVar, obj, zzhlVar, zzb);
                            } else {
                                zzgpVar = zzjyVar.zzn();
                            }
                        } else if (!zzjyVar.zzc()) {
                            break;
                        }
                    }
                    if (zzjyVar.zzb() != 12) {
                        throw zzij.zze();
                    } else if (zzgpVar != null) {
                        if (obj != null) {
                            zzhnVar.zza(zzgpVar, obj, zzhlVar, zzb);
                        } else {
                            zzktVar.zza((zzkt<?, ?>) zzc, i, zzgpVar);
                        }
                    }
                } else if ((zzb2 & 7) == 2) {
                    Object zza = zzhnVar.zza(zzhlVar, this.zza, zzb2 >>> 3);
                    if (zza != null) {
                        zzhnVar.zza(zzjyVar, zza, zzhlVar, zzb);
                    } else {
                        z = zzktVar.zza((zzkt<?, ?>) zzc, zzjyVar);
                        continue;
                    }
                } else {
                    z = zzjyVar.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzktVar.zzb((Object) t, (T) zzc);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final boolean zzd(T t) {
        return this.zzd.zza(t).zzf();
    }

    @Override // com.google.android.gms.internal.measurement.zzkb
    public final int zzb(T t) {
        zzkt<?, ?> zzktVar = this.zzb;
        int zze = zzktVar.zze(zzktVar.zzb(t)) + 0;
        return this.zzc ? zze + this.zzd.zza(t).zzg() : zze;
    }
}

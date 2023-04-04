package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzrn {
    private int zzbtj;
    private final Object lock = new Object();
    private List<zzrk> zzbtk = new LinkedList();

    public final zzrk zzp(boolean z) {
        synchronized (this.lock) {
            zzrk zzrkVar = null;
            if (this.zzbtk.size() == 0) {
                com.google.android.gms.ads.internal.util.zzd.zzdz("Queue empty");
                return null;
            }
            int i = 0;
            if (this.zzbtk.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                int i3 = 0;
                for (zzrk zzrkVar2 : this.zzbtk) {
                    int score = zzrkVar2.getScore();
                    if (score > i2) {
                        i = i3;
                        zzrkVar = zzrkVar2;
                        i2 = score;
                    }
                    i3++;
                }
                this.zzbtk.remove(i);
                return zzrkVar;
            }
            zzrk zzrkVar3 = this.zzbtk.get(0);
            if (z) {
                this.zzbtk.remove(0);
            } else {
                zzrkVar3.zzmi();
            }
            return zzrkVar3;
        }
    }

    public final boolean zza(zzrk zzrkVar) {
        synchronized (this.lock) {
            return this.zzbtk.contains(zzrkVar);
        }
    }

    public final boolean zzb(zzrk zzrkVar) {
        synchronized (this.lock) {
            Iterator<zzrk> it = this.zzbtk.iterator();
            while (it.hasNext()) {
                zzrk next = it.next();
                if (!com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzb()) {
                    if (zzrkVar != next && next.zzmf().equals(zzrkVar.zzmf())) {
                        it.remove();
                        return true;
                    }
                } else if (!com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzd() && zzrkVar != next && next.zzmh().equals(zzrkVar.zzmh())) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }
    }

    public final void zzc(zzrk zzrkVar) {
        synchronized (this.lock) {
            if (this.zzbtk.size() >= 10) {
                int size = this.zzbtk.size();
                StringBuilder sb = new StringBuilder(41);
                sb.append("Queue is full, current size = ");
                sb.append(size);
                com.google.android.gms.ads.internal.util.zzd.zzdz(sb.toString());
                this.zzbtk.remove(0);
            }
            int i = this.zzbtj;
            this.zzbtj = i + 1;
            zzrkVar.zzbw(i);
            zzrkVar.zzml();
            this.zzbtk.add(zzrkVar);
        }
    }
}

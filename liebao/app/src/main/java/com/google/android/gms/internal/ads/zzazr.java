package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzazr {
    private final Clock zzbqq;
    private final String zzdvz;
    private final zzbac zzedz;
    private final String zzeeb;
    private final Object lock = new Object();
    private long zzdxm = -1;
    private long zzeec = -1;
    private boolean zzdxi = false;
    private long zzeed = -1;
    private long zzeee = 0;
    private long zzeef = -1;
    private long zzeeg = -1;
    private final LinkedList<zzazq> zzeea = new LinkedList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazr(Clock clock, zzbac zzbacVar, String str, String str2) {
        this.zzbqq = clock;
        this.zzedz = zzbacVar;
        this.zzeeb = str;
        this.zzdvz = str2;
    }

    public final void zze(zzvq zzvqVar) {
        synchronized (this.lock) {
            long elapsedRealtime = this.zzbqq.elapsedRealtime();
            this.zzeef = elapsedRealtime;
            this.zzedz.zza(zzvqVar, elapsedRealtime);
        }
    }

    public final void zzey(long j) {
        synchronized (this.lock) {
            this.zzeeg = j;
            if (j != -1) {
                this.zzedz.zzb(this);
            }
        }
    }

    public final void zzyb() {
        synchronized (this.lock) {
            if (this.zzeeg != -1 && this.zzeec == -1) {
                this.zzeec = this.zzbqq.elapsedRealtime();
                this.zzedz.zzb(this);
            }
            this.zzedz.zzyb();
        }
    }

    public final void zzyc() {
        synchronized (this.lock) {
            if (this.zzeeg != -1) {
                zzazq zzazqVar = new zzazq(this);
                zzazqVar.zzya();
                this.zzeea.add(zzazqVar);
                this.zzeee++;
                this.zzedz.zzyc();
                this.zzedz.zzb(this);
            }
        }
    }

    public final void zzyd() {
        synchronized (this.lock) {
            if (this.zzeeg != -1 && !this.zzeea.isEmpty()) {
                zzazq last = this.zzeea.getLast();
                if (last.zzxy() == -1) {
                    last.zzxz();
                    this.zzedz.zzb(this);
                }
            }
        }
    }

    public final void zzar(boolean z) {
        synchronized (this.lock) {
            if (this.zzeeg != -1) {
                this.zzeed = this.zzbqq.elapsedRealtime();
            }
        }
    }

    public final Bundle toBundle() {
        Bundle bundle;
        synchronized (this.lock) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzeeb);
            bundle.putString("slotid", this.zzdvz);
            bundle.putBoolean("ismediation", false);
            bundle.putLong("treq", this.zzeef);
            bundle.putLong("tresponse", this.zzeeg);
            bundle.putLong("timp", this.zzeec);
            bundle.putLong("tload", this.zzeed);
            bundle.putLong("pcc", this.zzeee);
            bundle.putLong("tfetch", this.zzdxm);
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            Iterator<zzazq> it = this.zzeea.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public final String zzye() {
        return this.zzeeb;
    }
}

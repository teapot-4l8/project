package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbac implements zzrr {
    private final com.google.android.gms.ads.internal.util.zzf zzecl;
    private final zzazz zzefp;
    private final Object lock = new Object();
    private final HashSet<zzazr> zzefq = new HashSet<>();
    private final HashSet<zzbaa> zzefr = new HashSet<>();
    private boolean zzefs = false;
    private final zzbab zzefo = new zzbab();

    public zzbac(String str, com.google.android.gms.ads.internal.util.zzf zzfVar) {
        this.zzefp = new zzazz(str, zzfVar);
        this.zzecl = zzfVar;
    }

    public final void zzb(zzazr zzazrVar) {
        synchronized (this.lock) {
            this.zzefq.add(zzazrVar);
        }
    }

    public final void zzb(HashSet<zzazr> hashSet) {
        synchronized (this.lock) {
            this.zzefq.addAll(hashSet);
        }
    }

    public final Bundle zza(Context context, zzazy zzazyVar) {
        HashSet<zzazr> hashSet = new HashSet<>();
        synchronized (this.lock) {
            hashSet.addAll(this.zzefq);
            this.zzefq.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zzefp.zzn(context, this.zzefo.zzyw()));
        Bundle bundle2 = new Bundle();
        Iterator<zzbaa> it = this.zzefr.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NoSuchMethodError();
        }
        bundle.putBundle("slots", bundle2);
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        Iterator<zzazr> it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().toBundle());
        }
        bundle.putParcelableArrayList("ads", arrayList);
        zzazyVar.zza(hashSet);
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzrr
    public final void zzq(boolean z) {
        long currentTimeMillis = com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zzecl.zzzh() > ((Long) zzww.zzra().zzd(zzabq.zzcqb)).longValue()) {
                this.zzefp.zzefg = -1;
            } else {
                this.zzefp.zzefg = this.zzecl.zzzi();
            }
            this.zzefs = true;
            return;
        }
        this.zzecl.zzfa(currentTimeMillis);
        this.zzecl.zzdj(this.zzefp.zzefg);
    }

    public final void zzyc() {
        synchronized (this.lock) {
            this.zzefp.zzyc();
        }
    }

    public final void zzyb() {
        synchronized (this.lock) {
            this.zzefp.zzyb();
        }
    }

    public final void zza(zzvq zzvqVar, long j) {
        synchronized (this.lock) {
            this.zzefp.zza(zzvqVar, j);
        }
    }

    public final zzazr zza(Clock clock, String str) {
        return new zzazr(clock, this, this.zzefo.zzyv(), str);
    }

    public final boolean zzyy() {
        return this.zzefs;
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.common.util.Clock;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzbxr {
    private final zzdmi zzfyo;
    private final Set<zzbzl<zzve>> zzgcn;
    private final Set<zzbzl<zzbsy>> zzgco;
    private final Set<zzbzl<zzbtq>> zzgcp;
    private final Set<zzbzl<zzbus>> zzgcq;
    private final Set<zzbzl<zzbuj>> zzgcr;
    private final Set<zzbzl<zzbsz>> zzgcs;
    private final Set<zzbzl<zzbtm>> zzgct;
    private final Set<zzbzl<AdMetadataListener>> zzgcu;
    private final Set<zzbzl<AppEventListener>> zzgcv;
    private final Set<zzbzl<zzbvb>> zzgcw;
    private final Set<zzbzl<com.google.android.gms.ads.internal.overlay.zzp>> zzgcx;
    private final Set<zzbzl<zzbvm>> zzgcy;
    private zzbsx zzgcz;
    private zzcwk zzgda;

    private zzbxr(zza zzaVar) {
        this.zzgcn = zzaVar.zzgcn;
        this.zzgcp = zzaVar.zzgcp;
        this.zzgcq = zzaVar.zzgcq;
        this.zzgco = zzaVar.zzgco;
        this.zzgcr = zzaVar.zzgcr;
        this.zzgcs = zzaVar.zzgcs;
        this.zzgct = zzaVar.zzgct;
        this.zzgcu = zzaVar.zzgcu;
        this.zzgcv = zzaVar.zzgcv;
        this.zzgcw = zzaVar.zzgdb;
        this.zzfyo = zzaVar.zzfyo;
        this.zzgcx = zzaVar.zzgcx;
        this.zzgcy = zzaVar.zzgcy;
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static class zza {
        private zzdmi zzfyo;
        private Set<zzbzl<zzbvm>> zzgcy = new HashSet();
        private Set<zzbzl<zzve>> zzgcn = new HashSet();
        private Set<zzbzl<zzbsy>> zzgco = new HashSet();
        private Set<zzbzl<zzbtq>> zzgcp = new HashSet();
        private Set<zzbzl<zzbus>> zzgcq = new HashSet();
        private Set<zzbzl<zzbuj>> zzgcr = new HashSet();
        private Set<zzbzl<zzbsz>> zzgcs = new HashSet();
        private Set<zzbzl<AdMetadataListener>> zzgcu = new HashSet();
        private Set<zzbzl<AppEventListener>> zzgcv = new HashSet();
        private Set<zzbzl<zzbtm>> zzgct = new HashSet();
        private Set<zzbzl<zzbvb>> zzgdb = new HashSet();
        private Set<zzbzl<com.google.android.gms.ads.internal.overlay.zzp>> zzgcx = new HashSet();

        public final zza zza(zzbsy zzbsyVar, Executor executor) {
            this.zzgco.add(new zzbzl<>(zzbsyVar, executor));
            return this;
        }

        public final zza zza(zzbuj zzbujVar, Executor executor) {
            this.zzgcr.add(new zzbzl<>(zzbujVar, executor));
            return this;
        }

        public final zza zza(zzbsz zzbszVar, Executor executor) {
            this.zzgcs.add(new zzbzl<>(zzbszVar, executor));
            return this;
        }

        public final zza zza(zzbtm zzbtmVar, Executor executor) {
            this.zzgct.add(new zzbzl<>(zzbtmVar, executor));
            return this;
        }

        public final zza zza(AppEventListener appEventListener, Executor executor) {
            this.zzgcv.add(new zzbzl<>(appEventListener, executor));
            return this;
        }

        public final zza zza(zzve zzveVar, Executor executor) {
            this.zzgcn.add(new zzbzl<>(zzveVar, executor));
            return this;
        }

        public final zza zza(zzbtq zzbtqVar, Executor executor) {
            this.zzgcp.add(new zzbzl<>(zzbtqVar, executor));
            return this;
        }

        public final zza zza(zzbus zzbusVar, Executor executor) {
            this.zzgcq.add(new zzbzl<>(zzbusVar, executor));
            return this;
        }

        public final zza zza(com.google.android.gms.ads.internal.overlay.zzp zzpVar, Executor executor) {
            this.zzgcx.add(new zzbzl<>(zzpVar, executor));
            return this;
        }

        public final zza zza(zzbvb zzbvbVar, Executor executor) {
            this.zzgdb.add(new zzbzl<>(zzbvbVar, executor));
            return this;
        }

        public final zza zza(zzdmi zzdmiVar) {
            this.zzfyo = zzdmiVar;
            return this;
        }

        public final zza zza(zzbvm zzbvmVar, Executor executor) {
            this.zzgcy.add(new zzbzl<>(zzbvmVar, executor));
            return this;
        }

        public final zzbxr zzanf() {
            return new zzbxr(this);
        }
    }

    public final Set<zzbzl<zzbsy>> zzams() {
        return this.zzgco;
    }

    public final Set<zzbzl<zzbuj>> zzamt() {
        return this.zzgcr;
    }

    public final Set<zzbzl<zzbsz>> zzamu() {
        return this.zzgcs;
    }

    public final Set<zzbzl<zzbtm>> zzamv() {
        return this.zzgct;
    }

    public final Set<zzbzl<AdMetadataListener>> zzamw() {
        return this.zzgcu;
    }

    public final Set<zzbzl<AppEventListener>> zzamx() {
        return this.zzgcv;
    }

    public final Set<zzbzl<zzve>> zzamy() {
        return this.zzgcn;
    }

    public final Set<zzbzl<zzbtq>> zzamz() {
        return this.zzgcp;
    }

    public final Set<zzbzl<zzbus>> zzana() {
        return this.zzgcq;
    }

    public final Set<zzbzl<zzbvb>> zzanb() {
        return this.zzgcw;
    }

    public final Set<zzbzl<zzbvm>> zzanc() {
        return this.zzgcy;
    }

    public final Set<zzbzl<com.google.android.gms.ads.internal.overlay.zzp>> zzand() {
        return this.zzgcx;
    }

    public final zzdmi zzane() {
        return this.zzfyo;
    }

    public final zzbsx zzc(Set<zzbzl<zzbsz>> set) {
        if (this.zzgcz == null) {
            this.zzgcz = new zzbsx(set);
        }
        return this.zzgcz;
    }

    public final zzcwk zza(Clock clock, zzcwm zzcwmVar, zzctc zzctcVar) {
        if (this.zzgda == null) {
            this.zzgda = new zzcwk(clock, zzcwmVar, zzctcVar);
        }
        return this.zzgda;
    }
}

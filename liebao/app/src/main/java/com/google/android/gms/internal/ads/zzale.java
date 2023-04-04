package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzale {
    private final Context context;
    private final Object lock;
    private int status;
    private final zzbar zzbpx;
    private final String zzdkr;
    private com.google.android.gms.ads.internal.util.zzar<zzakv> zzdks;
    private com.google.android.gms.ads.internal.util.zzar<zzakv> zzdkt;
    private zzalz zzdku;

    private zzale(Context context, zzbar zzbarVar, String str) {
        this.lock = new Object();
        this.status = 1;
        this.zzdkr = str;
        this.context = context.getApplicationContext();
        this.zzbpx = zzbarVar;
        this.zzdks = new zzals();
        this.zzdkt = new zzals();
    }

    public zzale(Context context, zzbar zzbarVar, String str, com.google.android.gms.ads.internal.util.zzar<zzakv> zzarVar, com.google.android.gms.ads.internal.util.zzar<zzakv> zzarVar2) {
        this(context, zzbarVar, str);
        this.zzdks = zzarVar;
        this.zzdkt = zzarVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzalz zza(zzei zzeiVar) {
        zzalz zzalzVar = new zzalz(this.zzdkt);
        zzbat.zzeki.execute(new Runnable(this, zzeiVar, zzalzVar) { // from class: com.google.android.gms.internal.ads.zzalh
            private final zzale zzdkv;
            private final zzei zzdkw;
            private final zzalz zzdkx;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzdkv = this;
                this.zzdkw = zzeiVar;
                this.zzdkx = zzalzVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdkv.zza(this.zzdkw, this.zzdkx);
            }
        });
        zzalzVar.zza(new zzalr(this, zzalzVar), new zzalq(this, zzalzVar));
        return zzalzVar;
    }

    public final zzalv zzb(zzei zzeiVar) {
        synchronized (this.lock) {
            synchronized (this.lock) {
                if (this.zzdku != null && this.status == 0) {
                    this.zzdku.zza(new zzbbi(this) { // from class: com.google.android.gms.internal.ads.zzalg
                        private final zzale zzdkv;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzdkv = this;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbbi
                        public final void zzg(Object obj) {
                            this.zzdkv.zza((zzakv) obj);
                        }
                    }, zzalj.zzdla);
                }
            }
            if (this.zzdku != null && this.zzdku.getStatus() != -1) {
                if (this.status == 0) {
                    return this.zzdku.zzuw();
                } else if (this.status == 1) {
                    this.status = 2;
                    zza((zzei) null);
                    return this.zzdku.zzuw();
                } else if (this.status == 2) {
                    return this.zzdku.zzuw();
                } else {
                    return this.zzdku.zzuw();
                }
            }
            this.status = 2;
            zzalz zza = zza((zzei) null);
            this.zzdku = zza;
            return zza.zzuw();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzakv zzakvVar) {
        if (zzakvVar.isDestroyed()) {
            this.status = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzei zzeiVar, final zzalz zzalzVar) {
        try {
            final zzakx zzakxVar = new zzakx(this.context, this.zzbpx, zzeiVar, null);
            zzakxVar.zza(new zzaku(this, zzalzVar, zzakxVar) { // from class: com.google.android.gms.internal.ads.zzali
                private final zzale zzdkv;
                private final zzalz zzdky;
                private final zzakv zzdkz;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdkv = this;
                    this.zzdky = zzalzVar;
                    this.zzdkz = zzakxVar;
                }

                @Override // com.google.android.gms.internal.ads.zzaku
                public final void zzut() {
                    final zzale zzaleVar = this.zzdkv;
                    final zzalz zzalzVar2 = this.zzdky;
                    final zzakv zzakvVar = this.zzdkz;
                    com.google.android.gms.ads.internal.util.zzj.zzegq.postDelayed(new Runnable(zzaleVar, zzalzVar2, zzakvVar) { // from class: com.google.android.gms.internal.ads.zzall
                        private final zzale zzdkv;
                        private final zzalz zzdky;
                        private final zzakv zzdkz;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzdkv = zzaleVar;
                            this.zzdky = zzalzVar2;
                            this.zzdkz = zzakvVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzdkv.zza(this.zzdky, this.zzdkz);
                        }
                    }, zzalt.zzdlj);
                }
            });
            zzakxVar.zza("/jsLoaded", new zzaln(this, zzalzVar, zzakxVar));
            com.google.android.gms.ads.internal.util.zzbs zzbsVar = new com.google.android.gms.ads.internal.util.zzbs();
            zzalm zzalmVar = new zzalm(this, zzeiVar, zzakxVar, zzbsVar);
            zzbsVar.set(zzalmVar);
            zzakxVar.zza("/requestReload", zzalmVar);
            if (this.zzdkr.endsWith(".js")) {
                zzakxVar.zzcw(this.zzdkr);
            } else if (this.zzdkr.startsWith("<html>")) {
                zzakxVar.zzcy(this.zzdkr);
            } else {
                zzakxVar.zzcx(this.zzdkr);
            }
            com.google.android.gms.ads.internal.util.zzj.zzegq.postDelayed(new zzalp(this, zzalzVar, zzakxVar), zzalt.zzdli);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Error creating webview.", th);
            com.google.android.gms.ads.internal.zzr.zzkz().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzalzVar.reject();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzalz zzalzVar, zzakv zzakvVar) {
        synchronized (this.lock) {
            if (zzalzVar.getStatus() != -1 && zzalzVar.getStatus() != 1) {
                zzalzVar.reject();
                zzebs zzebsVar = zzbat.zzeki;
                zzakvVar.getClass();
                zzebsVar.execute(zzalk.zzb(zzakvVar));
                com.google.android.gms.ads.internal.util.zzd.zzed("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}

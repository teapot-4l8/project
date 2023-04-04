package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import com.umeng.analytics.pro.ak;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbdn implements zzhg, zzil, zzmz, zzpd<zzon>, zzqk {
    private static int zzeqi;
    private static int zzeqj;
    private int bytesTransferred;
    private final Context context;
    private int zzbmc;
    private final String zzbwe;
    private final int zzbwf;
    private final zzbcp zzepi;
    private final zzhy zzeql;
    private zzhh zzeqo;
    private ByteBuffer zzeqp;
    private boolean zzeqq;
    private final WeakReference<zzbcs> zzeqr;
    private zzbdx zzeqs;
    private long zzeqt;
    private final ArrayList<zzot> zzequ;
    private volatile zzbdj zzeqv;
    private Set<WeakReference<zzbdh>> zzeqw = new HashSet();
    private final zzbdo zzeqk = new zzbdo();
    private final zzhy zzeqm = new zzjc(zzlx.zzbde, com.google.android.gms.ads.internal.util.zzj.zzegq, this);
    private final zzob zzeqn = new zzoa();

    public zzbdn(Context context, zzbcp zzbcpVar, zzbcs zzbcsVar) {
        this.context = context;
        this.zzepi = zzbcpVar;
        this.zzeqr = new WeakReference<>(zzbcsVar);
        this.zzeql = new zzqe(this.context, zzlx.zzbde, 0L, com.google.android.gms.ads.internal.util.zzj.zzegq, this, -1);
        if (com.google.android.gms.ads.internal.util.zzd.zzyz()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 28);
            sb.append("ExoPlayerAdapter initialize ");
            sb.append(valueOf);
            com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
        }
        zzeqi++;
        zzhh zza = zzhl.zza(new zzhy[]{this.zzeqm, this.zzeql}, this.zzeqn, this.zzeqk);
        this.zzeqo = zza;
        zza.zza(this);
        this.bytesTransferred = 0;
        this.zzeqt = 0L;
        this.zzbmc = 0;
        this.zzequ = new ArrayList<>();
        this.zzeqv = null;
        this.zzbwe = (zzbcsVar == null || zzbcsVar.zzabz() == null) ? "" : zzbcsVar.zzabz();
        this.zzbwf = zzbcsVar != null ? zzbcsVar.zzaca() : 0;
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcng)).booleanValue()) {
            this.zzeqo.zzer();
        }
        if (zzbcsVar != null && zzbcsVar.zzacg() > 0) {
            this.zzeqo.zzv(zzbcsVar.zzacg());
        }
        if (zzbcsVar == null || zzbcsVar.zzach() <= 0) {
            return;
        }
        this.zzeqo.zzw(zzbcsVar.zzach());
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zza(zzhz zzhzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zza(zzid zzidVar, Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zza(zznu zznuVar, zzoi zzoiVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzil
    public final void zzaa(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzil
    public final void zzb(int i, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzb(Surface surface) {
    }

    @Override // com.google.android.gms.internal.ads.zzil
    public final void zzb(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzil
    public final void zzc(zzjm zzjmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzil
    public final void zzd(zzjm zzjmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzd(String str, long j, long j2) {
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zze(zzjm zzjmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* bridge */ /* synthetic */ void zze(zzon zzonVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zzen() {
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzf(zzjm zzjmVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zzg(boolean z) {
    }

    public final zzhh zzadd() {
        return this.zzeqo;
    }

    public static int zzade() {
        return zzeqi;
    }

    public static int zzadf() {
        return zzeqj;
    }

    private static long zzk(Map<String, List<String>> map) {
        if (map != null) {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        if (entry.getKey() != null && zzdxo.zza("content-length", entry.getKey()) && entry.getValue() != null && entry.getValue().get(0) != null) {
                            return Long.parseLong(entry.getValue().get(0));
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
            return 0L;
        }
        return 0L;
    }

    public final void zza(zzbdx zzbdxVar) {
        this.zzeqs = zzbdxVar;
    }

    public final zzbdo zzadg() {
        return this.zzeqk;
    }

    public final void zza(Uri[] uriArr, String str) {
        zza(uriArr, str, ByteBuffer.allocate(0), false);
    }

    public final void zza(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzne zznfVar;
        if (this.zzeqo == null) {
            return;
        }
        this.zzeqp = byteBuffer;
        this.zzeqq = z;
        if (uriArr.length == 1) {
            zznfVar = zzb(uriArr[0], str);
        } else {
            zzne[] zzneVarArr = new zzne[uriArr.length];
            for (int i = 0; i < uriArr.length; i++) {
                zzneVarArr[i] = zzb(uriArr[i], str);
            }
            zznfVar = new zznf(zzneVarArr);
        }
        this.zzeqo.zza(zznfVar);
        zzeqj++;
    }

    public final void release() {
        zzhh zzhhVar = this.zzeqo;
        if (zzhhVar != null) {
            zzhhVar.zzb(this);
            this.zzeqo.release();
            this.zzeqo = null;
            zzeqj--;
        }
    }

    public final long getBytesTransferred() {
        return this.bytesTransferred;
    }

    private final boolean zzacz() {
        return this.zzeqv != null && this.zzeqv.zzacz();
    }

    public final long zzaba() {
        if (zzacz()) {
            return 0L;
        }
        return this.bytesTransferred;
    }

    public final long zznh() {
        if (zzacz() && this.zzeqv.zzni()) {
            return Math.min(this.bytesTransferred, this.zzeqv.zznh());
        }
        return 0L;
    }

    public final long getTotalBytes() {
        if (!zzacz()) {
            while (!this.zzequ.isEmpty()) {
                this.zzeqt += zzk(this.zzequ.remove(0).getResponseHeaders());
            }
            return this.zzeqt;
        }
        return this.zzeqv.getContentLength();
    }

    public final int zzabb() {
        return this.zzbmc;
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzb(IOException iOException) {
        if (this.zzeqs != null) {
            if (this.zzepi.zzens) {
                this.zzeqs.zzc("onLoadException", iOException);
            } else {
                this.zzeqs.zzb("onLoadError", iOException);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzk(zzht zzhtVar) {
        zzbcs zzbcsVar = this.zzeqr.get();
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue() || zzbcsVar == null || zzhtVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("frameRate", String.valueOf(zzhtVar.zzahs));
        hashMap.put("bitRate", String.valueOf(zzhtVar.zzahk));
        int i = zzhtVar.width;
        int i2 = zzhtVar.height;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        hashMap.put(ak.z, sb.toString());
        hashMap.put("videoMime", zzhtVar.zzahn);
        hashMap.put("videoSampleMime", zzhtVar.zzaho);
        hashMap.put("videoCodec", zzhtVar.zzahl);
        zzbcsVar.zza("onMetadataEvent", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzg(int i, long j) {
        this.zzbmc += i;
    }

    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zzb(int i, int i2, int i3, float f) {
        zzbdx zzbdxVar = this.zzeqs;
        if (zzbdxVar != null) {
            zzbdxVar.zzp(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzil
    public final void zzc(zzht zzhtVar) {
        zzbcs zzbcsVar = this.zzeqr.get();
        if (!((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue() || zzbcsVar == null || zzhtVar == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("audioMime", zzhtVar.zzahn);
        hashMap.put("audioSampleMime", zzhtVar.zzaho);
        hashMap.put("audioCodec", zzhtVar.zzahl);
        zzbcsVar.zza("onMetadataEvent", hashMap);
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zza(boolean z, int i) {
        zzbdx zzbdxVar = this.zzeqs;
        if (zzbdxVar != null) {
            zzbdxVar.zzdy(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhg
    public final void zza(zzhe zzheVar) {
        zzbdx zzbdxVar = this.zzeqs;
        if (zzbdxVar != null) {
            zzbdxVar.zzb("onPlayerError", zzheVar);
        }
    }

    public final void zzdu(int i) {
        for (WeakReference<zzbdh> weakReference : this.zzeqw) {
            zzbdh zzbdhVar = weakReference.get();
            if (zzbdhVar != null) {
                zzbdhVar.setReceiveBufferSize(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Surface surface, boolean z) {
        if (this.zzeqo == null) {
            return;
        }
        zzhi zzhiVar = new zzhi(this.zzeql, 1, surface);
        if (z) {
            this.zzeqo.zzb(zzhiVar);
        } else {
            this.zzeqo.zza(zzhiVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(float f, boolean z) {
        if (this.zzeqo == null) {
            return;
        }
        zzhi zzhiVar = new zzhi(this.zzeqm, 2, Float.valueOf(f));
        if (z) {
            this.zzeqo.zzb(zzhiVar);
        } else {
            this.zzeqo.zza(zzhiVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzba(boolean z) {
        if (this.zzeqo == null) {
            return;
        }
        for (int i = 0; i < this.zzeqo.zzep(); i++) {
            this.zzeqn.zzf(i, !z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0044, code lost:
        if (((java.lang.Boolean) com.google.android.gms.internal.ads.zzww.zzra().zzd(com.google.android.gms.internal.ads.zzabq.zzcsd)).booleanValue() == false) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final zzne zzb(Uri uri, String str) {
        boolean z;
        zzoq zzoqVar;
        ByteBuffer byteBuffer;
        zzoq zzoqVar2;
        zzkb zzkbVar;
        if (this.zzeqq && this.zzeqp.limit() > 0) {
            byte[] bArr = new byte[this.zzeqp.limit()];
            this.zzeqp.get(bArr);
            zzoqVar2 = new zzoq(bArr) { // from class: com.google.android.gms.internal.ads.zzbdp
                private final byte[] zzejy;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzejy = bArr;
                }

                @Override // com.google.android.gms.internal.ads.zzoq
                public final zzon zzit() {
                    return new zzoo(this.zzejy);
                }
            };
        } else {
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcsf)).booleanValue()) {
            }
            if (this.zzepi.zzenq) {
                z = false;
                if (this.zzepi.zzenp <= 0) {
                    zzoqVar = new zzoq(this, str, z) { // from class: com.google.android.gms.internal.ads.zzbds
                        private final String zzdkl;
                        private final zzbdn zzere;
                        private final boolean zzerf;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzere = this;
                            this.zzdkl = str;
                            this.zzerf = z;
                        }

                        @Override // com.google.android.gms.internal.ads.zzoq
                        public final zzon zzit() {
                            return this.zzere.zzj(this.zzdkl, this.zzerf);
                        }
                    };
                } else {
                    zzoqVar = new zzoq(this, str, z) { // from class: com.google.android.gms.internal.ads.zzbdr
                        private final String zzdkl;
                        private final zzbdn zzere;
                        private final boolean zzerf;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzere = this;
                            this.zzdkl = str;
                            this.zzerf = z;
                        }

                        @Override // com.google.android.gms.internal.ads.zzoq
                        public final zzon zzit() {
                            return this.zzere.zzi(this.zzdkl, this.zzerf);
                        }
                    };
                }
                if (this.zzepi.zzenq) {
                    zzoqVar = new zzoq(this, zzoqVar) { // from class: com.google.android.gms.internal.ads.zzbdu
                        private final zzbdn zzere;
                        private final zzoq zzerh;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzere = this;
                            this.zzerh = zzoqVar;
                        }

                        @Override // com.google.android.gms.internal.ads.zzoq
                        public final zzon zzit() {
                            return this.zzere.zza(this.zzerh);
                        }
                    };
                }
                byteBuffer = this.zzeqp;
                if (byteBuffer != null && byteBuffer.limit() > 0) {
                    byte[] bArr2 = new byte[this.zzeqp.limit()];
                    this.zzeqp.get(bArr2);
                    zzoqVar = new zzoq(zzoqVar, bArr2) { // from class: com.google.android.gms.internal.ads.zzbdt
                        private final byte[] zzdyr;
                        private final zzoq zzerg;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.zzerg = zzoqVar;
                            this.zzdyr = bArr2;
                        }

                        @Override // com.google.android.gms.internal.ads.zzoq
                        public final zzon zzit() {
                            zzoq zzoqVar3 = this.zzerg;
                            byte[] bArr3 = this.zzdyr;
                            return new zzbea(new zzoo(bArr3), bArr3.length, zzoqVar3.zzit());
                        }
                    };
                }
                zzoqVar2 = zzoqVar;
            }
            z = true;
            if (this.zzepi.zzenp <= 0) {
            }
            if (this.zzepi.zzenq) {
            }
            byteBuffer = this.zzeqp;
            if (byteBuffer != null) {
                byte[] bArr22 = new byte[this.zzeqp.limit()];
                this.zzeqp.get(bArr22);
                zzoqVar = new zzoq(zzoqVar, bArr22) { // from class: com.google.android.gms.internal.ads.zzbdt
                    private final byte[] zzdyr;
                    private final zzoq zzerg;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzerg = zzoqVar;
                        this.zzdyr = bArr22;
                    }

                    @Override // com.google.android.gms.internal.ads.zzoq
                    public final zzon zzit() {
                        zzoq zzoqVar3 = this.zzerg;
                        byte[] bArr3 = this.zzdyr;
                        return new zzbea(new zzoo(bArr3), bArr3.length, zzoqVar3.zzit());
                    }
                };
            }
            zzoqVar2 = zzoqVar;
        }
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcnf)).booleanValue()) {
            zzkbVar = zzbdw.zzeri;
        } else {
            zzkbVar = zzbdv.zzeri;
        }
        return new zzna(uri, zzoqVar2, zzkbVar, this.zzepi.zzenr, com.google.android.gms.ads.internal.util.zzj.zzegq, this, null, this.zzepi.zzenn);
    }

    public final void finalize() {
        zzeqi--;
        if (com.google.android.gms.ads.internal.util.zzd.zzyz()) {
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
            sb.append("ExoPlayerAdapter finalize ");
            sb.append(valueOf);
            com.google.android.gms.ads.internal.util.zzd.zzed(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* synthetic */ void zzc(zzon zzonVar, int i) {
        this.bytesTransferred += i;
    }

    @Override // com.google.android.gms.internal.ads.zzpd
    public final /* synthetic */ void zza(zzon zzonVar, zzos zzosVar) {
        zzon zzonVar2 = zzonVar;
        if (zzonVar2 instanceof zzot) {
            this.zzequ.add((zzot) zzonVar2);
        } else if (zzonVar2 instanceof zzbdj) {
            this.zzeqv = (zzbdj) zzonVar2;
            zzbcs zzbcsVar = this.zzeqr.get();
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcsd)).booleanValue() && zzbcsVar != null && this.zzeqv.zznf()) {
                HashMap hashMap = new HashMap();
                hashMap.put("gcacheHit", String.valueOf(this.zzeqv.zzni()));
                hashMap.put("gcacheDownloaded", String.valueOf(this.zzeqv.zzada()));
                com.google.android.gms.ads.internal.util.zzj.zzegq.post(new Runnable(zzbcsVar, hashMap) { // from class: com.google.android.gms.internal.ads.zzbdq
                    private final Map zzeds;
                    private final zzbcs zzerd;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzerd = zzbcsVar;
                        this.zzeds = hashMap;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzerd.zza("onGcacheInfoEvent", this.zzeds);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzon zza(zzoq zzoqVar) {
        return new zzbdj(this.context, zzoqVar.zzit(), this.zzbwe, this.zzbwf, this, new zzbdl(this) { // from class: com.google.android.gms.internal.ads.zzbdy
            private final zzbdn zzere;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzere = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbdl
            public final void zzb(boolean z, long j) {
                this.zzere.zzd(z, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(boolean z, long j) {
        zzbdx zzbdxVar = this.zzeqs;
        if (zzbdxVar != null) {
            zzbdxVar.zzb(z, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzon zzi(String str, boolean z) {
        return new zzou(str, null, z ? this : null, this.zzepi.zzenk, this.zzepi.zzenm, true, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzon zzj(String str, boolean z) {
        zzbdh zzbdhVar = new zzbdh(str, z ? this : null, this.zzepi.zzenk, this.zzepi.zzenm, this.zzepi.zzenp);
        this.zzeqw.add(new WeakReference<>(zzbdhVar));
        return zzbdhVar;
    }
}

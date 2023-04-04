package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zzae;
import com.google.android.gms.ads.internal.util.zzam;
import com.google.android.gms.ads.internal.util.zzbl;
import com.google.android.gms.ads.internal.util.zzbo;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.ads.zzabz;
import com.google.android.gms.internal.ads.zzaks;
import com.google.android.gms.internal.ads.zzamj;
import com.google.android.gms.internal.ads.zzanl;
import com.google.android.gms.internal.ads.zzasb;
import com.google.android.gms.internal.ads.zzauq;
import com.google.android.gms.internal.ads.zzayd;
import com.google.android.gms.internal.ads.zzazs;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbeh;
import com.google.android.gms.internal.ads.zzbfq;
import com.google.android.gms.internal.ads.zzrm;
import com.google.android.gms.internal.ads.zzta;
import com.google.android.gms.internal.ads.zztx;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzr {
    private static zzr zzbqg = new zzr();
    private final com.google.android.gms.ads.internal.overlay.zza zzbqh;
    private final com.google.android.gms.ads.internal.overlay.zzo zzbqi;
    private final com.google.android.gms.ads.internal.util.zzj zzbqj;
    private final zzbfq zzbqk;
    private final com.google.android.gms.ads.internal.util.zzr zzbql;
    private final zzrm zzbqm;
    private final zzazs zzbqn;
    private final zzae zzbqo;
    private final zzta zzbqp;
    private final Clock zzbqq;
    private final zze zzbqr;
    private final zzabz zzbqs;
    private final zzam zzbqt;
    private final zzauq zzbqu;
    private final zzaks zzbqv;
    private final zzbbd zzbqw;
    private final zzamj zzbqx;
    private final zzbl zzbqy;
    private final zzw zzbqz;
    private final zzz zzbra;
    private final zzanl zzbrb;
    private final zzbo zzbrc;
    private final zzasb zzbrd;
    private final zztx zzbre;
    private final zzayd zzbrf;
    private final zzbv zzbrg;
    private final zzbeh zzbrh;
    private final zzbbm zzbri;

    protected zzr() {
        this(new com.google.android.gms.ads.internal.overlay.zza(), new com.google.android.gms.ads.internal.overlay.zzo(), new com.google.android.gms.ads.internal.util.zzj(), new zzbfq(), com.google.android.gms.ads.internal.util.zzr.zzdm(Build.VERSION.SDK_INT), new zzrm(), new zzazs(), new zzae(), new zzta(), DefaultClock.getInstance(), new zze(), new zzabz(), new zzam(), new zzauq(), new zzaks(), new zzbbd(), new zzamj(), new zzbl(), new zzw(), new zzz(), new zzanl(), new zzbo(), new zzasb(), new zztx(), new zzayd(), new zzbv(), new zzbeh(), new zzbbm());
    }

    private zzr(com.google.android.gms.ads.internal.overlay.zza zzaVar, com.google.android.gms.ads.internal.overlay.zzo zzoVar, com.google.android.gms.ads.internal.util.zzj zzjVar, zzbfq zzbfqVar, com.google.android.gms.ads.internal.util.zzr zzrVar, zzrm zzrmVar, zzazs zzazsVar, zzae zzaeVar, zzta zztaVar, Clock clock, zze zzeVar, zzabz zzabzVar, zzam zzamVar, zzauq zzauqVar, zzaks zzaksVar, zzbbd zzbbdVar, zzamj zzamjVar, zzbl zzblVar, zzw zzwVar, zzz zzzVar, zzanl zzanlVar, zzbo zzboVar, zzasb zzasbVar, zztx zztxVar, zzayd zzaydVar, zzbv zzbvVar, zzbeh zzbehVar, zzbbm zzbbmVar) {
        this.zzbqh = zzaVar;
        this.zzbqi = zzoVar;
        this.zzbqj = zzjVar;
        this.zzbqk = zzbfqVar;
        this.zzbql = zzrVar;
        this.zzbqm = zzrmVar;
        this.zzbqn = zzazsVar;
        this.zzbqo = zzaeVar;
        this.zzbqp = zztaVar;
        this.zzbqq = clock;
        this.zzbqr = zzeVar;
        this.zzbqs = zzabzVar;
        this.zzbqt = zzamVar;
        this.zzbqu = zzauqVar;
        this.zzbqv = zzaksVar;
        this.zzbqw = zzbbdVar;
        this.zzbqx = zzamjVar;
        this.zzbqy = zzblVar;
        this.zzbqz = zzwVar;
        this.zzbra = zzzVar;
        this.zzbrb = zzanlVar;
        this.zzbrc = zzboVar;
        this.zzbrd = zzasbVar;
        this.zzbre = zztxVar;
        this.zzbrf = zzaydVar;
        this.zzbrg = zzbvVar;
        this.zzbrh = zzbehVar;
        this.zzbri = zzbbmVar;
    }

    public static com.google.android.gms.ads.internal.overlay.zza zzkt() {
        return zzbqg.zzbqh;
    }

    public static com.google.android.gms.ads.internal.overlay.zzo zzku() {
        return zzbqg.zzbqi;
    }

    public static com.google.android.gms.ads.internal.util.zzj zzkv() {
        return zzbqg.zzbqj;
    }

    public static zzbfq zzkw() {
        return zzbqg.zzbqk;
    }

    public static com.google.android.gms.ads.internal.util.zzr zzkx() {
        return zzbqg.zzbql;
    }

    public static zzrm zzky() {
        return zzbqg.zzbqm;
    }

    public static zzazs zzkz() {
        return zzbqg.zzbqn;
    }

    public static zzae zzla() {
        return zzbqg.zzbqo;
    }

    public static zzta zzlb() {
        return zzbqg.zzbqp;
    }

    public static Clock zzlc() {
        return zzbqg.zzbqq;
    }

    public static zze zzld() {
        return zzbqg.zzbqr;
    }

    public static zzabz zzle() {
        return zzbqg.zzbqs;
    }

    public static zzam zzlf() {
        return zzbqg.zzbqt;
    }

    public static zzauq zzlg() {
        return zzbqg.zzbqu;
    }

    public static zzbbd zzlh() {
        return zzbqg.zzbqw;
    }

    public static zzamj zzli() {
        return zzbqg.zzbqx;
    }

    public static zzbl zzlj() {
        return zzbqg.zzbqy;
    }

    public static zzasb zzlk() {
        return zzbqg.zzbrd;
    }

    public static zzw zzll() {
        return zzbqg.zzbqz;
    }

    public static zzz zzlm() {
        return zzbqg.zzbra;
    }

    public static zzanl zzln() {
        return zzbqg.zzbrb;
    }

    public static zzbo zzlo() {
        return zzbqg.zzbrc;
    }

    public static zztx zzlp() {
        return zzbqg.zzbre;
    }

    public static zzbv zzlq() {
        return zzbqg.zzbrg;
    }

    public static zzbeh zzlr() {
        return zzbqg.zzbrh;
    }

    public static zzbbm zzls() {
        return zzbqg.zzbri;
    }

    public static zzayd zzlt() {
        return zzbqg.zzbrf;
    }
}

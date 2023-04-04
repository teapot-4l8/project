package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.query.QueryInfo;
import java.util.Random;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzww {
    private static zzww zzcjy = new zzww();
    private final zzbae zzcjz;
    private final zzwd zzcka;
    private final String zzckb;
    private final zzabl zzckc;
    private final zzabn zzckd;
    private final zzabm zzcke;
    private final zzbar zzckf;
    private final Random zzckg;
    private final WeakHashMap<QueryInfo, String> zzckh;

    protected zzww() {
        this(new zzbae(), new zzwd(new zzvo(), new zzvl(), new zzaaa(), new zzagw(), new zzavr(), new zzawv(), new zzasf(), new zzagz()), new zzabl(), new zzabn(), new zzabm(), zzbae.zzaar(), new zzbar(0, 204890000, true), new Random(), new WeakHashMap());
    }

    private zzww(zzbae zzbaeVar, zzwd zzwdVar, zzabl zzablVar, zzabn zzabnVar, zzabm zzabmVar, String str, zzbar zzbarVar, Random random, WeakHashMap<QueryInfo, String> weakHashMap) {
        this.zzcjz = zzbaeVar;
        this.zzcka = zzwdVar;
        this.zzckc = zzablVar;
        this.zzckd = zzabnVar;
        this.zzcke = zzabmVar;
        this.zzckb = str;
        this.zzckf = zzbarVar;
        this.zzckg = random;
        this.zzckh = weakHashMap;
    }

    public static zzbae zzqw() {
        return zzcjy.zzcjz;
    }

    public static zzwd zzqx() {
        return zzcjy.zzcka;
    }

    public static zzabn zzqy() {
        return zzcjy.zzckd;
    }

    public static zzabl zzqz() {
        return zzcjy.zzckc;
    }

    public static zzabm zzra() {
        return zzcjy.zzcke;
    }

    public static String zzrb() {
        return zzcjy.zzckb;
    }

    public static zzbar zzrc() {
        return zzcjy.zzckf;
    }

    public static Random zzrd() {
        return zzcjy.zzckg;
    }

    public static WeakHashMap<QueryInfo, String> zzre() {
        return zzcjy.zzckh;
    }
}

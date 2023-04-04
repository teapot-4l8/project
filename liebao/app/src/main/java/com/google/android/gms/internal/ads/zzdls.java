package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdls<R> implements zzdrx {
    public final Executor executor;
    public final String zzbvf;
    public final zzvq zzdvn;
    public final zzwc zzhdy;
    public final zzdmj<R> zzhkh;
    public final zzdmm zzhki;
    @Nullable
    private final zzdri zzhkj;

    public zzdls(zzdmj<R> zzdmjVar, zzdmm zzdmmVar, zzvq zzvqVar, String str, Executor executor, zzwc zzwcVar, @Nullable zzdri zzdriVar) {
        this.zzhkh = zzdmjVar;
        this.zzhki = zzdmmVar;
        this.zzdvn = zzvqVar;
        this.zzbvf = str;
        this.executor = executor;
        this.zzhdy = zzwcVar;
        this.zzhkj = zzdriVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    public final Executor getExecutor() {
        return this.executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    @Nullable
    public final zzdri zzavp() {
        return this.zzhkj;
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    public final zzdrx zzavq() {
        return new zzdls(this.zzhkh, this.zzhki, this.zzdvn, this.zzbvf, this.executor, this.zzhdy, this.zzhkj);
    }
}

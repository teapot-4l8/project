package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzccq implements zzesa<zzccn> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzdup> zzfab;
    private final zzesn<zzbst> zzfiv;
    private final zzesn<zzbtl> zzfjf;
    private final zzesn<JSONObject> zzflg;
    private final zzesn<zzbli> zzflm;
    private final zzesn<zzbzk> zzflv;
    private final zzesn<zzbar> zzfsw;
    private final zzesn<Clock> zzfvh;
    private final zzesn<zzcdy> zzfxe;
    private final zzesn<zzdpm> zzfxn;
    private final zzesn<zzdot> zzfxz;
    private final zzesn<zzchu> zzgfe;
    private final zzesn<zzcdr> zzgff;
    private final zzesn<zzei> zzgfg;
    private final zzesn<zzceq> zzgfh;

    public zzccq(zzesn<Context> zzesnVar, zzesn<zzcdy> zzesnVar2, zzesn<JSONObject> zzesnVar3, zzesn<zzchu> zzesnVar4, zzesn<zzcdr> zzesnVar5, zzesn<zzei> zzesnVar6, zzesn<zzbtl> zzesnVar7, zzesn<zzbst> zzesnVar8, zzesn<zzdot> zzesnVar9, zzesn<zzbar> zzesnVar10, zzesn<zzdpm> zzesnVar11, zzesn<zzbli> zzesnVar12, zzesn<zzceq> zzesnVar13, zzesn<Clock> zzesnVar14, zzesn<zzbzk> zzesnVar15, zzesn<zzdup> zzesnVar16) {
        this.zzeyq = zzesnVar;
        this.zzfxe = zzesnVar2;
        this.zzflg = zzesnVar3;
        this.zzgfe = zzesnVar4;
        this.zzgff = zzesnVar5;
        this.zzgfg = zzesnVar6;
        this.zzfjf = zzesnVar7;
        this.zzfiv = zzesnVar8;
        this.zzfxz = zzesnVar9;
        this.zzfsw = zzesnVar10;
        this.zzfxn = zzesnVar11;
        this.zzflm = zzesnVar12;
        this.zzgfh = zzesnVar13;
        this.zzfvh = zzesnVar14;
        this.zzflv = zzesnVar15;
        this.zzfab = zzesnVar16;
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return new zzccn(this.zzeyq.get(), this.zzfxe.get(), this.zzflg.get(), this.zzgfe.get(), this.zzgff.get(), this.zzgfg.get(), this.zzfjf.get(), this.zzfiv.get(), this.zzfxz.get(), this.zzfsw.get(), this.zzfxn.get(), this.zzflm.get(), this.zzgfh.get(), this.zzfvh.get(), this.zzflv.get(), this.zzfab.get());
    }
}

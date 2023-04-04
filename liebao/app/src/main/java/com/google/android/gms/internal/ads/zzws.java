package com.google.android.gms.internal.ads;

import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzws extends zzwt<zzaew> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzwd zzcjp;
    private final /* synthetic */ FrameLayout zzcju;
    private final /* synthetic */ FrameLayout zzcjv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzws(zzwd zzwdVar, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzcjp = zzwdVar;
        this.zzcju = frameLayout;
        this.zzcjv = frameLayout2;
        this.val$context = context;
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    protected final /* synthetic */ zzaew zzqp() {
        zzwd.zza(this.val$context, "native_ad_view_delegate");
        return new zzaal();
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzaew zzqq() {
        zzagw zzagwVar;
        zzagwVar = this.zzcjp.zzcjh;
        return zzagwVar.zzb(this.val$context, this.zzcju, this.zzcjv);
    }

    @Override // com.google.android.gms.internal.ads.zzwt
    public final /* synthetic */ zzaew zza(zzxz zzxzVar) {
        return zzxzVar.zza(ObjectWrapper.wrap(this.zzcju), ObjectWrapper.wrap(this.zzcjv));
    }
}

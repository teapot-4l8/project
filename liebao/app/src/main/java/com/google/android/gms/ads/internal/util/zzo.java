package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.a.c;
import com.google.android.gms.internal.ads.zzacq;
import com.google.android.gms.internal.ads.zzact;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzo implements zzact {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Uri val$uri;
    private final /* synthetic */ zzacq zzegx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzj zzjVar, zzacq zzacqVar, Context context, Uri uri) {
        this.zzegx = zzacqVar;
        this.val$context = context;
        this.val$uri = uri;
    }

    @Override // com.google.android.gms.internal.ads.zzact
    public final void zztc() {
    }

    @Override // com.google.android.gms.internal.ads.zzact
    public final void zztb() {
        new c.a(this.zzegx.zzsz()).a().a(this.val$context, this.val$uri);
        this.zzegx.zzc((Activity) this.val$context);
    }
}

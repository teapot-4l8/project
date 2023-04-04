package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzbfo implements zzebi<Map<String, String>> {
    private final /* synthetic */ Uri val$uri;
    private final /* synthetic */ zzbfh zzetq;
    private final /* synthetic */ List zzett;
    private final /* synthetic */ String zzetu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfo(zzbfh zzbfhVar, List list, String str, Uri uri) {
        this.zzetq = zzbfhVar;
        this.zzett = list;
        this.zzetu = str;
        this.val$uri = uri;
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final void zzb(Throwable th) {
        String valueOf = String.valueOf(this.val$uri);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 33);
        sb.append("Failed to parse gmsg params for: ");
        sb.append(valueOf);
        com.google.android.gms.ads.internal.util.zzd.zzez(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzebi
    public final /* synthetic */ void onSuccess(Map<String, String> map) {
        this.zzetq.zza(map, this.zzett, this.zzetu);
    }
}

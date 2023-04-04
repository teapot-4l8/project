package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzayd;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzayk implements zzayd.zzb {
    static final zzayd.zzb zzedi = new zzayk();

    private zzayk() {
    }

    @Override // com.google.android.gms.internal.ads.zzayd.zzb
    public final Object zzb(zzbha zzbhaVar) {
        String currentScreenName = zzbhaVar.getCurrentScreenName();
        if (currentScreenName != null) {
            return currentScreenName;
        }
        String currentScreenClass = zzbhaVar.getCurrentScreenClass();
        return currentScreenClass != null ? currentScreenClass : "";
    }
}
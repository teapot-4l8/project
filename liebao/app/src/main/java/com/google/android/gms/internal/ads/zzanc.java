package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzanc implements zzaiu {
    private final zzbbe<O> zzdml;
    private final /* synthetic */ zzana zzdmq;

    public zzanc(zzana zzanaVar, zzbbe<O> zzbbeVar) {
        this.zzdmq = zzanaVar;
        this.zzdml = zzbbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaiu
    public final void zzc(JSONObject jSONObject) {
        zzami zzamiVar;
        try {
            zzbbe<O> zzbbeVar = this.zzdml;
            zzamiVar = this.zzdmq.zzdmh;
            zzbbeVar.set(zzamiVar.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e2) {
            this.zzdml.setException(e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaiu
    public final void onFailure(String str) {
        try {
            if (str == null) {
                this.zzdml.setException(new zzamh());
            } else {
                this.zzdml.setException(new zzamh(str));
            }
        } catch (IllegalStateException unused) {
        }
    }
}

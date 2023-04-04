package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzamu implements zzaiu {
    private final /* synthetic */ zzamt zzdmg;
    private final zzalv zzdmk;
    private final zzbbe<O> zzdml;

    public zzamu(zzamt zzamtVar, zzalv zzalvVar, zzbbe<O> zzbbeVar) {
        this.zzdmg = zzamtVar;
        this.zzdmk = zzalvVar;
        this.zzdml = zzbbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaiu
    public final void zzc(JSONObject jSONObject) {
        zzami zzamiVar;
        try {
            try {
                zzbbe<O> zzbbeVar = this.zzdml;
                zzamiVar = this.zzdmg.zzdmh;
                zzbbeVar.set(zzamiVar.zzd(jSONObject));
                this.zzdmk.release();
            } catch (IllegalStateException unused) {
                this.zzdmk.release();
            } catch (JSONException e2) {
                this.zzdml.setException(e2);
                this.zzdmk.release();
            }
        } catch (Throwable th) {
            this.zzdmk.release();
            throw th;
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
        } finally {
            this.zzdmk.release();
        }
    }
}

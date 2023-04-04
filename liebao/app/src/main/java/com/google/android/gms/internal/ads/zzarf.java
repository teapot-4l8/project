package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzarf {
    private final boolean zzdrl;
    private final boolean zzdrm;
    private final boolean zzdrn;
    private final boolean zzdro;
    private final boolean zzdrp;

    private zzarf(zzarh zzarhVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        z = zzarhVar.zzdrl;
        this.zzdrl = z;
        z2 = zzarhVar.zzdrm;
        this.zzdrm = z2;
        z3 = zzarhVar.zzdrn;
        this.zzdrn = z3;
        z4 = zzarhVar.zzdro;
        this.zzdro = z4;
        z5 = zzarhVar.zzdrp;
        this.zzdrp = z5;
    }

    public final JSONObject zzds() {
        try {
            return new JSONObject().put("sms", this.zzdrl).put("tel", this.zzdrm).put("calendar", this.zzdrn).put("storePicture", this.zzdro).put("inlineVideo", this.zzdrp);
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzc("Error occured while obtaining the MRAID capabilities.", e2);
            return null;
        }
    }
}

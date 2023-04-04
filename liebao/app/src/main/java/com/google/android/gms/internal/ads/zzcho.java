package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.b.a;
import androidx.b.g;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcho extends zzafr {
    private final Context zzaai;
    private final zzcdr zzgeo;
    private zzcdf zzghx;
    private zzcen zzgle;

    public zzcho(Context context, zzcdr zzcdrVar, zzcen zzcenVar, zzcdf zzcdfVar) {
        this.zzaai = context;
        this.zzgeo = zzcdrVar;
        this.zzgle = zzcenVar;
        this.zzghx = zzcdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final IObjectWrapper zzts() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final String zzct(String str) {
        return this.zzgeo.zzaoy().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final zzaes zzcu(String str) {
        return this.zzgeo.zzaow().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final List<String> getAvailableAssetNames() {
        g<String, zzaee> zzaow = this.zzgeo.zzaow();
        g<String, String> zzaoy = this.zzgeo.zzaoy();
        String[] strArr = new String[zzaow.size() + zzaoy.size()];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i2 < zzaow.size()) {
            strArr[i3] = zzaow.b(i2);
            i2++;
            i3++;
        }
        while (i < zzaoy.size()) {
            strArr[i3] = zzaoy.b(i);
            i++;
            i3++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final String getCustomTemplateId() {
        return this.zzgeo.getCustomTemplateId();
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final void performClick(String str) {
        zzcdf zzcdfVar = this.zzghx;
        if (zzcdfVar != null) {
            zzcdfVar.zzfx(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final void recordImpression() {
        zzcdf zzcdfVar = this.zzghx;
        if (zzcdfVar != null) {
            zzcdfVar.zzaod();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final zzzd getVideoController() {
        return this.zzgeo.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final void destroy() {
        zzcdf zzcdfVar = this.zzghx;
        if (zzcdfVar != null) {
            zzcdfVar.destroy();
        }
        this.zzghx = null;
        this.zzgle = null;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final IObjectWrapper zztx() {
        return ObjectWrapper.wrap(this.zzaai);
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final boolean zzp(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (unwrap instanceof ViewGroup) {
            zzcen zzcenVar = this.zzgle;
            if (zzcenVar != null && zzcenVar.zza((ViewGroup) unwrap)) {
                this.zzgeo.zzaot().zza(new zzchr(this));
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final boolean zzty() {
        zzcdf zzcdfVar = this.zzghx;
        return (zzcdfVar == null || zzcdfVar.zzaok()) && this.zzgeo.zzaou() != null && this.zzgeo.zzaot() == null;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final boolean zztz() {
        IObjectWrapper zzaov = this.zzgeo.zzaov();
        if (zzaov != null) {
            com.google.android.gms.ads.internal.zzr.zzlk().zzac(zzaov);
            if (!((Boolean) zzww.zzra().zzd(zzabq.zzcwn)).booleanValue() || this.zzgeo.zzaou() == null) {
                return true;
            }
            this.zzgeo.zzaou().zza("onSdkLoaded", new a());
            return true;
        }
        com.google.android.gms.ads.internal.util.zzd.zzez("Trying to start OMID session before creation.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final void zzq(IObjectWrapper iObjectWrapper) {
        zzcdf zzcdfVar;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof View) || this.zzgeo.zzaov() == null || (zzcdfVar = this.zzghx) == null) {
            return;
        }
        zzcdfVar.zzaa((View) unwrap);
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final void zzua() {
        String zzaox = this.zzgeo.zzaox();
        if ("Google".equals(zzaox)) {
            com.google.android.gms.ads.internal.util.zzd.zzez("Illegal argument specified for omid partner name.");
            return;
        }
        zzcdf zzcdfVar = this.zzghx;
        if (zzcdfVar != null) {
            zzcdfVar.zzk(zzaox, false);
        }
    }
}

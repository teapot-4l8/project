package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaxt implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zzaai;
    private final zzayd zzbrf;
    private final SharedPreferences zzech;
    private final com.google.android.gms.ads.internal.util.zzf zzeci;
    private String zzecj = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaxt(Context context, com.google.android.gms.ads.internal.util.zzf zzfVar, zzayd zzaydVar) {
        this.zzech = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzeci = zzfVar;
        this.zzaai = context;
        this.zzbrf = zzaydVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzxn() {
        this.zzech.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(this.zzech, "IABTCF_PurposeConsents");
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        Context context;
        if ("IABTCF_PurposeConsents".equals(str)) {
            String string = sharedPreferences.getString("IABTCF_PurposeConsents", "");
            if (string.isEmpty() || this.zzecj.equals(string)) {
                return;
            }
            this.zzecj = string;
            boolean z = string.charAt(0) != '1';
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcpg)).booleanValue()) {
                this.zzeci.zzau(z);
                if (((Boolean) zzww.zzra().zzd(zzabq.zzcyt)).booleanValue() && z && (context = this.zzaai) != null) {
                    context.deleteDatabase("OfflineUpload.db");
                }
            }
            if (((Boolean) zzww.zzra().zzd(zzabq.zzcpc)).booleanValue()) {
                this.zzbrf.isInitialized();
            }
        }
    }
}

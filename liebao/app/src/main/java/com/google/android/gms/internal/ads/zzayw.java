package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzayw implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final String filename;
    private final /* synthetic */ zzayu zzedq;

    public zzayw(zzayu zzayuVar, String str) {
        this.zzedq = zzayuVar;
        this.filename = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        List<zzayz> list;
        synchronized (this.zzedq) {
            list = this.zzedq.zzedo;
            for (zzayz zzayzVar : list) {
                zzayzVar.zza(sharedPreferences, this.filename, str);
            }
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzayu {
    private final Context zzaai;
    private final Map<String, zzayw> zzedn = new HashMap();
    private final List<zzayz> zzedo = new ArrayList();
    private final zzaxx zzedp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzayu(Context context, zzaxx zzaxxVar) {
        this.zzaai = context;
        this.zzedp = zzaxxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zza(zzayz zzayzVar) {
        this.zzedo.add(zzayzVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzea(String str) {
        SharedPreferences sharedPreferences;
        if (this.zzedn.containsKey(str)) {
            return;
        }
        if ("__default__".equals(str)) {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.zzaai);
        } else {
            sharedPreferences = this.zzaai.getSharedPreferences(str, 0);
        }
        zzayw zzaywVar = new zzayw(this, str);
        this.zzedn.put(str, zzaywVar);
        sharedPreferences.registerOnSharedPreferenceChangeListener(zzaywVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
            this.zzedp.zzxp();
        }
    }
}

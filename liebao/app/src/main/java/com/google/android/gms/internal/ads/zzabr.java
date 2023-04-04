package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzabr implements zzady {
    private final /* synthetic */ zzabm zzdbs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabr(zzabm zzabmVar) {
        this.zzdbs = zzabmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzady
    public final Boolean zzf(String str, boolean z) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.zzdbs.zzcmn;
        return Boolean.valueOf(sharedPreferences.getBoolean(str, z));
    }

    @Override // com.google.android.gms.internal.ads.zzady
    public final Long getLong(String str, long j) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        try {
            sharedPreferences2 = this.zzdbs.zzcmn;
            return Long.valueOf(sharedPreferences2.getLong(str, j));
        } catch (ClassCastException unused) {
            sharedPreferences = this.zzdbs.zzcmn;
            return Long.valueOf(sharedPreferences.getInt(str, (int) j));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzady
    public final Double zza(String str, double d2) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.zzdbs.zzcmn;
        return Double.valueOf(sharedPreferences.getFloat(str, (float) d2));
    }

    @Override // com.google.android.gms.internal.ads.zzady
    public final String get(String str, String str2) {
        SharedPreferences sharedPreferences;
        sharedPreferences = this.zzdbs.zzcmn;
        return sharedPreferences.getString(str, str2);
    }
}

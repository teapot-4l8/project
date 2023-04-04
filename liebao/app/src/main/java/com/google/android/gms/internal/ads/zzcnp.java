package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzcnp extends Exception {
    private final zzdqj zzgqe;

    public zzcnp(zzdqj zzdqjVar) {
        this.zzgqe = zzdqjVar;
    }

    public zzcnp(zzdqj zzdqjVar, String str) {
        super(str);
        this.zzgqe = zzdqjVar;
    }

    public zzcnp(zzdqj zzdqjVar, String str, Throwable th) {
        super(str, th);
        this.zzgqe = zzdqjVar;
    }

    public final zzdqj zzasc() {
        return this.zzgqe;
    }
}

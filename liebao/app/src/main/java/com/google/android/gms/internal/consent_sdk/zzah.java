package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
final class zzah implements zzau {
    private zzbb zza;
    private final /* synthetic */ zzag zzb;

    private zzah(zzag zzagVar) {
        this.zzb = zzagVar;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzau
    public final zzar zza() {
        zzcu.zza(this.zza, zzbb.class);
        return new zzak(this.zzb, this.zza, null);
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzau
    public final /* synthetic */ zzau zza(zzbb zzbbVar) {
        this.zza = (zzbb) zzcu.zza(zzbbVar);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzah(zzag zzagVar, zzaf zzafVar) {
        this(zzagVar);
    }
}

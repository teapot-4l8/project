package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
final class zzeoc implements zzeok {
    private zzeok[] zzivm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeoc(zzeok... zzeokVarArr) {
        this.zzivm = zzeokVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzeok
    public final boolean zzg(Class<?> cls) {
        for (zzeok zzeokVar : this.zzivm) {
            if (zzeokVar.zzg(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzeok
    public final zzeol zzh(Class<?> cls) {
        zzeok[] zzeokVarArr;
        for (zzeok zzeokVar : this.zzivm) {
            if (zzeokVar.zzg(cls)) {
                return zzeokVar.zzh(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}

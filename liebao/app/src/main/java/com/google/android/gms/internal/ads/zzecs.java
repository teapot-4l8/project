package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeon;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public class zzecs<PrimitiveT, KeyProtoT extends zzeon> implements zzect<PrimitiveT> {
    private final zzecu<KeyProtoT> zziej;
    private final Class<PrimitiveT> zziek;

    public zzecs(zzecu<KeyProtoT> zzecuVar, Class<PrimitiveT> cls) {
        if (!zzecuVar.zzbbl().contains(cls) && !Void.class.equals(cls)) {
            throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", zzecuVar.toString(), cls.getName()));
        }
        this.zziej = zzecuVar;
        this.zziek = cls;
    }

    @Override // com.google.android.gms.internal.ads.zzect
    public final PrimitiveT zzm(zzelq zzelqVar) {
        try {
            return zzb(this.zziej.zzp(zzelqVar));
        } catch (zzenn e2) {
            String valueOf = String.valueOf(this.zziej.zzbbj().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzect
    public final PrimitiveT zza(zzeon zzeonVar) {
        String valueOf = String.valueOf(this.zziej.zzbbj().getName());
        String concat = valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type ");
        if (!this.zziej.zzbbj().isInstance(zzeonVar)) {
            throw new GeneralSecurityException(concat);
        }
        return (PrimitiveT) zzb(zzeonVar);
    }

    @Override // com.google.android.gms.internal.ads.zzect
    public final zzeon zzn(zzelq zzelqVar) {
        try {
            return zzbbi().zzq(zzelqVar);
        } catch (zzenn e2) {
            String valueOf = String.valueOf(this.zziej.zzbbn().zzbbo().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzect
    public final String getKeyType() {
        return this.zziej.getKeyType();
    }

    @Override // com.google.android.gms.internal.ads.zzect
    public final zzeic zzo(zzelq zzelqVar) {
        try {
            return (zzeic) ((zzena) zzeic.zzbey().zzhv(this.zziej.getKeyType()).zzag(zzbbi().zzq(zzelqVar).zzbgy()).zzb(this.zziej.zzbbk()).zzbjv());
        } catch (zzenn e2) {
            throw new GeneralSecurityException("Unexpected proto", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzect
    public final Class<PrimitiveT> zzbbh() {
        return this.zziek;
    }

    private final PrimitiveT zzb(KeyProtoT keyprotot) {
        if (Void.class.equals(this.zziek)) {
            throw new GeneralSecurityException("Cannot create a primitive for Void");
        }
        this.zziej.zzc(keyprotot);
        return (PrimitiveT) this.zziej.zza(keyprotot, (Class<PrimitiveT>) this.zziek);
    }

    private final zzecv<?, KeyProtoT> zzbbi() {
        return new zzecv<>(this.zziej.zzbbn());
    }
}

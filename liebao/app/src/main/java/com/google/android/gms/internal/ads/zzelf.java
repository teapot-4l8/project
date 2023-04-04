package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelf;
import com.google.android.gms.internal.ads.zzelg;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzelf<MessageType extends zzelg<MessageType, BuilderType>, BuilderType extends zzelf<MessageType, BuilderType>> implements zzeom {
    protected abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzemb zzembVar, zzemn zzemnVar);

    @Override // 
    /* renamed from: zzbgx */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2, zzemn zzemnVar) {
        try {
            zzemb zzb = zzemb.zzb(bArr, 0, i2, false);
            zza(zzb, zzemnVar);
            zzb.zzgl(0);
            return this;
        } catch (zzenn e2) {
            throw e2;
        } catch (IOException e3) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + "byte array".length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzeom
    public final /* synthetic */ zzeom zzf(zzeon zzeonVar) {
        if (!zzbjp().getClass().isInstance(zzeonVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return zza((zzelg) zzeonVar);
    }
}

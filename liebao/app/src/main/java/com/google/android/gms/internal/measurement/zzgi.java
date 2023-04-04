package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgg;
import com.google.android.gms.internal.measurement.zzgi;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
public abstract class zzgi<MessageType extends zzgg<MessageType, BuilderType>, BuilderType extends zzgi<MessageType, BuilderType>> implements zzji {
    protected abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzhb zzhbVar, zzhl zzhlVar);

    @Override // 
    /* renamed from: zzt */
    public abstract BuilderType clone();

    public BuilderType zza(byte[] bArr, int i, int i2) {
        try {
            zzhb zza = zzhb.zza(bArr, 0, i2, false);
            zza(zza, zzhl.zza());
            zza.zza(0);
            return this;
        } catch (zzij e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException(zza("byte array"), e3);
        }
    }

    public BuilderType zza(byte[] bArr, int i, int i2, zzhl zzhlVar) {
        try {
            zzhb zza = zzhb.zza(bArr, 0, i2, false);
            zza(zza, zzhlVar);
            zza.zza(0);
            return this;
        } catch (zzij e2) {
            throw e2;
        } catch (IOException e3) {
            throw new RuntimeException(zza("byte array"), e3);
        }
    }

    private final String zza(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf(str).length());
        sb.append("Reading ");
        sb.append(name);
        sb.append(" from a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzji
    public final /* synthetic */ zzji zza(zzjj zzjjVar) {
        if (!zzbv().getClass().isInstance(zzjjVar)) {
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
        return zza((zzgi<MessageType, BuilderType>) ((zzgg) zzjjVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final /* synthetic */ zzji zza(byte[] bArr, zzhl zzhlVar) {
        return zza(bArr, 0, bArr.length, zzhlVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzji
    public final /* synthetic */ zzji zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }
}

package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdzg<E> extends zzdyy<E> {
    private int zzaih;
    @NullableDecl
    private Object[] zzibc;

    public zzdzg() {
        super(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdzg(int i) {
        super(i);
        this.zzibc = new Object[zzdzd.zzez(i)];
    }

    public final zzdzd<E> zzbar() {
        zzdzd<E> zza;
        boolean zzy;
        int i = this.size;
        if (i != 0) {
            if (i == 1) {
                return zzdzd.zzad(this.zziaq[0]);
            }
            if (this.zzibc != null && zzdzd.zzez(this.size) == this.zzibc.length) {
                zzy = zzdzd.zzy(this.size, this.zziaq.length);
                Object[] copyOf = zzy ? Arrays.copyOf(this.zziaq, this.size) : this.zziaq;
                int i2 = this.zzaih;
                Object[] objArr = this.zzibc;
                zza = new zzdzu<>(copyOf, i2, objArr, objArr.length - 1, this.size);
            } else {
                zza = zzdzd.zza(this.size, this.zziaq);
                this.size = zza.size();
            }
            this.zziar = true;
            this.zzibc = null;
            return zza;
        }
        return zzdzu.zzibp;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdyy, com.google.android.gms.internal.ads.zzdyx
    public final /* synthetic */ zzdyx zzg(Iterable iterable) {
        zzdyi.checkNotNull(iterable);
        if (this.zzibc != null) {
            for (Object obj : iterable) {
                zzaa(obj);
            }
        } else {
            super.zzg(iterable);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdyy
    public final /* synthetic */ zzdyy zzab(Object obj) {
        return (zzdzg) zzaa(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdyx
    public final /* synthetic */ zzdyx zza(Iterator it) {
        zzdyi.checkNotNull(it);
        while (it.hasNext()) {
            zzaa(it.next());
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdyy, com.google.android.gms.internal.ads.zzdyx
    public final /* synthetic */ zzdyx zzaa(Object obj) {
        zzdyi.checkNotNull(obj);
        if (this.zzibc != null) {
            int zzez = zzdzd.zzez(this.size);
            Object[] objArr = this.zzibc;
            if (zzez <= objArr.length) {
                int length = objArr.length - 1;
                int hashCode = obj.hashCode();
                int zzex = zzdyw.zzex(hashCode);
                while (true) {
                    int i = zzex & length;
                    Object[] objArr2 = this.zzibc;
                    Object obj2 = objArr2[i];
                    if (obj2 == null) {
                        objArr2[i] = obj;
                        this.zzaih += hashCode;
                        super.zzaa(obj);
                        break;
                    } else if (obj2.equals(obj)) {
                        break;
                    } else {
                        zzex = i + 1;
                    }
                }
                return this;
            }
        }
        this.zzibc = null;
        super.zzaa(obj);
        return this;
    }
}

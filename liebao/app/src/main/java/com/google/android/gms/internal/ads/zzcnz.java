package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcnz implements zzesa<zzebt<String>> {
    private final zzesn<Context> zzeyq;
    private final zzesn<zzei> zzfuc;
    private final zzesn<zzebs> zzgao;

    private zzcnz(zzesn<zzei> zzesnVar, zzesn<Context> zzesnVar2, zzesn<zzebs> zzesnVar3) {
        this.zzfuc = zzesnVar;
        this.zzeyq = zzesnVar2;
        this.zzgao = zzesnVar3;
    }

    public static zzcnz zzx(zzesn<zzei> zzesnVar, zzesn<Context> zzesnVar2, zzesn<zzebs> zzesnVar3) {
        return new zzcnz(zzesnVar, zzesnVar2, zzesnVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzesn
    public final /* synthetic */ Object get() {
        return (zzebt) zzesg.zzbd(this.zzgao.get().zze(new Callable(this.zzfuc.get(), this.zzeyq.get()) { // from class: com.google.android.gms.internal.ads.zzcnw
            private final Context zzclh;
            private final zzei zzgql;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgql = r1;
                this.zzclh = r2;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzei zzeiVar = this.zzgql;
                return zzeiVar.zzcb().zzb(this.zzclh);
            }
        }));
    }
}

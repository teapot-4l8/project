package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@Deprecated
/* loaded from: classes.dex */
public final class zzeix extends zzena<zzeix, zza> implements zzeop {
    private static volatile zzeow<zzeix> zzek;
    private static final zzeix zzilv;
    private String zzilt = "";
    private zzenk<zzeij> zzilu = zzbjm();

    private zzeix() {
    }

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class zza extends zzena.zzb<zzeix, zza> implements zzeop {
        private zza() {
            super(zzeix.zzilv);
        }

        /* synthetic */ zza(zzeiz zzeizVar) {
            this();
        }
    }

    public final List<zzeij> zzbgh() {
        return this.zzilu;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzena
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeiz.zzel[i - 1]) {
            case 1:
                return new zzeix();
            case 2:
                return new zza(null);
            case 3:
                return zza(zzilv, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzilt", "zzilu", zzeij.class});
            case 4:
                return zzilv;
            case 5:
                zzeow<zzeix> zzeowVar = zzek;
                if (zzeowVar == null) {
                    synchronized (zzeix.class) {
                        zzeowVar = zzek;
                        if (zzeowVar == null) {
                            zzeowVar = new zzena.zza<>(zzilv);
                            zzek = zzeowVar;
                        }
                    }
                }
                return zzeowVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static zzeix zzbgi() {
        return zzilv;
    }

    static {
        zzeix zzeixVar = new zzeix();
        zzilv = zzeixVar;
        zzena.zza(zzeix.class, zzeixVar);
    }
}

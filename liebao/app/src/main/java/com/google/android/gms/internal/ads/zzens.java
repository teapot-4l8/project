package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public class zzens {
    private static final zzemn zzioq = zzemn.zzbiv();
    private zzelq zziuy;
    private volatile zzeon zziuz;
    private volatile zzelq zziva;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzens) {
            zzens zzensVar = (zzens) obj;
            zzeon zzeonVar = this.zziuz;
            zzeon zzeonVar2 = zzensVar.zziuz;
            if (zzeonVar == null && zzeonVar2 == null) {
                return zzbgy().equals(zzensVar.zzbgy());
            }
            if (zzeonVar == null || zzeonVar2 == null) {
                if (zzeonVar != null) {
                    return zzeonVar.equals(zzensVar.zzm(zzeonVar.zzbjp()));
                }
                return zzm(zzeonVar2.zzbjp()).equals(zzeonVar2);
            }
            return zzeonVar.equals(zzeonVar2);
        }
        return false;
    }

    private final zzeon zzm(zzeon zzeonVar) {
        if (this.zziuz == null) {
            synchronized (this) {
                if (this.zziuz == null) {
                    try {
                        this.zziuz = zzeonVar;
                        this.zziva = zzelq.zzipc;
                    } catch (zzenn unused) {
                        this.zziuz = zzeonVar;
                        this.zziva = zzelq.zzipc;
                    }
                }
            }
        }
        return this.zziuz;
    }

    public final zzeon zzn(zzeon zzeonVar) {
        zzeon zzeonVar2 = this.zziuz;
        this.zziuy = null;
        this.zziva = null;
        this.zziuz = zzeonVar;
        return zzeonVar2;
    }

    public final int zzbjj() {
        if (this.zziva != null) {
            return this.zziva.size();
        }
        if (this.zziuz != null) {
            return this.zziuz.zzbjj();
        }
        return 0;
    }

    public final zzelq zzbgy() {
        if (this.zziva != null) {
            return this.zziva;
        }
        synchronized (this) {
            if (this.zziva != null) {
                return this.zziva;
            }
            if (this.zziuz == null) {
                this.zziva = zzelq.zzipc;
            } else {
                this.zziva = this.zziuz.zzbgy();
            }
            return this.zziva;
        }
    }
}

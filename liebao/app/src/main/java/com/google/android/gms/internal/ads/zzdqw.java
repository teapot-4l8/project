package com.google.android.gms.internal.ads;

import java.util.LinkedList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdqw {
    private final int maxEntries;
    private final int zzhpx;
    private final LinkedList<zzdrj<?>> zzhpw = new LinkedList<>();
    private final zzdrz zzhpy = new zzdrz();

    public zzdqw(int i, int i2) {
        this.maxEntries = i;
        this.zzhpx = i2;
    }

    public final boolean zzb(zzdrj<?> zzdrjVar) {
        this.zzhpy.zzaxm();
        zzawt();
        if (this.zzhpw.size() == this.maxEntries) {
            return false;
        }
        this.zzhpw.add(zzdrjVar);
        return true;
    }

    public final zzdrj<?> zzawo() {
        this.zzhpy.zzaxm();
        zzawt();
        if (this.zzhpw.isEmpty()) {
            return null;
        }
        zzdrj<?> remove = this.zzhpw.remove();
        if (remove != null) {
            this.zzhpy.zzaxn();
        }
        return remove;
    }

    public final int size() {
        zzawt();
        return this.zzhpw.size();
    }

    public final long getCreationTimeMillis() {
        return this.zzhpy.getCreationTimeMillis();
    }

    public final long zzawp() {
        return this.zzhpy.zzawp();
    }

    public final int zzawq() {
        return this.zzhpy.zzawq();
    }

    public final String zzawr() {
        return this.zzhpy.zzaxc();
    }

    public final zzdry zzaws() {
        return this.zzhpy.zzaxp();
    }

    private final void zzawt() {
        while (!this.zzhpw.isEmpty()) {
            if (!(com.google.android.gms.ads.internal.zzr.zzlc().currentTimeMillis() - this.zzhpw.getFirst().zzhrl >= ((long) this.zzhpx))) {
                return;
            }
            this.zzhpy.zzaxo();
            this.zzhpw.remove();
        }
    }
}

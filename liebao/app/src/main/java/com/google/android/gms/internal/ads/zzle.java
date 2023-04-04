package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
final class zzle implements zzkz {
    private final zzpn zzaxd;
    private final int zzaxm;
    private final int zzaxp;
    private int zzaxq;
    private int zzaxr;

    public zzle(zzky zzkyVar) {
        zzpn zzpnVar = zzkyVar.zzaxd;
        this.zzaxd = zzpnVar;
        zzpnVar.zzbl(12);
        this.zzaxp = this.zzaxd.zzje() & 255;
        this.zzaxm = this.zzaxd.zzje();
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public final boolean zzhd() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public final int zzhb() {
        return this.zzaxm;
    }

    @Override // com.google.android.gms.internal.ads.zzkz
    public final int zzhc() {
        int i = this.zzaxp;
        if (i == 8) {
            return this.zzaxd.readUnsignedByte();
        }
        if (i == 16) {
            return this.zzaxd.readUnsignedShort();
        }
        int i2 = this.zzaxq;
        this.zzaxq = i2 + 1;
        if (i2 % 2 == 0) {
            int readUnsignedByte = this.zzaxd.readUnsignedByte();
            this.zzaxr = readUnsignedByte;
            return (readUnsignedByte & 240) >> 4;
        }
        return this.zzaxr & 15;
    }
}

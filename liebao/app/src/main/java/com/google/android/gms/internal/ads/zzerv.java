package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzerv {
    public static final zzerv zzjeu = new zzerv(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzerv zzjev = new zzerv(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzerv zzjew = new zzerv(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
    private static final zzerv zzjex = new zzerv(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);

    /* renamed from: a  reason: collision with root package name */
    private final double f5351a;

    /* renamed from: b  reason: collision with root package name */
    private final double f5352b;

    /* renamed from: c  reason: collision with root package name */
    private final double f5353c;

    /* renamed from: d  reason: collision with root package name */
    private final double f5354d;
    private final double w;
    private final double zzjeq;
    private final double zzjer;
    private final double zzjes;
    private final double zzjet;

    private zzerv(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.zzjeq = d6;
        this.zzjer = d7;
        this.w = d8;
        this.f5351a = d2;
        this.f5352b = d3;
        this.f5353c = d4;
        this.f5354d = d5;
        this.zzjes = d9;
        this.zzjet = d10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzerv zzervVar = (zzerv) obj;
        return Double.compare(zzervVar.f5351a, this.f5351a) == 0 && Double.compare(zzervVar.f5352b, this.f5352b) == 0 && Double.compare(zzervVar.f5353c, this.f5353c) == 0 && Double.compare(zzervVar.f5354d, this.f5354d) == 0 && Double.compare(zzervVar.zzjes, this.zzjes) == 0 && Double.compare(zzervVar.zzjet, this.zzjet) == 0 && Double.compare(zzervVar.zzjeq, this.zzjeq) == 0 && Double.compare(zzervVar.zzjer, this.zzjer) == 0 && Double.compare(zzervVar.w, this.w) == 0;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.zzjeq);
        long doubleToLongBits2 = Double.doubleToLongBits(this.zzjer);
        long doubleToLongBits3 = Double.doubleToLongBits(this.w);
        long doubleToLongBits4 = Double.doubleToLongBits(this.f5351a);
        long doubleToLongBits5 = Double.doubleToLongBits(this.f5352b);
        long doubleToLongBits6 = Double.doubleToLongBits(this.f5353c);
        long doubleToLongBits7 = Double.doubleToLongBits(this.f5354d);
        long doubleToLongBits8 = Double.doubleToLongBits(this.zzjes);
        long doubleToLongBits9 = Double.doubleToLongBits(this.zzjet);
        return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(zzjeu)) {
            return "Rotate 0°";
        }
        if (equals(zzjev)) {
            return "Rotate 90°";
        }
        if (equals(zzjew)) {
            return "Rotate 180°";
        }
        if (equals(zzjex)) {
            return "Rotate 270°";
        }
        double d2 = this.zzjeq;
        double d3 = this.zzjer;
        double d4 = this.w;
        double d5 = this.f5351a;
        double d6 = this.f5352b;
        double d7 = this.f5353c;
        double d8 = this.f5354d;
        double d9 = this.zzjes;
        double d10 = this.zzjet;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d2);
        sb.append(", v=");
        sb.append(d3);
        sb.append(", w=");
        sb.append(d4);
        sb.append(", a=");
        sb.append(d5);
        sb.append(", b=");
        sb.append(d6);
        sb.append(", c=");
        sb.append(d7);
        sb.append(", d=");
        sb.append(d8);
        sb.append(", tx=");
        sb.append(d9);
        sb.append(", ty=");
        sb.append(d10);
        sb.append("}");
        return sb.toString();
    }

    public static zzerv zzs(ByteBuffer byteBuffer) {
        double zzi = zzbp.zzi(byteBuffer);
        double zzi2 = zzbp.zzi(byteBuffer);
        double zzj = zzbp.zzj(byteBuffer);
        return new zzerv(zzi, zzi2, zzbp.zzi(byteBuffer), zzbp.zzi(byteBuffer), zzj, zzbp.zzj(byteBuffer), zzbp.zzj(byteBuffer), zzbp.zzi(byteBuffer), zzbp.zzi(byteBuffer));
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public class zzvt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvt> CREATOR = new zzvw();
    public final int height;
    public final int heightPixels;
    public final int width;
    public final int widthPixels;
    public final String zzadd;
    public boolean zzadh;
    public final boolean zzbsb;
    public final boolean zzcir;
    public final zzvt[] zzcis;
    public final boolean zzcit;
    public boolean zzciu;
    public boolean zzciv;
    private boolean zzciw;
    public boolean zzcix;
    public boolean zzciy;

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (zzd(displayMetrics) * displayMetrics.density);
    }

    private static int zzd(DisplayMetrics displayMetrics) {
        int i = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzvt zzqk() {
        return new zzvt("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false, false, false);
    }

    public static zzvt zzql() {
        return new zzvt("reward_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false);
    }

    public static zzvt zzqm() {
        return new zzvt("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false, false, false);
    }

    public zzvt() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false);
    }

    public static zzvt zzqn() {
        return new zzvt("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false, false);
    }

    public zzvt(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzvt(Context context, AdSize[] adSizeArr) {
        int i;
        int i2;
        double d2;
        double d3;
        AdSize adSize = adSizeArr[0];
        this.zzcir = false;
        this.zzcit = adSize.isFluid();
        this.zzcix = com.google.android.gms.ads.zza.zzc(adSize);
        this.zzciy = com.google.android.gms.ads.zza.zzd(adSize);
        boolean zza = com.google.android.gms.ads.zza.zza(adSize);
        this.zzadh = zza;
        if (this.zzcit) {
            this.width = AdSize.BANNER.getWidth();
            this.height = AdSize.BANNER.getHeight();
        } else if (this.zzciy) {
            this.width = adSize.getWidth();
            this.height = com.google.android.gms.ads.zza.zze(adSize);
        } else if (zza) {
            this.width = adSize.getWidth();
            this.height = com.google.android.gms.ads.zza.zzb(adSize);
        } else {
            this.width = adSize.getWidth();
            this.height = adSize.getHeight();
        }
        boolean z = this.width == -1;
        boolean z2 = this.height == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            zzww.zzqw();
            if (zzbae.zzbs(context)) {
                zzww.zzqw();
                if (zzbae.zzbt(context)) {
                    int i3 = displayMetrics.widthPixels;
                    zzww.zzqw();
                    this.widthPixels = i3 - zzbae.zzbu(context);
                    d2 = this.widthPixels / displayMetrics.density;
                    i = (int) d2;
                    d3 = i;
                    Double.isNaN(d2);
                    Double.isNaN(d3);
                    if (d2 - d3 >= 0.01d) {
                        i++;
                    }
                }
            }
            this.widthPixels = displayMetrics.widthPixels;
            d2 = this.widthPixels / displayMetrics.density;
            i = (int) d2;
            d3 = i;
            Double.isNaN(d2);
            Double.isNaN(d3);
            if (d2 - d3 >= 0.01d) {
            }
        } else {
            i = this.width;
            zzww.zzqw();
            this.widthPixels = zzbae.zza(displayMetrics, this.width);
        }
        if (z2) {
            i2 = zzd(displayMetrics);
        } else {
            i2 = this.height;
        }
        zzww.zzqw();
        this.heightPixels = zzbae.zza(displayMetrics, i2);
        if (z || z2) {
            StringBuilder sb = new StringBuilder(26);
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            sb.append("_as");
            this.zzadd = sb.toString();
        } else if (this.zzciy || this.zzadh) {
            int i4 = this.width;
            int i5 = this.height;
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append(i4);
            sb2.append("x");
            sb2.append(i5);
            sb2.append("_as");
            this.zzadd = sb2.toString();
        } else if (this.zzcit) {
            this.zzadd = "320x50_mb";
        } else {
            this.zzadd = adSize.toString();
        }
        if (adSizeArr.length > 1) {
            this.zzcis = new zzvt[adSizeArr.length];
            for (int i6 = 0; i6 < adSizeArr.length; i6++) {
                this.zzcis[i6] = new zzvt(context, adSizeArr[i6]);
            }
        } else {
            this.zzcis = null;
        }
        this.zzbsb = false;
        this.zzciu = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvt(String str, int i, int i2, boolean z, int i3, int i4, zzvt[] zzvtVarArr, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.zzadd = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzcir = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzcis = zzvtVarArr;
        this.zzbsb = z2;
        this.zzcit = z3;
        this.zzciu = z4;
        this.zzciv = z5;
        this.zzciw = z6;
        this.zzcix = z7;
        this.zzciy = z8;
        this.zzadh = z9;
    }

    public final AdSize zzqo() {
        return com.google.android.gms.ads.zza.zza(this.width, this.height, this.zzadd);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzadd, false);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.heightPixels);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzcir);
        SafeParcelWriter.writeInt(parcel, 6, this.width);
        SafeParcelWriter.writeInt(parcel, 7, this.widthPixels);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzcis, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbsb);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzcit);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzciu);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzciv);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzciw);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzcix);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzciy);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzadh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzaei extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaei> CREATOR = new zzael();
    public final int versionCode;
    public final int zzboc;
    public final int zzbod;
    public final boolean zzboe;
    public final int zzbof;
    public final boolean zzboh;
    public final boolean zzdgx;
    public final zzaaz zzdgy;

    public zzaei(NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzaaz(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzjx(), nativeAdOptions.getMediaAspectRatio());
    }

    public zzaei(com.google.android.gms.ads.nativead.NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), -1, nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new zzaaz(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zzjx(), nativeAdOptions.getMediaAspectRatio());
    }

    public zzaei(int i, boolean z, int i2, boolean z2, int i3, zzaaz zzaazVar, boolean z3, int i4) {
        this.versionCode = i;
        this.zzdgx = z;
        this.zzboc = i2;
        this.zzboe = z2;
        this.zzbof = i3;
        this.zzdgy = zzaazVar;
        this.zzboh = z3;
        this.zzbod = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdgx);
        SafeParcelWriter.writeInt(parcel, 3, this.zzboc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzboe);
        SafeParcelWriter.writeInt(parcel, 5, this.zzbof);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdgy, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzboh);
        SafeParcelWriter.writeInt(parcel, 8, this.zzbod);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static com.google.android.gms.ads.nativead.NativeAdOptions zzb(zzaei zzaeiVar) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzaeiVar == null) {
            return builder.build();
        }
        int i = zzaeiVar.versionCode;
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    builder.setRequestCustomMuteThisAd(zzaeiVar.zzboh).setMediaAspectRatio(zzaeiVar.zzbod);
                }
                builder.setReturnUrlsForImageAssets(zzaeiVar.zzdgx).setRequestMultipleImages(zzaeiVar.zzboe);
                return builder.build();
            }
            zzaaz zzaazVar = zzaeiVar.zzdgy;
            if (zzaazVar != null) {
                builder.setVideoOptions(new VideoOptions(zzaazVar));
            }
        }
        builder.setAdChoicesPlacement(zzaeiVar.zzbof);
        builder.setReturnUrlsForImageAssets(zzaeiVar.zzdgx).setRequestMultipleImages(zzaeiVar.zzboe);
        return builder.build();
    }

    public static com.google.android.gms.ads.formats.NativeAdOptions zzc(zzaei zzaeiVar) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (zzaeiVar == null) {
            return builder.build();
        }
        int i = zzaeiVar.versionCode;
        if (i != 2) {
            if (i != 3) {
                if (i == 4) {
                    builder.setRequestCustomMuteThisAd(zzaeiVar.zzboh).setMediaAspectRatio(zzaeiVar.zzbod);
                }
                builder.setReturnUrlsForImageAssets(zzaeiVar.zzdgx).setImageOrientation(zzaeiVar.zzboc).setRequestMultipleImages(zzaeiVar.zzboe);
                return builder.build();
            }
            zzaaz zzaazVar = zzaeiVar.zzdgy;
            if (zzaazVar != null) {
                builder.setVideoOptions(new VideoOptions(zzaazVar));
            }
        }
        builder.setAdChoicesPlacement(zzaeiVar.zzbof);
        builder.setReturnUrlsForImageAssets(zzaeiVar.zzdgx).setImageOrientation(zzaeiVar.zzboc).setRequestMultipleImages(zzaeiVar.zzboe);
        return builder.build();
    }
}

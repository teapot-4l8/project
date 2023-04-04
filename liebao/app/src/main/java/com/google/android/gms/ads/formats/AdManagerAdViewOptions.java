package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzaax;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzagp;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class AdManagerAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdManagerAdViewOptions> CREATOR = new zzb();
    private final boolean zzbns;
    private final IBinder zzbnt;

    private AdManagerAdViewOptions(Builder builder) {
        this.zzbns = builder.zzbns;
        this.zzbnt = builder.zzbnu != null ? new zzaax(builder.zzbnu) : null;
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean zzbns = false;
        private ShouldDelayBannerRenderingListener zzbnu;

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.zzbns = z;
            return this;
        }

        public final Builder setShouldDelayBannerRenderingListener(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
            this.zzbnu = shouldDelayBannerRenderingListener;
            return this;
        }

        public final AdManagerAdViewOptions build() {
            return new AdManagerAdViewOptions(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdManagerAdViewOptions(boolean z, IBinder iBinder) {
        this.zzbns = z;
        this.zzbnt = iBinder;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.zzbns;
    }

    public final zzagm zzjv() {
        return zzagp.zzy(this.zzbnt);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzbnt, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

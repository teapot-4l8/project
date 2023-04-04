package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzti extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzti> CREATOR = new zztl();
    public final String url;
    private final long zzbvx;
    private final String zzbvy;
    private final String zzbvz;
    private final String zzbwa;
    private final Bundle zzbwb;
    public final boolean zzbwc;
    public long zzbwd;
    public String zzbwe;
    public int zzbwf;

    public static zzti zzbs(String str) {
        return zzd(Uri.parse(str));
    }

    public static zzti zzd(Uri uri) {
        try {
            if ("gcache".equals(uri.getScheme())) {
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments.size() != 2) {
                    int size = pathSegments.size();
                    StringBuilder sb = new StringBuilder(62);
                    sb.append("Expected 2 path parts for namespace and id, found :");
                    sb.append(size);
                    com.google.android.gms.ads.internal.util.zzd.zzez(sb.toString());
                    return null;
                }
                String str = pathSegments.get(0);
                String str2 = pathSegments.get(1);
                String host = uri.getHost();
                String queryParameter = uri.getQueryParameter(ImagesContract.URL);
                boolean equals = "1".equals(uri.getQueryParameter("read_only"));
                String queryParameter2 = uri.getQueryParameter("expiration");
                long parseLong = queryParameter2 == null ? 0L : Long.parseLong(queryParameter2);
                Bundle bundle = new Bundle();
                for (String str3 : uri.getQueryParameterNames()) {
                    if (str3.startsWith("tag.")) {
                        bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                    }
                }
                return new zzti(queryParameter, parseLong, host, str, str2, bundle, equals, 0L, "", 0);
            }
            return null;
        } catch (NullPointerException | NumberFormatException e2) {
            com.google.android.gms.ads.internal.util.zzd.zzd("Unable to parse Uri into cache offering.", e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzti(String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z, long j2, String str5, int i) {
        this.url = str;
        this.zzbvx = j;
        this.zzbvy = str2 == null ? "" : str2;
        this.zzbvz = str3 == null ? "" : str3;
        this.zzbwa = str4 == null ? "" : str4;
        this.zzbwb = bundle == null ? new Bundle() : bundle;
        this.zzbwc = z;
        this.zzbwd = j2;
        this.zzbwe = str5;
        this.zzbwf = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.url, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzbvx);
        SafeParcelWriter.writeString(parcel, 4, this.zzbvy, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbvz, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzbwa, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzbwb, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbwc);
        SafeParcelWriter.writeLong(parcel, 9, this.zzbwd);
        SafeParcelWriter.writeString(parcel, 10, this.zzbwe, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzbwf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

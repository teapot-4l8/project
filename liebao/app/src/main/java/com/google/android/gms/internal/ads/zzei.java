package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzei {
    private static final String[] zzyc = {"/aclk", "/pcs/click", "/dbm/clk"};
    private String zzxy = "googleads.g.doubleclick.net";
    private String zzxz = "/pagead/ads";
    private String zzya = "ad.doubleclick.net";
    private String[] zzyb = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzdy zzyd;

    public zzei(zzdy zzdyVar) {
        this.zzyd = zzdyVar;
    }

    private final boolean zza(Uri uri) {
        if (uri == null) {
            throw null;
        }
        try {
            return uri.getHost().equals(this.zzya);
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public final boolean zzb(Uri uri) {
        if (uri != null) {
            try {
                String host = uri.getHost();
                for (String str : this.zzyb) {
                    if (host.endsWith(str)) {
                        return true;
                    }
                }
            } catch (NullPointerException unused) {
            }
            return false;
        }
        throw null;
    }

    public final zzdy zzcb() {
        return this.zzyd;
    }

    public final Uri zza(Uri uri, Context context) {
        return zza(uri, this.zzyd.zzb(context));
    }

    public final void zza(MotionEvent motionEvent) {
        this.zzyd.zza(motionEvent);
    }

    public final Uri zza(Uri uri, Context context, View view, Activity activity) {
        try {
            return zza(uri, this.zzyd.zza(context, uri.getQueryParameter("ai"), view, activity));
        } catch (UnsupportedOperationException unused) {
            throw new zzeh("Provided Uri is not in a valid state");
        }
    }

    public final boolean zzc(Uri uri) {
        if (zzb(uri)) {
            for (String str : zzyc) {
                if (uri.getPath().endsWith(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private final Uri zza(Uri uri, String str) {
        try {
            boolean zza = zza(uri);
            if (zza) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzeh("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzeh("Query parameter already exists: ms");
            }
            if (zza) {
                String uri2 = uri.toString();
                int indexOf = uri2.indexOf(";adurl");
                if (indexOf != -1) {
                    int i = indexOf + 1;
                    return Uri.parse(uri2.substring(0, i) + "dc_ms=" + str + ";" + uri2.substring(i));
                }
                String encodedPath = uri.getEncodedPath();
                int indexOf2 = uri2.indexOf(encodedPath);
                return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";dc_ms=" + str + ";" + uri2.substring(indexOf2 + encodedPath.length()));
            }
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            if (indexOf3 != -1) {
                int i2 = indexOf3 + 1;
                return Uri.parse(uri3.substring(0, i2) + "ms=" + str + "&" + uri3.substring(i2));
            }
            return uri.buildUpon().appendQueryParameter("ms", str).build();
        } catch (UnsupportedOperationException unused) {
            throw new zzeh("Provided Uri is not in a valid state");
        }
    }
}

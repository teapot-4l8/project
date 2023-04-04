package com.google.android.gms.internal.consent_sdk;

import android.util.JsonReader;
import android.util.JsonWriter;
import java.io.IOException;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public final class zzbu {
    public static final int zza = 1;
    public static final int zzb = 2;
    public static final int zzc = 3;
    public static final int zzd = 1;
    public static final int zze = 2;
    public static final int zzf = 3;
    public static final int zzg = 1;
    public static final int zzh = 2;
    public static final int zzi = 3;
    public static final int zzj = 4;
    public static final int zzk = 5;
    public static final int zzl = 6;
    public static final int zzm = 7;
    public static final int zzn = 8;
    private static final /* synthetic */ int[] zzo = {1, 2, 3};
    private static final /* synthetic */ int[] zzp = {1, 2, 3};
    private static final /* synthetic */ int[] zzq = {1, 2, 3, 4, 5, 6, 7, 8};

    public static int[] zza() {
        return (int[]) zzo.clone();
    }

    public static void zza(int i, JsonWriter jsonWriter) {
        if (i != 0) {
            int i2 = zzbq.zza[i - 1];
            if (i2 == 1) {
                jsonWriter.value("UNKNOWN");
                return;
            } else if (i2 == 2) {
                jsonWriter.value("ANDROID");
                return;
            } else if (i2 != 3) {
                return;
            } else {
                jsonWriter.value("IOS");
                return;
            }
        }
        throw null;
    }

    public static int[] zzb() {
        return (int[]) zzp.clone();
    }

    public static int zza(JsonReader jsonReader) {
        char c2;
        String nextString = jsonReader.nextString();
        int hashCode = nextString.hashCode();
        if (hashCode == 64208429) {
            if (nextString.equals("CLEAR")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != 82862015) {
            if (hashCode == 1856333582 && nextString.equals("UNKNOWN_ACTION_TYPE")) {
                c2 = 0;
            }
            c2 = 65535;
        } else {
            if (nextString.equals("WRITE")) {
                c2 = 1;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            if (c2 != 1) {
                if (c2 == 2) {
                    return zzf;
                }
                String valueOf = String.valueOf(nextString);
                throw new IOException(valueOf.length() != 0 ? "Failed to parse contentads.contributor.direct.serving.gdpr.appapi.ApplicationGdprResponse.Action.ActionTypefrom: ".concat(valueOf) : new String("Failed to parse contentads.contributor.direct.serving.gdpr.appapi.ApplicationGdprResponse.Action.ActionTypefrom: "));
            }
            return zze;
        }
        return zzd;
    }

    public static int[] zzc() {
        return (int[]) zzq.clone();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int zzb(JsonReader jsonReader) {
        char c2;
        String nextString = jsonReader.nextString();
        switch (nextString.hashCode()) {
            case -2058725357:
                if (nextString.equals("CONSENT_SIGNAL_COLLECT_CONSENT")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case -1969035850:
                if (nextString.equals("CONSENT_SIGNAL_ERROR")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -1263695752:
                if (nextString.equals("CONSENT_SIGNAL_UNKNOWN")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -954325659:
                if (nextString.equals("CONSENT_SIGNAL_NON_PERSONALIZED_ADS")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -918677260:
                if (nextString.equals("CONSENT_SIGNAL_PUBLISHER_MISCONFIGURATION")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 429411856:
                if (nextString.equals("CONSENT_SIGNAL_SUFFICIENT")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 467888915:
                if (nextString.equals("CONSENT_SIGNAL_PERSONALIZED_ADS")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1725474845:
                if (nextString.equals("CONSENT_SIGNAL_NOT_REQUIRED")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                return zzg;
            case 1:
                return zzh;
            case 2:
                return zzi;
            case 3:
                return zzj;
            case 4:
                return zzk;
            case 5:
                return zzl;
            case 6:
                return zzm;
            case 7:
                return zzn;
            default:
                String valueOf = String.valueOf(nextString);
                throw new IOException(valueOf.length() != 0 ? "Failed to parse contentads.contributor.direct.serving.gdpr.appapi.ApplicationGdprResponse.ConsentSignalfrom: ".concat(valueOf) : new String("Failed to parse contentads.contributor.direct.serving.gdpr.appapi.ApplicationGdprResponse.ConsentSignalfrom: "));
        }
    }
}

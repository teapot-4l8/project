package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.api.Releasable;
import com.umeng.analytics.pro.ak;
import com.umeng.analytics.pro.d;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public abstract class zzbek implements Releasable {
    protected Context mContext;
    protected String zzeiz;
    protected WeakReference<zzbcs> zzerx;

    public zzbek(zzbcs zzbcsVar) {
        this.mContext = zzbcsVar.getContext();
        this.zzeiz = com.google.android.gms.ads.internal.zzr.zzkv().zzq(this.mContext, zzbcsVar.zzacc().zzbrz);
        this.zzerx = new WeakReference<>(zzbcsVar);
    }

    public abstract void abort();

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzdq(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzdr(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzds(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzdt(int i) {
    }

    public abstract boolean zzfh(String str);

    public boolean zze(String str, String[] strArr) {
        return zzfh(str);
    }

    public final void zza(String str, String str2, long j, long j2, boolean z, long j3, long j4, long j5, int i, int i2) {
        zzbae.zzaah.post(new zzbem(this, str, str2, j, j2, j3, j4, j5, z, i, i2));
    }

    public final void zza(String str, String str2, int i, int i2, long j, long j2, boolean z, int i3, int i4) {
        zzbae.zzaah.post(new zzbel(this, str, str2, i, i2, j, j2, z, i3, i4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(String str, String str2, int i) {
        zzbae.zzaah.post(new zzbeo(this, str, str2, i));
    }

    public final void zzc(String str, String str2, long j) {
        zzbae.zzaah.post(new zzben(this, str, str2, j));
    }

    public final void zza(String str, String str2, String str3, String str4) {
        zzbae.zzaah.post(new zzbeq(this, str, str2, str3, str4));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String zzfi(String str) {
        return zzbae.zzes(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String zzfj(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1947652542:
                if (str.equals("interrupted")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1396664534:
                if (str.equals("badUrl")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -1347010958:
                if (str.equals("inProgress")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -918817863:
                if (str.equals("downloadTimeout")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case -659376217:
                if (str.equals("contentLengthMissing")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -642208130:
                if (str.equals("playerFailed")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -354048396:
                if (str.equals("sizeExceeded")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case -32082395:
                if (str.equals("externalAbort")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 3387234:
                if (str.equals("noop")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 96784904:
                if (str.equals(d.O)) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 580119100:
                if (str.equals("expireFailed")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 725497484:
                if (str.equals("noCacheDir")) {
                    c2 = 7;
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
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            default:
                return UMModuleRegister.INNER;
            case 6:
            case 7:
                return "io";
            case '\b':
            case '\t':
                return "network";
            case '\n':
            case 11:
                return ak.bo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, Map<String, String> map) {
        zzbcs zzbcsVar = this.zzerx.get();
        if (zzbcsVar != null) {
            zzbcsVar.zza(str, map);
        }
    }
}

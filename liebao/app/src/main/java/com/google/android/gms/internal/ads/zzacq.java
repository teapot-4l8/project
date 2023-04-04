package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.a.a;
import androidx.browser.a.b;
import androidx.browser.a.d;
import androidx.browser.a.e;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzacq implements zzeso {
    private e zzdct;
    private b zzdcu;
    private d zzdcv;
    private zzact zzdcw;

    public static boolean zzj(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        if (queryIntentActivities != null && resolveActivity != null) {
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                    return resolveActivity.activityInfo.packageName.equals(zzesm.zzcp(context));
                }
            }
        }
        return false;
    }

    public final void zzc(Activity activity) {
        d dVar = this.zzdcv;
        if (dVar == null) {
            return;
        }
        activity.unbindService(dVar);
        this.zzdcu = null;
        this.zzdct = null;
        this.zzdcv = null;
    }

    public final e zzsz() {
        b bVar = this.zzdcu;
        if (bVar == null) {
            this.zzdct = null;
        } else if (this.zzdct == null) {
            this.zzdct = bVar.a((a) null);
        }
        return this.zzdct;
    }

    public final void zza(zzact zzactVar) {
        this.zzdcw = zzactVar;
    }

    public final void zzd(Activity activity) {
        String zzcp;
        if (this.zzdcu == null && (zzcp = zzesm.zzcp(activity)) != null) {
            zzesp zzespVar = new zzesp(this);
            this.zzdcv = zzespVar;
            b.a(activity, zzcp, zzespVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeso
    public final void zza(b bVar) {
        this.zzdcu = bVar;
        bVar.a(0L);
        zzact zzactVar = this.zzdcw;
        if (zzactVar != null) {
            zzactVar.zztb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeso
    public final void zzta() {
        this.zzdcu = null;
        this.zzdct = null;
        zzact zzactVar = this.zzdcw;
        if (zzactVar != null) {
            zzactVar.zztc();
        }
    }
}

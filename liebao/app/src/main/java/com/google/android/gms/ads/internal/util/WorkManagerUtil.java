package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.work.b;
import androidx.work.c;
import androidx.work.e;
import androidx.work.i;
import androidx.work.j;
import androidx.work.n;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbao;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public class WorkManagerUtil extends zzbf {
    private static void zzbo(Context context) {
        try {
            n.a(context.getApplicationContext(), new b.a().a());
        } catch (IllegalStateException unused) {
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzbg
    public final boolean zzd(IObjectWrapper iObjectWrapper, String str, String str2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzbo(context);
        c a2 = new c.a().a(i.CONNECTED).a();
        try {
            n.a(context).a(new j.a(OfflineNotificationPoster.class).a(a2).a(new e.a().a("uri", str).a("gws_query_id", str2).a()).a("offline_notification_work").e());
            return true;
        } catch (IllegalStateException e2) {
            zzbao.zzd("Failed to instantiate WorkManager.", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzbg
    public final void zzaq(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzbo(context);
        try {
            n a2 = n.a(context);
            a2.a("offline_ping_sender_work");
            a2.a(new j.a(OfflinePingSender.class).a(new c.a().a(i.CONNECTED).a()).a("offline_ping_sender_work").e());
        } catch (IllegalStateException e2) {
            zzbao.zzd("Failed to instantiate WorkManager.", e2);
        }
    }
}

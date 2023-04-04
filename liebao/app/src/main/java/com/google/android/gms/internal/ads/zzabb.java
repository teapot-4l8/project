package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.just.agentweb.DefaultWebClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzabb {
    private final Context context;

    public zzabb(Context context) {
        Preconditions.checkNotNull(context, "Context can not be null");
        this.context = context;
    }

    public final boolean zzsd() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return zza(intent);
    }

    public final boolean zzse() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(DefaultWebClient.SCHEME_SMS));
        return zza(intent);
    }

    public final boolean zzsf() {
        return ((Boolean) com.google.android.gms.ads.internal.util.zzbr.zza(this.context, new zzaba())).booleanValue() && Wrappers.packageManager(this.context).checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public final boolean zzsg() {
        return zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }

    private final boolean zza(Intent intent) {
        Preconditions.checkNotNull(intent, "Intent can not be null");
        return !this.context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }
}

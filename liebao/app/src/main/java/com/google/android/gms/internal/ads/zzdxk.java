package com.google.android.gms.internal.ads;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdxk {
    private static final int FLAG_IMMUTABLE;
    private static final ClipData zzhyl;

    private static boolean zzu(int i, int i2) {
        return (i & i2) == i2;
    }

    @Nullable
    public static PendingIntent getService(Context context, int i, Intent intent, int i2) {
        boolean z = true;
        zzdyi.checkArgument((i2 & 95) == 0, "Cannot set any dangerous parts of intent to be mutable.");
        zzdyi.checkArgument(intent.getComponent() != null, "Must set component on Intent.");
        if (zzu(0, 1)) {
            zzdyi.checkArgument(!zzu(i2, 67108864), "Cannot set mutability flags if PendingIntent.FLAG_IMMUTABLE is set.");
        } else {
            if (Build.VERSION.SDK_INT >= 23 && !zzu(i2, 67108864)) {
                z = false;
            }
            zzdyi.checkArgument(z, "Must set PendingIntent.FLAG_IMMUTABLE for SDK >= 23 if no parts of intent are mutable.");
        }
        Intent intent2 = new Intent(intent);
        if (Build.VERSION.SDK_INT < 23 || !zzu(i2, 67108864)) {
            if (intent2.getPackage() == null) {
                intent2.setPackage(intent2.getComponent().getPackageName());
            }
            if (!zzu(0, 3) && intent2.getAction() == null) {
                intent2.setAction("");
            }
            if (!zzu(0, 9) && intent2.getCategories() == null) {
                intent2.addCategory("");
            }
            if (!zzu(0, 5) && intent2.getData() == null) {
                intent2.setDataAndType(Uri.EMPTY, "*/*");
            }
            if (!zzu(0, 17) && intent2.getClipData() == null) {
                intent2.setClipData(zzhyl);
            }
        }
        return PendingIntent.getService(context, 0, intent2, i2);
    }

    static {
        FLAG_IMMUTABLE = Build.VERSION.SDK_INT > 22 ? 67108864 : 0;
        zzhyl = ClipData.newIntent("", new Intent());
    }
}

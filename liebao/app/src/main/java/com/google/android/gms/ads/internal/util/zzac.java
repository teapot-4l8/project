package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzabq;
import com.google.android.gms.internal.ads.zzww;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzac extends zzz {
    @Override // com.google.android.gms.ads.internal.util.zzr
    public final void zzi(Activity activity) {
        if (((Boolean) zzww.zzra().zzd(zzabq.zzcqj)).booleanValue() && com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzm() == null && !activity.isInMultiWindowMode()) {
            zza(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this, activity) { // from class: com.google.android.gms.ads.internal.util.zzab
                private final zzac zzeha;
                private final Activity zzehb;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzeha = this;
                    this.zzehb = activity;
                }

                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return zzac.zza(this.zzehb, view, windowInsets);
                }
            });
        }
    }

    private static void zza(boolean z, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i = attributes.layoutInDisplayCutoutMode;
        int i2 = z ? 1 : 2;
        if (i2 != i) {
            attributes.layoutInDisplayCutoutMode = i2;
            window.setAttributes(attributes);
        }
    }

    public static /* synthetic */ WindowInsets zza(Activity activity, View view, WindowInsets windowInsets) {
        if (com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzzm() == null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            String str = "";
            if (displayCutout != null) {
                zzf zzyl = com.google.android.gms.ads.internal.zzr.zzkz().zzyl();
                for (Rect rect : displayCutout.getBoundingRects()) {
                    String format = String.format(Locale.US, "%d,%d,%d,%d", Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom));
                    if (!TextUtils.isEmpty(str)) {
                        str = String.valueOf(str).concat("|");
                    }
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(format);
                    str = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                }
                zzyl.zzeh(str);
            } else {
                com.google.android.gms.ads.internal.zzr.zzkz().zzyl().zzeh("");
            }
        }
        zza(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }
}

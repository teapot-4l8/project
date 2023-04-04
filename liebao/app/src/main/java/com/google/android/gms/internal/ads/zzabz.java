package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
@Deprecated
/* loaded from: classes.dex */
public final class zzabz {
    public static void zza(zzabx zzabxVar, zzabu zzabuVar) {
        if (zzabuVar.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzabuVar.zzma())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        zzabxVar.zza(zzabuVar.getContext(), zzabuVar.zzma(), zzabuVar.zzsm(), zzabuVar.zzsn());
    }
}

package com.google.android.gms.internal.ads;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public interface zzyh extends IInterface {
    String getVersionString();

    void initialize();

    void setAppMuted(boolean z);

    void setAppVolume(float f);

    void zza(zzaat zzaatVar);

    void zza(zzajt zzajtVar);

    void zza(zzann zzannVar);

    void zza(String str, IObjectWrapper iObjectWrapper);

    void zzb(IObjectWrapper iObjectWrapper, String str);

    void zzcd(String str);

    void zzce(String str);

    float zzrg();

    boolean zzrh();

    List<zzajm> zzri();

    void zzrj();
}

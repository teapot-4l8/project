package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzatf {
    @Nonnull
    private final View zzaay;
    private final Map<String, WeakReference<View>> zzdva;
    private final zzazc zzdvb;

    public zzatf(zzatg zzatgVar) {
        View view;
        Map<String, WeakReference<View>> map;
        View view2;
        Map<String, WeakReference<View>> map2;
        view = zzatgVar.zzaay;
        this.zzaay = view;
        map = zzatgVar.zzdva;
        this.zzdva = map;
        view2 = zzatgVar.zzaay;
        zzazc zzp = zzatd.zzp(view2.getContext());
        this.zzdvb = zzp;
        if (zzp == null || (map2 = this.zzdva) == null || map2.isEmpty()) {
            return;
        }
        try {
            this.zzdvb.zza(new zzatj(ObjectWrapper.wrap(this.zzaay).asBinder(), ObjectWrapper.wrap(this.zzdva).asBinder()));
        } catch (RemoteException unused) {
            zzbao.zzex("Failed to call remote method.");
        }
    }

    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzdvb == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdvb.zza(list, ObjectWrapper.wrap(this.zzaay), new zzate(this, updateImpressionUrlsCallback));
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateImpressionUrlsCallback.onFailure(sb.toString());
        }
    }

    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzdvb == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdvb.zzb(new ArrayList(Arrays.asList(uri)), ObjectWrapper.wrap(this.zzaay), new zzath(this, updateClickUrlCallback));
        } catch (RemoteException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateClickUrlCallback.onFailure(sb.toString());
        }
    }

    public final void reportTouchEvent(MotionEvent motionEvent) {
        zzazc zzazcVar = this.zzdvb;
        if (zzazcVar == null) {
            zzbao.zzdz("Failed to get internal reporting info generator.");
            return;
        }
        try {
            zzazcVar.zzao(ObjectWrapper.wrap(motionEvent));
        } catch (RemoteException unused) {
            zzbao.zzex("Failed to call remote method.");
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.umeng.analytics.pro.d;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdcd implements zzdhe<zzdce> {
    private final Context context;
    private final zzdpm zzfzg;
    private final zzebs zzhdd;
    private final View zzhde;

    public zzdcd(zzebs zzebsVar, Context context, zzdpm zzdpmVar, ViewGroup viewGroup) {
        this.zzhdd = zzebsVar;
        this.context = context;
        this.zzfzg = zzdpmVar;
        this.zzhde = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzdhe
    public final zzebt<zzdce> zzatu() {
        return this.zzhdd.zze(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdcg
            private final zzdcd zzhdh;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzhdh = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzhdh.zzatv();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdce zzatv() {
        Context context = this.context;
        zzvt zzvtVar = this.zzfzg.zzbpy;
        ArrayList arrayList = new ArrayList();
        View view = this.zzhde;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            int indexOfChild = parent instanceof ViewGroup ? ((ViewGroup) parent).indexOfChild(view) : -1;
            Bundle bundle = new Bundle();
            bundle.putString(d.y, parent.getClass().getName());
            bundle.putInt("index_of_child", indexOfChild);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzdce(context, zzvtVar, arrayList);
    }
}

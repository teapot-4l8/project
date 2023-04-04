package com.google.android.gms.internal.ads;

import androidx.b.g;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzcdy {
    public static final zzcdy zzghq = new zzcea().zzapk();
    private final zzafx zzghj;
    private final zzafs zzghk;
    private final zzagl zzghl;
    private final zzagg zzghm;
    private final zzakg zzghn;
    private final g<String, zzagd> zzgho;
    private final g<String, zzafy> zzghp;

    public final zzafx zzapd() {
        return this.zzghj;
    }

    public final zzafs zzape() {
        return this.zzghk;
    }

    public final zzagl zzapf() {
        return this.zzghl;
    }

    public final zzagg zzapg() {
        return this.zzghm;
    }

    public final zzakg zzaph() {
        return this.zzghn;
    }

    public final zzagd zzgb(String str) {
        return this.zzgho.get(str);
    }

    public final zzafy zzgc(String str) {
        return this.zzghp.get(str);
    }

    public final ArrayList<String> zzapi() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.zzghl != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.zzghj != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.zzghk != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.zzgho.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.zzghn != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    public final ArrayList<String> zzapj() {
        ArrayList<String> arrayList = new ArrayList<>(this.zzgho.size());
        for (int i = 0; i < this.zzgho.size(); i++) {
            arrayList.add(this.zzgho.b(i));
        }
        return arrayList;
    }

    private zzcdy(zzcea zzceaVar) {
        this.zzghj = zzceaVar.zzghj;
        this.zzghk = zzceaVar.zzghk;
        this.zzghl = zzceaVar.zzghl;
        this.zzgho = new g<>(zzceaVar.zzgho);
        this.zzghp = new g<>(zzceaVar.zzghp);
        this.zzghm = zzceaVar.zzghm;
        this.zzghn = zzceaVar.zzghn;
    }
}

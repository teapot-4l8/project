package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzabl {
    private final Collection<zzabf<?>> zzcmj = new ArrayList();
    private final Collection<zzabf<String>> zzcmk = new ArrayList();
    private final Collection<zzabf<String>> zzcml = new ArrayList();

    public final void zza(zzabf zzabfVar) {
        this.zzcmj.add(zzabfVar);
    }

    public final void zzb(zzabf<String> zzabfVar) {
        this.zzcmk.add(zzabfVar);
    }

    public final void zzc(zzabf<String> zzabfVar) {
        this.zzcml.add(zzabfVar);
    }

    public final void zza(SharedPreferences.Editor editor, int i, JSONObject jSONObject) {
        for (zzabf<?> zzabfVar : this.zzcmj) {
            if (zzabfVar.getSource() == 1) {
                zzabfVar.zza(editor, zzabfVar.zzb(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzbao.zzex("Flag Json is null.");
        }
    }

    public final List<String> zzsi() {
        ArrayList arrayList = new ArrayList();
        for (zzabf<String> zzabfVar : this.zzcmk) {
            String str = (String) zzww.zzra().zzd(zzabfVar);
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(str);
            }
        }
        arrayList.addAll(zzabv.zzso());
        return arrayList;
    }

    public final List<String> zzsj() {
        List<String> zzsi = zzsi();
        for (zzabf<String> zzabfVar : this.zzcml) {
            String str = (String) zzww.zzra().zzd(zzabfVar);
            if (!TextUtils.isEmpty(str)) {
                zzsi.add(str);
            }
        }
        zzsi.addAll(zzabv.zzsp());
        return zzsi;
    }
}

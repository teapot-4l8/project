package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdrl implements zzdri {
    private final Object[] zzhrm;

    public zzdrl(zzvq zzvqVar, String str, int i, String str2, zzwc zzwcVar) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzvqVar.zzcia));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zzp(zzvqVar.extras));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzvqVar.extras.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzvqVar.zzcib));
        }
        if (hashSet.contains("keywords")) {
            if (zzvqVar.zzcic != null) {
                arrayList.add(zzvqVar.zzcic.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzvqVar.zzcid));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzvqVar.zzadv));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzvqVar.zzbns));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzvqVar.zzcie);
        }
        if (hashSet.contains("location")) {
            if (zzvqVar.zzng != null) {
                arrayList.add(zzvqVar.zzng.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzvqVar.zzcig);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zzp(zzvqVar.zzcih));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zzp(zzvqVar.zzcii));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (zzvqVar.zzcij != null) {
                arrayList.add(zzvqVar.zzcij.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzvqVar.zzcik);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzvqVar.zzcil);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzvqVar.zzcim));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(zzvqVar.zzadw));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzvqVar.zzadx);
        }
        if (hashSet.contains("orientation")) {
            if (zzwcVar != null) {
                arrayList.add(Integer.valueOf(zzwcVar.orientation));
            } else {
                arrayList.add(null);
            }
        }
        this.zzhrm = arrayList.toArray();
    }

    @Override // com.google.android.gms.internal.ads.zzdri
    public final boolean equals(Object obj) {
        if (obj instanceof zzdrl) {
            return Arrays.equals(this.zzhrm, ((zzdrl) obj).zzhrm);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdri
    public final int hashCode() {
        return Arrays.hashCode(this.zzhrm);
    }

    public final String toString() {
        int hashCode = hashCode();
        String arrays = Arrays.toString(this.zzhrm);
        StringBuilder sb = new StringBuilder(String.valueOf(arrays).length() + 22);
        sb.append("[PoolKey#");
        sb.append(hashCode);
        sb.append(" ");
        sb.append(arrays);
        sb.append("]");
        return sb.toString();
    }

    private static String zzp(Bundle bundle) {
        String obj;
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj2 = bundle.get((String) it.next());
            if (obj2 == null) {
                obj = "null";
            } else if (obj2 instanceof Bundle) {
                obj = zzp((Bundle) obj2);
            } else {
                obj = obj2.toString();
            }
            sb.append(obj);
        }
        return sb.toString();
    }
}

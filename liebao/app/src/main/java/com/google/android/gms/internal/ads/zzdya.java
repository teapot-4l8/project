package com.google.android.gms.internal.ads;

import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public final class zzdya {
    private final String className;
    private final zzdyd zzhyw;
    private zzdyd zzhyx;
    private boolean zzhyy;

    private zzdya(String str) {
        zzdyd zzdydVar = new zzdyd();
        this.zzhyw = zzdydVar;
        this.zzhyx = zzdydVar;
        this.zzhyy = false;
        this.className = (String) zzdyi.checkNotNull(str);
    }

    public final zzdya zzy(@NullableDecl Object obj) {
        zzdyd zzdydVar = new zzdyd();
        this.zzhyx.zzhyz = zzdydVar;
        this.zzhyx = zzdydVar;
        zzdydVar.value = obj;
        return this;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.className);
        sb.append('{');
        zzdyd zzdydVar = this.zzhyw.zzhyz;
        String str = "";
        while (zzdydVar != null) {
            Object obj = zzdydVar.value;
            sb.append(str);
            if (obj != null && obj.getClass().isArray()) {
                String deepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
            } else {
                sb.append(obj);
            }
            zzdydVar = zzdydVar.zzhyz;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}

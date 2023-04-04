package com.a.a.a.a;

import com.a.a.c.c;

/* compiled from: DefaultBorderFormatter.java */
/* loaded from: classes.dex */
public class b implements a {
    @Override // com.a.a.a.b
    public String a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String[] strArr2 = new String[strArr.length];
        int i = 0;
        for (String str : strArr) {
            if (str != null) {
                strArr2[i] = str;
                i++;
            }
        }
        if (i == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("╔═══════════════════════════════════════════════════════════════════════════════════════════════════");
        sb.append(c.f4556a);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(a(strArr2[i2]));
            if (i2 != i - 1) {
                sb.append(c.f4556a);
                sb.append("╟───────────────────────────────────────────────────────────────────────────────────────────────────");
                sb.append(c.f4556a);
            } else {
                sb.append(c.f4556a);
                sb.append("╚═══════════════════════════════════════════════════════════════════════════════════════════════════");
            }
        }
        return sb.toString();
    }

    private static String a(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 10);
        String[] split = str.split(c.f4556a);
        int length = split.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(c.f4556a);
            }
            String str2 = split[i];
            sb.append((char) 9553);
            sb.append(str2);
        }
        return sb.toString();
    }
}

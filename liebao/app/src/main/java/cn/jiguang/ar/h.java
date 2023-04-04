package cn.jiguang.ar;

import android.text.TextUtils;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/* loaded from: classes.dex */
public final class h implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public String f3820a;

    /* renamed from: b  reason: collision with root package name */
    public int f3821b;

    /* renamed from: c  reason: collision with root package name */
    public transient InetAddress f3822c;

    public h(String str, int i) {
        this.f3820a = str;
        this.f3821b = i;
    }

    public h(InetAddress inetAddress, int i) {
        this.f3820a = inetAddress.getHostAddress();
        this.f3821b = i;
        this.f3822c = inetAddress;
    }

    public static h a(String str) {
        int lastIndexOf;
        String substring;
        if (!TextUtils.isEmpty(str) && (lastIndexOf = str.lastIndexOf(":")) >= 0) {
            try {
                int intValue = Integer.decode(str.substring(lastIndexOf + 1)).intValue();
                if (lastIndexOf == 0) {
                    substring = "";
                } else {
                    int i = str.startsWith("[") ? 1 : 0;
                    if (str.charAt(lastIndexOf - 1) == ']') {
                        lastIndexOf--;
                    }
                    substring = str.substring(i, lastIndexOf);
                }
                return new h(substring, intValue);
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static String a(LinkedHashSet<h> linkedHashSet) {
        if (linkedHashSet == null || linkedHashSet.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<h> it = linkedHashSet.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static LinkedHashSet<h> a(LinkedHashMap<String, Integer> linkedHashMap) {
        LinkedHashSet<h> linkedHashSet = new LinkedHashSet<>();
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            h hVar = new h(entry.getKey(), entry.getValue().intValue());
            if (hVar.a()) {
                linkedHashSet.add(hVar);
            }
        }
        return linkedHashSet;
    }

    public static boolean a(String str, int i) {
        return !TextUtils.isEmpty(str) && i > 0 && i <= 65535;
    }

    public static LinkedHashSet<h> b(String str) {
        LinkedHashSet<h> linkedHashSet = new LinkedHashSet<>();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split(",")) {
                h a2 = a(str2);
                if (a2 != null && a2.a()) {
                    linkedHashSet.add(a2);
                }
            }
        }
        return linkedHashSet;
    }

    public final boolean a() {
        int i;
        return !TextUtils.isEmpty(this.f3820a) && (i = this.f3821b) > 0 && i <= 65535;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            h hVar = (h) obj;
            if (this.f3821b == hVar.f3821b) {
                String str = this.f3820a;
                String str2 = hVar.f3820a;
                if (str == null ? str2 == null : str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f3820a;
        return ((str != null ? str.hashCode() : 0) * 31) + this.f3821b;
    }

    public final String toString() {
        StringBuilder sb;
        String str = ":";
        if (this.f3820a.contains(":")) {
            sb = new StringBuilder("[");
            sb.append(this.f3820a);
            str = "]:";
        } else {
            sb = new StringBuilder();
            sb.append(this.f3820a);
        }
        sb.append(str);
        sb.append(this.f3821b);
        return sb.toString();
    }
}

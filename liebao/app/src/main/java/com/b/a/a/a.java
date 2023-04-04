package com.b.a.a;

import java.util.List;

/* compiled from: CommandResult.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f4563a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f4564b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4565c;

    private static String a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            String str = "";
            for (String str2 : list) {
                sb.append(str);
                sb.append(str2);
                str = "\n";
            }
        }
        return sb.toString();
    }

    public a(List<String> list, List<String> list2, int i) {
        this.f4563a = list;
        this.f4564b = list2;
        this.f4565c = i;
    }

    public boolean a() {
        return this.f4565c == 0;
    }

    public String b() {
        return a(this.f4563a);
    }

    public String toString() {
        return b();
    }
}

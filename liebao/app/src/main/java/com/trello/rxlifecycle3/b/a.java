package com.trello.rxlifecycle3.b;

/* compiled from: Preconditions.java */
/* loaded from: classes2.dex */
public final class a {
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}

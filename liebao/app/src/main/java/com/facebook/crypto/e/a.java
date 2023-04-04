package com.facebook.crypto.e;

import java.io.IOException;

/* compiled from: Assertions.java */
/* loaded from: classes.dex */
public class a {
    public static void a(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static void b(boolean z, String str) {
        if (!z) {
            throw new IOException(str);
        }
    }
}

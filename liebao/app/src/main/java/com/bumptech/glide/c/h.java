package com.bumptech.glide.c;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* compiled from: Key.java */
/* loaded from: classes.dex */
public interface h {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f5102a = Charset.forName("UTF-8");

    void a(MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}

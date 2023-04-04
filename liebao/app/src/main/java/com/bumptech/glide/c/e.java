package com.bumptech.glide.c;

import java.io.IOException;

/* compiled from: HttpException.java */
/* loaded from: classes.dex */
public final class e extends IOException {

    /* renamed from: a  reason: collision with root package name */
    private final int f5096a;

    public e(int i) {
        this("Http request failed with status code: " + i, i);
    }

    public e(String str) {
        this(str, -1);
    }

    public e(String str, int i) {
        this(str, i, null);
    }

    public e(String str, int i, Throwable th) {
        super(str, th);
        this.f5096a = i;
    }
}

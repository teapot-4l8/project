package com.lxj.xpopup.c;

/* compiled from: ImageType.java */
/* loaded from: classes.dex */
public enum a {
    GIF(true),
    JPEG(false),
    RAW(false),
    PNG_A(true),
    PNG(false),
    WEBP_A(true),
    WEBP(false),
    UNKNOWN(false);
    
    private final boolean i;

    a(boolean z) {
        this.i = z;
    }
}

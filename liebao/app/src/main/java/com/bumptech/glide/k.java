package com.bumptech.glide;

import com.bumptech.glide.k;

/* compiled from: TransitionOptions.java */
/* loaded from: classes.dex */
public abstract class k<CHILD extends k<CHILD, TranscodeType>, TranscodeType> implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private com.bumptech.glide.g.b.c<? super TranscodeType> f5270a = com.bumptech.glide.g.b.a.a();

    /* renamed from: a */
    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.bumptech.glide.g.b.c<? super TranscodeType> b() {
        return this.f5270a;
    }
}

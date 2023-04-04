package a.a.a.a;

import java.io.IOException;

/* compiled from: HttpException.java */
/* loaded from: classes.dex */
public final class a extends IOException {

    /* renamed from: a  reason: collision with root package name */
    private final int f8a;

    public a(int i) {
        this("Http request failed with status code: " + i, i);
    }

    public a(String str) {
        this(str, -1);
    }

    public a(String str, int i) {
        this(str, i, null);
    }

    public a(String str, int i, Throwable th) {
        super(str, th);
        this.f8a = i;
    }
}

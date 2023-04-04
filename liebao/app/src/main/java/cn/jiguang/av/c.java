package cn.jiguang.av;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public int f3983a;

    /* renamed from: b  reason: collision with root package name */
    public int f3984b;

    /* renamed from: c  reason: collision with root package name */
    public int f3985c;

    /* renamed from: d  reason: collision with root package name */
    public byte f3986d;

    /* renamed from: e  reason: collision with root package name */
    public long f3987e;
    public int f;
    public long g;
    private boolean h;

    public c(boolean z, byte[] bArr) {
        this.h = false;
        try {
            this.h = false;
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            short s = wrap.getShort();
            this.f3983a = s;
            this.f3983a = s & Short.MAX_VALUE;
            this.f3984b = wrap.get();
            this.f3985c = wrap.get();
            this.f3986d = wrap.get();
            wrap.get();
            wrap.getInt();
            this.f3987e = wrap.getShort();
            this.g = wrap.getLong();
        } catch (Throwable unused) {
        }
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("[JHead] - len:");
        sb.append(this.f3983a);
        sb.append(", version:");
        sb.append(this.f3984b);
        sb.append(", command:");
        sb.append(this.f3985c);
        sb.append(", rid:");
        sb.append(this.f3987e);
        if (this.h) {
            str = ", sid:" + this.f;
        } else {
            str = "";
        }
        sb.append(str);
        sb.append(", juid:");
        sb.append(this.g);
        return sb.toString();
    }
}

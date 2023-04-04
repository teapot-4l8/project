package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: TIOStreamTransport.java */
/* loaded from: classes2.dex */
public class ce extends cg {

    /* renamed from: a  reason: collision with root package name */
    protected InputStream f6486a;

    /* renamed from: b  reason: collision with root package name */
    protected OutputStream f6487b;

    @Override // com.umeng.analytics.pro.cg
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.cg
    public void b() {
    }

    protected ce() {
        this.f6486a = null;
        this.f6487b = null;
    }

    public ce(InputStream inputStream) {
        this.f6486a = null;
        this.f6487b = null;
        this.f6486a = inputStream;
    }

    public ce(OutputStream outputStream) {
        this.f6486a = null;
        this.f6487b = null;
        this.f6487b = outputStream;
    }

    public ce(InputStream inputStream, OutputStream outputStream) {
        this.f6486a = null;
        this.f6487b = null;
        this.f6486a = inputStream;
        this.f6487b = outputStream;
    }

    @Override // com.umeng.analytics.pro.cg
    public void c() {
        InputStream inputStream = this.f6486a;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.f6486a = null;
        }
        OutputStream outputStream = this.f6487b;
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            this.f6487b = null;
        }
    }

    @Override // com.umeng.analytics.pro.cg
    public int a(byte[] bArr, int i, int i2) {
        InputStream inputStream = this.f6486a;
        if (inputStream == null) {
            throw new ch(1, "Cannot read from null inputStream");
        }
        try {
            int read = inputStream.read(bArr, i, i2);
            if (read >= 0) {
                return read;
            }
            throw new ch(4);
        } catch (IOException e2) {
            throw new ch(0, e2);
        }
    }

    @Override // com.umeng.analytics.pro.cg
    public void b(byte[] bArr, int i, int i2) {
        OutputStream outputStream = this.f6487b;
        if (outputStream == null) {
            throw new ch(1, "Cannot write to null outputStream");
        }
        try {
            outputStream.write(bArr, i, i2);
        } catch (IOException e2) {
            throw new ch(0, e2);
        }
    }

    @Override // com.umeng.analytics.pro.cg
    public void d() {
        OutputStream outputStream = this.f6487b;
        if (outputStream == null) {
            throw new ch(1, "Cannot flush null outputStream");
        }
        try {
            outputStream.flush();
        } catch (IOException e2) {
            throw new ch(0, e2);
        }
    }
}

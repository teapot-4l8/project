package com.b.a.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/* compiled from: StreamGobbler.java */
/* loaded from: classes.dex */
public class c extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedReader f4567a;

    /* renamed from: b  reason: collision with root package name */
    private List<String> f4568b;

    /* renamed from: c  reason: collision with root package name */
    private a f4569c;

    /* compiled from: StreamGobbler.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str);
    }

    public c(InputStream inputStream, List<String> list) {
        this.f4567a = new BufferedReader(new InputStreamReader(inputStream));
        this.f4568b = list;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (true) {
            try {
                String readLine = this.f4567a.readLine();
                if (readLine != null) {
                    if (this.f4568b != null) {
                        this.f4568b.add(readLine);
                    }
                    if (this.f4569c != null) {
                        this.f4569c.a(readLine);
                    }
                }
            } catch (IOException unused) {
            }
            try {
                this.f4567a.close();
                return;
            } catch (IOException unused2) {
                return;
            }
        }
    }
}

package com.facebook.crypto.e;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: SystemNativeCryptoLibrary.java */
/* loaded from: classes.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayList<String> f5317a = new ArrayList<String>() { // from class: com.facebook.crypto.e.c.1
        {
            add("conceal");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private boolean f5318b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5319c = false;

    /* renamed from: d  reason: collision with root package name */
    private volatile UnsatisfiedLinkError f5320d = null;

    @Override // com.facebook.crypto.e.b
    public synchronized void a() {
        if (!b()) {
            throw new com.facebook.crypto.a.a(this.f5320d);
        }
    }

    private synchronized boolean b() {
        if (!this.f5318b) {
            return this.f5319c;
        }
        try {
            Iterator<String> it = f5317a.iterator();
            while (it.hasNext()) {
                System.loadLibrary(it.next());
            }
            this.f5319c = true;
        } catch (UnsatisfiedLinkError e2) {
            this.f5320d = e2;
            this.f5319c = false;
        }
        this.f5318b = false;
        return this.f5319c;
    }
}

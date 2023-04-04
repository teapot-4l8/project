package androidx.work.impl.utils;

import androidx.work.WorkerParameters;

/* compiled from: StartWorkRunnable.java */
/* loaded from: classes.dex */
public class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private androidx.work.impl.h f3051a;

    /* renamed from: b  reason: collision with root package name */
    private String f3052b;

    /* renamed from: c  reason: collision with root package name */
    private WorkerParameters.a f3053c;

    public g(androidx.work.impl.h hVar, String str, WorkerParameters.a aVar) {
        this.f3051a = hVar;
        this.f3052b = str;
        this.f3053c = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3051a.f().a(this.f3052b, this.f3053c);
    }
}

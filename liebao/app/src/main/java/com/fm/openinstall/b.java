package com.fm.openinstall;

import android.content.Context;
import b.a.d;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f5344a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Configuration f5345b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f5346c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, Configuration configuration, String str) {
        this.f5344a = context;
        this.f5345b = configuration;
        this.f5346c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        d dVar;
        d dVar2;
        Boolean bool;
        synchronized (OpenInstall.class) {
            z = OpenInstall.f5340b;
            if (!z) {
                dVar = OpenInstall.f5339a;
                if (dVar == null) {
                    d unused = OpenInstall.f5339a = d.a(this.f5344a, this.f5345b);
                    dVar2 = OpenInstall.f5339a;
                    String str = this.f5346c;
                    bool = OpenInstall.f;
                    dVar2.a(str, bool.booleanValue());
                }
                boolean unused2 = OpenInstall.f5340b = true;
            }
        }
    }
}

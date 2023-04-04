package org.b.b.c.a;

import android.database.ContentObserver;
import android.util.Log;

/* compiled from: IdentifierIdObserver.java */
/* loaded from: classes2.dex */
public class c extends ContentObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f7782a;

    /* renamed from: b  reason: collision with root package name */
    private int f7783b;

    /* renamed from: c  reason: collision with root package name */
    private b f7784c;

    public c(b bVar, int i, String str) {
        super(null);
        this.f7784c = bVar;
        this.f7783b = i;
        this.f7782a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        b bVar = this.f7784c;
        if (bVar != null) {
            bVar.a(this.f7783b, this.f7782a);
        } else {
            Log.e("VMS_IDLG_SDK_Observer", "mIdentifierIdClient is null");
        }
    }
}

package com.a.a.d;

/* compiled from: PrinterSet.java */
/* loaded from: classes.dex */
public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private b[] f4562a;

    public c(b... bVarArr) {
        this.f4562a = bVarArr;
    }

    @Override // com.a.a.d.b
    public void a(int i, String str, String str2) {
        for (b bVar : this.f4562a) {
            bVar.a(i, str, str2);
        }
    }
}

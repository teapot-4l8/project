package com.fm.openinstall.a;

/* loaded from: classes.dex */
public abstract class a implements b {
    public abstract void a(com.fm.openinstall.b.a aVar);

    @Override // com.fm.openinstall.a.b
    public void a(com.fm.openinstall.b.a aVar, com.fm.openinstall.b.b bVar) {
        if (aVar == null) {
            aVar = new com.fm.openinstall.b.a();
        }
        a(aVar);
    }
}

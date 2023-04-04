package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class d extends c {
    private static HashMap<String, byte[]> f;
    private static HashMap<String, HashMap<String, byte[]>> g;

    /* renamed from: e  reason: collision with root package name */
    private f f6191e;

    public d() {
        f fVar = new f();
        this.f6191e = fVar;
        fVar.f6193a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final <T> void a(String str, T t) {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException("put name can not startwith . , now is " + str);
        }
        super.a(str, (String) t);
    }

    @Override // com.tencent.bugly.proguard.c
    public final void c() {
        super.c();
        this.f6191e.f6193a = (short) 3;
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final byte[] a() {
        if (this.f6191e.f6193a == 2) {
            if (this.f6191e.f6195c.equals("")) {
                throw new IllegalArgumentException("servantName can not is null");
            }
            if (this.f6191e.f6196d.equals("")) {
                throw new IllegalArgumentException("funcName can not is null");
            }
        } else {
            if (this.f6191e.f6195c == null) {
                this.f6191e.f6195c = "";
            }
            if (this.f6191e.f6196d == null) {
                this.f6191e.f6196d = "";
            }
        }
        j jVar = new j(0);
        jVar.a(this.f6127b);
        if (this.f6191e.f6193a == 2) {
            jVar.a((Map) this.f6126a, 0);
        } else {
            jVar.a((Map) this.f6189d, 0);
        }
        this.f6191e.f6197e = l.a(jVar.a());
        j jVar2 = new j(0);
        jVar2.a(this.f6127b);
        this.f6191e.a(jVar2);
        byte[] a2 = l.a(jVar2.a());
        int length = a2.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a2).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            i iVar = new i(bArr, 4);
            iVar.a(this.f6127b);
            this.f6191e.a(iVar);
            if (this.f6191e.f6193a == 3) {
                i iVar2 = new i(this.f6191e.f6197e);
                iVar2.a(this.f6127b);
                if (f == null) {
                    HashMap<String, byte[]> hashMap = new HashMap<>();
                    f = hashMap;
                    hashMap.put("", new byte[0]);
                }
                this.f6189d = iVar2.a((Map) f, 0, false);
                return;
            }
            i iVar3 = new i(this.f6191e.f6197e);
            iVar3.a(this.f6127b);
            if (g == null) {
                g = new HashMap<>();
                HashMap<String, byte[]> hashMap2 = new HashMap<>();
                hashMap2.put("", new byte[0]);
                g.put("", hashMap2);
            }
            this.f6126a = iVar3.a((Map) g, 0, false);
            new HashMap();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public final void b(String str) {
        this.f6191e.f6195c = str;
    }

    public final void c(String str) {
        this.f6191e.f6196d = str;
    }

    public final void b(int i) {
        this.f6191e.f6194b = 1;
    }
}

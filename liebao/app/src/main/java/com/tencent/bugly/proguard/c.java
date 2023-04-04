package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class c extends a {

    /* renamed from: d  reason: collision with root package name */
    protected HashMap<String, byte[]> f6189d = null;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Object> f6190e = new HashMap<>();
    private i f = new i();

    @Override // com.tencent.bugly.proguard.a
    public final /* bridge */ /* synthetic */ void a(String str) {
        super.a(str);
    }

    public void c() {
        this.f6189d = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.a
    public <T> void a(String str, T t) {
        if (this.f6189d == null) {
            super.a(str, (String) t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else {
            if (t == null) {
                throw new IllegalArgumentException("put value can not is null");
            }
            if (t instanceof Set) {
                throw new IllegalArgumentException("can not support Set");
            }
            j jVar = new j();
            jVar.a(this.f6127b);
            jVar.a(t, 0);
            this.f6189d.put(str, l.a(jVar.a()));
        }
    }

    public final <T> T b(String str, T t) {
        HashMap<String, byte[]> hashMap = this.f6189d;
        if (hashMap != null) {
            if (hashMap.containsKey(str)) {
                if (this.f6190e.containsKey(str)) {
                    return (T) this.f6190e.get(str);
                }
                try {
                    this.f.a(this.f6189d.get(str));
                    this.f.a(this.f6127b);
                    T t2 = (T) this.f.a((i) t, 0, true);
                    if (t2 != null) {
                        this.f6190e.put(str, t2);
                    }
                    return t2;
                } catch (Exception e2) {
                    throw new b(e2);
                }
            }
            return null;
        } else if (this.f6126a.containsKey(str)) {
            if (this.f6190e.containsKey(str)) {
                return (T) this.f6190e.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator<Map.Entry<String, byte[]>> it = this.f6126a.get(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                next.getKey();
                bArr = next.getValue();
            }
            try {
                this.f.a(bArr);
                this.f.a(this.f6127b);
                T t3 = (T) this.f.a((i) t, 0, true);
                this.f6190e.put(str, t3);
                return t3;
            } catch (Exception e3) {
                throw new b(e3);
            }
        } else {
            return null;
        }
    }

    @Override // com.tencent.bugly.proguard.a
    public byte[] a() {
        if (this.f6189d != null) {
            j jVar = new j(0);
            jVar.a(this.f6127b);
            jVar.a((Map) this.f6189d, 0);
            return l.a(jVar.a());
        }
        return super.a();
    }

    @Override // com.tencent.bugly.proguard.a
    public void a(byte[] bArr) {
        try {
            super.a(bArr);
        } catch (Exception unused) {
            this.f.a(bArr);
            this.f.a(this.f6127b);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f6189d = this.f.a((Map) hashMap, 0, false);
        }
    }
}

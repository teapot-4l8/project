package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.biz.UserInfoBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    private static Proxy f6125e;

    /* renamed from: a  reason: collision with root package name */
    protected HashMap<String, HashMap<String, byte[]>> f6126a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    protected String f6127b;

    /* renamed from: c  reason: collision with root package name */
    i f6128c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, Object> f6129d;

    public static aj a(int i) {
        if (i == 1) {
            return new ai();
        }
        if (i == 3) {
            return new ah();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        new HashMap();
        this.f6129d = new HashMap<>();
        this.f6127b = "GBK";
        this.f6128c = new i();
    }

    public static void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            f6125e = null;
        } else {
            f6125e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i));
        }
    }

    public static void a(InetAddress inetAddress, int i) {
        if (inetAddress == null) {
            f6125e = null;
        } else {
            f6125e = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(inetAddress, i));
        }
    }

    public void a(String str) {
        this.f6127b = str;
    }

    public static Proxy b() {
        return f6125e;
    }

    public static at a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        at atVar = new at();
        atVar.f6179a = userInfoBean.f5979e;
        atVar.f6183e = userInfoBean.j;
        atVar.f6182d = userInfoBean.f5977c;
        atVar.f6181c = userInfoBean.f5978d;
        atVar.g = com.tencent.bugly.crashreport.common.info.a.b().i();
        atVar.h = userInfoBean.o == 1;
        int i = userInfoBean.f5976b;
        if (i == 1) {
            atVar.f6180b = (byte) 1;
        } else if (i == 2) {
            atVar.f6180b = (byte) 4;
        } else if (i == 3) {
            atVar.f6180b = (byte) 2;
        } else if (i == 4) {
            atVar.f6180b = (byte) 3;
        } else if (userInfoBean.f5976b < 10 || userInfoBean.f5976b >= 20) {
            x.e("unknown uinfo type %d ", Integer.valueOf(userInfoBean.f5976b));
            return null;
        } else {
            atVar.f6180b = (byte) userInfoBean.f5976b;
        }
        atVar.f = new HashMap();
        if (userInfoBean.p >= 0) {
            Map<String, String> map = atVar.f;
            StringBuilder sb = new StringBuilder();
            sb.append(userInfoBean.p);
            map.put("C01", sb.toString());
        }
        if (userInfoBean.f5980q >= 0) {
            Map<String, String> map2 = atVar.f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(userInfoBean.f5980q);
            map2.put("C02", sb2.toString());
        }
        if (userInfoBean.r != null && userInfoBean.r.size() > 0) {
            for (Map.Entry<String, String> entry : userInfoBean.r.entrySet()) {
                Map<String, String> map3 = atVar.f;
                map3.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        if (userInfoBean.s != null && userInfoBean.s.size() > 0) {
            for (Map.Entry<String, String> entry2 : userInfoBean.s.entrySet()) {
                Map<String, String> map4 = atVar.f;
                map4.put("C04_" + entry2.getKey(), entry2.getValue());
            }
        }
        Map<String, String> map5 = atVar.f;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(!userInfoBean.l);
        map5.put("A36", sb3.toString());
        Map<String, String> map6 = atVar.f;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(userInfoBean.g);
        map6.put("F02", sb4.toString());
        Map<String, String> map7 = atVar.f;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(userInfoBean.h);
        map7.put("F03", sb5.toString());
        Map<String, String> map8 = atVar.f;
        map8.put("F04", userInfoBean.j);
        Map<String, String> map9 = atVar.f;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(userInfoBean.i);
        map9.put("F05", sb6.toString());
        Map<String, String> map10 = atVar.f;
        map10.put("F06", userInfoBean.m);
        Map<String, String> map11 = atVar.f;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(userInfoBean.k);
        map11.put("F10", sb7.toString());
        x.c("summary type %d vm:%d", Byte.valueOf(atVar.f6180b), Integer.valueOf(atVar.f.size()));
        return atVar;
    }

    public static String a(ArrayList<String> arrayList) {
        int i;
        int i2;
        int i3;
        StringBuffer stringBuffer = new StringBuffer();
        int i4 = 0;
        while (true) {
            String str = "map";
            if (i4 < arrayList.size()) {
                String str2 = arrayList.get(i4);
                if (str2.equals("java.lang.Integer") || str2.equals("int")) {
                    str = "int32";
                } else if (str2.equals("java.lang.Boolean") || str2.equals("boolean")) {
                    str = "bool";
                } else if (str2.equals("java.lang.Byte") || str2.equals("byte")) {
                    str = "char";
                } else if (str2.equals("java.lang.Double") || str2.equals("double")) {
                    str = "double";
                } else if (str2.equals("java.lang.Float") || str2.equals("float")) {
                    str = "float";
                } else if (str2.equals("java.lang.Long") || str2.equals("long")) {
                    str = "int64";
                } else if (str2.equals("java.lang.Short") || str2.equals("short")) {
                    str = "short";
                } else if (str2.equals("java.lang.Character")) {
                    throw new IllegalArgumentException("can not support java.lang.Character");
                } else {
                    if (str2.equals("java.lang.String")) {
                        str = "string";
                    } else if (str2.equals("java.util.List")) {
                        str = "list";
                    } else if (!str2.equals("java.util.Map")) {
                        str = str2;
                    }
                }
                arrayList.set(i4, str);
                i4++;
            } else {
                Collections.reverse(arrayList);
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    String str3 = arrayList.get(i5);
                    if (str3.equals("list")) {
                        arrayList.set(i5 - 1, "<" + arrayList.get(i3));
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("map")) {
                        arrayList.set(i5 - 1, "<" + arrayList.get(i2) + ",");
                        arrayList.set(0, arrayList.get(0) + ">");
                    } else if (str3.equals("Array")) {
                        arrayList.set(i5 - 1, "<" + arrayList.get(i));
                        arrayList.set(0, arrayList.get(0) + ">");
                    }
                }
                Collections.reverse(arrayList);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(it.next());
                }
                return stringBuffer.toString();
            }
        }
    }

    public <T> void a(String str, T t) {
        if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        }
        if (t == null) {
            throw new IllegalArgumentException("put value can not is null");
        }
        if (t instanceof Set) {
            throw new IllegalArgumentException("can not support Set");
        }
        j jVar = new j();
        jVar.a(this.f6127b);
        jVar.a(t, 0);
        byte[] a2 = l.a(jVar.a());
        HashMap<String, byte[]> hashMap = new HashMap<>(1);
        ArrayList<String> arrayList = new ArrayList<>(1);
        a(arrayList, t);
        hashMap.put(a(arrayList), a2);
        this.f6129d.remove(str);
        this.f6126a.put(str, hashMap);
    }

    public static au a(List<UserInfoBean> list, int i) {
        com.tencent.bugly.crashreport.common.info.a b2;
        if (list == null || list.size() == 0 || (b2 = com.tencent.bugly.crashreport.common.info.a.b()) == null) {
            return null;
        }
        b2.t();
        au auVar = new au();
        auVar.f6185b = b2.f6008d;
        auVar.f6186c = b2.h();
        ArrayList<at> arrayList = new ArrayList<>();
        for (UserInfoBean userInfoBean : list) {
            at a2 = a(userInfoBean);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        auVar.f6187d = arrayList;
        auVar.f6188e = new HashMap();
        Map<String, String> map = auVar.f6188e;
        map.put("A7", b2.g);
        Map<String, String> map2 = auVar.f6188e;
        map2.put("A6", b2.s());
        Map<String, String> map3 = auVar.f6188e;
        map3.put("A5", b2.r());
        Map<String, String> map4 = auVar.f6188e;
        StringBuilder sb = new StringBuilder();
        sb.append(b2.p());
        map4.put("A2", sb.toString());
        Map<String, String> map5 = auVar.f6188e;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b2.p());
        map5.put("A1", sb2.toString());
        Map<String, String> map6 = auVar.f6188e;
        map6.put("A24", b2.i);
        Map<String, String> map7 = auVar.f6188e;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(b2.q());
        map7.put("A17", sb3.toString());
        Map<String, String> map8 = auVar.f6188e;
        map8.put("A15", b2.w());
        Map<String, String> map9 = auVar.f6188e;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(b2.x());
        map9.put("A13", sb4.toString());
        Map<String, String> map10 = auVar.f6188e;
        map10.put("F08", b2.w);
        Map<String, String> map11 = auVar.f6188e;
        map11.put("F09", b2.x);
        Map<String, String> G = b2.G();
        if (G != null && G.size() > 0) {
            for (Map.Entry<String, String> entry : G.entrySet()) {
                Map<String, String> map12 = auVar.f6188e;
                map12.put("C04_" + entry.getKey(), entry.getValue());
            }
        }
        if (i == 1) {
            auVar.f6184a = (byte) 1;
        } else if (i != 2) {
            x.e("unknown up type %d ", Integer.valueOf(i));
            return null;
        } else {
            auVar.f6184a = (byte) 2;
        }
        return auVar;
    }

    public static <T extends k> T a(byte[] bArr, Class<T> cls) {
        if (bArr != null && bArr.length > 0) {
            try {
                T newInstance = cls.newInstance();
                i iVar = new i(bArr);
                iVar.a("utf-8");
                newInstance.a(iVar);
                return newInstance;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static ap a(Context context, int i, byte[] bArr) {
        com.tencent.bugly.crashreport.common.info.a b2 = com.tencent.bugly.crashreport.common.info.a.b();
        StrategyBean c2 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (b2 == null || c2 == null) {
            x.e("Can not create request pkg for parameters is invalid.", new Object[0]);
            return null;
        }
        try {
            ap apVar = new ap();
            synchronized (b2) {
                apVar.f6161a = 1;
                apVar.f6162b = b2.f();
                apVar.f6163c = b2.f6007c;
                apVar.f6164d = b2.k;
                apVar.f6165e = b2.m;
                apVar.f = b2.f;
                apVar.g = i;
                apVar.h = bArr == null ? "".getBytes() : bArr;
                apVar.i = b2.h;
                apVar.j = b2.i;
                apVar.k = new HashMap();
                apVar.l = b2.e();
                apVar.m = c2.p;
                apVar.o = b2.h();
                apVar.p = com.tencent.bugly.crashreport.common.info.b.c(context);
                apVar.f6166q = System.currentTimeMillis();
                apVar.r = b2.k();
                apVar.s = b2.j();
                apVar.t = b2.m();
                apVar.u = b2.l();
                apVar.v = b2.n();
                apVar.w = apVar.p;
                b2.getClass();
                apVar.n = "com.tencent.bugly";
                Map<String, String> map = apVar.k;
                map.put("A26", b2.y());
                Map<String, String> map2 = apVar.k;
                map2.put("A60", b2.z());
                Map<String, String> map3 = apVar.k;
                map3.put("A61", b2.A());
                Map<String, String> map4 = apVar.k;
                StringBuilder sb = new StringBuilder();
                sb.append(b2.R());
                map4.put("A62", sb.toString());
                Map<String, String> map5 = apVar.k;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(b2.S());
                map5.put("A63", sb2.toString());
                Map<String, String> map6 = apVar.k;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(b2.B);
                map6.put("F11", sb3.toString());
                Map<String, String> map7 = apVar.k;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(b2.A);
                map7.put("F12", sb4.toString());
                Map<String, String> map8 = apVar.k;
                map8.put("G1", b2.u());
                Map<String, String> map9 = apVar.k;
                map9.put("A64", b2.T());
                if (b2.D) {
                    Map<String, String> map10 = apVar.k;
                    map10.put("G2", b2.L());
                    Map<String, String> map11 = apVar.k;
                    map11.put("G3", b2.M());
                    Map<String, String> map12 = apVar.k;
                    map12.put("G4", b2.N());
                    Map<String, String> map13 = apVar.k;
                    map13.put("G5", b2.O());
                    Map<String, String> map14 = apVar.k;
                    map14.put("G6", b2.P());
                    Map<String, String> map15 = apVar.k;
                    map15.put("G7", Long.toString(b2.Q()));
                }
                Map<String, String> map16 = apVar.k;
                map16.put("D3", b2.l);
                if (com.tencent.bugly.b.f5968b != null) {
                    for (com.tencent.bugly.a aVar : com.tencent.bugly.b.f5968b) {
                        if (aVar.versionKey != null && aVar.version != null) {
                            apVar.k.put(aVar.versionKey, aVar.version);
                        }
                    }
                }
                apVar.k.put("G15", z.b("G15", ""));
                apVar.k.put("D4", z.b("D4", "0"));
            }
            u a2 = u.a();
            if (a2 != null && !a2.f6243a && bArr != null) {
                apVar.h = z.a(apVar.h, 2, 1, c2.u);
                if (apVar.h == null) {
                    x.e("reqPkg sbuffer error!", new Object[0]);
                    return null;
                }
            }
            Map<String, String> F = b2.F();
            if (F != null) {
                for (Map.Entry<String, String> entry : F.entrySet()) {
                    apVar.k.put(entry.getKey(), entry.getValue());
                }
            }
            return apVar;
        } catch (Throwable th) {
            if (!x.b(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private void a(ArrayList<String> arrayList, Object obj) {
        if (obj.getClass().isArray()) {
            if (!obj.getClass().getComponentType().toString().equals("byte")) {
                throw new IllegalArgumentException("only byte[] is supported");
            }
            if (Array.getLength(obj) > 0) {
                arrayList.add("java.util.List");
                a(arrayList, Array.get(obj, 0));
                return;
            }
            arrayList.add("Array");
            arrayList.add("?");
        } else if (obj instanceof Array) {
            throw new IllegalArgumentException("can not support Array, please use List");
        } else {
            if (obj instanceof List) {
                arrayList.add("java.util.List");
                List list = (List) obj;
                if (list.size() > 0) {
                    a(arrayList, list.get(0));
                } else {
                    arrayList.add("?");
                }
            } else if (obj instanceof Map) {
                arrayList.add("java.util.Map");
                Map map = (Map) obj;
                if (map.size() > 0) {
                    Object next = map.keySet().iterator().next();
                    Object obj2 = map.get(next);
                    arrayList.add(next.getClass().getName());
                    a(arrayList, obj2);
                    return;
                }
                arrayList.add("?");
                arrayList.add("?");
            } else {
                arrayList.add(obj.getClass().getName());
            }
        }
    }

    public byte[] a() {
        j jVar = new j(0);
        jVar.a(this.f6127b);
        jVar.a((Map) this.f6126a, 0);
        return l.a(jVar.a());
    }

    public void a(byte[] bArr) {
        this.f6128c.a(bArr);
        this.f6128c.a(this.f6127b);
        HashMap hashMap = new HashMap(1);
        HashMap hashMap2 = new HashMap(1);
        hashMap2.put("", new byte[0]);
        hashMap.put("", hashMap2);
        this.f6126a = this.f6128c.a((Map) hashMap, 0, false);
    }

    public static byte[] a(Object obj) {
        try {
            d dVar = new d();
            dVar.c();
            dVar.a("utf-8");
            dVar.b(1);
            dVar.b("RqdServer");
            dVar.c("sync");
            dVar.a("detail", (String) obj);
            return dVar.a();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public static aq a(byte[] bArr, boolean z) {
        if (bArr != null) {
            try {
                d dVar = new d();
                dVar.c();
                dVar.a("utf-8");
                dVar.a(bArr);
                Object b2 = dVar.b("detail", new aq());
                aq aqVar = aq.class.isInstance(b2) ? (aq) aq.class.cast(b2) : null;
                if (!z && aqVar != null && aqVar.f6169c != null && aqVar.f6169c.length > 0) {
                    x.c("resp buf %d", Integer.valueOf(aqVar.f6169c.length));
                    aqVar.f6169c = z.b(aqVar.f6169c, 2, 1, StrategyBean.f6019d);
                    if (aqVar.f6169c == null) {
                        x.e("resp sbuffer error!", new Object[0]);
                        return null;
                    }
                }
                return aqVar;
            } catch (Throwable th) {
                if (!x.b(th)) {
                    th.printStackTrace();
                }
            }
        }
        return null;
    }

    public static byte[] a(k kVar) {
        try {
            j jVar = new j();
            jVar.a("utf-8");
            kVar.a(jVar);
            return jVar.b();
        } catch (Throwable th) {
            if (x.b(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}

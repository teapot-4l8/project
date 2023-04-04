package com.speed.speed_library.c.a;

import android.util.Pair;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.speed.speed_library.R;
import com.speed.speed_library.utils.DeviceUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.a.h;
import kotlin.d.b.i;
import kotlin.h.f;
import kotlin.h.g;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.q;
import okhttp3.s;
import okhttp3.u;
import okhttp3.v;
import okhttp3.w;
import utils.AppLog;

/* compiled from: RequestEncryptInterceptor.kt */
/* loaded from: classes2.dex */
public final class c implements u {
    @Override // okhttp3.u
    public ac a(u.a aVar) {
        Iterator<w.b> it;
        i.b(aVar, "chain");
        aa a2 = aVar.a();
        aa.a e2 = a2.e();
        aa a3 = e2.a();
        String b2 = a2.b();
        ab d2 = a2.d();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        if (i.a((Object) "GET", (Object) b2) || i.a((Object) "DELETE", (Object) b2)) {
            int m = a2.a().m();
            while (i < m) {
                Pair<String, String> create = Pair.create(a2.a().a(i), a2.a().b(i));
                i.a((Object) create, "Pair.create(\n           …(i)\n                    )");
                arrayList.add(create);
                i++;
            }
        } else if (d2 instanceof q) {
            q qVar = (q) d2;
            int a4 = qVar.a();
            while (i < a4) {
                Pair<String, String> create2 = Pair.create(qVar.b(i), qVar.d(i));
                i.a((Object) create2, "Pair.create(requestBody.…i), requestBody.value(i))");
                arrayList.add(create2);
                i++;
            }
        } else if (d2 instanceof w) {
            Iterator<w.b> it2 = ((w) d2).a().iterator();
            while (it2.hasNext()) {
                w.b next = it2.next();
                v b3 = next.b().b();
                if (b3 == null) {
                    i.a();
                }
                if (i.a((Object) b3.a(), (Object) "text")) {
                    s a5 = next.a();
                    if (a5 == null) {
                        i.a();
                    }
                    int size = a5.b().size();
                    int i2 = 0;
                    while (i2 < size) {
                        AppLog appLog = AppLog.INSTANCE;
                        appLog.d("ParameterInterceptor", "headers======value=" + a5.b(i2));
                        String b4 = a5.b(i2);
                        i.a((Object) b4, AppMeasurementSdk.ConditionalUserProperty.VALUE);
                        it = it2;
                        if (g.a((CharSequence) b4, (CharSequence) "form-data; name=", false, 2, (Object) null)) {
                            String a6 = new f("\"").a(g.a(b4, "form-data; name=", "", false, 4, (Object) null), "");
                            AppLog appLog2 = AppLog.INSTANCE;
                            appLog2.d("ParameterInterceptor", "MultipartBody======key=" + a6);
                            c.c cVar = new c.c();
                            next.b().a(cVar);
                            Pair<String, String> create3 = Pair.create(a6, cVar.q());
                            i.a((Object) create3, "Pair.create(key, value)");
                            arrayList.add(create3);
                            break;
                        }
                        i2++;
                        it2 = it;
                    }
                }
                it = it2;
                it2 = it;
            }
        }
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        String a7 = a(arrayList, valueOf);
        AppLog.INSTANCE.i("sign");
        e2.a("ts", valueOf);
        e2.a("sign", a7);
        ac a8 = aVar.a(e2.a(a3.a()).a());
        i.a((Object) a8, "chain.proceed(newRequest)");
        return a8;
    }

    public final String a(List<Pair<String, String>> list, String str) {
        i.b(list, "requestParamList");
        i.b(str, "ts");
        StringBuilder sb = new StringBuilder();
        Pair<String, String> create = Pair.create("ts", str);
        i.a((Object) create, "Pair.create(\"ts\", ts)");
        list.add(create);
        h.a(list, a.f5660a);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Pair<String, String> pair = list.get(i);
            sb.append((String) pair.first);
            sb.append("=");
            sb.append((String) pair.second);
        }
        AppLog.INSTANCE.i("stringBuilder::" + ((Object) sb)); // password=phone=ts=1680274960WOYqZGTomCWAFREVnyliebao
                                                               // password=phone=ts=1680274959WOYqZGTomCWAFREVnyliebao
                                                               //                                            aaxx()
        String str2 = sb.toString() + com.speed.speed_library.b.g.f5610b.a().getResources().getString(R.string.a_key_three) + com.speed.speed_library.b.g.f5610b.Z() + DeviceUtils.aaxx(com.speed.speed_library.b.g.f5610b.a());
        AppLog.INSTANCE.i("signBody::" + str2);
        String a2 = com.speed.speed_library.utils.d.f5865a.a(str2); // md5(str2)
        if (a2 != null) {
            String lowerCase = a2.toLowerCase();
            i.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        }
        throw new kotlin.i("null cannot be cast to non-null type java.lang.String");
    }

    /* compiled from: RequestEncryptInterceptor.kt */
    /* loaded from: classes2.dex */
    static final class a<T> implements Comparator<Pair<String, String>> {

        /* renamed from: a */
        public static final a f5660a = new a();

        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a  reason: avoid collision after fix types in other method */
        public final int compare(Pair<String, String> pair, Pair<String, String> pair2) {
            Object obj = pair2.first;
            i.a(obj, "two.first");
            return ((String) pair.first).compareTo((String) obj);
        }
    }
}

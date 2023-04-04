package d.a.a.a.a;

import com.google.gson.GsonBuilder;
import e.a.a.h;
import e.s;
import java.util.HashMap;
import kotlin.d.b.g;
import kotlin.d.b.i;

/* compiled from: RetrofitClient.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f6983a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, s> f6984b = new HashMap<>();

    /* compiled from: RetrofitClient.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final HashMap<String, s> a() {
            return b.f6984b;
        }

        public final s a(String str) {
            i.b(str, "baseUrl");
            a aVar = this;
            if (aVar.a().containsKey(str)) {
                if (aVar.a().get(str) != null) {
                    s sVar = aVar.a().get(str);
                    if (sVar == null) {
                        i.a();
                    }
                    return sVar;
                }
                s b2 = aVar.b(str);
                aVar.a().put(str, b2);
                return b2;
            }
            s b3 = aVar.b(str);
            aVar.a().put(str, b3);
            return b3;
        }

        public final s b(String str) {
            i.b(str, "baseUrl");
            s a2 = new s.a().a(str).a(com.speed.speed_library.c.a.b.f5659a.a().a()).a(e.b.a.a.a(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create())).a(h.a()).a();
            i.a((Object) a2, "retrofit");
            return a2;
        }
    }
}

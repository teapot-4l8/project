package e;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import okhttp3.ac;
import okhttp3.ad;
import okhttp3.e;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpServiceMethod.java */
/* loaded from: classes2.dex */
public final class j<ResponseT, ReturnT> extends t<ReturnT> {

    /* renamed from: a  reason: collision with root package name */
    private final q f7050a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a f7051b;

    /* renamed from: c  reason: collision with root package name */
    private final c<ResponseT, ReturnT> f7052c;

    /* renamed from: d  reason: collision with root package name */
    private final f<ad, ResponseT> f7053d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <ResponseT, ReturnT> j<ResponseT, ReturnT> a(s sVar, Method method, q qVar) {
        c b2 = b(sVar, method);
        Type a2 = b2.a();
        if (a2 == r.class || a2 == ac.class) {
            throw u.a(method, "'" + u.a(a2).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        } else if (qVar.f7105a.equals("HEAD") && !Void.class.equals(a2)) {
            throw u.a(method, "HEAD method must use Void as response type.", new Object[0]);
        } else {
            return new j<>(qVar, sVar.f7119a, b2, a(sVar, method, a2));
        }
    }

    private static <ResponseT, ReturnT> c<ResponseT, ReturnT> b(s sVar, Method method) {
        Type genericReturnType = method.getGenericReturnType();
        try {
            return (c<ResponseT, ReturnT>) sVar.a(genericReturnType, method.getAnnotations());
        } catch (RuntimeException e2) {
            throw u.a(method, e2, "Unable to create call adapter for %s", genericReturnType);
        }
    }

    private static <ResponseT> f<ad, ResponseT> a(s sVar, Method method, Type type) {
        try {
            return sVar.b(type, method.getAnnotations());
        } catch (RuntimeException e2) {
            throw u.a(method, e2, "Unable to create converter for %s", type);
        }
    }

    private j(q qVar, e.a aVar, c<ResponseT, ReturnT> cVar, f<ad, ResponseT> fVar) {
        this.f7050a = qVar;
        this.f7051b = aVar;
        this.f7052c = cVar;
        this.f7053d = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.t
    public ReturnT a(Object[] objArr) {
        return this.f7052c.a(new l(this.f7050a, objArr, this.f7051b, this.f7053d));
    }
}

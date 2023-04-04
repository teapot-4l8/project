package e.b.a;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import e.f;
import e.s;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.ab;
import okhttp3.ad;

/* compiled from: GsonConverterFactory.java */
/* loaded from: classes2.dex */
public final class a extends f.a {

    /* renamed from: a  reason: collision with root package name */
    private final Gson f7015a;

    public static a a(Gson gson) {
        if (gson == null) {
            throw new NullPointerException("gson == null");
        }
        return new a(gson);
    }

    private a(Gson gson) {
        this.f7015a = gson;
    }

    @Override // e.f.a
    public f<ad, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        return new c(this.f7015a, this.f7015a.getAdapter(TypeToken.get(type)));
    }

    @Override // e.f.a
    public f<?, ab> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        return new b(this.f7015a, this.f7015a.getAdapter(TypeToken.get(type)));
    }
}

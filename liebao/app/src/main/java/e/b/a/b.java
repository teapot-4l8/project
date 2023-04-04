package e.b.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import e.f;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.ab;
import okhttp3.v;

/* compiled from: GsonRequestBodyConverter.java */
/* loaded from: classes2.dex */
final class b<T> implements f<T, ab> {

    /* renamed from: a  reason: collision with root package name */
    private static final v f7016a = v.a("application/json; charset=UTF-8");

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f7017b = Charset.forName("UTF-8");

    /* renamed from: c  reason: collision with root package name */
    private final Gson f7018c;

    /* renamed from: d  reason: collision with root package name */
    private final TypeAdapter<T> f7019d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f7018c = gson;
        this.f7019d = typeAdapter;
    }

    @Override // e.f
    /* renamed from: b */
    public ab a(T t) {
        c.c cVar = new c.c();
        JsonWriter newJsonWriter = this.f7018c.newJsonWriter(new OutputStreamWriter(cVar.d(), f7017b));
        this.f7019d.write(newJsonWriter, t);
        newJsonWriter.close();
        return ab.a(f7016a, cVar.p());
    }
}

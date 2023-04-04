package e.b.a;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import e.f;
import okhttp3.ad;

/* compiled from: GsonResponseBodyConverter.java */
/* loaded from: classes2.dex */
final class c<T> implements f<ad, T> {

    /* renamed from: a  reason: collision with root package name */
    private final Gson f7020a;

    /* renamed from: b  reason: collision with root package name */
    private final TypeAdapter<T> f7021b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.f7020a = gson;
        this.f7021b = typeAdapter;
    }

    @Override // e.f
    public T a(ad adVar) {
        JsonReader newJsonReader = this.f7020a.newJsonReader(adVar.d());
        try {
            T read = this.f7021b.read(newJsonReader);
            if (newJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return read;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            adVar.close();
        }
    }
}

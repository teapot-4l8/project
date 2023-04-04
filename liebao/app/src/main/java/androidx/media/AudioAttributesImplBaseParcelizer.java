package androidx.media;

/* loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static c read(androidx.versionedparcelable.a aVar) {
        c cVar = new c();
        cVar.f2093a = aVar.b(cVar.f2093a, 1);
        cVar.f2094b = aVar.b(cVar.f2094b, 2);
        cVar.f2095c = aVar.b(cVar.f2095c, 3);
        cVar.f2096d = aVar.b(cVar.f2096d, 4);
        return cVar;
    }

    public static void write(c cVar, androidx.versionedparcelable.a aVar) {
        aVar.a(false, false);
        aVar.a(cVar.f2093a, 1);
        aVar.a(cVar.f2094b, 2);
        aVar.a(cVar.f2095c, 3);
        aVar.a(cVar.f2096d, 4);
    }
}

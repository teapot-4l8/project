package androidx.media;

import android.media.AudioAttributes;

/* loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer {
    public static b read(androidx.versionedparcelable.a aVar) {
        b bVar = new b();
        bVar.f2091a = (AudioAttributes) aVar.b((androidx.versionedparcelable.a) bVar.f2091a, 1);
        bVar.f2092b = aVar.b(bVar.f2092b, 2);
        return bVar;
    }

    public static void write(b bVar, androidx.versionedparcelable.a aVar) {
        aVar.a(false, false);
        aVar.a(bVar.f2091a, 1);
        aVar.a(bVar.f2092b, 2);
    }
}

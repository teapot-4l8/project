package androidx.media;

/* loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(androidx.versionedparcelable.a aVar) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f2090a = (a) aVar.b((androidx.versionedparcelable.a) audioAttributesCompat.f2090a, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, androidx.versionedparcelable.a aVar) {
        aVar.a(false, false);
        aVar.a(audioAttributesCompat.f2090a, 1);
    }
}

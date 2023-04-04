package androidx.media;

import android.media.AudioAttributes;

/* compiled from: AudioAttributesImplApi21.java */
/* loaded from: classes.dex */
class b implements a {

    /* renamed from: a  reason: collision with root package name */
    AudioAttributes f2091a;

    /* renamed from: b  reason: collision with root package name */
    int f2092b = -1;

    public int hashCode() {
        return this.f2091a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f2091a.equals(((b) obj).f2091a);
        }
        return false;
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2091a;
    }
}

package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(androidx.versionedparcelable.a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f1614a = aVar.b(iconCompat.f1614a, 1);
        iconCompat.f1616c = aVar.b(iconCompat.f1616c, 2);
        iconCompat.f1617d = aVar.b((androidx.versionedparcelable.a) iconCompat.f1617d, 3);
        iconCompat.f1618e = aVar.b(iconCompat.f1618e, 4);
        iconCompat.f = aVar.b(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) aVar.b((androidx.versionedparcelable.a) iconCompat.g, 6);
        iconCompat.j = aVar.b(iconCompat.j, 7);
        iconCompat.e();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, androidx.versionedparcelable.a aVar) {
        aVar.a(true, true);
        iconCompat.a(aVar.a());
        if (-1 != iconCompat.f1614a) {
            aVar.a(iconCompat.f1614a, 1);
        }
        if (iconCompat.f1616c != null) {
            aVar.a(iconCompat.f1616c, 2);
        }
        if (iconCompat.f1617d != null) {
            aVar.a(iconCompat.f1617d, 3);
        }
        if (iconCompat.f1618e != 0) {
            aVar.a(iconCompat.f1618e, 4);
        }
        if (iconCompat.f != 0) {
            aVar.a(iconCompat.f, 5);
        }
        if (iconCompat.g != null) {
            aVar.a(iconCompat.g, 6);
        }
        if (iconCompat.j != null) {
            aVar.a(iconCompat.j, 7);
        }
    }
}

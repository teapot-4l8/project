package androidx.core.content.b;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: FontResourcesParserCompat.java */
/* loaded from: classes.dex */
public class c {

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class d implements a {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.core.e.a f1488a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1489b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1490c;

        public d(androidx.core.e.a aVar, int i, int i2) {
            this.f1488a = aVar;
            this.f1490c = i;
            this.f1489b = i2;
        }

        public androidx.core.e.a a() {
            return this.f1488a;
        }

        public int b() {
            return this.f1490c;
        }

        public int c() {
            return this.f1489b;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* renamed from: androidx.core.content.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0031c {

        /* renamed from: a  reason: collision with root package name */
        private final String f1483a;

        /* renamed from: b  reason: collision with root package name */
        private int f1484b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f1485c;

        /* renamed from: d  reason: collision with root package name */
        private String f1486d;

        /* renamed from: e  reason: collision with root package name */
        private int f1487e;
        private int f;

        public C0031c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f1483a = str;
            this.f1484b = i;
            this.f1485c = z;
            this.f1486d = str2;
            this.f1487e = i2;
            this.f = i3;
        }

        public String a() {
            return this.f1483a;
        }

        public int b() {
            return this.f1484b;
        }

        public boolean c() {
            return this.f1485c;
        }

        public String d() {
            return this.f1486d;
        }

        public int e() {
            return this.f1487e;
        }

        public int f() {
            return this.f;
        }
    }

    /* compiled from: FontResourcesParserCompat.java */
    /* loaded from: classes.dex */
    public static final class b implements a {

        /* renamed from: a  reason: collision with root package name */
        private final C0031c[] f1482a;

        public b(C0031c[] c0031cArr) {
            this.f1482a = c0031cArr;
        }

        public C0031c[] a() {
            return this.f1482a;
        }
    }

    public static a a(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return b(xmlPullParser, resources);
    }

    private static a b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return c(xmlPullParser, resources);
        }
        a(xmlPullParser);
        return null;
    }

    private static a c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamily);
        String string = obtainAttributes.getString(R.styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R.styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(R.styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R.styleable.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                a(xmlPullParser);
            }
            return new d(new androidx.core.e.a(string, string2, string3, a(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(d(xmlPullParser, resources));
                } else {
                    a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((C0031c[]) arrayList.toArray(new C0031c[arrayList.size()]));
    }

    private static int a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    public static List<List<byte[]>> a(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    private static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    private static C0031c d(XmlPullParser xmlPullParser, Resources resources) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.FontFamilyFont);
        if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontWeight)) {
            i = R.styleable.FontFamilyFont_fontWeight;
        } else {
            i = R.styleable.FontFamilyFont_android_fontWeight;
        }
        int i6 = obtainAttributes.getInt(i, 400);
        if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontStyle)) {
            i2 = R.styleable.FontFamilyFont_fontStyle;
        } else {
            i2 = R.styleable.FontFamilyFont_android_fontStyle;
        }
        boolean z = 1 == obtainAttributes.getInt(i2, 0);
        if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_ttcIndex)) {
            i3 = R.styleable.FontFamilyFont_ttcIndex;
        } else {
            i3 = R.styleable.FontFamilyFont_android_ttcIndex;
        }
        if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_fontVariationSettings)) {
            i4 = R.styleable.FontFamilyFont_fontVariationSettings;
        } else {
            i4 = R.styleable.FontFamilyFont_android_fontVariationSettings;
        }
        String string = obtainAttributes.getString(i4);
        int i7 = obtainAttributes.getInt(i3, 0);
        if (obtainAttributes.hasValue(R.styleable.FontFamilyFont_font)) {
            i5 = R.styleable.FontFamilyFont_font;
        } else {
            i5 = R.styleable.FontFamilyFont_android_font;
        }
        int resourceId = obtainAttributes.getResourceId(i5, 0);
        String string2 = obtainAttributes.getString(i5);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            a(xmlPullParser);
        }
        return new C0031c(string2, i6, z, string, i7, resourceId);
    }

    private static void a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }
}

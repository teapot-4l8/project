package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.a;
import android.support.v4.media.b;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() { // from class: android.support.v4.media.MediaDescriptionCompat.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.a(android.support.v4.media.a.a(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MediaDescriptionCompat[] newArray(int i) {
            return new MediaDescriptionCompat[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final String f422a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f423b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f424c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f425d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f426e;
    private final Uri f;
    private final Bundle g;
    private final Uri h;
    private Object i;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f422a = str;
        this.f423b = charSequence;
        this.f424c = charSequence2;
        this.f425d = charSequence3;
        this.f426e = bitmap;
        this.f = uri;
        this.g = bundle;
        this.h = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f422a = parcel.readString();
        this.f423b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f424c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f425d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = getClass().getClassLoader();
        this.f426e = (Bitmap) parcel.readParcelable(classLoader);
        this.f = (Uri) parcel.readParcelable(classLoader);
        this.g = parcel.readBundle(classLoader);
        this.h = (Uri) parcel.readParcelable(classLoader);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.f422a);
            TextUtils.writeToParcel(this.f423b, parcel, i);
            TextUtils.writeToParcel(this.f424c, parcel, i);
            TextUtils.writeToParcel(this.f425d, parcel, i);
            parcel.writeParcelable(this.f426e, i);
            parcel.writeParcelable(this.f, i);
            parcel.writeBundle(this.g);
            parcel.writeParcelable(this.h, i);
            return;
        }
        android.support.v4.media.a.a(a(), parcel, i);
    }

    public String toString() {
        return ((Object) this.f423b) + ", " + ((Object) this.f424c) + ", " + ((Object) this.f425d);
    }

    public Object a() {
        if (this.i != null || Build.VERSION.SDK_INT < 21) {
            return this.i;
        }
        Object a2 = a.C0011a.a();
        a.C0011a.a(a2, this.f422a);
        a.C0011a.a(a2, this.f423b);
        a.C0011a.b(a2, this.f424c);
        a.C0011a.c(a2, this.f425d);
        a.C0011a.a(a2, this.f426e);
        a.C0011a.a(a2, this.f);
        Bundle bundle = this.g;
        if (Build.VERSION.SDK_INT < 23 && this.h != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.h);
        }
        a.C0011a.a(a2, bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            b.a.a(a2, this.h);
        }
        Object a3 = a.C0011a.a(a2);
        this.i = a3;
        return a3;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaDescriptionCompat a(Object obj) {
        Uri uri;
        Bundle bundle = null;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        a aVar = new a();
        aVar.a(android.support.v4.media.a.a(obj));
        aVar.a(android.support.v4.media.a.b(obj));
        aVar.b(android.support.v4.media.a.c(obj));
        aVar.c(android.support.v4.media.a.d(obj));
        aVar.a(android.support.v4.media.a.e(obj));
        aVar.a(android.support.v4.media.a.f(obj));
        Bundle g = android.support.v4.media.a.g(obj);
        if (g != null) {
            MediaSessionCompat.a(g);
            uri = (Uri) g.getParcelable("android.support.v4.media.description.MEDIA_URI");
        } else {
            uri = null;
        }
        if (uri != null) {
            if (!g.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || g.size() != 2) {
                g.remove("android.support.v4.media.description.MEDIA_URI");
                g.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            }
            aVar.a(bundle);
            if (uri == null) {
                aVar.b(uri);
            } else if (Build.VERSION.SDK_INT >= 23) {
                aVar.b(b.a(obj));
            }
            MediaDescriptionCompat a2 = aVar.a();
            a2.i = obj;
            return a2;
        }
        bundle = g;
        aVar.a(bundle);
        if (uri == null) {
        }
        MediaDescriptionCompat a22 = aVar.a();
        a22.i = obj;
        return a22;
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f427a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f428b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f429c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f430d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f431e;
        private Uri f;
        private Bundle g;
        private Uri h;

        public a a(String str) {
            this.f427a = str;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f428b = charSequence;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.f429c = charSequence;
            return this;
        }

        public a c(CharSequence charSequence) {
            this.f430d = charSequence;
            return this;
        }

        public a a(Bitmap bitmap) {
            this.f431e = bitmap;
            return this;
        }

        public a a(Uri uri) {
            this.f = uri;
            return this;
        }

        public a a(Bundle bundle) {
            this.g = bundle;
            return this;
        }

        public a b(Uri uri) {
            this.h = uri;
            return this;
        }

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f427a, this.f428b, this.f429c, this.f430d, this.f431e, this.f, this.g, this.h);
        }
    }
}

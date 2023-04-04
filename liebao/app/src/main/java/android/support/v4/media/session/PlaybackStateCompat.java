package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.e;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() { // from class: android.support.v4.media.session.PlaybackStateCompat.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int f468a;

    /* renamed from: b  reason: collision with root package name */
    final long f469b;

    /* renamed from: c  reason: collision with root package name */
    final long f470c;

    /* renamed from: d  reason: collision with root package name */
    final float f471d;

    /* renamed from: e  reason: collision with root package name */
    final long f472e;
    final int f;
    final CharSequence g;
    final long h;
    List<CustomAction> i;
    final long j;
    final Bundle k;
    private Object l;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f468a = i;
        this.f469b = j;
        this.f470c = j2;
        this.f471d = f;
        this.f472e = j3;
        this.f = i2;
        this.g = charSequence;
        this.h = j4;
        this.i = new ArrayList(list);
        this.j = j5;
        this.k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f468a = parcel.readInt();
        this.f469b = parcel.readLong();
        this.f471d = parcel.readFloat();
        this.h = parcel.readLong();
        this.f470c = parcel.readLong();
        this.f472e = parcel.readLong();
        this.g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.j = parcel.readLong();
        this.k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f = parcel.readInt();
    }

    public String toString() {
        return "PlaybackState {state=" + this.f468a + ", position=" + this.f469b + ", buffered position=" + this.f470c + ", speed=" + this.f471d + ", updated=" + this.h + ", actions=" + this.f472e + ", error code=" + this.f + ", error message=" + this.g + ", custom actions=" + this.i + ", active item id=" + this.j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f468a);
        parcel.writeLong(this.f469b);
        parcel.writeFloat(this.f471d);
        parcel.writeLong(this.h);
        parcel.writeLong(this.f470c);
        parcel.writeLong(this.f472e);
        TextUtils.writeToParcel(this.g, parcel, i);
        parcel.writeTypedList(this.i);
        parcel.writeLong(this.j);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.f);
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> h = e.h(obj);
        if (h != null) {
            ArrayList arrayList2 = new ArrayList(h.size());
            for (Object obj2 : h) {
                arrayList2.add(CustomAction.a(obj2));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(e.a(obj), e.b(obj), e.c(obj), e.d(obj), e.e(obj), 0, e.f(obj), e.g(obj), arrayList, e.i(obj), Build.VERSION.SDK_INT >= 22 ? f.a(obj) : null);
        playbackStateCompat.l = obj;
        return playbackStateCompat;
    }

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() { // from class: android.support.v4.media.session.PlaybackStateCompat.CustomAction.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final String f473a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f474b;

        /* renamed from: c  reason: collision with root package name */
        private final int f475c;

        /* renamed from: d  reason: collision with root package name */
        private final Bundle f476d;

        /* renamed from: e  reason: collision with root package name */
        private Object f477e;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f473a = str;
            this.f474b = charSequence;
            this.f475c = i;
            this.f476d = bundle;
        }

        CustomAction(Parcel parcel) {
            this.f473a = parcel.readString();
            this.f474b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f475c = parcel.readInt();
            this.f476d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f473a);
            TextUtils.writeToParcel(this.f474b, parcel, i);
            parcel.writeInt(this.f475c);
            parcel.writeBundle(this.f476d);
        }

        public static CustomAction a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(e.a.a(obj), e.a.b(obj), e.a.c(obj), e.a.d(obj));
            customAction.f477e = obj;
            return customAction;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f474b) + ", mIcon=" + this.f475c + ", mExtras=" + this.f476d;
        }
    }
}

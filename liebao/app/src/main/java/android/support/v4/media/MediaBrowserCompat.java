package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f413a = Log.isLoggable("MediaBrowserCompat", 3);

    /* loaded from: classes.dex */
    public static abstract class a {
        public void a(String str, Bundle bundle, Bundle bundle2) {
        }

        public void b(String str, Bundle bundle, Bundle bundle2) {
        }

        public void c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public void a(MediaItem mediaItem) {
        }

        public void a(String str) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public void a(String str, Bundle bundle) {
        }

        public void a(String str, Bundle bundle, List<MediaItem> list) {
        }
    }

    /* loaded from: classes.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final int f418a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaDescriptionCompat f419b;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        MediaItem(Parcel parcel) {
            this.f418a = parcel.readInt();
            this.f419b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f418a);
            this.f419b.writeToParcel(parcel, i);
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.f418a + ", mDescription=" + this.f419b + '}';
        }
    }

    /* loaded from: classes.dex */
    private static class ItemReceiver extends android.support.v4.a.b {

        /* renamed from: d  reason: collision with root package name */
        private final String f416d;

        /* renamed from: e  reason: collision with root package name */
        private final b f417e;

        @Override // android.support.v4.a.b
        protected void a(int i, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
                this.f417e.a(this.f416d);
                return;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.f417e.a((MediaItem) parcelable);
            } else {
                this.f417e.a(this.f416d);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class SearchResultReceiver extends android.support.v4.a.b {

        /* renamed from: d  reason: collision with root package name */
        private final String f420d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f421e;
        private final c f;

        @Override // android.support.v4.a.b
        protected void a(int i, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey("search_results")) {
                this.f.a(this.f420d, this.f421e);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            this.f.a(this.f420d, this.f421e, arrayList);
        }
    }

    /* loaded from: classes.dex */
    private static class CustomActionResultReceiver extends android.support.v4.a.b {

        /* renamed from: d  reason: collision with root package name */
        private final String f414d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f415e;
        private final a f;

        @Override // android.support.v4.a.b
        protected void a(int i, Bundle bundle) {
            if (this.f == null) {
                return;
            }
            MediaSessionCompat.a(bundle);
            if (i == -1) {
                this.f.c(this.f414d, this.f415e, bundle);
            } else if (i == 0) {
                this.f.b(this.f414d, this.f415e, bundle);
            } else if (i == 1) {
                this.f.a(this.f414d, this.f415e, bundle);
            } else {
                Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.f415e + ", resultData=" + bundle + ")");
            }
        }
    }
}

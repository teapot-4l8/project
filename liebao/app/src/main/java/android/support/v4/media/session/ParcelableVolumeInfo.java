package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = new Parcelable.Creator<ParcelableVolumeInfo>() { // from class: android.support.v4.media.session.ParcelableVolumeInfo.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ParcelableVolumeInfo createFromParcel(Parcel parcel) {
            return new ParcelableVolumeInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ParcelableVolumeInfo[] newArray(int i) {
            return new ParcelableVolumeInfo[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public int f463a;

    /* renamed from: b  reason: collision with root package name */
    public int f464b;

    /* renamed from: c  reason: collision with root package name */
    public int f465c;

    /* renamed from: d  reason: collision with root package name */
    public int f466d;

    /* renamed from: e  reason: collision with root package name */
    public int f467e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ParcelableVolumeInfo(Parcel parcel) {
        this.f463a = parcel.readInt();
        this.f465c = parcel.readInt();
        this.f466d = parcel.readInt();
        this.f467e = parcel.readInt();
        this.f464b = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f463a);
        parcel.writeInt(this.f465c);
        parcel.writeInt(this.f466d);
        parcel.writeInt(this.f467e);
        parcel.writeInt(this.f464b);
    }
}

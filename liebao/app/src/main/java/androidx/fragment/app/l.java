package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentManagerState.java */
/* loaded from: classes.dex */
public final class l implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new Parcelable.Creator<l>() { // from class: androidx.fragment.app.l.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public l createFromParcel(Parcel parcel) {
            return new l(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public l[] newArray(int i) {
            return new l[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    ArrayList<o> f1903a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<String> f1904b;

    /* renamed from: c  reason: collision with root package name */
    b[] f1905c;

    /* renamed from: d  reason: collision with root package name */
    String f1906d;

    /* renamed from: e  reason: collision with root package name */
    int f1907e;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public l() {
        this.f1906d = null;
    }

    public l(Parcel parcel) {
        this.f1906d = null;
        this.f1903a = parcel.createTypedArrayList(o.CREATOR);
        this.f1904b = parcel.createStringArrayList();
        this.f1905c = (b[]) parcel.createTypedArray(b.CREATOR);
        this.f1906d = parcel.readString();
        this.f1907e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f1903a);
        parcel.writeStringList(this.f1904b);
        parcel.writeTypedArray(this.f1905c, i);
        parcel.writeString(this.f1906d);
        parcel.writeInt(this.f1907e);
    }
}

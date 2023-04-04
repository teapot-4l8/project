package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;

/* compiled from: VersionedParcelParcel.java */
/* loaded from: classes.dex */
class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f2728d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f2729e;
    private final int f;
    private final int g;
    private final String h;
    private int i;
    private int j;
    private int k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.b.a(), new androidx.b.a(), new androidx.b.a());
    }

    private b(Parcel parcel, int i, int i2, String str, androidx.b.a<String, Method> aVar, androidx.b.a<String, Method> aVar2, androidx.b.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f2728d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.f2729e = parcel;
        this.f = i;
        this.g = i2;
        this.j = i;
        this.h = str;
    }

    @Override // androidx.versionedparcelable.a
    public boolean b(int i) {
        while (this.j < this.g) {
            int i2 = this.k;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f2729e.setDataPosition(this.j);
            int readInt = this.f2729e.readInt();
            this.k = this.f2729e.readInt();
            this.j += readInt;
        }
        return this.k == i;
    }

    @Override // androidx.versionedparcelable.a
    public void c(int i) {
        b();
        this.i = i;
        this.f2728d.put(i, this.f2729e.dataPosition());
        a(0);
        a(i);
    }

    @Override // androidx.versionedparcelable.a
    public void b() {
        int i = this.i;
        if (i >= 0) {
            int i2 = this.f2728d.get(i);
            int dataPosition = this.f2729e.dataPosition();
            this.f2729e.setDataPosition(i2);
            this.f2729e.writeInt(dataPosition - i2);
            this.f2729e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.a
    protected a c() {
        Parcel parcel = this.f2729e;
        int dataPosition = parcel.dataPosition();
        int i = this.j;
        if (i == this.f) {
            i = this.g;
        }
        int i2 = i;
        return new b(parcel, dataPosition, i2, this.h + "  ", this.f2725a, this.f2726b, this.f2727c);
    }

    @Override // androidx.versionedparcelable.a
    public void a(byte[] bArr) {
        if (bArr != null) {
            this.f2729e.writeInt(bArr.length);
            this.f2729e.writeByteArray(bArr);
            return;
        }
        this.f2729e.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.a
    public void a(int i) {
        this.f2729e.writeInt(i);
    }

    @Override // androidx.versionedparcelable.a
    public void a(String str) {
        this.f2729e.writeString(str);
    }

    @Override // androidx.versionedparcelable.a
    public void a(Parcelable parcelable) {
        this.f2729e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.a
    public void a(boolean z) {
        this.f2729e.writeInt(z ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.a
    protected void a(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f2729e, 0);
    }

    @Override // androidx.versionedparcelable.a
    protected CharSequence g() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f2729e);
    }

    @Override // androidx.versionedparcelable.a
    public int d() {
        return this.f2729e.readInt();
    }

    @Override // androidx.versionedparcelable.a
    public String e() {
        return this.f2729e.readString();
    }

    @Override // androidx.versionedparcelable.a
    public byte[] f() {
        int readInt = this.f2729e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f2729e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.a
    public <T extends Parcelable> T h() {
        return (T) this.f2729e.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.a
    public boolean i() {
        return this.f2729e.readInt() != 0;
    }
}

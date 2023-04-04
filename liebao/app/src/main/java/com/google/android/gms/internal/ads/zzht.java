package com.google.android.gms.internal.ads;

import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.umeng.analytics.pro.ak;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzht implements Parcelable {
    public static final Parcelable.Creator<zzht> CREATOR = new zzhs();
    public final int height;
    private final String id;
    public final int width;
    public final int zzahk;
    public final String zzahl;
    private final zzmh zzahm;
    public final String zzahn;
    public final String zzaho;
    public final int zzahp;
    public final List<byte[]> zzahq;
    public final zzjo zzahr;
    public final float zzahs;
    public final int zzaht;
    public final float zzahu;
    private final int zzahv;
    private final byte[] zzahw;
    private final zzpy zzahx;
    public final int zzahy;
    public final int zzahz;
    public final int zzaia;
    private final int zzaib;
    private final int zzaic;
    public final long zzaid;
    public final int zzaie;
    public final String zzaif;
    private final int zzaig;
    private int zzaih;

    public static zzht zza(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, zzpy zzpyVar, zzjo zzjoVar) {
        return new zzht(str, null, str2, null, -1, i2, i3, i4, -1.0f, i5, f2, bArr, i6, zzpyVar, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, zzjoVar, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public static zzht zza(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, zzjo zzjoVar, int i5, String str4) {
        return zza(str, str2, null, -1, -1, i3, i4, -1, null, zzjoVar, 0, str4);
    }

    public static zzht zza(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, zzjo zzjoVar, int i6, String str4) {
        return new zzht(str, null, str2, null, -1, i2, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i3, i4, i5, -1, -1, i6, str4, -1, Long.MAX_VALUE, list, zzjoVar, null);
    }

    public static zzht zza(String str, String str2, String str3, int i, int i2, String str4, zzjo zzjoVar) {
        return zza(str, str2, null, -1, i2, str4, -1, zzjoVar, Long.MAX_VALUE, Collections.emptyList());
    }

    public static zzht zza(String str, String str2, String str3, int i, int i2, String str4, int i3, zzjo zzjoVar, long j, List<byte[]> list) {
        return new zzht(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, zzjoVar, null);
    }

    public static zzht zza(String str, String str2, String str3, int i, List<byte[]> list, String str4, zzjo zzjoVar) {
        return new zzht(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, zzjoVar, null);
    }

    public static zzht zza(String str, String str2, long j) {
        return new zzht(null, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, null, null);
    }

    public static zzht zza(String str, String str2, String str3, int i, zzjo zzjoVar) {
        return new zzht(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, zzjoVar, null);
    }

    private zzht(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, zzpy zzpyVar, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, zzjo zzjoVar, zzmh zzmhVar) {
        this.id = str;
        this.zzahn = str2;
        this.zzaho = str3;
        this.zzahl = str4;
        this.zzahk = i;
        this.zzahp = i2;
        this.width = i3;
        this.height = i4;
        this.zzahs = f;
        this.zzaht = i5;
        this.zzahu = f2;
        this.zzahw = bArr;
        this.zzahv = i6;
        this.zzahx = zzpyVar;
        this.zzahy = i7;
        this.zzahz = i8;
        this.zzaia = i9;
        this.zzaib = i10;
        this.zzaic = i11;
        this.zzaie = i12;
        this.zzaif = str5;
        this.zzaig = i13;
        this.zzaid = j;
        this.zzahq = list == null ? Collections.emptyList() : list;
        this.zzahr = zzjoVar;
        this.zzahm = zzmhVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzht(Parcel parcel) {
        this.id = parcel.readString();
        this.zzahn = parcel.readString();
        this.zzaho = parcel.readString();
        this.zzahl = parcel.readString();
        this.zzahk = parcel.readInt();
        this.zzahp = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.zzahs = parcel.readFloat();
        this.zzaht = parcel.readInt();
        this.zzahu = parcel.readFloat();
        this.zzahw = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.zzahv = parcel.readInt();
        this.zzahx = (zzpy) parcel.readParcelable(zzpy.class.getClassLoader());
        this.zzahy = parcel.readInt();
        this.zzahz = parcel.readInt();
        this.zzaia = parcel.readInt();
        this.zzaib = parcel.readInt();
        this.zzaic = parcel.readInt();
        this.zzaie = parcel.readInt();
        this.zzaif = parcel.readString();
        this.zzaig = parcel.readInt();
        this.zzaid = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzahq = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.zzahq.add(parcel.createByteArray());
        }
        this.zzahr = (zzjo) parcel.readParcelable(zzjo.class.getClassLoader());
        this.zzahm = (zzmh) parcel.readParcelable(zzmh.class.getClassLoader());
    }

    public final zzht zzy(int i) {
        return new zzht(this.id, this.zzahn, this.zzaho, this.zzahl, this.zzahk, i, this.width, this.height, this.zzahs, this.zzaht, this.zzahu, this.zzahw, this.zzahv, this.zzahx, this.zzahy, this.zzahz, this.zzaia, this.zzaib, this.zzaic, this.zzaie, this.zzaif, this.zzaig, this.zzaid, this.zzahq, this.zzahr, this.zzahm);
    }

    public final zzht zzds(long j) {
        return new zzht(this.id, this.zzahn, this.zzaho, this.zzahl, this.zzahk, this.zzahp, this.width, this.height, this.zzahs, this.zzaht, this.zzahu, this.zzahw, this.zzahv, this.zzahx, this.zzahy, this.zzahz, this.zzaia, this.zzaib, this.zzaic, this.zzaie, this.zzaif, this.zzaig, j, this.zzahq, this.zzahr, this.zzahm);
    }

    public final zzht zzd(int i, int i2) {
        return new zzht(this.id, this.zzahn, this.zzaho, this.zzahl, this.zzahk, this.zzahp, this.width, this.height, this.zzahs, this.zzaht, this.zzahu, this.zzahw, this.zzahv, this.zzahx, this.zzahy, this.zzahz, this.zzaia, i, i2, this.zzaie, this.zzaif, this.zzaig, this.zzaid, this.zzahq, this.zzahr, this.zzahm);
    }

    public final zzht zza(zzjo zzjoVar) {
        return new zzht(this.id, this.zzahn, this.zzaho, this.zzahl, this.zzahk, this.zzahp, this.width, this.height, this.zzahs, this.zzaht, this.zzahu, this.zzahw, this.zzahv, this.zzahx, this.zzahy, this.zzahz, this.zzaia, this.zzaib, this.zzaic, this.zzaie, this.zzaif, this.zzaig, this.zzaid, this.zzahq, zzjoVar, this.zzahm);
    }

    public final zzht zza(zzmh zzmhVar) {
        return new zzht(this.id, this.zzahn, this.zzaho, this.zzahl, this.zzahk, this.zzahp, this.width, this.height, this.zzahs, this.zzaht, this.zzahu, this.zzahw, this.zzahv, this.zzahx, this.zzahy, this.zzahz, this.zzaia, this.zzaib, this.zzaic, this.zzaie, this.zzaif, this.zzaig, this.zzaid, this.zzahq, this.zzahr, zzmhVar);
    }

    public final int zzfd() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public final MediaFormat zzfe() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.zzaho);
        String str = this.zzaif;
        if (str != null) {
            mediaFormat.setString(ak.N, str);
        }
        zza(mediaFormat, "max-input-size", this.zzahp);
        zza(mediaFormat, "width", this.width);
        zza(mediaFormat, "height", this.height);
        float f = this.zzahs;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        zza(mediaFormat, "rotation-degrees", this.zzaht);
        zza(mediaFormat, "channel-count", this.zzahy);
        zza(mediaFormat, "sample-rate", this.zzahz);
        zza(mediaFormat, "encoder-delay", this.zzaib);
        zza(mediaFormat, "encoder-padding", this.zzaic);
        for (int i = 0; i < this.zzahq.size(); i++) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.zzahq.get(i)));
        }
        zzpy zzpyVar = this.zzahx;
        if (zzpyVar != null) {
            zza(mediaFormat, "color-transfer", zzpyVar.zzasg);
            zza(mediaFormat, "color-standard", zzpyVar.zzasf);
            zza(mediaFormat, "color-range", zzpyVar.zzash);
            byte[] bArr = zzpyVar.zzbld;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final String toString() {
        String str = this.id;
        String str2 = this.zzahn;
        String str3 = this.zzaho;
        int i = this.zzahk;
        String str4 = this.zzaif;
        int i2 = this.width;
        int i3 = this.height;
        float f = this.zzahs;
        int i4 = this.zzahy;
        int i5 = this.zzahz;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 100 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("Format(");
        sb.append(str);
        sb.append(", ");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(str4);
        sb.append(", [");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append("], [");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append("])");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.zzaih == 0) {
            String str = this.id;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.zzahn;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzaho;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.zzahl;
            int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.zzahk) * 31) + this.width) * 31) + this.height) * 31) + this.zzahy) * 31) + this.zzahz) * 31;
            String str5 = this.zzaif;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.zzaig) * 31;
            zzjo zzjoVar = this.zzahr;
            int hashCode6 = (hashCode5 + (zzjoVar == null ? 0 : zzjoVar.hashCode())) * 31;
            zzmh zzmhVar = this.zzahm;
            this.zzaih = hashCode6 + (zzmhVar != null ? zzmhVar.hashCode() : 0);
        }
        return this.zzaih;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzht zzhtVar = (zzht) obj;
            if (this.zzahk == zzhtVar.zzahk && this.zzahp == zzhtVar.zzahp && this.width == zzhtVar.width && this.height == zzhtVar.height && this.zzahs == zzhtVar.zzahs && this.zzaht == zzhtVar.zzaht && this.zzahu == zzhtVar.zzahu && this.zzahv == zzhtVar.zzahv && this.zzahy == zzhtVar.zzahy && this.zzahz == zzhtVar.zzahz && this.zzaia == zzhtVar.zzaia && this.zzaib == zzhtVar.zzaib && this.zzaic == zzhtVar.zzaic && this.zzaid == zzhtVar.zzaid && this.zzaie == zzhtVar.zzaie && zzpt.zza(this.id, zzhtVar.id) && zzpt.zza(this.zzaif, zzhtVar.zzaif) && this.zzaig == zzhtVar.zzaig && zzpt.zza(this.zzahn, zzhtVar.zzahn) && zzpt.zza(this.zzaho, zzhtVar.zzaho) && zzpt.zza(this.zzahl, zzhtVar.zzahl) && zzpt.zza(this.zzahr, zzhtVar.zzahr) && zzpt.zza(this.zzahm, zzhtVar.zzahm) && zzpt.zza(this.zzahx, zzhtVar.zzahx) && Arrays.equals(this.zzahw, zzhtVar.zzahw) && this.zzahq.size() == zzhtVar.zzahq.size()) {
                for (int i = 0; i < this.zzahq.size(); i++) {
                    if (!Arrays.equals(this.zzahq.get(i), zzhtVar.zzahq.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static void zza(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.zzahn);
        parcel.writeString(this.zzaho);
        parcel.writeString(this.zzahl);
        parcel.writeInt(this.zzahk);
        parcel.writeInt(this.zzahp);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.zzahs);
        parcel.writeInt(this.zzaht);
        parcel.writeFloat(this.zzahu);
        parcel.writeInt(this.zzahw != null ? 1 : 0);
        byte[] bArr = this.zzahw;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.zzahv);
        parcel.writeParcelable(this.zzahx, i);
        parcel.writeInt(this.zzahy);
        parcel.writeInt(this.zzahz);
        parcel.writeInt(this.zzaia);
        parcel.writeInt(this.zzaib);
        parcel.writeInt(this.zzaic);
        parcel.writeInt(this.zzaie);
        parcel.writeString(this.zzaif);
        parcel.writeInt(this.zzaig);
        parcel.writeLong(this.zzaid);
        int size = this.zzahq.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.zzahq.get(i2));
        }
        parcel.writeParcelable(this.zzahr, 0);
        parcel.writeParcelable(this.zzahm, 0);
    }
}

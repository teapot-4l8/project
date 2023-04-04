package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzatq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatq> CREATOR = new zzatt();
    private final ApplicationInfo applicationInfo;
    private final int versionCode;
    private final zzbar zzbpx;
    private final zzvt zzbpy;
    private final float zzbsn;
    private final String zzbvf;
    private final String zzckb;
    private final boolean zzdnf;
    private final zzaei zzdpr;
    private final List<String> zzdps;
    private final int zzdrr;
    private final int zzdrs;
    private final Bundle zzdvm;
    private final zzvq zzdvn;
    private final PackageInfo zzdvo;
    private final String zzdvp;
    private final String zzdvq;
    private final Bundle zzdvr;
    private final int zzdvs;
    private final Bundle zzdvt;
    private final boolean zzdvu;
    private final String zzdvv;
    private final long zzdvw;
    private final String zzdvx;
    private final List<String> zzdvy;
    private final String zzdvz;
    private final List<String> zzdwa;
    private final long zzdwb;
    private final String zzdwc;
    private final float zzdwd;
    private final int zzdwe;
    private final int zzdwf;
    private final boolean zzdwg;
    private final String zzdwh;
    private final boolean zzdwi;
    private final String zzdwj;
    private final int zzdwk;
    private final Bundle zzdwl;
    private final String zzdwm;
    private final zzzj zzdwn;
    private final boolean zzdwo;
    private final Bundle zzdwp;
    private final String zzdwq;
    private final String zzdwr;
    private final String zzdws;
    private final boolean zzdwt;
    private final List<Integer> zzdwu;
    private final String zzdwv;
    private final List<String> zzdww;
    private final int zzdwx;
    private final boolean zzdwy;
    private final boolean zzdwz;
    private final boolean zzdxa;
    private final ArrayList<String> zzdxb;
    private final String zzdxc;
    private final zzajy zzdxd;
    private final String zzdxe;
    private final Bundle zzdxf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatq(int i, Bundle bundle, zzvq zzvqVar, zzvt zzvtVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, zzbar zzbarVar, Bundle bundle2, int i2, List<String> list, Bundle bundle3, boolean z, int i3, int i4, float f, String str5, long j, String str6, List<String> list2, String str7, zzaei zzaeiVar, List<String> list3, long j2, String str8, float f2, boolean z2, int i5, int i6, boolean z3, String str9, String str10, boolean z4, int i7, Bundle bundle4, String str11, zzzj zzzjVar, boolean z5, Bundle bundle5, String str12, String str13, String str14, boolean z6, List<Integer> list4, String str15, List<String> list5, int i8, boolean z7, boolean z8, boolean z9, ArrayList<String> arrayList, String str16, zzajy zzajyVar, String str17, Bundle bundle6) {
        List<String> unmodifiableList;
        List<String> unmodifiableList2;
        this.versionCode = i;
        this.zzdvm = bundle;
        this.zzdvn = zzvqVar;
        this.zzbpy = zzvtVar;
        this.zzbvf = str;
        this.applicationInfo = applicationInfo;
        this.zzdvo = packageInfo;
        this.zzdvp = str2;
        this.zzdvq = str3;
        this.zzckb = str4;
        this.zzbpx = zzbarVar;
        this.zzdvr = bundle2;
        this.zzdvs = i2;
        this.zzdps = list;
        if (list3 == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list3);
        }
        this.zzdwa = unmodifiableList;
        this.zzdvt = bundle3;
        this.zzdvu = z;
        this.zzdrr = i3;
        this.zzdrs = i4;
        this.zzbsn = f;
        this.zzdvv = str5;
        this.zzdvw = j;
        this.zzdvx = str6;
        if (list2 == null) {
            unmodifiableList2 = Collections.emptyList();
        } else {
            unmodifiableList2 = Collections.unmodifiableList(list2);
        }
        this.zzdvy = unmodifiableList2;
        this.zzdvz = str7;
        this.zzdpr = zzaeiVar;
        this.zzdwb = j2;
        this.zzdwc = str8;
        this.zzdwd = f2;
        this.zzdwi = z2;
        this.zzdwe = i5;
        this.zzdwf = i6;
        this.zzdwg = z3;
        this.zzdwh = str9;
        this.zzdwj = str10;
        this.zzdnf = z4;
        this.zzdwk = i7;
        this.zzdwl = bundle4;
        this.zzdwm = str11;
        this.zzdwn = zzzjVar;
        this.zzdwo = z5;
        this.zzdwp = bundle5;
        this.zzdwq = str12;
        this.zzdwr = str13;
        this.zzdws = str14;
        this.zzdwt = z6;
        this.zzdwu = list4;
        this.zzdwv = str15;
        this.zzdww = list5;
        this.zzdwx = i8;
        this.zzdwy = z7;
        this.zzdwz = z8;
        this.zzdxa = z9;
        this.zzdxb = arrayList;
        this.zzdxc = str16;
        this.zzdxd = zzajyVar;
        this.zzdxe = str17;
        this.zzdxf = bundle6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeBundle(parcel, 2, this.zzdvm, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdvn, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzbpy, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbvf, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.applicationInfo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzdvo, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzdvp, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzdvq, false);
        SafeParcelWriter.writeString(parcel, 10, this.zzckb, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzbpx, i, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.zzdvr, false);
        SafeParcelWriter.writeInt(parcel, 13, this.zzdvs);
        SafeParcelWriter.writeStringList(parcel, 14, this.zzdps, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.zzdvt, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzdvu);
        SafeParcelWriter.writeInt(parcel, 18, this.zzdrr);
        SafeParcelWriter.writeInt(parcel, 19, this.zzdrs);
        SafeParcelWriter.writeFloat(parcel, 20, this.zzbsn);
        SafeParcelWriter.writeString(parcel, 21, this.zzdvv, false);
        SafeParcelWriter.writeLong(parcel, 25, this.zzdvw);
        SafeParcelWriter.writeString(parcel, 26, this.zzdvx, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.zzdvy, false);
        SafeParcelWriter.writeString(parcel, 28, this.zzdvz, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.zzdpr, i, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.zzdwa, false);
        SafeParcelWriter.writeLong(parcel, 31, this.zzdwb);
        SafeParcelWriter.writeString(parcel, 33, this.zzdwc, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.zzdwd);
        SafeParcelWriter.writeInt(parcel, 35, this.zzdwe);
        SafeParcelWriter.writeInt(parcel, 36, this.zzdwf);
        SafeParcelWriter.writeBoolean(parcel, 37, this.zzdwg);
        SafeParcelWriter.writeString(parcel, 39, this.zzdwh, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.zzdwi);
        SafeParcelWriter.writeString(parcel, 41, this.zzdwj, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.zzdnf);
        SafeParcelWriter.writeInt(parcel, 43, this.zzdwk);
        SafeParcelWriter.writeBundle(parcel, 44, this.zzdwl, false);
        SafeParcelWriter.writeString(parcel, 45, this.zzdwm, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.zzdwn, i, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.zzdwo);
        SafeParcelWriter.writeBundle(parcel, 48, this.zzdwp, false);
        SafeParcelWriter.writeString(parcel, 49, this.zzdwq, false);
        SafeParcelWriter.writeString(parcel, 50, this.zzdwr, false);
        SafeParcelWriter.writeString(parcel, 51, this.zzdws, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.zzdwt);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.zzdwu, false);
        SafeParcelWriter.writeString(parcel, 54, this.zzdwv, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.zzdww, false);
        SafeParcelWriter.writeInt(parcel, 56, this.zzdwx);
        SafeParcelWriter.writeBoolean(parcel, 57, this.zzdwy);
        SafeParcelWriter.writeBoolean(parcel, 58, this.zzdwz);
        SafeParcelWriter.writeBoolean(parcel, 59, this.zzdxa);
        SafeParcelWriter.writeStringList(parcel, 60, this.zzdxb, false);
        SafeParcelWriter.writeString(parcel, 61, this.zzdxc, false);
        SafeParcelWriter.writeParcelable(parcel, 63, this.zzdxd, i, false);
        SafeParcelWriter.writeString(parcel, 64, this.zzdxe, false);
        SafeParcelWriter.writeBundle(parcel, 65, this.zzdxf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}

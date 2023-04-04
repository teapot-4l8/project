package com.google.android.gms.internal.ads;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zzizn uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public class zzeqr {
    public static final zzeqr zzizf = new zzeqr("DOUBLE", 0, zzequ.DOUBLE, 1);
    public static final zzeqr zzizg = new zzeqr("FLOAT", 1, zzequ.FLOAT, 5);
    public static final zzeqr zzizh = new zzeqr("INT64", 2, zzequ.LONG, 0);
    public static final zzeqr zzizi = new zzeqr("UINT64", 3, zzequ.LONG, 0);
    public static final zzeqr zzizj = new zzeqr("INT32", 4, zzequ.INT, 0);
    public static final zzeqr zzizk = new zzeqr("FIXED64", 5, zzequ.LONG, 1);
    public static final zzeqr zzizl = new zzeqr("FIXED32", 6, zzequ.INT, 5);
    public static final zzeqr zzizm = new zzeqr("BOOL", 7, zzequ.BOOLEAN, 0);
    public static final zzeqr zzizn;
    public static final zzeqr zzizo;
    public static final zzeqr zzizp;
    public static final zzeqr zzizq;
    public static final zzeqr zzizr;
    public static final zzeqr zzizs;
    public static final zzeqr zzizt;
    public static final zzeqr zzizu;
    public static final zzeqr zzizv;
    public static final zzeqr zzizw;
    private static final /* synthetic */ zzeqr[] zzizz;
    private final zzequ zzizx;
    private final int zzizy;

    public static zzeqr[] values() {
        return (zzeqr[]) zzizz.clone();
    }

    private zzeqr(String str, int i, zzequ zzequVar, int i2) {
        this.zzizx = zzequVar;
        this.zzizy = i2;
    }

    public final zzequ zzbmh() {
        return this.zzizx;
    }

    public final int zzbmi() {
        return this.zzizy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzeqr(String str, int i, zzequ zzequVar, int i2, zzeqo zzeqoVar) {
        this(str, i, zzequVar, i2);
    }

    static {
        final zzequ zzequVar = zzequ.STRING;
        zzizn = new zzeqr("STRING", 8, zzequVar, 2) { // from class: com.google.android.gms.internal.ads.zzeqq
        };
        final zzequ zzequVar2 = zzequ.MESSAGE;
        zzizo = new zzeqr("GROUP", 9, zzequVar2, 3) { // from class: com.google.android.gms.internal.ads.zzeqt
        };
        final zzequ zzequVar3 = zzequ.MESSAGE;
        zzizp = new zzeqr("MESSAGE", 10, zzequVar3, 2) { // from class: com.google.android.gms.internal.ads.zzeqs
        };
        final zzequ zzequVar4 = zzequ.BYTE_STRING;
        zzizq = new zzeqr("BYTES", 11, zzequVar4, 2) { // from class: com.google.android.gms.internal.ads.zzeqv
        };
        zzizr = new zzeqr("UINT32", 12, zzequ.INT, 0);
        zzizs = new zzeqr("ENUM", 13, zzequ.ENUM, 0);
        zzizt = new zzeqr("SFIXED32", 14, zzequ.INT, 5);
        zzizu = new zzeqr("SFIXED64", 15, zzequ.LONG, 1);
        zzizv = new zzeqr("SINT32", 16, zzequ.INT, 0);
        zzeqr zzeqrVar = new zzeqr("SINT64", 17, zzequ.LONG, 0);
        zzizw = zzeqrVar;
        zzizz = new zzeqr[]{zzizf, zzizg, zzizh, zzizi, zzizj, zzizk, zzizl, zzizm, zzizn, zzizo, zzizp, zzizq, zzizr, zzizs, zzizt, zzizu, zzizv, zzeqrVar};
    }
}

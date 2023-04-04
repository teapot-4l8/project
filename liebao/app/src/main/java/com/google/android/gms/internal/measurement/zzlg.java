package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum zzi uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
public class zzlg {
    public static final zzlg zza = new zzlg("DOUBLE", 0, zzln.DOUBLE, 1);
    public static final zzlg zzb = new zzlg("FLOAT", 1, zzln.FLOAT, 5);
    public static final zzlg zzc = new zzlg("INT64", 2, zzln.LONG, 0);
    public static final zzlg zzd = new zzlg("UINT64", 3, zzln.LONG, 0);
    public static final zzlg zze = new zzlg("INT32", 4, zzln.INT, 0);
    public static final zzlg zzf = new zzlg("FIXED64", 5, zzln.LONG, 1);
    public static final zzlg zzg = new zzlg("FIXED32", 6, zzln.INT, 5);
    public static final zzlg zzh = new zzlg("BOOL", 7, zzln.BOOLEAN, 0);
    public static final zzlg zzi;
    public static final zzlg zzj;
    public static final zzlg zzk;
    public static final zzlg zzl;
    public static final zzlg zzm;
    public static final zzlg zzn;
    public static final zzlg zzo;
    public static final zzlg zzp;
    public static final zzlg zzq;
    public static final zzlg zzr;
    private static final /* synthetic */ zzlg[] zzu;
    private final zzln zzs;
    private final int zzt;

    public static zzlg[] values() {
        return (zzlg[]) zzu.clone();
    }

    private zzlg(String str, int i, zzln zzlnVar, int i2) {
        this.zzs = zzlnVar;
        this.zzt = i2;
    }

    public final zzln zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzlg(String str, int i, zzln zzlnVar, int i2, zzlh zzlhVar) {
        this(str, i, zzlnVar, i2);
    }

    static {
        final zzln zzlnVar = zzln.STRING;
        zzi = new zzlg("STRING", 8, zzlnVar, 2) { // from class: com.google.android.gms.internal.measurement.zzlj
        };
        final zzln zzlnVar2 = zzln.MESSAGE;
        zzj = new zzlg("GROUP", 9, zzlnVar2, 3) { // from class: com.google.android.gms.internal.measurement.zzli
        };
        final zzln zzlnVar3 = zzln.MESSAGE;
        zzk = new zzlg("MESSAGE", 10, zzlnVar3, 2) { // from class: com.google.android.gms.internal.measurement.zzll
        };
        final zzln zzlnVar4 = zzln.BYTE_STRING;
        zzl = new zzlg("BYTES", 11, zzlnVar4, 2) { // from class: com.google.android.gms.internal.measurement.zzlk
        };
        zzm = new zzlg("UINT32", 12, zzln.INT, 0);
        zzn = new zzlg("ENUM", 13, zzln.ENUM, 0);
        zzo = new zzlg("SFIXED32", 14, zzln.INT, 5);
        zzp = new zzlg("SFIXED64", 15, zzln.LONG, 1);
        zzq = new zzlg("SINT32", 16, zzln.INT, 0);
        zzlg zzlgVar = new zzlg("SINT64", 17, zzln.LONG, 0);
        zzr = zzlgVar;
        zzu = new zzlg[]{zza, zzb, zzc, zzd, zze, zzf, zzg, zzh, zzi, zzj, zzk, zzl, zzm, zzn, zzo, zzp, zzq, zzlgVar};
    }
}

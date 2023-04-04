package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public final class zzeqg {
    private static final boolean zziqf;
    private static final zzd zziyk;
    private static final boolean zziyl;
    private static final long zziym;
    private static final long zziyn;
    private static final long zziyo;
    private static final long zziyp;
    private static final long zziyq;
    private static final long zziyr;
    private static final long zziys;
    private static final long zziyt;
    private static final long zziyu;
    private static final long zziyv;
    private static final long zziyw;
    private static final long zziyx;
    private static final long zziyy;
    private static final long zziyz;
    private static final int zziza;
    static final boolean zzizb;
    private static final Unsafe zzicl = zzbmd();
    private static final Class<?> zziot = zzelj.zzbhc();
    private static final boolean zziyi = zzo(Long.TYPE);
    private static final boolean zziyj = zzo(Integer.TYPE);

    private zzeqg() {
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    private static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final byte zzy(Object obj, long j) {
            if (zzeqg.zzizb) {
                return zzeqg.zzq(obj, j);
            }
            return zzeqg.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final void zze(Object obj, long j, byte b2) {
            if (zzeqg.zzizb) {
                zzeqg.zza(obj, j, b2);
            } else {
                zzeqg.zzb(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final boolean zzm(Object obj, long j) {
            if (zzeqg.zzizb) {
                return zzeqg.zzs(obj, j);
            }
            return zzeqg.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzeqg.zzizb) {
                zzeqg.zzb(obj, j, z);
            } else {
                zzeqg.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    private static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final byte zzy(Object obj, long j) {
            return this.zzize.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final void zze(Object obj, long j, byte b2) {
            this.zzize.putByte(obj, j, b2);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final boolean zzm(Object obj, long j) {
            return this.zzize.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final void zza(Object obj, long j, boolean z) {
            this.zzize.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final float zzn(Object obj, long j) {
            return this.zzize.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final void zza(Object obj, long j, float f) {
            this.zzize.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final double zzo(Object obj, long j) {
            return this.zzize.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final void zza(Object obj, long j, double d2) {
            this.zzize.putDouble(obj, j, d2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    private static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final byte zzy(Object obj, long j) {
            if (zzeqg.zzizb) {
                return zzeqg.zzq(obj, j);
            }
            return zzeqg.zzr(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final void zze(Object obj, long j, byte b2) {
            if (zzeqg.zzizb) {
                zzeqg.zza(obj, j, b2);
            } else {
                zzeqg.zzb(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final boolean zzm(Object obj, long j) {
            if (zzeqg.zzizb) {
                return zzeqg.zzs(obj, j);
            }
            return zzeqg.zzt(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final void zza(Object obj, long j, boolean z) {
            if (zzeqg.zzizb) {
                zzeqg.zzb(obj, j, z);
            } else {
                zzeqg.zzc(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.zzeqg.zzd
        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzbmb() {
        return zziqf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static abstract class zzd {
        Unsafe zzize;

        zzd(Unsafe unsafe) {
            this.zzize = unsafe;
        }

        public abstract void zza(Object obj, long j, double d2);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b2);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzize.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzize.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzize.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzize.putLong(obj, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzbmc() {
        return zziyl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zzl(Class<T> cls) {
        try {
            return (T) zzicl.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int zzm(Class<?> cls) {
        if (zziqf) {
            return zziyk.zzize.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzn(Class<?> cls) {
        if (zziqf) {
            return zziyk.zzize.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(Object obj, long j) {
        return zziyk.zzk(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(Object obj, long j, int i) {
        zziyk.zzb(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzl(Object obj, long j) {
        return zziyk.zzl(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, long j2) {
        zziyk.zza(obj, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzm(Object obj, long j) {
        return zziyk.zzm(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, boolean z) {
        zziyk.zza(obj, j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzn(Object obj, long j) {
        return zziyk.zzn(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, float f) {
        zziyk.zza(obj, j, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzo(Object obj, long j) {
        return zziyk.zzo(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, double d2) {
        zziyk.zza(obj, j, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzp(Object obj, long j) {
        return zziyk.zzize.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, Object obj2) {
        zziyk.zzize.putObject(obj, j, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte zza(byte[] bArr, long j) {
        return zziyk.zzy(bArr, zziym + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(byte[] bArr, long j, byte b2) {
        zziyk.zze(bArr, zziym + j, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzbmd() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzeqi());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzbme() {
        Unsafe unsafe = zzicl;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (zzelj.zzbhb()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = Logger.getLogger(zzeqg.class.getName());
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzbmf() {
        Unsafe unsafe = zzicl;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzbmg() == null) {
                return false;
            }
            if (zzelj.zzbhb()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = Logger.getLogger(zzeqg.class.getName());
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzo(Class<?> cls) {
        if (zzelj.zzbhb()) {
            try {
                Class<?> cls2 = zziot;
                cls2.getMethod("peekLong", cls, Boolean.TYPE);
                cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
                cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
                cls2.getMethod("peekInt", cls, Boolean.TYPE);
                cls2.getMethod("pokeByte", cls, Byte.TYPE);
                cls2.getMethod("peekByte", cls);
                cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
                cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    private static Field zzbmg() {
        Field zzb2;
        if (!zzelj.zzbhb() || (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) == null) {
            Field zzb3 = zzb(Buffer.class, "address");
            if (zzb3 == null || zzb3.getType() != Long.TYPE) {
                return null;
            }
            return zzb3;
        }
        return zzb2;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, (-4) & j) >>> ((int) (((j ^ (-1)) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = ((((int) j) ^ (-1)) & 3) << 3;
        zzb(obj, j2, ((255 & b2) << i) | (zzk(obj, j2) & ((255 << i) ^ (-1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b2) << i) | (zzk(obj, j2) & ((255 << i) ^ (-1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : (byte) 0);
    }

    static {
        zzd zzdVar;
        zzd zzdVar2 = null;
        if (zzicl != null) {
            if (zzelj.zzbhb()) {
                if (zziyi) {
                    zzdVar2 = new zzc(zzicl);
                } else if (zziyj) {
                    zzdVar2 = new zza(zzicl);
                }
            } else {
                zzdVar2 = new zzb(zzicl);
            }
        }
        zziyk = zzdVar2;
        zziyl = zzbmf();
        zziqf = zzbme();
        zziym = zzm(byte[].class);
        zziyn = zzm(boolean[].class);
        zziyo = zzn(boolean[].class);
        zziyp = zzm(int[].class);
        zziyq = zzn(int[].class);
        zziyr = zzm(long[].class);
        zziys = zzn(long[].class);
        zziyt = zzm(float[].class);
        zziyu = zzn(float[].class);
        zziyv = zzm(double[].class);
        zziyw = zzn(double[].class);
        zziyx = zzm(Object[].class);
        zziyy = zzn(Object[].class);
        Field zzbmg = zzbmg();
        zziyz = (zzbmg == null || (zzdVar = zziyk) == null) ? -1L : zzdVar.zzize.objectFieldOffset(zzbmg);
        zziza = (int) (zziym & 7);
        zzizb = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }
}

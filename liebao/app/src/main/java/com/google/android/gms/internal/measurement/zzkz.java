package com.google.android.gms.internal.measurement;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* loaded from: classes.dex */
public final class zzkz {
    static final boolean zza;
    private static final Unsafe zzb = zzc();
    private static final Class<?> zzc = zzgm.zzb();
    private static final boolean zzd = zzd(Long.TYPE);
    private static final boolean zze = zzd(Integer.TYPE);
    private static final zzc zzf;
    private static final boolean zzg;
    private static final boolean zzh;
    private static final long zzi;
    private static final long zzj;
    private static final long zzk;
    private static final long zzl;
    private static final long zzm;
    private static final long zzn;
    private static final long zzo;
    private static final long zzp;
    private static final long zzq;
    private static final long zzr;
    private static final long zzs;
    private static final long zzt;
    private static final long zzu;
    private static final long zzv;
    private static final int zzw;

    private zzkz() {
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    /* loaded from: classes.dex */
    private static final class zza extends zzc {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final byte zza(Object obj, long j) {
            if (zzkz.zza) {
                return zzkz.zzk(obj, j);
            }
            return zzkz.zzl(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final void zza(Object obj, long j, byte b2) {
            if (zzkz.zza) {
                zzkz.zzc(obj, j, b2);
            } else {
                zzkz.zzd(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final boolean zzb(Object obj, long j) {
            if (zzkz.zza) {
                return zzkz.zzm(obj, j);
            }
            return zzkz.zzn(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final void zza(Object obj, long j, boolean z) {
            if (zzkz.zza) {
                zzkz.zzd(obj, j, z);
            } else {
                zzkz.zze(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    /* loaded from: classes.dex */
    private static final class zzb extends zzc {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final byte zza(Object obj, long j) {
            if (zzkz.zza) {
                return zzkz.zzk(obj, j);
            }
            return zzkz.zzl(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final void zza(Object obj, long j, byte b2) {
            if (zzkz.zza) {
                zzkz.zzc(obj, j, b2);
            } else {
                zzkz.zzd(obj, j, b2);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final boolean zzb(Object obj, long j) {
            if (zzkz.zza) {
                return zzkz.zzm(obj, j);
            }
            return zzkz.zzn(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final void zza(Object obj, long j, boolean z) {
            if (zzkz.zza) {
                zzkz.zzd(obj, j, z);
            } else {
                zzkz.zze(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final float zzc(Object obj, long j) {
            return Float.intBitsToFloat(zze(obj, j));
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final double zzd(Object obj, long j) {
            return Double.longBitsToDouble(zzf(obj, j));
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final void zza(Object obj, long j, double d2) {
            zza(obj, j, Double.doubleToLongBits(d2));
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    /* loaded from: classes.dex */
    private static final class zzd extends zzc {
        zzd(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final byte zza(Object obj, long j) {
            return this.zza.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final void zza(Object obj, long j, byte b2) {
            this.zza.putByte(obj, j, b2);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final boolean zzb(Object obj, long j) {
            return this.zza.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final void zza(Object obj, long j, boolean z) {
            this.zza.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final float zzc(Object obj, long j) {
            return this.zza.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final void zza(Object obj, long j, float f) {
            this.zza.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final double zzd(Object obj, long j) {
            return this.zza.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.measurement.zzkz.zzc
        public final void zza(Object obj, long j, double d2) {
            this.zza.putDouble(obj, j, d2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza() {
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    /* loaded from: classes.dex */
    public static abstract class zzc {
        Unsafe zza;

        zzc(Unsafe unsafe) {
            this.zza = unsafe;
        }

        public abstract byte zza(Object obj, long j);

        public abstract void zza(Object obj, long j, byte b2);

        public abstract void zza(Object obj, long j, double d2);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract boolean zzb(Object obj, long j);

        public abstract float zzc(Object obj, long j);

        public abstract double zzd(Object obj, long j);

        public final int zze(Object obj, long j) {
            return this.zza.getInt(obj, j);
        }

        public final void zza(Object obj, long j, int i) {
            this.zza.putInt(obj, j, i);
        }

        public final long zzf(Object obj, long j) {
            return this.zza.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zza.putLong(obj, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb() {
        return zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T zza(Class<T> cls) {
        try {
            return (T) zzb.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int zzb(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzc(Class<?> cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(Object obj, long j) {
        return zzf.zze(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, int i) {
        zzf.zza(obj, j, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzb(Object obj, long j) {
        return zzf.zzf(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, long j2) {
        zzf.zza(obj, j, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzc(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, boolean z) {
        zzf.zza(obj, j, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zzd(Object obj, long j) {
        return zzf.zzc(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, float f) {
        zzf.zza(obj, j, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zze(Object obj, long j) {
        return zzf.zzd(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, double d2) {
        zzf.zza(obj, j, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzf(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte zza(byte[] bArr, long j) {
        return zzf.zza(bArr, zzi + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(byte[] bArr, long j, byte b2) {
        zzf.zza((Object) bArr, zzi + j, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe zzc() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzky());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzd() {
        Unsafe unsafe = zzb;
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
            if (zzgm.zza()) {
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
            Logger logger = Logger.getLogger(zzkz.class.getName());
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zze() {
        Unsafe unsafe = zzb;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (zzf() == null) {
                return false;
            }
            if (zzgm.zza()) {
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
            Logger logger = Logger.getLogger(zzkz.class.getName());
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzd(Class<?> cls) {
        if (zzgm.zza()) {
            try {
                Class<?> cls2 = zzc;
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

    private static Field zzf() {
        Field zza2;
        if (!zzgm.zza() || (zza2 = zza(Buffer.class, "effectiveDirectAddress")) == null) {
            Field zza3 = zza(Buffer.class, "address");
            if (zza3 == null || zza3.getType() != Long.TYPE) {
                return null;
            }
            return zza3;
        }
        return zza2;
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzk(Object obj, long j) {
        return (byte) (zza(obj, (-4) & j) >>> ((int) (((j ^ (-1)) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzl(Object obj, long j) {
        return (byte) (zza(obj, (-4) & j) >>> ((int) ((j & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = ((((int) j) ^ (-1)) & 3) << 3;
        zza(obj, j2, ((255 & b2) << i) | (zza(obj, j2) & ((255 << i) ^ (-1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(Object obj, long j, byte b2) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b2) << i) | (zza(obj, j2) & ((255 << i) ^ (-1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzm(Object obj, long j) {
        return zzk(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzn(Object obj, long j) {
        return zzl(obj, j) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzd(Object obj, long j, boolean z) {
        zzc(obj, j, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zze(Object obj, long j, boolean z) {
        zzd(obj, j, z ? (byte) 1 : (byte) 0);
    }

    static {
        zzc zzcVar;
        zzc zzcVar2 = null;
        if (zzb != null) {
            if (zzgm.zza()) {
                if (zzd) {
                    zzcVar2 = new zza(zzb);
                } else if (zze) {
                    zzcVar2 = new zzb(zzb);
                }
            } else {
                zzcVar2 = new zzd(zzb);
            }
        }
        zzf = zzcVar2;
        zzg = zze();
        zzh = zzd();
        zzi = zzb(byte[].class);
        zzj = zzb(boolean[].class);
        zzk = zzc(boolean[].class);
        zzl = zzb(int[].class);
        zzm = zzc(int[].class);
        zzn = zzb(long[].class);
        zzo = zzc(long[].class);
        zzp = zzb(float[].class);
        zzq = zzc(float[].class);
        zzr = zzb(double[].class);
        zzs = zzc(double[].class);
        zzt = zzb(Object[].class);
        zzu = zzc(Object[].class);
        Field zzf2 = zzf();
        zzv = (zzf2 == null || (zzcVar = zzf) == null) ? -1L : zzcVar.zza.objectFieldOffset(zzf2);
        zzw = (int) (zzi & 7);
        zza = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }
}

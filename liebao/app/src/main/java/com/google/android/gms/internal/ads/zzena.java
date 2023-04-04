package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzena;
import com.google.android.gms.internal.ads.zzena.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public abstract class zzena<MessageType extends zzena<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzelg<MessageType, BuilderType> {
    private static Map<Object, zzena<?, ?>> zzitp = new ConcurrentHashMap();
    protected zzeqd zzitn = zzeqd.zzbly();
    private int zzito = -1;

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    protected static class zza<T extends zzena<T, ?>> extends zzelh<T> {
        private final T zzitr;

        public zza(T t) {
            this.zzitr = t;
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    static final class zzc implements zzemv<zzc> {
        @Override // com.google.android.gms.internal.ads.zzemv
        public final int zzv() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzemv
        public final zzeqr zzbjc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzemv
        public final zzequ zzbjd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzemv
        public final boolean zzbje() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzemv
        public final boolean zzbjf() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzemv
        public final zzeom zza(zzeom zzeomVar, zzeon zzeonVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.ads.zzemv
        public final zzeos zza(zzeos zzeosVar, zzeos zzeosVar2) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public enum zze {
        public static final int zzitv = 1;
        public static final int zzitw = 2;
        public static final int zzitx = 3;
        public static final int zzity = 4;
        public static final int zzitz = 5;
        public static final int zziua = 6;
        public static final int zziub = 7;
        private static final /* synthetic */ int[] zziuc = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zzbjx() {
            return (int[]) zziuc.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static class zzf<ContainingType extends zzeon, Type> extends zzemo<ContainingType, Type> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzena<MessageType, BuilderType> implements zzeop {
        protected zzemt<zzc> zzitu = zzemt.zzbja();

        /* JADX INFO: Access modifiers changed from: package-private */
        public final zzemt<zzc> zzbjw() {
            if (this.zzitu.isImmutable()) {
                this.zzitu = (zzemt) this.zzitu.clone();
            }
            return this.zzitu;
        }
    }

    public String toString() {
        return zzeoo.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zziop != 0) {
            return this.zziop;
        }
        this.zziop = zzepb.zzble().zzax(this).hashCode(this);
        return this.zziop;
    }

    /* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
    /* loaded from: classes.dex */
    public static abstract class zzb<MessageType extends zzena<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzelf<MessageType, BuilderType> {
        private final MessageType zzitr;
        protected MessageType zzits;
        protected boolean zzitt = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zzb(MessageType messagetype) {
            this.zzitr = messagetype;
            this.zzits = (MessageType) messagetype.zza(zze.zzity, null, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void zzbjr() {
            MessageType messagetype = (MessageType) this.zzits.zza(zze.zzity, null, null);
            zza(messagetype, this.zzits);
            this.zzits = messagetype;
        }

        @Override // com.google.android.gms.internal.ads.zzeop
        public final boolean isInitialized() {
            return zzena.zza(this.zzits, false);
        }

        @Override // com.google.android.gms.internal.ads.zzeom
        /* renamed from: zzbjs */
        public MessageType zzbju() {
            if (this.zzitt) {
                return this.zzits;
            }
            MessageType messagetype = this.zzits;
            zzepb.zzble().zzax(messagetype).zzak(messagetype);
            this.zzitt = true;
            return this.zzits;
        }

        @Override // com.google.android.gms.internal.ads.zzeom
        /* renamed from: zzbjt */
        public final MessageType zzbjv() {
            MessageType messagetype = (MessageType) zzbju();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzeqb(messagetype);
        }

        @Override // com.google.android.gms.internal.ads.zzelf
        /* renamed from: zzb */
        public final BuilderType zza(MessageType messagetype) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            zza(this.zzits, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzepb.zzble().zzax(messagetype).zzg(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzemn zzemnVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            try {
                zzepb.zzble().zzax(this.zzits).zza(this.zzits, bArr, 0, i2, new zzell(zzemnVar));
                return this;
            } catch (zzenn e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e3);
            } catch (IndexOutOfBoundsException unused) {
                throw zzenn.zzbjz();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.ads.zzelf
        /* renamed from: zzb */
        public final BuilderType zza(zzemb zzembVar, zzemn zzemnVar) {
            if (this.zzitt) {
                zzbjr();
                this.zzitt = false;
            }
            try {
                zzepb.zzble().zzax(this.zzits).zza(this.zzits, zzemi.zza(zzembVar), zzemnVar);
                return this;
            } catch (RuntimeException e2) {
                if (e2.getCause() instanceof IOException) {
                    throw ((IOException) e2.getCause());
                }
                throw e2;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzelf
        public final /* synthetic */ zzelf zza(byte[] bArr, int i, int i2, zzemn zzemnVar) {
            return zzb(bArr, 0, i2, zzemnVar);
        }

        @Override // com.google.android.gms.internal.ads.zzelf
        public final /* synthetic */ zzelf zzbgx() {
            return (zzb) clone();
        }

        @Override // com.google.android.gms.internal.ads.zzeop
        public final /* synthetic */ zzeon zzbjp() {
            return this.zzitr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.ads.zzelf
        public /* synthetic */ Object clone() {
            zzb zzbVar = (zzb) this.zzitr.zza(zze.zzitz, null, null);
            zzbVar.zza((zzena) zzbju());
            return zzbVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzepb.zzble().zzax(this).equals(this, (zzena) obj);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzena<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbjh() {
        return (BuilderType) zza(zze.zzitz, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzeop
    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzbji() {
        BuilderType buildertype = (BuilderType) zza(zze.zzitz, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    final int zzbgz() {
        return this.zzito;
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    final void zzgd(int i) {
        this.zzito = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeon
    public final void zzb(zzemk zzemkVar) {
        zzepb.zzble().zzax(this).zza(this, zzemm.zza(zzemkVar));
    }

    @Override // com.google.android.gms.internal.ads.zzeon
    public final int zzbjj() {
        if (this.zzito == -1) {
            this.zzito = zzepb.zzble().zzax(this).zzau(this);
        }
        return this.zzito;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzena<?, ?>> T zzf(Class<T> cls) {
        zzena<?, ?> zzenaVar = zzitp.get(cls);
        if (zzenaVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzenaVar = zzitp.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (zzenaVar == null) {
            zzenaVar = (T) ((zzena) zzeqg.zzl(cls)).zza(zze.zziua, (Object) null, (Object) null);
            if (zzenaVar == null) {
                throw new IllegalStateException();
            }
            zzitp.put(cls, zzenaVar);
        }
        return (T) zzenaVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzena<?, ?>> void zza(Class<T> cls, T t) {
        zzitp.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zza(zzeon zzeonVar, String str, Object[] objArr) {
        return new zzepd(zzeonVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends zzena<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzitv, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzaw = zzepb.zzble().zzax(t).zzaw(t);
        if (z) {
            t.zza(zze.zzitw, zzaw ? t : null, null);
        }
        return zzaw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzeng zzbjk() {
        return zzend.zzbjy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzeng zza(zzeng zzengVar) {
        int size = zzengVar.size();
        return zzengVar.zzho(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzenl zzbjl() {
        return zzeob.zzbkq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzenk<E> zzbjm() {
        return zzepa.zzbld();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzenk<E> zza(zzenk<E> zzenkVar) {
        int size = zzenkVar.size();
        return zzenkVar.zzgg(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzena<T, ?>> T zza(T t, zzemb zzembVar, zzemn zzemnVar) {
        T t2 = (T) t.zza(zze.zzity, null, null);
        try {
            zzepi zzax = zzepb.zzble().zzax(t2);
            zzax.zza(t2, zzemi.zza(zzembVar), zzemnVar);
            zzax.zzak(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzenn) {
                throw ((zzenn) e2.getCause());
            }
            throw new zzenn(e2.getMessage()).zzl(t2);
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof zzenn) {
                throw ((zzenn) e3.getCause());
            }
            throw e3;
        }
    }

    private static <T extends zzena<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzemn zzemnVar) {
        T t2 = (T) t.zza(zze.zzity, null, null);
        try {
            zzepi zzax = zzepb.zzble().zzax(t2);
            zzax.zza(t2, bArr, 0, i2, new zzell(zzemnVar));
            zzax.zzak(t2);
            if (t2.zziop == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof zzenn) {
                throw ((zzenn) e2.getCause());
            }
            throw new zzenn(e2.getMessage()).zzl(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzenn.zzbjz().zzl(t2);
        }
    }

    private static <T extends zzena<T, ?>> T zza(T t) {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzenn(new zzeqb(t).getMessage()).zzl(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzena<T, ?>> T zza(T t, zzelq zzelqVar) {
        return (T) zza(zza(zzb(t, zzelqVar, zzemn.zzbiv())));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzena<T, ?>> T zza(T t, zzelq zzelqVar, zzemn zzemnVar) {
        return (T) zza(zzb(t, zzelqVar, zzemnVar));
    }

    private static <T extends zzena<T, ?>> T zzb(T t, zzelq zzelqVar, zzemn zzemnVar) {
        try {
            zzemb zzbhj = zzelqVar.zzbhj();
            T t2 = (T) zza(t, zzbhj, zzemnVar);
            try {
                zzbhj.zzgl(0);
                return t2;
            } catch (zzenn e2) {
                throw e2.zzl(t2);
            }
        } catch (zzenn e3) {
            throw e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzena<T, ?>> T zza(T t, byte[] bArr) {
        return (T) zza(zza(t, bArr, 0, bArr.length, zzemn.zzbiv()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzena<T, ?>> T zza(T t, byte[] bArr, zzemn zzemnVar) {
        return (T) zza(zza(t, bArr, 0, bArr.length, zzemnVar));
    }

    @Override // com.google.android.gms.internal.ads.zzeon
    public final /* synthetic */ zzeom zzbjn() {
        zzb zzbVar = (zzb) zza(zze.zzitz, (Object) null, (Object) null);
        zzbVar.zza(this);
        return zzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeon
    public final /* synthetic */ zzeom zzbjo() {
        return (zzb) zza(zze.zzitz, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzeop
    public final /* synthetic */ zzeon zzbjp() {
        return (zzena) zza(zze.zziua, (Object) null, (Object) null);
    }
}

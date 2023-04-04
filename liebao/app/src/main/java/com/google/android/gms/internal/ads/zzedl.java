package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
/* loaded from: classes.dex */
public final class zzedl {
    private static final Logger logger = Logger.getLogger(zzedl.class.getName());
    private static final ConcurrentMap<String, zzb> zzifd = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zza> zzife = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zziff = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzecm<?>> zzifg = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzedg<?, ?>> zzifh = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public interface zza {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    /* loaded from: classes.dex */
    public interface zzb {
        Set<Class<?>> zzbbl();

        zzect<?> zzbbv();

        Class<?> zzbbw();

        Class<?> zzbbx();

        <P> zzect<P> zzc(Class<P> cls);
    }

    private static <KeyProtoT extends zzeon> zzb zza(zzecu<KeyProtoT> zzecuVar) {
        return new zzedn(zzecuVar);
    }

    private static <KeyProtoT extends zzeon> zza zzb(zzecu<KeyProtoT> zzecuVar) {
        return new zzedo(zzecuVar);
    }

    private static synchronized zzb zzhr(String str) {
        zzb zzbVar;
        synchronized (zzedl.class) {
            if (!zzifd.containsKey(str)) {
                String valueOf = String.valueOf(str);
                throw new GeneralSecurityException(valueOf.length() != 0 ? "No key manager found for key type ".concat(valueOf) : new String("No key manager found for key type "));
            }
            zzbVar = zzifd.get(str);
        }
        return zzbVar;
    }

    @Deprecated
    public static zzecm<?> zzhs(String str) {
        if (str == null) {
            throw new IllegalArgumentException("catalogueName must be non-null.");
        }
        zzecm<?> zzecmVar = zzifg.get(str.toLowerCase(Locale.US));
        if (zzecmVar == null) {
            String format = String.format("no catalogue found for %s. ", str);
            if (str.toLowerCase(Locale.US).startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase(Locale.US).startsWith("tinkdeterministicaead")) {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkstreamingaead")) {
                format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkhybriddecrypt") || str.toLowerCase(Locale.US).startsWith("tinkhybridencrypt")) {
                format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkmac")) {
                format = String.valueOf(format).concat("Maybe call MacConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tinkpublickeysign") || str.toLowerCase(Locale.US).startsWith("tinkpublickeyverify")) {
                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
            } else if (str.toLowerCase(Locale.US).startsWith("tink")) {
                format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        return zzecmVar;
    }

    private static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    private static synchronized void zza(String str, Class<?> cls, boolean z) {
        synchronized (zzedl.class) {
            if (zzifd.containsKey(str)) {
                zzb zzbVar = zzifd.get(str);
                if (!zzbVar.zzbbw().equals(cls)) {
                    Logger logger2 = logger;
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(str);
                    logger2.logp(level, "com.google.crypto.tink.Registry", "ensureKeyManagerInsertable", valueOf.length() != 0 ? "Attempted overwrite of a registered key manager for key type ".concat(valueOf) : new String("Attempted overwrite of a registered key manager for key type "));
                    throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", str, zzbVar.zzbbw().getName(), cls.getName()));
                } else if (!z || zziff.get(str).booleanValue()) {
                } else {
                    String valueOf2 = String.valueOf(str);
                    throw new GeneralSecurityException(valueOf2.length() != 0 ? "New keys are already disallowed for key type ".concat(valueOf2) : new String("New keys are already disallowed for key type "));
                }
            }
        }
    }

    public static synchronized <P> void zza(zzect<P> zzectVar, boolean z) {
        synchronized (zzedl.class) {
            if (zzectVar == null) {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
            String keyType = zzectVar.getKeyType();
            zza(keyType, zzectVar.getClass(), z);
            zzifd.putIfAbsent(keyType, new zzedk(zzectVar));
            zziff.put(keyType, Boolean.valueOf(z));
        }
    }

    public static synchronized <KeyProtoT extends zzeon> void zza(zzecu<KeyProtoT> zzecuVar, boolean z) {
        synchronized (zzedl.class) {
            String keyType = zzecuVar.getKeyType();
            zza(keyType, zzecuVar.getClass(), true);
            if (!zzifd.containsKey(keyType)) {
                zzifd.put(keyType, zza(zzecuVar));
                zzife.put(keyType, zzb(zzecuVar));
            }
            zziff.put(keyType, true);
        }
    }

    public static synchronized <KeyProtoT extends zzeon, PublicKeyProtoT extends zzeon> void zza(zzedi<KeyProtoT, PublicKeyProtoT> zzediVar, zzecu<PublicKeyProtoT> zzecuVar, boolean z) {
        Class<?> zzbbx;
        synchronized (zzedl.class) {
            String keyType = zzediVar.getKeyType();
            String keyType2 = zzecuVar.getKeyType();
            zza(keyType, zzediVar.getClass(), true);
            zza(keyType2, zzecuVar.getClass(), false);
            if (keyType.equals(keyType2)) {
                throw new GeneralSecurityException("Private and public key type must be different.");
            }
            if (zzifd.containsKey(keyType) && (zzbbx = zzifd.get(keyType).zzbbx()) != null && !zzbbx.equals(zzecuVar.getClass())) {
                Logger logger2 = logger;
                Level level = Level.WARNING;
                StringBuilder sb = new StringBuilder(String.valueOf(keyType).length() + 96 + String.valueOf(keyType2).length());
                sb.append("Attempted overwrite of a registered key manager for key type ");
                sb.append(keyType);
                sb.append(" with inconsistent public key type ");
                sb.append(keyType2);
                logger2.logp(level, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", sb.toString());
                throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", zzediVar.getClass().getName(), zzbbx.getName(), zzecuVar.getClass().getName()));
            }
            if (!zzifd.containsKey(keyType) || zzifd.get(keyType).zzbbx() == null) {
                zzifd.put(keyType, new zzedm(zzediVar, zzecuVar));
                zzife.put(keyType, zzb(zzediVar));
            }
            zziff.put(keyType, true);
            if (!zzifd.containsKey(keyType2)) {
                zzifd.put(keyType2, zza(zzecuVar));
            }
            zziff.put(keyType2, false);
        }
    }

    public static synchronized <B, P> void zza(zzedg<B, P> zzedgVar) {
        synchronized (zzedl.class) {
            if (zzedgVar == null) {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
            Class<P> zzbbh = zzedgVar.zzbbh();
            if (zzifh.containsKey(zzbbh)) {
                zzedg<?, ?> zzedgVar2 = zzifh.get(zzbbh);
                if (!zzedgVar.getClass().equals(zzedgVar2.getClass())) {
                    Logger logger2 = logger;
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(zzbbh);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 56);
                    sb.append("Attempted overwrite of a registered SetWrapper for type ");
                    sb.append(valueOf);
                    logger2.logp(level, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", sb.toString());
                    throw new GeneralSecurityException(String.format("SetWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", zzbbh.getName(), zzedgVar2.getClass().getName(), zzedgVar.getClass().getName()));
                }
            }
            zzifh.put(zzbbh, zzedgVar);
        }
    }

    private static zzect<?> zzht(String str) {
        return zzhr(str).zzbbv();
    }

    private static <P> zzect<P> zza(String str, Class<P> cls) {
        zzb zzhr = zzhr(str);
        if (cls == null) {
            return (zzect<P>) zzhr.zzbbv();
        }
        if (zzhr.zzbbl().contains(cls)) {
            return zzhr.zzc(cls);
        }
        String name = cls.getName();
        String valueOf = String.valueOf(zzhr.zzbbw());
        Set<Class<?>> zzbbl = zzhr.zzbbl();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Class<?> cls2 : zzbbl) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(cls2.getCanonicalName());
            z = false;
        }
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder(String.valueOf(name).length() + 77 + String.valueOf(valueOf).length() + String.valueOf(sb2).length());
        sb3.append("Primitive type ");
        sb3.append(name);
        sb3.append(" not supported by key manager of type ");
        sb3.append(valueOf);
        sb3.append(", supported primitives: ");
        sb3.append(sb2);
        throw new GeneralSecurityException(sb3.toString());
    }

    public static synchronized zzeic zza(zzeif zzeifVar) {
        zzeic zzo;
        synchronized (zzedl.class) {
            zzect<?> zzht = zzht(zzeifVar.zzbev());
            if (zziff.get(zzeifVar.zzbev()).booleanValue()) {
                zzo = zzht.zzo(zzeifVar.zzbew());
            } else {
                String valueOf = String.valueOf(zzeifVar.zzbev());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzo;
    }

    public static synchronized zzeon zzb(zzeif zzeifVar) {
        zzeon zzn;
        synchronized (zzedl.class) {
            zzect<?> zzht = zzht(zzeifVar.zzbev());
            if (zziff.get(zzeifVar.zzbev()).booleanValue()) {
                zzn = zzht.zzn(zzeifVar.zzbew());
            } else {
                String valueOf = String.valueOf(zzeifVar.zzbev());
                throw new GeneralSecurityException(valueOf.length() != 0 ? "newKey-operation not permitted for key type ".concat(valueOf) : new String("newKey-operation not permitted for key type "));
            }
        }
        return zzn;
    }

    public static <P> P zza(String str, zzeon zzeonVar, Class<P> cls) {
        return (P) zza(str, (Class) checkNotNull(cls)).zza(zzeonVar);
    }

    private static <P> P zza(String str, zzelq zzelqVar, Class<P> cls) {
        return (P) zza(str, (Class) checkNotNull(cls)).zzm(zzelqVar);
    }

    public static <P> P zza(String str, byte[] bArr, Class<P> cls) {
        return (P) zza(str, zzelq.zzt(bArr), cls);
    }

    public static <P> P zza(zzeic zzeicVar, Class<P> cls) {
        return (P) zza(zzeicVar.zzbev(), zzeicVar.zzbew(), cls);
    }

    public static <B, P> P zza(zzedc<B> zzedcVar, Class<P> cls) {
        zzedg<?, ?> zzedgVar = zzifh.get(cls);
        if (zzedgVar == null) {
            String valueOf = String.valueOf(zzedcVar.zzbbh().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "No wrapper found for ".concat(valueOf) : new String("No wrapper found for "));
        } else if (!zzedgVar.zzbbu().equals(zzedcVar.zzbbh())) {
            String valueOf2 = String.valueOf(zzedgVar.zzbbu());
            String valueOf3 = String.valueOf(zzedcVar.zzbbh());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 44 + String.valueOf(valueOf3).length());
            sb.append("Wrong input primitive class, expected ");
            sb.append(valueOf2);
            sb.append(", got ");
            sb.append(valueOf3);
            throw new GeneralSecurityException(sb.toString());
        } else {
            return (P) zzedgVar.zza(zzedcVar);
        }
    }

    public static Class<?> zzd(Class<?> cls) {
        zzedg<?, ?> zzedgVar = zzifh.get(cls);
        if (zzedgVar == null) {
            return null;
        }
        return zzedgVar.zzbbu();
    }

    private zzedl() {
    }
}

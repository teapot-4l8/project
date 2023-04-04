package com.orhanobut.hawk;

/* loaded from: classes2.dex */
public class DefaultHawkFacade implements HawkFacade {
    private final Converter converter;
    private final Encryption encryption;
    private final LogInterceptor logInterceptor;
    private final Serializer serializer;
    private final Storage storage;

    @Override // com.orhanobut.hawk.HawkFacade
    public void destroy() {
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public boolean isBuilt() {
        return true;
    }

    public DefaultHawkFacade(HawkBuilder hawkBuilder) {
        this.encryption = hawkBuilder.getEncryption();
        this.storage = hawkBuilder.getStorage();
        this.converter = hawkBuilder.getConverter();
        this.serializer = hawkBuilder.getSerializer();
        LogInterceptor logInterceptor = hawkBuilder.getLogInterceptor();
        this.logInterceptor = logInterceptor;
        logInterceptor.onLog("Hawk.init -> Encryption : " + this.encryption.getClass().getSimpleName());
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public <T> boolean put(String str, T t) {
        HawkUtils.checkNull("Key", str);
        log("Hawk.put -> key: " + str + ", value: " + t);
        if (t == null) {
            log("Hawk.put -> Value is null. Any existing value will be deleted with the given key");
            return delete(str);
        }
        String converter = this.converter.toString(t);
        log("Hawk.put -> Converted to " + converter);
        if (converter == null) {
            log("Hawk.put -> Converter failed");
            return false;
        }
        String str2 = null;
        try {
            str2 = this.encryption.encrypt(str, converter);
            log("Hawk.put -> Encrypted to  " + str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (str2 == null) {
            log("Hawk.put -> Encryption failed");
            return false;
        }
        String serialize = this.serializer.serialize(str2, t);
        log("Hawk.put -> Serialized to" + serialize);
        if (serialize == null) {
            log("Hawk.put -> Serialization failed");
            return false;
        } else if (this.storage.put(str, serialize)) {
            log("Hawk.put -> Stored successfully");
            return true;
        } else {
            log("Hawk.put -> Store operation failed");
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.orhanobut.hawk.HawkFacade
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T get(String str) {
        String str2;
        log("Hawk.get -> key: " + str);
        T t = null;
        if (str == null) {
            log("Hawk.get -> null key, returning null value ");
            return null;
        }
        String str3 = (String) this.storage.get(str);
        log("Hawk.get -> Fetched from storage : " + str3);
        if (str3 == null) {
            log("Hawk.get -> Fetching from storage failed");
            return null;
        }
        DataInfo deserialize = this.serializer.deserialize(str3);
        log("Hawk.get -> Deserialized");
        if (deserialize == null) {
            log("Hawk.get -> Deserialization failed");
            return null;
        }
        try {
            str2 = this.encryption.decrypt(str, deserialize.cipherText);
            try {
                log("Hawk.get -> Decrypted to : " + str2);
            } catch (Exception e2) {
                e = e2;
                log("Hawk.get -> Decrypt failed: " + e.getMessage());
                if (str2 != null) {
                }
            }
        } catch (Exception e3) {
            e = e3;
            str2 = null;
        }
        if (str2 != null) {
            log("Hawk.get -> Decrypt failed");
            return null;
        }
        try {
            t = (T) this.converter.fromString(str2, deserialize);
            log("Hawk.get -> Converted to : " + t);
            return t;
        } catch (Exception unused) {
            log("Hawk.get -> Converter failed");
            return t;
        }
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public <T> T get(String str, T t) {
        T t2 = (T) get(str);
        return t2 == null ? t : t2;
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public long count() {
        return this.storage.count();
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public boolean deleteAll() {
        return this.storage.deleteAll();
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public boolean delete(String str) {
        return this.storage.delete(str);
    }

    @Override // com.orhanobut.hawk.HawkFacade
    public boolean contains(String str) {
        return this.storage.contains(str);
    }

    private void log(String str) {
        this.logInterceptor.onLog(str);
    }
}

package cn.jpush.android.cache;

/* loaded from: classes.dex */
public class Key<T> {

    /* renamed from: a  reason: collision with root package name */
    String f4301a;

    /* renamed from: b  reason: collision with root package name */
    String f4302b;

    /* renamed from: c  reason: collision with root package name */
    T f4303c;

    /* renamed from: d  reason: collision with root package name */
    boolean f4304d;

    private Key(String str, String str2, T t) {
        this.f4301a = str;
        this.f4302b = str2;
        if (t == null) {
            throw new IllegalArgumentException("default value can not be null");
        }
        this.f4303c = t;
    }

    public static Key<Integer> BadgeCurNum() {
        return new Key("cn.jpush.config", "badgeCurNum", 0).a();
    }

    public static Key<String> FCM_ClearFlag() {
        return new Key("cn.jpush.config", "fcm_clear_flag", "").a();
    }

    public static Key<String> NotiCancel() {
        return new Key("cn.jpush.config", "NotiCancel", "").a();
    }

    public static Key<String> NotiSchedule() {
        return new Key("cn.jpush.config", "NotiSchedule", "").a();
    }

    public static Key<Integer> PushVerCode() {
        return new Key("cn.jpush.config", "versionCode", 0).a();
    }

    public static Key<String> ThirdPush_ClearFlag() {
        return new Key("cn.jpush.config", "third_push_clear_flag", "").a();
    }

    public static Key<String> ThirdPush_RegID(byte b2) {
        return new Key("cn.jpush.config", "pluginPlatformRegid_v2" + ((int) b2), "").a();
    }

    public static Key<Boolean> ThirdPush_RegUpload(byte b2) {
        return new Key("cn.jpush.config", "pluginPlatformRegidupload" + ((int) b2), false).a();
    }

    private Key<T> a() {
        this.f4304d = true;
        return this;
    }

    public Key<T> file(String str) {
        this.f4301a = str;
        return this;
    }

    public Key<T> name(String str) {
        this.f4302b = str;
        return this;
    }

    public Key<T> set(T t) {
        this.f4303c = t;
        return this;
    }
}

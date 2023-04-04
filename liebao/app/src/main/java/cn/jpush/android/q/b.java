package cn.jpush.android.q;

import android.util.Log;
import dalvik.system.DexClassLoader;

/* loaded from: classes.dex */
public class b extends DexClassLoader {

    /* renamed from: a  reason: collision with root package name */
    private ClassLoader f4438a;

    public b(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, DexClassLoader.class.getClassLoader());
        this.f4438a = classLoader;
        Log.d("PushDexClassLoader", "init jpush cl...");
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) {
        try {
            return super.loadClass(str);
        } catch (ClassNotFoundException unused) {
            return this.f4438a.loadClass(str);
        }
    }
}

package cn.jpush.android.q;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import com.umeng.analytics.pro.ak;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f4435a;

    /* renamed from: b  reason: collision with root package name */
    private Resources f4436b;

    /* renamed from: c  reason: collision with root package name */
    private ClassLoader f4437c;

    private static PackageInfo a(Context context, String str) {
        return context.getPackageManager().getPackageArchiveInfo(str, 1);
    }

    public static a a(Context context) {
        try {
            Object dyInfo = JCoreHelper.getDyInfo(context, 2);
            Logger.d("LoadedResource", "load resouce:" + dyInfo);
            if (dyInfo != null && (dyInfo instanceof Map)) {
                Map map = (Map) dyInfo;
                String str = (String) map.get(ak.ax);
                Logger.d("LoadedResource", "jpush dex path:" + str);
                if (!TextUtils.isEmpty(str)) {
                    return a(context, str, (String) map.get("o"), (String) map.get("l"));
                }
            }
        } catch (Throwable th) {
            Logger.ww("LoadedResource", "l r failed:" + th.getMessage());
        }
        Logger.d("LoadedResource", "load resource failed");
        return null;
    }

    private static a a(Context context, String str, String str2, String str3) {
        PackageInfo a2 = a(context, str);
        if (a2 == null) {
            Logger.d("LoadedResource", "info is null");
            return null;
        }
        Logger.d("LoadedResource", "pkg name:" + a2.packageName);
        AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
        AssetManager.class.getMethod("addAssetPath", String.class).invoke(assetManager, str);
        Resources resources = new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
        a aVar = new a();
        aVar.a(resources);
        aVar.a(a2.packageName);
        aVar.a(new b(str, str2, str3, context.getClassLoader()));
        Logger.d("LoadedResource", "build resource:" + str);
        return aVar;
    }

    public int a(String str, String str2) {
        String str3 = this.f4435a + ".R$" + str;
        Logger.d("LoadedResource", "resource class:" + str3 + ",fieldName:" + str2);
        try {
            return ((Integer) this.f4437c.loadClass(str3).getField(str2).get(null)).intValue();
        } catch (Throwable th) {
            Logger.ww("LoadedResource", "[getResourceID] failed:" + th.getMessage());
            return 0;
        }
    }

    public void a(Resources resources) {
        this.f4436b = resources;
    }

    public void a(ClassLoader classLoader) {
        this.f4437c = classLoader;
    }

    public void a(String str) {
        this.f4435a = str;
    }

    public Class b(String str) {
        try {
            return this.f4437c.loadClass(str);
        } catch (ClassNotFoundException e2) {
            Logger.ww("LoadedResource", "[getClass] failed:" + e2.getMessage());
            return null;
        }
    }
}

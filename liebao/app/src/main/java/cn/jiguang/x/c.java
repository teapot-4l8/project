package cn.jiguang.x;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    private Context f4248a;

    public c(Context context) {
        this.f4248a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public String call() {
        String h;
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if ("huawei".equals(str.toLowerCase())) {
                h = a.h(this.f4248a);
                return h;
            }
            cn.jiguang.ad.a.d("IdHelper", "not supported this device:" + str);
            return "";
        } catch (Throwable th) {
            cn.jiguang.ad.a.e("IdHelper", "[LocalIdCall] failed:" + th.getMessage());
            return "";
        }
    }
}

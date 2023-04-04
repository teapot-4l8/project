package cn.jiguang.x;

import android.content.Context;
import com.bun.miitmdid.core.MdidSdkHelper;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes.dex */
public final class d implements Callable<String> {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<String> f4249a = new LinkedBlockingQueue<>(1);

    /* renamed from: b  reason: collision with root package name */
    private Context f4250b;

    public d(Context context) {
        this.f4250b = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public String call() {
        try {
            int InitSdk = MdidSdkHelper.InitSdk(this.f4250b, true, new e(this));
            cn.jiguang.ad.a.a("MittCall", "nres:" + InitSdk);
            return (InitSdk == 0 || InitSdk == 1008614) ? this.f4249a.take() : "";
        } catch (Throwable th) {
            cn.jiguang.ad.a.e("MittCall", "call ids failed:" + th.getMessage());
            return "";
        }
    }
}

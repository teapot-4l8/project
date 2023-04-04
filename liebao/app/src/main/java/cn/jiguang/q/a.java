package cn.jiguang.q;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.o.f;

/* loaded from: classes.dex */
public final class a implements ReportCallBack {

    /* renamed from: a  reason: collision with root package name */
    private Context f4198a;

    /* renamed from: b  reason: collision with root package name */
    private String f4199b;

    /* renamed from: c  reason: collision with root package name */
    private String f4200c;

    public a(Context context, String str, String str2) {
        this.f4198a = context;
        this.f4199b = str;
        this.f4200c = str2;
    }

    @Override // cn.jiguang.api.ReportCallBack
    public final void onFinish(int i) {
        cn.jiguang.ad.a.a("DeviceReport", "report finish code:" + i);
        if (i != 0) {
            return;
        }
        f.e(this.f4198a, this.f4200c);
        if (TextUtils.isEmpty(this.f4199b)) {
            return;
        }
        f.p(this.f4198a, this.f4199b);
    }
}

package cn.jiguang.l;

import android.content.Context;
import android.text.TextUtils;
import cn.jiguang.api.ReportCallBack;
import cn.jiguang.o.f;

/* loaded from: classes.dex */
public final class a implements ReportCallBack {

    /* renamed from: a  reason: collision with root package name */
    private String f4127a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f4128b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4129c;

    /* renamed from: d  reason: collision with root package name */
    private final String f4130d;

    public a(String str, Context context, String str2, String str3) {
        this.f4127a = str;
        this.f4128b = context;
        this.f4129c = str2;
        this.f4130d = str3;
    }

    @Override // cn.jiguang.api.ReportCallBack
    public final void onFinish(int i) {
        if (TextUtils.isEmpty(this.f4127a)) {
            this.f4127a = "";
        }
        Context context = this.f4128b;
        f.e(context, this.f4129c + this.f4127a);
        if (f.g(this.f4128b, this.f4129c) == 0) {
            f.l(this.f4128b, this.f4127a);
        }
        f.e(this.f4128b, this.f4130d);
    }
}

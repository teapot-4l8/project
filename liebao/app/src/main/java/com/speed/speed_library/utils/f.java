package com.speed.speed_library.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.ImagesContract;
import kotlin.d.b.i;

/* compiled from: IntentUtil.kt */
/* loaded from: classes2.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f5870a = new f();

    private f() {
    }

    public final void a(Context context, String str) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, ImagesContract.URL);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str));
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            com.speed.speed_library.b.f.a("出错了...", 0, 2, null);
        }
    }

    public final void a(Context context, String str, String str2) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, "title");
        i.b(str2, "shareContent");
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.TEXT", str2);
            context.startActivity(Intent.createChooser(intent, str));
        } catch (ActivityNotFoundException unused) {
        }
    }
}

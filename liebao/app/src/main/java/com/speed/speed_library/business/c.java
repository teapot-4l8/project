package com.speed.speed_library.business;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.speed.speed_library.R;
import com.speed.speed_library.b.f;
import com.speed.speed_library.b.h;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.ConfigModel;
import com.speed.speed_library.model.HideDialogEvent;
import com.speed.speed_library.model.OrderModel;
import com.speed.speed_library.model.ShareInfo;
import com.speed.speed_library.model.UserModel;
import com.speed.speed_library.utils.DeviceUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.d.b.i;
import kotlin.h.g;
import utils.AppLog;

/* compiled from: H5Interactive.kt */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final c f5627a = new c();

    public final void g(Context context, String str) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, "scheme");
    }

    private c() {
    }

    public final void a(Context context, String str) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, "scheme");
        String substring = str.substring(g.a((CharSequence) str, "-", 0, false, 6, (Object) null) + 1, str.length());
        i.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        try {
            Integer.parseInt(substring);
            d.a.a.a.a.c.f6985a.a().a(Integer.parseInt(substring), 0).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new a(context, context));
        } catch (Exception unused) {
            f.a("出错了，请稍后再试", 0, 2, null);
        }
    }

    /* compiled from: H5Interactive.kt */
    /* loaded from: classes2.dex */
    public static final class a extends com.speed.speed_library.a.c<BaseModel<OrderModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f5628a;

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Context context, Context context2) {
            super(context2);
            this.f5628a = context;
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<OrderModel> baseModel) {
            i.b(baseModel, "response");
            if (h.f5614a.a(baseModel, true)) {
                c.f5627a.a(this.f5628a, baseModel.getData());
            }
        }
    }

    public final void b(Context context, String str) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, "scheme");
        String substring = str.substring(g.a((CharSequence) str, "-", 0, false, 6, (Object) null) + 1, str.length());
        i.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        List b2 = g.b((CharSequence) substring, new String[]{","}, false, 0, 6, (Object) null);
        if (b2 != null) {
            try {
                if (b2.size() > 1) {
                    d.a.a.a.a.c.f6985a.a().a(Integer.parseInt((String) b2.get(0)), Integer.parseInt((String) b2.get(1))).b(b.b.h.a.d()).a(b.b.a.b.a.a()).a(new b(context, context));
                }
            } catch (Exception unused) {
                f.a("出错了，请稍后再试", 0, 2, null);
            }
        }
    }

    /* compiled from: H5Interactive.kt */
    /* loaded from: classes2.dex */
    public static final class b extends com.speed.speed_library.a.c<BaseModel<OrderModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f5629a;

        @Override // com.speed.speed_library.a.c
        public void b(Throwable th) {
            i.b(th, "e");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context, Context context2) {
            super(context2);
            this.f5629a = context;
        }

        @Override // com.speed.speed_library.a.c
        /* renamed from: a */
        public void b(BaseModel<OrderModel> baseModel) {
            i.b(baseModel, "response");
            if (h.f5614a.a(baseModel, true)) {
                c.f5627a.a(this.f5629a, baseModel.getData());
            }
        }
    }

    public final void a(Context context, OrderModel orderModel) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(orderModel, "orderModel");
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        StringBuilder sb = new StringBuilder();
        sb.append(com.speed.speed_library.b.b.f5592a.n());
        sb.append("/pay_style.html?price=");
        sb.append(orderModel.getReal_money());
        sb.append("&day=");
        sb.append(orderModel.getDay());
        sb.append("&order_id=");
        sb.append(orderModel.getOrder_id());
        sb.append("&remark=android&uid=");
        UserModel j = com.speed.speed_library.b.g.f5610b.j();
        sb.append(j != null ? Integer.valueOf(j.getUid()) : null);
        sb.append("&ts=");
        sb.append(currentTimeMillis);
        sb.append("&extend=android&pay_type=0");
        String sb2 = sb.toString();
        HashMap<String, String> a2 = a(sb2);
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, String> entry : a2.entrySet()) {
            Pair<String, String> create = Pair.create(entry.getKey(), entry.getValue());
            i.a((Object) create, "Pair.create(\n           …  value\n                )");
            arrayList.add(create);
        }
        String str = sb2 + "&sign=" + a(arrayList, String.valueOf(currentTimeMillis));
        AppLog.INSTANCE.i("payUrl---" + str);
        com.speed.speed_library.utils.f.f5870a.a(context, str);
    }

    private final HashMap<String, String> a(String str) {
        List a2;
        List a3;
        String[] strArr;
        List a4;
        List a5;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        HashMap<String, String> hashMap = new HashMap<>();
        List<String> a6 = new kotlin.h.f("\\?").a(str, 0);
        if (!a6.isEmpty()) {
            ListIterator<String> listIterator = a6.listIterator(a6.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() == 0) {
                    z4 = true;
                    continue;
                } else {
                    z4 = false;
                    continue;
                }
                if (!z4) {
                    a2 = kotlin.a.h.b(a6, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        a2 = kotlin.a.h.a();
        Object[] array = a2.toArray(new String[0]);
        if (array != null) {
            List<String> a7 = new kotlin.h.f("&").a(((String[]) array)[1], 0);
            if (!a7.isEmpty()) {
                ListIterator<String> listIterator2 = a7.listIterator(a7.size());
                while (listIterator2.hasPrevious()) {
                    if (listIterator2.previous().length() == 0) {
                        z3 = true;
                        continue;
                    } else {
                        z3 = false;
                        continue;
                    }
                    if (!z3) {
                        a3 = kotlin.a.h.b(a7, listIterator2.nextIndex() + 1);
                        break;
                    }
                }
            }
            a3 = kotlin.a.h.a();
            Object[] array2 = a3.toArray(new String[0]);
            if (array2 != null) {
                for (String str2 : (String[]) array2) {
                    if (g.a((CharSequence) str2, "=", 0, false, 6, (Object) null) > 0) {
                        List<String> a8 = new kotlin.h.f("=").a(str2, 0);
                        if (!a8.isEmpty()) {
                            ListIterator<String> listIterator3 = a8.listIterator(a8.size());
                            while (listIterator3.hasPrevious()) {
                                if (listIterator3.previous().length() == 0) {
                                    z2 = true;
                                    continue;
                                } else {
                                    z2 = false;
                                    continue;
                                }
                                if (!z2) {
                                    a4 = kotlin.a.h.b(a8, listIterator3.nextIndex() + 1);
                                    break;
                                }
                            }
                        }
                        a4 = kotlin.a.h.a();
                        Object[] array3 = a4.toArray(new String[0]);
                        if (array3 != null) {
                            String str3 = ((String[]) array3)[0];
                            List<String> a9 = new kotlin.h.f("=").a(str2, 0);
                            if (!a9.isEmpty()) {
                                ListIterator<String> listIterator4 = a9.listIterator(a9.size());
                                while (listIterator4.hasPrevious()) {
                                    if (listIterator4.previous().length() == 0) {
                                        z = true;
                                        continue;
                                    } else {
                                        z = false;
                                        continue;
                                    }
                                    if (!z) {
                                        a5 = kotlin.a.h.b(a9, listIterator4.nextIndex() + 1);
                                        break;
                                    }
                                }
                            }
                            a5 = kotlin.a.h.a();
                            Object[] array4 = a5.toArray(new String[0]);
                            if (array4 != null) {
                                hashMap.put(str3, ((String[]) array4)[1]);
                            } else {
                                throw new kotlin.i("null cannot be cast to non-null type kotlin.Array<T>");
                            }
                        } else {
                            throw new kotlin.i("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                }
                return hashMap;
            }
            throw new kotlin.i("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new kotlin.i("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: H5Interactive.kt */
    /* renamed from: com.speed.speed_library.business.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0139c<T> implements Comparator<Pair<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0139c f5630a = new C0139c();

        C0139c() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(Pair<String, String> pair, Pair<String, String> pair2) {
            Object obj = pair2.first;
            i.a(obj, "two.first");
            return ((String) pair.first).compareTo((String) obj);
        }
    }

    public final String a(List<Pair<String, String>> list, String str) {
        i.b(list, "requestParamList");
        i.b(str, "ts");
        StringBuilder sb = new StringBuilder();
        kotlin.a.h.a(list, C0139c.f5630a);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Pair<String, String> pair = list.get(i);
            String str2 = (String) pair.second;
            i.a((Object) str2, "pairValue");
            String a2 = g.a(str2, "*", "%2A", false, 4, (Object) null);
            sb.append((String) pair.first);
            sb.append("=");
            sb.append(a2);
        }
        AppLog.INSTANCE.i("stringBuilder::" + ((Object) sb));
        String str3 = sb.toString() + com.speed.speed_library.b.g.f5610b.a().getResources().getString(R.string.a_key_three) + com.speed.speed_library.b.g.f5610b.Z() + DeviceUtils.aaxx(com.speed.speed_library.b.g.f5610b.a());
        AppLog.INSTANCE.i("signBody::" + str3);
        String a3 = com.speed.speed_library.utils.d.f5865a.a(str3);
        if (a3 != null) {
            String lowerCase = a3.toLowerCase();
            i.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            return lowerCase;
        }
        throw new kotlin.i("null cannot be cast to non-null type java.lang.String");
    }

    public final void c(Context context, String str) {
        String sb;
        List<ShareInfo> share_info;
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, "scheme");
        d.a(d.f5631a, 0, 1, 0, 4, null);
        String substring = str.substring(g.a((CharSequence) str, "-", 0, false, 6, (Object) null) + 1, str.length());
        i.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        if (com.speed.speed_library.b.g.f5610b.t() != null) {
            ConfigModel t = com.speed.speed_library.b.g.f5610b.t();
            if ((t != null ? t.getShare_info() : null) != null) {
                ConfigModel t2 = com.speed.speed_library.b.g.f5610b.t();
                Integer valueOf = (t2 == null || (share_info = t2.getShare_info()) == null) ? null : Integer.valueOf(share_info.size());
                if (valueOf == null) {
                    i.a();
                }
                if (valueOf.intValue() > 0) {
                    ConfigModel t3 = com.speed.speed_library.b.g.f5610b.t();
                    if (t3 == null) {
                        i.a();
                    }
                    if (g.a((CharSequence) t3.getShare_info().get(0).getLink_url(), (CharSequence) "?", false, 2, (Object) null)) {
                        StringBuilder sb2 = new StringBuilder();
                        ConfigModel t4 = com.speed.speed_library.b.g.f5610b.t();
                        if (t4 == null) {
                            i.a();
                        }
                        sb2.append(t4.getShare_info().get(0).getLink_url());
                        sb2.append("&spread_num=");
                        sb2.append(substring);
                        sb = sb2.toString();
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        ConfigModel t5 = com.speed.speed_library.b.g.f5610b.t();
                        if (t5 == null) {
                            i.a();
                        }
                        sb3.append(t5.getShare_info().get(0).getLink_url());
                        sb3.append("?spread_num=");
                        sb3.append(substring);
                        sb = sb3.toString();
                    }
                    com.speed.speed_library.utils.f fVar = com.speed.speed_library.utils.f.f5870a;
                    StringBuilder sb4 = new StringBuilder();
                    ConfigModel t6 = com.speed.speed_library.b.g.f5610b.t();
                    if (t6 == null) {
                        i.a();
                    }
                    sb4.append(t6.getShare_info().get(0).getContent());
                    sb4.append(sb);
                    fVar.a(context, "分享有惊喜", sb4.toString());
                }
            }
        }
    }

    public final void d(Context context, String str) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, "scheme");
        String substring = str.substring(g.a((CharSequence) str, "-", 0, false, 6, (Object) null) + 1, str.length());
        i.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        com.speed.speed_library.utils.f.f5870a.a(context, substring);
    }

    public final void e(Context context, String str) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, "scheme");
        String substring = str.substring(g.a((CharSequence) str, "-", 0, false, 6, (Object) null) + 1, str.length());
        i.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        com.speed.speed_library.utils.f.f5870a.a(context, substring);
    }

    public final void f(Context context, String str) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, "scheme");
        String substring = str.substring(g.a((CharSequence) str, "-", 0, false, 6, (Object) null) + 1, str.length());
        i.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Object systemService = context.getSystemService("clipboard");
        if (systemService == null) {
            throw new kotlin.i("null cannot be cast to non-null type android.content.ClipboardManager");
        }
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Label", substring));
        f.a("复制成功", 0, 2, null);
    }

    public final void h(Context context, String str) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, "scheme");
        String substring = str.substring(g.a((CharSequence) str, "-", 0, false, 6, (Object) null) + 1, str.length());
        i.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        com.speed.speed_library.b.c.f5594a.a(context, com.speed.speed_library.b.b.f5592a.b(substring), "选择优惠券");
    }

    public final void i(Context context, String str) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, "scheme");
        d.f5631a.a(0, 0, 1);
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            f.a("出错了，请稍后再试", 0, 2, null);
        } else if (!g.a((CharSequence) str2, (CharSequence) "base64", false, 2, (Object) null)) {
            f.a("出错了，请稍后再试", 0, 2, null);
        } else {
            try {
                String substring = str.substring(g.a((CharSequence) str, ",", 0, false, 6, (Object) null) + 1, str.length());
                i.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                com.speed.speed_library.utils.b.a(context, com.speed.speed_library.utils.b.a(substring));
                f.a("保存成功", 0, 2, null);
            } catch (Exception unused) {
                f.a("出错了，请稍后再试", 0, 2, null);
            }
        }
    }

    public final void j(Context context, String str) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, "scheme");
        if (!e.f5632a.b()) {
            f.a("登录异常，请稍后再试", 0, 2, null);
            com.speed.speed_library.business.a.f5623a.f();
            return;
        }
        try {
            String substring = str.substring(g.a((CharSequence) str, "-", 0, false, 6, (Object) null) + 1, str.length());
            i.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            AppLog appLog = AppLog.INSTANCE;
            appLog.d("doSchemeWebviewNewActivity====" + substring);
            if (substring.equals("/recharge.html")) {
                org.greenrobot.eventbus.c.a().d(new HideDialogEvent());
            }
            com.speed.speed_library.b.c cVar = com.speed.speed_library.b.c.f5594a;
            cVar.a(context, com.speed.speed_library.b.b.f5592a.n() + substring, "");
        } catch (Exception unused) {
            f.a("出错了，请稍后再试", 0, 2, null);
        }
    }

    public final void k(Context context, String str) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, "scheme");
        if (!e.f5632a.b()) {
            f.a("登录异常，请稍后再试", 0, 2, null);
            com.speed.speed_library.business.a.f5623a.f();
            return;
        }
        com.speed.speed_library.b.c.f5594a.a(context, com.speed.speed_library.b.b.f5592a.d(), "优惠券");
    }

    public final void l(Context context, String str) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(str, "scheme");
        String str2 = str;
        if (g.a((CharSequence) str2, (CharSequence) "url://share", false, 2, (Object) null)) {
            c(context, str);
        } else if (g.a((CharSequence) str2, (CharSequence) "url://recommend", false, 2, (Object) null)) {
            d(context, str);
        } else if (g.a((CharSequence) str2, (CharSequence) "url://copy", false, 2, (Object) null)) {
            f(context, str);
        } else if (g.a((CharSequence) str2, (CharSequence) "url://buyb", false, 2, (Object) null)) {
            g(context, str);
        } else if (g.a((CharSequence) str2, (CharSequence) "url://buyc", false, 2, (Object) null)) {
            h(context, str);
        } else if (g.a((CharSequence) str2, (CharSequence) "url://buyd", false, 2, (Object) null)) {
            b(context, str);
        } else if (g.a((CharSequence) str2, (CharSequence) "url://buy", false, 2, (Object) null)) {
            a(context, str);
        } else if (g.a((CharSequence) str2, (CharSequence) "url://download", false, 2, (Object) null)) {
            i(context, str);
        } else if (g.a((CharSequence) str2, (CharSequence) "url://coupon", false, 2, (Object) null)) {
            k(context, str);
        } else if (g.a((CharSequence) str2, (CharSequence) "url://webview", false, 2, (Object) null)) {
            j(context, str);
        } else if (g.a((CharSequence) str2, (CharSequence) "url://browser", false, 2, (Object) null)) {
            e(context, str);
        }
    }
}

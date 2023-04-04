package cn.jpush.android.p;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.helper.Logger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class g {
    public static boolean a(ArrayList<String> arrayList, Context context, String str, String str2, boolean z) {
        String str3;
        StringBuilder sb;
        Logger.v("RichHelper", "action:loadHtmlImageResources - urlPrefix:" + str);
        boolean z2 = true;
        if (cn.jpush.android.u.a.a(str) && context != null && arrayList.size() > 0 && !TextUtils.isEmpty(str2)) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null || next.startsWith("http://")) {
                    str3 = next;
                } else {
                    str3 = str + next;
                }
                byte[] b2 = cn.jpush.android.o.a.b(str3, 5, 5000L);
                if (b2 != null) {
                    try {
                        if (next.startsWith("http://")) {
                            next = cn.jpush.android.u.c.b(next);
                        }
                        if (z) {
                            sb = new StringBuilder();
                            sb.append(cn.jpush.android.u.c.c(context, str2));
                            sb.append(next);
                        } else {
                            sb = new StringBuilder();
                            sb.append(cn.jpush.android.u.c.b(context, str2));
                            sb.append(next);
                        }
                        String sb2 = sb.toString();
                        cn.jpush.android.u.c.a(sb2, b2);
                        Logger.v("RichHelper", "Succeed to load image - " + sb2);
                    } catch (Exception e2) {
                        Logger.ww("RichHelper", "Write storage error,  create img file fail.", e2);
                    }
                } else {
                    cn.jpush.android.helper.c.a(str2, 1020, null, context);
                }
                z2 = false;
            }
        }
        return z2;
    }
}

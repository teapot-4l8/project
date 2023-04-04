package com.speed.speed_library.debug.netinfo.a;

import android.content.Context;
import com.speed.speed_library.R;
import com.speed.speed_library.debug.netinfo.ResultBean;

/* compiled from: ResultAdapter.java */
/* loaded from: classes2.dex */
public class c extends a<ResultBean> {
    public c(Context context, int i) {
        super(context, i);
    }

    @Override // com.speed.speed_library.debug.netinfo.a.a
    public void a(b bVar, ResultBean resultBean, int i) {
        bVar.a(R.id.item_activity_result_rv_tv, resultBean.getTitle());
        bVar.a(R.id.item_activity_result_rv_tv_param, a(resultBean.getParam().toString()));
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt != ',') {
                if (charAt != '[') {
                    if (charAt != ']') {
                        if (charAt != '{') {
                            if (charAt != '}') {
                                sb.append(charAt);
                            }
                        }
                    }
                    str2 = str2.replaceFirst("\t", "");
                    sb.append("\n" + str2 + charAt);
                }
                sb.append(str2 + charAt + "\n");
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append("\t");
                str2 = sb2.toString();
                sb.append(str2);
            } else {
                sb.append(charAt + "\n" + str2);
            }
        }
        return sb.toString();
    }
}

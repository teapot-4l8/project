package b.a.h.a;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

/* loaded from: classes.dex */
public class c {
    public static String a(d dVar) {
        if (dVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : dVar.a()) {
            if (!TextUtils.isEmpty((CharSequence) entry.getValue())) {
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append((String) entry.getValue());
                sb.append("&");
            }
        }
        String sb2 = sb.toString();
        return sb2.length() > 0 ? sb2.substring(0, sb2.length() - 1) : sb2;
    }

    public static String a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(readLine);
        }
    }
}

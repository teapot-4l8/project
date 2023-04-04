package a.a.a.e;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;

/* compiled from: Task.java */
/* loaded from: classes.dex */
public class r implements Callable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    Integer f393a;

    /* renamed from: b  reason: collision with root package name */
    String f394b;

    /* renamed from: c  reason: collision with root package name */
    int f395c;

    public r(Integer num, String str) {
        this.f393a = num;
        this.f394b = str;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a */
    public Integer call() {
        int i;
        int intValue = this.f393a.intValue();
        this.f395c = intValue;
        if (a(intValue, this.f394b)) {
            return Integer.valueOf(this.f395c);
        }
        do {
            this.f395c -= 28;
            f.b("当前size:" + this.f395c);
            if (a(this.f395c, this.f394b)) {
                return Integer.valueOf(this.f395c);
            }
            i = this.f395c;
        } while (i > 100);
        return Integer.valueOf(i);
    }

    private boolean a(int i, String str) {
        String a2 = a(b(i, str));
        return (TextUtils.isEmpty(a2) || !a2.toLowerCase().contains("icmp_seq") || a2.toLowerCase().contains("df")) ? false : true;
    }

    private String b(int i, String str) {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = str;
        return String.format("/system/bin/ping -c 1 -w 1 -s %d %s", objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARN: Type inference failed for: r7v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str) {
        Throwable th;
        Process process;
        try {
            try {
                process = Runtime.getRuntime().exec(str);
            } catch (IOException e2) {
                e = e2;
                process = null;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
                if (str != 0) {
                }
                throw th;
            }
            try {
                InputStream inputStream = process.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                    sb.append("\n");
                }
                bufferedReader.close();
                inputStream.close();
                String sb2 = sb.toString();
                if (process != null) {
                    process.destroy();
                }
                return sb2;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                if (process != null) {
                    process.destroy();
                }
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            if (str != 0) {
                str.destroy();
            }
            throw th;
        }
    }
}

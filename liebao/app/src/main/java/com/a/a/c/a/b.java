package com.a.a.c.a;

import com.a.a.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* compiled from: StackTraceUtil.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4554a;

    static {
        String name = d.class.getName();
        f4554a = name.substring(0, name.lastIndexOf(46) + 1);
    }

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static StackTraceElement[] a(StackTraceElement[] stackTraceElementArr, String str, int i) {
        return a(a(stackTraceElementArr, str), i);
    }

    private static StackTraceElement[] a(StackTraceElement[] stackTraceElementArr, String str) {
        int i;
        int length = stackTraceElementArr.length;
        for (int i2 = length - 1; i2 >= 0; i2--) {
            String className = stackTraceElementArr[i2].getClassName();
            if (className.startsWith(f4554a) || (str != null && className.startsWith(str))) {
                i = i2 + 1;
                break;
            }
        }
        i = 0;
        int i3 = length - i;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i3];
        System.arraycopy(stackTraceElementArr, i, stackTraceElementArr2, 0, i3);
        return stackTraceElementArr2;
    }

    private static StackTraceElement[] a(StackTraceElement[] stackTraceElementArr, int i) {
        int length = stackTraceElementArr.length;
        if (i > 0) {
            length = Math.min(i, length);
        }
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[length];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, length);
        return stackTraceElementArr2;
    }
}

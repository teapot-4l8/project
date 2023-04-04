package com.a.a.a.c;

import com.a.a.c.c;

/* compiled from: DefaultStackTraceFormatter.java */
/* loaded from: classes.dex */
public class a implements b {
    @Override // com.a.a.a.b
    public String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder(256);
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return null;
        }
        if (stackTraceElementArr.length == 1) {
            return "\t─ " + stackTraceElementArr[0].toString();
        }
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (i != length - 1) {
                sb.append("\t├ ");
                sb.append(stackTraceElementArr[i].toString());
                sb.append(c.f4556a);
            } else {
                sb.append("\t└ ");
                sb.append(stackTraceElementArr[i].toString());
            }
        }
        return sb.toString();
    }
}

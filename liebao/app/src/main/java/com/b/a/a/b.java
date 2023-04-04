package com.b.a.a;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Shell.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f4566a = {"echo -BOC-", "id"};

    public static a a(String str, String... strArr) {
        return a(str, strArr, null);
    }

    public static a a(String str, String[] strArr, String[] strArr2) {
        int i;
        List synchronizedList = Collections.synchronizedList(new ArrayList());
        List synchronizedList2 = Collections.synchronizedList(new ArrayList());
        try {
            try {
                Process b2 = b(str, strArr2);
                DataOutputStream dataOutputStream = new DataOutputStream(b2.getOutputStream());
                c cVar = new c(b2.getInputStream(), synchronizedList);
                c cVar2 = new c(b2.getErrorStream(), synchronizedList2);
                cVar.start();
                cVar2.start();
                try {
                    for (String str2 : strArr) {
                        dataOutputStream.write((str2 + "\n").getBytes("UTF-8"));
                        dataOutputStream.flush();
                    }
                    dataOutputStream.write("exit\n".getBytes("UTF-8"));
                    dataOutputStream.flush();
                } catch (IOException e2) {
                    if (!e2.getMessage().contains("EPIPE")) {
                        throw e2;
                    }
                }
                i = b2.waitFor();
                try {
                    dataOutputStream.close();
                } catch (IOException unused) {
                }
                cVar.join();
                cVar2.join();
                b2.destroy();
            } catch (InterruptedException unused2) {
                i = -1;
            }
        } catch (IOException unused3) {
            i = -4;
        }
        return new a(synchronizedList, synchronizedList2, i);
    }

    public static Process b(String str, String[] strArr) {
        if (strArr != null) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(System.getenv());
            int i = 0;
            for (String str2 : strArr) {
                int indexOf = str2.indexOf("=");
                if (indexOf >= 0) {
                    hashMap.put(str2.substring(0, indexOf), str2.substring(indexOf + 1));
                }
            }
            strArr = new String[hashMap.size()];
            for (Map.Entry entry : hashMap.entrySet()) {
                strArr[i] = ((String) entry.getKey()) + "=" + ((String) entry.getValue());
                i++;
            }
        }
        return Runtime.getRuntime().exec(str, strArr);
    }
}

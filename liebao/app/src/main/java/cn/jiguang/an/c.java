package cn.jiguang.an;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f3755a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ArrayList arrayList) {
        this.f3755a = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        ArrayList arrayList2;
        String str;
        ArrayList arrayList3;
        String str2;
        BufferedWriter bufferedWriter = null;
        try {
            try {
                StringBuilder sb = new StringBuilder();
                str = b.f3752c;
                sb.append(str);
                sb.append("-");
                sb.append(cn.jiguang.f.c.b());
                sb.append("_1.txt");
                String sb2 = sb.toString();
                File file = new File(sb2);
                file.getParentFile().mkdirs();
                int i = 2;
                while (true) {
                    if (!file.exists()) {
                        break;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    str2 = b.f3752c;
                    sb3.append(str2);
                    sb3.append("-");
                    sb3.append(cn.jiguang.f.c.b());
                    sb3.append("_");
                    sb3.append(i);
                    sb3.append(".txt");
                    sb2 = sb3.toString();
                    file = new File(sb2);
                    if (i > 10) {
                        d.f("Logger", "Unexpected error here, so many existed error file.");
                        break;
                    }
                    i++;
                }
                d.a("Logger", "Write log file: " + file.getName());
                if (!file.exists()) {
                    file.createNewFile();
                }
                BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(sb2));
                try {
                    Iterator it = this.f3755a.iterator();
                    while (it.hasNext()) {
                        bufferedWriter2.write(((String) it.next()) + "\n");
                    }
                    arrayList3 = b.f3754e;
                    arrayList3.clear();
                    bufferedWriter2.close();
                } catch (Throwable th) {
                    bufferedWriter = bufferedWriter2;
                    th = th;
                    try {
                        d.a("Logger", "write logs to file error", th);
                        arrayList2 = b.f3754e;
                        arrayList2.clear();
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                        b.c();
                    } catch (Throwable th2) {
                        try {
                            arrayList = b.f3754e;
                            arrayList.clear();
                            if (bufferedWriter != null) {
                                bufferedWriter.close();
                            }
                        } catch (Throwable th3) {
                            d.b("Logger", "close file stream error", th3);
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            d.b("Logger", "close file stream error", th5);
        }
        b.c();
    }
}

package com.umeng.analytics.process;

import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class DBFileTraversalUtil {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f6643a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    private static FileLockUtil f6644b = new FileLockUtil();

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    public static void traverseDBFiles(String str, final FileLockCallback fileLockCallback, final a aVar) {
        final File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            f6643a.execute(new Runnable() { // from class: com.umeng.analytics.process.DBFileTraversalUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles;
                    try {
                        for (File file2 : file.listFiles()) {
                            if (file2.getName().endsWith(com.umeng.analytics.process.a.f6662d)) {
                                DBFileTraversalUtil.f6644b.doFileOperateion(file2, fileLockCallback);
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> file: " + file2.getName());
                            }
                        }
                        if (aVar != null) {
                            aVar.a();
                        }
                    } catch (Throwable unused) {
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> end *** ");
                }
            });
        }
    }
}

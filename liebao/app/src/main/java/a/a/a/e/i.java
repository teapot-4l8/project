package a.a.a.e;

import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: MtuScan.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private String f373a;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f374b = false;

    public i(String str) {
        this.f373a = str;
    }

    public void a() {
        this.f374b = true;
    }

    public List<Integer> b() {
        int[] iArr = {ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED, 1492, 1472, 1468, 1430, 1400, 576};
        ArrayList arrayList = new ArrayList();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(7);
        try {
            try {
                ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(newFixedThreadPool);
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < 7; i++) {
                    arrayList2.add(executorCompletionService.submit(new r(Integer.valueOf(iArr[i]), this.f373a)));
                }
                for (int i2 = 0; i2 < 7; i2++) {
                    arrayList.add((Integer) executorCompletionService.take().get());
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return arrayList;
        } finally {
            newFixedThreadPool.shutdown();
        }
    }
}

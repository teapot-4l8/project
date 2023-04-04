package androidx.work;

import android.content.Context;

/* compiled from: WorkerFactory.java */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3087a = h.a("WorkerFactory");

    public abstract ListenableWorker a(Context context, String str, WorkerParameters workerParameters);

    public final ListenableWorker b(Context context, String str, WorkerParameters workerParameters) {
        ListenableWorker a2 = a(context, str, workerParameters);
        if (a2 != null) {
            return a2;
        }
        try {
            try {
                return (ListenableWorker) Class.forName(str).asSubclass(ListenableWorker.class).getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            } catch (Exception e2) {
                h a3 = h.a();
                String str2 = f3087a;
                a3.e(str2, "Could not instantiate " + str, e2);
                return null;
            }
        } catch (ClassNotFoundException unused) {
            h a4 = h.a();
            String str3 = f3087a;
            a4.e(str3, "Class not found: " + str, new Throwable[0]);
            return null;
        }
    }

    public static p a() {
        return new p() { // from class: androidx.work.p.1
            @Override // androidx.work.p
            public ListenableWorker a(Context context, String str, WorkerParameters workerParameters) {
                return null;
            }
        };
    }
}

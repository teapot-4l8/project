package androidx.work.impl;

import android.content.Context;
import androidx.work.WorkerParameters;
import androidx.work.impl.i;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* compiled from: Processor.java */
/* loaded from: classes.dex */
public class c implements androidx.work.impl.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f2955a = androidx.work.h.a("Processor");

    /* renamed from: b  reason: collision with root package name */
    private Context f2956b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.work.b f2957c;

    /* renamed from: d  reason: collision with root package name */
    private androidx.work.impl.utils.b.a f2958d;

    /* renamed from: e  reason: collision with root package name */
    private WorkDatabase f2959e;
    private List<d> g;
    private Map<String, i> f = new HashMap();
    private Set<String> h = new HashSet();
    private final List<androidx.work.impl.a> i = new ArrayList();
    private final Object j = new Object();

    public c(Context context, androidx.work.b bVar, androidx.work.impl.utils.b.a aVar, WorkDatabase workDatabase, List<d> list) {
        this.f2956b = context;
        this.f2957c = bVar;
        this.f2958d = aVar;
        this.f2959e = workDatabase;
        this.g = list;
    }

    public boolean a(String str) {
        return a(str, (WorkerParameters.a) null);
    }

    public boolean a(String str, WorkerParameters.a aVar) {
        synchronized (this.j) {
            if (this.f.containsKey(str)) {
                androidx.work.h.a().b(f2955a, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            i a2 = new i.a(this.f2956b, this.f2957c, this.f2958d, this.f2959e, str).a(this.g).a(aVar).a();
            ListenableFuture<Boolean> a3 = a2.a();
            a3.addListener(new a(this, str, a3), this.f2958d.a());
            this.f.put(str, a2);
            this.f2958d.b().execute(a2);
            androidx.work.h.a().b(f2955a, String.format("%s: processing %s", getClass().getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public boolean b(String str) {
        synchronized (this.j) {
            androidx.work.h.a().b(f2955a, String.format("Processor stopping %s", str), new Throwable[0]);
            i remove = this.f.remove(str);
            if (remove != null) {
                remove.a(false);
                androidx.work.h.a().b(f2955a, String.format("WorkerWrapper stopped for %s", str), new Throwable[0]);
                return true;
            }
            androidx.work.h.a().b(f2955a, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
            return false;
        }
    }

    public boolean c(String str) {
        synchronized (this.j) {
            androidx.work.h.a().b(f2955a, String.format("Processor cancelling %s", str), new Throwable[0]);
            this.h.add(str);
            i remove = this.f.remove(str);
            if (remove != null) {
                remove.a(true);
                androidx.work.h.a().b(f2955a, String.format("WorkerWrapper cancelled for %s", str), new Throwable[0]);
                return true;
            }
            androidx.work.h.a().b(f2955a, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
            return false;
        }
    }

    public boolean d(String str) {
        boolean contains;
        synchronized (this.j) {
            contains = this.h.contains(str);
        }
        return contains;
    }

    public boolean e(String str) {
        boolean containsKey;
        synchronized (this.j) {
            containsKey = this.f.containsKey(str);
        }
        return containsKey;
    }

    public void a(androidx.work.impl.a aVar) {
        synchronized (this.j) {
            this.i.add(aVar);
        }
    }

    public void b(androidx.work.impl.a aVar) {
        synchronized (this.j) {
            this.i.remove(aVar);
        }
    }

    @Override // androidx.work.impl.a
    public void a(String str, boolean z) {
        synchronized (this.j) {
            this.f.remove(str);
            androidx.work.h.a().b(f2955a, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z)), new Throwable[0]);
            for (androidx.work.impl.a aVar : this.i) {
                aVar.a(str, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Processor.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private androidx.work.impl.a f2960a;

        /* renamed from: b  reason: collision with root package name */
        private String f2961b;

        /* renamed from: c  reason: collision with root package name */
        private ListenableFuture<Boolean> f2962c;

        a(androidx.work.impl.a aVar, String str, ListenableFuture<Boolean> listenableFuture) {
            this.f2960a = aVar;
            this.f2961b = str;
            this.f2962c = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            try {
                z = this.f2962c.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.f2960a.a(this.f2961b, z);
        }
    }
}

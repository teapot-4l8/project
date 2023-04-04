package leavesc.hello.monitor.c;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import java.util.List;
import leavesc.hello.monitor.db.MonitorHttpInformationDatabase;
import leavesc.hello.monitor.db.a.b;
import leavesc.hello.monitor.holder.ContextHolder;

/* compiled from: MonitorViewModel.java */
/* loaded from: classes2.dex */
public class a extends x {

    /* renamed from: a  reason: collision with root package name */
    private LiveData<List<b>> f7232a = MonitorHttpInformationDatabase.a(ContextHolder.getContext()).m().a(300);

    /* renamed from: b  reason: collision with root package name */
    private LiveData<b> f7233b;

    public void b() {
        new Thread(new Runnable() { // from class: leavesc.hello.monitor.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                MonitorHttpInformationDatabase.a(ContextHolder.getContext()).m().a();
            }
        }).start();
    }

    public void c() {
        leavesc.hello.monitor.holder.a.a(ContextHolder.getContext()).b();
    }

    public void a(long j) {
        this.f7233b = MonitorHttpInformationDatabase.a(ContextHolder.getContext()).m().a(j);
    }

    public LiveData<List<b>> e() {
        return this.f7232a;
    }

    public LiveData<b> f() {
        return this.f7233b;
    }
}

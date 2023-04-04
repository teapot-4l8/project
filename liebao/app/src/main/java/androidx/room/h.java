package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.d;
import androidx.room.e;
import androidx.room.g;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MultiInstanceInvalidationClient.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    Context f2441a;

    /* renamed from: b  reason: collision with root package name */
    final String f2442b;

    /* renamed from: c  reason: collision with root package name */
    int f2443c;

    /* renamed from: d  reason: collision with root package name */
    final g f2444d;

    /* renamed from: e  reason: collision with root package name */
    final g.b f2445e;
    e f;
    final Executor g;
    final d h = new d.a() { // from class: androidx.room.h.1
        @Override // androidx.room.d
        public void a(final String[] strArr) {
            h.this.g.execute(new Runnable() { // from class: androidx.room.h.1.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.f2444d.a(strArr);
                }
            });
        }
    };
    final AtomicBoolean i = new AtomicBoolean(false);
    final ServiceConnection j = new ServiceConnection() { // from class: androidx.room.h.2
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            h.this.f = e.a.a(iBinder);
            h.this.g.execute(h.this.k);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h.this.g.execute(h.this.l);
            h.this.f = null;
            h.this.f2441a = null;
        }
    };
    final Runnable k = new Runnable() { // from class: androidx.room.h.3
        @Override // java.lang.Runnable
        public void run() {
            try {
                e eVar = h.this.f;
                if (eVar != null) {
                    h.this.f2443c = eVar.a(h.this.h, h.this.f2442b);
                    h.this.f2444d.a(h.this.f2445e);
                }
            } catch (RemoteException e2) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e2);
            }
        }
    };
    final Runnable l = new Runnable() { // from class: androidx.room.h.4
        @Override // java.lang.Runnable
        public void run() {
            h.this.f2444d.c(h.this.f2445e);
        }
    };
    private final Runnable m = new Runnable() { // from class: androidx.room.h.5
        @Override // java.lang.Runnable
        public void run() {
            h.this.f2444d.c(h.this.f2445e);
            try {
                e eVar = h.this.f;
                if (eVar != null) {
                    eVar.a(h.this.h, h.this.f2443c);
                }
            } catch (RemoteException e2) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e2);
            }
            if (h.this.f2441a != null) {
                h.this.f2441a.unbindService(h.this.j);
                h.this.f2441a = null;
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, String str, g gVar, Executor executor) {
        this.f2441a = context.getApplicationContext();
        this.f2442b = str;
        this.f2444d = gVar;
        this.g = executor;
        this.f2445e = new g.b(gVar.f2424b) { // from class: androidx.room.h.6
            @Override // androidx.room.g.b
            boolean a() {
                return true;
            }

            @Override // androidx.room.g.b
            public void a(Set<String> set) {
                if (h.this.i.get()) {
                    return;
                }
                try {
                    h.this.f.a(h.this.f2443c, (String[]) set.toArray(new String[0]));
                } catch (RemoteException e2) {
                    Log.w("ROOM", "Cannot broadcast invalidation", e2);
                }
            }
        };
        this.f2441a.bindService(new Intent(this.f2441a, MultiInstanceInvalidationService.class), this.j, 1);
    }
}

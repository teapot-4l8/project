package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.e;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {

    /* renamed from: a  reason: collision with root package name */
    int f2384a = 0;

    /* renamed from: b  reason: collision with root package name */
    final androidx.b.h<String> f2385b = new androidx.b.h<>();

    /* renamed from: c  reason: collision with root package name */
    final RemoteCallbackList<d> f2386c = new RemoteCallbackList<d>() { // from class: androidx.room.MultiInstanceInvalidationService.1
        @Override // android.os.RemoteCallbackList
        /* renamed from: a */
        public void onCallbackDied(d dVar, Object obj) {
            MultiInstanceInvalidationService.this.f2385b.b(((Integer) obj).intValue());
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final e.a f2387d = new e.a() { // from class: androidx.room.MultiInstanceInvalidationService.2
        @Override // androidx.room.e
        public int a(d dVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f2386c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.f2384a + 1;
                multiInstanceInvalidationService.f2384a = i;
                if (MultiInstanceInvalidationService.this.f2386c.register(dVar, Integer.valueOf(i))) {
                    MultiInstanceInvalidationService.this.f2385b.c(i, str);
                    return i;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f2384a--;
                return 0;
            }
        }

        @Override // androidx.room.e
        public void a(d dVar, int i) {
            synchronized (MultiInstanceInvalidationService.this.f2386c) {
                MultiInstanceInvalidationService.this.f2386c.unregister(dVar);
                MultiInstanceInvalidationService.this.f2385b.b(i);
            }
        }

        @Override // androidx.room.e
        public void a(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f2386c) {
                String a2 = MultiInstanceInvalidationService.this.f2385b.a(i);
                if (a2 == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.f2386c.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    int intValue = ((Integer) MultiInstanceInvalidationService.this.f2386c.getBroadcastCookie(i2)).intValue();
                    String a3 = MultiInstanceInvalidationService.this.f2385b.a(intValue);
                    if (i != intValue && a2.equals(a3)) {
                        try {
                            MultiInstanceInvalidationService.this.f2386c.getBroadcastItem(i2).a(strArr);
                        } catch (RemoteException e2) {
                            Log.w("ROOM", "Error invoking a remote callback", e2);
                        }
                    }
                }
                MultiInstanceInvalidationService.this.f2386c.finishBroadcast();
            }
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f2387d;
    }
}

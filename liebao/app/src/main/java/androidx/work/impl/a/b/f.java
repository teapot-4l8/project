package androidx.work.impl.a.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.h;

/* compiled from: StorageNotLowTracker.java */
/* loaded from: classes.dex */
public class f extends c<Boolean> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f2834d = h.a("StorageNotLowTracker");

    public f(Context context, androidx.work.impl.utils.b.a aVar) {
        super(context, aVar);
    }

    @Override // androidx.work.impl.a.b.d
    /* renamed from: a */
    public Boolean c() {
        Intent registerReceiver = this.f2825b.registerReceiver(null, b());
        if (registerReceiver != null && registerReceiver.getAction() != null) {
            String action = registerReceiver.getAction();
            char c2 = 65535;
            int hashCode = action.hashCode();
            if (hashCode != -1181163412) {
                if (hashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                    c2 = 0;
                }
            } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                c2 = 1;
            }
            if (c2 != 0) {
                return c2 != 1 ? null : false;
            }
        }
        return true;
    }

    @Override // androidx.work.impl.a.b.c
    public IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    @Override // androidx.work.impl.a.b.c
    public void a(Context context, Intent intent) {
        if (intent.getAction() == null) {
            return;
        }
        h.a().b(f2834d, String.format("Received %s", intent.getAction()), new Throwable[0]);
        String action = intent.getAction();
        char c2 = 65535;
        int hashCode = action.hashCode();
        if (hashCode != -1181163412) {
            if (hashCode == -730838620 && action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                c2 = 0;
            }
        } else if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            c2 = 1;
        }
        if (c2 == 0) {
            a((f) true);
        } else if (c2 != 1) {
        } else {
            a((f) false);
        }
    }
}

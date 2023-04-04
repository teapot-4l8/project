package androidx.core.app;

import android.app.Notification;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.i;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationCompatJellybean.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: b  reason: collision with root package name */
    private static Field f1460b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f1461c;

    /* renamed from: a  reason: collision with root package name */
    private static final Object f1459a = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static final Object f1462d = new Object();

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i = 0; i < size; i++) {
            Bundle bundle = list.get(i);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i, bundle);
            }
        }
        return sparseArray;
    }

    public static Bundle a(Notification notification) {
        synchronized (f1459a) {
            if (f1461c) {
                return null;
            }
            try {
                if (f1460b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f1461c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f1460b = declaredField;
                }
                Bundle bundle = (Bundle) f1460b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f1460b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Log.e("NotificationCompat", "Unable to access notification extras", e2);
                f1461c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Log.e("NotificationCompat", "Unable to access notification extras", e3);
                f1461c = true;
                return null;
            }
        }
    }

    public static Bundle a(Notification.Builder builder, i.a aVar) {
        IconCompat a2 = aVar.a();
        builder.addAction(a2 != null ? a2.b() : 0, aVar.b(), aVar.c());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", a(aVar.f()));
        }
        if (aVar.i() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", a(aVar.i()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle a(i.a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat a2 = aVar.a();
        bundle2.putInt("icon", a2 != null ? a2.b() : 0);
        bundle2.putCharSequence("title", aVar.b());
        bundle2.putParcelable("actionIntent", aVar.c());
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.e());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", a(aVar.f()));
        bundle2.putBoolean("showsUserInterface", aVar.j());
        bundle2.putInt("semanticAction", aVar.g());
        return bundle2;
    }

    private static Bundle a(m mVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", mVar.a());
        bundle.putCharSequence("label", mVar.b());
        bundle.putCharSequenceArray("choices", mVar.c());
        bundle.putBoolean("allowFreeFormInput", mVar.e());
        bundle.putBundle("extras", mVar.g());
        Set<String> d2 = mVar.d();
        if (d2 != null && !d2.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(d2.size());
            for (String str : d2) {
                arrayList.add(str);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] a(m[] mVarArr) {
        if (mVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[mVarArr.length];
        for (int i = 0; i < mVarArr.length; i++) {
            bundleArr[i] = a(mVarArr[i]);
        }
        return bundleArr;
    }
}

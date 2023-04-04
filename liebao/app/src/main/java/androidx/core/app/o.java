package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: TaskStackBuilder.java */
/* loaded from: classes.dex */
public final class o implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Intent> f1473a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final Context f1474b;

    /* compiled from: TaskStackBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        Intent f();
    }

    private o(Context context) {
        this.f1474b = context;
    }

    public static o a(Context context) {
        return new o(context);
    }

    public o a(Intent intent) {
        this.f1473a.add(intent);
        return this;
    }

    public o a(Activity activity) {
        Intent f = activity instanceof a ? ((a) activity).f() : null;
        if (f == null) {
            f = g.a(activity);
        }
        if (f != null) {
            ComponentName component = f.getComponent();
            if (component == null) {
                component = f.resolveActivity(this.f1474b.getPackageManager());
            }
            a(component);
            a(f);
        }
        return this;
    }

    public o a(ComponentName componentName) {
        int size = this.f1473a.size();
        try {
            Intent a2 = g.a(this.f1474b, componentName);
            while (a2 != null) {
                this.f1473a.add(size, a2);
                a2 = g.a(this.f1474b, a2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1473a.iterator();
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (this.f1473a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.f1473a;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.b.a(this.f1474b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f1474b.startActivity(intent);
    }
}

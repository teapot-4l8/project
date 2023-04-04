package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

/* compiled from: FragmentContainer.java */
/* loaded from: classes.dex */
public abstract class f {
    public abstract View a(int i);

    public abstract boolean a();

    @Deprecated
    public d a(Context context, String str, Bundle bundle) {
        return d.instantiate(context, str, bundle);
    }
}

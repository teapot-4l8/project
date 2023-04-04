package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.e;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* loaded from: classes.dex */
public class LifecycleActivity {
    private final Object zza;

    public LifecycleActivity(Activity activity) {
        this.zza = Preconditions.checkNotNull(activity, "Activity must not be null");
    }

    public boolean isChimera() {
        return false;
    }

    public LifecycleActivity(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    public boolean isSupport() {
        return this.zza instanceof e;
    }

    public final boolean zza() {
        return this.zza instanceof Activity;
    }

    public Activity asActivity() {
        return (Activity) this.zza;
    }

    public e asFragmentActivity() {
        return (e) this.zza;
    }

    public Object asObject() {
        return this.zza;
    }
}

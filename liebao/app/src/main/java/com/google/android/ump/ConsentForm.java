package com.google.android.ump;

import android.app.Activity;

/* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
/* loaded from: classes.dex */
public interface ConsentForm {

    /* compiled from: com.google.android.ump:user-messaging-platform@@1.0.0 */
    /* loaded from: classes.dex */
    public interface OnConsentFormDismissedListener {
        void onConsentFormDismissed(FormError formError);
    }

    void show(Activity activity, OnConsentFormDismissedListener onConsentFormDismissedListener);
}

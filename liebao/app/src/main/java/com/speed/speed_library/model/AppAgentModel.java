package com.speed.speed_library.model;

import android.graphics.drawable.Drawable;
import kotlin.d.b.i;

/* compiled from: AppAgentModel.kt */
/* loaded from: classes2.dex */
public final class AppAgentModel {
    private Drawable drawable;
    private String appName = "";
    private String packageName = "";

    /* renamed from: switch  reason: not valid java name */
    private boolean f0switch = true;

    public final String getAppName() {
        return this.appName;
    }

    public final void setAppName(String str) {
        i.b(str, "<set-?>");
        this.appName = str;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final void setPackageName(String str) {
        i.b(str, "<set-?>");
        this.packageName = str;
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public final void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public final boolean getSwitch() {
        return this.f0switch;
    }

    public final void setSwitch(boolean z) {
        this.f0switch = z;
    }
}

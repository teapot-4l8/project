package com.speed.speed_library.event;

import kotlin.d.b.i;

/* compiled from: LoginClickEvent.kt */
/* loaded from: classes2.dex */
public final class LoginClickEvent {
    private int pageType;
    private String phone;
    private int type;

    public LoginClickEvent(int i, int i2, String str) {
        i.b(str, "phone");
        this.pageType = i;
        this.type = i2;
        this.phone = str;
    }

    public final int getPageType() {
        return this.pageType;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final int getType() {
        return this.type;
    }

    public final void setPageType(int i) {
        this.pageType = i;
    }

    public final void setPhone(String str) {
        i.b(str, "<set-?>");
        this.phone = str;
    }

    public final void setType(int i) {
        this.type = i;
    }
}

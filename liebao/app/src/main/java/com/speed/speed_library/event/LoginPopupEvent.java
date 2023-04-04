package com.speed.speed_library.event;

import kotlin.d.b.i;

/* compiled from: LoginPopupEvent.kt */
/* loaded from: classes2.dex */
public final class LoginPopupEvent {
    private int pageType;
    private String phone;
    private String pwd;

    public LoginPopupEvent(int i, String str, String str2) {
        i.b(str, "phone");
        i.b(str2, "pwd");
        this.pageType = i;
        this.phone = str;
        this.pwd = str2;
    }

    public final int getPageType() {
        return this.pageType;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getPwd() {
        return this.pwd;
    }

    public final void setPageType(int i) {
        this.pageType = i;
    }

    public final void setPhone(String str) {
        i.b(str, "<set-?>");
        this.phone = str;
    }

    public final void setPwd(String str) {
        i.b(str, "<set-?>");
        this.pwd = str;
    }
}

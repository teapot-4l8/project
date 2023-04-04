package com.speed.speed_library.event;

import kotlin.d.b.i;

/* compiled from: RegisterPopupEvent.kt */
/* loaded from: classes2.dex */
public final class RegisterPopupEvent {
    private String captcha;
    private String inviteCode;
    private int pageType;
    private String phone;
    private String pwd;

    public RegisterPopupEvent(int i, String str, String str2, String str3, String str4) {
        i.b(str, "phone");
        i.b(str2, "pwd");
        i.b(str3, "captcha");
        i.b(str4, "inviteCode");
        this.pageType = i;
        this.phone = str;
        this.pwd = str2;
        this.captcha = str3;
        this.inviteCode = str4;
    }

    public final String getCaptcha() {
        return this.captcha;
    }

    public final String getInviteCode() {
        return this.inviteCode;
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

    public final void setCaptcha(String str) {
        i.b(str, "<set-?>");
        this.captcha = str;
    }

    public final void setInviteCode(String str) {
        i.b(str, "<set-?>");
        this.inviteCode = str;
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

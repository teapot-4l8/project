package com.speed.speed_library.event;

import kotlin.d.b.i;

/* compiled from: ForgetPopupEvent.kt */
/* loaded from: classes2.dex */
public final class ForgetPopupEvent {
    private String captcha;
    private int pageType;
    private String phone;
    private String pwd;

    public ForgetPopupEvent(int i, String str, String str2, String str3) {
        i.b(str, "phone");
        i.b(str2, "pwd");
        i.b(str3, "captcha");
        this.pageType = i;
        this.phone = str;
        this.pwd = str2;
        this.captcha = str3;
    }

    public final String getCaptcha() {
        return this.captcha;
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

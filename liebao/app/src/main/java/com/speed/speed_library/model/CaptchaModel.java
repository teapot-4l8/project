package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: CaptchaModel.kt */
/* loaded from: classes2.dex */
public final class CaptchaModel {
    private final String captcha;
    private final String phone;

    public static /* synthetic */ CaptchaModel copy$default(CaptchaModel captchaModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = captchaModel.phone;
        }
        if ((i & 2) != 0) {
            str2 = captchaModel.captcha;
        }
        return captchaModel.copy(str, str2);
    }

    public final String component1() {
        return this.phone;
    }

    public final String component2() {
        return this.captcha;
    }

    public final CaptchaModel copy(String str, String str2) {
        i.b(str, "phone");
        i.b(str2, "captcha");
        return new CaptchaModel(str, str2);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof CaptchaModel) {
                CaptchaModel captchaModel = (CaptchaModel) obj;
                return i.a((Object) this.phone, (Object) captchaModel.phone) && i.a((Object) this.captcha, (Object) captchaModel.captcha);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.phone;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.captcha;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "CaptchaModel(phone=" + this.phone + ", captcha=" + this.captcha + ")";
    }

    public CaptchaModel(String str, String str2) {
        i.b(str, "phone");
        i.b(str2, "captcha");
        this.phone = str;
        this.captcha = str2;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getCaptcha() {
        return this.captcha;
    }
}

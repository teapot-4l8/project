package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: BuryPointModel.kt */
/* loaded from: classes2.dex */
public final class DataModel {
    private int type;
    private int uid;
    private String phone = "";
    private String desc = "";

    public final int getUid() {
        return this.uid;
    }

    public final void setUid(int i) {
        this.uid = i;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final void setPhone(String str) {
        i.b(str, "<set-?>");
        this.phone = str;
    }

    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        i.b(str, "<set-?>");
        this.desc = str;
    }
}

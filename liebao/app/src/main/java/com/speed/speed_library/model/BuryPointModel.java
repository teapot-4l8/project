package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: BuryPointModel.kt */
/* loaded from: classes2.dex */
public final class BuryPointModel {
    private String cmd = "";
    private DataModel data;

    public final String getCmd() {
        return this.cmd;
    }

    public final void setCmd(String str) {
        i.b(str, "<set-?>");
        this.cmd = str;
    }

    public final DataModel getData() {
        return this.data;
    }

    public final void setData(DataModel dataModel) {
        this.data = dataModel;
    }
}

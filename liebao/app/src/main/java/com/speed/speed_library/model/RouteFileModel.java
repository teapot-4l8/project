package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: RouteFileModel.kt */
/* loaded from: classes2.dex */
public final class RouteFileModel {
    private int file_id;
    private String file_url = "";

    public final int getFile_id() {
        return this.file_id;
    }

    public final void setFile_id(int i) {
        this.file_id = i;
    }

    public final String getFile_url() {
        return this.file_url;
    }

    public final void setFile_url(String str) {
        i.b(str, "<set-?>");
        this.file_url = str;
    }
}

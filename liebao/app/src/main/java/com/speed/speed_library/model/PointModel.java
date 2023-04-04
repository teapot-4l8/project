package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: PointModel.kt */
/* loaded from: classes2.dex */
public final class PointModel {
    private Data data;
    private String date = "";
    private long last_time;
    private int point_type;
    private int uid;

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String str) {
        i.b(str, "<set-?>");
        this.date = str;
    }

    public final Data getData() {
        return this.data;
    }

    public final void setData(Data data) {
        this.data = data;
    }

    public final long getLast_time() {
        return this.last_time;
    }

    public final void setLast_time(long j) {
        this.last_time = j;
    }

    public final int getPoint_type() {
        return this.point_type;
    }

    public final void setPoint_type(int i) {
        this.point_type = i;
    }

    public final int getUid() {
        return this.uid;
    }

    public final void setUid(int i) {
        this.uid = i;
    }
}

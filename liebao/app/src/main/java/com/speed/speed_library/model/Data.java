package com.speed.speed_library.model;

import java.util.ArrayList;

/* compiled from: PointModel.kt */
/* loaded from: classes2.dex */
public final class Data {
    private int connect_fail;
    private int connect_success;
    private int connect_time;
    private int download_count;
    private int link_count;
    private ArrayList<CommonPoint> list;
    private int open_count;
    private int share_count;

    public final int getConnect_fail() {
        return this.connect_fail;
    }

    public final void setConnect_fail(int i) {
        this.connect_fail = i;
    }

    public final int getConnect_success() {
        return this.connect_success;
    }

    public final void setConnect_success(int i) {
        this.connect_success = i;
    }

    public final int getConnect_time() {
        return this.connect_time;
    }

    public final void setConnect_time(int i) {
        this.connect_time = i;
    }

    public final int getDownload_count() {
        return this.download_count;
    }

    public final void setDownload_count(int i) {
        this.download_count = i;
    }

    public final int getLink_count() {
        return this.link_count;
    }

    public final void setLink_count(int i) {
        this.link_count = i;
    }

    public final ArrayList<CommonPoint> getList() {
        return this.list;
    }

    public final void setList(ArrayList<CommonPoint> arrayList) {
        this.list = arrayList;
    }

    public final int getOpen_count() {
        return this.open_count;
    }

    public final void setOpen_count(int i) {
        this.open_count = i;
    }

    public final int getShare_count() {
        return this.share_count;
    }

    public final void setShare_count(int i) {
        this.share_count = i;
    }
}

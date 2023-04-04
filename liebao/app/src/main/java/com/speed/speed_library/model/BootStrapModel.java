package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: BootStrapModel.kt */
/* loaded from: classes2.dex */
public final class BootStrapModel {
    private int skip_time;
    private int skip_type;
    private String title = "";
    private int id = -1;
    private String link_url = "";
    private String img_url = "";

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        i.b(str, "<set-?>");
        this.title = str;
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final int getSkip_type() {
        return this.skip_type;
    }

    public final void setSkip_type(int i) {
        this.skip_type = i;
    }

    public final int getSkip_time() {
        return this.skip_time;
    }

    public final void setSkip_time(int i) {
        this.skip_time = i;
    }

    public final String getLink_url() {
        return this.link_url;
    }

    public final void setLink_url(String str) {
        i.b(str, "<set-?>");
        this.link_url = str;
    }

    public final String getImg_url() {
        return this.img_url;
    }

    public final void setImg_url(String str) {
        i.b(str, "<set-?>");
        this.img_url = str;
    }
}

package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: VersionCheckModel.kt */
/* loaded from: classes2.dex */
public final class VersionCheckModel {
    private int state;
    private final int vercode;
    private final String version_name = "";
    private final String log = "";
    private String app_url = "";

    public final int getVercode() {
        return this.vercode;
    }

    public final String getVersion_name() {
        return this.version_name;
    }

    public final String getLog() {
        return this.log;
    }

    public final int getState() {
        return this.state;
    }

    public final void setState(int i) {
        this.state = i;
    }

    public final String getApp_url() {
        return this.app_url;
    }

    public final void setApp_url(String str) {
        i.b(str, "<set-?>");
        this.app_url = str;
    }
}

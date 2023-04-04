package com.speed.speed_library.debug.netinfo;

import java.io.Serializable;

/* loaded from: classes2.dex */
public class ResultBean implements Serializable {
    private Object param;
    private String title;

    public ResultBean(String str, Object obj) {
        this.title = str;
        this.param = obj;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public Object getParam() {
        return this.param;
    }

    public void setParam(Object obj) {
        this.param = obj;
    }
}

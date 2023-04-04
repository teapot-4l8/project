package com.speed.speed_library.event;

import com.umeng.analytics.pro.d;
import kotlin.d.b.i;

/* compiled from: BuyTypeEvent.kt */
/* loaded from: classes2.dex */
public final class BuyTypeEvent {
    private String type;

    public BuyTypeEvent(String str) {
        i.b(str, d.y);
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        i.b(str, "<set-?>");
        this.type = str;
    }
}

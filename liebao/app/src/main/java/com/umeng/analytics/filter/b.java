package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* compiled from: EventWhiteList.java */
/* loaded from: classes2.dex */
public class b extends EventList {

    /* renamed from: a  reason: collision with root package name */
    private d f6329a;

    /* renamed from: b  reason: collision with root package name */
    private Object f6330b;

    public b(String str, String str2) {
        super(str, str2);
        this.f6330b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a2;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.f6330b) {
            if (this.f6329a == null) {
                this.f6329a = new d(true, this.mEventList);
            }
            a2 = this.f6329a.a(str);
        }
        return a2;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_WL = z;
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f6330b) {
            this.f6329a = null;
            this.f6329a = new d(true, this.mEventList);
        }
    }
}

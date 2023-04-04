package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* compiled from: EventBlackList.java */
/* loaded from: classes2.dex */
public class a extends EventList {

    /* renamed from: a  reason: collision with root package name */
    private d f6327a;

    /* renamed from: b  reason: collision with root package name */
    private Object f6328b;

    public a(String str, String str2) {
        super(str, str2);
        this.f6328b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a2;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.f6328b) {
            if (this.f6327a == null) {
                this.f6327a = new d(false, this.mEventList);
            }
            a2 = this.f6327a.a(str);
        }
        return a2;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_BL = z;
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f6328b) {
            this.f6327a = null;
            this.f6327a = new d(false, this.mEventList);
        }
    }
}

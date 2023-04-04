package com.youth.banner.util;

import androidx.lifecycle.h;
import androidx.lifecycle.k;
import androidx.lifecycle.l;
import androidx.lifecycle.t;

/* loaded from: classes.dex */
public class BannerLifecycleObserverAdapter implements k {
    private final l mLifecycleOwner;
    private final BannerLifecycleObserver mObserver;

    public BannerLifecycleObserverAdapter(l lVar, BannerLifecycleObserver bannerLifecycleObserver) {
        this.mLifecycleOwner = lVar;
        this.mObserver = bannerLifecycleObserver;
    }

    @t(a = h.a.ON_START)
    public void onStart() {
        LogUtils.i("onStart");
        this.mObserver.onStart(this.mLifecycleOwner);
    }

    @t(a = h.a.ON_STOP)
    public void onStop() {
        LogUtils.i("onStop");
        this.mObserver.onStop(this.mLifecycleOwner);
    }

    @t(a = h.a.ON_DESTROY)
    public void onDestroy() {
        LogUtils.i("onDestroy");
        this.mObserver.onDestroy(this.mLifecycleOwner);
    }
}

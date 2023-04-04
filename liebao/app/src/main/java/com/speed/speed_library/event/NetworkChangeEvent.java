package com.speed.speed_library.event;

/* compiled from: NetworkChangeEvent.kt */
/* loaded from: classes2.dex */
public final class NetworkChangeEvent {
    private boolean isConnected;

    public NetworkChangeEvent(boolean z) {
        this.isConnected = z;
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final void setConnected(boolean z) {
        this.isConnected = z;
    }
}

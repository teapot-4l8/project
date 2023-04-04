package wg;

import go.Seq;

/* loaded from: classes2.dex */
public abstract class Wg {
    private static native void _init();

    public static native String createTun(String str);

    public static native String getDomain(String str, String str2, boolean z);

    public static native String getPriAndPubKey();

    public static native String getPublic(String str);

    public static native String init(long j, String str);

    public static native String interfaceList();

    public static native void isSleep(long j);

    public static native String routeList();

    public static native String start(Callback callback);

    public static void touch() {
    }

    public static native String version();

    static {
        Seq.touch();
        _init();
    }

    private Wg() {
    }

    /* loaded from: classes2.dex */
    private static final class proxyCallback implements Seq.Proxy, Callback {
        private final int refnum;

        @Override // wg.Callback
        public native void callDownFlow(long j);

        @Override // wg.Callback
        public native void callFd(long j);

        @Override // wg.Callback
        public native void callStatus(long j);

        @Override // wg.Callback
        public native void callUpFlow(long j);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyCallback(int i) {
            this.refnum = i;
            Seq.trackGoRef(i, this);
        }
    }

    /* loaded from: classes2.dex */
    private static final class proxyVersion26 implements Seq.Proxy, Version26 {
        private final int refnum;

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        proxyVersion26(int i) {
            this.refnum = i;
            Seq.trackGoRef(i, this);
        }
    }
}

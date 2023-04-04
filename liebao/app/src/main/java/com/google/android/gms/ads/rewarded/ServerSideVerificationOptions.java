package com.google.android.gms.ads.rewarded;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
/* loaded from: classes.dex */
public class ServerSideVerificationOptions {
    private final String zzear;
    private final String zzeas;

    private ServerSideVerificationOptions(Builder builder) {
        this.zzear = builder.zzear;
        this.zzeas = builder.zzeas;
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.8.0 */
    /* loaded from: classes.dex */
    public static final class Builder {
        private String zzear = "";
        private String zzeas = "";

        public final Builder setUserId(String str) {
            this.zzear = str;
            return this;
        }

        public final Builder setCustomData(String str) {
            this.zzeas = str;
            return this;
        }

        public final ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }
    }

    public String getUserId() {
        return this.zzear;
    }

    public String getCustomData() {
        return this.zzeas;
    }
}

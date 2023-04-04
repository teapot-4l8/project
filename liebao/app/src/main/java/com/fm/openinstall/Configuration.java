package com.fm.openinstall;

/* loaded from: classes.dex */
public class Configuration {

    /* renamed from: a  reason: collision with root package name */
    private boolean f5329a;

    /* renamed from: b  reason: collision with root package name */
    private String f5330b;

    /* renamed from: c  reason: collision with root package name */
    private String f5331c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5332d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5333e;

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f5334a;

        /* renamed from: b  reason: collision with root package name */
        private String f5335b;

        /* renamed from: c  reason: collision with root package name */
        private String f5336c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f5337d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f5338e;

        public Builder adEnabled(boolean z) {
            this.f5334a = z;
            return this;
        }

        public Configuration build() {
            return new Configuration(this.f5334a, this.f5335b, this.f5336c, this.f5337d, this.f5338e);
        }

        public Builder gaid(String str) {
            this.f5336c = str;
            return this;
        }

        public Builder imeiDisabled() {
            this.f5338e = true;
            return this;
        }

        public Builder macDisabled() {
            this.f5337d = true;
            return this;
        }

        public Builder oaid(String str) {
            this.f5335b = str;
            return this;
        }
    }

    private Configuration() {
    }

    private Configuration(boolean z, String str, String str2, boolean z2, boolean z3) {
        this.f5329a = z;
        this.f5330b = str;
        this.f5331c = str2;
        this.f5332d = z2;
        this.f5333e = z3;
    }

    public static Configuration getDefault() {
        return new Configuration();
    }

    public String getGaid() {
        return this.f5331c;
    }

    public String getOaid() {
        return this.f5330b;
    }

    public boolean isAdEnabled() {
        return this.f5329a;
    }

    public boolean isImeiDisabled() {
        return this.f5333e;
    }

    public boolean isMacDisabled() {
        return this.f5332d;
    }
}

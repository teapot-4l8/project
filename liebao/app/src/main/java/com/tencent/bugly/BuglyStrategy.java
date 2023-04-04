package com.tencent.bugly;

import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BuglyStrategy {

    /* renamed from: c  reason: collision with root package name */
    private String f5958c;

    /* renamed from: d  reason: collision with root package name */
    private String f5959d;

    /* renamed from: e  reason: collision with root package name */
    private String f5960e;
    private long f;
    private String g;
    private String h;

    /* renamed from: q  reason: collision with root package name */
    private a f5961q;
    private boolean i = true;
    private boolean j = true;
    private boolean k = true;
    private Class<?> l = null;
    private boolean m = true;
    private boolean n = true;
    private boolean o = true;
    private boolean p = false;

    /* renamed from: a  reason: collision with root package name */
    protected int f5956a = 31;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f5957b = false;

    public synchronized BuglyStrategy setBuglyLogUpload(boolean z) {
        this.m = z;
        return this;
    }

    public synchronized BuglyStrategy setRecordUserInfoOnceADay(boolean z) {
        this.p = z;
        return this;
    }

    public synchronized BuglyStrategy setUploadProcess(boolean z) {
        this.o = z;
        return this;
    }

    public synchronized boolean isUploadProcess() {
        return this.o;
    }

    public synchronized boolean isBuglyLogUpload() {
        return this.m;
    }

    public synchronized boolean recordUserInfoOnceADay() {
        return this.p;
    }

    public boolean isReplaceOldChannel() {
        return this.n;
    }

    public void setReplaceOldChannel(boolean z) {
        this.n = z;
    }

    public synchronized String getAppVersion() {
        if (this.f5958c == null) {
            return com.tencent.bugly.crashreport.common.info.a.b().k;
        }
        return this.f5958c;
    }

    public synchronized BuglyStrategy setAppVersion(String str) {
        this.f5958c = str;
        return this;
    }

    public synchronized BuglyStrategy setUserInfoActivity(Class<?> cls) {
        this.l = cls;
        return this;
    }

    public synchronized Class<?> getUserInfoActivity() {
        return this.l;
    }

    public synchronized String getAppChannel() {
        if (this.f5959d == null) {
            return com.tencent.bugly.crashreport.common.info.a.b().m;
        }
        return this.f5959d;
    }

    public synchronized BuglyStrategy setAppChannel(String str) {
        this.f5959d = str;
        return this;
    }

    public synchronized String getAppPackageName() {
        if (this.f5960e == null) {
            return com.tencent.bugly.crashreport.common.info.a.b().f6007c;
        }
        return this.f5960e;
    }

    public synchronized BuglyStrategy setAppPackageName(String str) {
        this.f5960e = str;
        return this;
    }

    public synchronized long getAppReportDelay() {
        return this.f;
    }

    public synchronized BuglyStrategy setAppReportDelay(long j) {
        this.f = j;
        return this;
    }

    public synchronized String getLibBuglySOFilePath() {
        return this.g;
    }

    public synchronized BuglyStrategy setLibBuglySOFilePath(String str) {
        this.g = str;
        return this;
    }

    public synchronized String getDeviceID() {
        return this.h;
    }

    public synchronized BuglyStrategy setDeviceID(String str) {
        this.h = str;
        return this;
    }

    public synchronized boolean isEnableNativeCrashMonitor() {
        return this.i;
    }

    public synchronized BuglyStrategy setEnableNativeCrashMonitor(boolean z) {
        this.i = z;
        return this;
    }

    public synchronized BuglyStrategy setEnableUserInfo(boolean z) {
        this.k = z;
        return this;
    }

    public synchronized boolean isEnableUserInfo() {
        return this.k;
    }

    public synchronized boolean isEnableANRCrashMonitor() {
        return this.j;
    }

    public synchronized BuglyStrategy setEnableANRCrashMonitor(boolean z) {
        this.j = z;
        return this;
    }

    public synchronized a getCrashHandleCallback() {
        return this.f5961q;
    }

    public synchronized BuglyStrategy setCrashHandleCallback(a aVar) {
        this.f5961q = aVar;
        return this;
    }

    public synchronized void setCallBackType(int i) {
        this.f5956a = i;
    }

    public synchronized int getCallBackType() {
        return this.f5956a;
    }

    public synchronized void setCloseErrorCallback(boolean z) {
        this.f5957b = z;
    }

    public synchronized boolean getCloseErrorCallback() {
        return this.f5957b;
    }

    /* compiled from: BUGLY */
    /* loaded from: classes2.dex */
    public static class a {
        public static final int CRASHTYPE_ANR = 4;
        public static final int CRASHTYPE_BLOCK = 7;
        public static final int CRASHTYPE_COCOS2DX_JS = 5;
        public static final int CRASHTYPE_COCOS2DX_LUA = 6;
        public static final int CRASHTYPE_JAVA_CATCH = 1;
        public static final int CRASHTYPE_JAVA_CRASH = 0;
        public static final int CRASHTYPE_NATIVE = 2;
        public static final int CRASHTYPE_U3D = 3;
        public static final int MAX_USERDATA_KEY_LENGTH = 100;
        public static final int MAX_USERDATA_VALUE_LENGTH = 30000;

        public synchronized Map<String, String> onCrashHandleStart(int i, String str, String str2, String str3) {
            return null;
        }

        public synchronized byte[] onCrashHandleStart2GetExtraDatas(int i, String str, String str2, String str3) {
            return null;
        }
    }
}

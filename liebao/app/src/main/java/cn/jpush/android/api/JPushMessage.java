package cn.jpush.android.api;

import java.io.Serializable;
import java.util.Set;

/* loaded from: classes.dex */
public class JPushMessage implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    private String f4261a;

    /* renamed from: b  reason: collision with root package name */
    private Set<String> f4262b;

    /* renamed from: c  reason: collision with root package name */
    private String f4263c;

    /* renamed from: d  reason: collision with root package name */
    private int f4264d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4265e;
    private boolean f;
    private int g;
    private String h;

    public String getAlias() {
        return this.f4261a;
    }

    public String getCheckTag() {
        return this.f4263c;
    }

    public int getErrorCode() {
        return this.f4264d;
    }

    public String getMobileNumber() {
        return this.h;
    }

    public int getSequence() {
        return this.g;
    }

    public boolean getTagCheckStateResult() {
        return this.f4265e;
    }

    public Set<String> getTags() {
        return this.f4262b;
    }

    public boolean isTagCheckOperator() {
        return this.f;
    }

    public void setAlias(String str) {
        this.f4261a = str;
    }

    public void setCheckTag(String str) {
        this.f4263c = str;
    }

    public void setErrorCode(int i) {
        this.f4264d = i;
    }

    public void setMobileNumber(String str) {
        this.h = str;
    }

    public void setSequence(int i) {
        this.g = i;
    }

    public void setTagCheckOperator(boolean z) {
        this.f = z;
    }

    public void setTagCheckStateResult(boolean z) {
        this.f4265e = z;
    }

    public void setTags(Set<String> set) {
        this.f4262b = set;
    }

    public String toString() {
        return "JPushMessage{alias='" + this.f4261a + "', tags=" + this.f4262b + ", checkTag='" + this.f4263c + "', errorCode=" + this.f4264d + ", tagCheckStateResult=" + this.f4265e + ", isTagCheckOperator=" + this.f + ", sequence=" + this.g + ", mobileNumber=" + this.h + '}';
    }
}

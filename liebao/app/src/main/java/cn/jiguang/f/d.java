package cn.jiguang.f;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
final class d extends ThreadLocal<SimpleDateFormat> {

    /* renamed from: a  reason: collision with root package name */
    private String f4071a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(String str) {
        this.f4071a = str;
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ SimpleDateFormat initialValue() {
        return new SimpleDateFormat(this.f4071a, Locale.ENGLISH);
    }
}

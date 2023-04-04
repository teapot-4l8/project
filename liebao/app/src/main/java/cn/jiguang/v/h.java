package cn.jiguang.v;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* loaded from: classes.dex */
final class h extends ThreadLocal<SimpleDateFormat> {

    /* renamed from: a  reason: collision with root package name */
    private String f4242a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        this.f4242a = str;
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ SimpleDateFormat initialValue() {
        return new SimpleDateFormat(this.f4242a, Locale.ENGLISH);
    }
}

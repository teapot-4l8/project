package cn.jiguang.f;

import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;

/* loaded from: classes.dex */
public final class f implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    public static final f f4072a = new f(true, false);

    /* renamed from: b  reason: collision with root package name */
    public static final f f4073b = new f(false, true);

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4074c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f4075d;

    /* renamed from: e  reason: collision with root package name */
    private final String f4076e;
    private final int f;

    private f(boolean z, boolean z2) {
        this.f4074c = z;
        this.f4075d = z2;
        this.f4076e = null;
        this.f = 0;
    }

    public f(boolean z, boolean z2, String str, int i) {
        this.f4076e = str;
        this.f = i;
        this.f4074c = false;
        this.f4075d = true;
    }

    public static f a(String str) {
        return new f(false, true, str, 3);
    }

    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        if (!this.f4074c || file.isFile()) {
            if (!this.f4075d || file.isDirectory()) {
                if (TextUtils.isEmpty(this.f4076e)) {
                    return true;
                }
                int i = this.f;
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                return false;
                            }
                            return file.getName().contains(this.f4076e);
                        }
                        return file.getName().equals(this.f4076e);
                    }
                    return file.getName().endsWith(this.f4076e);
                }
                return file.getName().startsWith(this.f4076e);
            }
            return false;
        }
        return false;
    }
}

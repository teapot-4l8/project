package cn.jiguang.u;

import com.umeng.analytics.pro.ak;
import java.io.File;
import java.io.FileFilter;

/* loaded from: classes.dex */
final class b implements FileFilter {
    @Override // java.io.FileFilter
    public final boolean accept(File file) {
        String name = file.getName();
        if (name.startsWith(ak.w)) {
            for (int i = 3; i < name.length(); i++) {
                if (name.charAt(i) < '0' || name.charAt(i) > '9') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

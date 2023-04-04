package androidx.core.content;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;

/* compiled from: ContentResolverCompat.java */
/* loaded from: classes.dex */
public final class a {
    public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, androidx.core.d.a aVar) {
        Object d2;
        if (Build.VERSION.SDK_INT >= 16) {
            if (aVar != null) {
                try {
                    d2 = aVar.d();
                } catch (Exception e2) {
                    if (e2 instanceof OperationCanceledException) {
                        throw new androidx.core.d.c();
                    }
                    throw e2;
                }
            } else {
                d2 = null;
            }
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) d2);
        }
        if (aVar != null) {
            aVar.b();
        }
        return contentResolver.query(uri, strArr, str, strArr2, str2);
    }
}

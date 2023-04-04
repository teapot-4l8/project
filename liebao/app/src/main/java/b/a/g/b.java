package b.a.g;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import com.umeng.analytics.pro.ao;

/* loaded from: classes.dex */
public class b extends a {

    /* renamed from: b  reason: collision with root package name */
    private b.a.k.e f3195b;

    public b(Context context) {
        super(context);
        this.f3195b = b.a.k.e.a("AudioMediaStorage");
    }

    private String c(String str) {
        return str + ".mp3";
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
        if (r11.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0076, code lost:
        if (r11.isClosed() == false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0078, code lost:
        r11.close();
     */
    @Override // b.a.g.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String b(String str) {
        Cursor cursor;
        Cursor cursor2 = null;
        try {
            cursor = this.f3191a.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, new String[]{ao.f6395d, "_display_name", "title"}, "_display_name=?", new String[]{c(str)}, null);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();
                        cursor.getInt(cursor.getColumnIndex(ao.f6395d));
                        String a2 = b.a.k.b.a(cursor.getString(cursor.getColumnIndex("title")), 0);
                        if (cursor != null && !cursor.isClosed()) {
                            cursor.close();
                        }
                        return a2;
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null && !cursor2.isClosed()) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
            }
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return null;
    }

    @Override // b.a.g.a
    public boolean b(String str, String str2) {
        if (a(str) == null) {
            ContentResolver contentResolver = this.f3191a.getContentResolver();
            Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            ContentValues contentValues = new ContentValues();
            contentValues.put("relative_path", "Notifications/Installation");
            contentValues.put("_display_name", c(str));
            contentValues.put("title", b.a.k.b.b(str2, 0));
            try {
                contentResolver.insert(uri, contentValues);
            } catch (Exception unused) {
            }
            return false;
        }
        return true;
    }
}

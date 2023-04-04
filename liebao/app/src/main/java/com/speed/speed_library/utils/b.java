package com.speed.speed_library.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;

/* compiled from: CommonUtils.java */
/* loaded from: classes2.dex */
public class b {
    public static Bitmap a(String str) {
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static void a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, (String) null, (String) null);
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file:///sdcard/namecard/")));
    }
}

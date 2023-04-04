package com.speed.speed_library.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import kotlin.d.b.i;

/* compiled from: BitmapUtil.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5858a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f5859b = f5859b;

    /* renamed from: b  reason: collision with root package name */
    private static final String f5859b = f5859b;

    private a() {
    }

    public final int a(String str) {
        i.b(str, "filePath");
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final Bitmap a(int i, Bitmap bitmap) {
        if (bitmap != null) {
            Matrix matrix = new Matrix();
            matrix.postRotate(i);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        }
        return bitmap;
    }

    public final String b(String str) {
        i.b(str, "filePath");
        String path = new File(str).getPath();
        Bitmap c2 = c(str);
        int a2 = a(str);
        if (a2 != 0) {
            c2 = a(a2, c2);
        }
        File file = new File(path);
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (c2 == null) {
                i.a();
            }
            c2.compress(Bitmap.CompressFormat.JPEG, 50, fileOutputStream);
            fileOutputStream.close();
            String path2 = file.getPath();
            i.a((Object) path2, "outputFile.getPath()");
            return path2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    public final Bitmap c(String str) {
        i.b(str, "filePath");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, 480, 800);
        options.inJustDecodeBounds = false;
        Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
        i.a((Object) decodeFile, "BitmapFactory.decodeFile(filePath, options)");
        return decodeFile;
    }

    public final int a(BitmapFactory.Options options, int i, int i2) {
        i.b(options, "options");
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 > i2 || i4 > i) {
            int round = Math.round(i3 / i2);
            int round2 = Math.round(i4 / i);
            return round < round2 ? round : round2;
        }
        return 1;
    }

    public final String a(Context context, Uri uri) {
        i.b(context, com.umeng.analytics.pro.d.R);
        i.b(uri, "uri");
        if (kotlin.h.g.a("content", uri.getScheme(), true)) {
            if (Build.VERSION.SDK_INT >= 19) {
                return b(context, uri);
            }
            return c(context, uri);
        } else if (kotlin.h.g.a("file", uri.getScheme(), true)) {
            return uri.getPath();
        } else {
            return null;
        }
    }

    private final String b(Context context, Uri uri) {
        List a2;
        String[] strArr;
        boolean z;
        List a3;
        List a4;
        boolean z2;
        boolean z3;
        String str = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            if (a(uri)) {
                i.a((Object) documentId, "documentId");
                String str2 = documentId;
                List<String> a5 = new kotlin.h.f(":").a(str2, 0);
                if (!a5.isEmpty()) {
                    ListIterator<String> listIterator = a5.listIterator(a5.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() == 0) {
                            z3 = true;
                            continue;
                        } else {
                            z3 = false;
                            continue;
                        }
                        if (!z3) {
                            a3 = kotlin.a.h.b(a5, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                a3 = kotlin.a.h.a();
                Object[] array = a3.toArray(new String[0]);
                if (array != null) {
                    String str3 = ((String[]) array)[0];
                    List<String> a6 = new kotlin.h.f(":").a(str2, 0);
                    if (!a6.isEmpty()) {
                        ListIterator<String> listIterator2 = a6.listIterator(a6.size());
                        while (listIterator2.hasPrevious()) {
                            if (listIterator2.previous().length() == 0) {
                                z2 = true;
                                continue;
                            } else {
                                z2 = false;
                                continue;
                            }
                            if (!z2) {
                                a4 = kotlin.a.h.b(a6, listIterator2.nextIndex() + 1);
                                break;
                            }
                        }
                    }
                    a4 = kotlin.a.h.a();
                    Object[] array2 = a4.toArray(new String[0]);
                    if (array2 != null) {
                        String[] strArr2 = {((String[]) array2)[1]};
                        Uri uri2 = null;
                        if (i.a((Object) "image", (Object) str3)) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        } else if (i.a((Object) "video", (Object) str3)) {
                            uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        } else if (i.a((Object) "audio", (Object) str3)) {
                            uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                        }
                        return a(context, uri2, "_id=?", strArr2);
                    }
                    throw new kotlin.i("null cannot be cast to non-null type kotlin.Array<T>");
                }
                throw new kotlin.i("null cannot be cast to non-null type kotlin.Array<T>");
            } else if (c(uri)) {
                Uri parse = Uri.parse("content://downloads/public_downloads");
                Long valueOf = Long.valueOf(documentId);
                i.a((Object) valueOf, "java.lang.Long.valueOf(documentId)");
                return a(context, ContentUris.withAppendedId(parse, valueOf.longValue()), (String) null, (String[]) null);
            } else if (b(uri)) {
                String documentId2 = DocumentsContract.getDocumentId(uri);
                i.a((Object) documentId2, "docId");
                List<String> a7 = new kotlin.h.f(":").a(documentId2, 0);
                if (!a7.isEmpty()) {
                    ListIterator<String> listIterator3 = a7.listIterator(a7.size());
                    while (listIterator3.hasPrevious()) {
                        if (listIterator3.previous().length() == 0) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (!z) {
                            a2 = kotlin.a.h.b(a7, listIterator3.nextIndex() + 1);
                            break;
                        }
                    }
                }
                a2 = kotlin.a.h.a();
                Object[] array3 = a2.toArray(new String[0]);
                if (array3 != null) {
                    if (kotlin.h.g.a("primary", ((String[]) array3)[0], true)) {
                        return Environment.getExternalStorageDirectory() + '/' + strArr[1];
                    }
                    return str;
                }
                throw new kotlin.i("null cannot be cast to non-null type kotlin.Array<T>");
            } else {
                return str;
            }
        } else if (kotlin.h.g.a("content", uri.getScheme(), true)) {
            return a(context, uri, (String) null, (String[]) null);
        } else {
            return i.a((Object) "file", (Object) uri.getScheme()) ? uri.getPath() : str;
        }
    }

    private final String c(Context context, Uri uri) {
        return a(context, uri, (String) null, (String[]) null);
    }

    private final String a(Context context, Uri uri, String str, String[] strArr) {
        String str2 = null;
        String[] strArr2 = {"_data"};
        Cursor cursor = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (uri == null) {
                i.a();
            }
            cursor = contentResolver.query(uri, strArr2, str, strArr, null);
            return (cursor == null || !cursor.moveToFirst()) ? str2 : cursor.getString(cursor.getColumnIndexOrThrow(strArr2[0]));
        } catch (Exception unused) {
            if (cursor != null) {
                cursor.close();
                return str2;
            }
            return str2;
        }
    }

    private final boolean a(Uri uri) {
        return i.a((Object) "com.android.providers.media.documents", (Object) uri.getAuthority());
    }

    private final boolean b(Uri uri) {
        return i.a((Object) "com.android.externalstorage.documents", (Object) uri.getAuthority());
    }

    private final boolean c(Uri uri) {
        return i.a((Object) "com.android.providers.downloads.documents", (Object) uri.getAuthority());
    }

    public final String a(Bitmap bitmap, Bitmap.CompressFormat compressFormat, int i, File file) {
        i.b(bitmap, "bitmap");
        i.b(compressFormat, "format");
        i.b(file, "destFile");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (bitmap.compress(compressFormat, i, fileOutputStream)) {
                fileOutputStream.flush();
                fileOutputStream.close();
            }
            return file.getAbsolutePath();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }
}

package com.speed.speed_library.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import kotlin.d.b.j;
import kotlin.d.b.n;

/* compiled from: CustomDeviceId.kt */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: e  reason: collision with root package name */
    private static Context f5605e;

    /* renamed from: a  reason: collision with root package name */
    public static final e f5601a = new e();

    /* renamed from: b  reason: collision with root package name */
    private static final String f5602b = f5602b;

    /* renamed from: b  reason: collision with root package name */
    private static final String f5602b = f5602b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f5603c = c.f5594a.c();

    /* renamed from: d  reason: collision with root package name */
    private static final e f5604d = f5601a;
    private static String f = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS).toString() + File.separator + f5603c;

    private e() {
    }

    public final e a(Context context) {
        kotlin.d.b.i.b(context, com.umeng.analytics.pro.d.R);
        f5605e = context;
        return f5604d;
    }

    public final String a() {
        String b2 = b();
        if (TextUtils.isEmpty(b2)) {
            b2 = c();
        }
        if (TextUtils.isEmpty(b2)) {
            b2 = d();
        }
        return kotlin.h.g.a(kotlin.h.g.a(b2, "\r", "", false, 4, (Object) null), "\n", "", false, 4, (Object) null);
    }

    private final String b() {
        Context context = f5605e;
        if (context == null) {
            kotlin.d.b.i.b("mContext");
        }
        String b2 = b(context, f5602b, "");
        if (b2 == null) {
            kotlin.d.b.i.a();
        }
        b(b2);
        Log.d("DeviceId", "get id = " + b2 + " from app");
        return b2;
    }

    private final String c() {
        String a2;
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS).toString());
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(f);
        if (file2.exists()) {
            try {
                a2 = a(file2);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            Log.d("DeviceId", "get id = " + a2 + " from sdcard");
            a(a2);
            return a2;
        }
        a2 = "";
        Log.d("DeviceId", "get id = " + a2 + " from sdcard");
        a(a2);
        return a2;
    }

    private final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Context context = f5605e;
        if (context == null) {
            kotlin.d.b.i.b("mContext");
        }
        a(context, f5602b, str);
        Log.e("DeviceId", "save id = " + str + " to app");
    }

    private final void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_ALARMS).toString());
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(f);
        if (file2.exists()) {
            file2.deleteOnExit();
        }
        try {
            a(file2, str);
            Log.e("DeviceId", "save id = " + str + " to sdcard");
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private final String d() {
        String a2 = a(10);
        String a3 = com.speed.speed_library.utils.d.f5865a.a("33dfdfer21" + a2 + "sddddsfe");
        if (a3 == null) {
            throw new kotlin.i("null cannot be cast to non-null type java.lang.String");
        }
        String substring = a3.substring(0, 10);
        kotlin.d.b.i.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String str = "33dfdfer21." + a2 + '.' + substring;
        if (str == null) {
            throw new kotlin.i("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = str.toUpperCase();
        kotlin.d.b.i.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
        a(upperCase);
        b(upperCase);
        Log.e("DeviceId", "get device id = " + upperCase + " and save to both app and sdcard");
        return upperCase;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r6v11, types: [T, java.io.BufferedReader] */
    public final String a(File file) {
        kotlin.d.b.i.b(file, "file");
        String str = "";
        FileReader fileReader = null;
        n.a aVar = new n.a();
        aVar.f7161a = (BufferedReader) 0;
        try {
            try {
                FileReader fileReader2 = new FileReader(file);
                try {
                    try {
                        aVar.f7161a = new BufferedReader(fileReader2);
                        try {
                            n.a aVar2 = new n.a();
                            aVar2.f7161a = (String) 0;
                            while (new a(aVar2, aVar).a() != null) {
                                str = str + ((String) aVar2.f7161a) + "\r\n";
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (((BufferedReader) aVar.f7161a) != null) {
                            ((BufferedReader) aVar.f7161a).close();
                        }
                        fileReader2.close();
                    } catch (Throwable th) {
                        th = th;
                        fileReader = fileReader2;
                        if (((BufferedReader) aVar.f7161a) != null) {
                            ((BufferedReader) aVar.f7161a).close();
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileReader = fileReader2;
                    e.printStackTrace();
                    if (((BufferedReader) aVar.f7161a) != null) {
                        ((BufferedReader) aVar.f7161a).close();
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e = e4;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CustomDeviceId.kt */
    /* loaded from: classes2.dex */
    public static final class a extends j implements kotlin.d.a.a<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ n.a f5606a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ n.a f5607b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(n.a aVar, n.a aVar2) {
            super(0);
            this.f5606a = aVar;
            this.f5607b = aVar2;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.String] */
        @Override // kotlin.d.a.a
        /* renamed from: b */
        public final String a() {
            this.f5606a.f7161a = ((BufferedReader) this.f5607b.f7161a).readLine();
            return (String) this.f5606a.f7161a;
        }
    }

    public final void a(File file, String str) {
        kotlin.d.b.i.b(file, "file");
        kotlin.d.b.i.b(str, "str");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(str);
            fileWriter.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public final void a(Context context, String str, String str2) {
        kotlin.d.b.i.b(context, com.umeng.analytics.pro.d.R);
        kotlin.d.b.i.b(str, "key");
        kotlin.d.b.i.b(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public final String b(Context context, String str, String str2) {
        kotlin.d.b.i.b(context, com.umeng.analytics.pro.d.R);
        kotlin.d.b.i.b(str, "key");
        kotlin.d.b.i.b(str2, "defValue");
        return PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
    }

    public final String a(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i2 = 0; i2 < i; i2++) {
            if (random.nextInt(2) % 2 == 0) {
                if (random.nextInt(2) % 2 == 0) {
                    stringBuffer.append((char) (random.nextInt(27) + 65));
                } else {
                    stringBuffer.append((char) (random.nextInt(27) + 97));
                }
            } else {
                stringBuffer.append(random.nextInt(10));
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        kotlin.d.b.i.a((Object) stringBuffer2, "buffer.toString()");
        return stringBuffer2;
    }
}

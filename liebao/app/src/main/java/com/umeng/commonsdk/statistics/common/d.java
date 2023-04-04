package com.umeng.commonsdk.statistics.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: StoreHelper.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static d f6835a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Context f6836b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f6837c = null;

    /* renamed from: e  reason: collision with root package name */
    private static final String f6838e = "mobclick_agent_user_";
    private static final String f = "mobclick_agent_header_";
    private static final String g = "mobclick_agent_cached_";

    /* renamed from: d  reason: collision with root package name */
    private a f6839d;

    /* compiled from: StoreHelper.java */
    /* loaded from: classes2.dex */
    public interface b {
        void a(File file);

        boolean b(File file);

        void c(File file);
    }

    public d(Context context) {
        this.f6839d = new a(context);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            f6836b = context.getApplicationContext();
            f6837c = context.getPackageName();
            if (f6835a == null) {
                f6835a = new d(context);
            }
            dVar = f6835a;
        }
        return dVar;
    }

    public void a(int i) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f6836b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("vt", i).commit();
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f6836b);
        if (sharedPreferences != null) {
            return sharedPreferences.getInt("vt", 0);
        }
        return 0;
    }

    public String b() {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f6836b);
        if (sharedPreferences != null) {
            return sharedPreferences.getString("st", null);
        }
        return null;
    }

    public void a(String str) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f6836b);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString("st", str).commit();
        }
    }

    public boolean c() {
        return UMFrUtils.envelopeFileNumber(f6836b) > 0;
    }

    /* compiled from: StoreHelper.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f6840a;

        /* renamed from: b  reason: collision with root package name */
        private File f6841b;

        /* renamed from: c  reason: collision with root package name */
        private FilenameFilter f6842c;

        public a(Context context) {
            this(context, ".um");
        }

        public a(Context context, String str) {
            this.f6840a = 10;
            this.f6842c = new FilenameFilter() { // from class: com.umeng.commonsdk.statistics.common.d.a.1
                @Override // java.io.FilenameFilter
                public boolean accept(File file, String str2) {
                    return str2.startsWith("um");
                }
            };
            File file = new File(context.getFilesDir(), str);
            this.f6841b = file;
            if (file.exists() && this.f6841b.isDirectory()) {
                return;
            }
            this.f6841b.mkdir();
        }

        public boolean a() {
            File[] listFiles = this.f6841b.listFiles();
            return listFiles != null && listFiles.length > 0;
        }

        public void a(b bVar) {
            File file;
            File[] listFiles = this.f6841b.listFiles(this.f6842c);
            if (listFiles != null && listFiles.length >= 10) {
                Arrays.sort(listFiles);
                int length = listFiles.length - 10;
                for (int i = 0; i < length; i++) {
                    listFiles[i].delete();
                }
            }
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            bVar.a(this.f6841b);
            int length2 = listFiles.length;
            for (int i2 = 0; i2 < length2; i2++) {
                try {
                } catch (Throwable unused) {
                    file = listFiles[i2];
                }
                if (bVar.b(listFiles[i2])) {
                    file = listFiles[i2];
                    file.delete();
                }
            }
            bVar.c(this.f6841b);
        }

        public void a(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                return;
            }
            try {
                HelperUtils.writeFile(new File(this.f6841b, String.format(Locale.US, "um_cache_%d.env", Long.valueOf(System.currentTimeMillis()))), bArr);
            } catch (Exception unused) {
            }
        }

        public void b() {
            File[] listFiles = this.f6841b.listFiles(this.f6842c);
            if (listFiles == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                file.delete();
            }
        }

        public int c() {
            File[] listFiles = this.f6841b.listFiles(this.f6842c);
            if (listFiles == null || listFiles.length <= 0) {
                return 0;
            }
            return listFiles.length;
        }
    }

    private SharedPreferences f() {
        Context context = f6836b;
        return context.getSharedPreferences(f6838e + f6837c, 0);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences.Editor edit = f().edit();
        edit.putString("au_p", str);
        edit.putString("au_u", str2);
        edit.commit();
    }

    public String[] d() {
        try {
            SharedPreferences f2 = f();
            String string = f2.getString("au_p", null);
            String string2 = f2.getString("au_u", null);
            if (string != null && string2 != null) {
                return new String[]{string, string2};
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public void e() {
        f().edit().remove("au_p").remove("au_u").commit();
    }
}

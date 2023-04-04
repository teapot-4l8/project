package androidx.core.e;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import androidx.b.e;
import androidx.b.g;
import androidx.core.content.b.f;
import androidx.core.e.c;
import androidx.core.graphics.d;
import androidx.core.graphics.k;
import com.umeng.analytics.pro.ao;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* compiled from: FontsContractCompat.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    static final e<String, Typeface> f1514a = new e<>(16);

    /* renamed from: d  reason: collision with root package name */
    private static final androidx.core.e.c f1517d = new androidx.core.e.c("fonts", 10, 10000);

    /* renamed from: b  reason: collision with root package name */
    static final Object f1515b = new Object();

    /* renamed from: c  reason: collision with root package name */
    static final g<String, ArrayList<c.a<c>>> f1516c = new g<>();

    /* renamed from: e  reason: collision with root package name */
    private static final Comparator<byte[]> f1518e = new Comparator<byte[]>() { // from class: androidx.core.e.b.4
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(byte[] bArr, byte[] bArr2) {
            int i;
            int i2;
            if (bArr.length != bArr2.length) {
                i = bArr.length;
                i2 = bArr2.length;
            } else {
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    if (bArr[i3] != bArr2[i3]) {
                        i = bArr[i3];
                        i2 = bArr2[i3];
                    }
                }
                return 0;
            }
            return i - i2;
        }
    };

    static c a(Context context, androidx.core.e.a aVar, int i) {
        try {
            a a2 = a(context, (CancellationSignal) null, aVar);
            if (a2.a() == 0) {
                Typeface a3 = d.a(context, null, a2.b(), i);
                return new c(a3, a3 != null ? 0 : -3);
            }
            return new c(null, a2.a() == 1 ? -2 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new c(null, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f1533a;

        /* renamed from: b  reason: collision with root package name */
        final int f1534b;

        c(Typeface typeface, int i) {
            this.f1533a = typeface;
            this.f1534b = i;
        }
    }

    public static Typeface a(final Context context, final androidx.core.e.a aVar, final f.a aVar2, final Handler handler, boolean z, int i, final int i2) {
        final String str = aVar.f() + "-" + i2;
        Typeface a2 = f1514a.a((e<String, Typeface>) str);
        if (a2 != null) {
            if (aVar2 != null) {
                aVar2.onFontRetrieved(a2);
            }
            return a2;
        } else if (z && i == -1) {
            c a3 = a(context, aVar, i2);
            if (aVar2 != null) {
                if (a3.f1534b == 0) {
                    aVar2.callbackSuccessAsync(a3.f1533a, handler);
                } else {
                    aVar2.callbackFailAsync(a3.f1534b, handler);
                }
            }
            return a3.f1533a;
        } else {
            Callable<c> callable = new Callable<c>() { // from class: androidx.core.e.b.1
                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public c call() {
                    c a4 = b.a(context, aVar, i2);
                    if (a4.f1533a != null) {
                        b.f1514a.a(str, a4.f1533a);
                    }
                    return a4;
                }
            };
            if (z) {
                try {
                    return ((c) f1517d.a(callable, i)).f1533a;
                } catch (InterruptedException unused) {
                    return null;
                }
            }
            c.a<c> aVar3 = aVar2 == null ? null : new c.a<c>() { // from class: androidx.core.e.b.2
                @Override // androidx.core.e.c.a
                public void a(c cVar) {
                    if (cVar == null) {
                        f.a.this.callbackFailAsync(1, handler);
                    } else if (cVar.f1534b == 0) {
                        f.a.this.callbackSuccessAsync(cVar.f1533a, handler);
                    } else {
                        f.a.this.callbackFailAsync(cVar.f1534b, handler);
                    }
                }
            };
            synchronized (f1515b) {
                ArrayList<c.a<c>> arrayList = f1516c.get(str);
                if (arrayList != null) {
                    if (aVar3 != null) {
                        arrayList.add(aVar3);
                    }
                    return null;
                }
                if (aVar3 != null) {
                    ArrayList<c.a<c>> arrayList2 = new ArrayList<>();
                    arrayList2.add(aVar3);
                    f1516c.put(str, arrayList2);
                }
                f1517d.a(callable, new c.a<c>() { // from class: androidx.core.e.b.3
                    @Override // androidx.core.e.c.a
                    public void a(c cVar) {
                        synchronized (b.f1515b) {
                            ArrayList<c.a<c>> arrayList3 = b.f1516c.get(str);
                            if (arrayList3 == null) {
                                return;
                            }
                            b.f1516c.remove(str);
                            for (int i3 = 0; i3 < arrayList3.size(); i3++) {
                                arrayList3.get(i3).a(cVar);
                            }
                        }
                    }
                });
                return null;
            }
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* renamed from: androidx.core.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0034b {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f1528a;

        /* renamed from: b  reason: collision with root package name */
        private final int f1529b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1530c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f1531d;

        /* renamed from: e  reason: collision with root package name */
        private final int f1532e;

        public C0034b(Uri uri, int i, int i2, boolean z, int i3) {
            this.f1528a = (Uri) androidx.core.g.f.a(uri);
            this.f1529b = i;
            this.f1530c = i2;
            this.f1531d = z;
            this.f1532e = i3;
        }

        public Uri a() {
            return this.f1528a;
        }

        public int b() {
            return this.f1529b;
        }

        public int c() {
            return this.f1530c;
        }

        public boolean d() {
            return this.f1531d;
        }

        public int e() {
            return this.f1532e;
        }
    }

    /* compiled from: FontsContractCompat.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final int f1526a;

        /* renamed from: b  reason: collision with root package name */
        private final C0034b[] f1527b;

        public a(int i, C0034b[] c0034bArr) {
            this.f1526a = i;
            this.f1527b = c0034bArr;
        }

        public int a() {
            return this.f1526a;
        }

        public C0034b[] b() {
            return this.f1527b;
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, C0034b[] c0034bArr, CancellationSignal cancellationSignal) {
        HashMap hashMap = new HashMap();
        for (C0034b c0034b : c0034bArr) {
            if (c0034b.e() == 0) {
                Uri a2 = c0034b.a();
                if (!hashMap.containsKey(a2)) {
                    hashMap.put(a2, k.a(context, cancellationSignal, a2));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public static a a(Context context, CancellationSignal cancellationSignal, androidx.core.e.a aVar) {
        ProviderInfo a2 = a(context.getPackageManager(), aVar, context.getResources());
        if (a2 == null) {
            return new a(1, null);
        }
        return new a(0, a(context, aVar, a2.authority, cancellationSignal));
    }

    public static ProviderInfo a(PackageManager packageManager, androidx.core.e.a aVar, Resources resources) {
        String a2 = aVar.a();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a2, 0);
        if (resolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + a2);
        } else if (!resolveContentProvider.packageName.equals(aVar.b())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + a2 + ", but package was not " + aVar.b());
        } else {
            List<byte[]> a3 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(a3, f1518e);
            List<List<byte[]>> a4 = a(aVar, resources);
            for (int i = 0; i < a4.size(); i++) {
                ArrayList arrayList = new ArrayList(a4.get(i));
                Collections.sort(arrayList, f1518e);
                if (a(a3, arrayList)) {
                    return resolveContentProvider;
                }
            }
            return null;
        }
    }

    private static List<List<byte[]>> a(androidx.core.e.a aVar, Resources resources) {
        if (aVar.d() != null) {
            return aVar.d();
        }
        return androidx.core.content.b.c.a(resources, aVar.e());
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static C0034b[] a(Context context, androidx.core.e.a aVar, String str, CancellationSignal cancellationSignal) {
        Cursor cursor;
        ArrayList arrayList;
        String str2;
        String str3;
        int i;
        Cursor query;
        ArrayList arrayList2;
        Uri withAppendedId;
        ArrayList arrayList3 = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        try {
            if (Build.VERSION.SDK_INT > 16) {
                arrayList = arrayList3;
                str2 = "file_id";
                query = context.getContentResolver().query(build, new String[]{ao.f6395d, "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.c()}, null, cancellationSignal);
                str3 = ao.f6395d;
                i = 1;
            } else {
                arrayList = arrayList3;
                str2 = "file_id";
                str3 = ao.f6395d;
                i = 1;
                query = context.getContentResolver().query(build, new String[]{str3, str2, "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar.c()}, null);
            }
            if (query != null) {
                try {
                    if (query.getCount() > 0) {
                        int columnIndex = query.getColumnIndex("result_code");
                        ArrayList arrayList4 = new ArrayList();
                        int columnIndex2 = query.getColumnIndex(str3);
                        int columnIndex3 = query.getColumnIndex(str2);
                        int columnIndex4 = query.getColumnIndex("font_ttc_index");
                        int columnIndex5 = query.getColumnIndex("font_weight");
                        int columnIndex6 = query.getColumnIndex("font_italic");
                        while (query.moveToNext()) {
                            int i2 = columnIndex != -1 ? query.getInt(columnIndex) : 0;
                            int i3 = columnIndex4 != -1 ? query.getInt(columnIndex4) : 0;
                            if (columnIndex3 == -1) {
                                withAppendedId = ContentUris.withAppendedId(build, query.getLong(columnIndex2));
                            } else {
                                withAppendedId = ContentUris.withAppendedId(build2, query.getLong(columnIndex3));
                            }
                            arrayList4.add(new C0034b(withAppendedId, i3, columnIndex5 != -1 ? query.getInt(columnIndex5) : 400, columnIndex6 != -1 && query.getInt(columnIndex6) == i, i2));
                        }
                        arrayList2 = arrayList4;
                        if (query != null) {
                            query.close();
                        }
                        return (C0034b[]) arrayList2.toArray(new C0034b[0]);
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = query;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            arrayList2 = arrayList;
            if (query != null) {
            }
            return (C0034b[]) arrayList2.toArray(new C0034b[0]);
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }
}

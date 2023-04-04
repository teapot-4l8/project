package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActivityChooserModel.java */
/* loaded from: classes.dex */
public class d extends DataSetObservable {

    /* renamed from: a  reason: collision with root package name */
    static final String f1059a = d.class.getSimpleName();

    /* renamed from: e  reason: collision with root package name */
    private static final Object f1060e = new Object();
    private static final Map<String, d> f = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Context f1061b;

    /* renamed from: c  reason: collision with root package name */
    final String f1062c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1063d;
    private final Object g;
    private final List<a> h;
    private final List<c> i;
    private Intent j;
    private b k;
    private int l;
    private boolean m;
    private boolean n;
    private boolean o;
    private InterfaceC0026d p;

    /* compiled from: ActivityChooserModel.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(Intent intent, List<a> list, List<c> list2);
    }

    /* compiled from: ActivityChooserModel.java */
    /* renamed from: androidx.appcompat.widget.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0026d {
        boolean a(d dVar, Intent intent);
    }

    public int a() {
        int size;
        synchronized (this.g) {
            d();
            size = this.h.size();
        }
        return size;
    }

    public ResolveInfo a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.g) {
            d();
            resolveInfo = this.h.get(i).f1064a;
        }
        return resolveInfo;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.g) {
            d();
            List<a> list = this.h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f1064a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public Intent b(int i) {
        synchronized (this.g) {
            if (this.j == null) {
                return null;
            }
            d();
            a aVar = this.h.get(i);
            ComponentName componentName = new ComponentName(aVar.f1064a.activityInfo.packageName, aVar.f1064a.activityInfo.name);
            Intent intent = new Intent(this.j);
            intent.setComponent(componentName);
            if (this.p != null) {
                if (this.p.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo b() {
        synchronized (this.g) {
            d();
            if (this.h.isEmpty()) {
                return null;
            }
            return this.h.get(0).f1064a;
        }
    }

    public void c(int i) {
        synchronized (this.g) {
            d();
            a aVar = this.h.get(i);
            a aVar2 = this.h.get(0);
            a(new c(new ComponentName(aVar.f1064a.activityInfo.packageName, aVar.f1064a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.f1065b - aVar.f1065b) + 5.0f : 1.0f));
        }
    }

    private void c() {
        if (!this.m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.n) {
            this.n = false;
            if (TextUtils.isEmpty(this.f1062c)) {
                return;
            }
            new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.i), this.f1062c);
        }
    }

    private void d() {
        boolean f2 = f() | g();
        h();
        if (f2) {
            e();
            notifyChanged();
        }
    }

    private boolean e() {
        if (this.k == null || this.j == null || this.h.isEmpty() || this.i.isEmpty()) {
            return false;
        }
        this.k.a(this.j, this.h, Collections.unmodifiableList(this.i));
        return true;
    }

    private boolean f() {
        if (!this.o || this.j == null) {
            return false;
        }
        this.o = false;
        this.h.clear();
        List<ResolveInfo> queryIntentActivities = this.f1061b.getPackageManager().queryIntentActivities(this.j, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.h.add(new a(queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean g() {
        if (this.f1063d && this.n && !TextUtils.isEmpty(this.f1062c)) {
            this.f1063d = false;
            this.m = true;
            i();
            return true;
        }
        return false;
    }

    private boolean a(c cVar) {
        boolean add = this.i.add(cVar);
        if (add) {
            this.n = true;
            h();
            c();
            e();
            notifyChanged();
        }
        return add;
    }

    private void h() {
        int size = this.i.size() - this.l;
        if (size <= 0) {
            return;
        }
        this.n = true;
        for (int i = 0; i < size; i++) {
            this.i.remove(0);
        }
    }

    /* compiled from: ActivityChooserModel.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f1066a;

        /* renamed from: b  reason: collision with root package name */
        public final long f1067b;

        /* renamed from: c  reason: collision with root package name */
        public final float f1068c;

        public c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public c(ComponentName componentName, long j, float f) {
            this.f1066a = componentName;
            this.f1067b = j;
            this.f1068c = f;
        }

        public int hashCode() {
            ComponentName componentName = this.f1066a;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j = this.f1067b;
            return ((((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Float.floatToIntBits(this.f1068c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                c cVar = (c) obj;
                ComponentName componentName = this.f1066a;
                if (componentName == null) {
                    if (cVar.f1066a != null) {
                        return false;
                    }
                } else if (!componentName.equals(cVar.f1066a)) {
                    return false;
                }
                return this.f1067b == cVar.f1067b && Float.floatToIntBits(this.f1068c) == Float.floatToIntBits(cVar.f1068c);
            }
            return false;
        }

        public String toString() {
            return "[; activity:" + this.f1066a + "; time:" + this.f1067b + "; weight:" + new BigDecimal(this.f1068c) + "]";
        }
    }

    /* compiled from: ActivityChooserModel.java */
    /* loaded from: classes.dex */
    public static final class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        public final ResolveInfo f1064a;

        /* renamed from: b  reason: collision with root package name */
        public float f1065b;

        public a(ResolveInfo resolveInfo) {
            this.f1064a = resolveInfo;
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f1065b) + 31;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.f1065b) == Float.floatToIntBits(((a) obj).f1065b);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.f1065b) - Float.floatToIntBits(this.f1065b);
        }

        public String toString() {
            return "[resolveInfo:" + this.f1064a.toString() + "; weight:" + new BigDecimal(this.f1065b) + "]";
        }
    }

    private void i() {
        XmlPullParser newPullParser;
        try {
            FileInputStream openFileInput = this.f1061b.openFileInput(this.f1062c);
            try {
                try {
                    try {
                        newPullParser = Xml.newPullParser();
                        newPullParser.setInput(openFileInput, "UTF-8");
                        for (int i = 0; i != 1 && i != 2; i = newPullParser.next()) {
                        }
                    } catch (XmlPullParserException e2) {
                        String str = f1059a;
                        Log.e(str, "Error reading historical recrod file: " + this.f1062c, e2);
                        if (openFileInput == null) {
                            return;
                        }
                    }
                } catch (IOException e3) {
                    String str2 = f1059a;
                    Log.e(str2, "Error reading historical recrod file: " + this.f1062c, e3);
                    if (openFileInput == null) {
                        return;
                    }
                }
                if (!"historical-records".equals(newPullParser.getName())) {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
                List<c> list = this.i;
                list.clear();
                while (true) {
                    int next = newPullParser.next();
                    if (next == 1) {
                        if (openFileInput == null) {
                            return;
                        }
                    } else if (next != 3 && next != 4) {
                        if (!"historical-record".equals(newPullParser.getName())) {
                            throw new XmlPullParserException("Share records file not well-formed.");
                        }
                        list.add(new c(newPullParser.getAttributeValue(null, "activity"), Long.parseLong(newPullParser.getAttributeValue(null, "time")), Float.parseFloat(newPullParser.getAttributeValue(null, "weight"))));
                    }
                }
                try {
                    openFileInput.close();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ActivityChooserModel.java */
    /* loaded from: classes.dex */
    public final class e extends AsyncTask<Object, Void, Void> {
        e() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x006d, code lost:
            if (r15 != null) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x006f, code lost:
            r15.close();
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0092, code lost:
            if (r15 == null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00b2, code lost:
            if (r15 == null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00d2, code lost:
            if (r15 == null) goto L13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00d5, code lost:
            return null;
         */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream openFileOutput = d.this.f1061b.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            newSerializer.setOutput(openFileOutput, null);
                            newSerializer.startDocument("UTF-8", true);
                            newSerializer.startTag(null, "historical-records");
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                c cVar = (c) list.remove(0);
                                newSerializer.startTag(null, "historical-record");
                                newSerializer.attribute(null, "activity", cVar.f1066a.flattenToString());
                                newSerializer.attribute(null, "time", String.valueOf(cVar.f1067b));
                                newSerializer.attribute(null, "weight", String.valueOf(cVar.f1068c));
                                newSerializer.endTag(null, "historical-record");
                            }
                            newSerializer.endTag(null, "historical-records");
                            newSerializer.endDocument();
                            d.this.f1063d = true;
                        } catch (IOException e2) {
                            String str2 = d.f1059a;
                            Log.e(str2, "Error writing historical record file: " + d.this.f1062c, e2);
                            d.this.f1063d = true;
                        } catch (IllegalArgumentException e3) {
                            String str3 = d.f1059a;
                            Log.e(str3, "Error writing historical record file: " + d.this.f1062c, e3);
                            d.this.f1063d = true;
                        }
                    } catch (IllegalStateException e4) {
                        String str4 = d.f1059a;
                        Log.e(str4, "Error writing historical record file: " + d.this.f1062c, e4);
                        d.this.f1063d = true;
                    }
                } catch (Throwable th) {
                    d.this.f1063d = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                String str5 = d.f1059a;
                Log.e(str5, "Error writing historical record file: " + str, e5);
                return null;
            }
        }
    }
}

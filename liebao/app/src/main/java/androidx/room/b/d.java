package androidx.room.b;

import android.database.Cursor;
import android.os.Build;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.umeng.analytics.pro.ak;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* compiled from: TableInfo.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f2398a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, a> f2399b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<b> f2400c;

    /* renamed from: d  reason: collision with root package name */
    public final Set<C0054d> f2401d;

    public d(String str, Map<String, a> map, Set<b> set, Set<C0054d> set2) {
        this.f2398a = str;
        this.f2399b = Collections.unmodifiableMap(map);
        this.f2400c = Collections.unmodifiableSet(set);
        this.f2401d = set2 == null ? null : Collections.unmodifiableSet(set2);
    }

    public boolean equals(Object obj) {
        Set<C0054d> set;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        String str = this.f2398a;
        if (str == null ? dVar.f2398a == null : str.equals(dVar.f2398a)) {
            Map<String, a> map = this.f2399b;
            if (map == null ? dVar.f2399b == null : map.equals(dVar.f2399b)) {
                Set<b> set2 = this.f2400c;
                if (set2 == null ? dVar.f2400c == null : set2.equals(dVar.f2400c)) {
                    Set<C0054d> set3 = this.f2401d;
                    if (set3 == null || (set = dVar.f2401d) == null) {
                        return true;
                    }
                    return set3.equals(set);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f2398a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Map<String, a> map = this.f2399b;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set<b> set = this.f2400c;
        return hashCode2 + (set != null ? set.hashCode() : 0);
    }

    public String toString() {
        return "TableInfo{name='" + this.f2398a + "', columns=" + this.f2399b + ", foreignKeys=" + this.f2400c + ", indices=" + this.f2401d + '}';
    }

    public static d a(androidx.e.a.b bVar, String str) {
        return new d(str, c(bVar, str), b(bVar, str), d(bVar, str));
    }

    private static Set<b> b(androidx.e.a.b bVar, String str) {
        HashSet hashSet = new HashSet();
        Cursor b2 = bVar.b("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("id");
            int columnIndex2 = b2.getColumnIndex("seq");
            int columnIndex3 = b2.getColumnIndex("table");
            int columnIndex4 = b2.getColumnIndex("on_delete");
            int columnIndex5 = b2.getColumnIndex("on_update");
            List<c> a2 = a(b2);
            int count = b2.getCount();
            for (int i = 0; i < count; i++) {
                b2.moveToPosition(i);
                if (b2.getInt(columnIndex2) == 0) {
                    int i2 = b2.getInt(columnIndex);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (c cVar : a2) {
                        if (cVar.f2412a == i2) {
                            arrayList.add(cVar.f2414c);
                            arrayList2.add(cVar.f2415d);
                        }
                    }
                    hashSet.add(new b(b2.getString(columnIndex3), b2.getString(columnIndex4), b2.getString(columnIndex5), arrayList, arrayList2));
                }
            }
            return hashSet;
        } finally {
            b2.close();
        }
    }

    private static List<c> a(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new c(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static Map<String, a> c(androidx.e.a.b bVar, String str) {
        Cursor b2 = bVar.b("PRAGMA table_info(`" + str + "`)");
        HashMap hashMap = new HashMap();
        try {
            if (b2.getColumnCount() > 0) {
                int columnIndex = b2.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME);
                int columnIndex2 = b2.getColumnIndex(com.umeng.analytics.pro.d.y);
                int columnIndex3 = b2.getColumnIndex("notnull");
                int columnIndex4 = b2.getColumnIndex("pk");
                while (b2.moveToNext()) {
                    String string = b2.getString(columnIndex);
                    hashMap.put(string, new a(string, b2.getString(columnIndex2), b2.getInt(columnIndex3) != 0, b2.getInt(columnIndex4)));
                }
            }
            return hashMap;
        } finally {
            b2.close();
        }
    }

    private static Set<C0054d> d(androidx.e.a.b bVar, String str) {
        Cursor b2 = bVar.b("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME);
            int columnIndex2 = b2.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.ORIGIN);
            int columnIndex3 = b2.getColumnIndex("unique");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                HashSet hashSet = new HashSet();
                while (b2.moveToNext()) {
                    if (ak.aF.equals(b2.getString(columnIndex2))) {
                        String string = b2.getString(columnIndex);
                        boolean z = true;
                        if (b2.getInt(columnIndex3) != 1) {
                            z = false;
                        }
                        C0054d a2 = a(bVar, string, z);
                        if (a2 == null) {
                            return null;
                        }
                        hashSet.add(a2);
                    }
                }
                return hashSet;
            }
            return null;
        } finally {
            b2.close();
        }
    }

    private static C0054d a(androidx.e.a.b bVar, String str, boolean z) {
        Cursor b2 = bVar.b("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = b2.getColumnIndex("seqno");
            int columnIndex2 = b2.getColumnIndex("cid");
            int columnIndex3 = b2.getColumnIndex(AppMeasurementSdk.ConditionalUserProperty.NAME);
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1) {
                TreeMap treeMap = new TreeMap();
                while (b2.moveToNext()) {
                    if (b2.getInt(columnIndex2) >= 0) {
                        int i = b2.getInt(columnIndex);
                        treeMap.put(Integer.valueOf(i), b2.getString(columnIndex3));
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                return new C0054d(str, z, arrayList);
            }
            return null;
        } finally {
            b2.close();
        }
    }

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f2402a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2403b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2404c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f2405d;

        /* renamed from: e  reason: collision with root package name */
        public final int f2406e;

        public a(String str, String str2, boolean z, int i) {
            this.f2402a = str;
            this.f2403b = str2;
            this.f2405d = z;
            this.f2406e = i;
            this.f2404c = a(str2);
        }

        private static int a(String str) {
            if (str == null) {
                return 5;
            }
            String upperCase = str.toUpperCase(Locale.US);
            if (upperCase.contains("INT")) {
                return 3;
            }
            if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                return 2;
            }
            if (upperCase.contains("BLOB")) {
                return 5;
            }
            return (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (Build.VERSION.SDK_INT >= 20) {
                if (this.f2406e != aVar.f2406e) {
                    return false;
                }
            } else if (a() != aVar.a()) {
                return false;
            }
            return this.f2402a.equals(aVar.f2402a) && this.f2405d == aVar.f2405d && this.f2404c == aVar.f2404c;
        }

        public boolean a() {
            return this.f2406e > 0;
        }

        public int hashCode() {
            return (((((this.f2402a.hashCode() * 31) + this.f2404c) * 31) + (this.f2405d ? 1231 : 1237)) * 31) + this.f2406e;
        }

        public String toString() {
            return "Column{name='" + this.f2402a + "', type='" + this.f2403b + "', affinity='" + this.f2404c + "', notNull=" + this.f2405d + ", primaryKeyPosition=" + this.f2406e + '}';
        }
    }

    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f2407a;

        /* renamed from: b  reason: collision with root package name */
        public final String f2408b;

        /* renamed from: c  reason: collision with root package name */
        public final String f2409c;

        /* renamed from: d  reason: collision with root package name */
        public final List<String> f2410d;

        /* renamed from: e  reason: collision with root package name */
        public final List<String> f2411e;

        public b(String str, String str2, String str3, List<String> list, List<String> list2) {
            this.f2407a = str;
            this.f2408b = str2;
            this.f2409c = str3;
            this.f2410d = Collections.unmodifiableList(list);
            this.f2411e = Collections.unmodifiableList(list2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f2407a.equals(bVar.f2407a) && this.f2408b.equals(bVar.f2408b) && this.f2409c.equals(bVar.f2409c) && this.f2410d.equals(bVar.f2410d)) {
                return this.f2411e.equals(bVar.f2411e);
            }
            return false;
        }

        public int hashCode() {
            return (((((((this.f2407a.hashCode() * 31) + this.f2408b.hashCode()) * 31) + this.f2409c.hashCode()) * 31) + this.f2410d.hashCode()) * 31) + this.f2411e.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.f2407a + "', onDelete='" + this.f2408b + "', onUpdate='" + this.f2409c + "', columnNames=" + this.f2410d + ", referenceColumnNames=" + this.f2411e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TableInfo.java */
    /* loaded from: classes.dex */
    public static class c implements Comparable<c> {

        /* renamed from: a  reason: collision with root package name */
        final int f2412a;

        /* renamed from: b  reason: collision with root package name */
        final int f2413b;

        /* renamed from: c  reason: collision with root package name */
        final String f2414c;

        /* renamed from: d  reason: collision with root package name */
        final String f2415d;

        c(int i, int i2, String str, String str2) {
            this.f2412a = i;
            this.f2413b = i2;
            this.f2414c = str;
            this.f2415d = str2;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(c cVar) {
            int i = this.f2412a - cVar.f2412a;
            return i == 0 ? this.f2413b - cVar.f2413b : i;
        }
    }

    /* compiled from: TableInfo.java */
    /* renamed from: androidx.room.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0054d {

        /* renamed from: a  reason: collision with root package name */
        public final String f2416a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f2417b;

        /* renamed from: c  reason: collision with root package name */
        public final List<String> f2418c;

        public C0054d(String str, boolean z, List<String> list) {
            this.f2416a = str;
            this.f2417b = z;
            this.f2418c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0054d c0054d = (C0054d) obj;
            if (this.f2417b == c0054d.f2417b && this.f2418c.equals(c0054d.f2418c)) {
                if (this.f2416a.startsWith("index_")) {
                    return c0054d.f2416a.startsWith("index_");
                }
                return this.f2416a.equals(c0054d.f2416a);
            }
            return false;
        }

        public int hashCode() {
            return ((((this.f2416a.startsWith("index_") ? -1184239155 : this.f2416a.hashCode()) * 31) + (this.f2417b ? 1 : 0)) * 31) + this.f2418c.hashCode();
        }

        public String toString() {
            return "Index{name='" + this.f2416a + "', unique=" + this.f2417b + ", columns=" + this.f2418c + '}';
        }
    }
}

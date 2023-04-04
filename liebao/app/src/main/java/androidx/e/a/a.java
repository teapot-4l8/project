package androidx.e.a;

/* compiled from: SimpleSQLiteQuery.java */
/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: a  reason: collision with root package name */
    private final String f1809a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f1810b;

    public a(String str, Object[] objArr) {
        this.f1809a = str;
        this.f1810b = objArr;
    }

    public a(String str) {
        this(str, null);
    }

    @Override // androidx.e.a.e
    public String b() {
        return this.f1809a;
    }

    @Override // androidx.e.a.e
    public void a(d dVar) {
        a(dVar, this.f1810b);
    }

    public static void a(d dVar, Object[] objArr) {
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            Object obj = objArr[i];
            i++;
            a(dVar, i, obj);
        }
    }

    private static void a(d dVar, int i, Object obj) {
        if (obj == null) {
            dVar.a(i);
        } else if (obj instanceof byte[]) {
            dVar.a(i, (byte[]) obj);
        } else if (obj instanceof Float) {
            dVar.a(i, ((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            dVar.a(i, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            dVar.a(i, ((Long) obj).longValue());
        } else if (obj instanceof Integer) {
            dVar.a(i, ((Integer) obj).intValue());
        } else if (obj instanceof Short) {
            dVar.a(i, ((Short) obj).shortValue());
        } else if (obj instanceof Byte) {
            dVar.a(i, ((Byte) obj).byteValue());
        } else if (obj instanceof String) {
            dVar.a(i, (String) obj);
        } else if (obj instanceof Boolean) {
            dVar.a(i, ((Boolean) obj).booleanValue() ? 1L : 0L);
        } else {
            throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i + " Supported types: null, byte[], float, double, long, int, short, byte, string");
        }
    }
}

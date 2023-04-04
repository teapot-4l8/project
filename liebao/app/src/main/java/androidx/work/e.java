package androidx.work;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Data.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    Map<String, Object> f2789b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f2788c = h.a("Data");

    /* renamed from: a  reason: collision with root package name */
    public static final e f2787a = new a().a();

    e() {
    }

    public e(e eVar) {
        this.f2789b = new HashMap(eVar.f2789b);
    }

    e(Map<String, ?> map) {
        this.f2789b = new HashMap(map);
    }

    public String a(String str) {
        Object obj = this.f2789b.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public Map<String, Object> a() {
        return Collections.unmodifiableMap(this.f2789b);
    }

    public int b() {
        return this.f2789b.size();
    }

    public static byte[] a(e eVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeInt(eVar.b());
                    for (Map.Entry<String, Object> entry : eVar.f2789b.entrySet()) {
                        objectOutputStream2.writeUTF(entry.getKey());
                        objectOutputStream2.writeObject(entry.getValue());
                    }
                    try {
                        objectOutputStream2.close();
                    } catch (IOException e2) {
                        Log.e(f2788c, "Error in Data#toByteArray: ", e2);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e3) {
                        Log.e(f2788c, "Error in Data#toByteArray: ", e3);
                    }
                    if (byteArrayOutputStream.size() > 10240) {
                        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                    }
                    return byteArrayOutputStream.toByteArray();
                } catch (IOException e4) {
                    e = e4;
                    objectOutputStream = objectOutputStream2;
                    Log.e(f2788c, "Error in Data#toByteArray: ", e);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                            Log.e(f2788c, "Error in Data#toByteArray: ", e5);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e6) {
                        Log.e(f2788c, "Error in Data#toByteArray: ", e6);
                    }
                    return byteArray;
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e7) {
                            Log.e(f2788c, "Error in Data#toByteArray: ", e7);
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e8) {
                        Log.e(f2788c, "Error in Data#toByteArray: ", e8);
                    }
                    throw th;
                }
            } catch (IOException e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x005d -> B:36:0x0062). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static e a(byte[] bArr) {
        Throwable th;
        ObjectInputStream objectInputStream;
        Throwable e2;
        if (bArr.length > 10240) {
            throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
        }
        HashMap hashMap = new HashMap();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ObjectInputStream objectInputStream2 = null;
        try {
        } catch (IOException e3) {
            Log.e(f2788c, "Error in Data#fromByteArray: ", e3);
        }
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e4) {
                e = e4;
                Throwable th2 = e;
                objectInputStream = null;
                e2 = th2;
                Log.e(f2788c, "Error in Data#fromByteArray: ", e2);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return new e(hashMap);
            } catch (ClassNotFoundException e5) {
                e = e5;
                Throwable th22 = e;
                objectInputStream = null;
                e2 = th22;
                Log.e(f2788c, "Error in Data#fromByteArray: ", e2);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return new e(hashMap);
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                }
                try {
                    byteArrayInputStream.close();
                } catch (IOException e6) {
                    Log.e(f2788c, "Error in Data#fromByteArray: ", e6);
                }
                throw th;
            }
            try {
                for (int readInt = objectInputStream.readInt(); readInt > 0; readInt--) {
                    hashMap.put(objectInputStream.readUTF(), objectInputStream.readObject());
                }
                try {
                    objectInputStream.close();
                } catch (IOException e7) {
                    Log.e(f2788c, "Error in Data#fromByteArray: ", e7);
                }
                byteArrayInputStream.close();
            } catch (IOException e8) {
                e2 = e8;
                Log.e(f2788c, "Error in Data#fromByteArray: ", e2);
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e9) {
                        Log.e(f2788c, "Error in Data#fromByteArray: ", e9);
                    }
                }
                byteArrayInputStream.close();
                return new e(hashMap);
            } catch (ClassNotFoundException e10) {
                e2 = e10;
                Log.e(f2788c, "Error in Data#fromByteArray: ", e2);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                return new e(hashMap);
            }
            return new e(hashMap);
        } catch (Throwable th4) {
            th = th4;
            if (0 != 0) {
                try {
                    objectInputStream2.close();
                } catch (IOException e11) {
                    Log.e(f2788c, "Error in Data#fromByteArray: ", e11);
                }
            }
            byteArrayInputStream.close();
            throw th;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f2789b.equals(((e) obj).f2789b);
    }

    public int hashCode() {
        return this.f2789b.hashCode() * 31;
    }

    static Boolean[] a(boolean[] zArr) {
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i = 0; i < zArr.length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    static Byte[] b(byte[] bArr) {
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    static Integer[] a(int[] iArr) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    static Long[] a(long[] jArr) {
        Long[] lArr = new Long[jArr.length];
        for (int i = 0; i < jArr.length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    static Float[] a(float[] fArr) {
        Float[] fArr2 = new Float[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    static Double[] a(double[] dArr) {
        Double[] dArr2 = new Double[dArr.length];
        for (int i = 0; i < dArr.length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    /* compiled from: Data.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, Object> f2790a = new HashMap();

        public a a(String str, String str2) {
            this.f2790a.put(str, str2);
            return this;
        }

        public a a(e eVar) {
            a(eVar.f2789b);
            return this;
        }

        public a a(Map<String, Object> map) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                a(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public a a(String str, Object obj) {
            if (obj == null) {
                this.f2790a.put(str, null);
            } else {
                Class<?> cls = obj.getClass();
                if (cls == Boolean.class || cls == Byte.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == String.class || cls == Boolean[].class || cls == Byte[].class || cls == Integer[].class || cls == Long[].class || cls == Float[].class || cls == Double[].class || cls == String[].class) {
                    this.f2790a.put(str, obj);
                } else if (cls == boolean[].class) {
                    this.f2790a.put(str, e.a((boolean[]) obj));
                } else if (cls == byte[].class) {
                    this.f2790a.put(str, e.b((byte[]) obj));
                } else if (cls == int[].class) {
                    this.f2790a.put(str, e.a((int[]) obj));
                } else if (cls == long[].class) {
                    this.f2790a.put(str, e.a((long[]) obj));
                } else if (cls == float[].class) {
                    this.f2790a.put(str, e.a((float[]) obj));
                } else if (cls == double[].class) {
                    this.f2790a.put(str, e.a((double[]) obj));
                } else {
                    throw new IllegalArgumentException(String.format("Key %s has invalid type %s", str, cls));
                }
            }
            return this;
        }

        public e a() {
            e eVar = new e(this.f2790a);
            e.a(eVar);
            return eVar;
        }
    }
}

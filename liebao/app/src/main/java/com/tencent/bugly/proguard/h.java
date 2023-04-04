package com.tencent.bugly.proguard;

import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f6198a;

    /* renamed from: b  reason: collision with root package name */
    private int f6199b;

    private void a(String str) {
        for (int i = 0; i < this.f6199b; i++) {
            this.f6198a.append('\t');
        }
        if (str != null) {
            StringBuilder sb = this.f6198a;
            sb.append(str);
            sb.append(": ");
        }
    }

    public h(StringBuilder sb, int i) {
        this.f6199b = 0;
        this.f6198a = sb;
        this.f6199b = i;
    }

    public final h a(boolean z, String str) {
        a(str);
        StringBuilder sb = this.f6198a;
        sb.append(z ? 'T' : 'F');
        sb.append('\n');
        return this;
    }

    public final h a(byte b2, String str) {
        a(str);
        StringBuilder sb = this.f6198a;
        sb.append((int) b2);
        sb.append('\n');
        return this;
    }

    public final h a(short s, String str) {
        a(str);
        StringBuilder sb = this.f6198a;
        sb.append((int) s);
        sb.append('\n');
        return this;
    }

    public final h a(int i, String str) {
        a(str);
        StringBuilder sb = this.f6198a;
        sb.append(i);
        sb.append('\n');
        return this;
    }

    public final h a(long j, String str) {
        a(str);
        StringBuilder sb = this.f6198a;
        sb.append(j);
        sb.append('\n');
        return this;
    }

    public final h a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.f6198a.append("null\n");
        } else {
            StringBuilder sb = this.f6198a;
            sb.append(str);
            sb.append('\n');
        }
        return this;
    }

    public final h a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.f6198a.append("null\n");
            return this;
        } else if (bArr.length == 0) {
            StringBuilder sb = this.f6198a;
            sb.append(bArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f6198a;
            sb2.append(bArr.length);
            sb2.append(", [\n");
            h hVar = new h(this.f6198a, this.f6199b + 1);
            for (byte b2 : bArr) {
                hVar.a(null);
                StringBuilder sb3 = hVar.f6198a;
                sb3.append((int) b2);
                sb3.append('\n');
            }
            a(null);
            StringBuilder sb4 = this.f6198a;
            sb4.append(']');
            sb4.append('\n');
            return this;
        }
    }

    public final <K, V> h a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.f6198a.append("null\n");
            return this;
        } else if (map.isEmpty()) {
            StringBuilder sb = this.f6198a;
            sb.append(map.size());
            sb.append(", {}\n");
            return this;
        } else {
            StringBuilder sb2 = this.f6198a;
            sb2.append(map.size());
            sb2.append(", {\n");
            h hVar = new h(this.f6198a, this.f6199b + 1);
            h hVar2 = new h(this.f6198a, this.f6199b + 2);
            for (Map.Entry<K, V> entry : map.entrySet()) {
                hVar.a(null);
                StringBuilder sb3 = hVar.f6198a;
                sb3.append('(');
                sb3.append('\n');
                hVar2.a((h) entry.getKey(), (String) null);
                hVar2.a((h) entry.getValue(), (String) null);
                hVar.a(null);
                StringBuilder sb4 = hVar.f6198a;
                sb4.append(')');
                sb4.append('\n');
            }
            a(null);
            StringBuilder sb5 = this.f6198a;
            sb5.append('}');
            sb5.append('\n');
            return this;
        }
    }

    private <T> h a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.f6198a.append("null\n");
            return this;
        } else if (tArr.length == 0) {
            StringBuilder sb = this.f6198a;
            sb.append(tArr.length);
            sb.append(", []\n");
            return this;
        } else {
            StringBuilder sb2 = this.f6198a;
            sb2.append(tArr.length);
            sb2.append(", [\n");
            h hVar = new h(this.f6198a, this.f6199b + 1);
            for (T t : tArr) {
                hVar.a((h) t, (String) null);
            }
            a(null);
            StringBuilder sb3 = this.f6198a;
            sb3.append(']');
            sb3.append('\n');
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> h a(T t, String str) {
        if (t == null) {
            this.f6198a.append("null\n");
        } else if (t instanceof Byte) {
            byte byteValue = ((Byte) t).byteValue();
            a(str);
            StringBuilder sb = this.f6198a;
            sb.append((int) byteValue);
            sb.append('\n');
        } else if (t instanceof Boolean) {
            boolean booleanValue = ((Boolean) t).booleanValue();
            a(str);
            StringBuilder sb2 = this.f6198a;
            sb2.append(booleanValue ? 'T' : 'F');
            sb2.append('\n');
        } else if (t instanceof Short) {
            short shortValue = ((Short) t).shortValue();
            a(str);
            StringBuilder sb3 = this.f6198a;
            sb3.append((int) shortValue);
            sb3.append('\n');
        } else if (t instanceof Integer) {
            int intValue = ((Integer) t).intValue();
            a(str);
            StringBuilder sb4 = this.f6198a;
            sb4.append(intValue);
            sb4.append('\n');
        } else if (t instanceof Long) {
            long longValue = ((Long) t).longValue();
            a(str);
            StringBuilder sb5 = this.f6198a;
            sb5.append(longValue);
            sb5.append('\n');
        } else if (t instanceof Float) {
            float floatValue = ((Float) t).floatValue();
            a(str);
            StringBuilder sb6 = this.f6198a;
            sb6.append(floatValue);
            sb6.append('\n');
        } else if (t instanceof Double) {
            double doubleValue = ((Double) t).doubleValue();
            a(str);
            StringBuilder sb7 = this.f6198a;
            sb7.append(doubleValue);
            sb7.append('\n');
        } else if (t instanceof String) {
            a((String) t, str);
        } else if (t instanceof Map) {
            a((Map) t, str);
        } else if (t instanceof List) {
            List list = (List) t;
            if (list == null) {
                a(str);
                this.f6198a.append("null\t");
            } else {
                a(list.toArray(), str);
            }
        } else if (t instanceof k) {
            a((k) t, str);
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            a((h) ((boolean[]) t), str);
        } else {
            int i = 0;
            if (t instanceof short[]) {
                short[] sArr = (short[]) t;
                a(str);
                if (sArr == null) {
                    this.f6198a.append("null\n");
                } else if (sArr.length == 0) {
                    StringBuilder sb8 = this.f6198a;
                    sb8.append(sArr.length);
                    sb8.append(", []\n");
                } else {
                    StringBuilder sb9 = this.f6198a;
                    sb9.append(sArr.length);
                    sb9.append(", [\n");
                    h hVar = new h(this.f6198a, this.f6199b + 1);
                    int length = sArr.length;
                    while (i < length) {
                        short s = sArr[i];
                        hVar.a(null);
                        StringBuilder sb10 = hVar.f6198a;
                        sb10.append((int) s);
                        sb10.append('\n');
                        i++;
                    }
                    a(null);
                    StringBuilder sb11 = this.f6198a;
                    sb11.append(']');
                    sb11.append('\n');
                }
            } else if (t instanceof int[]) {
                int[] iArr = (int[]) t;
                a(str);
                if (iArr == null) {
                    this.f6198a.append("null\n");
                } else if (iArr.length == 0) {
                    StringBuilder sb12 = this.f6198a;
                    sb12.append(iArr.length);
                    sb12.append(", []\n");
                } else {
                    StringBuilder sb13 = this.f6198a;
                    sb13.append(iArr.length);
                    sb13.append(", [\n");
                    h hVar2 = new h(this.f6198a, this.f6199b + 1);
                    int length2 = iArr.length;
                    while (i < length2) {
                        int i2 = iArr[i];
                        hVar2.a(null);
                        StringBuilder sb14 = hVar2.f6198a;
                        sb14.append(i2);
                        sb14.append('\n');
                        i++;
                    }
                    a(null);
                    StringBuilder sb15 = this.f6198a;
                    sb15.append(']');
                    sb15.append('\n');
                }
            } else if (t instanceof long[]) {
                long[] jArr = (long[]) t;
                a(str);
                if (jArr == null) {
                    this.f6198a.append("null\n");
                } else if (jArr.length == 0) {
                    StringBuilder sb16 = this.f6198a;
                    sb16.append(jArr.length);
                    sb16.append(", []\n");
                } else {
                    StringBuilder sb17 = this.f6198a;
                    sb17.append(jArr.length);
                    sb17.append(", [\n");
                    h hVar3 = new h(this.f6198a, this.f6199b + 1);
                    int length3 = jArr.length;
                    while (i < length3) {
                        long j = jArr[i];
                        hVar3.a(null);
                        StringBuilder sb18 = hVar3.f6198a;
                        sb18.append(j);
                        sb18.append('\n');
                        i++;
                    }
                    a(null);
                    StringBuilder sb19 = this.f6198a;
                    sb19.append(']');
                    sb19.append('\n');
                }
            } else if (t instanceof float[]) {
                float[] fArr = (float[]) t;
                a(str);
                if (fArr == null) {
                    this.f6198a.append("null\n");
                } else if (fArr.length == 0) {
                    StringBuilder sb20 = this.f6198a;
                    sb20.append(fArr.length);
                    sb20.append(", []\n");
                } else {
                    StringBuilder sb21 = this.f6198a;
                    sb21.append(fArr.length);
                    sb21.append(", [\n");
                    h hVar4 = new h(this.f6198a, this.f6199b + 1);
                    int length4 = fArr.length;
                    while (i < length4) {
                        float f = fArr[i];
                        hVar4.a(null);
                        StringBuilder sb22 = hVar4.f6198a;
                        sb22.append(f);
                        sb22.append('\n');
                        i++;
                    }
                    a(null);
                    StringBuilder sb23 = this.f6198a;
                    sb23.append(']');
                    sb23.append('\n');
                }
            } else if (t instanceof double[]) {
                double[] dArr = (double[]) t;
                a(str);
                if (dArr == null) {
                    this.f6198a.append("null\n");
                } else if (dArr.length == 0) {
                    StringBuilder sb24 = this.f6198a;
                    sb24.append(dArr.length);
                    sb24.append(", []\n");
                } else {
                    StringBuilder sb25 = this.f6198a;
                    sb25.append(dArr.length);
                    sb25.append(", [\n");
                    h hVar5 = new h(this.f6198a, this.f6199b + 1);
                    int length5 = dArr.length;
                    while (i < length5) {
                        double d2 = dArr[i];
                        hVar5.a(null);
                        StringBuilder sb26 = hVar5.f6198a;
                        sb26.append(d2);
                        sb26.append('\n');
                        i++;
                    }
                    a(null);
                    StringBuilder sb27 = this.f6198a;
                    sb27.append(']');
                    sb27.append('\n');
                }
            } else if (t.getClass().isArray()) {
                a((Object[]) t, str);
            } else {
                throw new b("write object error: unsupport type.");
            }
        }
        return this;
    }

    public final h a(k kVar, String str) {
        a(str);
        StringBuilder sb = this.f6198a;
        sb.append('{');
        sb.append('\n');
        if (kVar == null) {
            StringBuilder sb2 = this.f6198a;
            sb2.append('\t');
            sb2.append("null");
        } else {
            kVar.a(this.f6198a, this.f6199b + 1);
        }
        a(null);
        StringBuilder sb3 = this.f6198a;
        sb3.append('}');
        sb3.append('\n');
        return this;
    }
}

package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bm;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* compiled from: TDeserializer.java */
/* loaded from: classes2.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    private final bs f6405a;

    /* renamed from: b  reason: collision with root package name */
    private final cf f6406b;

    public aw() {
        this(new bm.a());
    }

    public aw(bu buVar) {
        cf cfVar = new cf();
        this.f6406b = cfVar;
        this.f6405a = buVar.a(cfVar);
    }

    public void a(at atVar, byte[] bArr) {
        try {
            this.f6406b.a(bArr);
            atVar.read(this.f6405a);
        } finally {
            this.f6406b.e();
            this.f6405a.B();
        }
    }

    public void a(at atVar, String str, String str2) {
        try {
            try {
                a(atVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new az("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.f6405a.B();
        }
    }

    public void a(at atVar, byte[] bArr, ba baVar, ba... baVarArr) {
        try {
            try {
                if (j(bArr, baVar, baVarArr) != null) {
                    atVar.read(this.f6405a);
                }
            } catch (Exception e2) {
                throw new az(e2);
            }
        } finally {
            this.f6406b.e();
            this.f6405a.B();
        }
    }

    public Boolean a(byte[] bArr, ba baVar, ba... baVarArr) {
        return (Boolean) a((byte) 2, bArr, baVar, baVarArr);
    }

    public Byte b(byte[] bArr, ba baVar, ba... baVarArr) {
        return (Byte) a((byte) 3, bArr, baVar, baVarArr);
    }

    public Double c(byte[] bArr, ba baVar, ba... baVarArr) {
        return (Double) a((byte) 4, bArr, baVar, baVarArr);
    }

    public Short d(byte[] bArr, ba baVar, ba... baVarArr) {
        return (Short) a((byte) 6, bArr, baVar, baVarArr);
    }

    public Integer e(byte[] bArr, ba baVar, ba... baVarArr) {
        return (Integer) a((byte) 8, bArr, baVar, baVarArr);
    }

    public Long f(byte[] bArr, ba baVar, ba... baVarArr) {
        return (Long) a((byte) 10, bArr, baVar, baVarArr);
    }

    public String g(byte[] bArr, ba baVar, ba... baVarArr) {
        return (String) a((byte) 11, bArr, baVar, baVarArr);
    }

    public ByteBuffer h(byte[] bArr, ba baVar, ba... baVarArr) {
        return (ByteBuffer) a((byte) 100, bArr, baVar, baVarArr);
    }

    public Short i(byte[] bArr, ba baVar, ba... baVarArr) {
        Short sh;
        try {
            try {
                if (j(bArr, baVar, baVarArr) != null) {
                    this.f6405a.j();
                    sh = Short.valueOf(this.f6405a.l().f6458c);
                } else {
                    sh = null;
                }
                return sh;
            } catch (Exception e2) {
                throw new az(e2);
            }
        } finally {
            this.f6406b.e();
            this.f6405a.B();
        }
    }

    private Object a(byte b2, byte[] bArr, ba baVar, ba... baVarArr) {
        Object obj;
        try {
            try {
                bn j = j(bArr, baVar, baVarArr);
                if (j != null) {
                    if (b2 != 2) {
                        if (b2 != 3) {
                            if (b2 != 4) {
                                if (b2 != 6) {
                                    if (b2 != 8) {
                                        if (b2 != 100) {
                                            if (b2 == 10) {
                                                if (j.f6457b == 10) {
                                                    obj = Long.valueOf(this.f6405a.x());
                                                }
                                            } else if (b2 == 11 && j.f6457b == 11) {
                                                obj = this.f6405a.z();
                                            }
                                        } else if (j.f6457b == 11) {
                                            obj = this.f6405a.A();
                                        }
                                    } else if (j.f6457b == 8) {
                                        obj = Integer.valueOf(this.f6405a.w());
                                    }
                                } else if (j.f6457b == 6) {
                                    obj = Short.valueOf(this.f6405a.v());
                                }
                            } else if (j.f6457b == 4) {
                                obj = Double.valueOf(this.f6405a.y());
                            }
                        } else if (j.f6457b == 3) {
                            obj = Byte.valueOf(this.f6405a.u());
                        }
                    } else if (j.f6457b == 2) {
                        obj = Boolean.valueOf(this.f6405a.t());
                    }
                    return obj;
                }
                obj = null;
                return obj;
            } catch (Exception e2) {
                throw new az(e2);
            }
        } finally {
            this.f6406b.e();
            this.f6405a.B();
        }
    }

    private bn j(byte[] bArr, ba baVar, ba... baVarArr) {
        this.f6406b.a(bArr);
        int length = baVarArr.length + 1;
        ba[] baVarArr2 = new ba[length];
        int i = 0;
        baVarArr2[0] = baVar;
        int i2 = 0;
        while (i2 < baVarArr.length) {
            int i3 = i2 + 1;
            baVarArr2[i3] = baVarArr[i2];
            i2 = i3;
        }
        this.f6405a.j();
        bn bnVar = null;
        while (i < length) {
            bnVar = this.f6405a.l();
            if (bnVar.f6457b == 0 || bnVar.f6458c > baVarArr2[i].a()) {
                return null;
            }
            if (bnVar.f6458c != baVarArr2[i].a()) {
                bv.a(this.f6405a, bnVar.f6457b);
                this.f6405a.m();
            } else {
                i++;
                if (i < length) {
                    this.f6405a.j();
                }
            }
        }
        return bnVar;
    }

    public void a(at atVar, String str) {
        a(atVar, str.getBytes());
    }
}

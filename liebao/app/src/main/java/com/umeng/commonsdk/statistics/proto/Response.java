package com.umeng.commonsdk.statistics.proto;

import cn.jpush.android.api.JThirdPlatFormInterface;
import com.umeng.analytics.pro.ak;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.ba;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bg;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bn;
import com.umeng.analytics.pro.bs;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class Response implements at<Response, e>, Serializable, Cloneable {
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<e, bf> metaDataMap;
    private static final Map<Class<? extends ca>, cb> schemes;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public com.umeng.commonsdk.statistics.proto.d imprint;
    public String msg;
    private e[] optionals;
    public int resp_code;
    private static final bx STRUCT_DESC = new bx("Response");
    private static final bn RESP_CODE_FIELD_DESC = new bn("resp_code", (byte) 8, 1);
    private static final bn MSG_FIELD_DESC = new bn(JThirdPlatFormInterface.KEY_MSG, (byte) 11, 2);
    private static final bn IMPRINT_FIELD_DESC = new bn(ak.X, (byte) 12, 3);

    static {
        HashMap hashMap = new HashMap();
        schemes = hashMap;
        hashMap.put(cc.class, new b());
        schemes.put(cd.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.RESP_CODE, (e) new bf("resp_code", (byte) 1, new bg((byte) 8)));
        enumMap.put((EnumMap) e.MSG, (e) new bf(JThirdPlatFormInterface.KEY_MSG, (byte) 2, new bg((byte) 11)));
        enumMap.put((EnumMap) e.IMPRINT, (e) new bf(ak.X, (byte) 2, new bk((byte) 12, com.umeng.commonsdk.statistics.proto.d.class)));
        Map<e, bf> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        metaDataMap = unmodifiableMap;
        bf.a(Response.class, unmodifiableMap);
    }

    /* loaded from: classes2.dex */
    public enum e implements ba {
        RESP_CODE(1, "resp_code"),
        MSG(2, JThirdPlatFormInterface.KEY_MSG),
        IMPRINT(3, ak.X);
        

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, e> f6896d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private final short f6897e;
        private final String f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f6896d.put(eVar.b(), eVar);
            }
        }

        public static e a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return IMPRINT;
                }
                return MSG;
            }
            return RESP_CODE;
        }

        public static e b(int i) {
            e a2 = a(i);
            if (a2 != null) {
                return a2;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        public static e a(String str) {
            return f6896d.get(str);
        }

        e(short s, String str) {
            this.f6897e = s;
            this.f = str;
        }

        @Override // com.umeng.analytics.pro.ba
        public short a() {
            return this.f6897e;
        }

        @Override // com.umeng.analytics.pro.ba
        public String b() {
            return this.f;
        }
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
    }

    public Response(int i) {
        this();
        this.resp_code = i;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new e[]{e.MSG, e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new com.umeng.commonsdk.statistics.proto.d(response.imprint);
        }
    }

    @Override // com.umeng.analytics.pro.at
    public at<Response, e> deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.at
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public Response setResp_code(int i) {
        this.resp_code = i;
        setResp_codeIsSet(true);
        return this;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = aq.b(this.__isset_bitfield, 0);
    }

    public boolean isSetResp_code() {
        return aq.a(this.__isset_bitfield, 0);
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = aq.a(this.__isset_bitfield, 0, z);
    }

    public String getMsg() {
        return this.msg;
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public void setMsgIsSet(boolean z) {
        if (z) {
            return;
        }
        this.msg = null;
    }

    public com.umeng.commonsdk.statistics.proto.d getImprint() {
        return this.imprint;
    }

    public Response setImprint(com.umeng.commonsdk.statistics.proto.d dVar) {
        this.imprint = dVar;
        return this;
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public void setImprintIsSet(boolean z) {
        if (z) {
            return;
        }
        this.imprint = null;
    }

    @Override // com.umeng.analytics.pro.at
    public e fieldForId(int i) {
        return e.a(i);
    }

    @Override // com.umeng.analytics.pro.at
    public void read(bs bsVar) {
        schemes.get(bsVar.D()).b().b(bsVar, this);
    }

    @Override // com.umeng.analytics.pro.at
    public void write(bs bsVar) {
        schemes.get(bsVar.D()).b().a(bsVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
            if (dVar == null) {
                sb.append("null");
            } else {
                sb.append(dVar);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void validate() {
        com.umeng.commonsdk.statistics.proto.d dVar = this.imprint;
        if (dVar != null) {
            dVar.l();
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        try {
            write(new bm(new ce(objectOutputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new bm(new ce(objectInputStream)));
        } catch (az e2) {
            throw new IOException(e2.getMessage());
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements cb {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cb
        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends cc<Response> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: a */
        public void b(bs bsVar, Response response) {
            bsVar.j();
            while (true) {
                bn l = bsVar.l();
                if (l.f6457b == 0) {
                    break;
                }
                short s = l.f6458c;
                if (s != 1) {
                    if (s != 2) {
                        if (s == 3) {
                            if (l.f6457b == 12) {
                                response.imprint = new com.umeng.commonsdk.statistics.proto.d();
                                response.imprint.read(bsVar);
                                response.setImprintIsSet(true);
                            } else {
                                bv.a(bsVar, l.f6457b);
                            }
                        } else {
                            bv.a(bsVar, l.f6457b);
                        }
                    } else if (l.f6457b == 11) {
                        response.msg = bsVar.z();
                        response.setMsgIsSet(true);
                    } else {
                        bv.a(bsVar, l.f6457b);
                    }
                } else if (l.f6457b == 8) {
                    response.resp_code = bsVar.w();
                    response.setResp_codeIsSet(true);
                } else {
                    bv.a(bsVar, l.f6457b);
                }
                bsVar.m();
            }
            bsVar.k();
            if (!response.isSetResp_code()) {
                throw new bt("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
            }
            response.validate();
        }

        @Override // com.umeng.analytics.pro.ca
        /* renamed from: b */
        public void a(bs bsVar, Response response) {
            response.validate();
            bsVar.a(Response.STRUCT_DESC);
            bsVar.a(Response.RESP_CODE_FIELD_DESC);
            bsVar.a(response.resp_code);
            bsVar.c();
            if (response.msg != null && response.isSetMsg()) {
                bsVar.a(Response.MSG_FIELD_DESC);
                bsVar.a(response.msg);
                bsVar.c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                bsVar.a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(bsVar);
                bsVar.c();
            }
            bsVar.d();
            bsVar.b();
        }
    }

    /* loaded from: classes2.dex */
    private static class d implements cb {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cb
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c extends cd<Response> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.ca
        public void a(bs bsVar, Response response) {
            by byVar = (by) bsVar;
            byVar.a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            byVar.a(bitSet, 2);
            if (response.isSetMsg()) {
                byVar.a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(byVar);
            }
        }

        @Override // com.umeng.analytics.pro.ca
        public void b(bs bsVar, Response response) {
            by byVar = (by) bsVar;
            response.resp_code = byVar.w();
            response.setResp_codeIsSet(true);
            BitSet b2 = byVar.b(2);
            if (b2.get(0)) {
                response.msg = byVar.z();
                response.setMsgIsSet(true);
            }
            if (b2.get(1)) {
                response.imprint = new com.umeng.commonsdk.statistics.proto.d();
                response.imprint.read(byVar);
                response.setImprintIsSet(true);
            }
        }
    }
}

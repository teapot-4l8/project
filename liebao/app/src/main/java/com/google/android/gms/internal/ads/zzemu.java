package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
/* loaded from: classes.dex */
public enum zzemu {
    DOUBLE(0, zzemw.SCALAR, zzenp.DOUBLE),
    FLOAT(1, zzemw.SCALAR, zzenp.FLOAT),
    INT64(2, zzemw.SCALAR, zzenp.LONG),
    UINT64(3, zzemw.SCALAR, zzenp.LONG),
    INT32(4, zzemw.SCALAR, zzenp.INT),
    FIXED64(5, zzemw.SCALAR, zzenp.LONG),
    FIXED32(6, zzemw.SCALAR, zzenp.INT),
    BOOL(7, zzemw.SCALAR, zzenp.BOOLEAN),
    STRING(8, zzemw.SCALAR, zzenp.STRING),
    MESSAGE(9, zzemw.SCALAR, zzenp.MESSAGE),
    BYTES(10, zzemw.SCALAR, zzenp.BYTE_STRING),
    UINT32(11, zzemw.SCALAR, zzenp.INT),
    ENUM(12, zzemw.SCALAR, zzenp.ENUM),
    SFIXED32(13, zzemw.SCALAR, zzenp.INT),
    SFIXED64(14, zzemw.SCALAR, zzenp.LONG),
    SINT32(15, zzemw.SCALAR, zzenp.INT),
    SINT64(16, zzemw.SCALAR, zzenp.LONG),
    GROUP(17, zzemw.SCALAR, zzenp.MESSAGE),
    DOUBLE_LIST(18, zzemw.VECTOR, zzenp.DOUBLE),
    FLOAT_LIST(19, zzemw.VECTOR, zzenp.FLOAT),
    INT64_LIST(20, zzemw.VECTOR, zzenp.LONG),
    UINT64_LIST(21, zzemw.VECTOR, zzenp.LONG),
    INT32_LIST(22, zzemw.VECTOR, zzenp.INT),
    FIXED64_LIST(23, zzemw.VECTOR, zzenp.LONG),
    FIXED32_LIST(24, zzemw.VECTOR, zzenp.INT),
    BOOL_LIST(25, zzemw.VECTOR, zzenp.BOOLEAN),
    STRING_LIST(26, zzemw.VECTOR, zzenp.STRING),
    MESSAGE_LIST(27, zzemw.VECTOR, zzenp.MESSAGE),
    BYTES_LIST(28, zzemw.VECTOR, zzenp.BYTE_STRING),
    UINT32_LIST(29, zzemw.VECTOR, zzenp.INT),
    ENUM_LIST(30, zzemw.VECTOR, zzenp.ENUM),
    SFIXED32_LIST(31, zzemw.VECTOR, zzenp.INT),
    SFIXED64_LIST(32, zzemw.VECTOR, zzenp.LONG),
    SINT32_LIST(33, zzemw.VECTOR, zzenp.INT),
    SINT64_LIST(34, zzemw.VECTOR, zzenp.LONG),
    DOUBLE_LIST_PACKED(35, zzemw.PACKED_VECTOR, zzenp.DOUBLE),
    FLOAT_LIST_PACKED(36, zzemw.PACKED_VECTOR, zzenp.FLOAT),
    INT64_LIST_PACKED(37, zzemw.PACKED_VECTOR, zzenp.LONG),
    UINT64_LIST_PACKED(38, zzemw.PACKED_VECTOR, zzenp.LONG),
    INT32_LIST_PACKED(39, zzemw.PACKED_VECTOR, zzenp.INT),
    FIXED64_LIST_PACKED(40, zzemw.PACKED_VECTOR, zzenp.LONG),
    FIXED32_LIST_PACKED(41, zzemw.PACKED_VECTOR, zzenp.INT),
    BOOL_LIST_PACKED(42, zzemw.PACKED_VECTOR, zzenp.BOOLEAN),
    UINT32_LIST_PACKED(43, zzemw.PACKED_VECTOR, zzenp.INT),
    ENUM_LIST_PACKED(44, zzemw.PACKED_VECTOR, zzenp.ENUM),
    SFIXED32_LIST_PACKED(45, zzemw.PACKED_VECTOR, zzenp.INT),
    SFIXED64_LIST_PACKED(46, zzemw.PACKED_VECTOR, zzenp.LONG),
    SINT32_LIST_PACKED(47, zzemw.PACKED_VECTOR, zzenp.INT),
    SINT64_LIST_PACKED(48, zzemw.PACKED_VECTOR, zzenp.LONG),
    GROUP_LIST(49, zzemw.VECTOR, zzenp.MESSAGE),
    MAP(50, zzemw.MAP, zzenp.VOID);
    
    private static final zzemu[] zzisz;
    private static final Type[] zzita = new Type[0];
    private final int id;
    private final zzenp zzisv;
    private final zzemw zzisw;
    private final Class<?> zzisx;
    private final boolean zzisy;

    zzemu(int i, zzemw zzemwVar, zzenp zzenpVar) {
        int i2;
        this.id = i;
        this.zzisw = zzemwVar;
        this.zzisv = zzenpVar;
        int i3 = zzemx.zziti[zzemwVar.ordinal()];
        boolean z = true;
        if (i3 == 1) {
            this.zzisx = zzenpVar.zzbkj();
        } else if (i3 == 2) {
            this.zzisx = zzenpVar.zzbkj();
        } else {
            this.zzisx = null;
        }
        this.zzisy = (zzemwVar != zzemw.SCALAR || (i2 = zzemx.zzitj[zzenpVar.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : false;
    }

    public final int id() {
        return this.id;
    }

    static {
        zzemu[] values = values();
        zzisz = new zzemu[values.length];
        for (zzemu zzemuVar : values) {
            zzisz[zzemuVar.id] = zzemuVar;
        }
    }
}

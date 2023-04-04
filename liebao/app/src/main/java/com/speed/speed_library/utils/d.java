package com.speed.speed_library.utils;

import android.text.TextUtils;
import android.util.Base64;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.d.b.i;

/* compiled from: EncodeUtils.kt */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f5865a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static final String f5866b = f5866b;

    /* renamed from: b  reason: collision with root package name */
    private static final String f5866b = f5866b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f5867c = f5867c;

    /* renamed from: c  reason: collision with root package name */
    private static final String f5867c = f5867c;

    /* renamed from: d  reason: collision with root package name */
    private static final String f5868d = f5868d;

    /* renamed from: d  reason: collision with root package name */
    private static final String f5868d = f5868d;

    /* renamed from: e  reason: collision with root package name */
    private static final String f5869e = f5869e;

    /* renamed from: e  reason: collision with root package name */
    private static final String f5869e = f5869e;
    private static final String f = f;
    private static final String f = f;

    private d() {
    }

    public final String a(String str) {
        if (str != null) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bytes = str.getBytes(kotlin.h.d.f7190a);
                i.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                if (messageDigest == null) {
                    i.a();
                }
                byte[] digest = messageDigest.digest(bytes);
                StringBuilder sb = new StringBuilder();
                for (byte b2 : digest) {
                    int i = b2 & 255;
                    if (i < 16) {
                        sb.append("0");
                    }
                    sb.append(Integer.toHexString(i));
                }
                String sb2 = sb.toString();
                i.a((Object) sb2, "hexValue.toString()");
                return sb2;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public final String a(String str, String str2, String str3) {
        i.b(str, "content");
        i.b(str2, "password");
        i.b(str3, "iv");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] bytes = str.getBytes(kotlin.h.d.f7190a);
            i.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] decode = Base64.decode(bytes, 0);
            byte[] bytes2 = str2.getBytes(kotlin.h.d.f7190a);
            i.a((Object) bytes2, "(this as java.lang.String).getBytes(charset)");
            SecretKeySpec secretKeySpec = new SecretKeySpec(bytes2, f5866b);
            Cipher cipher = Cipher.getInstance(f);
            byte[] bytes3 = str3.getBytes(kotlin.h.d.f7190a);
            i.a((Object) bytes3, "(this as java.lang.String).getBytes(charset)");
            cipher.init(2, secretKeySpec, new IvParameterSpec(bytes3));
            byte[] doFinal = cipher.doFinal(decode);
            i.a((Object) doFinal, "cipher.doFinal(contentByte)");
            return new String(doFinal, kotlin.h.d.f7190a);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }
}

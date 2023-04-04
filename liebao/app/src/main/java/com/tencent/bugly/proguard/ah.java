package com.tencent.bugly.proguard;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class ah implements aj {

    /* renamed from: a  reason: collision with root package name */
    private String f6139a = null;

    @Override // com.tencent.bugly.proguard.aj
    public final byte[] a(byte[] bArr) {
        if (this.f6139a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(((int) b2) + " ");
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.f6139a.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(this.f6139a.getBytes()));
        byte[] doFinal = cipher.doFinal(bArr);
        StringBuffer stringBuffer2 = new StringBuffer();
        for (byte b3 : doFinal) {
            stringBuffer2.append(((int) b3) + " ");
        }
        return doFinal;
    }

    @Override // com.tencent.bugly.proguard.aj
    public final byte[] b(byte[] bArr) {
        if (this.f6139a == null || bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b2 : bArr) {
            stringBuffer.append(((int) b2) + " ");
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.f6139a.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(this.f6139a.getBytes()));
        byte[] doFinal = cipher.doFinal(bArr);
        StringBuffer stringBuffer2 = new StringBuffer();
        for (byte b3 : doFinal) {
            stringBuffer2.append(((int) b3) + " ");
        }
        return doFinal;
    }

    @Override // com.tencent.bugly.proguard.aj
    public final void a(String str) {
        if (str != null) {
            for (int length = str.length(); length < 16; length++) {
                str = str + "0";
            }
            this.f6139a = str.substring(0, 16);
        }
    }
}

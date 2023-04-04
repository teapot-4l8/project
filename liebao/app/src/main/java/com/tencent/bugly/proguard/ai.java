package com.tencent.bugly.proguard;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public final class ai implements aj {

    /* renamed from: a  reason: collision with root package name */
    private String f6140a = null;

    @Override // com.tencent.bugly.proguard.aj
    public final byte[] a(byte[] bArr) {
        if (this.f6140a == null || bArr == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f6140a.getBytes("UTF-8"))), new IvParameterSpec(this.f6140a.getBytes("UTF-8")));
        return cipher.doFinal(bArr);
    }

    @Override // com.tencent.bugly.proguard.aj
    public final byte[] b(byte[] bArr) {
        if (this.f6140a == null || bArr == null) {
            return null;
        }
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(this.f6140a.getBytes("UTF-8"))), new IvParameterSpec(this.f6140a.getBytes("UTF-8")));
        return cipher.doFinal(bArr);
    }

    @Override // com.tencent.bugly.proguard.aj
    public final void a(String str) {
        if (str != null) {
            this.f6140a = str;
        }
    }
}

package com.orhanobut.hawk;

import android.content.Context;
import android.util.Base64;
import com.facebook.a.a.a.a;
import com.facebook.a.a.a.d;
import com.facebook.crypto.c;
import com.facebook.crypto.f;
import com.facebook.crypto.g;

/* loaded from: classes2.dex */
class ConcealEncryption implements Encryption {
    private final c crypto;

    public ConcealEncryption(Context context) {
        this.crypto = a.a().a(new d(context, f.KEY_256));
    }

    @Override // com.orhanobut.hawk.Encryption
    public boolean init() {
        return this.crypto.a();
    }

    @Override // com.orhanobut.hawk.Encryption
    public String encrypt(String str, String str2) {
        return Base64.encodeToString(this.crypto.a(str2.getBytes(), g.a(str)), 2);
    }

    @Override // com.orhanobut.hawk.Encryption
    public String decrypt(String str, String str2) {
        g a2 = g.a(str);
        return new String(this.crypto.b(Base64.decode(str2, 2), a2));
    }
}

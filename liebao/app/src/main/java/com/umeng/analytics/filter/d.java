package com.umeng.analytics.filter;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: SmartDict.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private static final String f6331b = "Ă";

    /* renamed from: c  reason: collision with root package name */
    private MessageDigest f6333c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6335e;

    /* renamed from: a  reason: collision with root package name */
    private final String f6332a = "MD5";

    /* renamed from: d  reason: collision with root package name */
    private Set<Object> f6334d = new HashSet();

    public d(boolean z, String str) {
        int i = 0;
        this.f6335e = false;
        this.f6335e = z;
        try {
            this.f6333c = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
        }
        if (str != null) {
            if (z) {
                try {
                    byte[] decode = Base64.decode(str.getBytes(), 0);
                    while (i < decode.length / 4) {
                        int i2 = i * 4;
                        this.f6334d.add(Integer.valueOf(((decode[i2 + 0] & 255) << 24) + ((decode[i2 + 1] & 255) << 16) + ((decode[i2 + 2] & 255) << 8) + (decode[i2 + 3] & 255)));
                        i++;
                    }
                    return;
                } catch (IllegalArgumentException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            String[] split = str.split(f6331b);
            int length = split.length;
            while (i < length) {
                this.f6334d.add(split[i]);
                i++;
            }
        }
    }

    private Integer c(String str) {
        try {
            this.f6333c.update(str.getBytes());
            byte[] digest = this.f6333c.digest();
            return Integer.valueOf(((digest[0] & 255) << 24) + ((digest[1] & 255) << 16) + ((digest[2] & 255) << 8) + (digest[3] & 255));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public boolean a(String str) {
        if (this.f6335e) {
            return this.f6334d.contains(c(str));
        }
        return this.f6334d.contains(str);
    }

    public void b(String str) {
        if (this.f6335e) {
            this.f6334d.add(c(str));
        } else {
            this.f6334d.add(str);
        }
    }

    public void a() {
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.f6334d) {
            sb.append(obj);
            if (sb.length() > 0) {
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }

    public String toString() {
        if (this.f6335e) {
            byte[] bArr = new byte[this.f6334d.size() * 4];
            Iterator<Object> it = this.f6334d.iterator();
            int i = 0;
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                int i2 = i + 1;
                bArr[i] = (byte) (((-16777216) & intValue) >> 24);
                int i3 = i2 + 1;
                bArr[i2] = (byte) ((16711680 & intValue) >> 16);
                int i4 = i3 + 1;
                bArr[i3] = (byte) ((65280 & intValue) >> 8);
                i = i4 + 1;
                bArr[i4] = (byte) (intValue & 255);
            }
            return new String(Base64.encode(bArr, 0));
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : this.f6334d) {
            if (sb.length() > 0) {
                sb.append(f6331b);
            }
            sb.append(obj.toString());
        }
        return sb.toString();
    }
}

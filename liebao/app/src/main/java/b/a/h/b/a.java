package b.a.h.b;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.HashMap;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap f3225a = new HashMap();

    public a() {
        a();
    }

    private void a() {
        this.f3225a.put("cF", "opof");
        this.f3225a.put("aI", "ihse");
        this.f3225a.put("pp", "bolq");
        this.f3225a.put("pbH", "pwcf");
        this.f3225a.put("pbT", "aviw");
        this.f3225a.put("gR", "nosw");
        this.f3225a.put("mI", "capq");
        this.f3225a.put("Pk", "jpaw");
        this.f3225a.put("fin", "kltz");
        this.f3225a.put("ul", "qpxs");
        this.f3225a.put("ts", "qmvzs");
        this.f3225a.put("iI", "f3ef");
        this.f3225a.put("dI", "jdfn");
        this.f3225a.put("mA", "dajg");
        this.f3225a.put("sN", "kfgf");
        this.f3225a.put("andI", "mthe");
        this.f3225a.put("md", "ntrh");
        this.f3225a.put("bI", "regh");
        this.f3225a.put("bd", "krtn");
        this.f3225a.put("buiD", "mrth");
        this.f3225a.put("ver", "kjfe");
        this.f3225a.put("verI", "hwef");
        this.f3225a.put("wid", "efef");
        this.f3225a.put("hei", "efaa");
        this.f3225a.put("apV", "fefb");
        this.f3225a.put("ioA", "fafh");
        this.f3225a.put("im", "xefb");
        this.f3225a.put("oa", "effj");
        this.f3225a.put("ga", "feem");
        this.f3225a.put("loI", "fuqd");
        this.f3225a.put("im2", "bwfx");
        this.f3225a.put("si", "bnwp");
        this.f3225a.put("waU", "wpxk");
        this.f3225a.put("verS", "vsna");
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (String) this.f3225a.get(str);
    }

    public String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bArr = {-4, 110, 4, -38, -91, 80, -53, 111, 30, -30, -48, -69, -66, 0, 67, -63, -48, -79, 83, -104, 75, 58, -36, Byte.MAX_VALUE, -37, -82, -69, -22, -10, 70, 19, 83, 112, 43, 124, -73, 85, 79, -123, -87, -19, -26, -66, 101, -42, 64, 112, -60, 67, -25, -14, -63, -53, -62, 21, -105, Byte.MIN_VALUE, -8, -62, -64, 44, -69, 21, -23};
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ bArr[i % 64]);
        }
        return b.a.k.a.a().a().b(bytes);
    }
}

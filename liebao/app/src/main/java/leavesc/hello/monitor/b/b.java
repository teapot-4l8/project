package leavesc.hello.monitor.b;

import android.text.TextUtils;
import android.util.Base64;
import cn.jpush.android.service.WakedResultReceiver;
import com.google.gson.JsonParser;
import com.umeng.analytics.pro.ak;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;

/* compiled from: FormatUtils.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final SimpleDateFormat f7228a = new SimpleDateFormat("HH:mm:ss SSS", Locale.CHINA);

    /* renamed from: b  reason: collision with root package name */
    private static final SimpleDateFormat f7229b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS", Locale.CHINA);

    private static String c(String str) {
        return str != null ? str : "";
    }

    private static String a(Date date, SimpleDateFormat simpleDateFormat) {
        return date == null ? "" : simpleDateFormat.format(date);
    }

    public static String a(Date date) {
        return a(date, f7228a);
    }

    public static String b(Date date) {
        return a(date, f7229b);
    }

    public static String a(long j) {
        return a(j, true);
    }

    private static String a(long j, boolean z) {
        int i = z ? 1000 : 1024;
        if (j < i) {
            return j + " B";
        }
        double d2 = j;
        double d3 = i;
        int log = (int) (Math.log(d2) / Math.log(d3));
        StringBuilder sb = new StringBuilder();
        sb.append((z ? "kMGTPE" : "KMGTPE").charAt(log - 1));
        sb.append(z ? "" : ak.aC);
        String sb2 = sb.toString();
        Locale locale = Locale.US;
        double pow = Math.pow(d3, log);
        Double.isNaN(d2);
        return String.format(locale, "%.1f %sB", Double.valueOf(d2 / pow), sb2);
    }

    public static String a(List<leavesc.hello.monitor.db.a.a> list, boolean z) {
        StringBuilder sb = new StringBuilder();
        if (list != null) {
            for (leavesc.hello.monitor.db.a.a aVar : list) {
                sb.append(z ? "<b>" : "");
                sb.append(aVar.a());
                sb.append(": ");
                sb.append(z ? "</b>" : "");
                sb.append(aVar.b());
                sb.append(z ? "<br />" : "\n");
            }
        }
        return sb.toString();
    }

    public static String a(String str, String str2) {
        if (str2 == null || !str2.toLowerCase().contains("json")) {
            return (str2 == null || !str2.toLowerCase().contains("xml")) ? str : b(str);
        }
        return a(str);
    }

    private static String a(String str) {
        try {
            return c.a().toJson(new JsonParser().parse(str));
        } catch (Exception unused) {
            return str;
        }
    }

    private static String b(String str) {
        try {
            Transformer newTransformer = SAXTransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", WakedResultReceiver.WAKE_TYPE_KEY);
            SAXSource sAXSource = new SAXSource(new InputSource(new ByteArrayInputStream(str.getBytes())));
            StreamResult streamResult = new StreamResult(new ByteArrayOutputStream());
            newTransformer.transform(sAXSource, streamResult);
            return new String(((ByteArrayOutputStream) streamResult.getOutputStream()).toByteArray());
        } catch (Exception unused) {
            return str;
        }
    }

    public static String a(leavesc.hello.monitor.db.a.b bVar) {
        String str = ((((((((((((((("Url: " + c(bVar.n()) + "\n") + "Method: " + c(bVar.m()) + "\n") + "Protocol: " + c(bVar.r()) + "\n") + "Status: " + c(bVar.a().toString()) + "\n") + "Response: " + c(bVar.c()) + "\n") + "SSL: " + bVar.g() + "\n") + "\n") + "Request Time: " + b(bVar.j()) + "\n") + "Response Time: " + b(bVar.k()) + "\n") + "Duration: " + c(bVar.f()) + "\n") + "\n") + "Request Size: " + a(bVar.v()) + "\n") + "Response Size: " + a(bVar.C()) + "\n") + "Total Size: " + c(bVar.h()) + "\n") + "\n") + "---------- Request ----------\n\n";
        String a2 = bVar.a(false);
        if (!TextUtils.isEmpty(a2)) {
            str = str + a2 + "\n";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(bVar.w() ? c(bVar.d()) : "(encoded or binary body omitted)");
        String str2 = (sb.toString() + "\n") + "---------- Response ----------\n\n";
        String b2 = bVar.b(false);
        if (!TextUtils.isEmpty(b2)) {
            str2 = str2 + b2 + "\n";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(bVar.D() ? c(bVar.e()) : "(encoded or binary body omitted)");
        return sb2.toString();
    }

    public static String a(String str, String str2, String str3) {
        try {
            if (str2 == null) {
                System.out.print("Key为空null");
                return null;
            } else if (str2.length() != 16) {
                System.out.print("Key长度不是16位");
                return null;
            } else {
                SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(2, secretKeySpec, new IvParameterSpec(str3.getBytes()));
                try {
                    return new String(cipher.doFinal(Base64.decode(str.getBytes(), 0)));
                } catch (Exception e2) {
                    System.out.println(e2.toString());
                    return null;
                }
            }
        } catch (Exception e3) {
            System.out.println(e3.toString());
            return null;
        }
    }
}

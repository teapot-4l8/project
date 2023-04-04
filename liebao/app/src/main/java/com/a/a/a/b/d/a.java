package com.a.a.a.b.d;

import com.a.a.c.c;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/* compiled from: DefaultXmlFormatter.java */
/* loaded from: classes.dex */
public class a implements b {
    @Override // com.a.a.a.b
    public String a(String str) {
        if (str == null || str.trim().length() == 0) {
            throw new com.a.a.a.a("XML empty.");
        }
        try {
            StreamSource streamSource = new StreamSource(new StringReader(str));
            StreamResult streamResult = new StreamResult(new StringWriter());
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            newTransformer.setOutputProperty("indent", "yes");
            newTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", String.valueOf(4));
            newTransformer.transform(streamSource, streamResult);
            String obj = streamResult.getWriter().toString();
            return obj.replaceFirst(">", ">" + c.f4556a);
        } catch (Exception e2) {
            throw new com.a.a.a.a("Parse XML error. XML string:" + str, e2);
        }
    }
}

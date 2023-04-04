package kotlin.c;

import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.d.b.i;
import kotlin.g.c;

/* compiled from: ReadWrite.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final kotlin.g.b<String> a(BufferedReader bufferedReader) {
        i.b(bufferedReader, "$this$lineSequence");
        return c.a(new a(bufferedReader));
    }

    public static final String a(Reader reader) {
        i.b(reader, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        a(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        i.a((Object) stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    public static /* synthetic */ long a(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return a(reader, writer, i);
    }

    public static final long a(Reader reader, Writer writer, int i) {
        i.b(reader, "$this$copyTo");
        i.b(writer, "out");
        char[] cArr = new char[i];
        int read = reader.read(cArr);
        long j = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j += read;
            read = reader.read(cArr);
        }
        return j;
    }
}

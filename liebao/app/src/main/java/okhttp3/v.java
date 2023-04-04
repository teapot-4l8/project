package okhttp3;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* compiled from: MediaType.java */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f7720a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f7721b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    /* renamed from: c  reason: collision with root package name */
    private final String f7722c;

    /* renamed from: d  reason: collision with root package name */
    private final String f7723d;

    /* renamed from: e  reason: collision with root package name */
    private final String f7724e;
    @Nullable
    private final String f;

    private v(String str, String str2, String str3, @Nullable String str4) {
        this.f7722c = str;
        this.f7723d = str2;
        this.f7724e = str3;
        this.f = str4;
    }

    public static v a(String str) {
        Matcher matcher = f7720a.matcher(str);
        if (!matcher.lookingAt()) {
            throw new IllegalArgumentException("No subtype found for: \"" + str + '\"');
        }
        String lowerCase = matcher.group(1).toLowerCase(Locale.US);
        String lowerCase2 = matcher.group(2).toLowerCase(Locale.US);
        String str2 = null;
        Matcher matcher2 = f7721b.matcher(str);
        for (int end = matcher.end(); end < str.length(); end = matcher2.end()) {
            matcher2.region(end, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException("Parameter is not formatted correctly: \"" + str.substring(end) + "\" for: \"" + str + '\"');
            }
            String group = matcher2.group(1);
            if (group != null && group.equalsIgnoreCase("charset")) {
                String group2 = matcher2.group(2);
                if (group2 != null) {
                    if (group2.startsWith("'") && group2.endsWith("'") && group2.length() > 2) {
                        group2 = group2.substring(1, group2.length() - 1);
                    }
                } else {
                    group2 = matcher2.group(3);
                }
                if (str2 != null && !group2.equalsIgnoreCase(str2)) {
                    throw new IllegalArgumentException("Multiple charsets defined: \"" + str2 + "\" and: \"" + group2 + "\" for: \"" + str + '\"');
                }
                str2 = group2;
            }
        }
        return new v(str, lowerCase, lowerCase2, str2);
    }

    @Nullable
    public static v b(String str) {
        try {
            return a(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String a() {
        return this.f7723d;
    }

    @Nullable
    public Charset b() {
        return a((Charset) null);
    }

    @Nullable
    public Charset a(@Nullable Charset charset) {
        try {
            return this.f != null ? Charset.forName(this.f) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public String toString() {
        return this.f7722c;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof v) && ((v) obj).f7722c.equals(this.f7722c);
    }

    public int hashCode() {
        return this.f7722c.hashCode();
    }
}

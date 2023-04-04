package leavesc.hello.monitor.b;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import java.util.Date;

/* compiled from: JsonConverter.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private Gson f7230a;

    private c() {
        this.f7230a = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).registerTypeAdapter(Date.class, new DateTypeAdapter()).create();
    }

    public static Gson a() {
        return a.f7231a.f7230a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JsonConverter.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f7231a = new c();
    }
}

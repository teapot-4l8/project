package com.speed.speed_library.debug;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.speed.speed_library.R;
import com.speed.speed_library.b.g;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import kotlin.d.b.i;

/* compiled from: DebugSpeedLogActivity.kt */
/* loaded from: classes2.dex */
public final class DebugSpeedLogActivity extends com.speed.speed_library.a.a {
    private HashMap k;

    @Override // com.speed.speed_library.a.a
    public View d(int i) {
        if (this.k == null) {
            this.k = new HashMap();
        }
        View view = (View) this.k.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.k.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_debug_speed_log);
        l();
    }

    public final void l() {
        g gVar = g.f5610b;
        String m = m();
        if (m == null) {
            m = "";
        }
        gVar.d(m);
        TextView textView = (TextView) d(R.id.tv_speed_log);
        i.a((Object) textView, "tv_speed_log");
        textView.setText(g.f5610b.g());
        ((LinearLayout) d(R.id.ll_back)).setOnClickListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DebugSpeedLogActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DebugSpeedLogActivity.this.finish();
        }
    }

    public final String m() {
        File file = new File(getApplicationInfo().dataDir + '/' + com.speed.speed_library.speed.a.a() + ".log");
        if (file.exists()) {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), kotlin.h.d.f7190a);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            String a2 = kotlin.c.b.a((Reader) bufferedReader);
            bufferedReader.close();
            return a2;
        }
        return "";
    }
}

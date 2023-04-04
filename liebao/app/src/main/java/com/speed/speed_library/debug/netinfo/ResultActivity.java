package com.speed.speed_library.debug.netinfo;

import a.a.a.c.b;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.speed.speed_library.R;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ResultActivity extends c {
    private ContentLoadingProgressBar k;
    private RecyclerView l;
    private boolean m = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_result);
        setTitle("评测结果");
        ContentLoadingProgressBar contentLoadingProgressBar = (ContentLoadingProgressBar) findViewById(R.id.result_activity_pb);
        this.k = contentLoadingProgressBar;
        contentLoadingProgressBar.bringToFront();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.result_activity_rv);
        this.l = recyclerView;
        recyclerView.setHasFixedSize(true);
        final com.speed.speed_library.debug.netinfo.a.c cVar = new com.speed.speed_library.debug.netinfo.a.c(getApplicationContext(), R.layout.item_activity_result_rv);
        this.l.setAdapter(cVar);
        this.l.setLayoutManager(new LinearLayoutManager(getApplicationContext(), 1, false));
        this.k.b();
        a.a.a.a.a().a(getApplicationContext()).a(true).a(new a()).h().c().d().a(getIntent().getStringExtra("http"), new b() { // from class: com.speed.speed_library.debug.netinfo.ResultActivity.1
            @Override // a.a.a.c.b
            public void a(a.a.a.c.c cVar2, JSONObject jSONObject) {
                Context applicationContext = ResultActivity.this.getApplicationContext();
                Toast.makeText(applicationContext, cVar2.a() + " 评测成功", 0).show();
                cVar.a((com.speed.speed_library.debug.netinfo.a.c) new ResultBean(cVar2.a(), jSONObject.toString()));
            }

            @Override // a.a.a.c.b
            public void a(String str) {
                ResultActivity.this.m = true;
                Toast.makeText(ResultActivity.this.getApplicationContext(), str, 0).show();
            }

            @Override // a.a.a.c.b
            public void a(JSONObject jSONObject) {
                ResultActivity.this.m = true;
                ResultActivity.this.k.a();
                try {
                    Context applicationContext = ResultActivity.this.getApplicationContext();
                    Toast.makeText(applicationContext, "评测成功 总耗时" + jSONObject.getString("totalTime"), 0).show();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    @Override // androidx.appcompat.app.c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            if (this.m) {
                return super.onKeyDown(i, keyEvent);
            }
            Toast.makeText(getApplicationContext(), "客观稍等哦～～马上测试完成", 0).show();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}

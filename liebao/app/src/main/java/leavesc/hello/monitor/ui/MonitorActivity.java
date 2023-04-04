package leavesc.hello.monitor.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.e;
import androidx.lifecycle.s;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import leavesc.hello.monitor.R;
import leavesc.hello.monitor.a.a;

/* loaded from: classes2.dex */
public class MonitorActivity extends c {
    private leavesc.hello.monitor.c.a k;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_monitor);
        l();
        k();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final leavesc.hello.monitor.a.a aVar = new leavesc.hello.monitor.a.a(this);
        aVar.a(new a.c() { // from class: leavesc.hello.monitor.ui.MonitorActivity.1
            @Override // leavesc.hello.monitor.a.a.c
            public void a(int i, leavesc.hello.monitor.db.a.b bVar) {
                MonitorDetailsActivity.a(MonitorActivity.this, bVar.i());
            }
        });
        recyclerView.setAdapter(aVar);
        this.k.e().a(this, new s<List<leavesc.hello.monitor.db.a.b>>() { // from class: leavesc.hello.monitor.ui.MonitorActivity.2
            @Override // androidx.lifecycle.s
            public void a(List<leavesc.hello.monitor.db.a.b> list) {
                aVar.a(list);
            }
        });
    }

    private void k() {
        this.k = (leavesc.hello.monitor.c.a) z.a((e) this).a(leavesc.hello.monitor.c.a.class);
    }

    private void l() {
        a((Toolbar) findViewById(R.id.toolbar));
        androidx.appcompat.app.a c2 = c();
        if (c2 != null) {
            c2.a(true);
        }
        ((TextView) findViewById(R.id.tvToolbarTitle)).setText("Monitor");
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_monitor, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.clear) {
            this.k.b();
            this.k.c();
            return true;
        } else if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        } else {
            return true;
        }
    }
}

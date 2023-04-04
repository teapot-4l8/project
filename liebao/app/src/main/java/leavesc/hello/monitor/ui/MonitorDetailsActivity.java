package leavesc.hello.monitor.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.d;
import androidx.fragment.app.e;
import androidx.fragment.app.j;
import androidx.fragment.app.n;
import androidx.lifecycle.s;
import androidx.lifecycle.z;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;
import leavesc.hello.monitor.R;

/* loaded from: classes2.dex */
public class MonitorDetailsActivity extends c {
    private leavesc.hello.monitor.c.a k;
    private TextView l;
    private leavesc.hello.monitor.db.a.b m;

    public static void a(Context context, long j) {
        Intent intent = new Intent(context, MonitorDetailsActivity.class);
        intent.putExtra("keyId", j);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_monitor_details);
        k();
        l();
        this.k.a(getIntent().getLongExtra("keyId", 0L));
        this.k.f().a(this, new s<leavesc.hello.monitor.db.a.b>() { // from class: leavesc.hello.monitor.ui.MonitorDetailsActivity.1
            @Override // androidx.lifecycle.s
            public void a(leavesc.hello.monitor.db.a.b bVar) {
                MonitorDetailsActivity.this.m = bVar;
                if (bVar != null) {
                    MonitorDetailsActivity.this.l.setText(String.format("%s  %s", bVar.m(), bVar.p()));
                } else {
                    MonitorDetailsActivity.this.l.setText((CharSequence) null);
                }
            }
        });
    }

    private void k() {
        a((Toolbar) findViewById(R.id.toolbar));
        androidx.appcompat.app.a c2 = c();
        if (c2 != null) {
            c2.a(true);
        }
        this.l = (TextView) findViewById(R.id.tvToolbarTitle);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        a aVar = new a(j());
        aVar.a(leavesc.hello.monitor.ui.a.a(), "overview");
        aVar.a(b.a(), "request");
        aVar.a(b.b(), "response");
        viewPager.setAdapter(aVar);
        ((TabLayout) findViewById(R.id.tabs)).setupWithViewPager(viewPager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends n {

        /* renamed from: a  reason: collision with root package name */
        private List<d> f7271a;

        /* renamed from: b  reason: collision with root package name */
        private List<String> f7272b;

        private a(j jVar) {
            super(jVar);
            this.f7271a = new ArrayList();
            this.f7272b = new ArrayList();
        }

        void a(d dVar, String str) {
            this.f7271a.add(dVar);
            this.f7272b.add(str);
        }

        @Override // androidx.fragment.app.n
        public d a(int i) {
            return this.f7271a.get(i);
        }

        @Override // androidx.viewpager.widget.a
        public int b() {
            return this.f7271a.size();
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence c(int i) {
            return this.f7272b.get(i);
        }
    }

    private void l() {
        this.k = (leavesc.hello.monitor.c.a) z.a((e) this).a(leavesc.hello.monitor.c.a.class);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_share, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.share) {
            leavesc.hello.monitor.db.a.b bVar = this.m;
            if (bVar != null) {
                a(leavesc.hello.monitor.b.b.a(bVar));
                return true;
            }
            return true;
        } else if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        } else {
            return true;
        }
    }

    private void a(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, null));
    }
}

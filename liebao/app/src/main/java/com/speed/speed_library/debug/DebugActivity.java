package com.speed.speed_library.debug;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import androidx.fragment.app.j;
import androidx.fragment.app.p;
import com.speed.speed_library.R;
import java.util.HashMap;
import kotlin.d.b.i;

/* compiled from: DebugActivity.kt */
/* loaded from: classes2.dex */
public final class DebugActivity extends com.speed.speed_library.a.a implements CompoundButton.OnCheckedChangeListener {
    public j k;
    private final String l = "app";
    private final String m = "general";
    private final String n = "routes";
    private final String o = "interfaces";
    private androidx.fragment.app.d p;

    /* renamed from: q  reason: collision with root package name */
    private androidx.fragment.app.d f5661q;
    private androidx.fragment.app.d r;
    private androidx.fragment.app.d s;
    private androidx.fragment.app.d t;
    private HashMap u;

    @Override // com.speed.speed_library.a.a
    public View d(int i) {
        if (this.u == null) {
            this.u = new HashMap();
        }
        View view = (View) this.u.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            this.u.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.speed.speed_library.a.a, com.trello.rxlifecycle3.components.a.a, androidx.appcompat.app.c, androidx.fragment.app.e, androidx.activity.b, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_debug);
        l();
        a(bundle);
        m();
    }

    public final void l() {
        j j = j();
        i.a((Object) j, "supportFragmentManager");
        this.k = j;
    }

    public final void m() {
        DebugActivity debugActivity = this;
        ((RadioButton) d(R.id.tab_debug_app)).setOnCheckedChangeListener(debugActivity);
        ((RadioButton) d(R.id.tab_debug_general)).setOnCheckedChangeListener(debugActivity);
        ((RadioButton) d(R.id.tab_debug_routes)).setOnCheckedChangeListener(debugActivity);
        ((RadioButton) d(R.id.tab_debug_interfaces)).setOnCheckedChangeListener(debugActivity);
    }

    private final void a(Bundle bundle) {
        if (bundle != null) {
            try {
                j jVar = this.k;
                if (jVar == null) {
                    i.b("mFragmentManager");
                }
                androidx.fragment.app.d a2 = jVar.a(this.l);
                this.p = a2;
                this.t = a2;
                j jVar2 = this.k;
                if (jVar2 == null) {
                    i.b("mFragmentManager");
                }
                this.f5661q = jVar2.a(this.m);
                j jVar3 = this.k;
                if (jVar3 == null) {
                    i.b("mFragmentManager");
                }
                this.r = jVar3.a(this.n);
                j jVar4 = this.k;
                if (jVar4 == null) {
                    i.b("mFragmentManager");
                }
                this.s = jVar4.a(this.o);
                if (this.t == null) {
                    a a3 = a.f5666b.a();
                    this.p = a3;
                    this.t = a3;
                }
                if (this.f5661q == null) {
                    this.f5661q = b.f5668b.a();
                }
                if (this.r == null) {
                    this.r = d.f5677b.a();
                }
                if (this.s == null) {
                    this.s = c.f5672b.a();
                }
                j jVar5 = this.k;
                if (jVar5 == null) {
                    i.b("mFragmentManager");
                }
                p a4 = jVar5 != null ? jVar5.a() : null;
                androidx.fragment.app.d dVar = this.p;
                if (dVar == null) {
                    i.a();
                }
                p b2 = a4.b(dVar);
                androidx.fragment.app.d dVar2 = this.f5661q;
                if (dVar2 == null) {
                    i.a();
                }
                p b3 = b2.b(dVar2);
                androidx.fragment.app.d dVar3 = this.r;
                if (dVar3 == null) {
                    i.a();
                }
                p b4 = b3.b(dVar3);
                androidx.fragment.app.d dVar4 = this.s;
                if (dVar4 == null) {
                    i.a();
                }
                p b5 = b4.b(dVar4);
                androidx.fragment.app.d dVar5 = this.t;
                if (dVar5 == null) {
                    i.a();
                }
                b5.c(dVar5).c();
                return;
            } catch (Exception unused) {
                return;
            }
        }
        a a5 = a.f5666b.a();
        this.p = a5;
        this.t = a5;
        this.f5661q = b.f5668b.a();
        this.r = d.f5677b.a();
        this.s = c.f5672b.a();
        j jVar6 = this.k;
        if (jVar6 == null) {
            i.b("mFragmentManager");
        }
        p a6 = jVar6.a();
        i.a((Object) a6, "mFragmentManager.beginTransaction()");
        int i = R.id.debug_fragments;
        androidx.fragment.app.d dVar6 = this.p;
        if (dVar6 == null) {
            i.a();
        }
        a6.a(i, dVar6, this.l).c();
    }

    public final void a(androidx.fragment.app.d dVar, String str) {
        i.b(dVar, "fragment");
        if (dVar == this.t) {
            return;
        }
        j jVar = this.k;
        if (jVar == null) {
            i.b("mFragmentManager");
        }
        p a2 = jVar.a();
        i.a((Object) a2, "mFragmentManager.beginTransaction()");
        j jVar2 = this.k;
        if (jVar2 == null) {
            i.b("mFragmentManager");
        }
        jVar2.b();
        if (!dVar.isAdded()) {
            androidx.fragment.app.d dVar2 = this.t;
            if (dVar2 == null) {
                i.a();
            }
            a2.b(dVar2).a(R.id.debug_fragments, dVar, str).c(dVar).c();
        } else {
            androidx.fragment.app.d dVar3 = this.t;
            if (dVar3 == null) {
                i.a();
            }
            a2.b(dVar3).c(dVar).c();
        }
        this.t = dVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (z) {
            if (compoundButton == null) {
                i.a();
            }
            int id = compoundButton.getId();
            if (id == R.id.tab_debug_app) {
                androidx.fragment.app.d dVar = this.p;
                if (dVar == null) {
                    i.a();
                }
                a(dVar, this.l);
            } else if (id == R.id.tab_debug_general) {
                androidx.fragment.app.d dVar2 = this.f5661q;
                if (dVar2 == null) {
                    i.a();
                }
                a(dVar2, this.m);
            } else if (id == R.id.tab_debug_routes) {
                androidx.fragment.app.d dVar3 = this.r;
                if (dVar3 == null) {
                    i.a();
                }
                a(dVar3, this.n);
            } else if (id == R.id.tab_debug_interfaces) {
                androidx.fragment.app.d dVar4 = this.s;
                if (dVar4 == null) {
                    i.a();
                }
                a(dVar4, this.o);
            }
        }
    }
}

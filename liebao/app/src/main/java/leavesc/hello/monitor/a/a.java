package leavesc.hello.monitor.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.d;
import androidx.recyclerview.widget.h;
import java.util.List;
import leavesc.hello.monitor.R;
import leavesc.hello.monitor.db.a.b;

/* compiled from: MonitorAdapter.java */
/* loaded from: classes2.dex */
public class a extends RecyclerView.a<b> {

    /* renamed from: a  reason: collision with root package name */
    private final int f7211a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7212b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7213c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7214d;

    /* renamed from: e  reason: collision with root package name */
    private final int f7215e;
    private final int f;
    private c g;
    private d<leavesc.hello.monitor.db.a.b> h = new d<>(this, new C0183a());

    /* compiled from: MonitorAdapter.java */
    /* loaded from: classes2.dex */
    public interface c {
        void a(int i, leavesc.hello.monitor.db.a.b bVar);
    }

    public a(Context context) {
        this.f7211a = androidx.core.content.b.c(context, R.color.monitor_status_success);
        this.f7212b = androidx.core.content.b.c(context, R.color.monitor_status_requested);
        this.f7213c = androidx.core.content.b.c(context, R.color.monitor_status_error);
        this.f7214d = androidx.core.content.b.c(context, R.color.monitor_status_300);
        this.f7215e = androidx.core.content.b.c(context, R.color.monitor_status_400);
        this.f = androidx.core.content.b.c(context, R.color.monitor_status_500);
    }

    public void a(List<leavesc.hello.monitor.db.a.b> list) {
        this.h.a(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* renamed from: a */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* renamed from: a */
    public void onBindViewHolder(final b bVar, int i) {
        final leavesc.hello.monitor.db.a.b bVar2 = this.h.a().get(i);
        bVar.f7221b.setText(String.valueOf(bVar2.i()));
        bVar.f7223d.setText(String.format("%s  %s", bVar2.m(), bVar2.p()));
        bVar.f7224e.setText(bVar2.o());
        bVar.g.setText(leavesc.hello.monitor.b.b.a(bVar2.j()));
        bVar.f.setVisibility(bVar2.g() ? 0 : 8);
        if (bVar2.a() == b.a.Complete) {
            bVar.f7222c.setText(String.valueOf(bVar2.x()));
            bVar.h.setText(bVar2.f());
            bVar.i.setText(bVar2.h());
        } else {
            if (bVar2.a() == b.a.Failed) {
                bVar.f7222c.setText("!!!");
            } else {
                bVar.f7222c.setText((CharSequence) null);
            }
            bVar.h.setText((CharSequence) null);
            bVar.i.setText((CharSequence) null);
        }
        a(bVar, bVar2);
        bVar.f7220a.setOnClickListener(new View.OnClickListener() { // from class: leavesc.hello.monitor.a.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.g != null) {
                    a.this.g.a(bVar.getAdapterPosition(), bVar2);
                }
            }
        });
    }

    private void a(b bVar, leavesc.hello.monitor.db.a.b bVar2) {
        int i;
        if (bVar2.a() == b.a.Failed) {
            i = this.f7213c;
        } else if (bVar2.a() == b.a.Requested) {
            i = this.f7212b;
        } else if (bVar2.x() >= 500) {
            i = this.f;
        } else if (bVar2.x() >= 400) {
            i = this.f7215e;
        } else if (bVar2.x() >= 300) {
            i = this.f7214d;
        } else {
            i = this.f7211a;
        }
        bVar.f7222c.setTextColor(i);
        bVar.f7223d.setTextColor(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.h.a().size();
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MonitorAdapter.java */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.x {

        /* renamed from: a  reason: collision with root package name */
        public final View f7220a;

        /* renamed from: b  reason: collision with root package name */
        public final TextView f7221b;

        /* renamed from: c  reason: collision with root package name */
        public final TextView f7222c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f7223d;

        /* renamed from: e  reason: collision with root package name */
        public final TextView f7224e;
        public final ImageView f;
        public final TextView g;
        public final TextView h;
        public final TextView i;

        b(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_monitor, viewGroup, false));
            View view = this.itemView;
            this.f7220a = view;
            this.f7221b = (TextView) view.findViewById(R.id.tv_id);
            this.f7222c = (TextView) this.f7220a.findViewById(R.id.tv_code);
            this.f7223d = (TextView) this.f7220a.findViewById(R.id.tv_path);
            this.f7224e = (TextView) this.f7220a.findViewById(R.id.tv_host);
            this.f = (ImageView) this.f7220a.findViewById(R.id.iv_ssl);
            this.g = (TextView) this.f7220a.findViewById(R.id.tv_requestDate);
            this.h = (TextView) this.f7220a.findViewById(R.id.tv_duration);
            this.i = (TextView) this.f7220a.findViewById(R.id.tv_size);
        }
    }

    /* compiled from: MonitorAdapter.java */
    /* renamed from: leavesc.hello.monitor.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private class C0183a extends h.c<leavesc.hello.monitor.db.a.b> {
        private C0183a() {
        }

        @Override // androidx.recyclerview.widget.h.c
        public boolean a(leavesc.hello.monitor.db.a.b bVar, leavesc.hello.monitor.db.a.b bVar2) {
            return bVar.i() == bVar2.i();
        }

        @Override // androidx.recyclerview.widget.h.c
        public boolean b(leavesc.hello.monitor.db.a.b bVar, leavesc.hello.monitor.db.a.b bVar2) {
            return bVar.equals(bVar2);
        }

        @Override // androidx.recyclerview.widget.h.c
        public Object c(leavesc.hello.monitor.db.a.b bVar, leavesc.hello.monitor.db.a.b bVar2) {
            return super.c(bVar, bVar2);
        }
    }
}

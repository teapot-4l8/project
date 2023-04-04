package com.speed.speed_library.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.speed.speed_library.R;
import com.speed.speed_library.b.g;
import com.speed.speed_library.model.Route;
import com.speed.speed_library.model.RouteAreaModel;
import java.util.List;
import kotlin.d.b.i;

/* compiled from: RouteAdapter.kt */
/* loaded from: classes2.dex */
public final class RouteAdapter extends BaseQuickAdapter<RouteAreaModel.Route, BaseViewHolder> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RouteAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f5584a = new a();

        a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    public RouteAdapter(List<RouteAreaModel.Route> list) {
        super(R.layout.item_route, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, RouteAreaModel.Route route) {
        i.b(baseViewHolder, "helper");
        i.b(route, "item");
        int adapterPosition = baseViewHolder.getAdapterPosition();
        baseViewHolder.setText(R.id.tv_name, route.getName());
        baseViewHolder.setText(R.id.tv_desc, route.getDesc());
        TextView textView = (TextView) baseViewHolder.getView(R.id.tv_level);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_route_select);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_flag);
        if (route.getType() == 0) {
            i.a((Object) textView, "tv_level");
            textView.setText("普通路线");
        } else if (route.getType() == 1) {
            i.a((Object) textView, "tv_level");
            textView.setText("豪华路线");
        }
        if (route.getFlag_name().equals("hk")) {
            imageView2.setImageResource(R.mipmap.ic_flag_hk);
        } else if (route.getFlag_name().equals("jp")) {
            imageView2.setImageResource(R.mipmap.ic_flag_jp);
        } else if (route.getFlag_name().equals("usa")) {
            imageView2.setImageResource(R.mipmap.ic_flag_usa);
        } else if (route.getFlag_name().equals("kp")) {
            imageView2.setImageResource(R.mipmap.ic_flag_kp);
        } else if (route.getFlag_name().equals("cn")) {
            imageView2.setImageResource(R.mipmap.ic_flag_cn);
        } else if (route.getFlag_name().equals("ha")) {
            imageView2.setImageResource(R.mipmap.ic_flag_hao);
        } else {
            imageView2.setImageResource(R.mipmap.ic_flag_hao);
        }
        if (adapterPosition > 0 && ((RouteAreaModel.Route) this.mData.get(adapterPosition)).getType() == ((RouteAreaModel.Route) this.mData.get(adapterPosition - 1)).getType()) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
        Route r = g.f5610b.r();
        if (r == null || r.getId() != route.getId()) {
            imageView.setImageResource(R.mipmap.ic_route_unselect);
        } else {
            imageView.setImageResource(R.mipmap.ic_route_select);
        }
        baseViewHolder.itemView.setOnClickListener(a.f5584a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(List<RouteAreaModel.Route> list) {
        i.b(list, "list");
        this.mData = list;
        notifyDataSetChanged();
    }
}

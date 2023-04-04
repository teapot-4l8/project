package com.speed.speed_library.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.speed.speed_library.R;
import com.speed.speed_library.b.g;
import com.speed.speed_library.event.RouteEvent;
import com.speed.speed_library.model.Route;
import com.speed.speed_library.model.RouteExpandHeaderModel;
import com.speed.speed_library.model.RouteExpandModel;
import java.util.List;
import kotlin.d.b.i;
import utils.AppLog;

/* compiled from: LineAdapter.kt */
/* loaded from: classes2.dex */
public final class LineAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5556a = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private static final String f5557c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f5558d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static final int f5559e;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5560b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LineAdapter(List<? extends MultiItemEntity> list) {
        super(list);
        i.b(list, JThirdPlatFormInterface.KEY_DATA);
        this.f5560b = true;
        addItemType(f5558d, R.layout.line_item_expand_header);
        addItemType(f5559e, R.layout.line_item_expand);
    }

    public final void a(boolean z) {
        this.f5560b = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, MultiItemEntity multiItemEntity) {
        Route r;
        Route r2;
        i.b(baseViewHolder, "holder");
        i.b(multiItemEntity, "item");
        int itemViewType = baseViewHolder.getItemViewType();
        if (itemViewType == f5558d) {
            RouteExpandHeaderModel routeExpandHeaderModel = (RouteExpandHeaderModel) multiItemEntity;
            TextView textView = (TextView) baseViewHolder.getView(R.id.tv_line_group_name);
            i.a((Object) textView, "tvLineGroupName");
            textView.setText(routeExpandHeaderModel.getRouteGroupNmae());
            baseViewHolder.itemView.setOnClickListener(new b(baseViewHolder, routeExpandHeaderModel));
            ImageView imageView = (ImageView) baseViewHolder.getView(R.id.iv_line_expand_open);
            if (routeExpandHeaderModel.isExpanded()) {
                imageView.setImageResource(R.mipmap.ic_line_group_close);
            } else {
                imageView.setImageResource(R.mipmap.ic_line_group_open);
            }
            if (this.f5560b) {
                if (g.f5610b.r() != null && (r2 = g.f5610b.r()) != null && r2.getType() == 0) {
                    if (routeExpandHeaderModel.getSubItems() == null || routeExpandHeaderModel.getSubItems().size() <= 0) {
                        return;
                    }
                    for (RouteExpandModel routeExpandModel : routeExpandHeaderModel.getSubItems()) {
                        int id = routeExpandModel.getId();
                        Route r3 = g.f5610b.r();
                        if (r3 != null && id == r3.getId()) {
                            int adapterPosition = baseViewHolder.getAdapterPosition();
                            AppLog appLog = AppLog.INSTANCE;
                            appLog.i(routeExpandModel.getName() + adapterPosition);
                            baseViewHolder.itemView.post(new c(adapterPosition));
                        }
                    }
                } else if (routeExpandHeaderModel.getRouteGroupNmae().equals("海外线路")) {
                    baseViewHolder.itemView.post(new d(baseViewHolder.getAdapterPosition()));
                }
            }
        } else if (itemViewType == f5559e) {
            RouteExpandModel routeExpandModel2 = (RouteExpandModel) multiItemEntity;
            TextView textView2 = (TextView) baseViewHolder.getView(R.id.tv_line_label);
            TextView textView3 = (TextView) baseViewHolder.getView(R.id.tv_line_country_name);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.iv_line_flag);
            ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.iv_line_unselect);
            if (TextUtils.isEmpty(routeExpandModel2.getLabel())) {
                i.a((Object) textView2, "tv_line_label");
                textView2.setVisibility(8);
            } else {
                i.a((Object) textView2, "tv_line_label");
                textView2.setVisibility(0);
                textView2.setText(routeExpandModel2.getLabel());
                if (routeExpandModel2.getVip_state() == 0) {
                    Context context = this.mContext;
                    i.a((Object) context, "mContext");
                    textView2.setTextColor(context.getResources().getColor(R.color.color_text_gray_small));
                    textView2.setBackgroundResource(R.drawable.bg_line_label_gray);
                } else {
                    Context context2 = this.mContext;
                    i.a((Object) context2, "mContext");
                    textView2.setTextColor(context2.getResources().getColor(R.color.colorWhite));
                    textView2.setBackgroundResource(R.drawable.bg_line_label_red);
                }
            }
            i.a((Object) textView3, "tv_line_country_name");
            textView3.setText(routeExpandModel2.getName());
            if (routeExpandModel2.getImage_url() != null) {
                if (routeExpandModel2.getImage_url().length() > 0) {
                    if (this.mContext != null) {
                        com.bumptech.glide.c.b(this.mContext).a(routeExpandModel2.getImage_url()).a(imageView2);
                    }
                    r = g.f5610b.r();
                    if (r != null || r.getId() != routeExpandModel2.getId()) {
                        imageView3.setImageResource(R.mipmap.ic_line_unselect);
                    } else {
                        imageView3.setImageResource(R.mipmap.ic_line_select);
                    }
                    baseViewHolder.itemView.setOnClickListener(new e(routeExpandModel2));
                }
            }
            if (routeExpandModel2.getFlag_name().equals("hk")) {
                imageView2.setImageResource(R.mipmap.ic_flag_hk);
            } else if (routeExpandModel2.getFlag_name().equals("jp")) {
                imageView2.setImageResource(R.mipmap.ic_flag_jp);
            } else if (routeExpandModel2.getFlag_name().equals("usa")) {
                imageView2.setImageResource(R.mipmap.ic_flag_usa);
            } else if (routeExpandModel2.getFlag_name().equals("kp")) {
                imageView2.setImageResource(R.mipmap.ic_flag_kp);
            } else if (routeExpandModel2.getFlag_name().equals("cn")) {
                imageView2.setImageResource(R.mipmap.ic_flag_cn);
            } else if (routeExpandModel2.getFlag_name().equals("ha")) {
                imageView2.setImageResource(R.mipmap.ic_flag_hao);
            } else if (routeExpandModel2.getFlag_name().equals("fr")) {
                imageView2.setImageResource(R.mipmap.ic_flag_fr);
            } else if (routeExpandModel2.getFlag_name().equals("de")) {
                imageView2.setImageResource(R.mipmap.ic_flag_de);
            } else if (routeExpandModel2.getFlag_name().equals("gb")) {
                imageView2.setImageResource(R.mipmap.ic_flag_gb);
            } else {
                imageView2.setImageResource(R.mipmap.ic_flag_default);
            }
            r = g.f5610b.r();
            if (r != null) {
            }
            imageView3.setImageResource(R.mipmap.ic_line_unselect);
            baseViewHolder.itemView.setOnClickListener(new e(routeExpandModel2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f5562b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RouteExpandHeaderModel f5563c;

        b(BaseViewHolder baseViewHolder, RouteExpandHeaderModel routeExpandHeaderModel) {
            this.f5562b = baseViewHolder;
            this.f5563c = routeExpandHeaderModel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int adapterPosition = this.f5562b.getAdapterPosition();
            if (this.f5563c.isExpanded()) {
                LineAdapter.this.collapse(adapterPosition);
            } else {
                LineAdapter.this.expand(adapterPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f5565b;

        c(int i) {
            this.f5565b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LineAdapter.this.expand(this.f5565b);
            LineAdapter.this.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f5567b;

        d(int i) {
            this.f5567b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LineAdapter.this.expand(this.f5567b);
            LineAdapter.this.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RouteExpandModel f5569b;

        e(RouteExpandModel routeExpandModel) {
            this.f5569b = routeExpandModel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Route r = g.f5610b.r();
            if (r == null || r.getId() != this.f5569b.getId()) {
                Route route = new Route(this.f5569b.getDesc(), this.f5569b.getFlag_name(), this.f5569b.getGroup_name(), this.f5569b.getId(), this.f5569b.getIp(), this.f5569b.getLabel(), this.f5569b.getName(), this.f5569b.getType(), this.f5569b.getType_name(), this.f5569b.getVip_state(), this.f5569b.getImage_url());
                g.f5610b.a(route);
                LineAdapter.this.notifyDataSetChanged();
                org.greenrobot.eventbus.c.a().d(new RouteEvent(route));
            }
        }
    }

    /* compiled from: LineAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.d.b.g gVar) {
            this();
        }

        public final int a() {
            return LineAdapter.f5558d;
        }

        public final int b() {
            return LineAdapter.f5559e;
        }
    }

    static {
        String simpleName = LineAdapter.class.getSimpleName();
        i.a((Object) simpleName, "LineAdapter::class.java.simpleName");
        f5557c = simpleName;
        f5559e = 1;
    }
}

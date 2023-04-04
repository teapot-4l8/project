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

/* compiled from: LineTwoAdapter.kt */
/* loaded from: classes2.dex */
public final class LineTwoAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f5570a = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private static final String f5571c;

    /* renamed from: d  reason: collision with root package name */
    private static final int f5572d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static final int f5573e;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5574b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LineTwoAdapter(List<? extends MultiItemEntity> list) {
        super(list);
        i.b(list, JThirdPlatFormInterface.KEY_DATA);
        this.f5574b = true;
        addItemType(f5572d, R.layout.line_item_expand_header);
        addItemType(f5573e, R.layout.line_item_expand);
    }

    public final void a(boolean z) {
        this.f5574b = z;
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
        if (itemViewType == f5572d) {
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
            if (this.f5574b) {
                if (g.f5610b.r() != null && (r2 = g.f5610b.r()) != null && r2.getType() == 1) {
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
        } else if (itemViewType == f5573e) {
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
    /* compiled from: LineTwoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ BaseViewHolder f5576b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RouteExpandHeaderModel f5577c;

        b(BaseViewHolder baseViewHolder, RouteExpandHeaderModel routeExpandHeaderModel) {
            this.f5576b = baseViewHolder;
            this.f5577c = routeExpandHeaderModel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int adapterPosition = this.f5576b.getAdapterPosition();
            if (this.f5577c.isExpanded()) {
                LineTwoAdapter.this.collapse(adapterPosition);
            } else {
                LineTwoAdapter.this.expand(adapterPosition);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineTwoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f5579b;

        c(int i) {
            this.f5579b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LineTwoAdapter.this.expand(this.f5579b);
            LineTwoAdapter.this.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineTwoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f5581b;

        d(int i) {
            this.f5581b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LineTwoAdapter.this.expand(this.f5581b);
            LineTwoAdapter.this.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LineTwoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RouteExpandModel f5583b;

        e(RouteExpandModel routeExpandModel) {
            this.f5583b = routeExpandModel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Route r = g.f5610b.r();
            if (r == null || r.getId() != this.f5583b.getId()) {
                Route route = new Route(this.f5583b.getDesc(), this.f5583b.getFlag_name(), this.f5583b.getGroup_name(), this.f5583b.getId(), this.f5583b.getIp(), this.f5583b.getLabel(), this.f5583b.getName(), this.f5583b.getType(), this.f5583b.getType_name(), this.f5583b.getVip_state(), this.f5583b.getImage_url());
                g.f5610b.a(route);
                LineTwoAdapter.this.notifyDataSetChanged();
                org.greenrobot.eventbus.c.a().d(new RouteEvent(route));
            }
        }
    }

    /* compiled from: LineTwoAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.d.b.g gVar) {
            this();
        }
    }

    static {
        String simpleName = LineTwoAdapter.class.getSimpleName();
        i.a((Object) simpleName, "LineTwoAdapter::class.java.simpleName");
        f5571c = simpleName;
        f5573e = 1;
    }
}

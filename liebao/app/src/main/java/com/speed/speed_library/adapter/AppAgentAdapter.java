package com.speed.speed_library.adapter;

import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.speed.speed_library.R;
import com.speed.speed_library.b.g;
import com.speed.speed_library.model.AppAgentModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.d.b.i;

/* compiled from: AppAgentAdapter.kt */
/* loaded from: classes2.dex */
public final class AppAgentAdapter extends BaseQuickAdapter<AppAgentModel, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f5553a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppAgentAdapter(List<AppAgentModel> list) {
        super(R.layout.item_appagent, list);
        i.b(list, JThirdPlatFormInterface.KEY_DATA);
        ArrayList<String> V = g.f5610b.V();
        this.f5553a = V == null ? new ArrayList<>() : V;
    }

    public final ArrayList<String> a() {
        return this.f5553a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a */
    public void convert(BaseViewHolder baseViewHolder, AppAgentModel appAgentModel) {
        i.b(baseViewHolder, "helper");
        i.b(appAgentModel, "item");
        baseViewHolder.setText(R.id.tv_name, appAgentModel.getAppName());
        Switch r3 = (Switch) baseViewHolder.getView(R.id.switch_app);
        ((ImageView) baseViewHolder.getView(R.id.iv_launcher)).setImageDrawable(appAgentModel.getDrawable());
        if (appAgentModel.getSwitch()) {
            i.a((Object) r3, "switch");
            r3.setChecked(true);
        } else {
            i.a((Object) r3, "switch");
            r3.setChecked(false);
        }
        r3.setOnCheckedChangeListener(new a(appAgentModel));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AppAgentAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AppAgentModel f5555b;

        a(AppAgentModel appAgentModel) {
            this.f5555b = appAgentModel;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                if (z) {
                    AppAgentAdapter.this.a().add(this.f5555b.getPackageName());
                    this.f5555b.setSwitch(true);
                } else {
                    AppAgentAdapter.this.a().remove(this.f5555b.getPackageName());
                    this.f5555b.setSwitch(false);
                }
                g.f5610b.b(AppAgentAdapter.this.a());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(List<AppAgentModel> list) {
        i.b(list, "list");
        this.mData = list;
        notifyDataSetChanged();
    }
}

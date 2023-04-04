package com.youth.banner.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.x;
import com.youth.banner.holder.IViewHolder;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.util.BannerUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class BannerAdapter<T, VH extends RecyclerView.x> extends RecyclerView.a<VH> implements IViewHolder<T, VH> {
    private OnBannerListener mOnBannerListener;
    private VH mViewHolder;
    protected List<T> mDatas = new ArrayList();
    private int increaseCount = 2;

    public BannerAdapter(List<T> list) {
        setDatas(list);
    }

    public void setDatas(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mDatas = list;
    }

    public T getData(int i) {
        return this.mDatas.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public final void onBindViewHolder(VH vh, int i) {
        this.mViewHolder = vh;
        final int realPosition = getRealPosition(i);
        onBindView(vh, this.mDatas.get(realPosition), realPosition, getRealCount());
        if (this.mOnBannerListener != null) {
            vh.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.youth.banner.adapter.-$$Lambda$BannerAdapter$5KfvqsxBCR0neERFrR0TPtkuvUg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BannerAdapter.this.lambda$onBindViewHolder$0$BannerAdapter(realPosition, view);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$BannerAdapter(int i, View view) {
        this.mOnBannerListener.OnBannerClick(this.mDatas.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        return (VH) onCreateHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return getRealCount() > 1 ? getRealCount() + this.increaseCount : getRealCount();
    }

    public int getRealCount() {
        List<T> list = this.mDatas;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getRealPosition(int i) {
        return BannerUtils.getRealPosition(this.increaseCount == 2, i, getRealCount());
    }

    public void setOnBannerListener(OnBannerListener onBannerListener) {
        this.mOnBannerListener = onBannerListener;
    }

    public VH getViewHolder() {
        return this.mViewHolder;
    }

    public void setIncreaseCount(int i) {
        this.increaseCount = i;
    }
}

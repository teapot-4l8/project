package com.youth.banner.itemdecoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes2.dex */
public class MarginDecoration extends RecyclerView.h {
    private int mMarginPx;

    public MarginDecoration(int i) {
        this.mMarginPx = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.u uVar) {
        if (requireLinearLayoutManager(recyclerView).getOrientation() == 1) {
            rect.top = this.mMarginPx;
            rect.bottom = this.mMarginPx;
            return;
        }
        rect.left = this.mMarginPx;
        rect.right = this.mMarginPx;
    }

    private LinearLayoutManager requireLinearLayoutManager(RecyclerView recyclerView) {
        RecyclerView.i layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return (LinearLayoutManager) layoutManager;
        }
        throw new IllegalStateException("The layoutManager must be LinearLayoutManager");
    }
}

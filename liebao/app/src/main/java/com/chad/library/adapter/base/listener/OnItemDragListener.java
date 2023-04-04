package com.chad.library.adapter.base.listener;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public interface OnItemDragListener {
    void onItemDragEnd(RecyclerView.x xVar, int i);

    void onItemDragMoving(RecyclerView.x xVar, int i, RecyclerView.x xVar2, int i2);

    void onItemDragStart(RecyclerView.x xVar, int i);
}

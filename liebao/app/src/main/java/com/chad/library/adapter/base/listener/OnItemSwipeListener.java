package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public interface OnItemSwipeListener {
    void clearView(RecyclerView.x xVar, int i);

    void onItemSwipeMoving(Canvas canvas, RecyclerView.x xVar, float f, float f2, boolean z);

    void onItemSwipeStart(RecyclerView.x xVar, int i);

    void onItemSwiped(RecyclerView.x xVar, int i);
}

package com.chad.library.adapter.base.callback;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import com.chad.library.R;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;

/* loaded from: classes.dex */
public class ItemDragAndSwipeCallback extends l.a {
    private BaseItemDraggableAdapter mAdapter;
    private float mMoveThreshold = 0.1f;
    private float mSwipeThreshold = 0.7f;
    private int mDragMoveFlags = 15;
    private int mSwipeMoveFlags = 32;

    @Override // androidx.recyclerview.widget.l.a
    public boolean isLongPressDragEnabled() {
        return false;
    }

    public ItemDragAndSwipeCallback(BaseItemDraggableAdapter baseItemDraggableAdapter) {
        this.mAdapter = baseItemDraggableAdapter;
    }

    @Override // androidx.recyclerview.widget.l.a
    public boolean isItemViewSwipeEnabled() {
        return this.mAdapter.isItemSwipeEnable();
    }

    @Override // androidx.recyclerview.widget.l.a
    public void onSelectedChanged(RecyclerView.x xVar, int i) {
        if (i == 2 && !isViewCreateByAdapter(xVar)) {
            this.mAdapter.onItemDragStart(xVar);
            xVar.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, true);
        } else if (i == 1 && !isViewCreateByAdapter(xVar)) {
            this.mAdapter.onItemSwipeStart(xVar);
            xVar.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, true);
        }
        super.onSelectedChanged(xVar, i);
    }

    @Override // androidx.recyclerview.widget.l.a
    public void clearView(RecyclerView recyclerView, RecyclerView.x xVar) {
        super.clearView(recyclerView, xVar);
        if (isViewCreateByAdapter(xVar)) {
            return;
        }
        if (xVar.itemView.getTag(R.id.BaseQuickAdapter_dragging_support) != null && ((Boolean) xVar.itemView.getTag(R.id.BaseQuickAdapter_dragging_support)).booleanValue()) {
            this.mAdapter.onItemDragEnd(xVar);
            xVar.itemView.setTag(R.id.BaseQuickAdapter_dragging_support, false);
        }
        if (xVar.itemView.getTag(R.id.BaseQuickAdapter_swiping_support) == null || !((Boolean) xVar.itemView.getTag(R.id.BaseQuickAdapter_swiping_support)).booleanValue()) {
            return;
        }
        this.mAdapter.onItemSwipeClear(xVar);
        xVar.itemView.setTag(R.id.BaseQuickAdapter_swiping_support, false);
    }

    @Override // androidx.recyclerview.widget.l.a
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.x xVar) {
        if (isViewCreateByAdapter(xVar)) {
            return makeMovementFlags(0, 0);
        }
        return makeMovementFlags(this.mDragMoveFlags, this.mSwipeMoveFlags);
    }

    @Override // androidx.recyclerview.widget.l.a
    public boolean onMove(RecyclerView recyclerView, RecyclerView.x xVar, RecyclerView.x xVar2) {
        return xVar.getItemViewType() == xVar2.getItemViewType();
    }

    @Override // androidx.recyclerview.widget.l.a
    public void onMoved(RecyclerView recyclerView, RecyclerView.x xVar, int i, RecyclerView.x xVar2, int i2, int i3, int i4) {
        super.onMoved(recyclerView, xVar, i, xVar2, i2, i3, i4);
        this.mAdapter.onItemDragMoving(xVar, xVar2);
    }

    @Override // androidx.recyclerview.widget.l.a
    public void onSwiped(RecyclerView.x xVar, int i) {
        if (isViewCreateByAdapter(xVar)) {
            return;
        }
        this.mAdapter.onItemSwiped(xVar);
    }

    @Override // androidx.recyclerview.widget.l.a
    public float getMoveThreshold(RecyclerView.x xVar) {
        return this.mMoveThreshold;
    }

    @Override // androidx.recyclerview.widget.l.a
    public float getSwipeThreshold(RecyclerView.x xVar) {
        return this.mSwipeThreshold;
    }

    public void setSwipeThreshold(float f) {
        this.mSwipeThreshold = f;
    }

    public void setMoveThreshold(float f) {
        this.mMoveThreshold = f;
    }

    public void setDragMoveFlags(int i) {
        this.mDragMoveFlags = i;
    }

    public void setSwipeMoveFlags(int i) {
        this.mSwipeMoveFlags = i;
    }

    @Override // androidx.recyclerview.widget.l.a
    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.x xVar, float f, float f2, int i, boolean z) {
        super.onChildDrawOver(canvas, recyclerView, xVar, f, f2, i, z);
        if (i != 1 || isViewCreateByAdapter(xVar)) {
            return;
        }
        View view = xVar.itemView;
        canvas.save();
        if (f > 0.0f) {
            canvas.clipRect(view.getLeft(), view.getTop(), view.getLeft() + f, view.getBottom());
            canvas.translate(view.getLeft(), view.getTop());
        } else {
            canvas.clipRect(view.getRight() + f, view.getTop(), view.getRight(), view.getBottom());
            canvas.translate(view.getRight() + f, view.getTop());
        }
        this.mAdapter.onItemSwiping(canvas, xVar, f, f2, z);
        canvas.restore();
    }

    private boolean isViewCreateByAdapter(RecyclerView.x xVar) {
        int itemViewType = xVar.getItemViewType();
        return itemViewType == 273 || itemViewType == 546 || itemViewType == 819 || itemViewType == 1365;
    }
}

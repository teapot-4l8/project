package com.chad.library.adapter.base;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.h.j;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import com.chad.library.R;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseItemDraggableAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final String ERROR_NOT_SAME_ITEMTOUCHHELPER = "Item drag and item swipe should pass the same ItemTouchHelper";
    private static final int NO_TOGGLE_VIEW = 0;
    protected boolean itemDragEnabled;
    protected boolean itemSwipeEnabled;
    protected boolean mDragOnLongPress;
    protected l mItemTouchHelper;
    protected OnItemDragListener mOnItemDragListener;
    protected OnItemSwipeListener mOnItemSwipeListener;
    protected View.OnLongClickListener mOnToggleViewLongClickListener;
    protected View.OnTouchListener mOnToggleViewTouchListener;
    protected int mToggleViewId;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.a
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.x xVar, int i) {
        onBindViewHolder((BaseItemDraggableAdapter<T, K>) ((BaseViewHolder) xVar), i);
    }

    public BaseItemDraggableAdapter(List<T> list) {
        super(list);
        this.mToggleViewId = 0;
        this.itemDragEnabled = false;
        this.itemSwipeEnabled = false;
        this.mDragOnLongPress = true;
    }

    public BaseItemDraggableAdapter(int i, List<T> list) {
        super(i, list);
        this.mToggleViewId = 0;
        this.itemDragEnabled = false;
        this.itemSwipeEnabled = false;
        this.mDragOnLongPress = true;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void onBindViewHolder(K k, int i) {
        super.onBindViewHolder((BaseItemDraggableAdapter<T, K>) k, i);
        int itemViewType = k.getItemViewType();
        if (this.mItemTouchHelper == null || !this.itemDragEnabled || itemViewType == 546 || itemViewType == 273 || itemViewType == 1365 || itemViewType == 819) {
            return;
        }
        int i2 = this.mToggleViewId;
        if (i2 != 0) {
            View view = k.getView(i2);
            if (view != null) {
                view.setTag(R.id.BaseQuickAdapter_viewholder_support, k);
                if (this.mDragOnLongPress) {
                    view.setOnLongClickListener(this.mOnToggleViewLongClickListener);
                    return;
                } else {
                    view.setOnTouchListener(this.mOnToggleViewTouchListener);
                    return;
                }
            }
            return;
        }
        k.itemView.setTag(R.id.BaseQuickAdapter_viewholder_support, k);
        k.itemView.setOnLongClickListener(this.mOnToggleViewLongClickListener);
    }

    public void setToggleViewId(int i) {
        this.mToggleViewId = i;
    }

    public void setToggleDragOnLongPress(boolean z) {
        this.mDragOnLongPress = z;
        if (z) {
            this.mOnToggleViewTouchListener = null;
            this.mOnToggleViewLongClickListener = new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseItemDraggableAdapter.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (BaseItemDraggableAdapter.this.mItemTouchHelper == null || !BaseItemDraggableAdapter.this.itemDragEnabled) {
                        return true;
                    }
                    BaseItemDraggableAdapter.this.mItemTouchHelper.a((RecyclerView.x) view.getTag(R.id.BaseQuickAdapter_viewholder_support));
                    return true;
                }
            };
            return;
        }
        this.mOnToggleViewTouchListener = new View.OnTouchListener() { // from class: com.chad.library.adapter.base.BaseItemDraggableAdapter.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (j.a(motionEvent) != 0 || BaseItemDraggableAdapter.this.mDragOnLongPress) {
                    return false;
                }
                if (BaseItemDraggableAdapter.this.mItemTouchHelper == null || !BaseItemDraggableAdapter.this.itemDragEnabled) {
                    return true;
                }
                BaseItemDraggableAdapter.this.mItemTouchHelper.a((RecyclerView.x) view.getTag(R.id.BaseQuickAdapter_viewholder_support));
                return true;
            }
        };
        this.mOnToggleViewLongClickListener = null;
    }

    public void enableDragItem(l lVar) {
        enableDragItem(lVar, 0, true);
    }

    public void enableDragItem(l lVar, int i, boolean z) {
        this.itemDragEnabled = true;
        this.mItemTouchHelper = lVar;
        setToggleViewId(i);
        setToggleDragOnLongPress(z);
    }

    public void disableDragItem() {
        this.itemDragEnabled = false;
        this.mItemTouchHelper = null;
    }

    public boolean isItemDraggable() {
        return this.itemDragEnabled;
    }

    public void enableSwipeItem() {
        this.itemSwipeEnabled = true;
    }

    public void disableSwipeItem() {
        this.itemSwipeEnabled = false;
    }

    public boolean isItemSwipeEnable() {
        return this.itemSwipeEnabled;
    }

    public void setOnItemDragListener(OnItemDragListener onItemDragListener) {
        this.mOnItemDragListener = onItemDragListener;
    }

    public int getViewHolderPosition(RecyclerView.x xVar) {
        return xVar.getAdapterPosition() - getHeaderLayoutCount();
    }

    public void onItemDragStart(RecyclerView.x xVar) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragStart(xVar, getViewHolderPosition(xVar));
    }

    public void onItemDragMoving(RecyclerView.x xVar, RecyclerView.x xVar2) {
        int viewHolderPosition = getViewHolderPosition(xVar);
        int viewHolderPosition2 = getViewHolderPosition(xVar2);
        if (inRange(viewHolderPosition) && inRange(viewHolderPosition2)) {
            if (viewHolderPosition < viewHolderPosition2) {
                int i = viewHolderPosition;
                while (i < viewHolderPosition2) {
                    int i2 = i + 1;
                    Collections.swap(this.mData, i, i2);
                    i = i2;
                }
            } else {
                for (int i3 = viewHolderPosition; i3 > viewHolderPosition2; i3--) {
                    Collections.swap(this.mData, i3, i3 - 1);
                }
            }
            notifyItemMoved(xVar.getAdapterPosition(), xVar2.getAdapterPosition());
        }
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragMoving(xVar, viewHolderPosition, xVar2, viewHolderPosition2);
    }

    public void onItemDragEnd(RecyclerView.x xVar) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragEnd(xVar, getViewHolderPosition(xVar));
    }

    public void setOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener) {
        this.mOnItemSwipeListener = onItemSwipeListener;
    }

    public void onItemSwipeStart(RecyclerView.x xVar) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.onItemSwipeStart(xVar, getViewHolderPosition(xVar));
    }

    public void onItemSwipeClear(RecyclerView.x xVar) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.clearView(xVar, getViewHolderPosition(xVar));
    }

    public void onItemSwiped(RecyclerView.x xVar) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener != null && this.itemSwipeEnabled) {
            onItemSwipeListener.onItemSwiped(xVar, getViewHolderPosition(xVar));
        }
        int viewHolderPosition = getViewHolderPosition(xVar);
        if (inRange(viewHolderPosition)) {
            this.mData.remove(viewHolderPosition);
            notifyItemRemoved(xVar.getAdapterPosition());
        }
    }

    public void onItemSwiping(Canvas canvas, RecyclerView.x xVar, float f, float f2, boolean z) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.onItemSwipeMoving(canvas, xVar, f, f2, z);
    }

    private boolean inRange(int i) {
        return i >= 0 && i < this.mData.size();
    }
}

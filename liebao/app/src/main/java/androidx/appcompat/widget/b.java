package androidx.appcompat.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* compiled from: ActionBarBackgroundDrawable.java */
/* loaded from: classes.dex */
class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    final ActionBarContainer f1039a;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public b(ActionBarContainer actionBarContainer) {
        this.f1039a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f1039a.f831d) {
            if (this.f1039a.f830c != null) {
                this.f1039a.f830c.draw(canvas);
                return;
            }
            return;
        }
        if (this.f1039a.f828a != null) {
            this.f1039a.f828a.draw(canvas);
        }
        if (this.f1039a.f829b == null || !this.f1039a.f832e) {
            return;
        }
        this.f1039a.f829b.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f1039a.f831d) {
            if (this.f1039a.f830c != null) {
                this.f1039a.f830c.getOutline(outline);
            }
        } else if (this.f1039a.f828a != null) {
            this.f1039a.f828a.getOutline(outline);
        }
    }
}

package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.ac;
import androidx.transition.w;
import java.util.Map;

/* loaded from: classes.dex */
public class TextScale extends w {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    @Override // androidx.transition.w
    public void captureStartValues(ac acVar) {
        captureValues(acVar);
    }

    @Override // androidx.transition.w
    public void captureEndValues(ac acVar) {
        captureValues(acVar);
    }

    private void captureValues(ac acVar) {
        if (acVar.f2510b instanceof TextView) {
            acVar.f2509a.put(PROPNAME_SCALE, Float.valueOf(((TextView) acVar.f2510b).getScaleX()));
        }
    }

    @Override // androidx.transition.w
    public Animator createAnimator(ViewGroup viewGroup, ac acVar, ac acVar2) {
        if (acVar == null || acVar2 == null || !(acVar.f2510b instanceof TextView) || !(acVar2.f2510b instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) acVar2.f2510b;
        Map<String, Object> map = acVar.f2509a;
        Map<String, Object> map2 = acVar2.f2509a;
        float floatValue = map.get(PROPNAME_SCALE) != null ? ((Float) map.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        float floatValue2 = map2.get(PROPNAME_SCALE) != null ? ((Float) map2.get(PROPNAME_SCALE)).floatValue() : 1.0f;
        if (floatValue == floatValue2) {
            return null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(floatValue, floatValue2);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.internal.TextScale.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue3);
                textView.setScaleY(floatValue3);
            }
        });
        return ofFloat;
    }
}

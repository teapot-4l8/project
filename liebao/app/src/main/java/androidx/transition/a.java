package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;

/* compiled from: AnimatorUtils.java */
/* loaded from: classes.dex */
class a {

    /* compiled from: AnimatorUtils.java */
    /* renamed from: androidx.transition.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    interface InterfaceC0059a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof InterfaceC0059a) {
                    ((InterfaceC0059a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof InterfaceC0059a) {
                    ((InterfaceC0059a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}

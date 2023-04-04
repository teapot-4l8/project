package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.appcompat.widget.am;

/* compiled from: AppCompatDrawableManager.java */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final PorterDuff.Mode f1085a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private static k f1086b;

    /* renamed from: c  reason: collision with root package name */
    private am f1087c;

    public static synchronized void a() {
        synchronized (k.class) {
            if (f1086b == null) {
                k kVar = new k();
                f1086b = kVar;
                kVar.f1087c = am.a();
                f1086b.f1087c.a(new am.e() { // from class: androidx.appcompat.widget.k.1

                    /* renamed from: a  reason: collision with root package name */
                    private final int[] f1088a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

                    /* renamed from: b  reason: collision with root package name */
                    private final int[] f1089b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

                    /* renamed from: c  reason: collision with root package name */
                    private final int[] f1090c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};

                    /* renamed from: d  reason: collision with root package name */
                    private final int[] f1091d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

                    /* renamed from: e  reason: collision with root package name */
                    private final int[] f1092e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                    private final int[] f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

                    private ColorStateList a(Context context) {
                        return b(context, ar.a(context, R.attr.colorButtonNormal));
                    }

                    private ColorStateList b(Context context) {
                        return b(context, 0);
                    }

                    private ColorStateList c(Context context) {
                        return b(context, ar.a(context, R.attr.colorAccent));
                    }

                    private ColorStateList b(Context context, int i) {
                        int a2 = ar.a(context, R.attr.colorControlHighlight);
                        return new ColorStateList(new int[][]{ar.f1004a, ar.f1007d, ar.f1005b, ar.h}, new int[]{ar.c(context, R.attr.colorButtonNormal), androidx.core.graphics.a.a(a2, i), androidx.core.graphics.a.a(a2, i), i});
                    }

                    private ColorStateList d(Context context) {
                        int[][] iArr = new int[3];
                        int[] iArr2 = new int[3];
                        ColorStateList b2 = ar.b(context, R.attr.colorSwitchThumbNormal);
                        if (b2 != null && b2.isStateful()) {
                            iArr[0] = ar.f1004a;
                            iArr2[0] = b2.getColorForState(iArr[0], 0);
                            iArr[1] = ar.f1008e;
                            iArr2[1] = ar.a(context, R.attr.colorControlActivated);
                            iArr[2] = ar.h;
                            iArr2[2] = b2.getDefaultColor();
                        } else {
                            iArr[0] = ar.f1004a;
                            iArr2[0] = ar.c(context, R.attr.colorSwitchThumbNormal);
                            iArr[1] = ar.f1008e;
                            iArr2[1] = ar.a(context, R.attr.colorControlActivated);
                            iArr[2] = ar.h;
                            iArr2[2] = ar.a(context, R.attr.colorSwitchThumbNormal);
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    @Override // androidx.appcompat.widget.am.e
                    public Drawable a(am amVar, Context context, int i) {
                        if (i == R.drawable.abc_cab_background_top_material) {
                            return new LayerDrawable(new Drawable[]{amVar.a(context, R.drawable.abc_cab_background_internal_bg), amVar.a(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
                        }
                        return null;
                    }

                    private void a(Drawable drawable, int i, PorterDuff.Mode mode) {
                        if (ae.b(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = k.f1085a;
                        }
                        drawable.setColorFilter(k.a(i, mode));
                    }

                    @Override // androidx.appcompat.widget.am.e
                    public boolean a(Context context, int i, Drawable drawable) {
                        if (i == R.drawable.abc_seekbar_track_material) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            a(layerDrawable.findDrawableByLayerId(16908288), ar.a(context, R.attr.colorControlNormal), k.f1085a);
                            a(layerDrawable.findDrawableByLayerId(16908303), ar.a(context, R.attr.colorControlNormal), k.f1085a);
                            a(layerDrawable.findDrawableByLayerId(16908301), ar.a(context, R.attr.colorControlActivated), k.f1085a);
                            return true;
                        } else if (i == R.drawable.abc_ratingbar_material || i == R.drawable.abc_ratingbar_indicator_material || i == R.drawable.abc_ratingbar_small_material) {
                            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                            a(layerDrawable2.findDrawableByLayerId(16908288), ar.c(context, R.attr.colorControlNormal), k.f1085a);
                            a(layerDrawable2.findDrawableByLayerId(16908303), ar.a(context, R.attr.colorControlActivated), k.f1085a);
                            a(layerDrawable2.findDrawableByLayerId(16908301), ar.a(context, R.attr.colorControlActivated), k.f1085a);
                            return true;
                        } else {
                            return false;
                        }
                    }

                    private boolean a(int[] iArr, int i) {
                        for (int i2 : iArr) {
                            if (i2 == i) {
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override // androidx.appcompat.widget.am.e
                    public ColorStateList a(Context context, int i) {
                        if (i == R.drawable.abc_edit_text_material) {
                            return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_edittext);
                        }
                        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                            return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_switch_track);
                        }
                        if (i == R.drawable.abc_switch_thumb_material) {
                            return d(context);
                        }
                        if (i == R.drawable.abc_btn_default_mtrl_shape) {
                            return a(context);
                        }
                        if (i == R.drawable.abc_btn_borderless_material) {
                            return b(context);
                        }
                        if (i == R.drawable.abc_btn_colored_material) {
                            return c(context);
                        }
                        if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                            return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_spinner);
                        }
                        if (a(this.f1089b, i)) {
                            return ar.b(context, R.attr.colorControlNormal);
                        }
                        if (a(this.f1092e, i)) {
                            return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_default);
                        }
                        if (a(this.f, i)) {
                            return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_btn_checkable);
                        }
                        if (i == R.drawable.abc_seekbar_thumb_material) {
                            return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_seek_thumb);
                        }
                        return null;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:21:0x0046  */
                    /* JADX WARN: Removed duplicated region for block: B:28:0x0061 A[RETURN] */
                    @Override // androidx.appcompat.widget.am.e
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public boolean b(Context context, int i, Drawable drawable) {
                        int i2;
                        boolean z;
                        PorterDuff.Mode mode = k.f1085a;
                        int i3 = 16842801;
                        if (a(this.f1088a, i)) {
                            i3 = R.attr.colorControlNormal;
                        } else if (a(this.f1090c, i)) {
                            i3 = R.attr.colorControlActivated;
                        } else if (a(this.f1091d, i)) {
                            mode = PorterDuff.Mode.MULTIPLY;
                        } else if (i == R.drawable.abc_list_divider_mtrl_alpha) {
                            i3 = 16842800;
                            i2 = Math.round(40.8f);
                            z = true;
                            if (z) {
                                if (ae.b(drawable)) {
                                    drawable = drawable.mutate();
                                }
                                drawable.setColorFilter(k.a(ar.a(context, i3), mode));
                                if (i2 != -1) {
                                    drawable.setAlpha(i2);
                                }
                                return true;
                            }
                            return false;
                        } else if (i != R.drawable.abc_dialog_material_background) {
                            i2 = -1;
                            z = false;
                            i3 = 0;
                            if (z) {
                            }
                        }
                        i2 = -1;
                        z = true;
                        if (z) {
                        }
                    }

                    @Override // androidx.appcompat.widget.am.e
                    public PorterDuff.Mode a(int i) {
                        if (i == R.drawable.abc_switch_thumb_material) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }
                });
            }
        }
    }

    public static synchronized k b() {
        k kVar;
        synchronized (k.class) {
            if (f1086b == null) {
                a();
            }
            kVar = f1086b;
        }
        return kVar;
    }

    public synchronized Drawable a(Context context, int i) {
        return this.f1087c.a(context, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, int i, boolean z) {
        return this.f1087c.a(context, i, z);
    }

    public synchronized void a(Context context) {
        this.f1087c.a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList b(Context context, int i) {
        return this.f1087c.b(context, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Drawable drawable, au auVar, int[] iArr) {
        am.a(drawable, auVar, iArr);
    }

    public static synchronized PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (k.class) {
            a2 = am.a(i, mode);
        }
        return a2;
    }
}

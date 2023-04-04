package com.speed.speed_library.model;

import kotlin.d.b.i;

/* compiled from: OrderModel.kt */
/* loaded from: classes2.dex */
public final class OrderModel {
    private final int created;
    private final int day;
    private final int give_day;
    private final int money;
    private final String order_id;
    private final String pay_type;
    private final int postage_type;
    private final String product_id;
    private final int real_money;
    private final int updated;
    private final int user_type;

    public final int component1() {
        return this.created;
    }

    public final int component10() {
        return this.updated;
    }

    public final int component11() {
        return this.user_type;
    }

    public final int component2() {
        return this.day;
    }

    public final int component3() {
        return this.give_day;
    }

    public final int component4() {
        return this.money;
    }

    public final String component5() {
        return this.order_id;
    }

    public final String component6() {
        return this.pay_type;
    }

    public final int component7() {
        return this.postage_type;
    }

    public final String component8() {
        return this.product_id;
    }

    public final int component9() {
        return this.real_money;
    }

    public final OrderModel copy(int i, int i2, int i3, int i4, String str, String str2, int i5, String str3, int i6, int i7, int i8) {
        i.b(str, "order_id");
        i.b(str2, "pay_type");
        i.b(str3, "product_id");
        return new OrderModel(i, i2, i3, i4, str, str2, i5, str3, i6, i7, i8);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof OrderModel) {
                OrderModel orderModel = (OrderModel) obj;
                return this.created == orderModel.created && this.day == orderModel.day && this.give_day == orderModel.give_day && this.money == orderModel.money && i.a((Object) this.order_id, (Object) orderModel.order_id) && i.a((Object) this.pay_type, (Object) orderModel.pay_type) && this.postage_type == orderModel.postage_type && i.a((Object) this.product_id, (Object) orderModel.product_id) && this.real_money == orderModel.real_money && this.updated == orderModel.updated && this.user_type == orderModel.user_type;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = ((((((this.created * 31) + this.day) * 31) + this.give_day) * 31) + this.money) * 31;
        String str = this.order_id;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.pay_type;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.postage_type) * 31;
        String str3 = this.product_id;
        return ((((((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.real_money) * 31) + this.updated) * 31) + this.user_type;
    }

    public String toString() {
        return "OrderModel(created=" + this.created + ", day=" + this.day + ", give_day=" + this.give_day + ", money=" + this.money + ", order_id=" + this.order_id + ", pay_type=" + this.pay_type + ", postage_type=" + this.postage_type + ", product_id=" + this.product_id + ", real_money=" + this.real_money + ", updated=" + this.updated + ", user_type=" + this.user_type + ")";
    }

    public OrderModel(int i, int i2, int i3, int i4, String str, String str2, int i5, String str3, int i6, int i7, int i8) {
        i.b(str, "order_id");
        i.b(str2, "pay_type");
        i.b(str3, "product_id");
        this.created = i;
        this.day = i2;
        this.give_day = i3;
        this.money = i4;
        this.order_id = str;
        this.pay_type = str2;
        this.postage_type = i5;
        this.product_id = str3;
        this.real_money = i6;
        this.updated = i7;
        this.user_type = i8;
    }

    public final int getCreated() {
        return this.created;
    }

    public final int getDay() {
        return this.day;
    }

    public final int getGive_day() {
        return this.give_day;
    }

    public final int getMoney() {
        return this.money;
    }

    public final String getOrder_id() {
        return this.order_id;
    }

    public final String getPay_type() {
        return this.pay_type;
    }

    public final int getPostage_type() {
        return this.postage_type;
    }

    public final String getProduct_id() {
        return this.product_id;
    }

    public final int getReal_money() {
        return this.real_money;
    }

    public final int getUpdated() {
        return this.updated;
    }

    public final int getUser_type() {
        return this.user_type;
    }
}

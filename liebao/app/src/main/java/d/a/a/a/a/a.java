package d.a.a.a.a;

import b.b.e;
import com.speed.speed_library.model.BadgeModel;
import com.speed.speed_library.model.BaseModel;
import com.speed.speed_library.model.BootStrapModel;
import com.speed.speed_library.model.CaptchaModel;
import com.speed.speed_library.model.CheckInListModel;
import com.speed.speed_library.model.CommonModel;
import com.speed.speed_library.model.ConfigModel;
import com.speed.speed_library.model.DomainModel;
import com.speed.speed_library.model.MarqueeModel;
import com.speed.speed_library.model.OrderModel;
import com.speed.speed_library.model.RouteInfoModel;
import com.speed.speed_library.model.RouteModel;
import com.speed.speed_library.model.UploadModel;
import com.speed.speed_library.model.UserModel;
import com.speed.speed_library.model.VersionCheckModel;
import e.c.f;
import e.c.l;
import e.c.n;
import e.c.o;
import e.c.q;
import e.c.t;
import okhttp3.ab;
import okhttp3.w;

/* compiled from: RetrofitApi.kt */
/* loaded from: classes2.dex */
public interface a {
    @f(a = "/api/app/user/user_info")
    e<BaseModel<UserModel>> a();

    @f(a = "/api/app/common/marquee_info")
    e<BaseModel<MarqueeModel>> a(@t(a = "type") int i);

    @o(a = "/api/app/order/buy")
    @e.c.e
    e<BaseModel<OrderModel>> a(@e.c.c(a = "id") int i, @e.c.c(a = "ticket_id") int i2);

    @o(a = "/api/app/common/connect")
    @e.c.e
    e<BaseModel<CommonModel>> a(@e.c.c(a = "uid") int i, @e.c.c(a = "endpoint") String str);

    @o(a = "/api/app/common/feedback")
    @e.c.e
    e<CommonModel> a(@e.c.c(a = "type") int i, @e.c.c(a = "desc") String str, @e.c.c(a = "phone") String str2, @e.c.c(a = "img_url") String str3, @e.c.c(a = "endpoint") String str4, @e.c.c(a = "log") String str5);

    @f(a = "/api/app/user/route_info")
    e<BaseModel<RouteInfoModel>> a(@t(a = "id") Integer num, @t(a = "public_key") String str);

    @f(a = "/api/app/common/version")
    e<BaseModel<VersionCheckModel>> a(@t(a = "type") String str);

    @o(a = "/api/app/common/captcha")
    @e.c.e
    e<BaseModel<CaptchaModel>> a(@e.c.c(a = "phone") String str, @e.c.c(a = "type") int i);

    @o(a = "/api/app/user/login")
    @e.c.e
    e<BaseModel<UserModel>> a(@e.c.c(a = "phone") String str, @e.c.c(a = "password") String str2);

    @o(a = "/api/app/user/bind_phone")
    @e.c.e
    e<BaseModel<UserModel>> a(@e.c.c(a = "phone") String str, @e.c.c(a = "password") String str2, @e.c.c(a = "captcha") String str3);

    @o(a = "/api/app/common/point")
    e<BaseModel<CommonModel>> a(@e.c.a ab abVar);

    @o(a = "/api/app/common/upload")
    @l
    e<BaseModel<UploadModel>> a(@q w.b bVar);

    @o(a = "/api/app/user/check_in")
    e<BaseModel<UserModel>> b();

    @o(a = "/api/app/common/report/click")
    @e.c.e
    e<BaseModel<CommonModel>> b(@e.c.c(a = "type_name") String str, @e.c.c(a = "id") int i);

    @o(a = "/api/app/user/qr_info")
    @e.c.e
    e<BaseModel<CommonModel>> b(@e.c.c(a = "unique_code") String str, @e.c.c(a = "operate") String str2, @e.c.c(a = "qr_type") String str3);

    @f(a = "/api/app/user/check_in")
    e<BaseModel<CheckInListModel>> c();

    @n(a = "/api/app/user/retrieve_password")
    @e.c.e
    e<BaseModel<CommonModel>> c(@e.c.c(a = "phone") String str, @e.c.c(a = "password") String str2, @e.c.c(a = "captcha") String str3);

    @f(a = "/api/app/common/bootpage")
    e<BaseModel<BootStrapModel>> d();

    @f(a = "/api/app/route_list")
    e<BaseModel<RouteModel>> e();

    @f(a = "/api/app/common/config_info")
    e<BaseModel<ConfigModel>> f();

    @f(a = "/api/app/common/broadcast/last")
    e<BaseModel<BadgeModel>> g();

    @f(a = "/api/app/common/feedback/last")
    e<BaseModel<BadgeModel>> h();

    @f(a = "/api/app/domain")
    e<BaseModel<DomainModel>> i();

    @f(a = "/api/app/common/marquee_info")
    e<BaseModel<MarqueeModel>> j();
}

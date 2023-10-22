package MyUtil.report;


import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Body;


public interface heartbeat {

    @POST("/x/report/click/android2")
    Call<ResponseBody> reportClick(@Body RequestBody body);

}

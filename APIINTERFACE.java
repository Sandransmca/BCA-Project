package com.example.grievanceapp;




import  okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;


    public interface APIINTERFACE {
        @Multipart
        @POST("AddCustomerPhoto")

        Call <String>AddCustomerPhoto(@Query("CustmerId") String UserID, @Part MultipartBody.Part image);
        @FormUrlEncoded
        @POST("Registration.php")
        Call<ResponseBody> register(@Field("name")String name, @Field("pass")String pass, @Field("email")String email,@Field("gender")String gender);
        @FormUrlEncoded
        @POST("Women_Login.php")
        Call<ResponseBody> login(@Field("email") String email, @Field("password") String pass);
}

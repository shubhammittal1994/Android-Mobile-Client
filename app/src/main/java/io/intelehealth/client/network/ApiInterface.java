package io.intelehealth.client.network;


import io.intelehealth.client.dto.ResponseDTO;
import io.intelehealth.client.models.Location;
import io.intelehealth.client.models.Results;
import io.intelehealth.client.models.loginModel.LoginModel;
import io.intelehealth.client.models.loginProviderModel.LoginProviderModel;
import io.intelehealth.client.models.pushRequestApiCall.PushRequestApiCall;
import io.intelehealth.client.models.pushResponseApiCall.PushResponseApiCall;
import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiInterface {


    @GET("location?tag=Login%20Location")
    Observable<Results<Location>> LOCATION_OBSERVABLE(@Query("v") String representation);

//    @GET("visit")
//    Call<PatientUUIDResponsemodel> GETPATIENT(@Query("patient") String patientUUID, @Header("Authorization") String authHeader);
//
//
//    @GET
//    Call<VisitResponsemodel> VISIT_RESPONSEMODEL_CALL(@Url String url, @Header("Authorization") String authHeader);

    @DELETE
    Call<Void> DELETE_ENCOUNTER(@Url String url, @Header("Authorization") String authHeader);

    //EMR-Middleware/webapi/pull/pulldata/
    @GET
    Call<ResponseDTO> RESPONSE_DTO_CALL(@Url String url, @Header("Authorization") String authHeader);

    @GET
    Observable<LoginModel> LOGIN_MODEL_OBSERVABLE(@Url String url, @Header("Authorization") String authHeader);

    @GET
    Observable<LoginProviderModel> LOGIN_PROVIDER_MODEL_OBSERVABLE(@Url String url, @Header("Authorization") String authHeader);

    @Headers({"Accept: application/json"})
    @POST
    Single<PushResponseApiCall> PUSH_RESPONSE_API_CALL_OBSERVABLE(@Url String url, @Header("Authorization") String authHeader, @Body PushRequestApiCall pushRequestApiCall);

    @GET
    Observable<ResponseBody> PERSON_PROFILE_PIC_DOWNLOAD(@Url String url, @Header("Authorization") String authHeader);

    @GET
    Observable<ResponseBody> OBS_IMAGE_DOWNLOAD(@Url String url, @Header("Authorization") String authHeader);


}
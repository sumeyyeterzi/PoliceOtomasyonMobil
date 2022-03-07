package org.sbm.police.service;

import com.google.gson.JsonObject;

import org.sbm.police.model.request.PoliceAddModel;
import org.sbm.police.model.request.PoliceUpdateModel;
import org.sbm.police.model.response.PoliceModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IPoliceService {

    @GET("list") //controllerdeki yol gibi düşün.
    Call<List<PoliceModel>> getPoliceler(); //call: dönüşlerde kullanılan  hazır obje yapısı. retrofite özel.

    @PUT("update/{id}")
    Call<Boolean> updatePolice(@Path("id")int id, @Body PoliceUpdateModel body);  //otomatik convert ediliyor.

     @DELETE("delete/{id}")
    Call<Boolean> deletePolice(@Path ("id") int id); //sadece id aldığı için Body eklmedim.

   @POST("add")
    Call<Boolean> addPolice(@Body PoliceAddModel body);
}


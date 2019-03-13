package com.ozoneplayer.ozoneplayerapp.interfaces;

import com.ozoneplayer.ozoneplayerapp.model.OzonePhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EndpointAPI {
    @GET("changes/")
    Call<List<OzonePhoto>> loadChanges(@Query("q") String status);
}

package com.daphneliu.androidapisample

import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingService {
    /**
     * Address to [LatLng]
     */
    @GET("geocode/json")
    suspend fun geocode(
        @Query("address") address: String,
        @Query("key") key: String
    ): GeocodingResponse
}

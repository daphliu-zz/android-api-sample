package com.daphneliu.androidapisample

data class GeocodingResponse(
    val results: List<Result>,
    val status: String,
    val error_message: String?
)

data class Result(
    val geometry: Geometry
)

data class Geometry(
    val location: LatLng
)

data class LatLng(
    val lat: Float,
    val lng: Float
)

package andrey.chernikovich.data.net.entity.user

import andrey.chernikovich.data.net.entity.RestEntity

data class GeoResponse(
    val lat: String,
    val lng: String
) : RestEntity
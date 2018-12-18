package andrey.chernikovich.data.net.entity.user

import andrey.chernikovich.data.net.entity.RestEntity

data class AddressResponse(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeoResponse
) : RestEntity
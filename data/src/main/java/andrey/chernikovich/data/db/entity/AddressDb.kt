package andrey.chernikovich.data.db.entity

import andrey.chernikovich.data.net.entity.user.GeoResponse

data class AddressDb(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: GeoDb
)  : DataEntity
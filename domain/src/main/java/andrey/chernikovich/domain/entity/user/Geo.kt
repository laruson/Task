package andrey.chernikovich.domain.entity.user

import andrey.chernikovich.domain.entity.DomainEntity

data class Geo(
    val lat: String,
    val lng: String
) : DomainEntity
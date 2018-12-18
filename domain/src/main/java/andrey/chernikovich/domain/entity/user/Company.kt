package andrey.chernikovich.domain.entity.user

import andrey.chernikovich.domain.entity.DomainEntity

data class Company(
    val name: String,
    val catchPhrase: String,
    val bs: String
) : DomainEntity
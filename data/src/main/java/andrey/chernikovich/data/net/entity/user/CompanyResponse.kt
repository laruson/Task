package andrey.chernikovich.data.net.entity.user

import andrey.chernikovich.data.net.entity.RestEntity

data class CompanyResponse(
    val name: String,
    val catchPhrase: String,
    val bs: String
) : RestEntity
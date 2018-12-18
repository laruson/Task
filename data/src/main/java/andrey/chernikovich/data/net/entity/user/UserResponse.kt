package andrey.chernikovich.data.net.entity.user

import andrey.chernikovich.data.net.entity.RestEntity

data class UserResponse(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressResponse,
    val phone: String,
    val website: String,
    val company: CompanyResponse
) : RestEntity
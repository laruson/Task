package andrey.chernikovich.data.net.entity

import andrey.chernikovich.data.net.entity.user.AddressResponse
import andrey.chernikovich.data.net.entity.user.CompanyResponse
import andrey.chernikovich.data.net.entity.user.GeoResponse
import andrey.chernikovich.data.net.entity.user.UserResponse
import andrey.chernikovich.domain.entity.Post
import andrey.chernikovich.domain.entity.user.Address
import andrey.chernikovich.domain.entity.user.Company
import andrey.chernikovich.domain.entity.user.Geo
import andrey.chernikovich.domain.entity.user.User

fun PostResponse.transformToPost(): Post {
    return Post(
        userId = userId,
        id = id,
        title = title,
        body = body
    )
}

fun UserResponse.transformToUser():User{
    return User(
        id = id,
        name = name,
        username = username,
        email = email,
        address = address.transformToAddress(),
        phone = phone,
        website = website,
        company = company.transformToCompany()
    )
}

fun AddressResponse.transformToAddress():Address{
    return Address(
        street = street,
        suite = suite,
        city = city,
        zipcode = zipcode,
        geo = geo.transformToGeo()
    )
}

fun GeoResponse.transformToGeo():Geo{
    return Geo(
        lat = lat,
        lng = lng
    )
}

fun CompanyResponse.transformToCompany():Company{
    return Company(
        name = name,
        catchPhrase = catchPhrase,
        bs = bs
    )
}
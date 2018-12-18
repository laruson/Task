package andrey.chernikovich.data.db.entity

import andrey.chernikovich.domain.entity.user.Address
import andrey.chernikovich.domain.entity.user.Company
import andrey.chernikovich.domain.entity.user.Geo
import andrey.chernikovich.domain.entity.user.User

fun User.transformToUserDb(): UserDb {
    return UserDb(
        id = id,
        name = name,
        username = username,
        email = email,
        address = address.transformToAddressDb(),
        phone = phone,
        website = website,
        company = company.transformToCompanyDb()
    )
}

fun Address.transformToAddressDb(): AddressDb {
    return AddressDb(
        street = street,
        suite = suite,
        city = city,
        zipcode = zipcode,
        geo = geo.transformToGeoDb()
    )
}

fun Geo.transformToGeoDb(): GeoDb {
    return GeoDb(
        lat = lat,
        lng = lng
    )
}

fun Company.transformToCompanyDb(): CompanyDb {
    return CompanyDb(
        name = name,
        catchPhrase = catchPhrase,
        bs = bs
    )
}
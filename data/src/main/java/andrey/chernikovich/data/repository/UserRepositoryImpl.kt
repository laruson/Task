package andrey.chernikovich.data.repository

import andrey.chernikovich.data.net.rest.service.RestService
import andrey.chernikovich.domain.entity.user.User
import andrey.chernikovich.domain.repository.UserRepository

class UserRepositoryImpl(restService: RestService) : UserRepository {
    override fun saveUser(user: User) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
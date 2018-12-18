package andrey.chernikovich.data.repository

import andrey.chernikovich.data.db.dao.UserDao
import andrey.chernikovich.data.db.entity.transformToUserDb
import andrey.chernikovich.data.net.entity.transformToUser
import andrey.chernikovich.data.net.rest.service.RestService
import andrey.chernikovich.domain.entity.user.User
import andrey.chernikovich.domain.repository.UserRepository
import io.reactivex.Observable

class UserRepositoryImpl(private val restService: RestService,
                         private val userDao: UserDao) : UserRepository {

    override fun getUser(id: Int): Observable<User> {
        return restService.getUser(id).map {
            it.transformToUser()
        }
    }

    override fun saveUser(user: User) {
        userDao.saveUser(user.transformToUserDb())
    }
}
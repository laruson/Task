package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.user.User
import io.reactivex.Observable

interface UserRepository : BaseRepository {

    fun saveUser(user: User)

    fun getUser(id:Int):Observable<User>
}
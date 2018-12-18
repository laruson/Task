package andrey.chernikovich.domain.repository

import andrey.chernikovich.domain.entity.user.User

interface UserRepository : BaseRepository {
    fun saveUser(user: User)
}
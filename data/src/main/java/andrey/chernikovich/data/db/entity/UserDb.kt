package andrey.chernikovich.data.db.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "users")
data class UserDb (
    @PrimaryKey
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: AddressDb,
    val phone: String,
    val website: String,
    val company: CompanyDb
) : DataEntity
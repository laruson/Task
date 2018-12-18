package andrey.chernikovich.data.db.entity

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson

class Converter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromAddressDb(value: AddressDb): String {
            return Gson().toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun toAddressDb(value: String): AddressDb {
            return Gson().fromJson(value, AddressDb::class.java)
        }

        @TypeConverter
        @JvmStatic
        fun fromCompanyDb(value: CompanyDb): String {
            return Gson().toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun toCompanyDb(value: String): CompanyDb {
            return Gson().fromJson(value, CompanyDb::class.java)
        }

        @TypeConverter
        @JvmStatic
        fun fromGeoDb(value: GeoDb): String {
            return Gson().toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun toGeoDb(value: String): GeoDb {
            return Gson().fromJson(value, GeoDb::class.java)
        }
    }
}
package mx.com.persistenciaroom.data

import android.annotation.SuppressLint
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = arrayOf(Trabajador::class), version = 1)
abstract class TrabajadoresDB: RoomDatabase() {
     abstract fun TrabajadorDAO(): TrabajadorDAO

    companion object{
        @SuppressLint("StaticFieldLeak")
        private lateinit var context: Context
        private val database: TrabajadoresDB by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            Room.databaseBuilder(context, TrabajadoresDB::class.java, "trabajadores.db")
                .allowMainThreadQueries()
                .build()
        }

        fun getDatabase(context: Context): TrabajadoresDB{
            Companion.context = context.applicationContext
            return database
        }
    }
}

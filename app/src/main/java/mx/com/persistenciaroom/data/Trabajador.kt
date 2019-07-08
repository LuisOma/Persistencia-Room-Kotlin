package mx.com.persistenciaroom.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "trabajadores")
data class Trabajador(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "nombre")
    var nombre: String? = null,

    @ColumnInfo(name = "puesto")
    var puesto: String? = null,

    @ColumnInfo(name = "antiguedad")
    var antiguedad: String? = null) {
}


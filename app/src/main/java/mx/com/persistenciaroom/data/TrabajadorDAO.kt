package mx.com.persistenciaroom.data

import android.arch.persistence.room.*


@Dao
interface TrabajadorDAO {
    @Insert
    fun insertarTrabajador(trabajador: Trabajador)

    @Query("SELECT * FROM trabajadores WHERE nombre = :nombre")
    fun getTrabajadorPorNombre(nombre: String): Trabajador

    @Query("SELECT * FROM trabajadores")
    fun getTrabajadores(): List<Trabajador>

    @Query("DELETE FROM trabajadores")
    fun deleteTrabajadores()

    @Delete
    fun deleteTrabajador(trabajador: Trabajador)

    @Update
    fun updateTrabajador(trabajador: Trabajador)
}

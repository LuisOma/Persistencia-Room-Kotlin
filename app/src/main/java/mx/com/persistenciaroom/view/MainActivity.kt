package mx.com.persistenciaroom.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import mx.com.persistenciaroom.R
import mx.com.persistenciaroom.data.Constants
import mx.com.persistenciaroom.data.TrabajadoresDB


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        maBtInsertarTrabajador.setOnClickListener{
            val intent = Intent(applicationContext, InsertEditActivity::class.java)
            intent.putExtra(Constants.NUEVO_TRABAJADOR, Constants.SI)
            startActivity(intent)
        }

        maBtTrabajadores.setOnClickListener{
            val intent = Intent(applicationContext, TrabajadoresActivity::class.java)
            startActivity(intent)
        }

        maBtBorrarTrabajadores.setOnClickListener{
            TrabajadoresDB.getDatabase(applicationContext).TrabajadorDAO().deleteTrabajadores()
        }

        maBtTrabajador.setOnClickListener{
            val nombre = maEtBuscar.text.toString()
            val trabajador = TrabajadoresDB.getDatabase(applicationContext).TrabajadorDAO().getTrabajadorPorNombre(nombre)
            if(trabajador == null){
                maEtBuscar.setText(R.string.mensaje)
            }else{
                val intent = Intent(applicationContext, InsertEditActivity::class.java)
                intent.putExtra(Constants.ID, trabajador.id)
                intent.putExtra(Constants.NOMBRE, trabajador.nombre)
                intent.putExtra(Constants.PUESTO, trabajador.puesto)
                intent.putExtra(Constants.ANTIGUEDAD, trabajador.antiguedad)
                intent.putExtra(Constants.NUEVO_TRABAJADOR, Constants.NO)
                startActivity(intent)
            }
        }
    }

}

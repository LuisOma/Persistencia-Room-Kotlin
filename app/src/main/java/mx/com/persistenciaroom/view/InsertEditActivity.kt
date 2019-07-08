package mx.com.persistenciaroom.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_insert_edit.*
import mx.com.persistenciaroom.R
import mx.com.persistenciaroom.data.Constants
import mx.com.persistenciaroom.data.Trabajador
import mx.com.persistenciaroom.data.TrabajadoresDB


class InsertEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_edit)

        var nuevoTrabajador = intent.getStringExtra(Constants.NUEVO_TRABAJADOR)
        var trabajador = Trabajador(0, "","", "")

        if(nuevoTrabajador.equals(Constants.SI)){

        }else{
            trabajador.id = intent.getIntExtra(Constants.ID, 0)
            trabajador.nombre = intent.getStringExtra(Constants.NOMBRE)
            ieaNombre.setText(trabajador.nombre)
            trabajador.puesto = intent.getStringExtra(Constants.PUESTO)
            ieaPuesto.setText(trabajador.puesto)
            trabajador.antiguedad = intent.getStringExtra(Constants.ANTIGUEDAD)
            ieaAntig.setText(trabajador.antiguedad)
        }

        ieaBteliminar.setOnClickListener({
            if(nuevoTrabajador.equals(Constants.SI)){

            }else{
                TrabajadoresDB.getDatabase(applicationContext).TrabajadorDAO().deleteTrabajador(trabajador)
                finish()
            }
        })

        ieaBtGuardar.setOnClickListener({
            var trabajadorSalvar = Trabajador(0,
                ieaNombre.text.toString(),
                ieaPuesto.text.toString(),
                ieaAntig.text.toString())

            if (nuevoTrabajador.equals(Constants.SI)){
                TrabajadoresDB.getDatabase(applicationContext).TrabajadorDAO().insertarTrabajador(trabajadorSalvar)
                finish()
            }else{
                trabajadorSalvar.id = trabajador.id
                TrabajadoresDB.getDatabase(applicationContext).TrabajadorDAO().updateTrabajador(trabajadorSalvar)
                finish()
            }
        })

    }
}

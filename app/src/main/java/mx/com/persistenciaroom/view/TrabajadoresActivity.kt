package mx.com.persistenciaroom.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_trabajadores.*
import mx.com.persistenciaroom.R
import mx.com.persistenciaroom.adapters.TrabajadorAdapter
import mx.com.persistenciaroom.data.Trabajador
import mx.com.persistenciaroom.data.TrabajadoresDB


class TrabajadoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trabajadores)

        var trabajadores: List<Trabajador> = TrabajadoresDB.getDatabase(applicationContext).TrabajadorDAO().getTrabajadores()

        taRv.layoutManager = LinearLayoutManager(this)
        taRv.adapter = TrabajadorAdapter(trabajadores, this)
    }
}

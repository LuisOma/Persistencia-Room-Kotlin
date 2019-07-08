package mx.com.persistenciaroom.adapters

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item_trabajador.view.*
import mx.com.persistenciaroom.data.Constants
import mx.com.persistenciaroom.view.InsertEditActivity
import mx.com.persistenciaroom.R
import mx.com.persistenciaroom.data.Trabajador


class TrabajadorAdapter(val trabajadores: List<Trabajador>, val activity: Activity): RecyclerView.Adapter<TrabajadorAdapter.TrabajadorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrabajadorViewHolder {
        var layoutInflate = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_trabajador, parent, false)
        return TrabajadorViewHolder(layoutInflate)
    }

    override fun getItemCount(): Int {
        return trabajadores.size
    }

    override fun onBindViewHolder(holder: TrabajadorViewHolder, position: Int) {
        val trabajador = trabajadores[position]
        holder.bindTrabajador(trabajador, activity)
    }

    class TrabajadorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindTrabajador(trabajador: Trabajador, activity: Activity){
            itemView.setOnClickListener({
                val intent = Intent(itemView.context, InsertEditActivity::class.java)
                intent.putExtra(Constants.ID, trabajador.id)
                intent.putExtra(Constants.NOMBRE, trabajador.nombre)
                intent.putExtra(Constants.PUESTO, trabajador.puesto)
                intent.putExtra(Constants.ANTIGUEDAD, trabajador.antiguedad)
                intent.putExtra(Constants.NUEVO_TRABAJADOR, Constants.NO)
                itemView.context.startActivity(intent)
                activity.finish()
            })

            itemView.litNombre.text = trabajador.nombre
            itemView.litPuesto.text = trabajador.puesto
            itemView.litAntiguedad.text = trabajador.antiguedad
        }
    }
}

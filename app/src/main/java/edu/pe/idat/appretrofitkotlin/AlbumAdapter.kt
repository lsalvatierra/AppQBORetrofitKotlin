package edu.pe.idat.appretrofitkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlbumAdapter (private var lstalbum :List<Album>)
    : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {


    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvid : TextView = itemView.findViewById(R.id.tvid)
        val tvtitulo : TextView  = itemView.findViewById(R.id.tvtitulo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater
            .from(parent.context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.item_album,
                parent, false
            )
        )
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lstalbum[position]
        holder.tvid.text = item.id.toString()
        holder.tvtitulo.text = item.title
    }
    override fun getItemCount(): Int {
        return lstalbum.size
    }
}
package uz.future.destination.todokotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.future.destination.todokotlin.R
import uz.future.destination.todokotlin.data.db.Note
import uz.future.destination.todokotlin.ui.viewmodels.NoteViewModel

class NoteAdapter(var notes: List<Note>, private val viewModel: NoteViewModel) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var note = notes[position]
        holder.title.text = note.title
        holder.description.text = note.description
        holder.priority.text = note.priority.toString()


    }

    override fun getItemCount(): Int = notes.size


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.tw_title)
        var description: TextView = itemView.findViewById(R.id.tw_description)
        var priority: TextView = itemView.findViewById(R.id.tw_priority)


    }

}
package uz.future.destination.todokotlin.ui

import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.future.destination.todokotlin.R
import uz.future.destination.todokotlin.adapter.NoteAdapter
import uz.future.destination.todokotlin.data.db.Note
import uz.future.destination.todokotlin.data.db.NoteDatabase
import uz.future.destination.todokotlin.data.repository.NoteRepository
import uz.future.destination.todokotlin.ui.viewmodels.NoteViewModel
import uz.future.destination.todokotlin.ui.viewmodels.NoteViewModelFactory
import uz.future.destination.todokotlin.util.AddDialogInterface
import uz.future.destination.todokotlin.util.AddNotesItemDialog

class NoteActivity : AppCompatActivity() {

    val TAG = "NoteActivity"

    private lateinit var viewModel: NoteViewModel
    lateinit var rv: RecyclerView
    lateinit var add_btn: FloatingActionButton
    lateinit var toolbar: androidx.appcompat.widget.Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar?.title = "ToDo Kotlin"



        rv = findViewById(R.id.rv)
        val database: NoteDatabase = NoteDatabase(this)
        val repository = NoteRepository(database)
        val factory = NoteViewModelFactory(repository)

        viewModel = ViewModelProvider(this, factory).get(NoteViewModel::class.java)

        rv.layoutManager = LinearLayoutManager(this)
        val adapter = NoteAdapter(listOf(), viewModel)
        rv.adapter = adapter
        viewModel.getAllNotes().observe(this, Observer {
            adapter.notes = it
            adapter.notifyDataSetChanged()
        })


        add_btn = findViewById(R.id.noteAdd)
        add_btn.setOnClickListener {
            AddNotesItemDialog(this,

                object : AddDialogInterface {
                    override fun onAddButtonCLicked(note: Note) {
                        viewModel.insert(note)
                    }

                }).show()
        }
    }
}
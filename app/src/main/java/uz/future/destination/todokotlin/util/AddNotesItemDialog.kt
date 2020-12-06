package uz.future.destination.todokotlin.util

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import uz.future.destination.todokotlin.R
import uz.future.destination.todokotlin.data.db.Note

class AddNotesItemDialog(
    context: Context, var dialogInterface: AddDialogInterface
) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.add_note)

        var save: Button? = findViewById<Button>(R.id.save)
        var cancel: Button? = findViewById<Button>(R.id.cancel)

        findViewById<NumberPicker>(R.id.add_priority)?.maxValue = 10
        findViewById<NumberPicker>(R.id.add_priority)?.minValue = 1


        save?.setOnClickListener {
            val title = findViewById<EditText>(R.id.add_title)?.text.toString()
            val desctiption = findViewById<EditText>(R.id.add_description)?.text.toString()
            val priority = findViewById<NumberPicker>(R.id.add_priority)?.value?.toInt()


            if (title.isNullOrEmpty() || desctiption.isNullOrEmpty()) {
                Toast.makeText(context, "Please enter the data", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val item = Note(title, desctiption, priority!!)
            dialogInterface.onAddButtonCLicked(item)
            dismiss()
        }
        cancel?.setOnClickListener {
            dismiss()
        }


    }


}
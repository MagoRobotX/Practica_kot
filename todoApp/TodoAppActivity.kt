package com.magorobot.androidmaster.todoApp

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.magorobot.androidmaster.R
import com.magorobot.androidmaster.todoApp.TaskCategory.*

class TodoAppActivity : AppCompatActivity() {
    private  val categories= listOf(
        Bussines,
        Personal,
        Other
    )
    private val tasks = mutableListOf(
        Tasks("Prueba Business", Bussines),
        Tasks("Prueba Pesonal", Personal),
        Tasks("Prueba Otros", Other )
    )
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var rvTasks:RecyclerView
    private lateinit var tasksAdapter: TasksAdapter
    private lateinit var fabAddtask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo_app)
        initComponent()
        initUi()
        initListeners()
    }

    private fun initListeners() {
        fabAddtask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog= Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        val btAddTask: Button =dialog.findViewById(R.id.btAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rbCategory: RadioGroup =dialog.findViewById(R.id.rbCategories)

        btAddTask.setOnClickListener{
            val currentTask =etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rbCategory.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rbCategory.findViewById(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    getString(R.string.Bussines) -> Bussines
                    getString(R.string.other) -> Personal
                    else -> Other
                }
                tasks.add(Tasks(currentTask, currentCategory))
               // tasks.add(Tasks(etTask.text.toString(), currentCategory))
                updateTask()
                dialog.hide()
            }
        }
        dialog.show()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCtegories)
        rvTasks = findViewById(R.id.rvTask)
        fabAddtask = findViewById(R.id.fabAddtask)
    }

    private fun initUi() {
        categoriesAdapter = CategoriesAdapter(categories){position -> updateCategories(position)}
        rvCategories.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter =categoriesAdapter

        tasksAdapter = TasksAdapter(tasks) {position -> onItemSelected(position)}
        rvTasks.layoutManager =LinearLayoutManager(this)
        rvTasks.adapter =tasksAdapter

    }
    private fun onItemSelected(position:Int){
        tasks[position].isSelected = !tasks[position].isSelected
        updateTask()
    }
    private fun updateCategories(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTask()
    }

    private fun updateTask(){
        val selectedCategories:List<TaskCategory> = categories.filter { it.isSelected }
        val newTasks= tasks.filter { selectedCategories.contains(it.category) }
        tasksAdapter.tasks =newTasks
        tasksAdapter.notifyDataSetChanged()
    }
}
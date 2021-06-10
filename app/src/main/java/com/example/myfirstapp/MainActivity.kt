package com.example.myfirstapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter= TodoAdapter(mutableListOf())
        val btnclickme = findViewById<Button>(R.id.btnAddTodo)
        val btn = findViewById<Button>(R.id.btnDeleteItems)

        rec_viewTodoItems.adapter = todoAdapter
        rec_viewTodoItems.layoutManager = LinearLayoutManager(this)

        btnclickme.setOnClickListener{
            val todoTitle = edittextTodoTitle.text.toString()
            Toast.makeText(this@MainActivity, "You added a item.", Toast.LENGTH_SHORT).show()
            if (todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                edittextTodoTitle.text.clear()
            }
        }

        btn.setOnClickListener {
            todoAdapter.deleteDoneTodo()
            Toast.makeText(this@MainActivity, "Your item is deleted.", Toast.LENGTH_SHORT).show()
        }
    }
}
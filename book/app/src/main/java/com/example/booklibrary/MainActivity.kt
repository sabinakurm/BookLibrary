package com.example.booklibrary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booklibrary.adapters.BookAdapter
import com.example.booklibrary.model.Book



class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var addBookButton: Button

    private val books = mutableListOf(
        Book("Война и мир", "Лев Толстой", "https://example.com/cover1.jpg"),
        Book("Преступление и наказание", "Фёдор Достоевский", "https://example.com/cover2.jpg")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        addBookButton = findViewById(R.id.addBookButton)

        val adapter = BookAdapter(books) { book ->
            val intent = Intent(this, BookDetailActivity::class.java)
            intent.putExtra("book", book)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        addBookButton.setOnClickListener {
            val intent = Intent(this, AddBookActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val newBook = data?.getSerializableExtra("newBook") as? Book
            newBook?.let {
                books.add(it)
                recyclerView.adapter?.notifyDataSetChanged()
            }
        }
    }
}




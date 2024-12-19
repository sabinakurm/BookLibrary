package com.example.booklibrary

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.booklibrary.model.Book
import com.squareup.picasso.Picasso
import missing.namespace.R


class BookDetailActivity : AppCompatActivity() {

    private lateinit var titleTextView: TextView
    private lateinit var authorTextView: TextView
    private lateinit var coverImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        titleTextView = findViewById(R.id.titleTextView)
        authorTextView = findViewById(R.id.authorTextView)
        coverImageView = findViewById(R.id.coverImageView)

        val book = intent.getSerializableExtra("book") as? Book
        book?.let {
            titleTextView.text = it.title
            authorTextView.text = it.author
            Picasso.get().load(it.coverImageUrl).into(coverImageView)
        }
    }
}



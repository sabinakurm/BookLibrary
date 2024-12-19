package com.example.booklibrary.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.booklibrary.R
import com.example.booklibrary.model.Book
import com.squareup.picasso.Picasso

class BookAdapter(
    private val books: List<Book>,
    private val onClick: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book)
    }

    override fun getItemCount(): Int = books.size

    inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        private val authorTextView: TextView = itemView.findViewById(R.id.authorTextView)
        private val coverImageView: ImageView = itemView.findViewById(R.id.coverImageView)

        fun bind(book: Book) {
            titleTextView.text = book.title
            authorTextView.text = book.author
            Picasso.get().load(book.coverImageUrl).into(coverImageView)

            itemView.setOnClickListener {
                onClick(book)
            }
        }
    }
}

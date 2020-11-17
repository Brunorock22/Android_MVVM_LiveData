package com.example.nybooks.presentation.books

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nybooks.R
import com.example.nybooks.data.model.Book
import com.example.nybooks.presentation.details.BookDetailsActivity
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        toolbarMain.title = getString(R.string.book_title)
        setSupportActionBar(toolbarMain)


        val viewModel: BooksViewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)
        viewModel.booksLiveData.observe(this, Observer {

            it?.let { books ->
                with(recyclerBooks) {
                    layoutManager =
                        LinearLayoutManager(this@BooksActivity, RecyclerView.VERTICAL, false)
                    setHasFixedSize(true)
                    adapter = BooksAdapter(books) { book ->
                        var startIntent : Intent = BookDetailsActivity.getStartIntent(
                            this@BooksActivity,
                            book.title,
                            book.description
                        )
                        this@BooksActivity.startActivity(startIntent)

                    }
                }

            }
        })

        viewModel.getBooks()

    }


}

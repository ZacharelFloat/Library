package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {
    public static final String BOOK_ID_KEY = "bookId";

    private TextView txtBookname2, txtAuthor2, txtPagesNumbr2, txtDescription2;
    private Button btnAddToWantToRead2, btnAddToAlreadyRead2, btnAddToCurrentlyReading2, btnAddToFavorite2;
    private ImageView bookCoverImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();


        Intent intent = getIntent();
        if (null != intent) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1) {
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if (null != incomingBook) {
                    setData(incomingBook);
                    handleAlreadyRead(incomingBook);
                    handleWantToReadBooks(incomingBook);
                    handleCurrentlyReadingBooks(incomingBook);
                    handleFavoriteBooks(incomingBook);
                }
            }
        }
    }
    private void handleCurrentlyReadingBooks(Book book){
        ArrayList<Book> currentlyReadingBooks = Utils.getInstance().getCurrentlyReadingBooks();
        boolean existInCurrently = false;
        for (Book b : currentlyReadingBooks) {
            if (b.getId() == book.getId()) {
                existInCurrently  = true;
            }
        }
        if (existInCurrently ) {
            btnAddToCurrentlyReading2.setEnabled(false);
        } else {
            btnAddToCurrentlyReading2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getCurrentlyReadingBooks().add(book)) {
                        btnAddToCurrentlyReading2.setEnabled(false);
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();
//                      Intent intent = new Intent(BookActivity.this, AlreadyReadBookActivity.class);  //:TODO: Activity wechsel bei hinzufügen von Item
//                        startActivity(intent);
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happend, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }


    }
    private void handleFavoriteBooks(Book book) {
        ArrayList<Book> favoriteBooks = Utils.getInstance().getFavoriteBooks();
        boolean existInFavBooks = false;
        for (Book b : favoriteBooks) {
            if (b.getId() == book.getId()) {
                existInFavBooks = true;
            }
        }
        if (existInFavBooks) {
            btnAddToFavorite2.setEnabled(false);
        } else {
            btnAddToFavorite2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getFavoriteBooks().add(book)) {
                        btnAddToFavorite2.setEnabled(false);
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happend, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
    private void handleWantToReadBooks(Book book) {
        ArrayList<Book> wantToReadBooks = Utils.getInstance().getWantToReadBooks();
        boolean existInwantToReadBooks = false;
        for (Book b : wantToReadBooks) {
            if (b.getId() == book.getId()) {
                existInwantToReadBooks = true;
            }
        }
        if (existInwantToReadBooks) {
            btnAddToWantToRead2.setEnabled(false);
        } else {
            btnAddToWantToRead2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addWantToReadBooks(book)) {
                        btnAddToWantToRead2.setEnabled(false);
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happend, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }



    private void handleAlreadyRead(Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();
        boolean existInAlreadyReadBooks = false;
        for (Book b : alreadyReadBooks) {
            if (b.getId() == book.getId()) {
                existInAlreadyReadBooks = true;
            }
        }
        if (existInAlreadyReadBooks) {
            btnAddToAlreadyRead2.setEnabled(false);
        } else {
            btnAddToAlreadyRead2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Utils.getInstance().addToAlreadyRead(book)) {
                        btnAddToAlreadyRead2.setEnabled(false);
                        Toast.makeText(BookActivity.this, "Book added", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happend, try again", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    private void setData(Book book) {
        txtBookname2.setText(book.getName());
        txtAuthor2.setText(book.getAuthor());
        txtDescription2.setText(book.getLongDesc());
        txtPagesNumbr2.setText(String.valueOf(book.getPages()));
        Glide.with(this)
                .asBitmap()
                .load(book.getImageUrl())
                .into(bookCoverImg);
    }


    private void initViews() {
        bookCoverImg = findViewById(R.id.imgBookCover);

        txtAuthor2 = findViewById(R.id.nameAuthorTxt2);
        txtBookname2 = findViewById(R.id.txNameBook2);
        txtPagesNumbr2 = findViewById(R.id.txtPageNumbr2);
        txtDescription2 = findViewById(R.id.txtLongDesc2);

        btnAddToAlreadyRead2 = findViewById(R.id.btnAddToAlreadyRead2);
        btnAddToCurrentlyReading2 = findViewById(R.id.btnAddtoCurrentlyReading2);
        btnAddToFavorite2 = findViewById(R.id.btnAddToFavorites2);
        btnAddToWantToRead2 = findViewById(R.id.btnWantToRead2);


    }
}
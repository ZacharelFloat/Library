package com.example.mylibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private static final String ALL_BOOKS_KEY = "all_books";
    private static final String ALREADY_READ_BOOKS = "already_read_books";
    private static final String WANT_TO_READ_BOOKS = "want_to_read_books";
    private static final String CURRENTLY_READING_BOOKS = "currently_reading_books";
    private static final String FAVORITE_BOOKS = "favorite_books";
    private static Utils instance;
    private SharedPreferences sharedPreferences;
//    private static ArrayList<Book> books;
//    private static ArrayList<Book> alreadyReadBooks;
//    private static ArrayList<Book> wantToReadBooks;
//    private static ArrayList<Book> currentlyReadingBooks;
//    private static ArrayList<Book> favoriteBooks;
//    private static ArrayList<Anime> favAnime;

    private Utils(Context context) {
        sharedPreferences = context.getSharedPreferences("alternate_db",Context.MODE_PRIVATE);
        Gson gson = new Gson();
        if (null == getAllBooks()) {
            initData();
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (null == getAlreadyReadBooks()) {
            editor.putString(ALREADY_READ_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getWantToReadBooks()) {
            editor.putString(WANT_TO_READ_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getCurrentlyReadingBooks()) {
            editor.putString(CURRENTLY_READING_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (null == getFavoriteBooks()) {
            editor.putString(FAVORITE_BOOKS,gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }

    }

    private void initData() {
        //TODO: Add initial Data
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(
                1,
                "Die Drei ???",
                "Robert Arthur",
                "https://cdn.smehost.net/hcmssmeappscom-delabelsprod/produkte/buecher/das-gespensterschloss.png",
                128,
                "Albert Hitfield sucht für einen Gruselfilm ein altes Spukhaus. Hätten sich unsere drei Freunde Justus, Bob und Peter besser nicht an der Suche beteiligen sollen?",
                "Long Description"));

        books.add(new Book(
                2,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));
        books.add(new Book(
                3,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));
        books.add(new Book(
                4,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));
        books.add(new Book(
                5,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));
        books.add(new Book(
                6,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));
        books.add(new Book(
                7,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));
        books.add(new Book(
                8,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        editor.putString(ALL_BOOKS_KEY,gson.toJson(books));
        editor.commit();

    }

    public static Utils getInstance(Context context) {
        if (null != instance) {
            return instance;
        } else {
            instance = new Utils(context);
            return instance;
        }
    }

    public  ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOKS_KEY,null),type);
        return books;
    }

    public ArrayList<Book> getAlreadyReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALREADY_READ_BOOKS,null),type);
        return books;
    }

    public  ArrayList<Book> getWantToReadBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(WANT_TO_READ_BOOKS,null),type);
        return books;
    }

    public  ArrayList<Book> getCurrentlyReadingBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(CURRENTLY_READING_BOOKS,null),type);
        return books;
    }

    public ArrayList<Book> getFavoriteBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>(){}.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(FAVORITE_BOOKS,null),type);
        return books;
    }

    public Book getBookById(int id) {
        ArrayList<Book> books = getAllBooks();
        if (null != books){
        for (Book b : books) {
            if (b.getId() == id) {
                return b;


        }
            }
        }
        return null;
    }

    public boolean addWantToReadBooks(Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if (books != null){
            if (books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(WANT_TO_READ_BOOKS);
                editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }return false;
    }

    public boolean addToAlreadyRead(Book book) {
        ArrayList<Book> books = getAlreadyReadBooks();
        if (books != null){
            if (books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(ALREADY_READ_BOOKS);
                editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }return false;
    }

    public boolean addToFavorite(Book book){
        ArrayList<Book> books = getFavoriteBooks();
        if (books != null){
            if (books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(FAVORITE_BOOKS);
                editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }return false;

    }

    public boolean addToCurrentlyReading(Book book){
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if (books != null){
            if (books.add(book)){
                Gson gson = new Gson();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove(CURRENTLY_READING_BOOKS);
                editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                editor.commit();
                return true;
            }
        }return false;
    }

    public boolean removeFromAlreadyRead(Book book){
        ArrayList<Book> books = getAlreadyReadBooks();
        if (books != null){
            for (Book b : books) {
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(ALREADY_READ_BOOKS);
                        editor.putString(ALREADY_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }

            }

            }
        }return false;
    }

    public boolean removeFromWantToRead(Book book){
        ArrayList<Book> books = getWantToReadBooks();
        if (books != null){
            for (Book b : books) {
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(WANT_TO_READ_BOOKS);
                        editor.putString(WANT_TO_READ_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }

                }

            }
        }return false;
    }

    public boolean removeFromFavorite(Book book){
        ArrayList<Book> books = getFavoriteBooks();
        if (books != null){
            for (Book b : books) {
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(FAVORITE_BOOKS);
                        editor.putString(FAVORITE_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }

                }

            }
        }return false;
    }

    public boolean removeFromCurrently(Book book){
        ArrayList<Book> books = getCurrentlyReadingBooks();
        if (books != null){
            for (Book b : books) {
                if (b.getId() == book.getId()){
                    if (books.remove(b)){
                        Gson gson = new Gson();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove(CURRENTLY_READING_BOOKS);
                        editor.putString(CURRENTLY_READING_BOOKS, gson.toJson(books));
                        editor.commit();
                        return true;
                    }

                }

            }
        }return false;
    }
}

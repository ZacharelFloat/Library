package com.example.mylibrary;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> favoriteBooks;
    private static ArrayList<Anime> favAnime;

    private Utils() {
        if (null == allBooks) {
            allBooks = new ArrayList<>();
        }
        if (null == alreadyReadBooks) {
            alreadyReadBooks = new ArrayList<>();
        }
        if (null == wantToReadBooks) {
            wantToReadBooks = new ArrayList<>();
        }
        if (null == currentlyReadingBooks) {
            currentlyReadingBooks = new ArrayList<>();
        }
        if (null == favoriteBooks) {
            favoriteBooks = new ArrayList<>();
        }
        initData();
    }
    private void initAnime(){
        favAnime.add(new Anime(
                1,
                "Shield Hero",
                "2018",
                "JapAnime"
        ));


    }
    private void initData() {
        //TODO: Add initial Data
        allBooks.add(new Book(
                1,
                "Die Drei ???",
                "Robert Arthur",
                "https://cdn.smehost.net/hcmssmeappscom-delabelsprod/produkte/buecher/das-gespensterschloss.png",
                128,
                "Albert Hitfield sucht für einen Gruselfilm ein altes Spukhaus. Hätten sich unsere drei Freunde Justus, Bob und Peter besser nicht an der Suche beteiligen sollen?",
                "Long Description"));

        allBooks.add(new Book(
                2,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));
        allBooks.add(new Book(
                3,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));
        allBooks.add(new Book(
                4,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));
        allBooks.add(new Book(
                5,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));
        allBooks.add(new Book(
                6,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));
        allBooks.add(new Book(
                7,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));
        allBooks.add(new Book(
                8,
                "Sword art online",
                "Reki Kawahara",
                "https://cdn-prod.scalefast.com/public/assets/user/122595/image/742913e199b2978b632b5460783e4d00.jpg",
                128,
                "In the year 2022, virtual reality has progressed by leaps and bounds, and a massive online role-playing game called Sword Art Online (SAO) is launched. With the aid of NerveGear\" technology, players can control their avatars within the game using nothing but their own thoughts.",
                "Long Description"));

    }

    public static Utils getInstance() {
        if (null != instance) {
            return instance;
        } else {
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book getBookById(int id) {
        for (Book b : allBooks) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }

    public boolean addWantToReadBooks(Book book){
        return wantToReadBooks.add(book);
    }

    public boolean addToAlreadyRead(Book book) {
        return alreadyReadBooks.add(book);
    }

    public boolean addToFavorite(Book book){return favoriteBooks.add(book);}

    public boolean addToCurrentlyReading(Book book){
        return  currentlyReadingBooks.add(book);
    }
    public boolean removeFromAlreadyRead(Book book){
        return alreadyReadBooks.remove(book);
    }






    }

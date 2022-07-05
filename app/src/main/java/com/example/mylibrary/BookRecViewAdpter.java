package com.example.mylibrary;

import static com.example.mylibrary.BookActivity.BOOK_ID_KEY;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecViewAdpter extends RecyclerView.Adapter<BookRecViewAdpter.ViewHolder> {
    private static final String TAG = "BookRecViewAdpter";

    private ArrayList<Book> books = new ArrayList<>();
    private Context mcontext;
    private String parentActivity;

    public BookRecViewAdpter(Context mcontext, String parentActivity) {
        this.mcontext = mcontext;
        this.parentActivity = parentActivity;
    }

    public BookRecViewAdpter(Context mcontext) {
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        Book book = books.get(position);
        holder.txtname.setText(book.getName());
        Glide.with(mcontext)
                .asBitmap()
                .load(book.getImageUrl())
                .into(holder.imgBook);

        holder.imgBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,BookActivity.class);
                intent.putExtra(BOOK_ID_KEY, book.getId());
                mcontext.startActivity(intent);
            }
        });




        holder.txtAuthor.setText(books.get(holder.getAdapterPosition()).getAuthor());
        holder.txtDescription.setText(books.get(holder.getAdapterPosition()).getShortDesc());


        if (books.get(holder.getAdapterPosition()).isExpanded()) {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.VISIBLE);
            holder.downArrow.setVisibility(View.GONE);
            if (parentActivity.equals("allBooks")){
                holder.btnDelete.setVisibility(View.GONE);

            }else if (parentActivity.equals("alreadyRead")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
                        builder.setMessage("Sure??!!");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance(mcontext).removeFromAlreadyRead(books.get(holder.getAdapterPosition()))){
                                    Toast.makeText(mcontext, "Book removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mcontext, "", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.create().show();

                    }
                });
                
            }else if (parentActivity.equals("cR")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
                        builder.setMessage("Sure?!?!?!");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance(mcontext).removeFromCurrently(books.get(holder.getAdapterPosition()))){
                                    Toast.makeText(mcontext, "Book removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mcontext, "", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.create().show();

                    }
                });

            }else if (parentActivity.equals("wantToRead")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
                        builder.setMessage("Sure??!!");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(Utils.getInstance(mcontext).removeFromWantToRead(books.get(holder.getAdapterPosition()))){
                                    Toast.makeText(mcontext, "Book removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mcontext, "", Toast.LENGTH_SHORT).show();
                            }
                        });
                        builder.create().show();

                    }
                });
                
            }else if(parentActivity.equals("favoriteBooks")){
                holder.btnDelete.setVisibility(View.VISIBLE);
                holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mcontext);
                        builder.setMessage("Was geht so?");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (Utils.getInstance(mcontext).removeFromFavorite(books.get(holder.getAdapterPosition()))){
                                    Toast.makeText(mcontext, "Book removed", Toast.LENGTH_SHORT).show();
                                    notifyDataSetChanged();
                                }
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                        builder.create().show();
                    }
                });

            }


        } else {
            TransitionManager.beginDelayedTransition(holder.parent);
            holder.expandedRelLayout.setVisibility(View.GONE);
            holder.downArrow.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView parent;
        private ImageView imgBook;
        private TextView txtname;
        private ImageView downArrow, upArrow;
        private RelativeLayout expandedRelLayout;
        private TextView txtAuthor, txtDescription, btnDelete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.imgbook);
            txtname = itemView.findViewById(R.id.txtBookName);
            downArrow = itemView.findViewById(R.id.btnDownArrow);
            upArrow = itemView.findViewById(R.id.btnUparrow);
            txtAuthor = itemView.findViewById(R.id.txtAuthor);
            txtDescription = itemView.findViewById(R.id.txtShortDesc);
            expandedRelLayout = itemView.findViewById(R.id.expandedRelLayout);
            btnDelete = itemView.findViewById(R.id.btnDelete);

            downArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });

            upArrow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Book book = books.get(getAdapterPosition());
                    book.setExpanded(!book.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });


        }
    }
}

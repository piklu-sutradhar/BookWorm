package comp3350.bookworm.Presentation;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.R;


// TODO: this will be implemented in iteration 2
public class SearchListAdapter extends ArrayAdapter<Book> {

//    private final Context mContext;
//    private ArrayList<Book> searchListArray = new ArrayList<Book>();
//    private ArrayList<Book> modifiedList = new ArrayList<Book>();

    public SearchListAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
//        mContext = context;
//        searchListArray.addAll(books);
//        modifiedList.addAll(searchListArray);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        final Book book = getItem(position);
//
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_book, parent, false);
//        }
//
//        TextView bookName = (TextView) convertView.findViewById(R.id.bookName);
//        TextView authorName = (TextView) convertView.findViewById(R.id.authorName);
//        TextView price = (TextView) convertView.findViewById(R.id.bookPrice);
//
//        bookName.setText(book.getBookName());
//        authorName.setText(book.getAuthorName());
//        price.setText(Double.toString(book.getBookPrice()));
//
//
//        Button btButton = (Button) convertView.findViewById(R.id.btn_arrayAdapter_book);
////        btButton.setTag(book);
//        btButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(mContext, DescriptionActivity.class);
//                intent.putExtra("BookName", book.getBookName());
//
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                mContext.startActivity(intent);
//            }
//        });

        return convertView;
    }
//    public void filter(String charText) {
//        charText = charText.toLowerCase(Locale.getDefault());
//        modifiedList.clear();
//        if (charText.length() == 0) {
//            modifiedList.addAll(searchListArray);
//        } else {
//            for (Book book : searchListArray) {
//                if (book.getBookName().toLowerCase(Locale.getDefault()).contains(charText)) {
//                    modifiedList.add(book);
//                }
//            }
//        }
//        notifyDataSetChanged();
//    }
}

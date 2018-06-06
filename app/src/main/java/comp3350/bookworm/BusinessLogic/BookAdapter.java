package comp3350.bookworm.BusinessLogic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import comp3350.bookworm.Objects.Book;
import comp3350.bookworm.R;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, ArrayList<Book> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Book book = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_book, parent, false);
        }
        // Lookup view for data population
        TextView bookName = (TextView) convertView.findViewById(R.id.bookName);
        TextView authorName = (TextView) convertView.findViewById(R.id.authorName);
        TextView price = (TextView) convertView.findViewById(R.id.bookPrice);

        // Populate the data into the template view using the data object
        bookName.setText(book.getBookName());
        authorName.setText(book.getAuthorName());
        price.setText(Double.toString(book.getBookPrice()));
        // Return the completed view to render on screen
        return convertView;
    }

}

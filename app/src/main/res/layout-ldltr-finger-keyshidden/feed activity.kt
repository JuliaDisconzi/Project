import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import java.util.ArrayList;

public class FeedActivity extends Activity {
    private ListView feedListView;
    private ArrayAdapter<FeedItem> adapter;
    private ArrayList<FeedItem> feedItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed_layout);

        feedListView = findViewById(R.id.feedListView);
        SearchView searchView = findViewById(R.id.searchView);

        adapter = new ArrayAdapter<>(this, R.layout.feed_item, feedItems);
        feedListView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                performSearch(newText);
                return true;
            }
        });
    }

    private void performSearch(String query) {
        ArrayList<FeedItem> searchResults = new ArrayList<>();

        for (FeedItem item : feedItems) {
        if (item.title.contains(query) || item.description.contains(query)) {
            searchResults.add(item);
        }
    }

        adapter.clear();
        adapter.addAll(searchResults);
        adapter.notifyDataSetChanged();
    }
}

class FeedItem {
    String title;
    String description;


/**************** Author: Gage Heinrich ************************
 * ***************      A01263913        ************************
 * ************  Any code used was from my  previous Assignments*
 * */package com.example.yams.mathbooksonamazon;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MathBookList extends ListActivity {

    private static String[] mListOfBooks;
    private static Resources mRes = null;
    private static String [] mBookArrayURL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_book_list);

        mRes = getResources();
        mListOfBooks = mRes.getStringArray(R.array.isbns);
        mBookArrayURL = mRes.getStringArray(R.array.urls);
        getListView().setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mListOfBooks));



    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {


        Uri uri = Uri.parse(mBookArrayURL[position]);
        // here I am using the implicit intent of ACTION_VIEW one that is a;ready supplied by android so
        // I don't have to make another class activity to create an explicit intent. It seemes more efficient this way
        // rather than making an entire web viewclass and passing information through bundles that way.
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_math_book_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

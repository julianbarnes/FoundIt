package com.example.julia.foundit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

public class LostItemBrowseActivity extends AppCompatActivity {

    ListView LostItems;
    String[] fruitname={"Mango", "Banana", "Watermelon","Grapes", "Kiwi", "Apple"};
    String[] desc = {"This is mango","This is banana","This is watermelon","This is grapes", "This is Kiwi", "This is Apple"};
    Integer[] imgid={R.drawable.fruit,R.drawable.fruit,R.drawable.fruit,R.drawable.fruit,R.drawable.fruit,R.drawable.fruit};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_item_browse);
        LostItems = findViewById(R.id.lostitemslist);
        CustomListView customListView = new CustomListView(this, fruitname, desc, imgid);
        LostItems.setAdapter(customListView);


        //Extra stuff
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}

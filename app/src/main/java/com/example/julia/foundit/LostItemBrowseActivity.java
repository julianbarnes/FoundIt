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
    String[] list_items={"Item1", "Item2", "Item3","Item4", "Item5", "Item6"};
    String[] desc = {"This is Item1","This is Item2","This is Item3","This is Item4", "This is Item5", "This is Item6"};
    Integer[] imgid={R.drawable.fruit,R.drawable.fruit,R.drawable.fruit,R.drawable.fruit,R.drawable.fruit,R.drawable.fruit};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_item_browse);
        LostItems = findViewById(R.id.lostitemslist);
        CustomListView customListView = new CustomListView(this, list_items, desc, imgid);
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

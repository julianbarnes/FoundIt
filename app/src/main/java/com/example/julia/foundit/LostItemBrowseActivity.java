package com.example.julia.foundit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class LostItemBrowseActivity extends AppCompatActivity {

    ListView LostItems;
    String[] item_titles ={"Item1", "Item2", "Item3","Item4", "Item5", "Item6"};
    String[] item_descriptions = {"This is Item1","This is Item2","This is Item3","This is Item4", "This is Item5", "This is Item6"};
    Integer[] item_pics ={R.drawable.fruit,R.drawable.fruit,R.drawable.fruit,R.drawable.fruit,R.drawable.fruit,R.drawable.fruit};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_item_browse);
        LostItems = findViewById(R.id.lostitemslist);

        //Create an item array
    //    final Item[] lost_items = new Item[item_titles.length];//maybe should change to array list
//        for (int i = 0; i < item_titles.length; i++){
//            lost_items[i] = new Item(item_titles[i],item_descriptions[i]);
//        }
        CustomListView customListView = new CustomListView(this, item_titles, item_descriptions, item_pics);
        LostItems.setAdapter(customListView);
        LostItems.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent intent = new Intent(LostItemBrowseActivity.this, ViewLostItem.class);
                        intent.putExtra("item", new Item(item_titles[position],item_descriptions[position]));
                        startActivity(intent);
                    }
                }
        );


        //Extra stuff
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

}

package com.example.julia.foundit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ViewLostItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_lost_item);

        Item item = (Item) getIntent().getSerializableExtra("item");
        String title = item.getTitle();
        String description = item.getDesc();

        TextView titleView = findViewById(R.id.item_title);
        titleView.setText(title);
        TextView descView = findViewById(R.id.item_desc);
        descView.setText(description);

    }
}

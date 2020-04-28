package com.example.shoppinglistapp.lists;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.shoppinglistapp.item.DeleteItem;
import com.example.shoppinglistapp.item.ItemMod;

import com.example.shoppinglistapp.item.NewItem;
import com.example.shoppinglistapp.R;;
import com.example.shoppinglistapp.database.List1DBHelper;

import java.util.ArrayList;

public class List1 extends AppCompatActivity {

    private static final String TAG = "List1";

    List1DBHelper list1DBHelper;
    private ListView nameList;
    private ListView pieceList;
    private ListView priceList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list1);

        list1DBHelper = new List1DBHelper(this);

        nameList = (ListView) findViewById(R.id.nameList);
        pieceList = (ListView) findViewById(R.id.pieceList);
        priceList = (ListView) findViewById(R.id.priceList);
        nameView();
        pieceView();
        priceView();

    }

    private void nameView() {
        Cursor data = list1DBHelper.getAllData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(2));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        nameList.setAdapter(adapter);
    }
    private void pieceView() {
        Cursor data = list1DBHelper.getAllData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(4));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        pieceList.setAdapter(adapter);
    }
    private void priceView() {
        Cursor data = list1DBHelper.getAllData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(3));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        priceList.setAdapter(adapter);
    }



    public void onClick(final android.view.View v) {
        switch (v.getId()) {
            case R.id.newItem:
                Intent lists = new Intent(List1.this, NewListItem.class);
                startActivity(lists);
                break;
            case R.id.modButton:
                Intent items = new Intent(List1.this, ListItemMod.class);
                startActivity(items);
                break;
            case R.id.delButton:
                Intent itemDel = new Intent(List1.this, ListItemDelete.class);
                startActivity(itemDel);
        }
    }

    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.list2:
                Intent list2 = new Intent(List1.this, List2.class);
                startActivity(list2);
                break;
            case R.id.list3:
                Intent list3 = new Intent(List1.this, List3.class);
                startActivity(list3);
                break;
            case R.id.list4:
                Intent list4 = new Intent(List1.this, List4.class);
                startActivity(list4);
                break;
            case R.id.list5:
                Intent list5 = new Intent(List1.this, List5.class);
                startActivity(list5);
                break;
            case R.id.newItem:
                Intent newItem = new Intent(List1.this, NewItem.class);
                startActivity(newItem);
                break;
            case R.id.itemMod:
                Intent itemMod = new Intent(List1.this, ItemMod.class);
                startActivity(itemMod);
                break;
            case R.id.deleteItem:
                Intent deleteItem = new Intent(List1.this, DeleteItem.class);
                startActivity(deleteItem);
                break;
            case R.id.newListItem:
                Intent newListItem = new Intent(List1.this, NewListItem.class);
                startActivity(newListItem);
                break;
            case R.id.listItemMod:
                Intent listItemMod = new Intent(List1.this, ListItemMod.class);
                startActivity(listItemMod);
                break;
            case R.id.listItemDelete:
                Intent listItemDelete = new Intent(List1.this, ListItemDelete.class);
                startActivity(listItemDelete);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}


/**/
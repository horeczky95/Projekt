package com.example.shoppinglistapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.shoppinglistapp.item.DeleteItem;
import com.example.shoppinglistapp.item.ItemMod;
import com.example.shoppinglistapp.item.Items;
import com.example.shoppinglistapp.item.NewItem;
import com.example.shoppinglistapp.lists.ListItemDelete;
import com.example.shoppinglistapp.lists.NewListItem;
import com.example.shoppinglistapp.lists.ListItemMod;
import com.example.shoppinglistapp.lists.Lists;
import com.example.shoppinglistapp.lists.List1;
import com.example.shoppinglistapp.lists.List2;
import com.example.shoppinglistapp.lists.List3;
import com.example.shoppinglistapp.lists.List4;
import com.example.shoppinglistapp.lists.List5;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(final android.view.View v) {
        switch (v.getId()) {
            case R.id.lists:
                Intent lists = new Intent(MainActivity.this, Lists.class);
                startActivity(lists);
                break;
            case R.id.items:
                Intent items = new Intent(MainActivity.this, Items.class);
                startActivity(items);
                break;
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
            case R.id.list1:
                Intent list1 = new Intent(MainActivity.this, List1.class);
                startActivity(list1);
                break;
            case R.id.list2:
                Intent list2 = new Intent(MainActivity.this, List2.class);
                startActivity(list2);
                break;
            case R.id.list3:
                Intent list3 = new Intent(MainActivity.this, List3.class);
                startActivity(list3);
                break;
            case R.id.list4:
                Intent list4 = new Intent(MainActivity.this, List4.class);
                startActivity(list4);
                break;
            case R.id.list5:
                Intent list5 = new Intent(MainActivity.this, List5.class);
                startActivity(list5);
                break;
            case R.id.newListItem:
                Intent newListItem = new Intent(MainActivity.this, NewListItem.class);
                startActivity(newListItem);
                break;
            case R.id.listItemMod:
                Intent listItemMod = new Intent(MainActivity.this, ListItemMod.class);
                startActivity(listItemMod);
                break;
            case R.id.listItemDelete:
                Intent listItemDelete = new Intent(MainActivity.this, ListItemDelete.class);
                startActivity(listItemDelete);
                break;
            case R.id.newItem:
                Intent newItem = new Intent(MainActivity.this, NewItem.class);
                startActivity(newItem);
                break;
            case R.id.itemMod:
                Intent itemMod = new Intent(MainActivity.this, ItemMod.class);
                startActivity(itemMod);
                break;
            case R.id.deleteItem:
                Intent deleteItem = new Intent(MainActivity.this, DeleteItem.class);
                startActivity(deleteItem);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

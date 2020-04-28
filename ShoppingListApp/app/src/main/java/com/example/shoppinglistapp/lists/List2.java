package com.example.shoppinglistapp.lists;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.shoppinglistapp.item.DeleteItem;
import com.example.shoppinglistapp.item.ItemMod;

import com.example.shoppinglistapp.item.NewItem;
import com.example.shoppinglistapp.R;

public class List2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);
    }

    public void onClick(final android.view.View v) {
        switch (v.getId()) {
            case R.id.newItem:
                Intent lists = new Intent(List2.this, NewListItem.class);
                startActivity(lists);
                break;
            case R.id.modButton:
                Intent items = new Intent(List2.this, ListItemMod.class);
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
                Intent list1 = new Intent(List2.this, List1.class);
                startActivity(list1);
                break;
            case R.id.list3:
                Intent list3 = new Intent(List2.this, List3.class);
                startActivity(list3);
                break;
            case R.id.list4:
                Intent list4 = new Intent(List2.this, List4.class);
                startActivity(list4);
                break;
            case R.id.list5:
                Intent list5 = new Intent(List2.this, List5.class);
                startActivity(list5);
                break;
            case R.id.newItem:
                Intent newItem = new Intent(List2.this, NewItem.class);
                startActivity(newItem);
                break;
            case R.id.itemMod:
                Intent itemMod = new Intent(List2.this, ItemMod.class);
                startActivity(itemMod);
                break;
            case R.id.deleteItem:
                Intent deleteItem = new Intent(List2.this, DeleteItem.class);
                startActivity(deleteItem);
                break;
            case R.id.newListItem:
                Intent newListItem = new Intent(List2.this, NewListItem.class);
                startActivity(newListItem);
                break;
            case R.id.listItemMod:
                Intent listItemMod = new Intent(List2.this, ListItemMod.class);
                startActivity(listItemMod);
                break;
            case R.id.listItemDelete:
                Intent listItemDelete = new Intent(List2.this, ListItemDelete.class);
                startActivity(listItemDelete);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

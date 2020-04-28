package com.example.shoppinglistapp.lists;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shoppinglistapp.R;
import com.example.shoppinglistapp.database.List1DBHelper;
import com.example.shoppinglistapp.item.DeleteItem;
import com.example.shoppinglistapp.item.ItemMod;
import com.example.shoppinglistapp.item.NewItem;

import java.util.ArrayList;

public class ListItemDelete extends AppCompatActivity {

    private static final String TAG = "ListItemDelete";

    List1DBHelper list1DBHelper;

    private ListView barCodeList;
    private ListView nameList;
    private ListView priceList;
    private ListView pieceList;

    private EditText listNumber;
    private EditText barCode;

    private Button delItemButton;
    private Button listViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item_delete);

        barCodeList = (ListView) findViewById(R.id.barCodeList);
        nameList = (ListView) findViewById(R.id.nameList);
        priceList = (ListView) findViewById(R.id.priceList);
        pieceList = (ListView) findViewById(R.id.pieceList);

        listNumber = (EditText) findViewById(R.id.listNum);
        barCode = (EditText) findViewById(R.id.barCode);

        listViewer = (Button) findViewById(R.id.listViewer);
        delItemButton = (Button) findViewById(R.id.delItemButton);

        list1DBHelper = new List1DBHelper(this);

        listViewer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                barCodeView();
                nameView();
                priceView();
                pieceView();
            }
        });
        delItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = listNumber.getText().toString();
                String barcode = barCode.getText().toString();
                if(num.equals("1")){
                    if(barCode.length() != 0) {
                        list1DBHelper.deleteItem(barcode);
                        barCode.setText("");
                        toastMessage("Termék törölve a táblából!");
                    } else {
                        toastMessage("Nincs megadva vonalkód!");
                    }

                } else {
                    toastMessage("Hiba!");
                }
                barCodeView();
                nameView();
                priceView();
                pieceView();
            }
        });
    }


    private void barCodeView() {
        Cursor data = list1DBHelper.getAllData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        barCodeList.setAdapter(adapter);
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

    private void priceView() {
        Cursor data = list1DBHelper.getAllData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(3));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        priceList.setAdapter(adapter);
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

    private void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
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
                Intent list1 = new Intent(ListItemDelete.this, List1.class);
                startActivity(list1);
                break;
            case R.id.list2:
                Intent list2 = new Intent(ListItemDelete.this, List2.class);
                startActivity(list2);
                break;
            case R.id.list3:
                Intent list3 = new Intent(ListItemDelete.this, List3.class);
                startActivity(list3);
                break;
            case R.id.list4:
                Intent list4 = new Intent(ListItemDelete.this, List4.class);
                startActivity(list4);
                break;
            case R.id.list5:
                Intent list5 = new Intent(ListItemDelete.this, List5.class);
                startActivity(list5);
                break;
            case R.id.newItem:
                Intent newItem = new Intent(ListItemDelete.this, NewItem.class);
                startActivity(newItem);
                break;
            case R.id.itemMod:
                Intent itemMod = new Intent(ListItemDelete.this, ItemMod.class);
                startActivity(itemMod);
                break;
            case R.id.deleteItem:
                Intent deleteItem = new Intent(ListItemDelete.this, DeleteItem.class);
                startActivity(deleteItem);
                break;
            case R.id.newListItem:
                Intent newListItem = new Intent(ListItemDelete.this, NewListItem.class);
                startActivity(newListItem);
                break;
            case R.id.listItemMod:
                Intent listItemDelete = new Intent(ListItemDelete.this, ListItemMod.class);
                startActivity(listItemDelete);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

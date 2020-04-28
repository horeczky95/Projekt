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

import com.example.shoppinglistapp.item.DeleteItem;
import com.example.shoppinglistapp.item.ItemMod;
import com.example.shoppinglistapp.item.NewItem;
import com.example.shoppinglistapp.R;
import com.example.shoppinglistapp.database.List1DBHelper;
import com.example.shoppinglistapp.database.MainDBHelper;

import java.util.ArrayList;

public class NewListItem extends AppCompatActivity {

    private static final String TAG = "NewListItem";

    MainDBHelper mainDBHelper;
    List1DBHelper list1DBHelper;

    private ListView barCodeList;
    private ListView nameList;
    private ListView priceList;
    private ListView pieceList;

    private EditText barCode;
    private EditText name;
    private EditText price;
    private EditText piece;
    private EditText listNumber;

    private Button addList;
    private Button addDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_itemto_list);

        barCode = (EditText) findViewById(R.id.barCode);
        name = (EditText) findViewById(R.id.name);
        price = (EditText) findViewById(R.id.price);
        piece = (EditText) findViewById(R.id.piece);
        listNumber = (EditText) findViewById(R.id.listNum);

        addList = (Button) findViewById(R.id.addList);
        addDB = (Button) findViewById(R.id.addDB);

        barCodeList = (ListView) findViewById(R.id.barCodeList);
        nameList = (ListView) findViewById(R.id.nameList);
        priceList = (ListView) findViewById(R.id.priceList);
        pieceList = (ListView) findViewById(R.id.pieceList);

        mainDBHelper = new MainDBHelper(this);
        list1DBHelper = new List1DBHelper(this);

        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newBarcode = barCode.getText().toString();
                String newName = name.getText().toString();
                String newPrice = price.getText().toString();
                String newPiece = piece.getText().toString();
                String num = listNumber.getText().toString();
                if(num.equals("1")) {
                    if (barCode.length() != 0 && name.length() != 0 &&
                            price.length() != 0 && piece.length() != 0) {
                        addDatatoList1(newBarcode, newName, newPrice, newPiece);
                        barCode.setText("");
                        name.setText("");
                        price.setText("");
                        piece.setText("");
                        toastMessage("A termék be került a listába.");
                    } else {
                        toastMessage("Kihagytál egy adatot!");
                    }
                } else {
                    toastMessage("Hiba");
                }
            }
        });

        addDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newBarcode = barCode.getText().toString();
                String newName = name.getText().toString();
                String newPrice = price.getText().toString();
                if(barCode.length() != 0 && name.length() != 0 && price.length() != 0) {
                    addData(newBarcode, newName, newPrice);
                    barCode.setText("");
                    name.setText("");
                    price.setText("");
                    toastMessage("A termék be került az adatbázisba.");
                } else {
                    toastMessage("Kihagytál egy adatot!");
                }
                barCodeView();
                nameView();
                priceView();
                pieceView();
            }
        });

        barCodeView();
        nameView();
        priceView();
        pieceView();
    }

    public void addDatatoList1(String barcode, String name, String price, String piece) {
        boolean insertData = list1DBHelper.addData(barcode, name, price, piece);

        if(insertData) {
            toastMessage("Hozzáadás megtörtént!");
        } else {
            toastMessage("Valamit elrontottál!");
        }
    }

    public void addData(String barcode, String name, String price) {
        boolean insertData = mainDBHelper.addData(barcode, name, price);

        if(insertData) {
            toastMessage("Hozzáadás megtörtént!");
        } else {
            toastMessage("Valamit elrontottál!");
        }
    }

    private void barCodeView() {
        Cursor data = mainDBHelper.viewData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        barCodeList.setAdapter(adapter);
    }

    private void nameView() {
        Cursor data = mainDBHelper.viewData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(2));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        nameList.setAdapter(adapter);
    }

    private void priceView() {
        Cursor data = mainDBHelper.viewData();
        ArrayList<String> listData = new ArrayList<>();
        while(data.moveToNext()) {
            listData.add(data.getString(3));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        priceList.setAdapter(adapter);
    }

    private void pieceView() {
        Cursor data = mainDBHelper.viewData();
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
                Intent list1 = new Intent(NewListItem.this, List1.class);
                startActivity(list1);
                break;
            case R.id.list2:
                Intent list2 = new Intent(NewListItem.this, List2.class);
                startActivity(list2);
                break;
            case R.id.list3:
                Intent list3 = new Intent(NewListItem.this, List3.class);
                startActivity(list3);
                break;
            case R.id.list4:
                Intent list4 = new Intent(NewListItem.this, List4.class);
                startActivity(list4);
                break;
            case R.id.list5:
                Intent list5 = new Intent(NewListItem.this, List5.class);
                startActivity(list5);
                break;
            case R.id.newItem:
                Intent newItem = new Intent(NewListItem.this, NewItem.class);
                startActivity(newItem);
                break;
            case R.id.itemMod:
                Intent itemMod = new Intent(NewListItem.this, ItemMod.class);
                startActivity(itemMod);
                break;
            case R.id.deleteItem:
                Intent deleteItem = new Intent(NewListItem.this, DeleteItem.class);
                startActivity(deleteItem);
                break;
            case R.id.listItemMod:
                Intent listItemMod = new Intent(NewListItem.this, ListItemMod.class);
                startActivity(listItemMod);
                break;
            case R.id.listItemDelete:
                Intent listItemDelete = new Intent(NewListItem.this, ListItemDelete.class);
                startActivity(listItemDelete);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
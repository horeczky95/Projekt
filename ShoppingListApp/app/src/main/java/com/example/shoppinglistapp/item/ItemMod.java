package com.example.shoppinglistapp.item;

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
import com.example.shoppinglistapp.database.MainDBHelper;
import com.example.shoppinglistapp.lists.ListItemDelete;
import com.example.shoppinglistapp.lists.NewListItem;
import com.example.shoppinglistapp.lists.ListItemMod;
import com.example.shoppinglistapp.lists.List1;
import com.example.shoppinglistapp.lists.List2;
import com.example.shoppinglistapp.lists.List3;
import com.example.shoppinglistapp.lists.List4;
import com.example.shoppinglistapp.lists.List5;

import java.util.ArrayList;

public class ItemMod extends AppCompatActivity {

    private static final String TAG = "ItemMod";

    MainDBHelper mainDBHelper;

    private ListView barCodeList;
    private ListView nameList;
    private ListView priceList;

    private EditText barCode;
    private EditText name;
    private EditText price;
    private Button modButton;
    private Button nameModButton;
    private Button priceModButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_mod);

        barCodeList = (ListView) findViewById(R.id.barCodeList);
        nameList = (ListView) findViewById(R.id.nameList);
        priceList = (ListView) findViewById(R.id.priceList);
        barCode = (EditText) findViewById(R.id.barCode);
        name = (EditText) findViewById(R.id.name);
        price = (EditText) findViewById(R.id.price);
        modButton = (Button) findViewById(R.id.modButton);
        nameModButton = (Button) findViewById(R.id.nameModButton);
        priceModButton = (Button) findViewById(R.id.priceModButton);
        mainDBHelper = new MainDBHelper(this);

        updateItem();
        updateName();
        updatePrice();

        barCodeView();
        nameView();
        priceView();
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

    public void updateItem() {
        modButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (barCode.length() != 0 && name.length() != 0 && price.length() != 0) {
                    boolean isUpdate = mainDBHelper.updateItem(barCode.getText().toString(), name.getText().toString(),
                            price.getText().toString());

                    if (isUpdate == true) {
                        toastMessage("Termék módosítva!");
                    } else {
                        toastMessage("Sikertelen módosítás");
                    }
                    barCodeView();
                    nameView();
                    priceView();
                } else {
                    toastMessage("Hiányzó adat!");
                }
            }
        });
    }

    public void updateName() {
        nameModButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (barCode.length() != 0 && name.length() != 0) {
                    boolean isUpdate = mainDBHelper.updateName(barCode.getText().toString(), name.getText().toString());
                    if (isUpdate == true) {
                        toastMessage("Név módosítva!");
                    } else {
                        toastMessage("Sikertelen módosítás");
                    }
                    barCodeView();
                    nameView();
                    priceView();
                } else {
                    toastMessage("Hiányzó adat!");
                }
            }
        });
    }

    public void updatePrice() {
        priceModButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (barCode.length() != 0 && price.length() != 0) {
                    boolean isUpdate = mainDBHelper.updatePrice(barCode.getText().toString(), price.getText().toString());
                    if (isUpdate == true) {
                        toastMessage("Ár módosítva!");
                    } else {
                        toastMessage("Sikertelen módosítás");
                    }
                    barCodeView();
                    nameView();
                    priceView();
                }else {
                    toastMessage("Hiányzó adat!");
                }
            }
        });
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
                Intent list1 = new Intent(ItemMod.this, List1.class);
                startActivity(list1);
                break;
            case R.id.list2:
                Intent list2 = new Intent(ItemMod.this, List2.class);
                startActivity(list2);
                break;
            case R.id.list3:
                Intent list3 = new Intent(ItemMod.this, List3.class);
                startActivity(list3);
                break;
            case R.id.list4:
                Intent list4 = new Intent(ItemMod.this, List4.class);
                startActivity(list4);
                break;
            case R.id.list5:
                Intent list5 = new Intent(ItemMod.this, List5.class);
                startActivity(list5);
                break;
            case R.id.newItem:
                Intent newItem = new Intent(ItemMod.this, NewItem.class);
                startActivity(newItem);
                break;
            case R.id.deleteItem:
                Intent deleteItem = new Intent(ItemMod.this, DeleteItem.class);
                startActivity(deleteItem);
                break;
            case R.id.newListItem:
                Intent newListItem = new Intent(ItemMod.this, NewListItem.class);
                startActivity(newListItem);
                break;
            case R.id.listItemMod:
                Intent listItemMod = new Intent(ItemMod.this, ListItemMod.class);
                startActivity(listItemMod);
                break;
            case R.id.listItemDelete:
                Intent listItemDelete = new Intent(ItemMod.this, ListItemDelete.class);
                startActivity(listItemDelete);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

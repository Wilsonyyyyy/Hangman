package com.example.hangman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class menu extends AppCompatActivity {

    ListView listView2;
    String[] wordef ={"String - strings are created\nand manipulated through\nthe string class","Integer - a memory location that can\nhold an integer, a positive or negative\nnon-decimal number. It is denoted by the keyword, 'int'","If else - Use if to specify a block of code to be executed,\nif a specified condition is true. Use else to specify\na block of code to be executed, if the same condition is false.\nUse else if to specify a new condition to test, if the first condition is false.","Switch - a multi-way branch statement.\nBased on the value of the expression\ngiven, different parts of code can be executed quickly.\nThe given expression can be of a primitive data type such\nas int, char, short, byte, and char"};

    ArrayAdapter<String>arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        listView2 = (ListView) findViewById(R.id.listview2);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,wordef);
        listView2.setAdapter(arrayAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("type here  to search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
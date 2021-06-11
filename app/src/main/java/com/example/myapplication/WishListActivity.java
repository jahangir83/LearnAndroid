package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

public class  WishListActivity extends Activity{


    //----------Create variable
    EditText wishEditText;
    Button addWishButton;
    ListView wishListViw;


    ArrayList<Items> arrayList ;
    BaseAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);

        initializeAll();
    }
    //

    private void initializeAll(){
        wishEditText = (EditText) findViewById(R.id.newWishEditText);
        addWishButton = (Button) findViewById(R.id.addWishButton);
        wishListViw  = (ListView) findViewById(R.id.wishListView);
        arrayList = new ArrayList<Items>();
        adapter = new BaseAdapter() {
            //-------Layout
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @Override
            public View getView(int position, View view, ViewGroup viewGroup) {
                if(view == null){
                    view= inflater.inflate(R.layout.wishlistitems, null);
                }
                TextView wishTextView = (TextView) view.findViewById(R.id.wishListItemTextView);
                TextView dateTextView = (TextView) view.findViewById(R.id.wishListDateTextViw);
                wishTextView.setText(arrayList.get(position).getWishString());
                Date date = arrayList.get(position).getDate();
                android.text.format.DateFormat df = new android.text.format.DateFormat();
                dateTextView.setText(df.format("dd/mm/yyyy hh: mm:ss a", date));

                return view;
            }

            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return arrayList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }
        };
        wishListViw.setAdapter(adapter);

        addWishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = wishEditText.getText().toString();
                Date date = new Date();
                Items items = new Items(string ,date);
                arrayList.add(items);

                //
                adapter.notifyDataSetChanged();
                wishEditText.setText("");

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(wishEditText.getWindowToken(),0);

                Toast.makeText(getBaseContext(), "New wish Added To List", Toast.LENGTH_LONG).show();
            }
        });

        wishListViw.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayList.remove(position);
                adapter.notifyDataSetChanged();
                Toast.makeText(getBaseContext(), "One Item Removed", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
package com.example.todoz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView =findViewById(R.id.listView);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addItems(view);
            }
        });
        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>( context this, android.R.layout.simple_list_item_1,items);
        listView.setAdapter(itemsAdapter);
        setUpListViewListener();


    }
    private void setUpListViewListener(){
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean OnItemLongClick(AdapterView<?> adapterView, View view,int i, long l) {
                Context context = getApplicationContext();
                Toast.makeText(context, resld: "Item Removed", Toast.LENGTH_LONG).show();
                items.remove(i);
                itemsAdapter.notifyDataSetChanged();
                return true;

            }

        });
    }

    private void addItems(View view) {
        EditText input =findViewById(R.id.editText2);
        String itemText=input.getText().toString();
        if(!(itemText.equals(""))){
            itemAdapter.add(itemText);
            input.setText("");
        }
        else{
            Toast.makeText(getApplicationContext(), resld: "Please enter text..", Toast.LENGTH_LONG).show();
        }

    }
}
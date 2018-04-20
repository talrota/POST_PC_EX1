package com.example.talrota.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button save;
    ArrayList<String> messageArray = new ArrayList<String>();
    EditText txt;
    ListView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (EditText)findViewById(R.id.editText);
        show = (ListView)findViewById(R.id.messageList);
        save = (Button)findViewById(R.id.saveButton);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = txt.getText().toString();
                if (userInput.length() == 0 || userInput.trim().equals("")){
                    Toast.makeText(getBaseContext(), "Please insert text", Toast.LENGTH_LONG).show();
                }
                else {
                    messageArray.add(userInput);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, messageArray);
                    show.setAdapter(adapter);
                    ((EditText)findViewById(R.id.editText)).setText(" ");
                    show.setSelection(show.getAdapter().getCount()-1);

                }
            }
        });
    }
}

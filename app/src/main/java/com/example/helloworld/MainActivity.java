package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    /*
     override tells the compiler that the method immediately following is to be used
     in place of the super class's method of the same name
    */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //tells the activity to use activity_main.xml as the layout
        // R tells the compiler to use a resource
        // the resource is from the layout folder
        // the resource is the file named activity_main

        initDisplayButton();
    }

    // button display function
    private void initDisplayButton() {
        Button displayButton = findViewById(R.id.buttonDisplay);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editName = findViewById(R.id.editTextName);
                TextView textDisplay = findViewById(R.id.textViewDisplay);
                String nameToDisplay = editName.getText().toString();
                Resources res = getResources(); // asks the system for access to the value files
                String displayString = res.getString(R.string.welcome_message, nameToDisplay); // creates the string with a message and name
                textDisplay.setText(displayString);
            }
        });
    }
}
package com.brysonpayne.ch4_challenge3_madlibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText txtBigAnimal;
    public EditText txtPastTenseVerb;
    public EditText txtSmallContainer;
    public EditText txtFood;
    public EditText txtOutput;
    public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtBigAnimal = (EditText) findViewById(R.id.txtBigAnimal);
        txtPastTenseVerb = (EditText) findViewById(R.id.txtPastTenseVerb);
        txtSmallContainer = (EditText) findViewById(R.id.txtSmallContainer);
        txtFood = (EditText) findViewById(R.id.txtFood);
        txtOutput = (EditText) findViewById(R.id.txtOutput);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          String message = "Once upon a time... \n"+
                                                  "There was a "+txtBigAnimal.getText().toString()+
                                                  " princess \nwho "+txtPastTenseVerb.getText().toString()+
                                                  " in a "+txtFood.getText().toString()+" "+
                                                  txtSmallContainer.getText().toString()+". \n"+
                                                  "And she lived happily ever after.";
                                          txtOutput.setText(message);
                                      }
                                  }
        );
    }
}

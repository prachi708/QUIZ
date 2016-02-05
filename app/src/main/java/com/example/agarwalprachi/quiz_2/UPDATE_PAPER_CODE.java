package com.example.agarwalprachi.quiz_2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UPDATE_PAPER_CODE extends ActionBarActivity {
    EditText txt2,txt4;
    Button b1;
    AlertDialog al;
    String s1="",s2="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__paper__code);
        txt2=(EditText)findViewById(R.id.txt2);
        txt4=(EditText)findViewById(R.id.txt4);
        al=new AlertDialog.Builder(this).create();
        b1=(Button)findViewById(R.id.b1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update__paper__code, menu);
        return true;
    }

    public void OnButtonClickAddQuestion(View v1)
    {
        Intent h2=new Intent(this,UPDATE_QUESTION.class);
        s1=""+txt2.getText();
        s2=""+txt4.getText();
        if(s1.equals("")||(s2.equals("")))
        {
            Toast.makeText(this, "Enter missing value", Toast.LENGTH_SHORT).show();
            AlertD();
        }
        else {
            h2.putExtra("code", s1);
            h2.putExtra("q_nos", s2);
            startActivity(h2);
            finish();
        }

    }

    public void AlertD()
    {
        al.setTitle("Alert");
        al.setMessage("Either paper code or question no. or both missing.Enter value");
        al.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                al.dismiss();
            }
        });
        al.show();

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

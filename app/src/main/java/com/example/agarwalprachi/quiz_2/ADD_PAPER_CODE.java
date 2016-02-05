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

import com.example.agarwalprachi.quiz_2.R;


public class ADD_PAPER_CODE extends ActionBarActivity {
EditText txt2;
    Button b1;
    String s1="";
    Intent h2;
    AlertDialog al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__paper__code);
        txt2=(EditText)findViewById(R.id.txt2);
        b1=(Button)findViewById(R.id.b1);
        h2=new Intent(this,ADD_QUESTION.class);
        al=new AlertDialog.Builder(this).create();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add__paper__code, menu);
        return true;
    }


    public void OnButtonClickAddQuestion(View v1)
    {
        s1=""+txt2.getText();
        if(s1.equals(""))
        {
            Toast.makeText(this,"Enter paper code",Toast.LENGTH_SHORT).show();
            AlertD();
        }
        else {
            h2.putExtra("code", s1);
            startActivity(h2);
            finish();
        }

    }


    public void AlertD()
    {
        al.setTitle("Alert");
        al.setMessage("No paper code entered.Enter paper code");
        al.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //choicedialog();
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

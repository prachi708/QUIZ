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
import android.widget.TextView;
import android.widget.Toast;


public class DISPLAY_PAPER_CODE extends ActionBarActivity {
EditText txt2,txt4;
    TextView txt3;
    Button b1,b2,b3;
    AlertDialog al;
    String s1="",s2="",s3="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__paper__code);
        txt2=(EditText)findViewById(R.id.txt2);
        txt4=(EditText)findViewById(R.id.txt4);
        txt3=(TextView)findViewById(R.id.txt3);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        al=new AlertDialog.Builder(this).create();
        txt3.setVisibility(View.INVISIBLE);
        txt4.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display__paper__code, menu);
        return true;
    }

    public void OnDisplayComplete1Paper(View v1)
    {
        Intent h1=new Intent(this,DISPLAY_1_PAPER.class);
        s1=""+txt2.getText();
        if(s1.equals(""))
        {
            Toast.makeText(this, "Enter paper code", Toast.LENGTH_SHORT).show();
            AlertD();
        }
        else {
            h1.putExtra("code", s1);
            startActivity(h1);
            finish();

        }


    }
public void OnDisplay1Question(View v1)
{
    txt3.setVisibility(View.VISIBLE);
    txt4.setVisibility(View.VISIBLE);
    b3.setVisibility(View.VISIBLE);
}

    public void AlertD()
    {
        al.setTitle("Alert");
        al.setMessage("Value missing.Enter value");
        al.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //choicedialog();
                al.dismiss();
            }
        });
        al.show();

    }
    public void OnDisplay(View v1)
    {
        Intent h2=new Intent(this,DISPLAY_1_QUESTION.class);
        s1=""+txt2.getText();
        s2=""+txt4.getText();
        if(s1.equals("")||(s2.equals("")))
        {
            Toast.makeText(this, "Either paper Code or Question no. missing.Enter value", Toast.LENGTH_SHORT).show();
            AlertD();
        }
        else {
            h2.putExtra("code", s1);
            h2.putExtra("q_nos", s2);
            startActivity(h2);
            finish();
        }
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

package com.example.agarwalprachi.quiz_2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.agarwalprachi.quiz_2.R;


public class ADD_QUESTION extends ActionBarActivity {
String s1="",s2="",s3="",s4="",s5="",s6="",s7="",s9="";
    ImageButton imb1;
    AlertDialog al;
    EditText txt2,txt4,txt5,txt6,txt7,txt9;
    int i=0,choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__question);
        txt2=(EditText)findViewById(R.id.txt2);
        txt4=(EditText)findViewById(R.id.txt4);
        txt5=(EditText)findViewById(R.id.txt5);
        txt6=(EditText)findViewById(R.id.txt6);
        txt7=(EditText)findViewById(R.id.txt7);
        txt9=(EditText)findViewById(R.id.txt9);
        al=new AlertDialog.Builder(this).create();
        SelectingRow();
        //Intent h2=new Intent(this,ADD_PAPER_CODE.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add__question, menu);
        return true;
    }

    public void SelectingRow()
    {
        s3=""+getIntent().getStringExtra("code");
        s1="SELECT* FROM PAPER WHERE (PAPER_CODE=='"+s3+"');";
        Cursor c;
        try {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
            c=dbase.rawQuery(s1,null);
            while(c.move(1)) {
              i++;

            }
            i++;
            Toast.makeText(this, "no of questions:"+i, Toast.LENGTH_LONG).show();
        }catch(Exception E)
        {
            Toast.makeText(this,"error found no such paper code or question exist:"+E, Toast.LENGTH_LONG).show();
        }


    }

    public void OnAdd(View v1)
    {

        s2=""+txt2.getText();
        s4=""+txt4.getText();
        s5=""+txt5.getText();
        s6=""+txt6.getText();
        s7=""+txt7.getText();
        s9=""+txt9.getText();
        s1="INSERT INTO PAPER VALUES ('"+s3+"',"+i+",'"+s2+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s9+"');";
        try
        {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE,null);
            dbase.execSQL(s1);
            Toast.makeText(this, "value inserted::", Toast.LENGTH_LONG).show();
            i++;
        }

        catch(Exception E)
        {
            Toast.makeText(this, "error found cannot insert::" + E, Toast.LENGTH_LONG).show();
        }
        AlertD();
    }


    public void AlertD()
    {
        al.setTitle("Alert");
        al.setMessage("Do you want to add more question to same paper");
        al.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
choice=1;
                choicedialog();

            }
        });
        al.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = 2;
                choicedialog();
            }
        });

        al.show();

    }

public void choicedialog()
{
    if(choice==1)
    {
        Intent h1=new Intent(this,ADD_QUESTION.class);
        h1.putExtra("code",s3);
        startActivity(h1);
        finish();
    }
    else if(choice==2)
    {
        Intent h1=new Intent(this,ADMIN_MENU.class);
        startActivity(h1);
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

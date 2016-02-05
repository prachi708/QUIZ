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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.agarwalprachi.quiz_2.R;


public class DISPLAY_1_QUESTION extends ActionBarActivity {
String s1="",s3="",s4="";
    EditText txt2,txt4,txt6,txt8,txt9,txt10,txt11,txt13;
    Button b1;
    AlertDialog al;
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_1__question);
        s3=""+getIntent().getStringExtra("code");
        s4=""+getIntent().getStringExtra("q_nos");
        txt2=(EditText)findViewById(R.id.txt2);
        txt4=(EditText)findViewById(R.id.txt4);
        txt6=(EditText)findViewById(R.id.txt6);
        txt8=(EditText)findViewById(R.id.txt8);
        txt9=(EditText)findViewById(R.id.txt9);
        txt10=(EditText)findViewById(R.id.txt10);
        txt11=(EditText)findViewById(R.id.txt11);
        txt13=(EditText)findViewById(R.id.txt13);
        al=new AlertDialog.Builder(this).create();
        b1=(Button)findViewById(R.id.b1);
       func1quespaper();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_1__question, menu);
        return true;
    }
public void func1quespaper()
{

    s1="SELECT* FROM PAPER WHERE (PAPER_CODE=='"+s3+"') AND (Q_NO=="+s4+");";
    Cursor c;
    try {
        SQLiteDatabase dbase;
        dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
        c=dbase.rawQuery(s1,null);
        if(c.move(1))
        {
            txt2.setText("" +c.getString(0));
            txt4.setText("" +c.getString(1));
            txt6.setText("" +c.getString(2));
            txt8.setText("" +c.getString(3));
            txt9.setText("" +c.getString(4));
            txt10.setText("" +c.getString(5));
            txt11.setText("" +c.getString(6));
            txt13.setText("" +c.getString(7));
            flag=1;
        }

        Toast.makeText(this, "question displayed:", Toast.LENGTH_LONG).show();
    }catch(Exception E)
    {
        Toast.makeText(this,"error found no such paper code or question exist:"+E, Toast.LENGTH_LONG).show();
    }
if(flag==0)
{
    AlertD1();
}
}

public void OnClickOK(View v1)
{
    Intent h1=new Intent(this,ADMIN_MENU.class);
    startActivity(h1);
    finish();
}
    public void AlertD1()
    {
        al.setTitle("Alert");
        al.setMessage("Either wrong question no. or paper code   Do you want to change values?");
        al.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                choicedialog(1);

            }
        });
        al.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                choicedialog(2);
            }
        });

        al.show();

    }
    public void choicedialog(int xx)
    {
        if(xx==1)
        {
            Intent h1=new Intent(this,DISPLAY_PAPER_CODE.class);
            startActivity(h1);
            finish();
        }
        else if(xx==2)
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

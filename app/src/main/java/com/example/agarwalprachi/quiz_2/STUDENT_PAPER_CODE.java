package com.example.agarwalprachi.quiz_2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;


public class STUDENT_PAPER_CODE extends ActionBarActivity {
String s1="";
    AutoCompleteTextView txt2;
    String aa1[];
    ArrayAdapter ad;
    static int norow=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__paper__code);
        txt2=(AutoCompleteTextView)findViewById(R.id.txt2);
        Display();
        aa1=new String[norow];
       Display1();
        func();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_student__paper__code, menu);
        return true;
    }

    public void Display()
    {
        s1="SELECT DISTINCT PAPER_CODE FROM PAPER";
        Cursor c;
        String s6="",s7="";
        try {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
            c=dbase.rawQuery(s1, null);
            int i=0;
            while(c.move(1))
            {
                i++;
            }
            norow=i;
            Toast.makeText(this, "first query run", Toast.LENGTH_LONG).show();

        }catch(Exception E)
        {
            Toast.makeText(this, "error found cannot select1:" + E, Toast.LENGTH_LONG).show();
        }
    }

    public void Display1()
    {
        // g=new String[norow];
        s1="SELECT DISTINCT PAPER_CODE FROM PAPER";
        Cursor c;
        String s6="",s7="";
        try {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
            c=dbase.rawQuery(s1, null);
            int i=0;
            while(c.move(1))
            {
                aa1[i]=c.getString(0);
                s6+="--"+c.getString(0);
               // Toast.makeText(this, "row " + aa1[i] + "**", Toast.LENGTH_LONG).show();
                i++;
            }
            Toast.makeText(this, "row selected:" + s6 + "**", Toast.LENGTH_LONG).show();

        }catch(Exception E)
        {
            Toast.makeText(this,"error found cannot select:"+E, Toast.LENGTH_LONG).show();
        }
    }


    public void func() {
        ad = new ArrayAdapter(this, android.R.layout.simple_list_item_1, aa1);
        if (ad != null) {
            txt2.setThreshold(1);
            txt2.setAdapter(ad);
        }
    }
public  void OnStartExam(View v1)
{
    Intent h3=new Intent(this,START_EXAM.class);
   String s5=""+txt2.getText();
    h3.putExtra("code", s5);
    startActivity(h3);
    finish();


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

package com.example.agarwalprachi.quiz_2;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class CREATE_DATABASE extends ActionBarActivity {
String s1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__database);
        OnCreatePaper();
        OnCreateStudent();
        OnCreateTeacher();
        OnCreateLogin();
        Intent h1 = new Intent(this, LOGIN.class);
        startActivity(h1);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create__database, menu);
        return true;
    }


    public void OnCreatePaper()
    {
        s1="CREATE TABLE PAPER (PAPER_CODE TEXT(3),Q_NO NUMBER,QUES TEXT(400),OPT_A TEXT(25),OPT_B TEXT(25),OPT_C TEXT(25),OPT_D TEXT(25),CORRECT_OPT TEXT(25));" ;
        try
        {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE,null);
            Toast.makeText(this, "database created paper", Toast.LENGTH_LONG).show();
            dbase.execSQL(s1);
            Toast.makeText(this, "table created paper", Toast.LENGTH_LONG).show();
        }

        catch(Exception E)
        {
            Toast.makeText(this, "error found cant create paper" + E, Toast.LENGTH_LONG).show();
        }
    }

    public void OnCreateTeacher()
    {
        s1="CREATE TABLE TEACHER_LOGIN (LOGIN_NAME TEXT(30) PRIMARY KEY,PASSWORD TEXT(30));" ;
        try
        {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE,null);
            Toast.makeText(this, "database created teacher", Toast.LENGTH_LONG).show();
            dbase.execSQL(s1);
            Toast.makeText(this, "table created teacher_login", Toast.LENGTH_LONG).show();
        }

        catch(Exception E)
        {
            Toast.makeText(this, "error found" + E, Toast.LENGTH_LONG).show();
        }
    }


    public void OnCreateStudent()
    {
        s1="CREATE TABLE STUDENT_DETAIL (TEACHER_LOGIN_NAME TEXT(30),STUDENT_NAME TEXT(30),PAPER_CODE TEXT(3),MARKS NUMBER);" ;
        try
        {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE,null);
            Toast.makeText(this, "database created STUDENT", Toast.LENGTH_LONG).show();
            dbase.execSQL(s1);
            Toast.makeText(this, "table created student", Toast.LENGTH_LONG).show();
        }

        catch(Exception E)
        {
            Toast.makeText(this, "error found in student" + E, Toast.LENGTH_LONG).show();
        }
    }



    public void OnCreateLogin()
    {
        s1="CREATE TABLE LOGIN (USERNAME TEXT(30) ,PASSWORD TEXT(30));" ;
        try
        {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE,null);
            Toast.makeText(this, "database created login", Toast.LENGTH_LONG).show();
            dbase.execSQL(s1);
            Toast.makeText(this, "table created login", Toast.LENGTH_LONG).show();
        }

        catch(Exception E)
        {
            Toast.makeText(this, "error found in login" + E, Toast.LENGTH_LONG).show();
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

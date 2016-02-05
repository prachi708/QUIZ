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
import android.widget.EditText;
import android.widget.Toast;

import com.example.agarwalprachi.quiz_2.R;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;


public class CREATE_TEACHER_LOGIN extends ActionBarActivity {
EditText txt3,txt4,txt6;
    String s1="",s2="",s3="",s4="";
    int i=0,i_total,flag=0;
    //String loginname[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__teacher__login);
        txt3=(EditText)findViewById(R.id.txt3);
        txt4=(EditText)findViewById(R.id.txt4);
        txt6=(EditText)findViewById(R.id.txt6);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create__teacher__login, menu);
        return true;
    }


    public void OnCreateTeacherLogin(View v1)
{
   s2=""+txt3.getText();
    s3=""+txt4.getText();
    s4=""+txt6.getText();
 if(s2.equals("")||(s3.equals("")||(s4.equals(""))))
 {
     Toast.makeText(this,"Enter values:", Toast.LENGTH_LONG).show();
 }
else if(s3.equals(s4)==false)
 {
     Toast.makeText(this,"passwords do not match:", Toast.LENGTH_LONG).show();
 }
    else
 {

     s1="SELECT LOGIN_NAME FROM TEACHER_LOGIN;";
     Cursor c;
     i=0;
     {
         try {
             SQLiteDatabase dbase;
             dbase = openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
             c = dbase.rawQuery(s1, null);
             while (c.move(1)) {
                 if (s2.equals(c.getString(0))) {
                     {
                         flag = 1;
                         break;
                     }
                 }
                 //loginname[i]=c.getString(0);
             }
             Toast.makeText(this, "all login name selected1:", Toast.LENGTH_LONG).show();
         } catch (Exception E) {
             Toast.makeText(this, "error found no login name selected1:" + E, Toast.LENGTH_LONG).show();
         }
     }
     if(flag==0) {

         OnAddTeacherLogin();
         OnCallAdminMenu();
     }
     else if(flag==1)
     {
         Toast.makeText(this,"user name already exist.Enter different username:", Toast.LENGTH_LONG).show();
     }
 }
}
public void OnCallAdminMenu()
{

    Intent h1=new Intent(this,ADMIN_MENU.class);
    startActivity(h1);
    finish();


}
    public void OnAddTeacherLogin()
    {
        s1="INSERT INTO TEACHER_LOGIN VALUES ('"+s2+"','"+s3+"');";
        try
        {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE,null);
            dbase.execSQL(s1);
            Toast.makeText(this, "value inserted in teacher login::", Toast.LENGTH_LONG).show();
        }

        catch(Exception E)
        {
            Toast.makeText(this, "error found cannot insert in teacher login::" + E, Toast.LENGTH_LONG).show();
        }



        s1="INSERT INTO LOGIN VALUES ('"+s2+"','"+s3+"');";
        try
        {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE,null);
            dbase.execSQL(s1);
            Toast.makeText(this, "value inserted in login::", Toast.LENGTH_LONG).show();
        }

        catch(Exception E)
        {
            Toast.makeText(this, "error found cannot insert in login::" + E, Toast.LENGTH_LONG).show();
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

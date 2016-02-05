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
import android.widget.Button;
import android.widget.Toast;

import com.example.agarwalprachi.quiz_2.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class LOGIN extends ActionBarActivity {
    Button b1,b2;
    String user_name[]=new String[2];
    String s1="",s9="",username="",password="";
    //char password[]=new char[30];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    public void OnClickAdmin(View v1)
    {
       // Toast.makeText(this, "1" , Toast.LENGTH_LONG).show();
            s1="SELECT * FROM LOGIN";
       // Toast.makeText(this, "2" , Toast.LENGTH_LONG).show();
            Cursor c;
            String s6="";
            try {
                SQLiteDatabase dbase;
                dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
                c=dbase.rawQuery(s1, null);
                while(c.move(1))
                {
                    username=c.getString(0);
                    password=c.getString(1);
                    s6+="--"+c.getString(1);
                    s9=""+username+" "+password;

                }
                Toast.makeText(this, "row selected:" + s6 + "  "+s9+"***" , Toast.LENGTH_LONG).show();
            }
            catch(Exception E)
            {
                Toast.makeText(this,"error found cannot select:"+E, Toast.LENGTH_LONG).show();
            }


        if(username.equals(""))
        {
                Intent h1=new Intent(this,CREATE_TEACHER_LOGIN.class);
                startActivity(h1);
                //finish();

            Toast.makeText(this,"VALUE IN DATABASE IS NULL", Toast.LENGTH_LONG).show();

        }

        else
        {
            Toast.makeText(this, "aa" + s9, Toast.LENGTH_SHORT).show();
            Intent h1 = new Intent(this, ADMIN_LOGIN.class);
            h1.putExtra("usernpass", s9);
            startActivity(h1);
            //finish();
         }
            Toast.makeText(this,"VALUE EXIST IN DATABASE", Toast.LENGTH_LONG).show();
        }

    public void OnClickStudent(View v1)
    {
       Intent h1=new Intent(this,STUDENT_LOGIN.class);
        startActivity(h1);
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

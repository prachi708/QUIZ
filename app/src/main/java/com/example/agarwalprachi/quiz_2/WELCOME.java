package com.example.agarwalprachi.quiz_2;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class WELCOME extends ActionBarActivity {
    String user_name[]=new String[2];
    String db_table[]=new String[10];
    String s1="",s2="",s9="",username="",password="";
    int i1=0,flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        OnCheckDatabase();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
        return true;
    }

public void CallIntent()
{
    if(flag==0)
    {
        Intent h1=new Intent(this,CREATE_DATABASE.class);
        startActivity(h1);
        finish();

        Toast.makeText(this,"VALUE IN DATABASE IS NULL", Toast.LENGTH_LONG).show();

    }

    else if(flag==1)
    {
        Toast.makeText(this, "aa" + s9, Toast.LENGTH_SHORT).show();
        Intent h1 = new Intent(this, LOGIN.class);
        startActivity(h1);
        finish();
    }

}

    public void ds()
    {
        {
            Handler h1=new Handler();
            h1.postDelayed(new Runnable()
            {
                public void run()
                {
                    CallIntent();
                }
            }
                    ,5000);
        }
    }




    public void OnCheckDatabase()
    {
        s1="SELECT name FROM sqlite_master WHERE name='LOGIN';";
        Toast.makeText(this, "hello hello", Toast.LENGTH_LONG).show();
        Cursor c;
        {
            try {
                SQLiteDatabase dbase;
                dbase = openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
                c = dbase.rawQuery(s1, null);
                while (c.move(1)) {
                    db_table[i1] = c.getString(0);
                    i1++;
                    s2+=c.getString(0)+"  ";
                    flag=1;
                    Toast.makeText(this, "table name"+s2, Toast.LENGTH_LONG).show();
                }
            }
            catch(Exception E)
            {
                Toast.makeText(this, "error found no login name selected1:" + E, Toast.LENGTH_LONG).show();
            }
        }
        Toast.makeText(this,"VALUE EXIST IN DATABASE", Toast.LENGTH_LONG).show();
        ds();
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

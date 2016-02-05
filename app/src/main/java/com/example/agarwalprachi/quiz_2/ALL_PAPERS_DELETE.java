package com.example.agarwalprachi.quiz_2;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.agarwalprachi.quiz_2.R;


public class ALL_PAPERS_DELETE extends ActionBarActivity {
String s1;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__papers__delete);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_all__papers__delete, menu);
        return true;
    }

    public void OnAllPaperDelete(View v1)
    {

        s1="DELETE FROM PAPER" ;
        try
        {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE,null);
            dbase.execSQL(s1);
            Toast.makeText(this, "All papers deleted::", Toast.LENGTH_LONG).show();

        }

        catch(Exception E)
        {
            Toast.makeText(this, "error cannot delete all papers as no database or table exist::" + E, Toast.LENGTH_LONG).show();
        }

    }


    public void OnNoPaperDelete(View v1)
    {
        Intent h1=new Intent(this,ADMIN_MENU.class);
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

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


public class STUDENT_LOGIN extends ActionBarActivity {
EditText txt2;
    String s1="",s2="";
    int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__login);
        txt2=(EditText)findViewById(R.id.txt2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_student__login, menu);
        return true;
    }



    public void SelectingteacherLogin(View v1)
    {
        s1=""+txt2.getText();
        s2="SELECT* FROM TEACHER_LOGIN WHERE (LOGIN_NAME=='"+s1+"');";
        Cursor c;
        try {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
            c=dbase.rawQuery(s2,null);
            while(c.move(1)) {
                flag=1;
            }
            Toast.makeText(this, "record exists:", Toast.LENGTH_LONG).show();
        }catch(Exception E)
        {
            Toast.makeText(this,"error error error!!!:"+E, Toast.LENGTH_LONG).show();
        }
if(flag==1)
{
    Intent h1=new Intent(this,STUDENT_PAPER_CODE.class);
    startActivity(h1);
    finish();
}
        else if(flag==0)
{
    Toast.makeText(this, "NO SUCH TEACHER EXISTS", Toast.LENGTH_LONG).show();
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

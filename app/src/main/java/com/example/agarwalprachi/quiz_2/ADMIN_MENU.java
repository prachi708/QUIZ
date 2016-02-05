package com.example.agarwalprachi.quiz_2;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agarwalprachi.quiz_2.R;


public class ADMIN_MENU extends ActionBarActivity {
ArrayAdapter ad;
    String s1="",s2="";
    String list[]={"1. ADD QUESTIONS","2. UPDATE QUESTION","3. DELETE QUESTION/QUESTION PAPER","4. DELETE ALL QUESTION PAPERS","5. DISPLAY QUESTION/QUESTION PAPER","6. DISPLAY ALL QUESTION PAPERS"};
    ListView lv1;
    int i=0,choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__menu);
        lv1=(ListView)findViewById(R.id.lv1);
       // OnCreate();
        func();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_admin__menu, menu);
        return true;
    }


    public void func()
    {
        ad=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);
        if(ad!=null)
        {

            lv1.setAdapter(ad);
            lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                    s2=""+((TextView)view).getText().toString();
                    Toast.makeText(getApplicationContext(), "Selected"+s2, Toast.LENGTH_SHORT).show();
                    //  Place code here with the action

                    if(s2.equals("1. ADD QUESTIONS"))
                    {
                      choice=1;
                        OnMenuCall();
                    }
                   else if(s2.equals("2. UPDATE QUESTION"))
                    {
                        choice=2;
                        OnMenuCall();
                    }
                    else if(s2.equals("3. DELETE QUESTION/QUESTION PAPER"))
                    {
                        choice=3;
                        OnMenuCall();
                    }
                    else if(s2.equals("4. DELETE ALL QUESTION PAPERS"))
                    {
                        choice=4;
                        OnMenuCall();
                    }
                    else if(s2.equals("5. DISPLAY QUESTION/QUESTION PAPER"))
                    {
                        choice=5;
                        OnMenuCall();
                    }
                    else if(s2.equals("6. DISPLAY ALL QUESTION PAPERS"))
                    {
                        choice=6;
                        OnMenuCall();
                    }


                }
            });

        }

    }


    public void OnMenuCall()
    {
        if(choice==1)
        {
            Intent h1=new Intent(this,ADD_PAPER_CODE.class);
            startActivity(h1);


        }
       else if(choice==2)
        {
            Intent h1=new Intent(this,UPDATE_PAPER_CODE.class);
            startActivity(h1);

        }
        else if(choice==3)
        {
            Intent h1=new Intent(this,DELETE_QUESTION.class);
            startActivity(h1);

        }
        else if(choice==4)
        {
            Intent h1=new Intent(this,ALL_PAPERS_DELETE.class);
            startActivity(h1);

        }
        else if(choice==5)
        {
            Intent h1=new Intent(this,DISPLAY_PAPER_CODE.class);
            startActivity(h1);

        }
        else if(choice==6)
        {
            Intent h1=new Intent(this,DISPLAY_ALL_PAPERS.class);
            startActivity(h1);

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

package com.example.agarwalprachi.quiz_2;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agarwalprachi.quiz_2.R;


public class DISPLAY_1_PAPER extends ActionBarActivity {
String s1="",s2="",s3="";
    int i1=0,i_total;
    String q_paper[][]=new String[400][7];
    ScrollView sv1;
    int flag=0;
    AlertDialog al;
    HorizontalScrollView hsv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_1__paper);
        s3=""+getIntent().getStringExtra("code");
        hsv1=(HorizontalScrollView)findViewById(R.id.hsv1);
        al=new AlertDialog.Builder(this).create();
        DisplayCompleteQuestionPaper();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_1__paper, menu);
        return true;
    }

    public void OnAdminMenuCall(View v1)
    {
        Intent h1=new Intent(this,ADMIN_MENU.class);
        startActivity(h1);
    }
    public void DisplayCompleteQuestionPaper()
    {
        s1="SELECT * FROM PAPER WHERE PAPER_CODE=='"+s3+"'";
        Cursor c;
        String s6="";
        try {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
            c=dbase.rawQuery(s1, null);
            while(c.move(1))
            {
                q_paper[i1][0]=c.getString(1);
                q_paper[i1][1]=c.getString(2);
                q_paper[i1][2]=c.getString(3);
                q_paper[i1][3]=c.getString(4);
                q_paper[i1][4]=c.getString(5);
                q_paper[i1][5]=c.getString(6);
                q_paper[i1][6]=c.getString(7);
                s6+="--"+c.getString(1);
                i1++;
                flag=1;
            }
            i_total=i1;
            Toast.makeText(this, "row selected:" + s6 + "***" + i_total, Toast.LENGTH_LONG).show();
            i1=0;
        }
        catch(Exception E)
        {
            Toast.makeText(this,"error found cannot select:"+E, Toast.LENGTH_LONG).show();
        }
        if(flag==1) {
            click12();
        }
        else if(flag==0)
        {
            AlertD1();
        }
    }


    public void AlertD1()
    {
        al.setTitle("Alert");
        al.setMessage("Wrong paper code   Do you want to change values?");
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



    public void click12()
    {
        int ix=0;
        TableLayout t1 = new TableLayout(this);
        //hsv1=new HorizontalScrollView(this);
        TableRow tr=new TableRow(this);
        tr.setId(ix);
        TextView trh1,trh2,trh3,trh4,trh5,trh6;
        //tr.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT));
        trh1 = new TextView(this);
        trh2 = new TextView(this);
        trh3 = new TextView(this);
        trh4 = new TextView(this);
        trh5 = new TextView(this);
        trh6 = new TextView(this);
        trh1.setId(ix++);
        trh2.setId(ix++);
        trh3.setId(ix++);
        trh4.setId(ix++);
        trh5.setId(ix++);
        trh6.setId(ix++);
        trh1.setText("Q_No.");
        trh2.setText("QUESTION");
        trh3.setText("OPTION 'A'");
        trh4.setText("OPTION 'B'");
        trh5.setText("OPTION 'C'");
        trh6.setText("OPTION 'D'");
        trh1.setTypeface(null, Typeface.BOLD);
        trh2.setTypeface(null, Typeface.BOLD);
        trh3.setTypeface(null, Typeface.BOLD);
        trh4.setTypeface(null, Typeface.BOLD);
        trh5.setTypeface(null, Typeface.BOLD);
        trh6.setTypeface(null, Typeface.BOLD);
        trh1.setTextColor(Color.BLACK);
        trh2.setTextColor(Color.BLACK);
        trh3.setTextColor(Color.BLACK);
        trh4.setTextColor(Color.BLACK);
        trh5.setTextColor(Color.BLACK);
        trh6.setTextColor(Color.BLACK);
        tr.setBackgroundColor(Color.YELLOW);
        tr.addView(trh1);
        tr.addView(trh2);
        tr.addView(trh3);
        tr.addView(trh4);
        tr.addView(trh5);
        tr.addView(trh6);
        t1.addView(tr, new TableLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        for(int j=0;j<i_total;j++)
        {
            tr= new TableRow(this);
            int i = 10;
            tr.setId(i+j);
            tr.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT));//this is fixed syntax
            TextView ts0,ts1,ts2,ts3,ts4,ts5;
            ts0 = new TextView(this);
            ts1 = new TextView(this);
            ts2 = new TextView(this);
            ts3 = new TextView(this);
            ts4 = new TextView(this);
            ts5=new TextView(this);
            ts0.setId(i + 10 + j);
            ts0.setPadding(30, 1, 1, 1);
            ts0.setText(q_paper[i1][0]);
            ts1.setId(i + 50 + j);
            ts1.setPadding(50, 1, 1, 1);
           // ts1.setBackgroundColor(Color.GREEN);
            ts1.setText(q_paper[i1][1]);
            ts1.setSingleLine(true);
            ts1.setTypeface(null, Typeface.ITALIC);
            ts2.setId(i + 90 + j);
            ts2.setPadding(30, 1, 1, 1);
            ts2.setText(q_paper[i1][2]);
            ts3.setId(i + 50 + j + i);
            ts3.setPadding(50, 1, 1, 1);
           // ts3.setBackgroundColor(Color.GREEN);
            ts3.setText(q_paper[i1][3]);
            ts4.setId(i + 190 + j);
            ts4.setPadding(30, 1, 1, 1);
            ts4.setText(q_paper[i1][4]);
            ts5.setId(i + 50 + j + i);
            ts5.setPadding(50, 1, 1, 1);
            //ts5.setBackgroundColor(Color.GREEN);
            ts5.setText(q_paper[i1][5]);

            if((j%2)==0) {
                tr.setBackgroundColor(Color.BLUE);
            }
            else {
                tr.setBackgroundColor(Color.TRANSPARENT);
            }
            tr.addView(ts0);
            tr.addView(ts1);
            tr.addView(ts2);
            tr.addView(ts3);
            tr.addView(ts4);
            tr.addView(ts5);
            t1.addView(tr, new TableLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));//this is fixed syntax
            i1++;
        }
        hsv1.addView(t1);

        //sv1.addView(t1);
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

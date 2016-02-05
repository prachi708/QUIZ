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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class UPDATE_QUESTION extends ActionBarActivity {
    String s1="",s2="",s3="",s4="",s5="",s6="",s7="",s8="",s9="";
    ImageButton imb1;
    EditText txt2,txt4,txt5,txt6,txt7,txt9;
    int i=1,flag=0;
    AlertDialog al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__question);
        txt2=(EditText)findViewById(R.id.txt2);
        txt4=(EditText)findViewById(R.id.txt4);
        txt5=(EditText)findViewById(R.id.txt5);
        txt6=(EditText)findViewById(R.id.txt6);
        txt7=(EditText)findViewById(R.id.txt7);
        txt9=(EditText)findViewById(R.id.txt9);
        al=new AlertDialog.Builder(this).create();
        //Intent h2=new Intent(this,UPDATE_PAPER_CODE.class);
        s3=""+getIntent().getStringExtra("code");
        s8=""+getIntent().getStringExtra("q_nos");
        s1="SELECT* FROM PAPER WHERE (PAPER_CODE=='"+s3+"') AND (Q_NO=="+s8+");";
        Cursor c;
        try {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE,null);
            c=dbase.rawQuery(s1,null);
            while(c.move(1)) {
                txt2.setText("" +c.getString(2));
                txt4.setText("" +c.getString(3));
                txt5.setText("" +c.getString(4));
                txt6.setText("" +c.getString(5));
                txt7.setText("" +c.getString(6));
                txt9.setText("" +c.getString(7));
                Toast.makeText(this, "question selected:", Toast.LENGTH_LONG).show();
                flag=1;
            }

        }catch(Exception E)
        {
            Toast.makeText(this,"error found no such paper code or question exist:"+E, Toast.LENGTH_LONG).show();
        }
        if(flag==0)
            AlertD1();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update__question, menu);
        return true;
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
            Intent h1=new Intent(this,UPDATE_PAPER_CODE.class);
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



    public void OnUpdate(View v1)
    {

        s2=""+txt2.getText();
        s4=""+txt4.getText();
        s5=""+txt5.getText();
        s6=""+txt6.getText();
        s7=""+txt7.getText();
        s9=""+txt9.getText();
        s1="UPDATE PAPER SET   QUES='"+s2+"',OPT_A='"+s4+"',OPT_B='"+s5+"',OPT_C='"+s6+"',OPT_D='"+s7+"',CORRECT_OPT='"+s9+"' WHERE (PAPER_CODE=='"+s3+"') AND (Q_NO=="+s8+");";
        try
        {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE,null);
            dbase.execSQL(s1);
            Toast.makeText(this, "value updated::", Toast.LENGTH_LONG).show();
            i++;
        }
        catch(Exception E)
        {
            Toast.makeText(this, "error found cannot update::" + E, Toast.LENGTH_LONG).show();
        }
        Intent h1=new Intent(this,ADMIN_MENU.class);
        startActivity(h1);
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

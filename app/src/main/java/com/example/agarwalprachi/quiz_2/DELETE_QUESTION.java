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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.agarwalprachi.quiz_2.R;


public class DELETE_QUESTION extends ActionBarActivity {
EditText txt2,txt5;
    TextView txt4;
    Button b1,b2,b3;
    int flag=0;
    AlertDialog al,al1;
    String s1="",s2="",s3="",s4="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete__question);
        txt2=(EditText)findViewById(R.id.txt2);
        txt5=(EditText)findViewById(R.id.txt5);
       txt4=(TextView)findViewById(R.id.txt4);
        b3=(Button)findViewById(R.id.b3);
        al=new AlertDialog.Builder(this).create();
        al1=new AlertDialog.Builder(this).create();
      txt4.setVisibility(View.INVISIBLE);
        txt5.setVisibility(View.INVISIBLE);
       b3.setVisibility(View.INVISIBLE);
       // b3.setEnabled(false);
       // s2=""+txt2.getText();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_delete__question, menu);
        return true;
    }


    public void OnCompletePaperDelete(View v1) {
        s2 = "" + txt2.getText();
        if (s2.equals("")) {
            Toast.makeText(this, "Enter paper code", Toast.LENGTH_SHORT).show();
            AlertD();
        } else {
            s1 = "SELECT* FROM PAPER WHERE PAPER_CODE=='" + s2 + "';";
            Cursor c;
            try {
                SQLiteDatabase dbase;
                dbase = openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
                c = dbase.rawQuery(s1, null);
                if (c.move(1)) {
                    flag = 1;
                }

                Toast.makeText(this, "questions exists:", Toast.LENGTH_LONG).show();
            } catch (Exception E) {
                Toast.makeText(this, "questions error:" + E, Toast.LENGTH_LONG).show();
            }

            if (flag == 1) {
                s1 = "DELETE FROM PAPER WHERE PAPER_CODE='" + s2 + "'";
                try {
                    SQLiteDatabase dbase;
                    dbase = openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
                    dbase.execSQL(s1);
                    Toast.makeText(this, "Complete paper deleted::", Toast.LENGTH_LONG).show();
                } catch (Exception E) {
                    Toast.makeText(this, "error cannot delete as no database or table exist::" + E, Toast.LENGTH_LONG).show();
                }
            }
            else if(flag==0)
            {
                AlertD1();
            }
        }
    }

    public void AlertD()
    {
        al1.setTitle("Alert");
        al1.setMessage("Value missing.Enter value");
        al1.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //choicedialog();
                al1.dismiss();
            }
        });
        al1.show();
    }

    public void AlertD1()
    {
        al.setTitle("Alert");
        al.setMessage("Wrong value(s) entered   Do you want to change values?");
        al.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                al.dismiss();
            }
        });
        al.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choicedialog();
            }
        });
        al.show();

    }
    public void choicedialog()
    {
            Intent h1=new Intent(this,ADMIN_MENU.class);
            startActivity(h1);
            finish();
    }
public void OnOneQuestionDelete(View v1)
{
    txt4.setVisibility(View.VISIBLE);
    txt5.setVisibility(View.VISIBLE);
    b3.setVisibility(View.VISIBLE);
}

    public void OnDelete(View v1)
     {
         s2=""+txt2.getText();
        s3=""+txt5.getText();
         if(s2.equals("")||s3.equals(""))
         {
             Toast.makeText(this, "Enter paper code", Toast.LENGTH_SHORT).show();
             AlertD();
         }
         else {

             s1 = "SELECT* FROM PAPER WHERE (PAPER_CODE='" + s2 + "') AND (Q_NO==" + s3 + ")";
             Cursor c;
             try {
                 SQLiteDatabase dbase;
                 dbase = openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
                 c = dbase.rawQuery(s1, null);
                 if (c.move(1)) {
                     flag = 1;
                 }

                 Toast.makeText(this, "questions exists:", Toast.LENGTH_LONG).show();
             } catch (Exception E) {
                 Toast.makeText(this, "questions error:" + E, Toast.LENGTH_LONG).show();
             }

             if (flag == 1) {
                 s1="DELETE FROM PAPER WHERE (PAPER_CODE='" + s2 + "') AND (Q_NO==" + s3 + ");";
                 try {
                     SQLiteDatabase dbase;
                     dbase = openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
                     dbase.execSQL(s1);
                     Toast.makeText(this, "Complete paper deleted::", Toast.LENGTH_LONG).show();
                 } catch (Exception E) {
                     Toast.makeText(this, "error cannot delete as no database or table exist::" + E, Toast.LENGTH_LONG).show();
                 }
             }
             else if(flag==0)
             {
                 AlertD1();
             }
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

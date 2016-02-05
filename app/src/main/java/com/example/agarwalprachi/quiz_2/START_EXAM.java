package com.example.agarwalprachi.quiz_2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.agarwalprachi.quiz_2.R.drawable.abc_cab_background_top_material;


public class START_EXAM extends ActionBarActivity {
    String s1="",s2="",s3="";
    int norow=0;
    int iq=1,iy=0,iz=0;
    EditText txt1,txt2;
    RadioButton rb1,rb2,rb3,rb4;
    int min=0,sec=0;
    RadioGroup rg1;
    String aa[];
    RelativeLayout aaa;
    TextView txt3;
    AlertDialog al;
    int correct=0;
    String q_paper[][];
    String c_ans[];

    @Override
    public boolean onKeyDown(int k, KeyEvent e) {
        Toast.makeText(this, "You are not allowed to quit before submitting", Toast.LENGTH_SHORT).show();
       // if(k==KeyEvent.KEYCODE_HOME)
       // finish();
        return true;
        // return super.onKeyDown(keyCode, event);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__exam);
        s3=""+getIntent().getStringExtra("code");
        txt1=(EditText)findViewById(R.id.txt1);
        txt2=(EditText)findViewById(R.id.txt2);
        txt3=(TextView)findViewById(R.id.txt3);
        rb1=(RadioButton)findViewById(R.id.rb1);
        rb2=(RadioButton)findViewById(R.id.rb2);
        rb3=(RadioButton)findViewById(R.id.rb3);
        rb4=(RadioButton)findViewById(R.id.rb4);
        rg1=(RadioGroup)findViewById(R.id.rg1);
        aaa=(RelativeLayout)findViewById(R.id.aaa);
        al=new AlertDialog.Builder(this).create();
        //timer();
        Display();
        Display1();
        Question1();
        ds(0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start__exam, menu);
        return true;
    }
    public void Display()
    {
        s1="SELECT* FROM PAPER WHERE PAPER_CODE=='"+s3+"';";
        Cursor c;
        String s6="",s7="";
        try {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
            c=dbase.rawQuery(s1, null);
            int i=0;
            while(c.move(1))
            {
                i++;
            }
            norow=i;
            aa=new String[norow];
            q_paper=new String[norow][7];
            c_ans=new String[norow];
            Toast.makeText(this, "first query run", Toast.LENGTH_LONG).show();
        }catch(Exception E)
        {
            Toast.makeText(this, "error found cannot select1:" + E, Toast.LENGTH_LONG).show();
        }
    }

    public void Display1()
    {
        // g=new String[norow];
        s1="SELECT* FROM PAPER WHERE PAPER_CODE=='"+s3+"';";
        Cursor c;
        String s6="",s7="";
        try {
            SQLiteDatabase dbase;
            dbase=openOrCreateDatabase("QUIZ.db", Context.MODE_PRIVATE, null);
            c=dbase.rawQuery(s1, null);
            int i=0;
            while(c.move(1))
            {
               // aa[i]=c.getString(1);
                q_paper[i][0]=c.getString(1);
                q_paper[i][1]=c.getString(2);
                q_paper[i][2]=c.getString(3);
                q_paper[i][3]=c.getString(4);
                q_paper[i][4]=c.getString(5);
                q_paper[i][5]=c.getString(6);
                q_paper[i][6]=c.getString(7);
                s6+="--"+c.getString(1);
                s7+="*"+c.getString(7);
                // Toast.makeText(this, "row " + aa1[i] + "**", Toast.LENGTH_LONG).show();
                i++;
            }
            Toast.makeText(this, "row selected:" + s6 + "**", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "row selected:" + s7 + "**", Toast.LENGTH_LONG).show();

        }catch(Exception E)
        {
            Toast.makeText(this,"error found cannot select:"+E, Toast.LENGTH_LONG).show();
        }
    }

    public void ds(int i1)
    {

        {
            Handler h1=new Handler();
            h1.postDelayed(new Runnable()
            {
                public void run()
                {
                    if(sec==60)
                    {
                        min++;
                        sec=0;
                    }

                    txt3.setText(""+min+":"+sec);
                    sec++;
                    ds(0);
                }
            }
                    ,1000);

        }
    }
    public void Question1()
    {
        txt1.setText("" + q_paper[0][0]);
        txt2.setText("" + q_paper[0][1]);
        rb1.setText(""+q_paper[0][2]);
        rb2.setText(""+q_paper[0][3]);
        rb3.setText(""+q_paper[0][4]);
        rb4.setText(""+q_paper[0][5]);
    }
public void Questions(View v1)
{
    rg1.clearCheck();
   if(iq<norow) {
       txt1.setText("" + q_paper[iq][0]);
       txt2.setText("" + q_paper[iq][1]);
       rb1.setText("" + q_paper[iq][2]);
       rb2.setText("" + q_paper[iq][3]);
       rb3.setText("" + q_paper[iq][4]);
       rb4.setText("" + q_paper[iq][5]);
       iq++;

          //aaa.setBackgroundDrawable();
   }
  else
   {
          al.setTitle("Marks");
           al.setMessage("No. of Correct Answers: " + correct + "\nNo. of Wrong Answers: " + (norow - correct));
          // al.setMessage("/n No. of Wrong Answers:"+(norow-correct));
           al.setButton("OK", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {
                   //choicedialog();
                   al.dismiss();
                   OnCallNewActivity();
               }
           });
           al.show();

   }
}
    public void OnCallNewActivity()
    {
        Intent h1=new Intent(this,LOGIN.class);
        startActivity(h1);
        finish();
    }
public void OnClickSubmit(View v1) {
    if (iy < norow) {
        if (rb1.isChecked() && ((q_paper[iy][6].equals("a")) || (q_paper[iy][6].equals("1")))) {
            correct++;
            iy++;
            Toast.makeText(this,"Submitted",Toast.LENGTH_SHORT).show();
        }
       else if (rb2.isChecked() && ((q_paper[iy][6].equals("b")) || (q_paper[iy][6].equals("2")))) {
            correct++;
            iy++;
            Toast.makeText(this,"Submitted",Toast.LENGTH_SHORT).show();
        }
      else  if (rb3.isChecked() && ((q_paper[iy][6].equals("c")) || (q_paper[iy][6].equals("3")))) {
            correct++;
            iy++;
            Toast.makeText(this,"Submitted",Toast.LENGTH_SHORT).show();
        }
      else  if (rb2.isChecked() && ((q_paper[iy][6].equals("d")) || (q_paper[iy][6].equals("4")))) {
            correct++;
            iy++;
            Toast.makeText(this,"Submitted",Toast.LENGTH_SHORT).show();
        }
        else if((rb1.isChecked()==false)&&(rb2.isChecked()==false)&&(rb3.isChecked()==false)&&(rb4.isChecked()==false))
        {
            Toast.makeText(this,"Select one of the option",Toast.LENGTH_SHORT).show();
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

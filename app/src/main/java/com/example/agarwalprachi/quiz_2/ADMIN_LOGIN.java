package com.example.agarwalprachi.quiz_2;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.agarwalprachi.quiz_2.R;


public class ADMIN_LOGIN extends ActionBarActivity {
EditText txt3,txt4;
    ImageButton ib1;
    String s1="",s2="",s3="",s4="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        txt3=(EditText)findViewById(R.id.txt3);
        txt4=(EditText)findViewById(R.id.txt4);
        txt3.setBackgroundColor(Color.TRANSPARENT);
        txt4.setBackgroundColor(Color.TRANSPARENT);
        ib1=(ImageButton)findViewById(R.id.ib1);
        s4=getIntent().getStringExtra("usernpass");
       //txt3.setText(""+s4);
       // txt3.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_admin, menu);
        return true;
    }


    public void OnclickAdminLogin(View v1)
    {
        s1=""+txt3.getText();
        s2=""+txt4.getText();
        s3=""+s1+" "+s2;
        if(s3.equals(s4))
        {
            Intent h1=new Intent(this,ADMIN_MENU.class);
            startActivity(h1);
            finish();

        }
        else
        {
            Toast.makeText(this, "Either Username or Password is not Correct", Toast.LENGTH_LONG).show();

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

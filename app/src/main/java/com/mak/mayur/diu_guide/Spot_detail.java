package com.mak.mayur.diu_guide;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.TextView;

import static android.app.PendingIntent.getActivity;


public class Spot_detail extends Activity {


    String msg =" ";
    String[] des;
    String[] tit={"Chakratirth beach","Church of St.Thomas","Church of St.Francis of Assisi","Cycling track","Fort","Fortress of Panikota","Gangeshwar Temple","Ghoghla Beach","Gomtimata Beach","INS Khukri Memorial","Jallandhar Shrine","Nagar Seth Haveli","Nagoa Beach","Naida Caves","Shell Museum","St Paul's Church",};



    int[] images = {R.drawable.d_one, R.drawable.d_two, R.drawable.three, R.drawable.d_four,R.drawable.d_five, R.drawable.d_six, R.drawable.d_seven, R.drawable.d_eight,R.drawable.d_nine, R.drawable.d_ten, R.drawable.d_eleven, R.drawable.d_twelve,R.drawable.d_thirteen, R.drawable.d_fourteen, R.drawable.d_fifteen, R.drawable.d_sixteen};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spot_detail);


//        getSupportActionBar().setHomeButtonEnabled(true);
        //       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//            callthis(String msg);

        TextView tx = (TextView) findViewById(R.id.tv);
        ImageView iv = (ImageView) findViewById(R.id.imageView2);


        Intent intent = getIntent();

        Resources res = getResources();
        des = res.getStringArray(R.array.des);


        // msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        msg = intent.getStringExtra(Spot.EXTRA_MESSAGE);

        //     }
        tx.setText("" + msg);

        // Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        int msg_int = Integer.parseInt(msg);//typecast
//int msg_int=0;

        for (int i = 0; i < 16; i++) {


            if (msg_int == i)
            {


                setTitle(tit[i]);
                tx.setText("" + des[i]);
                iv.setImageResource(images[i]);
            }
        }


    }









/*
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_spot_detail, menu);
        return true;
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

*/

}

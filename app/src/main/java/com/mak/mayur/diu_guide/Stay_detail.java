package com.mak.mayur.diu_guide;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class Stay_detail extends Activity {

    ListView listView;
    String[] Shop_title;
    String[] Shop_add;

    // private SearchView mSearchView;

    String msg = " ";
    LVhelper adapter;


//    public static final String EXTRA_MESSAGE = "Message";
    //  int[] images = {R.drawable.attire, R.drawable.positivity, R.drawable.confidence, R.drawable.polite, R.drawable.posi3, R.drawable.speech4, R.drawable.knowqq, R.drawable.four, R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_stay_detail);


        Intent intent = getIntent();
        //    editText=(EditText)findViewById(R.id.search_txt);

        //     msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        msg = intent.getStringExtra(Stay.EXTRA_MESSAGE);

        //     }
//
        //   mSearchView = (SearchView) findViewById(R.id.searchView);
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();


        int msg_int = Integer.parseInt(msg);//typecast


        Resources res = getResources();


        switch (msg_int) {

            case 0:
                setTitle("Budget Hotels");
                Shop_title = res.getStringArray(R.array.l_Title);
                Shop_add = res.getStringArray(R.array.l_add);
                break;

            case 3:
                setTitle("Mid Range Hotels");
                Shop_title = res.getStringArray(R.array.m_Title);
                Shop_add = res.getStringArray(R.array.m_add);
                break;

            case 2:
                setTitle("Luxury Hotels");
                Shop_title = res.getStringArray(R.array.h_Title);
                Shop_add = res.getStringArray(R.array.h_add);
                break;


        }


        listView = (ListView) findViewById(R.id.mListView);

        adapter = new LVhelper(this, Shop_title, Shop_add);
        listView.setAdapter(adapter);


        // listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1,Shop_title));
        //  listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Shop_title));
        // listView.setTextFilterEnabled(true);
        //setupSearchView();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

//                Toast.makeText(getApplicationContext(),
//                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
//                        .show();


                //  Intent i = new Intent(List_2.this, com.example.mayur.vdr_guide.Menu.class);
                //  EditText editText =(EditText)findViewById(R.id.edit_message);

                //String msg = editText.getText().toString();
                // String msg = Integer.toString(position);


//                startActivity(i);
                //  Toast.makeText(this,"Next activity",Toast.LENGTH_LONG).show();


                //filter


            }
        });

    }


    class LVhelper extends ArrayAdapter<String> {
        Context context;
        //        int[] images;
        String[] titlearray;
        String[] addarray;

        LVhelper(Context c, String[] titles, String[] address) {

            super(c, R.layout.singlerow2, R.id.textView1, titles);
            this.context = c;
            //   this.images = imgs;
            this.titlearray = titles;
            this.addarray = address;

        }


        class MyViewHolder {

            //ImageView myimg;
            TextView mytxt;
            TextView myadd;


            MyViewHolder(View view) {

                //    myimg = (ImageView) view.findViewById(R.id.imageView);
                mytxt = (TextView) view.findViewById(R.id.textView1);
                myadd = (TextView) view.findViewById(R.id.textView2);
            }
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            MyViewHolder holder = null;
            if (row == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.singlerow2, parent, false);
                holder = new MyViewHolder(row);
                row.setTag(holder);
            } else {
                holder = (MyViewHolder) row.getTag();


            }


            // holder.myimg.setImageResource(images[position]);
            holder.mytxt.setText(titlearray[position]);
            holder.myadd.setText(addarray[position]);
            return row;


        }
    }





/*
    private void setupSearchView()
    {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setQueryHint("Search Here");
    }

    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            listView.clearTextFilter();
        }
        else
        {
            listView.setFilterText(newText.toString());
        }
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }


*/
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stay_detail, menu);
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


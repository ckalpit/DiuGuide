package com.mak.mayur.diu_guide;

import android.content.Intent;
//import android.support.v4.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.*;

import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;
/**
 * Created by Mayur on 05/06/2015.
 */

public class Spot extends Fragment
{

    public static final String TAG =Spot.class.getSimpleName();
    ListView listView;
    public static final String EXTRA_MESSAGE = "Message";




    public static Spot newInstance()
    {
        return new Spot();
    };

    private String[] mNames ={"Chakratirth beach","Church of St. Thomas","Church of St. Francis","Cycling track","Fort","Fortress of Panikota","Gangeshwar Temple","Ghoghla Beach","Gomtimata Beach","INS Khukri Memorial","Jallandhar Shrine","Nagar Seth Haveli","Nagoa Beach","Naida Caves","Shell Museum","St Paul's Church"};


//    private String[] mAnimals = { "Perro", "Gato", "Oveja", "Elefante", "Pez",
    //           "Nicuro", "Bocachico", "Chucha", "Curie", "Raton", "Aguila",
    //          "Leon", "Jirafa" };

    int[] flags = new int[]{
            R.drawable.chakra,
            R.drawable.fransi,
            R.drawable.st_thomas,
            R.drawable.caycal,
            R.drawable.fort,
            R.drawable.fortn_pani,
            R.drawable.gangeesh,
            R.drawable.ghoghla,
            R.drawable.gomtitmata,
            R.drawable.ins,
            R.drawable.jalandar,
            R.drawable.nagarsethhaveli,
            R.drawable.nago,
            R.drawable.naida,
            R.drawable.shel,
            R.drawable.paul,

    };


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i <16; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("txt","" + mNames[i]);
            //    hm.put("cur","creator : " + mAnimals[i]);
            hm.put("flag", Integer.toString(flags[i]));
            aList.add(hm);
        }
        String[] from = {"flag", "txt", "cur"};

        //     int[] to = { R.id.flag,R.id.txt,R.id.cur,R.id.textView2};
        int[] to = {R.id.imageView, R.id.textView1, R.id.textView2};



        View v = inflater.inflate(R.layout.fragment_spot, container, false);

        listView=(ListView)v.findViewById(R.id.listView1);

        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // When clicked, show a toast with the TextView text
                //     Toast.makeText(getApplicationContext(),

                Intent intent =new Intent(view.getContext(),Spot_detail.class);
                String msg = Integer.toString(position);
                intent.putExtra("Message",msg);
                getActivity().startActivity(intent);

/*                Spot demo = new Spot();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(android.R.id.content, demo);
                fragmentTransaction.commit();
*/
            }
     //       return demo;
        });




        ListView list = (ListView)v.findViewById(R.id.listView1);
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(),aList,R.layout.singlerow, from, to);
        list.setAdapter(adapter);
        return v;
        //this.getBaseContext()
/*
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(arg1.getContext(),MainActivity2.class);
                startActivity(intent);

            }
        });
*/



    }



}








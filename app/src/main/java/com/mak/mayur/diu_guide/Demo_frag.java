package com.mak.mayur.diu_guide;

import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class Demo_frag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String msg = " ";
    String[] des;
    String[] tit = {"Chakratirth beach", "Church of St.Thomas", "Church of St.Francis of Assisi", "Cycling track", "Fort", "Fortress of Panikota", "Gangeshwar Temple", "Ghoghla Beach", "Gomtimata Beach", "INS Khukri Memorial", "Jallandhar Shrine", "Nagar Seth Haveli", "Nagoa Beach", "Naida Caves", "Shell Museum", "St Paul's Church",};


    int[] images = {R.drawable.d_one, R.drawable.d_two, R.drawable.three, R.drawable.d_four, R.drawable.d_five, R.drawable.d_six, R.drawable.d_seven, R.drawable.d_eight, R.drawable.d_nine, R.drawable.d_ten, R.drawable.d_eleven, R.drawable.d_twelve, R.drawable.d_thirteen, R.drawable.d_fourteen, R.drawable.d_fifteen, R.drawable.d_sixteen};


//    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Demo_frag.
     */
    // TODO: Rename and change types and number of parameters
    public static Demo_frag newInstance(String param1, String param2) {
        Demo_frag fragment = new Demo_frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Demo_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_spot, container, false);

        TextView tx = (TextView) v.findViewById(R.id.textView);
        ImageView iv = (ImageView) v.findViewById(R.id.imageView2);


//        Intent intent = getIntent();

        Resources res = getResources();
        des = res.getStringArray(R.array.des);


        // msg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

    //    msg = intent.getStringExtra(Spot.EXTRA_MESSAGE);


        tx.setText("" + msg);

        // Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        int msg_int = Integer.parseInt(msg);//typecast


        for (int i = 0; i < 16; i++) {


            if (msg_int == i) {


                // setTitle(tit[i]);
                tx.setText("" + des[i]);
                iv.setImageResource(images[i]);
            }
        }

        return v;
    }

}
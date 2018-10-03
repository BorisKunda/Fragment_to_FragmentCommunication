package com.happytrees.fragmentfragmentcommunication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends Fragment {

    TextView tvB;
    FragmentBInterface fragmentBInterface;

    public FragmentB() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        tvB = v.findViewById(R.id.frBTV);
        Button btnB = v.findViewById(R.id.FrB_Btn);
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            fragmentBInterface.changeTextBtoA();
            }
        });
        return v;
    }

    void changeTextInB(String s) {
        tvB.setText(s);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentBInterface) {//context is instance of FragmentBInterface .if activity implemented this interface
            fragmentBInterface =  (FragmentBInterface)context;//casting main activity context to interface
        }else{
            Log.e("Main Activity"," must implement FragmentBInterface");
        }
    }
}

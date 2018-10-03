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
public class FragmentA extends Fragment {

    TextView tvA;
    FragmentAInterface fragmentAInterface;

    public FragmentA() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);

        tvA = v.findViewById(R.id.frATV);


        Button btn = v.findViewById(R.id.frABtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            fragmentAInterface.changeTextAtoB();
            }
        });

        return v;
    }

    void changeTextInA(String s) {
     tvA.setText(s);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentAInterface) {//means MainActivity implemented FragmentAInterface
            fragmentAInterface = (FragmentAInterface) context;//casting main activity context to interface
        }else{
            Log.e("Main Activity"," must implement FragmentAInterface");
        }

    }
}

package com.happytrees.fragmentfragmentcommunication;


import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentAInterface,FragmentBInterface{

    FragmentA fragmentA;
    FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frAcontainer,fragmentA ).commit();
        fragmentManager.beginTransaction().replace(R.id.frBcontainer,fragmentB ).commit();


    }

    @Override
    public void changeTextAtoB() {
        fragmentB.changeTextInB("click from fragment A through interface FragmentAInterface implemented in Main Activity");
    }


    @Override
    public void changeTextBtoA() {
        fragmentA.changeTextInA("click from fragment B through interface FragmentBInterface implemented in Main Activity");
    }
}

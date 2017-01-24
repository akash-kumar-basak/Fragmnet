package com.example.engineerakash.workingwithfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Object initialize of fragment class
    StartFragment startFragment = new StartFragment();
    AnimalFragment animalFragment = new AnimalFragment();
    CarFragment carFragment = new CarFragment();
    ColourFragment colourFragment = new ColourFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize fragment manager and fragment transaction
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //add a fragment
        fragmentTransaction.add(R.id.fragmentBase, startFragment);
        fragmentTransaction.commit();
    }

    public void nextFragment(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (view.getId() == R.id.animalButton)
        {
            fragmentTransaction.replace(R.id.fragmentBase, animalFragment);
        }
        else if (view.getId() == R.id.carButton)
        {
            fragmentTransaction.replace(R.id.fragmentBase, carFragment);
        }
        else
        {
            fragmentTransaction.replace(R.id.fragmentBase, colourFragment);
        }
        //fragmentTransaction.remove(startFragment);
        fragmentTransaction.addToBackStack("back to previous fragment");
        fragmentTransaction.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}

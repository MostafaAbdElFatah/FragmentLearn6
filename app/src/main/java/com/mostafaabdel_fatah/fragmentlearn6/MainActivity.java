package com.mostafaabdel_fatah.fragmentlearn6;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button button;
    boolean status = false;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
    }

    public void btnClicked(View view) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (!status){
            Fragment1 fragment1 = new Fragment1();
            fragmentTransaction.add(R.id.relativeLayout,fragment1);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            button.setText("Load Second Fragment");
            status =true;
        }else {
            Fragment2 fragment2 = new Fragment2();
            fragmentTransaction.add(R.id.relativeLayout,fragment2);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
            button.setText("Load First Fragment");
            status = false;
        }
    }
}

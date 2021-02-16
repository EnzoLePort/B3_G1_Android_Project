package fr.epsi.ourapplicationb3g1_ase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends EpsiActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.buttonZone1).setOnClickListener(this);
        findViewById(R.id.buttonZone1).setOnClickListener(this);
    }

    public static void displayActivity(EpsiActivity activity){
        Intent intent = new Intent(activity,MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonZone1:
                StudentsActivity.displayActivity(this,"Infos");
                break;
            case R.id.buttonZone2:
                //OtherActivity.displayActivity(this,"Rayons");
                break;
        }
    }
}
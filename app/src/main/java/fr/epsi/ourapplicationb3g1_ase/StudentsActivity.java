package fr.epsi.ourapplicationb3g1_ase;

import android.content.Intent;
import android.os.Bundle;

public class StudentsActivity extends EpsiActivity {

    public static void displayActivity(EpsiActivity activity,String title){
        Intent intent = new Intent(activity,StudentsActivity.class);
        intent.putExtra("title",title);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        showBack();
        String title = getIntent().getExtras().getString("title","");
        setTitle(title);
    }
}
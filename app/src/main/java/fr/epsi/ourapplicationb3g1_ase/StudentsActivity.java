package fr.epsi.ourapplicationb3g1_ase;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class StudentsActivity extends EpsiActivity implements View.OnClickListener{

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

        findViewById(R.id.buttonAlexis).setOnClickListener(this);
        findViewById(R.id.buttonSami).setOnClickListener(this);
        findViewById(R.id.buttonEnzo).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonAlexis:
                StudentInfoActivity.displayActivity(this,"Alexis", "Zucher","Alexis.zucher@epsi.fr", "Groupe 1");
                break;
            case R.id.buttonSami:
                StudentInfoActivity.displayActivity(this,"Sami", "Dief","Sami.dief@epsi.fr", "Groupe 1");
                break;
            case R.id.buttonEnzo:
                StudentInfoActivity.displayActivity(this,"Enzo", "Le Port","Enzo.leport@epsi.fr", "Groupe 1");
                break;
        }
    }
}
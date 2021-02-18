package fr.epsi.ourapplicationb3g1_ase;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class StudentInfoActivity extends EpsiActivity {

    public static void displayActivity(EpsiActivity activity,String name,String lastName, String email, String groupe){
        Intent intent = new Intent(activity,StudentInfoActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("lastName",lastName);
        intent.putExtra("email",email);
        intent.putExtra("groupe",groupe);

        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);
        showBack();

        //passage de la valeur du prenom
        String name = getIntent().getExtras().getString("name","");
        TextView textViewName = findViewById(R.id.NameInfo);
        if(textViewName!=null){
            textViewName.setText(name);
        }

        //passage de la valeur du nom
        String lastName = getIntent().getExtras().getString("lastName","");
        TextView textViewLastName = findViewById(R.id.lastNameInfo);
        if(textViewLastName!=null){
            textViewLastName.setText(lastName);
        }

        //passage de la valeur de l'email
        String email = getIntent().getExtras().getString("email","");
        TextView textViewEmail =findViewById(R.id.EmailInfo);
        if(textViewEmail!=null){
            textViewEmail.setText(email);
        }

        //passage de la valeur du groupe
        String group = getIntent().getExtras().getString("groupe","");
        TextView textViewGroup =findViewById(R.id.GroupeInfo);
        if(textViewGroup!=null){
            textViewGroup.setText(group);
        }

    }
}
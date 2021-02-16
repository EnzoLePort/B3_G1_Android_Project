package fr.epsi.ourapplicationb3g1_ase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StudentInfoActivity extends EpsiActivity {

    public static void displayActivity(EpsiActivity activity,String Name, String Email, String Groupe){
        Intent intent = new Intent(activity,StudentInfoActivity.class);
        intent.putExtra("Name",Name);
        intent.putExtra("Email",Email);
        intent.putExtra("Groupe",Groupe);

        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        //passage de la valeur du nom
        String name = getIntent().getExtras().getString("Name","");
        TextView textView=findViewById(R.id.NameInfo);
        if(textView!=null){
            textView.setText(name);
        }

        //passage de la valeur de l'email
        String email = getIntent().getExtras().getString("Email","");
        TextView textViewmail =findViewById(R.id.EmailInfo);
        if(textViewmail!=null){
            textViewmail.setText(email);
        }

        //passage de la valeur du groupe
        String group = getIntent().getExtras().getString("Groupe","");
        TextView textViewgroup =findViewById(R.id.GroupeInfo);
        if(textViewgroup!=null){
            textViewgroup.setText(group);
        }


    }
}
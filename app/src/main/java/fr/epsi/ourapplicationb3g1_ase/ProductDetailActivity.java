package fr.epsi.ourapplicationb3g1_ase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductDetailActivity extends EpsiActivity {

    public static void displayActivity(EpsiActivity activity,String name, String description, String picture_url){
        Intent intent = new Intent(activity,ProductDetailActivity.class);
        intent.putExtra("name",name);
        intent.putExtra("description",description);
        intent.putExtra("picture_url",picture_url);

        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        showBack();

        String name = getIntent().getExtras().getString("name","");
        setTitle(name);

        String description = getIntent().getExtras().getString("description","");
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        if(textViewDescription!=null){ textViewDescription.setText(description); }

        String picture_url = getIntent().getExtras().getString("picture_url","");
        ImageView textViewPictureUrl = findViewById(R.id.imageViewProduct);
        Picasso.get().load(picture_url).into(textViewPictureUrl);
    }
}
package fr.epsi.ourapplicationb3g1_ase;

import java.util.ArrayList;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OtherActivity extends EpsiActivity {

    public static void displayActivity(EpsiActivity activity,String title){
        Intent intent=new Intent(activity, CategoriesWSActivity.class);
        activity.startActivity(intent);
    }

    private ArrayList<Categories> categories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        setTitle("OtherAct_");
        showBack();
        categories = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerViewCategories);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(this,categories);
        recyclerView.setAdapter(categoriesAdapter);

        String url = "https://djemam.com/epsi/categories.json";
        WSCall wsCall = new WSCall(url, new WSCall.Callback() {
            @Override
            public void onComplete(String result) {
                try {
                    JSONObject jsonObject= new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("items");
                    for(int i=0;i<jsonArray.length();i++){
                        Categories categorie = new Categories(jsonArray.getJSONObject(i));
                        categories.add(categorie);
                    }
                    categoriesAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(OtherActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        wsCall.run();
    }
}
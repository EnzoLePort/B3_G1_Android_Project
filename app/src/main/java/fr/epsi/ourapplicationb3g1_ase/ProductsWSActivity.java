package fr.epsi.ourapplicationb3g1_ase;

import android.os.Bundle;
import org.json.JSONArray;
import java.util.ArrayList;
import org.json.JSONObject;
import android.widget.Toast;
import android.content.Intent;
import org.json.JSONException;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

public class ProductsWSActivity extends EpsiActivity {

    public static void displayActivity(EpsiActivity activity,String title,String url){
        Intent intent=new Intent(activity, ProductsWSActivity.class);
        intent.putExtra("title",title);
        intent.putExtra("url",url);
        activity.startActivity(intent);
    }

    private ArrayList<Products> products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        showBack();
        String title = getIntent().getExtras().getString("title","");
        setTitle(title);

        products = new ArrayList<>();
        RecyclerView recyclerView = findViewById(R.id.recyclerViewProducts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ProductsAdapter productsAdapter = new ProductsAdapter(this,products);
        recyclerView.setAdapter(productsAdapter);

        String url = getIntent().getExtras().getString("url","");
        WSCall wsCall = new WSCall(url, new WSCall.Callback() {
            @Override
            public void onComplete(String result) {
                try {
                    JSONObject jsonObject= new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("items");
                    for(int i=0;i<jsonArray.length();i++){
                        Products product = new Products(jsonArray.getJSONObject(i));
                        products.add(product);
                    }
                    productsAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(ProductsWSActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        wsCall.run();
    }
}
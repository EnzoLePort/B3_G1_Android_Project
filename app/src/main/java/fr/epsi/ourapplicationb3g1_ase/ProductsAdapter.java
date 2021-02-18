package fr.epsi.ourapplicationb3g1_ase;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import com.squareup.picasso.Picasso;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {
    EpsiActivity activity;
    ArrayList<Products> products;

    public ProductsAdapter(EpsiActivity activity, ArrayList<Products> products){
        this.activity = activity;
        this.products = products;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewDescription;
        private final ImageView imageViewProduct;
        private final View layoutCellProduct;

        public ViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.textViewName);
            textViewDescription = view.findViewById(R.id.textViewDescription);
            imageViewProduct = view.findViewById(R.id.imageViewProduct);
            layoutCellProduct = view.findViewById(R.id.layoutCellProduct);
        }

        public TextView getTextViewName() {
            return textViewName;
        }
        public TextView getTextViewDescription() { return textViewDescription; }
        public ImageView getImageViewProduct() {
            return imageViewProduct;
        }
        public View getLayoutCellProduct() {
            return layoutCellProduct;
        }
    }

    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_products, viewGroup, false);

        return new ProductsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.ViewHolder holder, int position) {
        final Products product = products.get(position);
        holder.getTextViewName().setText(product.getName());
        holder.getTextViewDescription().setText(product.getDescription());
        Picasso.get().load(product.getPicture_url()).into(holder.getImageViewProduct());
        holder.getLayoutCellProduct().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("what next ?");
                //System.out.println("url : " + categorie.getProducts_url());
                //ProductsActivity.displayActivity(activity,categorie.getTitle(),categorie.getProducts_url());
            }
        });
    }

    @Override
    public int getItemCount() { return products.size(); }
}

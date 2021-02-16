package fr.epsi.ourapplicationb3g1_ase;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    EpsiActivity activity;
    ArrayList<Categories> categories;

    public CategoriesAdapter(EpsiActivity activity, ArrayList<Categories> categories){
        this.activity = activity;
        this.categories = categories;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTitle;
        private final View layoutCellCategorie;

        public ViewHolder(View view) {
            super(view);
            textViewTitle = view.findViewById(R.id.textViewTitle);
            layoutCellCategorie = view.findViewById(R.id.layoutCellCategorie);
        }

        public TextView getTextViewTitle() {
            return textViewTitle;
        }
        public View getLayoutCellCategorie() {
            return layoutCellCategorie;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_categories, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Categories categorie = categories.get(position);
        holder.getTextViewTitle().setText(categorie.getTitle());
        holder.getLayoutCellCategorie().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("what next ?");
                //ImageActivity.displayActivity(activity,student.getUrl(),student.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}

package harshbarash.github.io;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    ListActivity listActivity;
    List<Collection> collectionList;


    public CustomAdapter(ListActivity listActivity, List<Collection> collectionList) {
        this.listActivity = listActivity;
        this.collectionList = collectionList;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.collection_layout, viewGroup, false);

        ViewHolder viewHolder = new ViewHolder(itemView);

        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {

//                показ данных в тосте при клике
                String title = collectionList.get(position).getNominal_value();
                // description todo


                Toast.makeText(listActivity, title+"\n"
                                /// todo description
                        , Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder viewHolder, int position) {
        viewHolder.nominal_value.setText(collectionList.get(position).getNominal_value());
        //description TODO
    }

    @Override
    public int getItemCount() {
        return collectionList.size();
    }
}

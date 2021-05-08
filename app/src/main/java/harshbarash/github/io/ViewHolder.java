package harshbarash.github.io;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView nominal_value; //todo description из лайаута
    View cView;

    public ViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);

        cView = itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClicListener.onItemClick(v, getAdapterPosition());

            }
        });
//        долгое нажатие (уддержание)
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClicListener.onItemClick(v, getAdapterPosition());
                return true;
            }
        });

        nominal_value = itemView.findViewById(R.id.Title);
        //description с 10 минуты TODO
        }

        private ViewHolder.ClickListener mClicListener;

        public interface ClickListener {
            void onItemClick(View view, int position);
            void onItemLongClick(View view, int position);
        }

        public void setOnClickListener(ViewHolder.ClickListener clickListener){
            mClicListener = clickListener;
        }
}

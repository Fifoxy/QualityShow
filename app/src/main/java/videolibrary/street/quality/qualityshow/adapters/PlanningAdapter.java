package videolibrary.street.quality.qualityshow.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import videolibrary.street.quality.qualityshow.QualityShowApplication;
import videolibrary.street.quality.qualityshow.R;
import videolibrary.street.quality.qualityshow.api.user.dao.Serie;
import videolibrary.street.quality.qualityshow.listeners.ClickListener;


public class PlanningAdapter extends RecyclerView.Adapter<PlanningHolder> {

    ClickListener clickListener;
    List<Serie> series;

    public PlanningAdapter(List<Serie> list_serie, ClickListener listener) {
        series = list_serie;
        clickListener = listener;
    }

    @Override
    public PlanningHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.planning_items, parent, false);
        return new PlanningHolder(v);
    }

    @Override
    public void onBindViewHolder(PlanningHolder holder, int position) {
        if(position < getItemCount()){
            Serie serie = series.get(position);

            if(serie != null){
                // holder.episode_titleView.setText();
               // holder.episodeView.setText(Integer.toString(serie.getYear()));
               // holder.serie_titleView.setText(serie.getTitle());

                Object photo = serie.getPoster().get("thumb");

                Picasso.with(QualityShowApplication.getContext()).load((String) photo).into(holder.imageView);
                holder.setView(serie, clickListener);
            }
        }


    }

    @Override
    public int getItemCount() {
        return series.size();
    }
}

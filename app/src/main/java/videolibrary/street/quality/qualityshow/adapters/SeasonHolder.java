package videolibrary.street.quality.qualityshow.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import videolibrary.street.quality.qualityshow.R;
import videolibrary.street.quality.qualityshow.listeners.ClickListener;

/**
 * Created by Sacael on 06/11/2015.
 */
public class SeasonHolder extends RecyclerView.ViewHolder{

    private View view;
    public ImageView image;
    public TextView number;
    public TextView episodes;


    public SeasonHolder(View itemView) {
        super(itemView);
        this.view = itemView;
        this.image = (ImageView) itemView.findViewById(R.id.season_image_view);
        this.number = (TextView) itemView.findViewById(R.id.number_season);
        this.episodes = (TextView) itemView.findViewById(R.id.number_episodes);
    }

}

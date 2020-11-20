package com.faisal.peoplentech.lecture.retrofit.adopter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faisal.peoplentech.lecture.retrofit.R;
import com.faisal.peoplentech.lecture.retrofit.model.Anim;

import java.lang.ref.WeakReference;
import java.util.List;

public class AnimeViewAdopter extends RecyclerView.Adapter<AnimeViewAdopter.AnimeViewHolder> {

    private List<Anim> mAnime ;
    private IDetailsClickListener mClickListener;

    public  class AnimeViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView tvTitle;
        TextView data;
        TextView tvDescription;
        TextView rating;
        private WeakReference<IDetailsClickListener> ref;

        public AnimeViewHolder(View v) {
            super(v);
            ref = new WeakReference<IDetailsClickListener>(mClickListener);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            tvTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            tvDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            tvDescription.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ref.get().onClick(getAdapterPosition());
                }
            });


        }
    }

    public AnimeViewAdopter(List<Anim> mAnime, IDetailsClickListener mClickListener) {
        this.mAnime = mAnime;
        this.mClickListener = mClickListener;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view_anime, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        holder.tvTitle.setText(mAnime.get(position).getName());
        holder.data.setText(mAnime.get(position).getCategorie());
        holder.tvDescription.setText(mAnime.get(position).getDescription());
        holder.rating.setText(mAnime.get(position).getRating().toString());
    }

    @Override
    public int getItemCount() {
        return mAnime.size();
    }
}

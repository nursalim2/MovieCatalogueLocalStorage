package com.firmanjabar.favapp.feature.tv_detail.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firmanjabar.favapp.R;
import com.firmanjabar.favapp.data.model.Video;
import com.firmanjabar.favapp.utils.Utils;

import java.util.ArrayList;

public class TvVideoAdapter extends RecyclerView.Adapter<TvVideoAdapter.VideoHolder> {
    private ArrayList<Video> videoList;
    private final TvVideoAdapter.OnItemClickListener listener;

    public TvVideoAdapter ( OnItemClickListener listener ) {
        this.videoList = new ArrayList<>();
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onVideoClick ( Video video );
    }

    public ArrayList<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(ArrayList<Video> videoList) {
        this.videoList = videoList;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder( @NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_card, parent, false);
        return new VideoHolder(v);
    }

    @Override
    public void onBindViewHolder( @NonNull TvVideoAdapter.VideoHolder holder, int position) {
        holder.bind(videoList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView imgThumb;
        View view;

        VideoHolder ( View itemView ) {
            super(itemView);
            view = itemView;
            txtName = itemView.findViewById(R.id.name);
            imgThumb = itemView.findViewById(R.id.imgThumb);
        }

        public void bind(Video video, TvVideoAdapter.OnItemClickListener listener) {
            txtName.setText(video.getName());
            String url = "https://i1.ytimg.com/vi/" + video.getKey() + "/0.jpg";
            Utils.setImageYoutube(url,imgThumb);
            view.setOnClickListener(v -> listener.onVideoClick(video));
        }
    }
}

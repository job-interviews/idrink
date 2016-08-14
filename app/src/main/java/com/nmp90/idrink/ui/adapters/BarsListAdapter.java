package com.nmp90.idrink.ui.adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.nmp90.idrink.R;
import com.nmp90.idrink.api.models.Bar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by nmp on 14.08.16.
 */

public class BarsListAdapter extends RecyclerView.Adapter<BarsListAdapter.ViewHolder> {

    private final PublishSubject<Bar> onClickSubject = PublishSubject.create();
    private final List<Bar> bars;

    public BarsListAdapter(List<Bar> bars) {
        this.bars = bars;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_bar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Bar bar = bars.get(position);
        holder.barName.setText(bar.getName());
        holder.barDistance.setText(String.valueOf(bar.getDistance()));
        holder.container.setOnClickListener(view -> {
            onClickSubject.onNext(bar);
        });
    }

    public Observable<Bar> getPositionClicks(){
        return onClickSubject.asObservable();
    }

    @Override
    public int getItemCount() {
        return bars.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.row_container)
        LinearLayout container;

        @BindView(R.id.tv_bar_name)
        AppCompatTextView barName;

        @BindView(R.id.tv_bar_distance)
        AppCompatTextView barDistance;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

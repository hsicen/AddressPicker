package com.hisence.style.citythreelist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hisence.style.citylist.bean.CityInfoBean;
import com.hisence.style.citypickerview.R;

import java.util.ArrayList;
import java.util.List;


public class CityAdapter extends RecyclerView.Adapter<CityAdapter.MyViewHolder> {
    List<CityInfoBean> cityList = new ArrayList<>();

    Context context;

    private OnItemSelectedListener mOnItemClickListener;

    public CityAdapter(Context context, List<CityInfoBean> cityList) {
        this.cityList = cityList;
        this.context = context;
    }

    public void setOnItemClickListener(OnItemSelectedListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(
                LayoutInflater.from(context).inflate(R.layout.item_citylist, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tv.setText(cityList.get(position).getName());
        holder.tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener != null && position < cityList.size()) {
                    mOnItemClickListener.onItemSelected(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public interface OnItemSelectedListener {
        /**
         * item点击事件
         *
         * @param view
         * @param position
         */
        void onItemSelected(View view, int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (TextView) view.findViewById(R.id.default_item_city_name_tv);
        }
    }
}

package com.vit.customerapp.ui.feature.choose_service.adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.vit.customerapp.R;
import com.vit.customerapp.ui.base.BaseViewHolder;
import com.vit.customerapp.ui.feature.choose_service.listener.OnClickChooseServiceItemListener;

import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.OnClick;

public class ChooseServiceAdapter extends RecyclerView.Adapter<ChooseServiceAdapter.ChooseServiceViewHolder> {


    private OnClickChooseServiceItemListener listener;

    public ChooseServiceAdapter() {

    }

    @NonNull
    @Override
    public ChooseServiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choose_service_view_item, parent, false);
        return new ChooseServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChooseServiceViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ChooseServiceViewHolder extends BaseViewHolder<String> {

        @BindView(R.id.text_price)
        TextView mTextPrice;

        @BindDrawable(R.drawable.ic_oval_white)
        Drawable icOvalWhite;

        @BindDrawable(R.drawable.ic_oval_green_gradient)
        Drawable icOvalGreen;

        private boolean isChoose = false;

        public ChooseServiceViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(String s) {

        }

        @OnClick(R.id.layout_root)
        void onClickItem() {
            if (isChoose) {
                mTextPrice.setBackground(icOvalWhite);
                isChoose = false;
            } else {
                mTextPrice.setBackground(icOvalGreen);
                isChoose = true;
            }
            Toast.makeText(itemView.getContext(), isChoose + "", Toast.LENGTH_SHORT).show();
            if (listener != null) {
                listener.onClickChooseService(isChoose);
            }
        }
    }
}

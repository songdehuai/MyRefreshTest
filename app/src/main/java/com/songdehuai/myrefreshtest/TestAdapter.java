package com.songdehuai.myrefreshtest;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestAdapter extends BaseAdapter {
    private Context context;
    private List<String> arrayList = new ArrayList<>();
    private OnLoadMoreListener onLoadMoreListener;

    public TestAdapter(Context context) {
        this.context = context;
    }

    public void addData(int count) {
        for (int i = 0; i < count; i++) {
            arrayList.add(UUID.randomUUID().toString());
        }
        notifyDataSetChanged();
        if (onLoadMoreListener != null) {
            onLoadMoreListener.onSuccess();
        }
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onSuccess();
    }

    public void setData() {
        arrayList.clear();
        for (int i = 0; i < 10; i++) {
            arrayList.add(UUID.randomUUID().toString());
        }
        notifyDataSetChanged();
        if (onLoadMoreListener != null) {
            onLoadMoreListener.onSuccess();
        }
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (null == viewHolder) {
            convertView = View.inflate(context, R.layout.item_test, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setText(arrayList.get(position));
        return convertView;
    }

    class ViewHolder {
        TextView textView;

        public ViewHolder(View itemView) {
            textView = itemView.findViewById(R.id.item_test_tv);
        }
    }
}

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.appcompat.widget.AppCompatTextView;

import java.util.ArrayList;
import java.util.List;

public class ExampleAdapter extends BaseAdapter {

    private final ArrayList<String> data = new ArrayList<String>();
    private final ArrayList<View> views = new ArrayList<View>();
    private OnClickListener listener = null;

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return views.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_adapter_item, parent);

        String currentData = data.get(position);
        AppCompatTextView name = view.findViewById(R.id.item_name);
        AppCompatTextView secondName = view.findViewById(R.id.item_second_name);
        AppCompatTextView email = view.findViewById(R.id.item_email);
        view.setOnClickListener(v -> {
            if (listener != null) {
                listener.onClick();
            }
        });
        name.setText(currentData);
        views.add(view);

        return view;
    }

    public void setData(List<String> values) {
        data.clear();
        data.addAll(values);
        notifyDataSetChanged();
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    interface OnClickListener {

        public void onClick();
    }
}
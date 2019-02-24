package com.example.noranow.noranfinal2019.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.noranow.noranfinal2019.R;

public class TaskAdapter extends ArrayAdapter<MyTask>
{

    public TaskAdapter( Context context, int resource) {
        super(context, resource);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        if (convertView==null)//to build one item from using xml layout
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.task_item,parent,false);
        //to get curremt data object
        MyTask m=getItem(position);//return data object number "position"

        //get references for each item at the xml ui
        TextView tvTitle=convertView.findViewById(R.id.tvitmTitle);
        TextView tvText=convertView.findViewById(R.id.tvitmText);
        SeekBar skbNess =convertView.findViewById(R.id.skbitmNess);
        SeekBar skbImp=convertView.findViewById(R.id.skbitmImp);
        ImageButton ibDel=convertView.findViewById(R.id.btnitmDelTask);

        //put the data of the object on the view
        tvText.setText(m.getText());
        tvTitle.setText(m.getTitle());
        skbImp.setProgress(m.getImportant());
        skbNess.setProgress(m.getNecessary());

        ibDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Del",Toast.LENGTH_SHORT).show();

            }
        });

        return convertView;
    }
}

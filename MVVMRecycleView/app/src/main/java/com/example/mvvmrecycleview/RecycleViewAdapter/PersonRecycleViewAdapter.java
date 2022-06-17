package com.example.mvvmrecycleview.RecycleViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmrecycleview.Activity.EditActivity;
import com.example.mvvmrecycleview.Model.Person;
import com.example.mvvmrecycleview.R;

import java.util.ArrayList;

public class PersonRecycleViewAdapter extends RecyclerView.Adapter<PersonRecycleViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Person> objects = new ArrayList<>();

    public PersonRecycleViewAdapter(Context context, ArrayList<Person> objects)
    {
        this.context = context;
        this.objects = objects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.activity_main_element, parent, false);

        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person person = objects.get(position);
        String name = person.getName();
        String phone = person.getPhone();

        holder.name.setText( name);
        holder.phone.setText(phone);
        holder.parentLayout.setOnClickListener(view ->{
            Intent intent = new Intent(context, EditActivity.class);
            intent.putExtra("position", String.valueOf(position));
            intent.putExtra("name", name);
            intent.putExtra("phone", phone);
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView phone;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            setUpComponent(itemView);
        }

        public void setUpComponent(View itemView)
        {
            name = itemView.findViewById(R.id.elementName);
            phone = itemView.findViewById(R.id.elementPhone);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}

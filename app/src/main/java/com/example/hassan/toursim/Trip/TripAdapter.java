package com.example.hassan.toursim.Trip;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hassan.toursim.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.viewHolder>{

    List<Datum>cop;

    public TripAdapter(List<Datum> cop) {
        this.cop = cop;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.trip_layout,viewGroup,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder viewHolder, int i) {

     Datum item=cop.get(i);
        viewHolder.tx1.setText(item.getName());
       // viewHolder.tx2.setText(item.getPrice());

        String image=item.getFeaturedImage();
        if (image.isEmpty())
        {
            // Picasso.get().load(R.drawable.ic_launcher_foreground).into( viewHolder.book_image);
            viewHolder.imageView.setImageResource(R.drawable.ic_launcher_foreground);
        }
        else
        {
            Picasso.get().load(image).into( viewHolder.imageView);
        }

    }

    @Override
    public int getItemCount() {
        return cop.size();
    }

    class viewHolder extends RecyclerView.ViewHolder
    {

        ImageView imageView;
        TextView tx1,tx2;
       public viewHolder(View view)
        {
           super(view);

           imageView=view.findViewById(R.id.tip_image);
           tx1=view.findViewById(R.id.tip_title);
            tx2=view.findViewById(R.id.tip_price);

        }



    }
}

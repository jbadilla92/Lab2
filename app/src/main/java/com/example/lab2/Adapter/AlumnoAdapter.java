package com.example.lab2.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.lab2.LogicaNegocio.Alumno;
import com.example.lab2.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by User on 21/03/2018.
 */

public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.MyViewHolder> implements Filterable {
    private List<Alumno> alumnoList;
    private List<Alumno> alumnoListFiltered;
    private AlumnoAdapterListener listener;
    private Alumno deletedItem;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView titulo1, titulo2, description;
        //two layers
        public RelativeLayout viewForeground, viewBackgroundDelete, viewBackgroundEdit;


        public MyViewHolder(View view) {
            super(view);
            titulo1 = view.findViewById(R.id.titleFirstLbl);
            titulo2 = view.findViewById(R.id.titleSecLbl);
            description = view.findViewById(R.id.descriptionLbl);
            viewBackgroundDelete = view.findViewById(R.id.view_background_delete);
            viewBackgroundEdit = view.findViewById(R.id.view_background_edit);
            viewForeground = view.findViewById(R.id.view_foreground);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // send selected contact in callback
                    listener.onContactSelected(alumnoListFiltered.get(getAdapterPosition()));
                }
            });
        }
    }

    public AlumnoAdapter(List<Alumno> alumnoList, AlumnoAdapterListener listener) {
        this.alumnoList = alumnoList;
        this.listener = listener;
        //init filter
        this.alumnoListFiltered = alumnoList;
    }

    @Override
    public AlumnoAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AlumnoAdapter.MyViewHolder holder, int position) {
        // rendering view
        final Alumno alumno = alumnoListFiltered.get(position);
        holder.titulo1.setText(alumno.getCedula());
        holder.titulo2.setText(alumno.getNombre());
        holder.description.setText(alumno.getCarrera());
    }

    @Override
    public int getItemCount() {
        return alumnoListFiltered.size();
    }

    public void removeItem(int position) {
        deletedItem = alumnoListFiltered.remove(position);
        Iterator<Alumno> iter = alumnoList.iterator();
        while (iter.hasNext()) {
            Alumno aux = iter.next();
            if (deletedItem.equals(aux))
                iter.remove();
        }
        // notify item removed
        notifyItemRemoved(position);
    }

    public void restoreItem(int position) {

        if (alumnoListFiltered.size() == alumnoList.size()) {
            alumnoListFiltered.add(position, deletedItem);
        } else {
            alumnoListFiltered.add(position, deletedItem);
            alumnoList.add(deletedItem);
        }
        notifyDataSetChanged();
        // notify item added by position
        notifyItemInserted(position);
    }

    public Alumno getSwipedItem(int index) {
        if (this.alumnoList.size() == this.alumnoListFiltered.size()) { //not filtered yet
            return alumnoList.get(index);
        } else {
            return alumnoListFiltered.get(index);
        }
    }

    public void onItemMove(int fromPosition, int toPosition) {
        if (alumnoList.size() == alumnoListFiltered.size()) { // without filter
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(alumnoList, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(alumnoList, i, i - 1);
                }
            }
        } else {
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(alumnoListFiltered, i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(alumnoListFiltered, i, i - 1);
                }
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    alumnoListFiltered = alumnoList;
                } else {
                    List<Alumno> filteredList = new ArrayList<>();
                    for (Alumno row : alumnoList) {
                        // filter use two parameters
                        if (row.getCedula().toLowerCase().contains(charString.toLowerCase()) || row.getNombre().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    alumnoListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = alumnoListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                alumnoListFiltered = (ArrayList<Alumno>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public interface AlumnoAdapterListener {
        void onContactSelected(Alumno alumno);
    }
}

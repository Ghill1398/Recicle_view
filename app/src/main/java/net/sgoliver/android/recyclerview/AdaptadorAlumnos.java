package net.sgoliver.android.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

public class AdaptadorAlumnos
        extends RecyclerView.Adapter<AdaptadorAlumnos.TitularesViewHolder>
        implements View.OnClickListener {

    private View.OnClickListener listener;
    private ArrayList<Alumno> datos;

    public static class TitularesViewHolder
            extends RecyclerView.ViewHolder {

        private TextView Nombre;
        private TextView Apellido;
        private ImageView Imagen;

        public TitularesViewHolder(View itemView) {
            super(itemView);

            Nombre = (TextView)itemView.findViewById(R.id.LblTitulo);
            Apellido = (TextView)itemView.findViewById(R.id.LblSubTitulo);
            Imagen = (ImageView)itemView.findViewById(R.id.MAN);
        }

        public void bindAlumno(Alumno t) {
            Nombre.setText(t.getNombre());
            Apellido.setText(t.getApellidos());
            Imagen.setImageResource(R.mipmap.ic_man);
        }
    }

    public AdaptadorAlumnos(ArrayList<Alumno> datos) {
        this.datos = datos;
    }

    @Override
    public TitularesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.listitem_titular, viewGroup, false);

        itemView.setOnClickListener(this);
        //android:background="?android:attr/selectableItemBackground"

        TitularesViewHolder tvh = new TitularesViewHolder(itemView);

        return tvh;
    }

    @Override
    public void onBindViewHolder(TitularesViewHolder viewHolder, int pos) {
        Alumno item = datos.get(pos);

        viewHolder.bindAlumno(item);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}

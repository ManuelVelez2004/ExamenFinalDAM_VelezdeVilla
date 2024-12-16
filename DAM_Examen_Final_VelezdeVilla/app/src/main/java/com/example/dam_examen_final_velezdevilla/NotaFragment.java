package com.example.dam_examen_final_velezdevilla;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A fragment representing a list of Items.
 */
public class NotaFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
    private NotasInteractionListener mListener;
    private List<Nota> notaList;
    private MyNotaRecyclerViewAdapter adapterNotas;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotaFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static NotaFragment newInstance(int columnCount) {
        NotaFragment fragment = new NotaFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager( mColumnCount, StaggeredGridLayoutManager.VERTICAL));
            }
            notaList = new ArrayList<>();
            notaList.add(new Nota("Trabajo Académico:","Las notas del trabajo académico serán  revisadas e ingresadas el día 23 de Diciembre.", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Examen Final:", "Estudiar, practicar y presentarse al examen Final el día 16 de Diciembre.",false, android.R.color.holo_green_light));
            notaList.add(new Nota("Resultado de Examen Final:","La Revisión del examen final se revisará durante la sesión de clases y el resultado será publicado en los próximos dias, específicamente: 23/12/24.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("Examen Sustitutorio:","Examen Sustitutorio planificado para el día 23 de diciembre del 2024. Asistir puntualmente a todos los que se van a presentar.", true, android.R.color.holo_blue_light));
            notaList.add(new Nota("Fiestas Navideñas:", "La Navidad es una época del año llena de emociones, de reencuentros, y de momentos especiales para compartir con las personas que más queremos. Es un tiempo para expresar nuestros sentimientos y agradecer por lo que hemos vivido durante el año. Y nada mejor que unas palabras llenas de cariño para transmitir ese amor y gratitud a nuestros seres queridos.",false, android.R.color.holo_green_light));
            notaList.add(new Nota("Despedida de Ciclo:","Quiero dejar con ustedes este mensaje y espero que lo recuerden toda su vida: “La mayor necesidad del mundo es la de hombres que no se vendan ni se compren; hombres que sean sinceros y honrados en lo más íntimo de sus almas; hombres que no teman dar al pecado el nombre que le corresponde; hombres cuya conciencia sea tan leal al deber como la brújula al polo; hombres que se mantengan de parte de la justicia aunque se desplomen los cielos”. Aprecio mucho su amistad, su participación en las sesiones de clases, cada ciclo es una nueva experiencia, deseo que sigan estudiando. Muchas Felicidades. Nos vemos el 2025 - I.", true, android.R.color.holo_orange_light));
            notaList.add(new Nota("Estudia y superate:","Todas las distintas capacidades que el hombre posee de la mente, del alma y del cuerpo le fueron dadas por Dios para que las dedique a alcanzar el más alto grado de excelencia posible. Toda facultad y todo atributo con que el Creador nos haya dotado deben emplearse para su gloria y para el ennoblecimiento de nuestros semejantes. Y en este empleo se halla la ocupación más pura, más noble y más feliz.", true, android.R.color.holo_orange_light));
            adapterNotas = new MyNotaRecyclerViewAdapter(notaList, mListener);
            recyclerView.setAdapter(adapterNotas);
        }
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof NotasInteractionListener){
            mListener = (NotasInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + "Debe implementarse NotasInteractionListener");
        }
    }

}
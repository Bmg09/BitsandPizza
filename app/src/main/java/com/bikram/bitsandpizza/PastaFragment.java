package com.bikram.bitsandpizza;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PastaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PastaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PastaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PastaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PastaFragment newInstance(String param1, String param2) {
        PastaFragment fragment = new PastaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView pastaRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_pasta,container,false);
        String[] pastaName = new String[Pasta.pastas.length];
        for (int i = 0; i < Pasta.pastas.length; i++) {
            pastaName[i] = Pasta.pastas[i].getCaption();
        }
        int[] pastaResourceId = new int[Pasta.pastas.length];
        for (int i = 0; i < Pasta.pastas.length; i++) {
            pastaResourceId[i] = Pasta.pastas[i].getImageIds();
        }
        CaptionedImageAdapter cp = new CaptionedImageAdapter(pastaName,pastaResourceId);
        pastaRecycler.setAdapter(cp);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        pastaRecycler.setLayoutManager(gridLayoutManager);
        cp.setListener(new CaptionedImageAdapter.Listener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(),PastaDetailActivity.class);
                intent.putExtra(PastaDetailActivity.EXTRA_PASTA_ID,position);
                getActivity().startActivity(intent);
            }
        });
        return pastaRecycler;
    }
}
package com.rightside.deef.client;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rightside.deef.R;
import com.rightside.deef.client.adapter.OfferAdapter;
import com.rightside.deef.client.model.Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OfferFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OfferFragment extends Fragment {

    private OfferAdapter adapter;
    private List<Offer> offers = new ArrayList<>();
    private RecyclerView recyclerView;

    public static OfferFragment newInstance(String param1, String param2) {
        OfferFragment fragment = new OfferFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_offer, container, false);

        recyclerView = view.findViewById(R.id.recyclerView_offers);

        Offer o1 = new Offer("Lojão do Eletrônico", "Fabrício", 2299.00, "https://lh3.googleusercontent.com/proxy/GH30i4zdu5hOXBMyBF5yvfjxWnrS4xuzA1osFB2_ceNKQduq9WTioWDvJ1aufBpcHwjvqOfNSaK9Fi0vgILYjNAY8y32");
        offers.add(o1);
        offers.add(o1);
        offers.add(o1);
        offers.add(o1);
        offers.add(o1);

        adapter = new OfferAdapter(offers, getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
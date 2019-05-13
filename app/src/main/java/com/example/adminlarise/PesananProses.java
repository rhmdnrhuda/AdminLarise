package com.example.adminlarise;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PesananProses extends Fragment {

    ProgressDialog progressDialog;
    List<PesananObjek> list = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter ;
    String NameHolder, NumberHolder;
    public static DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    static final ArrayList<PesananObjek> po = new ArrayList<>();
    static final ArrayList<String> eek = new ArrayList<>();

    Firebase firebase;
    public static final String Firebase_Server_URL = "https://larise-1234.firebaseio.com/";
    public static final String Database_Path = "larise-1234";
    DatabaseReference databaseReference;

    public PesananProses() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_pesanan_proses, container, false);
        View fView = inflater.inflate(R.layout.fragment_pesanan_masuk,container,false);
        Firebase.setAndroidContext(getActivity());
        firebase = new Firebase(Firebase_Server_URL);

        recyclerView = (RecyclerView) fView.findViewById(R.id.rv_pesanan);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        progressDialog = new ProgressDialog(getActivity());

        databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        progressDialog.setMessage("Loading Data from Firebase Database");
        progressDialog.show();

        for(int i=0; i<Global.po.size();i++){
            if(Global.po.get(i).getStatus().equals("WAIT")){
                list.add(Global.po.get(i));
            }
        }
        adapter = new PesananAdapter(getActivity(), list);

        recyclerView.setAdapter(adapter);

        progressDialog.dismiss();
        return fView;
    }

}

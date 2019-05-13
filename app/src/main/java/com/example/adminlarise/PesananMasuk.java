package com.example.adminlarise;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 */
public class PesananMasuk extends Fragment {

//    DatabaseReference databaseReference;
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

    public PesananMasuk() {
        // Required empty public constructor
    }

    DatabaseReference databaseReference;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fView = inflater.inflate(R.layout.fragment_pesanan_masuk, container, false);

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
        return fView;
    }

}

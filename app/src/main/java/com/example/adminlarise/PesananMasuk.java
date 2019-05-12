package com.example.adminlarise;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.client.Firebase;
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
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_pesanan_masuk, container, false);
        Firebase.setAndroidContext(getActivity());

        firebase = new Firebase(Firebase_Server_URL);

////        databaseReference = FirebaseDatabase.getInstance().getReference().child("pesanan").child("ADYtRlOHV5ODGoebM8iGCHN1tjG3").child("12-05-2019-21:26").child("pesanan").child("0");
        View fView = inflater.inflate(R.layout.fragment_pesanan_masuk, container, false);
        recyclerView = (RecyclerView) fView.findViewById(R.id.rv_pesanan);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        progressDialog = new ProgressDialog(getActivity());
        databaseReference = FirebaseDatabase.getInstance().getReference();
        DatabaseReference ref = databaseReference.child("pesanan").child("ADYtRlOHV5ODGoebM8iGCHN1tjG3").child("12-05-2019-21:26").child("pesanan").child("0");
//                .child("ADYtRlOHV5ODGoebM8iGCHN1tjG3").child("12-05-2019-02:12");
//                .child("ADYtRlOHV5ODGoebM8iGCHN1tjG3").child("12-05-2019-21:26").child("pesanan").child("0");
        progressDialog.setMessage("Loading Data from Firebase Database");
        progressDialog.show();
//        databaseReference.addValueEventListener(new ValueEventListener() {
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                Log.e("Pesan 3", String.valueOf(snapshot.getRef()));
                if(snapshot.exists()){
//                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        String name = snapshot.child("nama").getValue(String.class);
                        String number = "aksdjkasjdka";
                        String price = "asu kabeh";
                        Log.e("TAG", name + " / " + number + " / " + price);
                        PesananObjek studentDetails = snapshot.getValue(PesananObjek.class);
                        list.add(studentDetails);
//                    }
                }else{
                    Toast.makeText(getActivity(), "****NOT FOUND****", Toast.LENGTH_LONG).show();
                }
//                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                    Log.e("Pesan","asu");
//                    String name = dataSnapshot.child("nama").getValue(String.class);
//                    String number = "aksdjkasjdka";
//                    String price = "asu kabeh";
//                    Log.e("TAG", name + " / " + number + " / " + price);

//                }

                adapter = new PesananAdapter(getActivity(), list);

                recyclerView.setAdapter(adapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }

        };
        ref.addListenerForSingleValueEvent(eventListener);
        return fView;
    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        progressDialog.setContentView();
//


}

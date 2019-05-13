package com.example.adminlarise;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Global {
    public static DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    static final ArrayList<PesananObjek> po = new ArrayList<>();
    static final ArrayList<String> Key = new ArrayList<>();
    static double longitude,latitude;
    public static void setListener() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
//        progressDialog.setMessage("Loading Data from Firebase Database");
//        progressDialog.show();
        ref.child("pesanan").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                for (DataSnapshot single : dataSnapshot.getChildren()) {
                    Log.e("MASUK", dataSnapshot.getKey());
                    Key.add(dataSnapshot.getKey());
                    po.add(single.getValue(PesananObjek.class));
                    Log.e("data", String.valueOf(po.get(po.size()-1).getLatitude()));
                    Log.e("data", String.valueOf(po.get(po.size()-1).getLongitude()));

                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.e("CHANGE", dataSnapshot.getKey());
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                Log.e("REMOVED", dataSnapshot.getKey());
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.e("MOVE", dataSnapshot.getKey());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    public static void updateStatus(PesananObjek p,String Key,String stat){
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        db.child("pesanan").child(Key).child(p.getId()).child("status").setValue(stat);
    }
}

package com.example.adminlarise;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {

    View fView;
    TextView txtMasuk,txtProgres,txtSelesai;


    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fView = inflater.inflate(R.layout.fragment_home, container, false);
        int a, b,c;
        a=0;
        b=0;
        c=0;
        for(int i=0; i<Global.po.size();i++){
            if(Global.po.get(i).getStatus().equals("WAIT")){
                Log.e("INI A", String.valueOf(a));
                a++;
            }else if(Global.po.get(i).getStatus().equals("PENDING")){
                b++;
            }else{
                c++;
            }
        }

        txtMasuk = fView.findViewById(R.id.pesananMasuk);
        txtProgres = fView.findViewById(R.id.pesananProses);
        txtSelesai = fView.findViewById(R.id.pesananHistory);
        txtMasuk.setText(String.valueOf(a));
        txtProgres.setText(String.valueOf(b));
        txtSelesai.setText(String.valueOf(c));
        // Inflate the layout for this fragment
        return fView;
    }

}

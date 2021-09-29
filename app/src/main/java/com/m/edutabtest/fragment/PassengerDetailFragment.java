package com.m.edutabtest.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.m.edutabtest.R;
import com.m.edutabtest.adapter.PassengerAdapter;
import com.m.edutabtest.models.BaseResponse;
import com.m.edutabtest.networkss.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PassengerDetailFragment extends Fragment {
    private Context mContext;
    private RecyclerView rv;
    APIService mService;

    public static PassengerDetailFragment newInstance() {
        PassengerDetailFragment fragment = new PassengerDetailFragment();
        Bundle bundle = new Bundle();

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.passenger_detail, null);
        initiz(view);

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void initiz(View view) {
        rv = view.findViewById(R.id.rv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);
    }


}

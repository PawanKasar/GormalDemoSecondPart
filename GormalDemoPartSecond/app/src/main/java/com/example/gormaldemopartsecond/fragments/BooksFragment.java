package com.example.gormaldemopartsecond.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gormaldemopartsecond.Interfaces.SubApiInterface;
import com.example.gormaldemopartsecond.R;
import com.example.gormaldemopartsecond.RetroClient.RetrofitApiUtils;
import com.example.gormaldemopartsecond.adapters.BooksAdapter;
import com.example.gormaldemopartsecond.models.AvailableBookResultModel;
import com.example.gormaldemopartsecond.models.BookModel;
import com.example.gormaldemopartsecond.utilities.CallingImportantMethod;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class BooksFragment extends Fragment {

    private RecyclerView rvBookList;
    private SubApiInterface iApiInterface;
    private RetrofitApiUtils retrofitApiUtils;
    private BooksAdapter booksAdapter;
    ProgressDialog pd;

    public BooksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_books, container, false);
        initViews(rootView);
        return rootView;
    }

    private void initViews(View rootView){
        rvBookList = rootView.findViewById(R.id.rv_bookList);

        try{
            pd = new ProgressDialog(getActivity(), R.style.MyTheme);
            pd.setCancelable(false);
            pd.setProgressStyle(android.R.style.Widget_ProgressBar_Small);
            pd.show();
            requestServerToGetAvailableBookList();
        }catch (Exception ex){
            try {
                throw new IOException(ex.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /*
    * Api Calling method to fetch Books List from server
    **/
    private void requestServerToGetAvailableBookList(){
        iApiInterface = retrofitApiUtils.getAPIService();
        iApiInterface.requestServerToGetAvailableBookList().enqueue(new Callback<BookModel>() {
            @Override
            public void onResponse(Call<BookModel> call, Response<BookModel> response) {
                try{
                    if (response.isSuccessful()){
                        if (response.body() != null){
                            ArrayList<AvailableBookResultModel> bookResultModelArrayList = response.body().getResults();
                            Log.e("HomeFragment","ArrayList "+bookResultModelArrayList.toString());
                            setDataOnRecyclerView(bookResultModelArrayList);
                            pd.dismiss();
                        }else {
                            CallingImportantMethod.showToast(getContext(),"Data is null");
                            pd.dismiss();
                        }
                    }else {
                        CallingImportantMethod.showToast(getContext(),"No response from server");
                        pd.dismiss();
                    }
                }catch (Exception ex){
                    try {
                        pd.dismiss();
                        throw new IOException(ex.toString());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        pd.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<BookModel> call, Throwable t) {
                try {
                    CallingImportantMethod.showToast(getContext(),t.getMessage());
                    pd.dismiss();
                }catch (Exception e){
                    e.printStackTrace();
                    pd.dismiss();
                }
            }
        });
    }

    private void setDataOnRecyclerView(ArrayList<AvailableBookResultModel> arrayList){
        try {
            rvBookList.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            rvBookList.setLayoutManager(layoutManager);
            booksAdapter = new BooksAdapter(getContext(), arrayList);
            rvBookList.setAdapter(booksAdapter);
            booksAdapter.notifyDataSetChanged();
        }catch (Exception ex){
            try {
                throw new IOException(ex.toString());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}

package com.example.gormaldemopartsecond.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gormaldemopartsecond.Interfaces.SubApiInterface;
import com.example.gormaldemopartsecond.R;
import com.example.gormaldemopartsecond.RetroClient.RetrofitApiUtils;
import com.example.gormaldemopartsecond.models.BookModel;
import com.example.gormaldemopartsecond.utilities.CallingImportantMethod;

import java.io.IOException;

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

                }catch (Exception ex){
                    try {
                        //pd.dismiss();
                        throw new IOException(ex.toString());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                        //pd.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<BookModel> call, Throwable t) {
                try {
                    CallingImportantMethod.showToast(getContext(),t.getMessage());
                    //pd.dismiss();
                }catch (Exception e){
                    e.printStackTrace();
                    //pd.dismiss();
                }
            }
        });
    }
}

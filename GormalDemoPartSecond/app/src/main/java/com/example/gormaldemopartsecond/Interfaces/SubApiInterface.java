package com.example.gormaldemopartsecond.Interfaces;


import com.example.gormaldemopartsecond.models.BookModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface SubApiInterface {

    @GET("getAllAvailableBooks")
    Call<BookModel> requestServerToGetAvailableBookList();

}

package com.zht.service.impl;

import com.zht.danmu.api.DouYuApi;
import com.zht.model.douyuapi.RoomInfBean;
import com.zht.service.IDouyuApi;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * Created by zht on 2018/4/24.
 */
@Service
public class DouyuApiServiceImpl implements IDouyuApi {
    @Override
    public RoomInfBean getcontent() {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(DouYuApi.url).
                addConverterFactory(GsonConverterFactory.create()).
                build();
        DouYuApi douyuapi=retrofit.create(DouYuApi.class);
        Call<RoomInfBean> call=douyuapi.getZhihuDetail(643037);
        try {
            Response<RoomInfBean> res=call.execute();
            return res.body();
        } catch (IOException e) {
            e.printStackTrace();  //会堵塞主线程，因为是同步请求
        }
        return null;
    }

    @Override
    public String room_status() {
        return getcontent().getData().getRoom_status();
    }


}

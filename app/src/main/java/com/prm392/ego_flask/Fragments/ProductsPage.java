package com.prm392.ego_flask.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.prm392.ego_flask.R;
import com.prm392.ego_flask.models.Bottle;
import com.prm392.ego_flask.models.BottleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends Fragment {
    private RecyclerView recyclerView;
    private BottleAdapter bottleAdapter;
    private List<Bottle> bottleList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, container, false);

        // Khởi tạo RecyclerView và Adapter
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        bottleList = new ArrayList<>();
        bottleAdapter = new BottleAdapter(bottleList, getContext());
        recyclerView.setAdapter(bottleAdapter);

        fetchComponents();

        return view;
    }

    private void fetchComponents() {
        String url = "https://egoflask-be.azurewebsites.net/api/Product?pageSize=100";

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Bottle bottle = new Bottle();

                                // Gán dữ liệu từ JSON vào đối tượng Bottle
                                bottle.setId(jsonObject.getString("productId"));
                                bottle.setName(jsonObject.getString("name"));
                                bottle.setImageUrl(jsonObject.getString("imageUrl"));
                                bottle.setSoldQuantity(jsonObject.getInt("sold")); // Lấy số lượng đã bán
                                bottle.setPrice(jsonObject.getDouble("price")); // Lấy giá từ JSON
                                bottle.setNapColor(jsonObject.getString("engrave")); // Thay đổi nếu cần
                                bottle.setQuaiColor(jsonObject.getString("engrave")); // Thay đổi nếu cần
                                bottle.setBinhColor(jsonObject.getString("engrave")); // Thay đổi nếu cần

                                bottleList.add(bottle);
                            }
                            bottleAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        requestQueue.add(jsonArrayRequest);
    }

}

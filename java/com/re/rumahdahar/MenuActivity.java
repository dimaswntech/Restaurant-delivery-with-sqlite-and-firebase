package com.re.rumahdahar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.re.rumahdahar.Adapter.FoodAdapter;
import com.re.rumahdahar.Models.Food;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food("MINUTEVEGAN PASTA",R.drawable.a1, 54800,"Spanyol Pasta Food"));
        foods.add(new Food("CAPRESE PASTA SALAD",R.drawable.a2, 48700,"Indonesian Pasta Food"));
        foods.add(new Food("CREAMY AVOCADO PASTA",R.drawable.a3, 56700,"Italian Pasta Food"));
        foods.add(new Food("INSTANT POT CREAMY GARLIC",R.drawable.a4, 54800,"American Pasta Food"));
        foods.add(new Food("ANTIPASTO TORTELLINI PASTA",R.drawable.a5, 54800,"Asian Pasta Food"));
        foods.add(new Food("SALAD PLATTER FOODIECRUSH",R.drawable.a6, 54800,"Korean Pasta Food"));

        adapter = new FoodAdapter(this, foods);
        ListView orderListView = (ListView) findViewById(R.id.order_list_view);
        orderListView.setAdapter(adapter);
        orderListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MenuActivity.this,FoodDetailActivity.class);

                Food currentFood = foods.get(position);
                Log.e("FOOD NAME", currentFood.getFoodName());
                i.putExtra("name", currentFood.getFoodName());
                i.putExtra("image", currentFood.getmImageResource());
                i.putExtra("price", currentFood.getFoodPrice());
                i.putExtra("type", currentFood.getType());
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_cart: Intent i = new Intent(MenuActivity.this, CartListActivity.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

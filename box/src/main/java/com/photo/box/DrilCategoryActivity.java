package com.photo.box;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DrilCategoryActivity extends AppCompatActivity {

    private ListView listViewDrils;
    private ArrayList <Dril> drils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dril_category);

        ActionBar actionBar=getSupportActionBar();
        if(actionBar !=null){
            actionBar.hide();

        }
        listViewDrils=findViewById(R.id.listViewDrils);
drils=new ArrayList<>();
drils.add(new Dril(getString(R.string.dril_interskol_title),getString(R.string.dril_interskol_info),R.drawable.pizza4));
drils.add(new Dril(getString(R.string.dril_makita_title),getString(R.string.dril_makita_info),R.drawable.pizza4));
drils.add(new Dril(getString(R.string.dril_devalt_title),getString(R.string.dril_devalt_info),R.drawable.pizza4));


        ArrayAdapter<Dril>adapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,drils);
       listViewDrils.setAdapter(adapter);
       listViewDrils.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Dril drill=drils.get(position);
               Intent intent=new Intent(getApplicationContext(),DrilDetailActivity.class);
               intent.putExtra("title",drill.getTitle());
               intent.putExtra("info",drill.getInfo());
               intent.putExtra("resId",drill.getImageRecoursId());

               startActivity(intent);
           }
       });

    }
}

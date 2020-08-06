package com.example.prueba11;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.prueba11.Adaptadores.ViewPagerAdapter;
import com.example.prueba11.Fragments.FragmentMascota;
import com.example.prueba11.Fragments.FragmentPerrito;
import com.example.prueba11.menu.About;
import com.example.prueba11.menu.Formulario_Contacto;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPagerAdapter adapter;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        // Add Fragment here
        adapter.AddFragment(new FragmentMascota(),"Mascota");
        adapter.AddFragment(new FragmentPerrito(),"Perrito");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity, menu);
            return super.onCreateOptionsMenu(menu);
        }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

     switch (item.getItemId()){
         case R.id.action_Contactos:
             Intent intent = new Intent(this, Formulario_Contacto.class);
             startActivity(intent);
             return  true;
         case  R.id.action_About:
             Intent intent1= new Intent(this, About.class);
             startActivity(intent1);
             return true;
         default:
             return super.onOptionsItemSelected(item);

     }



        }




}

package com.tarwisoft.ofertoncine2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PeliculaActivity extends AppCompatActivity {

    private Button btnComprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pelicula);

        btnComprar=(Button)findViewById(R.id.btnComprar);

        btnComprar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                Intent intent =  new Intent(getApplicationContext(), CompraActivity.class);
                Bundle b = new Bundle();
                b.putString("codigo_oferta","123456");
                b.putString("codigo_producto","123456");
                intent.putExtras(b);
                startActivity(intent);
            }
        });


        showToolbar("Pelicula: Advangers",true);

    }

    public void showToolbar(String title, boolean upButton){
        android.support.v7.widget.Toolbar toolbar=(android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}

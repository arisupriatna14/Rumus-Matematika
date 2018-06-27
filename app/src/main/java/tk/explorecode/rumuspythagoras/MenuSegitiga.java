package tk.explorecode.rumuspythagoras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuSegitiga extends AppCompatActivity implements View.OnClickListener {
    private Button btnLuasSegitiga, btnAlasSegitiga, btnTinggiSegitiga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_segitiga);

        getSupportActionBar().setTitle("Segitiga");

        btnLuasSegitiga = (Button) findViewById(R.id.btn_luas_segitiga);
        btnAlasSegitiga = (Button) findViewById(R.id.btn_alas_segitiga);
        btnTinggiSegitiga = (Button) findViewById(R.id.btn_tinggi_segitiga);

        btnLuasSegitiga.setOnClickListener(this);
        btnAlasSegitiga.setOnClickListener(this);
        btnTinggiSegitiga.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_luas_segitiga:
                Intent luasSegitiga = new Intent(MenuSegitiga.this, LuasSegitiga.class);
                startActivity(luasSegitiga);
                break;
            case R.id.btn_alas_segitiga:
                Intent alasSegitiga = new Intent(MenuSegitiga.this, AlasSegitiga.class);
                startActivity(alasSegitiga);
                break;
            case R.id.btn_tinggi_segitiga:
                Intent tinggiSegitiga = new Intent(MenuSegitiga.this, TinggiSegitiga.class);
                startActivity(tinggiSegitiga);
                break;
        }
    }
}

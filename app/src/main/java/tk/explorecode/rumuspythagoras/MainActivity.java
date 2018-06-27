package tk.explorecode.rumuspythagoras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnBelahKetupat;
    private Button btnTrapesium;
    private Button btnSegitiga;
    private Button btnJajarGenjang;
    private Button btnBujurSangkar;
    private Button btnPersegiPanjang;
    private Button btnLingkaran;
    private Button btnKubus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBelahKetupat = (Button)findViewById(R.id.btn_belah_ketupat);
        btnTrapesium = (Button)findViewById(R.id.btn_trapesium);
        btnSegitiga = (Button)findViewById(R.id.btn_segitiga);
        btnJajarGenjang = (Button)findViewById(R.id.btn_jajar_genjang);
        btnBujurSangkar = (Button)findViewById(R.id.btn_bujur_sangkar);
        btnPersegiPanjang = (Button)findViewById(R.id.btn_persegi_panjang);
        btnLingkaran = (Button)findViewById(R.id.btn_lingkaran);
        btnKubus =  (Button)findViewById(R.id.btn_kubus);

        btnBelahKetupat.setOnClickListener(this);
        btnTrapesium.setOnClickListener(this);
        btnSegitiga.setOnClickListener(this);
        btnJajarGenjang.setOnClickListener(this);
        btnBujurSangkar.setOnClickListener(this);
        btnPersegiPanjang.setOnClickListener(this);
        btnLingkaran.setOnClickListener(this);
        btnKubus.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_belah_ketupat:
                Intent intentBelahKetupat = new Intent(MainActivity.this, LuasBelahKetupat.class);
                startActivity(intentBelahKetupat);
                break;
            case R.id.btn_trapesium:
                Intent intentTrapesium = new Intent(MainActivity.this, Trapesium.class);
                startActivity(intentTrapesium);
                break;
            case R.id.btn_segitiga:
                Intent intentSegitiga = new Intent(MainActivity.this, MenuSegitiga.class);
                startActivity(intentSegitiga);
                break;
            case R.id.btn_jajar_genjang:
                Intent intenJajarGenjang = new Intent(MainActivity.this, JajarGenjang.class);
                startActivity(intenJajarGenjang);
                break;
            case R.id.btn_bujur_sangkar:
                Intent intentBujurSangkar = new Intent(MainActivity.this, BujurSangkar.class);
                startActivity(intentBujurSangkar);
                break;
            case R.id.btn_persegi_panjang:
                Intent intentPersegiPanjang = new Intent(MainActivity.this, PersegiPanjang.class);
                startActivity(intentPersegiPanjang);
                break;
            case R.id.btn_lingkaran:
                Intent intentLingkaran = new Intent(MainActivity.this, Lingkaran.class);
                startActivity(intentLingkaran);
                break;
            case R.id.btn_kubus:
                Intent intentKubus = new Intent(MainActivity.this, Kubus.class);
                startActivity(intentKubus);
                break;
        }
    }
}

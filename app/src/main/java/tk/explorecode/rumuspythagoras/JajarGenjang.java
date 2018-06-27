package tk.explorecode.rumuspythagoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class JajarGenjang extends AppCompatActivity implements View.OnClickListener{
    private EditText inputAlas, inputTinggi;
    private Button btnHitungLuasJajarGenjang;
    private TextView resultHasilLuasJajarGenjang;

    private static final String STATE_HASIL_JAJAR_GENJANG = "state_hasil_jajar_genjang";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jajar_genjang);

        getSupportActionBar().setTitle("Jajar Genjang");

        inputAlas = (EditText)findViewById(R.id.input_alas_jajar_genjang);
        inputTinggi = (EditText)findViewById(R.id.input_tinggi_jajar_genjang);
        btnHitungLuasJajarGenjang = (Button)findViewById(R.id.btn_hitung_luas_jajar_genjang);
        resultHasilLuasJajarGenjang = (TextView)findViewById(R.id.result_luas_jajar_genjang);

        btnHitungLuasJajarGenjang.setOnClickListener(this);

        if (savedInstanceState != null) {
            String hasilLuasJajarGenjang = savedInstanceState.getString(STATE_HASIL_JAJAR_GENJANG);
            resultHasilLuasJajarGenjang.setText(hasilLuasJajarGenjang);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL_JAJAR_GENJANG, resultHasilLuasJajarGenjang.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung_luas_jajar_genjang) {
            String alasTrapesium = inputAlas.getText().toString().trim();
            String tinggiTrapesium = inputTinggi.getText().toString().trim();
            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(alasTrapesium)) {
                isEmptyFields = true;
                inputAlas.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(tinggiTrapesium)) {
                isEmptyFields = true;
                inputTinggi.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double alas_trapesium = Double.parseDouble(alasTrapesium);
                double tinggi_trapesium = Double.parseDouble(tinggiTrapesium);
                double luasJajarGenjang = alas_trapesium * tinggi_trapesium;
                resultHasilLuasJajarGenjang.setText(String.valueOf("Luas Jajar Genjang = " + luasJajarGenjang + " cm"));
            }
        }
    }
}

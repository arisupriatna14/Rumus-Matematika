package tk.explorecode.rumuspythagoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Trapesium extends AppCompatActivity implements View.OnClickListener{
    private EditText inputAlasAtas, inputAlasBawah, inputTinggi;
    private Button btnHitungLuasTrapesium;
    private TextView resultLuasTrapesium;

    private static final String STATE_HASIL_TRAPESIUM = "state_hasil_trapesium";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapesium);

        getSupportActionBar().setTitle("Trapesium");

        inputAlasAtas = (EditText)findViewById(R.id.input_alas_atas);
        inputAlasBawah = (EditText)findViewById(R.id.input_alas_bawah);
        inputTinggi = (EditText)findViewById(R.id.input_tinggi);
        btnHitungLuasTrapesium = (Button)findViewById(R.id.btn_hitung_luas_trapesium);
        resultLuasTrapesium = (TextView)findViewById(R.id.result_luas_trapesium);
        btnHitungLuasTrapesium.setOnClickListener(this);

        if (savedInstanceState != null) {
            String hasilLuasTrapesium = savedInstanceState.getString(STATE_HASIL_TRAPESIUM);
            resultLuasTrapesium.setText(hasilLuasTrapesium);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL_TRAPESIUM, resultLuasTrapesium.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung_luas_trapesium) {
            String alasAtas = inputAlasAtas.getText().toString().trim();
            String alasBawah = inputAlasBawah.getText().toString().trim();
            String tinggiTrapesium = inputTinggi.getText().toString().trim();
            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(alasAtas)) {
                isEmptyFields = true;
                inputAlasAtas.setError("Field tidak boleh kosong");
            }
            if (TextUtils.isEmpty(alasBawah)) {
                isEmptyFields = true;
                inputAlasBawah.setError("Field tidak boleh kosong");
            }
            if (TextUtils.isEmpty(tinggiTrapesium)) {
                isEmptyFields = true;
                inputTinggi.setError("Field tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double alas_atas = Double.parseDouble(alasAtas);
                double alas_bawah = Double.parseDouble(alasBawah);
                double tinggi = Double.parseDouble(tinggiTrapesium);
                double luasTrapesium = (alas_atas * alas_bawah * tinggi) / 4;
                resultLuasTrapesium.setText(String.valueOf("Luas Trapesium = " + luasTrapesium + " cm"));
            }
        }
    }
}

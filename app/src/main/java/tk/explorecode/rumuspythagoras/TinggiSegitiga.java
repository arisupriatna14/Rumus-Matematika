package tk.explorecode.rumuspythagoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TinggiSegitiga extends AppCompatActivity implements View.OnClickListener {
    private EditText inputLuas, inputAlas;
    private Button btnHitungTinggiSegitiga;
    private TextView resultHasilTinggiSegitiga;

    private static final String STATE_HASIL_TINGGI_SEGITIGA = "state_hasil_tinggi_segitiga";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinggi_segitiga);

        getSupportActionBar().setTitle("Tinggi Segitiga");

        inputLuas = (EditText) findViewById(R.id.input_luas_segitiga);
        inputAlas = (EditText) findViewById(R.id.input_alas_segitiga);
        btnHitungTinggiSegitiga = (Button) findViewById(R.id.btn_hitung_tinggi_segitiga);
        resultHasilTinggiSegitiga = (TextView) findViewById(R.id.result_hasil_tinggi_segitiga);

        btnHitungTinggiSegitiga.setOnClickListener(this);


        if (savedInstanceState != null) {
            String hasilTinggi = savedInstanceState.getString(STATE_HASIL_TINGGI_SEGITIGA);
            resultHasilTinggiSegitiga.setText(hasilTinggi);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL_TINGGI_SEGITIGA, resultHasilTinggiSegitiga.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung_tinggi_segitiga) {
            String input_luas = inputLuas.getText().toString().trim();
            String input_alas = inputAlas.getText().toString().trim();
            boolean isEmptyField = false;

            if (TextUtils.isEmpty(input_luas)) {
                isEmptyField = true;
                inputLuas.setError("Field ini tidak boleh kosong");
            }

            if (TextUtils.isEmpty(input_alas)) {
                isEmptyField = true;
                inputAlas.setError("Field ini tidak boleh kosong");
            }

            if (!isEmptyField) {
                double inputLuas = Double.parseDouble(input_luas);
                double inputAlas = Double.parseDouble(input_alas);
                double tinggiSegitiga = inputLuas / inputAlas;
                resultHasilTinggiSegitiga.setText(String.valueOf("Tinggi Segitiga = " + tinggiSegitiga + " cm"));
            }


        }
    }
}

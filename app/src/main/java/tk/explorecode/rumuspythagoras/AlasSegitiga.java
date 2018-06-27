package tk.explorecode.rumuspythagoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AlasSegitiga extends AppCompatActivity implements View.OnClickListener {
    private EditText inputLuas, inputTinggi;
    private Button btnHitungAlasSegitigal;
    private TextView resultHasilAlasSegitiga;

    private static final String STATE_HASIL_ALAS_SEGITIGA = "state_hasil_alas_segitiga";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alas_segitiga);

        getSupportActionBar().setTitle("Alas Segitiga");

        inputLuas = (EditText) findViewById(R.id.input_luas_segitiga);
        inputTinggi = (EditText) findViewById(R.id.input_tinggi_segitiga);
        btnHitungAlasSegitigal = (Button) findViewById(R.id.btn_hitung_alas_segitiga);
        resultHasilAlasSegitiga = (TextView) findViewById(R.id.result_hasil_alas_segitiga);

        btnHitungAlasSegitigal.setOnClickListener(this);

        if (savedInstanceState != null) {
            String hasilAlasSegitiga = savedInstanceState.getString(STATE_HASIL_ALAS_SEGITIGA);
            resultHasilAlasSegitiga.setText(hasilAlasSegitiga);
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL_ALAS_SEGITIGA, resultHasilAlasSegitiga.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung_alas_segitiga) {
            String input_luas = inputLuas.getText().toString().trim();
            String input_tinggi = inputTinggi.getText().toString().trim();
            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(input_luas)) {
                isEmptyFields = true;
                inputLuas.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(input_tinggi)) {
                isEmptyFields = true;
                inputTinggi.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double inputLuas = Double.parseDouble(input_luas);
                double inputTinggi = Double.parseDouble(input_tinggi);
                double alasSegitiga = inputLuas / inputTinggi;
                resultHasilAlasSegitiga.setText(String.valueOf("Alas Segitiga = " + alasSegitiga + " cm"));
            }
        }
    }
}

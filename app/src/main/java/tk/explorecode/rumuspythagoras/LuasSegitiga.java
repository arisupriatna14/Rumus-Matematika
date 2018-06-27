package tk.explorecode.rumuspythagoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LuasSegitiga extends AppCompatActivity implements View.OnClickListener{
    private EditText inputAlasSegitiga, inputTinggiSegitiga;
    private Button btnHitungLuasSegitiga;
    private TextView resultHasilLuasSegitiga;

    private static final String STATE_HASIL_SEGITIGA = "state_hasil_segitiga";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas_segitiga);

        getSupportActionBar().setTitle("Luas Segitiga");

        inputAlasSegitiga = (EditText)findViewById(R.id.input_alas_segitiga);
        inputTinggiSegitiga = (EditText)findViewById(R.id.input_tinggi_segitiga);
        btnHitungLuasSegitiga = (Button)findViewById(R.id.btn_hitung_luas_segitiga);
        resultHasilLuasSegitiga = (TextView)findViewById(R.id.result_luas_segitiga);

        btnHitungLuasSegitiga.setOnClickListener(this);


        if (savedInstanceState != null) {
            String hasiLuasSegitiga = savedInstanceState.getString(STATE_HASIL_SEGITIGA);
            resultHasilLuasSegitiga.setText(String.valueOf(hasiLuasSegitiga));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL_SEGITIGA, resultHasilLuasSegitiga.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung_luas_segitiga) {
            String alasSegitiga = inputAlasSegitiga.getText().toString().trim();
            String tinggiSegitiga = inputTinggiSegitiga.getText().toString().trim();
            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(alasSegitiga)) {
                isEmptyFields = true;
                inputAlasSegitiga.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(tinggiSegitiga)) {
                isEmptyFields = true;
                inputTinggiSegitiga.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double alas_segitiga = Double.parseDouble(alasSegitiga);
                double tinggi_segitiga = Double.parseDouble(tinggiSegitiga);
                double luasSegitiga = (alas_segitiga * tinggi_segitiga) / 2;
                resultHasilLuasSegitiga.setText(String.valueOf("Luas Segitiga = " + luasSegitiga + " cm"));
            }
        }
    }
}

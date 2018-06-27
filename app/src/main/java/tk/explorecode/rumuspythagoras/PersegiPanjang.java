package tk.explorecode.rumuspythagoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PersegiPanjang extends AppCompatActivity implements View.OnClickListener{
    private EditText inputPanjang, inputLebar;
    private Button btnHitungLuasPersegiPanjang;
    private TextView resultHasilLuasPersegiPanjang;

    private static final String STATE_HASIL_PERSEGI_PANJANG = "state_hasil_persegi_panjang";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi_panjang);

        getSupportActionBar().setTitle("Persegi Panjang");

        inputPanjang = (EditText)findViewById(R.id.input_panjang);
        inputLebar = (EditText)findViewById(R.id.input_lebar);
        btnHitungLuasPersegiPanjang = (Button)findViewById(R.id.btn_hitung_luas_persegi_panjang);
        resultHasilLuasPersegiPanjang = (TextView)findViewById(R.id.result_luas_persegi_panjang);

        btnHitungLuasPersegiPanjang.setOnClickListener(this);

        if (savedInstanceState != null) {
            String hasilLuasPersegiPanjang = savedInstanceState.getString(STATE_HASIL_PERSEGI_PANJANG);
            resultHasilLuasPersegiPanjang.setText(hasilLuasPersegiPanjang);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL_PERSEGI_PANJANG, resultHasilLuasPersegiPanjang.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung_luas_persegi_panjang) {
            String panjangPersegiPanjang = inputPanjang.getText().toString().trim();
            String lebarPersegiPanjang = inputLebar.getText().toString().trim();
            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(panjangPersegiPanjang)) {
                isEmptyFields = true;
                inputPanjang.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(lebarPersegiPanjang)) {
                isEmptyFields = true;
                inputLebar.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double panjang = Double.parseDouble(panjangPersegiPanjang);
                double lebar = Double.parseDouble(lebarPersegiPanjang);
                double luasPersegiPanjang = panjang * lebar;
                resultHasilLuasPersegiPanjang.setText(String.valueOf("Luas Persegi Panjang = " + luasPersegiPanjang + " cm"));
            }
        }
    }
}

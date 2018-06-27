package tk.explorecode.rumuspythagoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BujurSangkar extends AppCompatActivity implements View.OnClickListener{
    private EditText inputSisiSatu, inputSisiDua;
    private Button btnHitungLuasBujurSangkar;
    private TextView resultHasilLuasBujurSangkar;

    private static final String STATE_HASIL_BUJUR_SANGKAR = "state_hasil_bujur_sangkar";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bujur_sangkar);

        getSupportActionBar().setTitle("Bujur Sangkar");

        inputSisiSatu = (EditText)findViewById(R.id.input_sisi_1);
        inputSisiDua = (EditText)findViewById(R.id.input_sisi_2);
        btnHitungLuasBujurSangkar = (Button)findViewById(R.id.btn_hitung_luas_bujur_sangkar);
        resultHasilLuasBujurSangkar = (TextView)findViewById(R.id.result_luas_bujur_sangkar);

        btnHitungLuasBujurSangkar.setOnClickListener(this);

        if (savedInstanceState != null) {
            String hasilLuasBujurSangkar = savedInstanceState.getString(STATE_HASIL_BUJUR_SANGKAR);
            resultHasilLuasBujurSangkar.setText(hasilLuasBujurSangkar);
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL_BUJUR_SANGKAR, resultHasilLuasBujurSangkar.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung_luas_bujur_sangkar) {
            String sisi_satu = inputSisiSatu.getText().toString().trim();
            String sisi_dua = inputSisiSatu.getText().toString().trim();
            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(sisi_satu)) {
                isEmptyFields = true;
                inputSisiSatu.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(sisi_dua)) {
                isEmptyFields = true;
                inputSisiDua.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double sisiSatu = Double.parseDouble(sisi_satu);
                double sisiDua = Double.parseDouble(sisi_dua);
                double luasBujurSangkar = sisiSatu * sisiDua;
                resultHasilLuasBujurSangkar.setText(String.valueOf("Luas Bujur Sangkar = "+luasBujurSangkar + " cm"));
            }
        }
    }
}

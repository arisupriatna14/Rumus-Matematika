package tk.explorecode.rumuspythagoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lingkaran extends AppCompatActivity implements View.OnClickListener{
    private EditText inputJariJari;
    private Button btnHitungLuasLingkaran;
    private TextView resultHasilLuasLingkaran;

    private static final String STATE_HASIL_LINGKARAN = "state_hasil_lingkaran";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);

        getSupportActionBar().setTitle("Lingkaran");

        inputJariJari = (EditText)findViewById(R.id.input_jari_jari);
        btnHitungLuasLingkaran = (Button)findViewById(R.id.btn_hitung_luas_lingkaran);
        resultHasilLuasLingkaran = (TextView)findViewById(R.id.result_luas_lingkaran);

        btnHitungLuasLingkaran.setOnClickListener(this);

        if (savedInstanceState != null) {
            String hasilLuasLingkaran = savedInstanceState.getString(STATE_HASIL_LINGKARAN);
            resultHasilLuasLingkaran.setText(hasilLuasLingkaran);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL_LINGKARAN, resultHasilLuasLingkaran.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_hitung_luas_lingkaran) {
            String jariJari = inputJariJari.getText().toString().trim();
            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(jariJari)) {
                isEmptyFields = true;
                inputJariJari.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double jari_jari = Double.parseDouble(jariJari);
                double luasLingkaran = 3.14 * jari_jari * jari_jari;
                resultHasilLuasLingkaran.setText(String.valueOf("Luas Lingkaran = " + luasLingkaran + "cm"));
            }
        }
    }
}

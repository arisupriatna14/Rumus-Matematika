package tk.explorecode.rumuspythagoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Kubus extends AppCompatActivity implements View.OnClickListener{
    private EditText inputSisi;
    private Button btnHitungSisiKubus;
    private TextView resultHasilSisiKubus;

    private static final String STATE_HASIL_KUBUS = "state_hasil_kubus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubus);

        getSupportActionBar().setTitle("Kubus");

        inputSisi = (EditText)findViewById(R.id.input_sisi);
        btnHitungSisiKubus = (Button)findViewById(R.id.btn_hitung_isi_kubus);
        resultHasilSisiKubus = (TextView)findViewById(R.id.result_isi_kubus);

        btnHitungSisiKubus.setOnClickListener(this);

        if (savedInstanceState != null) {
            String hasilIsiKubus = savedInstanceState.getString(STATE_HASIL_KUBUS);
            resultHasilSisiKubus.setText(hasilIsiKubus);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL_KUBUS, resultHasilSisiKubus.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hitung_isi_kubus:
                String input_sisi = inputSisi.getText().toString().trim();
                boolean isEmptyFields = false;

                if (TextUtils.isEmpty(input_sisi)) {
                    isEmptyFields = true;
                    inputSisi.setError("Field tidak boleh kosong");
                }

                if (!isEmptyFields) {
                    double inputSisi = Double.parseDouble(input_sisi);
                    double isiKubus = inputSisi * inputSisi * inputSisi;
                    resultHasilSisiKubus.setText(String.valueOf("Isi Kubus = " + isiKubus + " cm^3" ));
                }

                break;
        }
    }
}

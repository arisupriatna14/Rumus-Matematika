package tk.explorecode.rumuspythagoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LuasBelahKetupat extends AppCompatActivity implements View.OnClickListener {
    private EditText inputDiagonal1, inputDiagonal2;
    private Button btnHitungLuasBelahKetupat;
    private TextView resultLuasBelahKetupat;

    private static final String STATE_HASIL_BELAH_KETUPAT = "state_hasil_belah_ketupat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas_belah_ketupat);

        getSupportActionBar().setTitle("Belah Ketupat");

        inputDiagonal1 = (EditText)findViewById(R.id.input_diagonal_1);
        inputDiagonal2 = (EditText)findViewById(R.id.input_diagonal_2);
        btnHitungLuasBelahKetupat = (Button)findViewById(R.id.btn_hitung_luas_belah_ketupat);
        resultLuasBelahKetupat = (TextView)findViewById(R.id.result_luas_belah_ketupat);
        btnHitungLuasBelahKetupat.setOnClickListener(this);

        if (savedInstanceState != null) {
            String hasilLuasBelahKetupat = savedInstanceState.getString(STATE_HASIL_BELAH_KETUPAT);
            resultLuasBelahKetupat.setText(hasilLuasBelahKetupat);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL_BELAH_KETUPAT, resultLuasBelahKetupat.getText().toString());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hitung_luas_belah_ketupat:
                String diagonal1 = inputDiagonal1.getText().toString().trim();
                String diagonal2 = inputDiagonal2.getText().toString().trim();
                boolean isEmptyFields = false;

                if (TextUtils.isEmpty(diagonal1)) {
                    isEmptyFields = true;
                    inputDiagonal1.setError("Field tidak boleh kosong");
                }
                if (TextUtils.isEmpty(diagonal2)) {
                    isEmptyFields = true;
                    inputDiagonal2.setError("Field tidak boleh kosong");
                }
                if (!isEmptyFields) {
                    double diagonal_1 = Double.parseDouble(diagonal1);
                    double diagonal_2 = Double.parseDouble(diagonal2);
                    double luasBelahKetupat = (diagonal_1 * diagonal_2) / 2;
                    resultLuasBelahKetupat.setText(String.valueOf("Luas Belah Ketupat = " + luasBelahKetupat + " cm"));
                }
                break;
        }
    }
}

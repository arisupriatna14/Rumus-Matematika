package tk.explorecode.rumuspythagoras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MenuBelahKetupat extends AppCompatActivity implements View.OnClickListener{
    private Button btnLuasBelahKetupat, btnDiagonalSatu, btnDiagonalDua;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_belah_ketupat);

        getSupportActionBar().setTitle("Belah Ketupat");

        btnLuasBelahKetupat = (Button)findViewById(R.id.btn_luas_belah_ketupat);
        btnDiagonalSatu = (Button)findViewById(R.id.btn_diagonal_satu);
        btnDiagonalDua = (Button)findViewById(R.id.btn_diagonal_dua);

        btnLuasBelahKetupat.setOnClickListener(this);
        btnDiagonalSatu.setOnClickListener(this);
        btnDiagonalDua.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_luas_belah_ketupat:break;
            case R.id.btn_diagonal_satu:break;
            case R.id.btn_diagonal_dua:break;
        }
    }
}

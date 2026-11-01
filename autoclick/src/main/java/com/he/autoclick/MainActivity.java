package com.he.autoclick;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends Activity {

    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefs = getSharedPreferences("settings", MODE_PRIVATE);

        Switch swMaster = findViewById(R.id.swMaster);
        Switch swAutoClick = findViewById(R.id.swAutoClick);
        EditText etJarak = findViewById(R.id.etJarak);
        EditText etBlokir = findViewById(R.id.etBlokir);
        Button btnSimpan = findViewById(R.id.btnSimpan);

        swMaster.setChecked(prefs.getBoolean("master", false));
        swAutoClick.setChecked(prefs.getBoolean("autoclick", true));
        etJarak.setText(prefs.getString("jarak", "3"));
        etBlokir.setText(prefs.getString("blokir", ""));

        btnSimpan.setOnClickListener(v -> {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("master", swMaster.isChecked());
            editor.putBoolean("autoclick", swAutoClick.isChecked());
            editor.putString("jarak", etJarak.getText().toString());
            editor.putString("blokir", etBlokir.getText().toString());
            editor.apply();

            Toast.makeText(this, "Pengaturan Disimpan!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}

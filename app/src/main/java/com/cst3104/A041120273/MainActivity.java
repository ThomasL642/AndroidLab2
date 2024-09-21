package com.cst3104.A041120273;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    Switch simpleSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        simpleSwitch = (Switch) findViewById(R.id.switch1);
        simpleSwitch.setOnClickListener(new View.OnClickListener() {
            final boolean switchState = simpleSwitch.isChecked();
            final boolean[] previousState = {simpleSwitch.isChecked()};
            @Override
            public void onClick(View view) {
                boolean switchState = simpleSwitch.isChecked();
                if (switchState) {
                    Snackbar snackbar = Snackbar.make(simpleSwitch, R.string.SwitchMessage1, Snackbar.LENGTH_LONG);
                    snackbar.setAction(R.string.UndoMessage, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            simpleSwitch.setChecked(false);
                        }
                    });
                    snackbar.show();
                } else {
                    Snackbar snackbar = Snackbar.make(simpleSwitch, R.string.SwitchMessage2, Snackbar.LENGTH_LONG);
                    snackbar.setAction(R.string.UndoMessage, new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            simpleSwitch.setChecked(true);
                        }
                    });
                    snackbar.show();
                }
            }
        });


    }

    public void OnClick(View view) {
        Toast.makeText(this, getResources().getString(R.string.toast_message), Toast.LENGTH_LONG).show();
    }

}


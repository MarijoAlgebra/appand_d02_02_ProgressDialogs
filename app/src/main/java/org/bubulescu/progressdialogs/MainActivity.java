package org.bubulescu.progressdialogs;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.prefs.BackingStoreException;

public class MainActivity extends AppCompatActivity {

    private Button btnCircle, btnHorizontal;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setupListeners();
    }

    private void initWidgets() {
        btnCircle = findViewById(R.id.btnCircle);
        btnHorizontal = findViewById(R.id.btnHorizontal);
    }

    private void setupListeners() {
        btnCircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Toast.makeText(MainActivity.this, "Prošlo je 5 sec.", Toast.LENGTH_SHORT).show();
                }
                */

                progressDialog = ProgressDialog.show(MainActivity.this, "Working", "Executing bcg task");
                BcgTaskSimulation bcgTaskSimulation = new BcgTaskSimulation(progressDialog, false);
                bcgTaskSimulation.start();

            }
        });

        btnHorizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("Downloading");
                progressDialog.setMessage("Please Wait!");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.show();

                BcgTaskSimulation bcgTaskSimulation = new BcgTaskSimulation(progressDialog, true);
                bcgTaskSimulation.start();
            }
        });
    }
}

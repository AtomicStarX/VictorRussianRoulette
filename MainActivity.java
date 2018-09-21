package org.ieselcaminas.pmdm.victorrussianroulette;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private FrameLayout bangLayout;
    private TextView textBang;
    private Barrel barrel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barrel= findViewById(R.id.barrelLayout);
        barrel.setFireListener(new Barrel.FireListener() {
            @Override
            public void fire(boolean bang) {
                if(bang){
                    bang();
                }
            }
        });

        bangLayout = findViewById(R.id.bangLayout);
        textBang = findViewById(R.id.textViewBang);

        assignActionToReload();
    }

    private void assignActionToReload() {
        Button buttonReload = findViewById(R.id.buttonReload);
        buttonReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBackground();
                barrel.reset();
            }

            private void resetBackground() {
                bangLayout = findViewById(R.id.bangLayout);
                bangLayout.setBackgroundColor(getResources().getColor(R.color.colorBackgorund));
                textBang.setVisibility(View.INVISIBLE);
            }

        });
    }



    private void bang() {
        bangLayout = findViewById(R.id.bangLayout);
        textBang = findViewById(R.id.textViewBang);

        bangLayout.setBackgroundColor(getResources().getColor(R.color.colorBang));
        textBang.setVisibility(View.VISIBLE);

    }


}

package com.example.myapplicationown1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText pass_id;
    Button bt_submit;
    TextView tv_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pass_id = findViewById(R.id.pass_id);
        bt_submit = findViewById(R.id.bt_submit);
        tv_id = findViewById(R.id.tv_id);

        tv_id.setVisibility(View.GONE);

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idNumber = pass_id.getText().toString().trim();

                String dob = idNumber.substring(0,6);

                int gender = Integer.parseInt(Character.toString(idNumber.charAt(6)));
                String sGender;
                if( gender <5)
                    sGender = getString(R.string.fml);
                else
                    sGender = getString(R.string.ml);

                int nationality = Integer.parseInt(Character.toString(idNumber.charAt(10)));
                String sNationality;
                if( nationality==1)

                    sNationality = getString(R.string.sa_citeizen);
                else
                    sNationality = getString(R.string.pr_citizen);


                String text = getString(R.string.dob) + dob + "\n"+
                               getString(R.string.gender) + sGender + "\n" +
                                getString(R.string.nationality) + sNationality;

                tv_id.setText(text);
                tv_id.setVisibility(View.VISIBLE);

            }
        });

    }


}

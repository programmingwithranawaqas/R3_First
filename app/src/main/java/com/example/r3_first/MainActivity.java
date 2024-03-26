package com.example.r3_first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etID;
    private Button btnCancel, btnSubmit;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        tvResult.setVisibility(View.GONE);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = etID.getText().toString().trim();
                if(id.isEmpty())
                {
                    Toast.makeText(MainActivity.this, getString(R.string.id_can_t_be_empty), Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(id.length() != 13)
                    {
                        Toast.makeText(MainActivity.this, "ID length must be 13", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        String dob = id.substring(0, 6);
                        String sGender = id.substring(6, 10);
                        char citizen = id.charAt(10);
                        char validity = id.charAt(id.length()-1);

                        String year = "19"+dob.substring(0,2);
                        String []months = {"", "January", "February",
                                "March", "April", "May",
                                "June", "July", "August",
                                "September", "October", "November","December"};

                        int m = Integer.parseInt(dob.substring(2,4));

                        String text = "";
                        if(m>=1 && m<=12)
                        {
                            text = dob.substring(4, 6)+" "+months[m]+" "+year+"\n";
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Month is incorrect", Toast.LENGTH_SHORT).show();
                        }


                        if(Integer.parseInt(sGender)>4999)
                        {
                            text = text + "Male";

                        }
                        else
                        {
                            text += "Female";
                        }

                        if(citizen == '0')
                        {
                            text += "\n"+"SA Citizen";
                        }
                        else
                        {
                            text += "\n"+"Permanent";
                        }

                        if(validity == '0')
                        {
                            text += "\n" + "Invalid";
                        }
                        else
                        {
                            text += "\n" + "Valid";
                        }


                        tvResult.setVisibility(View.VISIBLE);
                        tvResult.setText(text);
                    }
                }
            }
        });

    }

    private void init()
    {
        etID = findViewById(R.id.etID);
        btnCancel = findViewById(R.id.btnCancel);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);
    }
}
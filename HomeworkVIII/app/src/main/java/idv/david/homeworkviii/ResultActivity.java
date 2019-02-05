package idv.david.homeworkviii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {
    private Button btnSubmit, btnClear, btnBack;
    private EditText idHeight, idWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        findViews();
    }

    private void findViews() {
        btnSubmit = findViewById(R.id.btnSubmit);
        btnClear = findViewById(R.id.btnClear);
        btnBack = findViewById(R.id.btnBack);
        idHeight = findViewById(R.id.idHeight);
        idWeight = findViewById(R.id.idWeight);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idHeight.setText("");
                idWeight.setText("");

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Bundle bundle = new Bundle();

                try {
                    String Height = idHeight.getText().toString().trim();
                    String Weight = idWeight.getText().toString().trim();
                    double BMIH = Double.parseDouble(Height);
                    double BMIW = Double.parseDouble(Weight);
                    double bmi = (BMIW) / ((BMIH * 0.01) * (BMIH * 0.01));

                    String normal = "";

                    if (bmi < 18.5) {
                        normal = "過低";
                    } else if (bmi > 24) {
                        normal = "危險";
                    } else {
                        normal = "正常";
                    }


                    if (Height.isEmpty() || Weight.isEmpty()) {
                        throw new Exception();
                    }
                    bundle.putDouble("BMI", bmi);
                    bundle.putString("normal", normal);


                } catch (Exception e) {
                    Toast.makeText(ResultActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                    return;
                }
                intent.putExtras(bundle);
                startActivity(intent);
                finish();

            }
        });

    }

    public void onBackClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

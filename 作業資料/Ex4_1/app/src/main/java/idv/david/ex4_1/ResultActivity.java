package idv.david.ex4_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvResult = findViewById(R.id.tvResult);
        showResult();
    }

    private void showResult() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            double height = bundle.getDouble("height");
            double weight = bundle.getDouble("weight");

            double bmi = weight / Math.pow(height, 2);
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            String bmiStr = nf.format(bmi);

            String result;
            if (bmi < 18.5) {
                result = "過瘦";
            } else if (bmi >= 24) {
                result = "過胖";
            } else {
                result = "正常";
            }

            StringBuilder sb = new StringBuilder();
            sb.append("BMI = ").append(bmiStr).append("\n")
                    .append("結果為: ").append(result);
            tvResult.setText(sb);
        }
    }

    public void onBackClick(View view) {
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);

        finish();
    }
}

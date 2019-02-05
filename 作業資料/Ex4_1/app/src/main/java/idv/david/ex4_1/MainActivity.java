package idv.david.ex4_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etHeight, etWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
    }

    public void onSubmitClick(View view) {
        String heightStr = etHeight.getText().toString().trim();
        String weightStr = etWeight.getText().toString().trim();

        if(heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(this, "請填妥資料再送出", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double height = Double.parseDouble(heightStr) / 100;
            double weight = Double.parseDouble(weightStr);

            Intent intent = new Intent(this, ResultActivity.class);
            Bundle bundle = new Bundle();
            bundle.putDouble("height", height);
            bundle.putDouble("weight", weight);

            intent.putExtras(bundle);

            startActivity(intent);

        } catch (NumberFormatException nfe) {
            Toast.makeText(this, "輸入資料格式有誤，請重新輸入", Toast.LENGTH_SHORT).show();
        }

    }

    public void onClearClick(View view) {
        etHeight.setText("");
        etWeight.setText(null);
    }

}

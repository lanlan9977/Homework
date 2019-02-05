package idv.david.homeworkviii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView1, textView2;
    private Button btnUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        btnUp = findViewById(R.id.btnUp);
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivity(intent);
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Double BMI = bundle.getDouble("BMI");
            String BMI2 = bundle.getString("normal");
            java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
            df.format(BMI);


            textView1.setText(String.valueOf(df.format(BMI)));
            textView2.setText(BMI2);
        }


    }

    public void onEnd(View view) {
//        Intent intent = new Intent();
//        intent.setClass(MainActivity.this, ResultActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //注意本行的FLAG設置
//        startActivity(intent);
        System.exit(0);

//        finish();
    }
}


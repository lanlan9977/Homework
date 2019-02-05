package idv.david.homeworki;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etName, etMobile;
    private Button btnSubmit;
    private TextView tvResult;
    private CheckBox btnCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        etName = findViewById(R.id.etName);
        etMobile = findViewById(R.id.etMobile);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);
        btnCheckBox = findViewById(R.id.checkBox);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnCheckBox.isChecked())
                tvResult.setText(getResources().getString(R.string.setname) + etName.getText().toString() + "\n" + getResources().getString(R.string.setmobile) + etMobile.getText().toString()+ "\n"+getResources().getString(R.string.dataCheck));
            }
        });
//        public void onToggleButtonClick(new View.OnClickListener(){
//            CheckBox tb = (CheckBox) v;
//            String tbResult = tb.getText().toString();
//            tvResult.setText(tbResult);
//        }


    }


}
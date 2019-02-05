package idv.david.homeworkiii;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {//需繼承AppCompatActivity
    private TextView tvResult;
    private Button previousButton;
    private Button nextButton;
    private ImageView teamView;
    private int buttonNo;
    private BaseballTeam[] baseballteam = {
            new BaseballTeam(R.string.p2, R.drawable.p2),
            new BaseballTeam(R.string.p3, R.drawable.p3),
            new BaseballTeam(R.string.p4, R.drawable.p4),
            new BaseballTeam(R.string.p5, R.drawable.p5),
            new BaseballTeam(R.string.p6, R.drawable.p6),
            new BaseballTeam(R.string.p7, R.drawable.p7),
            new BaseballTeam(R.string.p8, R.drawable.p8),
            new BaseballTeam(R.string.p9, R.drawable.p9),
            new BaseballTeam(R.string.p10, R.drawable.p10),
            new BaseballTeam(R.string.p1, R.drawable.p1)};

//    Activity是提供畫面的應用程式元件，使用者可以與此畫面互動以執行動作
//    系統建立您的 Activity 時會呼叫此方法,建立。
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//繼承AppCompatActivity之onCreate方法，並Override該方法
        setContentView(R.layout.activity_main);//使用setContentView可以在Activity中動態切換顯示的View
        findViews();
        //View？ 即在Acivity上所顯示的控件，就稱之為View,透過findViews()登記呈現
    }

    private void findViews() {

        //需先透過ID登記控件

        tvResult = findViewById(R.id.tvResult);
        previousButton = findViewById(R.id.previousButton);
        nextButton = findViewById(R.id.nextButton);
        teamView = findViewById(R.id.teamView);

        //setOnClickListener為按下後呈現的結果
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(baseballteam[buttonNo].getTeamname());//setText為Textview要呈現的文字內容
                teamView.setImageResource(baseballteam[buttonNo].getTeampics());//setImageResource為要呈現的圖片內容
                buttonNo--;
                if(buttonNo<0)
                    buttonNo = 9;
            }});

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvResult.setText(baseballteam[buttonNo].getTeamname());
                teamView.setImageResource(baseballteam[buttonNo].getTeampics());
                buttonNo++;
                if(buttonNo>9)
                    buttonNo = 0;
            }});

    }
}
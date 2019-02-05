package idv.david.homeworkii;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    private SeekBar seekBarRed, seekBarGreen, seekBarBlue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

    }

    private void findViews() {
        relativeLayout = findViewById(R.id.relativeLayout);
        seekBarRed = findViewById(R.id.seekBarRed);
        seekBarGreen = findViewById(R.id.seekBarGreen);
        seekBarBlue = findViewById(R.id.seekBarBlue);


        //setOnSeekBarChangeListener為滑動SeekBar後呈現的內容
        seekBarRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //onProgressChanged為正在滑動要呈現的內容
                //progress為滑動後的值，並透過setProgress()&getProgress()，取得其他seekBar的數值
                relativeLayout.setBackgroundColor(Color.rgb(progress, seekBarGreen.getProgress(), seekBarBlue.getProgress()));
                seekBarRed.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //onStartTrackingTouch為開始滑動要呈現的內容

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //onStopTrackingTouch為結束滑動要呈現的內容
                //Toast為畫面小型訊息框，makeText為要顯示的文字內容
                Toast.makeText(MainActivity.this, getString(R.string.redBend) + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });
        seekBarGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                relativeLayout.setBackgroundColor(Color.rgb(seekBarRed.getProgress(), progress, seekBarBlue.getProgress()));
                seekBarGreen.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, getString(R.string.greenBend) + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });
        seekBarBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                relativeLayout.setBackgroundColor(Color.rgb(seekBarRed.getProgress(), seekBarGreen.getProgress(), progress));
                seekBarBlue.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, getString(R.string.blueBend) + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}

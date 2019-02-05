package idv.david.homeworkiv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        relativeLayout = findViewById(R.id.relativeLayout);
    }
    //使用options Menu需先改寫onOptionsItemSelected & onCreateOptionsMenu兩種方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();//利用MenuInflater建立選單
        inflater.inflate(R.menu.options_menu, menu);//登記menu id=options_menu的選單
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int background = 0;
        switch (item.getItemId()) {//當item的ID為相同的id 會將背景改成該圖片或顏色背景
            case R.id.changeWallpaperA:
                background = R.drawable.a;
                break;
            case R.id.changeWallpaperB:
                background = R.drawable.b;
                break;
            case R.id.changeWallpaperC:
                background = R.drawable.c;
                break;
            case R.id.changeYellow:
                background = R.color.colorYellow;
                break;
            case R.id.changeBlue:
                background = R.color.colorBlue;
                break;
            case R.id.changeRed:
                background = R.color.colorRed;
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        relativeLayout.setBackgroundResource(background);//再利用relativeLayout顯示背景圖片

        return true;
    }
}

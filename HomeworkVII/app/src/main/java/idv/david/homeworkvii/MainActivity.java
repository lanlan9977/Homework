package idv.david.homeworkvii;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;

public class MainActivity extends AppCompatActivity {
    private RectBarView rectBarView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

    }

    private void findViews() {

        rectBarView = findViewById(R.id.rectBarView);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

//        MenuItem menu1 =menu.add(R.id.firstGroup, R.id.itemCircle, 0, R.string.circle);
//        MenuItem menu2 =menu.add(R.id.firstGroup, R.id.itemRect, 0, R.string.rect);
//        sub1.add(R.id.itemBlue);

        SubMenu sub1 = menu.addSubMenu(R.id.firstGroup, R.id.itemCircle, 0, R.string.circle);
        SubMenu sub2 = menu.addSubMenu(R.id.firstGroup, R.id.itemRect, 0, R.string.rect);


        sub1.add(R.id.secondGroup, R.id.itemBlue, 0, R.string.blue);
        sub1.add(R.id.secondGroup, R.id.itemRed, 1, R.string.red);
        sub2.add(R.id.secondGroup, R.id.itemBlue, 0, R.string.blue);
        sub2.add(R.id.secondGroup, R.id.itemRed, 1, R.string.red);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemCircle:
                rectBarView.setShape(0);
                break;
            case R.id.itemRect:
                rectBarView.setShape(1);
                break;
            case R.id.itemBlue:
                rectBarView.setShapeColor(0);
                rectBarView.invalidate();

                break;
            case R.id.itemRed:
                rectBarView.setShapeColor(1);
                rectBarView.invalidate();
                break;

            case R.id.itemEnd:
//                finish();
                System.exit(0);


            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

}





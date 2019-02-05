package idv.david.homeworkix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btnGo, btnStop;
    private TextView TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        btnGo = findViewById(R.id.idGo);
        btnStop = findViewById(R.id.idStop);
        TextView = findViewById(R.id.idTween);

        btnGo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AnimationSet as = new AnimationSet(true);
                TranslateAnimation translateAnimation = new TranslateAnimation(0, 700, 0, 700);
                RotateAnimation rotateAnimation = new RotateAnimation(0, 360,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                );
                rotateAnimation.setRepeatMode(Animation.RESTART);
                rotateAnimation.setRepeatCount(Animation.INFINITE);
                as.addAnimation(rotateAnimation);
                as.addAnimation(translateAnimation);
                as.setDuration(2000);
                translateAnimation.setRepeatMode(Animation.RESTART);
                translateAnimation.setRepeatCount(Animation.INFINITE);
                TextView.startAnimation(as);

            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                TextView.clearAnimation();
            }
        });
    }
}

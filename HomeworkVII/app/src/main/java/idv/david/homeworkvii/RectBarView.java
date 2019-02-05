package idv.david.homeworkvii;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RectBarView extends View {
    private List<Integer> inputData = new ArrayList<>();
    private Paint paint = new Paint();
    private int itemColorId;
    private int itemShapeId;

    public RectBarView(Context context) {
        super(context);
    }

    public RectBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);

        paint.setStrokeWidth(1f);
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);

        if (itemColorId == 0) {
            paint.setColor(Color.BLUE);
        } else if (itemColorId == 1) {
            paint.setColor(Color.RED);
        }
        if (itemShapeId == 0) {
            canvas.drawCircle(110, 140, 110, paint);
        } else if (itemShapeId == 1) {
            canvas.drawRect(10, 30, 210, 230, paint);
        }

    }

    public void setShape(int itemShapeId) {
        this.itemShapeId = itemShapeId;
    }

    public void setShapeColor(int itemColorId) {
        this.itemColorId = itemColorId;

    }

}

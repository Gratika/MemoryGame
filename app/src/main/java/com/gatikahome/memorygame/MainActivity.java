package com.gatikahome.memorygame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    int rowCount;
    int columnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //створюємо основний контейнер ConstraintLayout
        ConstraintLayout constraintLayout=new ConstraintLayout(this);
        //картки будуть розміщуватися всередині GridLayout
        columnCount=2;
        rowCount=2;
        GridLayout gridLayout = createGridLayout(rowCount,columnCount);
        //генеруємо потрібну кількість карток
        for (int i=0; i<rowCount; i++){
            for(int j=0; j<columnCount; j++){
               ImageButton imageButton = createImageButton(i,j);
               gridLayout.addView(imageButton);
            }
        }

        constraintLayout.addView(gridLayout);
        setContentView(constraintLayout);

    }
    private GridLayout createGridLayout(int rowCount, int columnCount){
        GridLayout gridLayout=new GridLayout(this);
        gridLayout.setColumnCount(columnCount);
        gridLayout.setRowCount(rowCount);
        //налаштовуємо позиціонування нашого gridLayout в ConstraintLayout
        ConstraintLayout.LayoutParams constraintLayoutParams = new ConstraintLayout.LayoutParams
                (ConstraintLayout.LayoutParams.WRAP_CONTENT , ConstraintLayout.LayoutParams.WRAP_CONTENT);
        // позиціонування в центрі контейнера ConstraintLayout
        constraintLayoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID;
        constraintLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
        constraintLayoutParams.rightToRight=ConstraintLayout.LayoutParams.PARENT_ID;
        constraintLayoutParams.bottomToBottom=ConstraintLayout.LayoutParams.PARENT_ID;
        gridLayout.setLayoutParams(constraintLayoutParams);
        return gridLayout;
    }
    private ImageButton createImageButton(int rowNum, int columnNum){
        ImageButton imageButton = new ImageButton(this);
        //встановлюємо зворотню сторону для картки
        imageButton.setBackgroundResource(R.drawable.ic_launcher_background);

        //вказуємо розташування картки (рядок та стовпчик) в GridLayout
        GridLayout.LayoutParams layoutParams= new GridLayout.LayoutParams();
        layoutParams.rowSpec = GridLayout.spec(rowNum);
        layoutParams.columnSpec=GridLayout.spec(columnNum);
        layoutParams.setGravity(Gravity.CENTER);
        imageButton.setLayoutParams(layoutParams);

        //отримую відступ у пікселях та встановлюю Margin для ImageButton
        int marginPixels = getResources().getDimensionPixelSize(R.dimen.image_margint);
        layoutParams.setMargins(marginPixels, marginPixels, marginPixels, marginPixels);
        return imageButton;

    }
}
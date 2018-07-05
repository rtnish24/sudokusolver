package com.example.sudokusolver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[][] example = new int[9][9];
        example[0][2] = 1;
        example[8][0] = 1;
        example[2][6] = 1;
        Grid grid = new Grid(example);
        grid.solve();
        System.out.println(grid.toString());
    }
}

package com.example.sudokusolver;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button solveButton = findViewById(R.id.solveButton);

        solveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int[][] startingBoard = new int[9][9];
                EditText[][] inputFields = new EditText[9][9];
                int id;

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        id = getResources().getIdentifier("cell" + Integer.toString(i) + Integer.toString(j), "id" , getPackageName());
                        inputFields[i][j] = findViewById(id);
                        if (!(inputFields[i][j].getText().length() == 0)){
                            startingBoard[i][j] = Integer.valueOf(inputFields[i][j].getText().toString());
                        }
                    }
                }
                Grid grid = new Grid(startingBoard);
                grid.solve();

                for (int i = 0; i < 9; i++) {
                    for (int j = 0; j < 9; j++) {
                        inputFields[i][j].setText(Integer.toString(grid.getCell(i, j).getValue()));
                    }
                }
            }
        });
    }
}

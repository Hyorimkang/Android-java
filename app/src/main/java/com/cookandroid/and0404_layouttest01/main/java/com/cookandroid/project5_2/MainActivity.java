package com.cookandroid.project5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtX, edtY;
    TextView txtResult;
    Button[] btnCals = new Button[4];
    Integer[] btnCalsId = {R.id.btnAdd,R.id.btnSub,R.id.btnMul,R.id.btnDiv};
    Button[] btnArr = new Button[10];
    Integer[] numIdArr = {R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5
            ,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9};
    int num1, num2, i;
    Integer result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("간단계산기 [강효림]");
        edtX = findViewById(R.id.edtX);
        edtY = findViewById(R.id.edtY);
        txtResult = findViewById(R.id.txtResult);
        for(i=0; i<btnArr.length; i++){
            btnArr[i] = findViewById(numIdArr[i]);
        }
        for(i=0; i<btnCals.length; i++){
            btnCals[i] = findViewById(btnCalsId[i]);
        }

        for (i = 0; i<btnCals.length; i++){
            final int index = i; //익명클래스안에서 사용하기 위한 변수
            btnCals[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    num1 = Integer.parseInt(edtX.getText().toString());
                    num2 = Integer.parseInt(edtY.getText().toString());

                    switch (view.getId()){
                        case R.id.btnAdd: result = num1 + num2; break;
                        case R.id.btnSub: result = num1 - num2; break;
                        case R.id.btnMul: result = num1 * num2; break;
                        case R.id.btnDiv: result = num1 / num2; break;
                    }
                    txtResult.setText("계산결과 : " + result);
                }
            });
        }//for

        for(i=0; i<btnArr.length; i++){
            final int index = i;
            btnArr[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edtX.isFocused() == true){
                        String x = edtX.getText().toString()
                                + btnArr[index].getText().toString();
                        edtX.setText(x);
                    }
                    else if(edtY.isFocused() == true){
                        String y = edtY.getText().toString()
                                + btnArr[index].getText().toString();
                        edtY.setText(y);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),
                                "먼저 에디트 텍스트를 선택하세요",Toast.LENGTH_SHORT).show();;
                    }
                }
            });
        }
    }
}
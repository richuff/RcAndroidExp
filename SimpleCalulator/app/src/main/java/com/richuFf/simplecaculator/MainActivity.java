package com.richuFf.simplecaculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_result;
    private String firstNum = "";
    private String operator="";
    private String secondNum = "";

    private String showText = "";
    private String result = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取结果文本视图
        tv_result = findViewById(R.id.tv_result);
        //给每个按钮绑定事件
        findViewById(R.id.btn_cancel).setOnClickListener(this);
        findViewById(R.id.btn_div).setOnClickListener(this);
        findViewById(R.id.btn_mul).setOnClickListener(this);
        findViewById(R.id.btn_clear).setOnClickListener(this);
        findViewById(R.id.btn_seven).setOnClickListener(this);
        findViewById(R.id.btn_eight).setOnClickListener(this);
        findViewById(R.id.btn_nine).setOnClickListener(this);
        findViewById(R.id.btn_plus).setOnClickListener(this);
        findViewById(R.id.btn_four).setOnClickListener(this);
        findViewById(R.id.btn_five).setOnClickListener(this);
        findViewById(R.id.btn_six).setOnClickListener(this);
        findViewById(R.id.btn_mius).setOnClickListener(this);
        findViewById(R.id.btn_one).setOnClickListener(this);
        findViewById(R.id.btn_two).setOnClickListener(this);
        findViewById(R.id.btn_three).setOnClickListener(this);
        findViewById(R.id.btn_sqrt).setOnClickListener(this);
        findViewById(R.id.btn_divone).setOnClickListener(this);
        findViewById(R.id.btn_zero).setOnClickListener(this);
        findViewById(R.id.btn_point).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String inputtext;
        if (v.getId() == R.id.btn_sqrt){
            inputtext = "√";
        }else{
            inputtext = ((TextView) v).getText().toString();
        }
        if (v.getId() == R.id.btn_clear) {
            clear();
        }else if(v.getId() == R.id.btn_cancel) {
            cancel();
        }else if(v.getId() == R.id.btn_plus) {
            operator = inputtext;
            refreshText(showText+inputtext);
            if (!Objects.equals(firstNum, "") && !Objects.equals(secondNum,"")){
                double caculate_result = Caculate();
                refreshOpreator(String.valueOf(caculate_result));
            }
        }else if (v.getId() == R.id.btn_mius) {
            operator = inputtext;
            refreshText(showText+inputtext);
            if (!Objects.equals(firstNum, "") && !Objects.equals(secondNum,"")){
                double caculate_result = Caculate();
                refreshOpreator(String.valueOf(caculate_result));
            }
        }else if (v.getId() == R.id.btn_mul) {
            operator = inputtext;
            refreshText(showText+inputtext);
            if (!Objects.equals(firstNum, "") && !Objects.equals(secondNum,"")){
                double caculate_result = Caculate();
                refreshOpreator(String.valueOf(caculate_result));
            }
        }else if (v.getId() == R.id.btn_div) {
            operator = inputtext;
            refreshText(showText+inputtext);
            if (!Objects.equals(firstNum, "") && !Objects.equals(secondNum,"")){
                double caculate_result = Caculate();
                refreshOpreator(String.valueOf(caculate_result));
            }
        }else if (v.getId() == R.id.btn_equal) {
            double caculate_result = Caculate();
            refreshOpreator(String.valueOf(caculate_result));
            refreshText(showText+"="+caculate_result);
        }else if (v.getId() == R.id.btn_sqrt) {
            double sqrt_result = Math.sqrt(Double.parseDouble(firstNum));
            refreshOpreator(String.valueOf(sqrt_result));
            refreshText(showText + "^=" + sqrt_result);
        }else if (v.getId()==R.id.btn_divone) {
            double sqrt_result = 1/Double.parseDouble(firstNum);
            refreshOpreator(String.valueOf(sqrt_result));
            refreshText(showText + "/=" + sqrt_result);
        }
        else{
            if (!result.isEmpty()){
                clear();
            }
            if (operator.isEmpty()) {
                firstNum = firstNum + inputtext;
            } else {
                secondNum = secondNum + inputtext;
            }
            //整数不需要前面的0
            if (showText.equals("0") && !inputtext.equals(".")) {
                refreshText(inputtext);
            } else {
                refreshText(showText + inputtext);
            }
        }
    }
    private void cancel(){
        if (showText.length()>1){
            refreshText(showText.substring(0,showText.length()-1));
        }else{
            refreshText("0");
        }
    }
    private void refreshText(String text){
        showText = text;
        tv_result.setText(showText);
    }
    private void clear() {
        refreshOpreator("");
        refreshText("0");
    }
    private void refreshOpreator(String newresult){
        result = newresult;
        firstNum = result;
        secondNum = "";
        operator = "";
    }
    private double Caculate(){
        switch (operator){
            case "+":
                return Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
            case "-":
                return Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
            case "X":
                return Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
            case "÷":
                return Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
        }
        return 0;
    }
}
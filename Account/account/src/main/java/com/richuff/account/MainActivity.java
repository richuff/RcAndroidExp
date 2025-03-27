package com.richuff.account;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import Entity.BillInfo;
import utils.BillDbHelper;
import utils.DateUtil;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private TextView tv_date;
    private EditText et_amount;
    private RadioGroup rg_type;
    private EditText et_remark;
    private Calendar calendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView tv_main = findViewById(R.id.title_main);
        TextView tv_option = findViewById(R.id.title_option);
        tv_main.setText("添加账单");
        tv_option.setText("账单列表");
        //设置账单日期
        calendar = Calendar.getInstance();
        tv_date = findViewById(R.id.account_date);
        et_amount = findViewById(R.id.et_amount);
        et_remark = findViewById(R.id.et_remark);
        rg_type = findViewById(R.id.rg_type);

        tv_date.setText(DateUtil.getCalendarTime(calendar));

        tv_date.setOnClickListener(this);
        findViewById(R.id.save).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.account_date){
            DatePickerDialog dpd = new DatePickerDialog(this,this,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            dpd.show();
        }else if (v.getId() == R.id.save) {
            Random random = new Random();
            //保存信息
            BillInfo info = new BillInfo()
                    .setDate(tv_date.getText().toString())
                    .setAmount(Double.parseDouble(et_amount.getText().toString()))
                    .setType(rg_type.getCheckedRadioButtonId() == R.id.income ? BillInfo.INCOME : BillInfo.COST)
                    .setRemark(et_remark.getText().toString()).setId(random.nextInt());

            BillDbHelper dbHelper = BillDbHelper.getInstance(this);
            dbHelper.openReadLink();
            dbHelper.openWriteLink();

            if (dbHelper.insertInfo(info) > 0){
                Toast.makeText(this,"插入成功",Toast.LENGTH_SHORT).show();
            }

            dbHelper.closeLink();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);


    }
}
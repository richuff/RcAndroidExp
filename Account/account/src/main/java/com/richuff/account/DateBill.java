package com.richuff.account;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;

import java.util.Calendar;

import com.richuff.account.adpter.ViewPageAdapter;
import com.richuff.account.utils.BillDbHelper;
import com.richuff.account.utils.DateUtil;

public class DateBill extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private TextView tv_month;
    private Calendar calendar;

    private ViewPager vp_bill;

    public static BillDbHelper billDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_date_bill);

        TextView tv_main = findViewById(R.id.title_main);
        TextView tv_option = findViewById(R.id.title_option);
        tv_main.setText("账单列表");
        tv_option.setText("添加账单");

        calendar = Calendar.getInstance();
        tv_month = findViewById(R.id.account_month);
        tv_month.setText(DateUtil.getNowMonth());
        tv_month.setOnClickListener(this);

        billDbHelper = BillDbHelper.getInstance(this);
        billDbHelper.openReadLink();
        billDbHelper.openWriteLink();

        initiaPageView();

        findViewById(R.id.title_option).setOnClickListener(this);

    }


    private void initiaPageView() {
        PagerTabStrip pt = findViewById(R.id.pts_bill);
        pt.setTextSize(TypedValue.COMPLEX_UNIT_SP,17);
        vp_bill = findViewById(R.id.vp_bill);
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager(),calendar.get(Calendar.YEAR));
        vp_bill.setAdapter(adapter);
        vp_bill.setCurrentItem(calendar.get(Calendar.MONTH));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.account_month){
            DatePickerDialog dpd = new DatePickerDialog(this,this,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH));
            dpd.show();
        }else if (v.getId() == R.id.title_option){
            Intent intent = new Intent(this,MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        tv_month.setText(DateUtil.getCalendarMonth(calendar));

        vp_bill.setCurrentItem(calendar.get(Calendar.MONTH));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        billDbHelper.closeLink();
    }
}
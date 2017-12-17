package mad.com.lifetime;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;


import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterFront extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener mDobDateListener;
    public String TAG = "RegFrontActivity";
    @BindView(R.id.register_dob_button) Button dob_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_front);
        ButterKnife.bind(this);

        Toolbar regToolbar = (Toolbar) findViewById(R.id.register_toolbar);
        setSupportActionBar(regToolbar);//to support a toolbar





    }

    @OnClick(R.id.register_dob_button)
    void showDatePickerDialog(View v) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int dialog_bg_color;

        mDobDateListener = new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Log.d(TAG,"dd/mm/yyyy: "+dayOfMonth+" /"+monthOfYear+"/ "+year);
            }
        };

        DatePickerDialog dobDatePickerDialog = new DatePickerDialog(
                RegisterFront.this,
                android.R.style.Theme_Material_Dialog,
                mDobDateListener,
                year,
                month,
                day
        );
        getWindow().setGravity(Gravity.CENTER);
        dialog_bg_color = getResources().getColor(R.color.colorPrimaryDark);
        dobDatePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(dialog_bg_color));
        dobDatePickerDialog.show();
        //..you don't even need the line @InjectView(R.id.click_button) if this button isn't being used else where
    }

}

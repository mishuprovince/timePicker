package app.space365.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private  int hourOfDay,minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadTimeDialog();
    }

    private void loadTimeDialog(){
        Calendar calendar = Calendar.getInstance();
        hourOfDay = calendar.get(Calendar.HOUR);
        minute = calendar.get(Calendar.MINUTE);
        Button button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                TimePickerDialog pickerDialog = new TimePickerDialog(MainActivity.this, AlertDialog.THEME_HOLO_LIGHT, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // TODO Auto-generated method stub
                        Toast.makeText(MainActivity.this, hourOfDay + "时" + minute + "分", Toast.LENGTH_SHORT).show();
                    }
                }, hourOfDay, minute, true);
                pickerDialog.show();
            }
        });
    }
}
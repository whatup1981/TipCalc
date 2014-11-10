package com.example.tipcalc;



import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	private EditText moneyText;
	private ToggleButton button10;
	private ToggleButton button15;
	private ToggleButton button20;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    	
        button10 = (ToggleButton)findViewById(R.id.toggleButton1);
    	button15 = (ToggleButton)findViewById(R.id.toggleButton2);
    	button20 = (ToggleButton)findViewById(R.id.toggleButton3);
    	
        moneyText = (EditText)findViewById(R.id.editText1);
        
        moneyText.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			 
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				calcTips();
				
			}
		});
        calcTips();
    }
    
    private void calcTips() 
    {
    	String moneyString = moneyText.getText().toString();
    	double money = 0.0;
    	if (!moneyString.equals("")) {
    		money = Double.parseDouble(moneyString);
    	}
    	

    	int tips = 0;
    	if (button10.isChecked()) {
    		tips = 10;
    	} else if (button15.isChecked()) {
    		tips = 15;
    	} else if (button20.isChecked()) {
    		tips = 20;
    	}
    	
    	TextView showTipsText = (TextView)findViewById(R.id.showTips);
    	DecimalFormat df = new DecimalFormat( "#,###,###,##0.00" );
    	
    	showTipsText.setText(String.valueOf(df.format(money*tips/100)));
    }
    
    public void disableOtherButton(View v) {
    	switch(v.getId()) {
    	case R.id.toggleButton1:
    		button10.setChecked(true);
    		button15.setChecked(false);
    		button20.setChecked(false);
    		break;
    	case R.id.toggleButton2:
    		button10.setChecked(false);
    		button15.setChecked(true);
    		button20.setChecked(false);
    		break;
    	case R.id.toggleButton3:
    		button10.setChecked(false);
    		button15.setChecked(false);
    		button20.setChecked(true);
    		break;
    	}
    	calcTips();
    }
}

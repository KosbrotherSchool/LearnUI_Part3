package com.example.learnui_part3;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Spinner mSpinner;
	private TextView mTextView;
	private AlertDialog.Builder finishDialog;
	
	String[] colors = new String[] { "黑色", "藍色", "黃色", "紅色" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mSpinner = (Spinner) findViewById(R.id.mySpinner);
		mTextView = (TextView) findViewById(R.id.myTextView);

		ArrayAdapter<String> colorAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, colors);

		mSpinner.setAdapter(colorAdapter);

		mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView adapterView, View view,
					int position, long id) {

				String stringColor = adapterView.getSelectedItem().toString();

				Toast.makeText(MainActivity.this, "您選擇" + stringColor,
						Toast.LENGTH_SHORT).show();
				mTextView.setText("你選擇了:" + stringColor);
				
				switch (position) {
				case 0:
					mTextView.setTextColor(getResources()
							.getColor(R.color.black));
					break;
				case 1:
					mTextView.setTextColor(getResources()
							.getColor(R.color.blue));
					break;
				case 2:
					mTextView.setTextColor(getResources()
							.getColor(R.color.yellow));
					break;
				case 3:
					mTextView.setTextColor(getResources()
							.getColor(R.color.red));
					break;
				}
			}

			public void onNothingSelected(AdapterView arg0) {
				Toast.makeText(MainActivity.this, "您沒有選擇任何項目",
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		finishDialog = new AlertDialog.Builder(this)
				.setTitle("結束執行")
				.setMessage("離開ColorPicker?")
				.setPositiveButton("Yes",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								finish();
								System.exit(0);
							}
						})
				.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
		finishDialog.show();
	}

}

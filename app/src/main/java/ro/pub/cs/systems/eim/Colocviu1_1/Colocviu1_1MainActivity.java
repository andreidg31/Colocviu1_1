package ro.pub.cs.systems.eim.Colocviu1_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Colocviu1_1MainActivity extends AppCompatActivity {

    private Button northBtn, westBtn, eastBtn, southBtn;
    private String messageString = "";
    private Integer noCardinal = 0;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        private void addToString(String text) {
            if (messageString.length() == 0) {
                messageString.concat(text);
            }
            else {
                messageString.concat(",").concat(text);
            }
            TextView noCardinal = (TextView) findViewById(R.id.noCardinalTextView);
            noCardinal.setText((CharSequence) noCardinal.toString());
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.north_button:
                    noCardinal++;
                    addToString(northBtn.getText().toString());
                    noCardinal++;
                    break;
                case R.id.west_button:
                    addToString(westBtn.getText().toString());
                    noCardinal++;
                    break;
                case R.id.east_button:
                    addToString(eastBtn.getText().toString());
                    noCardinal++;
                    break;
                case R.id.south_button:
                    addToString(southBtn.getText().toString());
                    noCardinal++;
                    break;
                case R.id.navigate_button:
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_1SecondaryActivity.class);
                    intent.putExtra(Constants.CARDINAL, messageString);
                    break;
            }
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_1_main);

        northBtn = findViewById(R.id.north_button);
        westBtn = findViewById(R.id.west_button);
        eastBtn = findViewById(R.id.east_button);
        southBtn = findViewById(R.id.south_button);

        northBtn.setOnClickListener(buttonClickListener);
        westBtn.setOnClickListener(buttonClickListener);
        eastBtn.setOnClickListener(buttonClickListener);
        southBtn.setOnClickListener(buttonClickListener);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(Constants.NO_CARDINAL, noCardinal);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.NO_CARDINAL)) {
            noCardinal = savedInstanceState.getInt(Constants.NO_CARDINAL);
            TextView noCardinal = (TextView) findViewById(R.id.noCardinalTextView);
            noCardinal.setText((CharSequence) noCardinal.toString());
        }
    }
}
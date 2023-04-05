package ro.pub.cs.systems.eim.Colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Colocviu1_1MainActivity extends AppCompatActivity {

    private Button northBtn, westBtn, eastBtn, southBtn;
    private String messageString = "";

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements View.OnClickListener {

        private void addToString(String text) {
            if (messageString.length() == 0) {
                messageString.concat(text);
            }
            else {
                messageString.concat(",").concat(text);
            }

        }
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.north_button:
                    addToString(northBtn.getText().toString());
                    break;
                case R.id.west_button:
                    addToString(westBtn.getText().toString());
                    break;
                case R.id.east_button:
                    addToString(eastBtn.getText().toString());
                    break;
                case R.id.south_button:
                    addToString(southBtn.getText().toString());
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
}
package madsum.resume;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    TextView movein;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        movein = (TextView) findViewById(R.id.textView13);
        Typeface face = Typeface.createFromAsset(getAssets(), "font/SupercellFont.ttf");
        movein.setTypeface(face, Typeface.BOLD);
    }

    public void onClick(View view) {
        Intent intent = new Intent(Main3Activity.this, MainActivity2.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Welcome User !", Toast.LENGTH_LONG).show();
    }

}

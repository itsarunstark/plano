package ai.arakoo.plano;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button b = this.findViewById(R.id.clickBtn);
        b.setOnClickListener(this);
        RadioGroup grp = this.findViewById(R.id.mRadio);
        grp.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        ProgressBar bar = this.findViewById(R.id.progressBar);
        bar.setProgress(0);
        if(v.getId() == R.id.clickBtn){
            Toast.makeText(this, R.string.toastText, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        ProgressBar bar = this.findViewById(R.id.progressBar);
        if (checkedId == R.id.married) {
            bar.setProgress(34, true);
            Toast.makeText(this, R.string.marriedText, Toast.LENGTH_SHORT).show();
        } else if (checkedId == R.id.single){
            bar.setProgress(67, true);
            Toast.makeText(this, R.string.singleText, Toast.LENGTH_SHORT).show();
        } else if (checkedId == R.id.relationship){
            bar.setProgress(100, true);
            Toast.makeText(this, R.string.relationshipText, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, R.string.toastText, Toast.LENGTH_SHORT).show();
        }
    }
}
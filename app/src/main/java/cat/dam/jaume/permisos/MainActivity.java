package cat.dam.jaume.permisos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button camara, emmaga;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camara = (Button) findViewById(R.id.camara);
        emmaga = (Button) findViewById(R.id.emmaga);

        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camaraP();
            }
        });

        emmaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escrituraP();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void camaraP() {
        int permisos = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

        if (permisos == PackageManager.PERMISSION_GRANTED) {     //
            Toast.makeText(this, "Ja tens els permisos de la camara!", Toast.LENGTH_SHORT).show();//toast mostran resultat
        } else {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 1);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void escrituraP() {
        int permisos = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);

        if (permisos == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Ja tens els permisos de escritura!", Toast.LENGTH_SHORT).show();//toast mostran resultat
        } else {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }
}



package kg.geektech.android2.opengallery;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    public static final int IMAGE_CODE = 1;
    private CircleImageView circleImageView;
    private Button button;
    Uri imageUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleImageView = findViewById(R.id.circleImageView);
        button =findViewById(R.id.btnGallery);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImageForm();


            }
        });


    }

    private void openImageForm() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_CODE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == IMAGE_CODE) && (resultCode == RESULT_OK) && (data != null) && (data.getData() != null)) {
            imageUri = data.getData();
            circleImageView.setImageURI(imageUri);


        }
    }
}

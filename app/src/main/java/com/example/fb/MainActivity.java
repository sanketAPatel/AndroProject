package com.example.fb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    //object for views
    EditText mTitleEt,mDescriptionEt;
    Button mSaveBtn;

    //progresdia
    ProgressDialog pd;

    //firesotre object creating
   private FirebaseFirestore db;
    //actionbar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //view initialization
        mTitleEt =findViewById(R.id.titleET);
        mDescriptionEt=findViewById(R.id.descriptionET);
        mSaveBtn=findViewById(R.id.saveBtn);


        //progress dialog
        pd= new ProgressDialog(this);
        //click button setonClick listener
        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input in g the data
                String title=mTitleEt.getText().toString().trim();
                String description=mDescriptionEt.getText().toString().trim();
                    //function call for data upload
                 uploadData(title,description);
            }
        });


    }

    private void uploadData(String title, String description) {
        //title for progrss bar
        pd.setTitle("data adding to FireStore");
        //show progreessbar
        pd.show();
        //setting up random id
        String id= UUID.randomUUID().toString();
        HashMap<String,Object>doc=new HashMap<>();
        doc.put("id",id);
        doc.put("title",title);
        doc.put("description",description);

        //to add this data
       
    }


}
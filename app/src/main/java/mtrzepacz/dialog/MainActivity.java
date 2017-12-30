package mtrzepacz.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declarations of buttons
    Button buttonSimple,buttonSimpleList,buttonRadio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assignment of buttons to layout elements
        buttonSimple = (Button) findViewById(R.id.buttonSimple);
        buttonSimpleList = (Button) findViewById(R.id.buttonSimpleList);
        buttonRadio  = (Button) findViewById(R.id.buttonListRadio);
    }



    public void createSimpleDialog(View v)
    {
        //creating builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //setting message and title
        builder.setMessage("Simple Dialog Message")
                .setTitle("Simple Dialog Title");

        //setting buttons
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
           //overriding onClick for each one
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(MainActivity.this, "Simple dialog - Yes", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(MainActivity.this, "Simple dialog  - No", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Simple dialog - Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        //Creating Alertdialog and displaying it
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void createSimpleListDialog(View v)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //array of options
        String [] options = {"First","Second","Third"};
        builder.setTitle("SimpleList Dialog Title");
        //creating list from options
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //switch metod for options
                switch (which) {
                    case 0:
                        Toast.makeText(MainActivity.this, "First", Toast.LENGTH_SHORT).show();
                    case 1:
                        Toast.makeText(MainActivity.this, "Second", Toast.LENGTH_SHORT).show();
                    case 2:
                        Toast.makeText(MainActivity.this, "Third", Toast.LENGTH_SHORT).show();
                }
            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(MainActivity.this, "Simple List dialog - Yes", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(MainActivity.this, "Simple List dialog  - No", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Simple List dialog - Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void createListWithRadio(View v)
    {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String [] options = {"Yes","No","Cancel"};
            builder.setTitle("SimpleList Dialog Title");
            // 2 argument is which one is selected by defualt
            builder.setSingleChoiceItems(options, 1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which) {
                        case 0:
                            Toast.makeText(MainActivity.this, "First Radio", Toast.LENGTH_SHORT).show();
                        case 1:
                            Toast.makeText(MainActivity.this, "Second Radio", Toast.LENGTH_SHORT).show();
                        case 2:
                            Toast.makeText(MainActivity.this, "Third Radio", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int id)
                {
                    Toast.makeText(MainActivity.this, "Radio List dialog - Yes", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int id)
                {
                    Toast.makeText(MainActivity.this, "Radio List dialog  - No", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Radio List dialog - Cancel", Toast.LENGTH_SHORT).show();
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
    }
}

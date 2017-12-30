package mtrzepacz.dialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // declarations of buttons
    Button buttonSimple,buttonSimpleList,buttonRadio,buttonCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //assignment of buttons to layout elements and setting onClickListeners
        buttonSimple = (Button) findViewById(R.id.buttonSimple);
        buttonSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSimpleDialog();
            }
        });
        buttonSimpleList = (Button) findViewById(R.id.buttonSimpleList);
        buttonSimpleList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createSimpleListDialog();
            }
        });
        buttonRadio  = (Button) findViewById(R.id.buttonListRadio);
        buttonRadio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                createListWithRadio();
            }
        });
        buttonCheck = (Button) findViewById(R.id.buttonListCheckBox);
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createListWithCheckBox();
            }
        });
    }



    public void createSimpleDialog()
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

    public void createSimpleListDialog()
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

    public void createListWithRadio()
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

    public void createListWithCheckBox()
    {
        boolean[] mSelectedItems = new boolean[3];
        mSelectedItems[0] = true;
        mSelectedItems[1] = false;
        mSelectedItems[2] = true;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final String [] options = {"Yes","No","Cancel"};
        builder.setTitle("CheckBox dialog")
                .setMultiChoiceItems(options,mSelectedItems, new DialogInterface.OnMultiChoiceClickListener(){
        @Override
        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
            if (isChecked) {
                Toast.makeText(MainActivity.this, "Check " + options[which], Toast.LENGTH_SHORT).show();
            } else  {
                Toast.makeText(MainActivity.this, "UnCheck " + options[which], Toast.LENGTH_SHORT).show();
            }

        }
    });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(MainActivity.this, "CheckBox List dialog - Yes", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                Toast.makeText(MainActivity.this, "CheckBox List dialog  - No", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "CheckBox List dialog - Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

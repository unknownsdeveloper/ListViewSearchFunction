package ankit.developer.unknowns.listviewsearchfunction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    String data[]={"Ankit","Bipul","Pankaj","Gaurav","Sourav","Abhishek","Ashish","Yash"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.searchtext);
        listView=(ListView)findViewById(R.id.list);
        arrayAdapter=new ArrayAdapter<String>(this,R.layout.list_item,R.id.textView,data);
        listView.setAdapter(arrayAdapter);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                MainActivity.this.arrayAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}

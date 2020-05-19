package com.example.mymobapplication3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {
    private DbContext dbContext;
    private TextView getAllTextView;
    private TextView emptyDBTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        dbContext = new DbContext(this);

        getAllTextView = this.findViewById(R.id.allRows);
        emptyDBTextView = this.findViewById(R.id.emptyDB);
        getAllRows();
    }

    private void getAllRows() {
        SQLiteDatabase database = dbContext.getWritableDatabase();
        Cursor cursor = database.query(DbContext.TABLE_NAME, null, null, null, null, null, null);

        //String allRows = String.format("%-3s %-30s %-40s\n", "id", "date", "result");
        String allRows = "";
        if (cursor.moveToFirst()) {
            emptyDBTextView.setText("History");
            int idIndex = cursor.getColumnIndex(DbContext.KEY_ID);
            int dateIndex = cursor.getColumnIndex(dbContext.KEY_DATE);
            int resultIndex = cursor.getColumnIndex(DbContext.KEY_RESULT);

            do {
                allRows += String.format("%-3d %-30s %-40s\n", cursor.getInt(idIndex),"Date:\n" + cursor.getString(dateIndex), cursor.getString(resultIndex));
//                System.out.println(allRows);

            } while (cursor.moveToNext() && !cursor.isLast());
            getAllTextView.setText(allRows);
        } else {
            emptyDBTextView.setText("0 row exists");
        }
        cursor.close();

        dbContext.close();
    }
}

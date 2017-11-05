package programmingtalents.com.recyclerviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<String> mItemList;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView= (RecyclerView) findViewById(R.id.mylist);
        mItemList=new ArrayList<>();
        insertDataInList();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        //For horizontal List
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,true));
        mRecyclerViewAdapter=new RecyclerViewAdapter(MainActivity.this,mItemList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

    }

    private void insertDataInList() {
        for(int i=1;i<11;i++){
            mItemList.add("Item "+i);
        }
    }
}

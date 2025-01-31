package com.example.memoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Context context;
    RecyclerView memoList;
    MemoListAdapter memoListAdapter;
    LinearLayoutManager layoutManager;

    Spinner categorySpinner;
    EditText memoEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        setView();
    }

    private void setView(){
        categorySpinner = findViewById(R.id.category);
        memoEdit = findViewById(R.id.memo);

        Button registerButton = findViewById(R.id.register);
        registerButton.setOnClickListener(this);

        memoList = findViewById(R.id.recyclerview);

        setRecyclerView();
        setMemoListItem();
    }

    private void setRecyclerView(){
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        memoList.setLayoutManager(layoutManager);

        memoListAdapter = new MemoListAdapter(context, R.layout.row_memo_item, new ArrayList<MemoItem>());
        memoList.setAdapter(memoListAdapter);
    }

    private void setMemoListItem(){
        ArrayList<MemoItem> list = getMemoDummyList();
        memoListAdapter.addItemList(list);
    }

    private ArrayList<MemoItem> getMemoDummyList(){
        ArrayList<MemoItem> list = new ArrayList<>();

        MemoItem item1 = new MemoItem("life", "lunch with hong");
        MemoItem item2 = new MemoItem("company", "meeting afternoon");

        list.add(item1);
        list.add(item2);

        return list;
    }

    @Override
    public void onClick(View v){
        registerMemo();
    }

    private void registerMemo(){
        String category = (String) categorySpinner.getSelectedItem();
        String memo = memoEdit.getText().toString();

        if(TextUtils.isEmpty(memo)){
            Toast.makeText(context, R.string.msg_memo_input, Toast.LENGTH_SHORT).show();
            return;
        }

        addMemoItem(category, memo);

        categorySpinner.setSelection(0);
        memoEdit.setText("");

        hideKeyboard();
    }

    private void hideKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void addMemoItem(String category, String memo){
        MemoItem item = new MemoItem(category, memo);

        memoListAdapter.addItem(item);
    }
}

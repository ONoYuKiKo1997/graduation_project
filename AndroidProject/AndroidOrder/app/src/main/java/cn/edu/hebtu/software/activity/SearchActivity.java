package cn.edu.hebtu.software.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.task.DivideDetailTask;

public class SearchActivity extends AppCompatActivity {
    @BindView(R.id.btn_cancle)
    public Button btnCansel;
    @BindView(R.id.et_search_content)
    public EditText editText;
    @BindView(R.id.iv_return)
    public ImageView ivReturn;
    @BindView(R.id.lv_search)
    public ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_search);
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        final Context mContext = this;
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = editText.getText().toString();
                DivideDetailTask divideDetailTask = new DivideDetailTask(mContext,listView);
                divideDetailTask.execute(str);
            }
        });

    }

    @OnClick(R.id.iv_return)
    public void onClick(){
        finish();
    }

    @OnClick(R.id.btn_cancle)
    public void onClick(View view) {
        editText.setText("");
    }


}

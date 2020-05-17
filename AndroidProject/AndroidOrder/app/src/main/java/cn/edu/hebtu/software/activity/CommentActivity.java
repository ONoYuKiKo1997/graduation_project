package cn.edu.hebtu.software.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.Date;

import cn.edu.hebtu.software.R;
import cn.edu.hebtu.software.bean.Comment;
import cn.edu.hebtu.software.task.SubmitComment;

public class CommentActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    ImageView ivReturn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_comment);
        super.onCreate(savedInstanceState);

        ivReturn = findViewById(R.id.iv_return);
        editText = findViewById(R.id.et_comment);
        button = findViewById(R.id.submit);

        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Comment comment = new Comment();
        final Intent intent = getIntent();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editText.getText().toString();
                comment.setdId(Integer.parseInt(intent.getStringExtra("dId")));
                comment.setdName(intent.getStringExtra("dName"));
                comment.setuId(intent.getStringExtra("uId"));
                comment.setuNickName(intent.getStringExtra("uNickname"));
                comment.setcContent(content);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String str = sdf.format(new Date());
                comment.setcDate(str);
                Gson gson = new Gson();
                SubmitComment submitComment = new SubmitComment(CommentActivity.this);
                submitComment.execute(gson.toJson(comment));
                Toast.makeText(CommentActivity.this,"提交成功",Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}

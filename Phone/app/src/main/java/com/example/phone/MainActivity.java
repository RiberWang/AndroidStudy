package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.phone.gridview.GridViewActivity;
import com.example.phone.listview.ListViewActivity;
import com.example.phone.recycleview.RecycleViewActivity;

import static android.Manifest.permission.CALL_PHONE;
import static android.content.Intent.ACTION_CALL;
import static android.content.Intent.ACTION_DIAL;

public class MainActivity extends AppCompatActivity {
    EditText mobileText;
    private  Button mBtnTextView, mBtnButton;
    private  Button mBtnEditText;
    private  Button mBtnRadioButton, mBtnCheckBox, mBtnImageView, mBtnListView, mBtnGridView, mBtnRecyleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileText = findViewById(R.id.mobile);

        Button button = (Button) this.findViewById(R.id.buttonClick);
        button.setOnClickListener(new ButtonClickListener());
        
        Person person = new Person();
        System.out.println(person.add(3, 9));

        mBtnTextView = findViewById(R.id.btn_textView);
        mBtnButton = findViewById(R.id.btn_button);
        mBtnEditText = findViewById(R.id.btn_login);
        mBtnRadioButton = findViewById(R.id.btn_radio);
        mBtnCheckBox = findViewById(R.id.btn_checkbox);
        mBtnImageView = findViewById(R.id.btn_imageview);
        mBtnListView = findViewById(R.id.btn_listview);
        mBtnGridView = findViewById(R.id.btn_gridview);
        mBtnRecyleView = findViewById(R.id.btn_recycle_view);
        setListeners();
    }

    private final class ButtonClickListener implements View.OnClickListener {
        public void onClick(View v) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{ CALL_PHONE}, 1); // 获取权限
            }
            else  {
                call();
            }
        }

        private void call() {
            String number = mobileText.getText().toString();
            System.out.println(number);
            Intent intent = new Intent(ACTION_CALL); // ACTION_CALL直接拨打电话 ACTION_DIAL跳转到拨号界面，用户手动点击拨打
            Uri data = Uri.parse("tel:" + number);
            intent.setData(data);
            startActivity(intent);


        }
    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnRecyleView.setOnClickListener(onClick);
    }

    private  class OnClick implements View.OnClickListener {
        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_textView:
                    // 跳转到TextView演示界面
                    intent = new Intent(MainActivity.this, TextViewActivity.class);

                    break;
                case R.id.btn_button:
                    // 跳转到Button演示界面
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;

                case R.id.btn_login:
                    // 跳转到EditText演示界面
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;

                case R.id.btn_radio:
                    // 跳转到RadioButton演示界面
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;

                case R.id.btn_checkbox:
                    // 跳转到CheckBox演示界面
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;

                case R.id.btn_imageview:
                    // 跳转到ImageView演示界面
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;

                case R.id.btn_listview:
                    // 跳转到ListView演示界面
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;

                case R.id.btn_gridview:
                    // 跳转到GridView演示界面
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;

                case R.id.btn_recycle_view:
                    // 跳转到RecycleView演示界面
                    intent = new Intent(MainActivity.this, RecycleViewActivity.class);
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + v.getId());
            }
            startActivity(intent);
        }
    }
}
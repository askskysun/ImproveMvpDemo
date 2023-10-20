package com.hero.mvpherodemo.student.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.hero.mvpherodemo.R;
import com.hero.mvpherodemo.mvp.BaseMvpActivity;
import com.hero.mvpherodemo.student.bean.StudentBean;
import com.hero.mvpherodemo.student.contract.StudentContract;
import com.hero.mvpherodemo.student.presenter.StudentPresenter;
import com.hero.mvpherodemo.student.util.ParseJsonUtil;

/**
 * View层
 */
public class StudentActivity extends BaseMvpActivity<StudentContract.View, StudentPresenter> implements StudentContract.View {

    private TextView tvData;
    private String requestUrl = "";
    /**
     * 页面通用LoadingDialog
     */
    private ProgressDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvppattern);
        findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.requestData(requestUrl);
            }
        });
        tvData = findViewById(R.id.text2);
        loadingDialog = new ProgressDialog(this);
    }

    @Override
    public StudentPresenter createPresenter() {
        StudentPresenter mvpPresenter = new StudentPresenter();
        return mvpPresenter;
    }

    @Override
    public void showLoading() {
        if (loadingDialog != null) {
            loadingDialog.show();
        }
    }

    @Override
    public void dismissLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }

    @Override
    public void showSuccessData(String data) {
        StudentBean dataInfo = ParseJsonUtil.parseJSONData(data);
        tvData.setText(
            "姓名：" + dataInfo.getmName() + "\n" + "性别：" + dataInfo.getmGender() + "\n" + "年龄：" + dataInfo.getmAge());
    }

    @Override
    public void showFailureData(String data) {
        tvData.setText(data);
    }
}
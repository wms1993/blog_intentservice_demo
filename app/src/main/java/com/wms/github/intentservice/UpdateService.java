package com.wms.github.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by 王梦思 on 2017/5/26.
 */

public class UpdateService extends IntentService {

    private static final String TAG = "UpdateService";

    public UpdateService(String name) {
        super(name);
    }

    public UpdateService() {
        super("");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e("UpdateService","onHandleIntent...");
        if (intent != null) {
            String path = intent.getStringExtra("apkFilePath");
            downloadApk(path);
        }
    }

    private void downloadApk(String path) {
        Log.e("UpdateService",path);
        Log.e("UpdateService","正在下载安装包...");
        //模拟耗时操作，这里就不真的下载文件了
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //这里代码执行完成后，Service就停止了
        Log.e("UpdateService","安装包下载完成...");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate...");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy...");
    }
}

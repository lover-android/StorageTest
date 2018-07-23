package com.example.administrator.storagetest;

import android.os.Environment;
import android.os.StatFs;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.util.Log;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private TextView tv1,tv2,tv3,tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.text1);
        tv2 = (TextView)findViewById(R.id.text2);
        tv3 = (TextView)findViewById(R.id.text3);
        tv4 = (TextView)findViewById(R.id.text4);

        tv1.setText(getsizeandcount1());
        tv2.setText(getsizeandcount2());
        tv3.setText(getsizeandcount3());
        tv4.setText(getsizeandcount4());

    }

    /**
     * 获得SD卡总大小
     *
     * @return
     */
    private String getSDTotalSize() {
        //Environment.get
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long totalSize = stat.getTotalBytes();
        return Formatter.formatFileSize(MainActivity.this, totalSize);
        //return null;
    }

    /**
     * 获得sd卡剩余容量，即可用大小
     *
     * @return
     */
    private String getSDAvailableSize() {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long availableBlocks = stat.getAvailableBytes();
        return Formatter.formatFileSize(MainActivity.this, availableBlocks);
    }

    /**
     * 获得机身内存总大小
     *
     * @return
    */
    private String getRomTotalSize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long totalBlocks = stat.getTotalBytes();
        return Formatter.formatFileSize(MainActivity.this, totalBlocks);
    }

    /**
     * 获得机身可用内存
     *
     * @return
     */
    private String getRomAvailableSize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long f_frsize = stat.getBlockSizeLong();
        long f_blocks = stat.getBlockCountLong();
        long availableBlocks = stat.getFreeBytes();
        Log.i("wubotest", "f_blocks = " + f_blocks + ",    f_frsize = " + f_frsize);
        return Formatter.formatFileSize(MainActivity.this, availableBlocks);
    }

    private String getsizeandcount1() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long f_frsize = stat.getBlockSizeLong();
        long f_blocks = stat.getBlockCountLong();
        Log.i("wubotest", "getsizeandcount1 path = " + path.getPath() + ",   f_blocks = " + f_blocks + ",    f_frsize = " + f_frsize);
        return "getsizeandcount1 f_blocks = " + f_blocks + ",    f_frsize = " + f_frsize + ",  tottal = " + f_blocks * f_blocks;
    }

    private String getsizeandcount2() {
        File path = Environment.getExternalStorageDirectory();
        StatFs stat = new StatFs(path.getPath());
        long f_frsize = stat.getBlockSizeLong();
        long f_blocks = stat.getBlockCountLong();
        Log.i("wubotest", "getsizeandcount2 path = " + path.getPath() + ",   f_blocks = " + f_blocks + ",    f_frsize = " + f_frsize +
                ",  totalbytes = " + stat.getTotalBytes() + ",  availablebytes = " + stat.getAvailableBytes());
        return "getsizeandcount2 availablebytes = " + stat.getAvailableBytes();
    }

    private String getsizeandcount3() {
        File path = Environment.getRootDirectory();
        StatFs stat = new StatFs(path.getPath());
        long f_frsize = stat.getBlockSizeLong();
        long f_blocks = stat.getBlockCountLong();
        Log.i("wubotest", "getsizeandcount3 path = " + path.getPath() + ",   f_blocks = " + f_blocks + ",    f_frsize = " + f_frsize);
        return "getsizeandcount3 f_blocks = " + f_blocks + ",    f_frsize = " + f_frsize + ",  tottal = " + f_blocks * f_blocks;
    }

    private String getsizeandcount4() {
        File path = Environment.getDownloadCacheDirectory();
        StatFs stat = new StatFs(path.getPath());
        long f_frsize = stat.getBlockSizeLong();
        long f_blocks = stat.getBlockCountLong();
        Log.i("wubotest", "getsizeandcount4 path = " + path.getPath() + ",   f_blocks = " + f_blocks + ",    f_frsize = " + f_frsize);
        return "getsizeandcount4 f_blocks = " + f_blocks + ",    f_frsize = " + f_frsize + ",  tottal = " + f_blocks * f_blocks;
    }


}

package com.transcendence.greenstar.demo.pdf.act;

import android.os.Environment;
import android.text.TextUtils;

import com.transcendence.core.base.activity.AppAc;
import com.transcendence.core.global.Global;
import com.transcendence.core.utils.log.LogUtils;
import com.transcendence.greenstar.R;
import com.transcendence.greenstar.demo.pdf.utils.LoadFileModel;
import com.transcendence.greenstar.demo.pdf.utils.Md5Tool;
import com.transcendence.greenstar.demo.pdf.utils.SuperFileView2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.ResponseBody;

/**
 * @author joephone
 * @date 2023/8/4
 * @desc
 */
public class FileDisplayActivity extends AppAc {

    private SuperFileView2 mSuperFileView;
    private String filePath;
    private String pdfUrl;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_demo_pdf_file_display;
    }

    @Override
    protected void initView() {
        mSuperFileView = findViewById(R.id.pdfView);
        mSuperFileView.setOnGetFilePathListener(new SuperFileView2.OnGetFilePathListener() {
            @Override
            public void onGetFilePath(SuperFileView2 mSuperFileView2) {
                getFilePathAndShowFile(mSuperFileView2);
            }
        });

//        Intent intent = this.getIntent();
        pdfUrl = Global.PDF.url2;// getIntent().getStringExtra(Global.PUBLIC_INTENT_KEY.PDF_URL); //(String) intent.getSerializableExtra("path");

        if (!TextUtils.isEmpty(pdfUrl)) {
            LogUtils.d("文件path:" + pdfUrl);
            setFilePath(pdfUrl);
        }
        mSuperFileView.show();
    }

    private void getFilePathAndShowFile(SuperFileView2 fileView) {
        if (getFilePath().contains("http")) {//网络地址要先下载
            downLoadFromNet(getFilePath(),fileView);
        } else {
            fileView.displayFile(new File(getFilePath()));
        }
    }

    public void setFilePath(String fileUrl) {
        this.filePath = fileUrl;
    }

    private String getFilePath() {
        return filePath;
    }

    private void downLoadFromNet(final String url,final SuperFileView2 mSuperFileView2) {
        LogUtils.d("downLoadFromNet");
        //1.网络下载、存储路径、
        File cacheFile = getCacheFile(url);
        if (cacheFile.exists()) {
            if (cacheFile.length() <= 0) {
                LogUtils.d( "删除空文件！！");
                cacheFile.delete();
                return;
            }
        }


        LoadFileModel.loadPdfFile(url, new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                LogUtils.d("下载文件-->onResponse");
                boolean flag;
                InputStream is = null;
                byte[] buf = new byte[2048];
                int len = 0;
                FileOutputStream fos = null;
                try {
                    ResponseBody responseBody = response.body();
                    is = responseBody.byteStream();
                    long total = responseBody.contentLength();

                    File file1 = getCacheDir(url);
                    if (!file1.exists()) {
                        file1.mkdirs();
                        LogUtils.d("创建缓存目录： " + file1.toString());
                    }


                    //fileN : /storage/emulated/0/pdf/kauibao20170821040512.pdf
                    File fileN = getCacheFile(url);//new File(getCacheDir(url), getFileName(url))

                    LogUtils.d("创建缓存文件： " + fileN.toString());
                    if (!fileN.exists()) {
                        boolean mkdir = fileN.createNewFile();
                    }
                    fos = new FileOutputStream(fileN);
                    long sum = 0;
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                        sum += len;
                        int progress = (int) (sum * 1.0f / total * 100);
//                        LogUtils.d("写入缓存文件" + fileN.getName() + "进度: " + progress);
                    }
                    fos.flush();
                    LogUtils.d("文件下载成功,准备展示文件。");
                    //2.ACache记录文件的有效期
                    mSuperFileView2.displayFile(fileN);
                } catch (Exception e) {
                    LogUtils.d("文件下载异常 = " + e.toString());
                } finally {
                    try {
                        if (is != null)
                            is.close();
                    } catch (IOException e) {
                    }
                    try {
                        if (fos != null)
                            fos.close();
                    } catch (IOException e) {
                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                LogUtils.d("文件下载失败");
                File file = getCacheFile(url);
                if (!file.exists()) {
                    LogUtils.d("删除下载失败文件");
                    file.delete();
                }
            }
        });


    }

    /***
     * 获取缓存目录
     *
     * @param url
     * @return
     */
    private File getCacheDir(String url) {
        return new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/007/");
    }
    /***
     * 绝对路径获取缓存文件
     *
     * @param url
     * @return
     */
    private File getCacheFile(String url) {
        File cacheFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/007/"
                + getFileName(url));
        LogUtils.d( "缓存文件 = " + cacheFile.toString());
        return cacheFile;
    }

    /***
     * 根据链接获取文件名（带类型的），具有唯一性
     *
     * @param url
     * @return
     */
    private String getFileName(String url) {
        String fileName = Md5Tool.hashKey(url) + "." + getFileType(url);
        return fileName;
    }

    /***
     * 获取文件类型
     *
     * @param paramString
     * @return
     */
    private String getFileType(String paramString) {
        String str = "";

        if (TextUtils.isEmpty(paramString)) {
            LogUtils.d("paramString---->null");
            return str;
        }
        LogUtils.d("paramString:"+paramString);
        int i = paramString.lastIndexOf('.');
        if (i <= -1) {
            LogUtils.d("i <= -1");
            return str;
        }


        str = paramString.substring(i + 1);
        LogUtils.d("paramString.substring(i + 1)------>"+str);
        return str;
    }
}

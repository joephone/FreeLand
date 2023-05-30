package com.transcendence.greenstar.demo.appinfo.mmkv;

import com.tencent.mmkv.MMKV;
import com.transcendence.greenstar.demo.appinfo.config.KeyConstants;

/**
 * @author joephone
 * @date 2023/4/27
 * @desc
 */
public class GSMMkvHelper {

    private static MMKV mmkv;

    private GSMMkvHelper(){
        mmkv = MMKV.defaultMMKV();
    }

    public static GSMMkvHelper getInstance() {
        return MMkvHolder.INSTANCE;
    }



    private static class MMkvHolder {
        private static final GSMMkvHelper INSTANCE = new GSMMkvHelper();
    }

    public void setAppSort(int appSort){
        mmkv.encode(KeyConstants.KEY_APP_SORT,appSort);
    }

    public int getAppSort(){
        return mmkv.decodeInt(KeyConstants.KEY_APP_SORT,0);
    }
    

}

package com.transcendence.core.utils.mmkv;

import com.tencent.mmkv.MMKV;

/**
 * @author joephone
 * @date 2023/4/27
 * @desc
 */
public class MMkvHelper {

    private static MMKV mmkv;

    private MMkvHelper(){
        mmkv = MMKV.defaultMMKV();
    }

    public static MMkvHelper getInstance() {
        return MMkvHolder.INSTANCE;
    }



    private static class MMkvHolder {
        private static final MMkvHelper INSTANCE = new MMkvHelper();
    }




}

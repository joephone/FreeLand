package com.transcendence.core.base.global;

import com.transcendence.core.R;

/**
 * @author joephone
 * @date 2023/5/23
 * @desc
 */
public class Global {

    public static final String TAG = "Freeland";

    public static final String BUGLY_ID = "4b1e18351f";
    public static final String BUGLY_KEY = "41682c5c-d8d9-4577-b949-c268ad44c023";

    public static int[] mBeautyIds = new int[]{
            R.drawable.beauty01,
            R.drawable.beauty02,
            R.drawable.beauty03,
            R.drawable.beauty04,
            R.drawable.beauty05,
            R.drawable.beauty06,
            R.drawable.beauty07,
            R.drawable.beauty08,
            R.drawable.beauty09,
            R.drawable.beauty10,};


    public final class SP_KEY {
        public static final String APP_FIRST_START = "appFirstStart";
        public static final String APP_BADGE = "appBadge";
    }

    public final class INTENT_KEY {
        public static final String BIG_IMAGE = "bigImage";
    }

    public static final class PDF {
        public static String url = "http://hotelpodlipou.sk/uploads/files/sample.pdf";
        public static String url2 = "http://livedoor.4.blogimg.jp/nikoneko55-hogehoge/imgs/9/9/9937d147.gif";
    }

    public final class MAP {
        //比例尺 100
        public static final  int SMALL_ZOOM =18;
        public static final  int MID_ZOOM =13;
        public static final  int BIG_ZOOM =15;
        public static final  String DEFAULT_LAT ="defaultLan";
        public static final  String DEFAULT_LON ="defaultLon";
    }


    public static int standardZoom(){
        return MAP.SMALL_ZOOM;
    }
}

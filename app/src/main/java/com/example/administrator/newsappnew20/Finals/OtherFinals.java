package com.example.administrator.newsappnew20.Finals;

import com.example.administrator.newsappnew20.R;

import java.util.ArrayList;

/**
 * Created by pfsu on 2017/6/8/008.
 */

public class OtherFinals {
    public static  final int resArray [] = {R.mipmap.goldcat,R.mipmap.tw,R.mipmap.finance,R.mipmap.tachnology};
    public static  final String newTitleArray[]={"淘金猫头条","汤唯短发利落西装干练女神范","CNN财经要闻","苹果在店里引入机器人，给你修手机"};
    public static  final String  ALLNEWS =OtherFinals.class.getSimpleName();
    public static  final String GOLD_CAT ="http://www.taojinmao.com.cn/";
    public static  final String ENTERTAINMENT ="http://www.huabian.com/tushuobagua/2017/0608/45945.html";
    public static  final String FINANCE ="http://money.cnn.com/news/";
    public static  final String TECHNOLOGY ="http://www.qdaily.com/articles/41747.html";
    public static ArrayList<String> uriList= new ArrayList<>();
    public static  final ArrayList<String> addNews(){
        uriList.add(OtherFinals.GOLD_CAT);
        uriList.add(OtherFinals.ENTERTAINMENT);
        uriList.add(OtherFinals.FINANCE);
        uriList.add(OtherFinals.TECHNOLOGY);
        return uriList;
    }
}

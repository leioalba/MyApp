package cn.edu.gdpt.androiddemo.utils;

import android.os.Handler;

import com.google.gson.Gson;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkhttpUntil {
    public static OkHttpClient okHttpClient = new OkHttpClient();
    public static Handler handler = new Handler();

    /*  public static void synGetrequest(String url,Class myclass,NetworkListining listining) throws Exception {
          new Thread(new Runnable() {
              @Override
              public void run() {
                  try {
                      listining.BackResultSuccess(toObject(myclass, responseTostring(Toresponse(Tocall(Torequest(url))))));
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
          }).start();


      }*/
    public static <T> void enqueueGetrequest(final String url, final Class<T> myclass, final NetworkListining<T> listining) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Tocall(Torequest(url)).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, final IOException e) {

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    listining.BackResultFail(e);
                                }
                            });
                        }

                        @Override
                        public void onResponse(Call call, final Response response) throws IOException {

                            final String string = response.body().string();
                            handler.post(new Runnable() {
                                @Override
                                public void run() {

                                  try{
                                      listining.BackResultSuccess(toObject(myclass, string), response.code());
                                  }catch (Exception e){
                                      listining.BackResultFail(e);
                                  }finally {
                                      if(string!=null){
                                          listining.tostring(string);
                                      }else{
                                          listining.tostring("404！！！！");
                                      }

                                  }

                                }
                            });

                        }
                    });


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }



    public static <T> void enqueueGetrequest(final String url, final TostringNetworkListining listining) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Tocall(Torequest(url)).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, final IOException e) {

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    listining.BackResultFail(e);
                                }
                            });
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                           if(response.code()==200){
                               final String string = response.body().string();
                               handler.post(new Runnable() {
                                   @Override
                                   public void run() {
                                       listining.tostring(string);
                                   }
                               });
                           }

                        }
                    });


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public static <T> T toObject(Class<T> myclass, String string) {
        return new Gson().fromJson(string, myclass);
    }

    public static String responseTostring(Response toresponse) throws IOException {
        String string = toresponse.body().string();
        return string;
    }

    public static Response Toresponse(Call tocall) throws IOException {
        return tocall.execute();
    }

    public static Call Tocall(Request torequest) {
        Call call = okHttpClient.newCall(torequest);

        return call;
    }

    public static Request Torequest(String url) {
        return new Request.Builder().url(url).get().build();
    }



    public static String converterToFirstSpell(String chines) {
        StringBuffer pinyinName = new StringBuffer();
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                try {
                    // 取得当前汉字的所有全拼
                    String[] strs = PinyinHelper.toHanyuPinyinStringArray(
                            nameChar[i], defaultFormat);
                    if (strs != null) {
                        for (int j = 0; j < strs.length; j++) {
                            // 取首字母
                            pinyinName.append(strs[j].charAt(0));
                            if (j != strs.length - 1) {
                                pinyinName.append(",");
                            }
                        }
                    }
                    // else {
                    // pinyinName.append(nameChar[i]);
                    // }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName.append(nameChar[i]);
            }
            pinyinName.append(" ");
        }
        // return pinyinName.toString();
        return parseTheChineseByObject(discountTheChinese(pinyinName.toString()));
    }
    private static String parseTheChineseByObject(
            List<Map<String, Integer>> list) {
        Map<String, Integer> first = null; // 用于统计每一次,集合组合数据
        // 遍历每一组集合
        for (int i = 0; i < list.size(); i++) {
            // 每一组集合与上一次组合的Map
            Map<String, Integer> temp = new Hashtable<String, Integer>();
            // 第一次循环，first为空
            if (first != null) {
                // 取出上次组合与此次集合的字符，并保存
                for (String s : first.keySet()) {
                    for (String s1 : list.get(i).keySet()) {
                        String str = s + s1;
                        temp.put(str, 1);
                    }
                }
                // 清理上一次组合数据
                if (temp != null && temp.size() > 0) {
                    first.clear();
                }
            } else {
                for (String s : list.get(i).keySet()) {
                    String str = s;
                    temp.put(str, 1);
                }
            }
            // 保存组合数据以便下次循环使用
            if (temp != null && temp.size() > 0) {
                first = temp;
            }
        }
        String returnStr = "";
        if (first != null) {
            // 遍历取出组合字符串
            for (String str : first.keySet()) {
                returnStr += (str + ",");
            }
        }
        if (returnStr.length() > 0) {
            returnStr = returnStr.substring(0, returnStr.length() - 1);
        }
        return returnStr;
    }
    private static List<Map<String, Integer>> discountTheChinese(String theStr) {
        // 去除重复拼音后的拼音列表
        List<Map<String, Integer>> mapList = new ArrayList<Map<String, Integer>>();
        // 用于处理每个字的多音字，去掉重复
        Map<String, Integer> onlyOne = null;
        String[] firsts = theStr.split(" ");
        // 读出每个汉字的拼音
        for (String str : firsts) {
            onlyOne = new Hashtable<String, Integer>();
            String[] china = str.split(",");
            // 多音字处理
            for (String s : china) {
                Integer count = onlyOne.get(s);
                if (count == null) {
                    onlyOne.put(s, new Integer(1));
                } else {
                    onlyOne.remove(s);
                    count++;
                    onlyOne.put(s, count);
                }
            }
            mapList.add(onlyOne);
        }
        return mapList;
    }


}

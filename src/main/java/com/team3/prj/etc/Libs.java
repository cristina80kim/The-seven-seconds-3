package com.team3.prj.etc;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class Libs {

    //================================================
    // 1. DB 관련
    //================================================

    //================================================
    // 2. File 관련
    //================================================

    private static int compareToIgnoreCase(String comp1, String comp2) {
       return comp1 != null && comp2 != null
          ? comp1.compareToIgnoreCase(comp2) : 0;
    }

    // 기능: path에서 확장자를 응답한다.
    // 테스트코드 및 결과
    //  String str;
    //  str = null;
    //  System.out.println("1 :" + Libs.getFileExt(str)); // ""
    //  str = "";
    //  System.out.println("2 :" + Libs.getFileExt(str)); // ""
    //  str = "123";
    //  System.out.println("3 :" + Libs.getFileExt(str)); // ""
    //  str = "1234.";
    //  System.out.println("4 :" + Libs.getFileExt(str)); // "."
    //  str = "1234.56";
    //  System.out.println("5 :" + Libs.getFileExt(str)); // ".56"
    //  str = "1234.56/";
    //  System.out.println("6 :" + Libs.getFileExt(str)); // ".56"
    //  str = "1234.56/7";
    //  System.out.println("7 :" + Libs.getFileExt(str)); // ""
    //  str = "1234.56/78.";
    //  System.out.println("8 :" + Libs.getFileExt(str)); // "."
    //  str = "1234.56/78.9";
    //  System.out.println("9 :" + Libs.getFileExt(str)); // ".9"
    //  str = "C:";
    //  System.out.println("A :" + Libs.getFileExt(str)); // ""
    //  str = "C:123";
    //  System.out.println("B :" + Libs.getFileExt(str)); // ""
    //  str = "C:123.";
    //  System.out.println("C :" + Libs.getFileExt(str)); // "."
    //  str = "C:123.45";
    //  System.out.println("D :" + Libs.getFileExt(str)); // ".45"
    //  str = "C:123.45/5";
    //  System.out.println("E :" + Libs.getFileExt(str)); // ""
    //  str = "C:123.45/5.6";
    //  System.out.println("F :" + Libs.getFileExt(str)); // ".6"
    public static String getFileExt(String path) {
       String result = "";

       if(path != null && path.length() >= 1) {
          File fi = new File(path);
          String fileName = fi.getName();
          int idx = fileName.lastIndexOf(".");

          result = idx >= 0 ? fileName.substring(idx) : "";
       }

       return result;
    }


    //================================================
    // 3. Date/Time 관련
    //================================================
    static SimpleDateFormat fmYyyyMmDd = new SimpleDateFormat("yyyy-MM-dd");
    static SimpleDateFormat fmYyyyMmDd8 = new SimpleDateFormat("yyyyMMdd");
    static SimpleDateFormat fmAll = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat fmAll15 = new SimpleDateFormat("yyyyMMdd HHmmss");

    //--------------------------------------
    // 기능: 1. "yyyy-MM-dd HH:mm:ss" >> java.util.Date
    public static Date strToDate(String date) throws ParseException {
       Date result = null;

       if(date != null) {
          date = date.trim();
          SimpleDateFormat fmt = null;

          switch(date.length()) {
          case 8: fmt = fmYyyyMmDd8; break;
          case 10: fmt = fmYyyyMmDd; break;
          case 15: fmt = fmAll15; break;
          case 19: fmt = fmAll; break;
          }

          if(fmt != null) {
             result = fmt.parse(date);
          }
       }

       return result;
    }

    // 기능: java.util.Date >> "yyyy-MM-dd HH:mm:ss"
    public static String dateToStr(Date date) {
       return date != null ? Libs.fmAll.format(date) : "";
    }

    // 기능: java.util.Date >> "yyyy-MM-dd"
    public static String dateToStr8(Date date){
       return date != null ? Libs.fmYyyyMmDd.format(date) : "";
    }

    //--------------------------------------
    // 기능: 2. "yyyy-MM-dd" >> java.sql.Date
    public static java.sql.Date strToSqlDate(String date) throws ParseException {
       return date != null && date.trim().length() != 0
             ? dateToSqlDate(strToDate(date)) : null;
    }

    // 기능: java.sql.Date >> "yyyy-MM-dd"
    public static String sqlDateToStr(java.sql.Date date) {
       return date != null ? dateToStr(sqlDateToDate(date)) : null;
    }

    //--------------------------------------
    // 기능: 3. java.util.Date >> java.sql.Date
    public static java.sql.Date dateToSqlDate(Date date) {
       return date != null ? new java.sql.Date(date.getTime()) : null;
    }

    // 기능: java.sql.Date >> java.util.Date
    public static Date sqlDateToDate(java.sql.Date date) {
       return date != null ? new Date(date.getTime()) : null;
    }

    //--------------------------------------
    // 기능: 4. java.sql.Date >> java.util.Date
    public static java.sql.Timestamp strToTimestamp(String date) throws ParseException {
       return date != null && date.trim().length() != 0
             ? new java.sql.Timestamp(strToDate(date).getTime()) : null;
    }

    public static String timestampToStr(java.sql.Timestamp date){
       return date != null ? dateToStr(new Date(date.getTime())) : "";
    }

    public static String timestampToStr8(java.sql.Timestamp date){
       return date != null ? dateToStr8(new Date(date.getTime())) : "";
    }

    public static String dateTimeToStr(Date date) {
       return dateToStr(date);
    }


    //================================================
    // 4. 변환 관련
    //================================================

    public static int strToInt(String str, int defValue) {
       if(str == null || str.trim().length() == 0) {
          return defValue;
       }
       else {
          return Integer.valueOf(str.trim());
       }
    }

    public static long strToLong(String str, long defValue) {
       if(str == null || str.trim().length() == 0) {
          return defValue;
       }
       else {
          return Long.valueOf(str.trim());
       }
    }


    //================================================
    // 5. 문자열 관련
    //================================================

    // 기능: 문자열이 null 또는 ""인 경우 true를 응답한다.
    public static boolean isEmpty(String str) {
       return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return str != null && str.length() != 0;
    }

    // 기능: 문자열이 null 또는 trim()후 "" 인 경우 true를 응답한다.
    public static boolean isEmptyExt(String str) {
       return str == null || str.trim().length() == 0;
    }

    public static boolean isNotEmptyExt(String str) {
       return str != null && str.trim().length() != 0;
    }

    // 기능: 문자열이 null 또는 ""인 경우 defVal를 그렇지 안흔 경우 str를 응답한다.
    public static String nvl(String str, String defVal) {
       return str == null || str.length() == 0 ? defVal : str;
    }

    public static Integer nvl(Integer i, Integer defVal) {
        return i == null ? defVal : i;
    }

    public static Long nvl(Long l, Long defVal) {
        return l == null ? defVal : l;
    }

    // 기능: 문자열이 null이면 ""를 그렇지 않으면 str를 응
    public static String toString(String str) {
       return str == null ? "" : str;
    }

    // 기능: 권한 정의 문자열을 HashMap에 추가한다.
    public static void addAuthorizations(HashMap<String, String> hm, String[][] authorizations) {
        for(String[] item : authorizations) {
            if(hm.containsValue(item[0])) {
                System.out.println("중복 적용 권한: " + item[0]);
            }
            else {
                hm.put(item[0], item[1]);
            }
        }
    }


    //================================================
    // 6. JSON 관련
    //================================================

    public static JSONObject makeJosnValue(Object key, Object value) {
        JSONObject result = new JSONObject();
        result.put(key, value);
        return result;
    }

    public static JSONObject makeJosnValue(Object[][]arr) {
        JSONObject result = new JSONObject();

        if(arr != null) {
            for(Object[] objs : arr) {
                if(objs != null && objs[0] != null) {
                    result.put(objs[0], objs[1]);
                }
            }
        }

        return result;
    }

    // 기능: 결과를 TOAST grid에서 사용할 수 있도록 JSON 결과 형태로 변환하여 응답한다.
    public static JSONObject makeToastJsonResult(Object param) {
        JSONObject contents = Libs.makeJosnValue("contents", param);
        JSONObject jsonResult = new JSONObject();
        jsonResult.put("result", param != null);
        jsonResult.put("data", contents);
        return jsonResult;
    }

    public static JSONObject makeToastJsonResult(Object param, String page, String perPage, int count) {
        int page2 = Integer.valueOf(Libs.nvl(page, "1"));
        JSONObject data = new JSONObject();
        data.put("contents", param);

        JSONObject pagination = new JSONObject();
        pagination.put("page", String.valueOf(page2));
        pagination.put("totalCount", String.valueOf(count));
        data.put("pagination", pagination);

        JSONObject jsonResult = new JSONObject();
        jsonResult.put("result", true); // param != null);
        jsonResult.put("data", data);
        return jsonResult;
    }


    //================================================
    // 7. 기타 관련
    //================================================

    // 기능: HttpSession을 응답한다.
    public static HttpSession getSession() {
        ServletRequestAttributes servletRequestAttribute
            = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);
        return httpSession;
    }

    // 기능: HttpSession에 키와 값을 저장한다.
    public static void setSessionAttribute(String key, String value) {
        Libs.getSession().setAttribute(key, value);
    }

    // 기능: 권한 등록 HashMap 정보를 출력한다.
    public static void showAuthInfos(HashMap<String, String> hmAuthos) {
        if(hmAuthos != null) {
            System.out.println("==============================");
            for(String key : hmAuthos.keySet()){
                String value = hmAuthos.get(key);
                System.out.println(key + " : " + value);
            }
            System.out.println("==============================");
        }
    }

}

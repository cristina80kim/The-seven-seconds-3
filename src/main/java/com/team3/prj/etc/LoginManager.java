package com.team3.prj.etc;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.team3.prj.vo.UserInstanceVO;

public class LoginManager {
   private static final boolean isTestMode = false;
   private static final String testSessionId = ">>> test_session_id <<<";
   public static HashMap<String, UserInstanceVO> hmUsers = new HashMap<>();

   // static 초기화 블럭
   static {
      if(isTestMode) {
         // 임시로 Manager를 만들어 등록함.
         synchronized (hmUsers) {
            hmUsers.put(testSessionId, TempUserInstance.createTempUser());
         }
      }
   }

   public static UserInstanceVO getUserInfo() {
       return getUserInfo(Libs.getSession().getId());
    }

   public static UserInstanceVO getUserInfo(HttpServletRequest request) {
      return getUserInfo(request.getSession().getId());
   }

   // 기능: sessionId에 대한 사용자 정보를 응답한다. 단, 등록안 된 sessionId일 경우 bull를 앙답한다.
   public static UserInstanceVO getUserInfo(String sessionId) {
      UserInstanceVO result = null;

      if(hmUsers.size() >= 1) {
         if(LoginManager.isTestMode) {
            sessionId = LoginManager.testSessionId;
         }

         synchronized (hmUsers) {
            result = hmUsers.get(sessionId); // 없으면 null 응답
         }
      }

      return result;
   }

   public static boolean setUserInfo(String sessionId, UserInstanceVO newVo) {
      boolean result = false;

      if (Libs.isNotEmptyExt(sessionId) && newVo != null) {
         synchronized (hmUsers) {
            UserInstanceVO userVo = hmUsers.get(sessionId);

            if (userVo != null) {
               hmUsers.remove(sessionId);
            }

            hmUsers.put(sessionId, newVo);
         }
      }
      System.out.println("사용자 수: " + hmUsers.size());
      return result;
   }

   // TODO: DB에서 관리자 ID릏 읽도록 구현해야 함.
   public static UserInstanceVO getManagerInfo() {
       return TempUserInstance.createTempManager();
   }

   // 기능: sessionId에 대한 Login 사용자 ID를 응답한다.
   public static String getUserId() {
       String result = "";
       UserInstanceVO vo = getUserInfo();

       if(vo != null) {
           result = vo.getId();
       }

       return result;
   }

   // 기능: sessionId에 대한 Login 여부를 검색하여 login한 user이면 그의 role를 응답
   public static String getUserRole() {
       String result = Common.strRoleAnonymous;

       UserInstanceVO vo = getUserInfo();

       if(vo != null) {
           result = vo.getRole();
       }

       return result;
   }

}

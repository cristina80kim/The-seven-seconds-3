package com.team3.prj.etc;

import java.util.Arrays;
import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.team3.prj.controller.EtcController;
import com.team3.prj.controller.FaqController;
import com.team3.prj.controller.MainController;
import com.team3.prj.controller.MypageRsrvController;
import com.team3.prj.controller.NoticeController;
import com.team3.prj.controller.PaymentController;
import com.team3.prj.controller.QnaController;
import com.team3.prj.controller.RoomDtlController;
import com.team3.prj.controller.RoomListOpenController;
import com.team3.prj.controller.RoomMstController;
import com.team3.prj.controller.RsrvListController;
import com.team3.prj.controller.StayListController;
import com.team3.prj.controller.TestController;
import com.team3.prj.controller.UploadTestContorller;
import com.team3.prj.controller.UserController;

@Aspect
@Component
public class CheckPermission {

    private static String className = "CheckPermission.";
    private static HashMap<String, String> hmAuthorizations = new HashMap<>();
    private static int cnt = 0;

    static { // private static void collectAuthorizations() {
        System.out.println(className + "cnt = " + ++cnt);

        // 01
        EtcController etcController = new EtcController();
        Libs.addAuthorizations(hmAuthorizations, etcController.getAuthorizations());

        // 02
        FaqController faqController = new FaqController();
        Libs.addAuthorizations(hmAuthorizations, faqController.getAuthorizations());

        // 03
        MainController mainController = new MainController();
        Libs.addAuthorizations(hmAuthorizations, mainController.getAuthorizations());

        // 04
        MypageRsrvController mypageRsrvController = new MypageRsrvController();
        Libs.addAuthorizations(hmAuthorizations, mypageRsrvController.getAuthorizations());

        // 05
        NoticeController noticeController = new NoticeController();
        Libs.addAuthorizations(hmAuthorizations, noticeController.getAuthorizations());

        // 06
        PaymentController paymentController = new PaymentController();
        Libs.addAuthorizations(hmAuthorizations, paymentController.getAuthorizations());

        // 07
        QnaController qnaController = new QnaController();
        Libs.addAuthorizations(hmAuthorizations, qnaController.getAuthorizations());

        // 08
        RoomDtlController roomDtlController = new RoomDtlController();
        Libs.addAuthorizations(hmAuthorizations, roomDtlController.getAuthorizations());

        // 09
        RoomListOpenController roomListOpenController = new RoomListOpenController();
        Libs.addAuthorizations(hmAuthorizations, roomListOpenController.getAuthorizations());

        // 10
        RoomMstController roomMstController = new RoomMstController();
        Libs.addAuthorizations(hmAuthorizations, roomMstController.getAuthorizations());

        // 11
        RsrvListController rsrvListController = new RsrvListController();
        Libs.addAuthorizations(hmAuthorizations, rsrvListController.getAuthorizations());

        // 12
        StayListController stayListController = new StayListController();
        Libs.addAuthorizations(hmAuthorizations, stayListController.getAuthorizations());

        // 13
        TestController testController = new TestController();
        Libs.addAuthorizations(hmAuthorizations, testController.getAuthorizations());

        // 14
        UploadTestContorller uploadTestContorller = new UploadTestContorller();
        Libs.addAuthorizations(hmAuthorizations, uploadTestContorller.getAuthorizations());

        // 15
        UserController userController = new UserController();
        Libs.addAuthorizations(hmAuthorizations, userController.getAuthorizations());

        Libs.showAuthInfos(hmAuthorizations);
    }

    // AOP(Aspect Oriented Programming): https://velog.io/@fortice/Spring-AOP

    // [AOP 용어]
    // - Aspect:    여러 객체에 공통으로 적용되는 기능이다. ex) 트랜잭션, 보안
    // - Advice:    언제 공통 관심 기능을 핵심 로직에 적용할 지를 정의하고 있다. ex) 메서드 호출 전, 후
    // - Joinpoint: Advice를 적용 가능한 지점을 의미한다. 메서드 호출, 필드 값 변경 등이 있으며, 프록시의 경우 메서드 호출이다.
    // - Pointcut:  Joinpoint의 부분 집합으로 실제 Advice가 적용되는 Joinpoint를 나타낸다. 스프링에서 정규 표현식, AspectJ 문법으로 정의 가능하다.
    // - Weaving:   Advice를 핵심 로직 코드에 적용하는 것을 Weaving이라 한다.

    // [메서드 호출 시 Advice 종류]
    // - Before Advice: 대상 객체의 메서드 호출 전에 공통 기능을 실행한다.
    // - After Returning Advice: 대상 객체의 메서드가 익셉션 없이 실행된 이후에 공통 기능을 실행한다.
    // - After Throwing Advice: 대상 객체의 메서드를 실행하는 도중 익셉션이 발생한 경우에
    //   공통 기능을 실행한다.
    // - After Advice: 익셉션 발생 여부에 상관 없이 대상 객체의 메서드 실행 후 공통 기능을 실행한다.
    //   (try-catch-finally의 finally와 비슷)
    // - Around Advice: 대상 객체의 메서드 실행 전, 후 또는 익셉션 발생 시점에 공통 기능을
    //   실행하는데 사용된다.

    // [실행 순서]
    //  1. CheckPermission.around(): begin
    //  2.   CheckPermission.beforeMethod(): begin
    //  3.   CheckPermission.beforeMethod(): end
    //  4.   QnaController.frmSelectAll()
    //  5.   CheckPermission.afterReturningMethod(): begin
    //  6.   CheckPermission.afterReturningMethod(): end
    //  7. CheckPermission.around(): end

    // 기능: @GetMapping 설정된 클래스/메소드 만 AspectJ를 적용함.
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMapping() {
        System.out.println(className + ".getMapping(): begin");
        System.out.println(className + ".getMapping(): end");
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping() {
        System.out.println(className + ".postMapping(): begin");
        System.out.println(className + ".postMapping(): end");
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping() {
        System.out.println(className + ".requestMapping(): begin");
        System.out.println(className + ".requestMapping(): end");
    }

    // 기능: 위의 GetMapping() 이 실행되기 전에 실행하도록 설정함.
    @Before("getMapping()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println(className + ".beforeMethod(): begin");
        System.out.println(className + ".beforeMethod(): end");
    }

    @Around("getMapping()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(className + ".around(): begin");
        Object result = null;

        try {
            String className = joinPoint.getTarget().getClass().getSimpleName();
            String sigName = joinPoint.getSignature().getName();
            String methodName = className + "." + sigName;
            String args = Arrays.toString(joinPoint.getArgs());

            //result = joinPoint.proceed();

            // TOOD: (김용수)
            System.out.println("Name: " + methodName + ", args: " + args);

            if(hmAuthorizations.containsKey(methodName)) {
                String methodAuth = hmAuthorizations.get(methodName);
                String userAuth = "U";

                if(methodAuth.indexOf(userAuth) >= 0) {
                    result = joinPoint.proceed();
                }
                else {
                    System.out.println(methodName + "(): 부족한 사용자 권한"
                            + ", 정의권한: " + methodAuth + ", 사용자권한: " + userAuth + ", 실행안됨.");
                }
            }
            else {
                System.out.println(methodName + "(): 미정의 권한 Method. 실행안됨.");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(className + ".around(): end");
        return result;
    }

    @AfterReturning(pointcut = "getMapping()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        System.out.println(className + ".afterReturningMethod(): begin");
        System.out.println(className + ".afterReturningMethod(): end");
    }
}

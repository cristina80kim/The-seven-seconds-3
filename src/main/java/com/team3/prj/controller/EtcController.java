package com.team3.prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.etc.Common;
import com.team3.prj.service.EtcService;
import com.team3.prj.vo.NoteVO;

@Controller
//@RequestMapping(value="/etc", method={RequestMethod.GET, RequestMethod.POST})
@RequestMapping(value="/etc")
public class EtcController {

    private final String className = "EtcController";
    private final String className2 = className + ".";

    public String[][] getAuthorizations() {
        return new String[][] {
            {className2 + "frmNote", Common.strRoleAMUY},
            {className2 + "getTermsOfService", Common.strRoleAMUY},
            {className2 + "getPrivacyPolicy", Common.strRoleAMUY},
            {className2 + "select", Common.strRoleAMUY},
            {className2 + "insert", Common.strRoleAMUY},
            {className2 + "update", Common.strRoleAMUY},
            {className2 + "delete", Common.strRoleAMUY}
        };
    }

    @Autowired
    EtcService service;

    // http://localhost:8081/etc/frmNote
    @RequestMapping("/frmNote")
    public String frmNote() {
        System.out.println(className + ".frmNote()");
        return "frmNote";   // frmNote.html
    }

    // 기능: "이용약관" 조회
    // http://localhost:8081/etc/getTermsOfService
    @RequestMapping("/getTermsOfService")
    public @ResponseBody NoteVO getTermsOfService() {
        System.out.println(className + ".getTermsOfService()");
        NoteVO result = service.select(NoteVO.createTermsOfService());
        System.out.println("출력: " + result);
        return result;
    }

    // 기능: "개인정보보호정책" 조회
    // http://localhost:8081/etc/getPrivacyPolicy
    @RequestMapping("/getPrivacyPolicy")
    public @ResponseBody NoteVO getPrivacyPolicy() {
        System.out.println(className + ".getPrivacyPolicy()");
        NoteVO result = service.select(NoteVO.createPrivacyPolicy());
        System.out.println("출력: " + result);
        return result;
    }

    // http://localhost:8081/etc/select
    @RequestMapping("/select")
    public @ResponseBody NoteVO select(@RequestBody NoteVO vo) {
        System.out.println(className + ".select()");
        System.out.println("입력: " + vo);
        NoteVO result = service.select(vo);
        System.out.println("출력: " + result);
        return result;
    }

    // http://localhost:8081/etc/insert
    @RequestMapping("/insert")
    public @ResponseBody String insert(@RequestBody NoteVO vo) {
        System.out.println(className + ".insert()");
        System.out.println("엽력: " + vo);
        String result = service.insert(vo);
        System.out.println("출력: " + result);
        return result;
    }

    // http://localhost:8081/etc/update
    @RequestMapping("/update")
    public @ResponseBody int update(@RequestBody NoteVO vo) {
        System.out.println(className + ".update()");
        System.out.println("엽력: " + vo);
        int result = service.update(vo);
        System.out.println("출력: " + result);
        return result;
    }

    // http://localhost:8081/etc/delete
    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody NoteVO vo) {
        System.out.println(className + ".delete()");
        System.out.println("엽력: " + vo);
        int result = service.delete(vo);
        System.out.println("출력: " + result);
        return result;
    }
}

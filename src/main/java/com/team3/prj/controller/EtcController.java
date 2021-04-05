package com.team3.prj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.service.EtcService;
import com.team3.prj.vo.NoteVO;

@Controller
//@RequestMapping(value="/etc", method={RequestMethod.GET, RequestMethod.POST})
@RequestMapping(value="/etc")
public class EtcController {

    private final String className = "EtcController";
    
    @Autowired
    EtcService service;

    // http://localhost:8081/etc/frmNote
    @RequestMapping("/frmNote")
    public String frmNote() {
        System.out.println(className + ".frmNote()");
        return "frmNote";   // frmNote.html
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
        System.out.println(vo);
        String result = service.insert(vo);
        return result;
    }

    // http://localhost:8081/etc/update
    @RequestMapping("/update")
    public @ResponseBody int update(@RequestBody NoteVO vo) {
        System.out.println(className + ".update()");
        System.out.println(vo);
        return service.update(vo);
    }
    
    // http://localhost:8081/etc/delete
    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody NoteVO vo) {
        System.out.println(className + ".delete()");
        System.out.println(vo);
        return service.delete(vo);
    }
}

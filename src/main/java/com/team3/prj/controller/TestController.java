package com.team3.prj.controller;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.team3.prj.etc.Common;
import com.team3.prj.etc.Libs;
import com.team3.prj.service.QnaService;
import com.team3.prj.vo.AjaxTestVO;
import com.team3.prj.vo.EmpVO;
import com.team3.prj.vo.QnaSearchVO;
import com.team3.prj.vo.QnaVO;

// 1st committing

@Controller
@RequestMapping("/test")
public class TestController {
    
    private final String className = "TestController";
    private final String className2 = className + ".";
    
    @Autowired
    QnaService qnaSrvice;

    public String[][] getAuthorizations() {
        return new String[][] {
            {className2 + "jsonTest", Common.strRoleAMUY},
            {className2 + "getData4Toast", Common.strRoleAUY},
        };
    }
    
    // http://localhost:8081/test/json
    @GetMapping("/jsonTest")
    @ResponseBody
    public EmpVO jsonTest() {
        System.out.println(className + ".jsonTest()");
        return new EmpVO();
    }

    // http://localhost:8081/test/getData4Toast
    @GetMapping("/getData4Toast")
    public @ResponseBody String getData4Toast() {
        System.out.println(className + ".getData4Toast()");

        String jsonData = "{"
                + "    \"result\": true,\r\n"
                + "    \"data\": {\r\n"
                + "        \"contents\": [\r\n"
                + "            {\r\n"
                + "                \"name\": \"yskim\",\r\n"
                + "                \"value\": \"99세\"\r\n"
                + "            },\r\n"
                + "            {\r\n"
                + "                \"name\": \"한가인\",\r\n"
                + "                \"value\": \"20세\"\r\n"
                + "            }\r\n"
                + "        ]\r\n"
                + "    }"
                + "}";

        return jsonData;
    }
    
    // http://localhost:8081/test/getData4Toast2
    @GetMapping("/getData4Toast2")
    public @ResponseBody Object getData4Toast2() {
        System.out.println(className + ".getData4Toast2()");
        
        // String[][] str = new String[][] {{"111", "112", "113"}, {"121", "122", "123"}};
        
        // [결과]
        // {"result": true, "data": { "contents": [ { "name": "yskim", "value": "99세" }, { "name": "한가인", "value": "20세" } ] }}
        // {"result": true, "data": { "contents": [ { "name": "yskim", "value": "10세" }, { "name": "한가인2", "value": "20세" } ] }}
        
        JSONObject jsonData = new JSONObject();
        
        jsonData.put("result", true);
        jsonData.put("data",
                Libs.makeJosnValue("contents",
                        new Object[] { 
                                Libs.makeJosnValue(new Object[][] { { "name", "yskim" }, { "value", null } }),
                                Libs.makeJosnValue(new Object[][] { { "name", "한가인2" }, { "value", "20세" } }), 
                                Libs.makeJosnValue(new Object[][] { { "name", null }, { "value", null } }), 
                                Libs.makeJosnValue(new Object[][] { { "name", null }, { "value", "99세" } }) 
                                }));
        
//                Libs.makeJosnValue(Libs.makeJosnValue("result", true),
//                        Libs.makeJosnValue("data",
//                                Libs.makeJosnValue("contents", new Object[] {
//                                        Libs.makeJosnValue(new Object[][] { { "name", "yskim" }, { "value", "10세" } }),
//                                        Libs.makeJosnValue(new Object[][] { { "name", "한가인2" }, { "value", "20세" } })
//
//                                })));

        return jsonData;
    }
    
    // http://localhost:8081/test/getData4Toast3
    @GetMapping("/getData4Toast3")
    public @ResponseBody Object getData4Toast3(QnaSearchVO vo) {
        System.out.println(className + ".getData4Toast3()");
        
        List<QnaVO> lstQnaResult = qnaSrvice.search(vo);
        return Libs.makeToastJsonResult(lstQnaResult);
    }
    
    // http://localhost:8081/test/frmShowGrid
    @GetMapping("/frmShowGrid")
    public String frmShowGrid() {
        System.out.println(className + ".frmShowGrid()");
        return "/test/frmTestShowGrid2";  // .html
    }
    
    // http://localhost:8081/test/frmToggleCheckBox
    @GetMapping("/frmToggleCheckBox")
    public String frmToggleCheckBox() {
        System.out.println(className + ".frmToggleCheckBox()");
        return "/test/frmToggleCheckBox";  // .html
    }
        
    @PostMapping("/toggleCheckBox")
    public @ResponseBody AjaxTestVO toggleCheckBox(
            // @RequestParam(value="isPub", required=false, defaultValue="N") // isPub이 전달 안 된 경우 "N"을 가짐.
            // String isPub, String name, String age, String tel) {
            AjaxTestVO vo) {
        System.out.println(className + ".toggleCheckBox()");
        
        if(vo != null) {
            vo.setPub(Libs.nvl(vo.getPub(), "N"));  // null 또는 "" 인 경우 "N"으로 변경
        }
        
        System.out.println("[상태값] " + vo);
        return vo;
    }
    
    // ************************************************
    // * JSON 데이터를 parameter로 전달하는  경우
    //   - POST 방식, 
    //   - P@RequestBody로 parameter 받고,
    //   - Parameter VO에 @NoArgsConstructor
    //   가 있어야 한다.
    // ************************************************
    @PostMapping("/ajaxToggleCheckBox")
    public @ResponseBody AjaxTestVO ajaxToggleCheckBox(
            // @RequestParam(value="isPub", required=false, defaultValue="N") // isPub이 전달 안 된 경우 "N"을 가짐.
            // String isPub, String name, String age, String tel) {
            @RequestBody AjaxTestVO vo) {
        System.out.println(className + ".toggleCheckBox()");
        
        if(vo != null) {
            vo.setPub(Libs.nvl(vo.getPub(), "N"));  // null 또는 "" 인 경우 "N"으로 변경
        }
        
        System.out.println("[상태값] " + vo);
        return vo;
    }

}

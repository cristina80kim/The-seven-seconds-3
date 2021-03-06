package com.team3.prj.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    public String[][] getAuthorizations() {
        return new String[][] {
            {className2 + "jsonTest", Common.strRoleAMUY},
            {className2 + "getData4Toast", Common.strRoleAMUY},
            {className2 + "qnaSearch", Common.strRoleAMUY},
            {className2 + "getData4Toast2", Common.strRoleAMUY},
            {className2 + "getData4Toast3", Common.strRoleAMUY},
            {className2 + "frmShowGrid", Common.strRoleAMUY},
            {className2 + "frmToggleCheckBox", Common.strRoleAMUY},
            {className2 + "toggleCheckBox", Common.strRoleAMUY},
            {className2 + "ajaxToggleCheckBox", Common.strRoleAMUY}
        };
    }

    @Autowired
    QnaService qnaSrvice;

    // http://localhost:8081/test/json
    @GetMapping("/jsonTest")
    @ResponseBody
    public EmpVO jsonTest() {
        System.out.println(className + ".jsonTest()");
        return new EmpVO();
    }

    // http://localhost:8081/test/getData4Toast
    @RequestMapping("/getData4Toast")
    public @ResponseBody String getData4Toast() {
        System.out.println(className + ".getData4Toast()");

        String jsonData = "{"
                + "    \"result\": true,\r\n"
                + "    \"data\": {\r\n"
                + "        \"contents\": [\r\n"
                + "            {\r\n"
                + "                \"name\": \"yskim\",\r\n"
                + "                \"value\": \"99???\"\r\n"
                + "            },\r\n"
                + "            {\r\n"
                + "                \"name\": \"?????????\",\r\n"
                + "                \"value\": \"20???\"\r\n"
                + "            }\r\n"
                + "        ]\r\n"
                + "    }"
                + "}";

        return jsonData;
    }

    // http://localhost:8081/test/qnaSearch?cateId=&keyWord=
    @GetMapping("/qnaSearch")
    public @ResponseBody List<QnaVO> qnaSearch(QnaSearchVO svo) {
        System.out.println(className + ".qnaSearch()");
        System.out.println(svo);
        List<QnaVO> result = qnaSrvice.search(svo);
        System.out.println("??????: " + result);
        return result;
    }

    // http://localhost:8081/test/getData4Toast2?page=1&perPage=10
    @RequestMapping("/getData4Toast2")
    public @ResponseBody Object getData4Toast2(
            @RequestParam(value="page", required=false, defaultValue="1") String page,
            @RequestParam(value="perPage", required=false, defaultValue="5") String perPage) {
        System.out.println(className + ".getData4Toast2(" + page + ", " + perPage + ")");

        // String[][] str = new String[][] {{"111", "112", "113"}, {"121", "122", "123"}};

        // [??????]
        // {"result": true, "data": { "contents": [ { "name": "yskim", "value": "99???" }, { "name": "?????????", "value": "20???" } ] }}
        // {"result": true, "data": { "contents": [ { "name": "yskim", "value": "10???" }, { "name": "?????????2", "value": "20???" } ] }}

        int page2 = Integer.valueOf(Libs.nvl(page, "1"));
        int perPage2 = Integer.valueOf(Libs.nvl(perPage, "5"));
        System.out.println("?????????: page: " + page2 + ", perPage: " + perPage2);

        // ?????? ?????? ????????? ?????????
        Object[] objs = new Object[perPage2];
        int start = (page2 - 1) * perPage2;

        for(int nI = 0; nI < perPage2; nI ++) {
            start++;
            String name = (nI % 2 == 0 ? "?????????" : "??????") + start;
            String value = String.valueOf((nI % 2 == 0 ? 25 : 20) + start);
            objs[nI] = Libs.makeJosnValue(new Object[][] {
                { "name", name }, { "value", value } });
        }

        // ?????? ?????? ??????
        int totalCount = 13;

        // ????????? TOAST Grid ????????? JSON?????? ??????.
        JSONObject result = Libs.makeToastJsonResult(objs, page, perPage, totalCount);
        // ??????
        //   {
        //     "result":true,
        //     "data": { "pagination": {"page":"1", "totalCount":"13"},
        //               "contents":[
        //                 {"name":"?????????1", "value":"26"},
        //                 {"name":"??????2",  "value":"22"},
        //                 {"name":"?????????3", "value":"28"},
        //                 {"name":"??????4",  "value":"24"},
        //                 {"name":"?????????5", "value":"30"},
        //                 {"name":"??????6",  "value":"26"},
        //                 {"name":"?????????7", "value":"32"},
        //                 {"name":"??????8",  "value":"28"},
        //                 {"name":"?????????9", "value":"34"},
        //                 {"name":"??????10", "value":"30"}
        //               ]
        //             }
        //   }

//        JSONObject data = new JSONObject();
//        data.put("contents", objs);
//
//        JSONObject pagination = new JSONObject();
//        pagination.put("page", String.valueOf(page2));
//        pagination.put("totalCount", String.valueOf(totalCount));
//        data.put("pagination", pagination);
//
//        JSONObject result = new JSONObject();
//        result.put("result", true);
//        result.put("data", data);


//                Libs.makeJosnValue("contents",
//                        new Object[] {
//                                Libs.makeJosnValue(new Object[][] { { "name", "yskim" }, { "value", null } }),
//                                Libs.makeJosnValue(new Object[][] { { "name", "?????????2" }, { "value", "20???" } }),
//                                Libs.makeJosnValue(new Object[][] { { "name", null }, { "value", null } }),
//                                Libs.makeJosnValue(new Object[][] { { "name", null }, { "value", "99???" } })
//                });

//                Libs.makeJosnValue(Libs.makeJosnValue("result", true),
//                        Libs.makeJosnValue("data",
//                                Libs.makeJosnValue("contents", new Object[] {
//                                        Libs.makeJosnValue(new Object[][] { { "name", "yskim" }, { "value", "10???" } }),
//                                        Libs.makeJosnValue(new Object[][] { { "name", "?????????2" }, { "value", "20???" } })
//
//                                })));
        return result;
    }

    // http://localhost:8081/test/getData4Toast3
    @GetMapping("/getData4Toast3")
    public @ResponseBody Object getData4Toast3(QnaSearchVO vo) {
        System.out.println(className + ".getData4Toast3()");

        List<QnaVO> lstQnaResult = qnaSrvice.search(vo);
        String page = "1";
        String perPage = "5";
        int totalCount = 13;
        return Libs.makeToastJsonResult(lstQnaResult, page, perPage, totalCount);
    }

    // http://localhost:8081/test/frmShowGrid
    @GetMapping("/frmShowGrid")
    public String frmShowGrid() {
        System.out.println(className + ".frmShowGrid()");

        HttpSession httpSession = Libs.getSession();
        httpSession.setAttribute("id", "yskim");
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
            // @RequestParam(value="isPub", required=false, defaultValue="N") // isPub??? ?????? ??? ??? ?????? "N"??? ??????.
            // String isPub, String name, String age, String tel) {
            AjaxTestVO vo) {
        System.out.println(className + ".toggleCheckBox()");

        if(vo != null) {
            vo.setPub(Libs.nvl(vo.getPub(), "N"));  // null ?????? "" ??? ?????? "N"?????? ??????
        }

        System.out.println("[?????????] " + vo);
        return vo;
    }

    // ************************************************
    // * JSON ???????????? parameter??? ????????????  ??????
    //   - POST ??????,
    //   - P@RequestBody??? parameter ??????,
    //   - Parameter VO??? @NoArgsConstructor
    //   ??? ????????? ??????.
    // ************************************************
    @PostMapping("/ajaxToggleCheckBox")
    public @ResponseBody AjaxTestVO ajaxToggleCheckBox(
            // @RequestParam(value="isPub", required=false, defaultValue="N") // isPub??? ?????? ??? ??? ?????? "N"??? ??????.
            // String isPub, String name, String age, String tel) {
            @RequestBody AjaxTestVO vo) {
        System.out.println(className + ".toggleCheckBox()");

        if(vo != null) {
            vo.setPub(Libs.nvl(vo.getPub(), "N"));  // null ?????? "" ??? ?????? "N"?????? ??????
        }

        System.out.println("[?????????] " + vo);
        return vo;
    }

}


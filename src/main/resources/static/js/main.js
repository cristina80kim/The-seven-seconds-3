
var main = {

  //============================================================
  // 기능: checkbox인 chk가 checked이면 value를 vChecked로 그렇지 않으면 vUnchecked로 설정한다.
  //============================================================
  onCheckBoxChanged: function(chk, vChecked, vUnchecked) {
    chk.value = chk.checked ? vChecked : vUnchecked; 
    console.log(">>> chk.value = " + chk.value + ", chk.checked = " + chk.checked);
  },

  //------------------------------------------------------------
  // 기능: checkbox인 chk가 checked이면 value를 "Y"로 그렇지 않으면 "N"으로 설정한다.
  onIsPubChanged: function(chk) {
    main.onCheckBoxChanged(chk, "Y", "N");
  },
  
  //------------------------------------------------------------
  // 숙박시설-유형(호텔, 모텔, 펜션/풀빌라, 글램핑/캠프, 게하/한옥, 리조트/콘도)
  //------------------------------------------------------------
  // 기능: checkbox인 chk가 checked이면 value를 "hotel"로 그렇지 않으면 ""으로 설정한다.
  onHotelChanged: function(chk) {
    main.onCheckBoxChanged(chk, "hotel", "");
  },
  
  // 기능: checkbox인 chk가 checked이면 value를 "motel"로 그렇지 않으면 ""으로 설정한다.
  onMotelChanged: function(chk) {
    main.onCheckBoxChanged(chk, "motel", "");
  },
  
  // 기능: checkbox인 chk가 checked이면 value를 "pension"로 그렇지 않으면 ""으로 설정한다.
  onPensionChanged: function(chk) {
    main.onCheckBoxChanged(chk, "pension", "");
  },
  
  // 기능: checkbox인 chk가 checked이면 value를 "glamping"로 그렇지 않으면 ""으로 설정한다.
  onGlampingChanged: function(chk) {
    main.onCheckBoxChanged(chk, "glamping", "");
  },
  
  // 기능: checkbox인 chk가 checked이면 value를 "guest_house"로 그렇지 않으면 ""으로 설정한다.
  onGuestHouseChanged: function(chk) {
    main.onCheckBoxChanged(chk, "guest_house", "");
  },

  // 기능: checkbox인 chk가 checked이면 value를 "resort"로 그렇지 않으면 ""으로 설정한다.
  onResortChanged: function(chk) {
    main.onCheckBoxChanged(chk, "resort", "");
  },
  
  //------------------------------------------------------------
  // 룸-유형(...)
  //------------------------------------------------------------
  // 기능: checkbox인 chk가 checked이면 value를 "standard"로 그렇지 않으면 ""으로 설정한다.
  onStandardChanged: function(chk) {
    main.onCheckBoxChanged(chk, "standard", "");
  },
  
  // 기능: checkbox인 chk가 checked이면 value를 "single"로 그렇지 않으면 ""으로 설정한다.
  onSingleChanged: function(chk) {
    main.onCheckBoxChanged(chk, "single", "");
  },
  
  // 기능: checkbox인 chk가 checked이면 value를 "double"로 그렇지 않으면 ""으로 설정한다.
  onDoubleChanged: function(chk) {
    main.onCheckBoxChanged(chk, "double", "");
  },
  
  // 기능: checkbox인 chk가 checked이면 value를 "triple"로 그렇지 않으면 ""으로 설정한다.
  onTripleChanged: function(chk) {
    main.onCheckBoxChanged(chk, "triple", "");
  },
  
  // 기능: checkbox인 chk가 checked이면 value를 "twin"로 그렇지 않으면 ""으로 설정한다.
  onTwinChanged: function(chk) {
    main.onCheckBoxChanged(chk, "twin", "");
  },
  
  // 기능: checkbox인 chk가 checked이면 value를 "superior"로 그렇지 않으면 ""으로 설정한다.
  onSuperiorChanged: function(chk) {
    main.onCheckBoxChanged(chk, "superior", "");
  },
  
  // 기능: checkbox인 chk가 checked이면 value를 "deluxe"로 그렇지 않으면 ""으로 설정한다.
  onDeluxeChanged: function(chk) {
    main.onCheckBoxChanged(chk, "deluxe", "");
  },
  
  // 기능: checkbox인 chk가 checked이면 value를 "suite"로 그렇지 않으면 ""으로 설정한다.
  onSuiteChanged: function(chk) {
    main.onCheckBoxChanged(chk, "suite", "");
  },
  
  //============================================================
  // 기능: param이 빈 값인지 검사한다.      
  //============================================================
  isEmpty: function(param) {
    return (typeof param == "undefined" || param == null || param == "") ? true : false;
  },

  //============================================================
  // 기능: param이 유효한 값인지 검사한다.      
  //============================================================
  isNotEmpty: function(param) {
    return (typeof param == "undefined" || param == null || param == "") ? false : true;
  },

  //============================================================
  // 기능: param이 유효한 값인지 param을 그렇지 않으며 defVal를 응답한다.      
  //============================================================
  nvl: function(param, defVal) {
    return (typeof param == "undefined" || param == null || param == "") ? defVal : param;
  },

  ajaxGetHtml: function(loc, componentName) {
    // window.open(loc);
    // window.location.href =
    console.log(">>> ajaxGetHtml(): 1");
    console.log(">>> ajaxGetHtml(): " + loc);

    $.ajax({ 
        type : "GET", 
        url : loc, 
        dataType : "html", 
        success : function(msg) {
            console.log(msg); 
            $("#" + componentName).html(msg); 
        } 
    });
 
    console.log(">>> ajaxGetHtml(): 2");
  },

  //============================================================
  // 기능: ajax GET 형태로 loc를 호출하여 성공한 경우 callbackFunc를 호출한다.      
  //============================================================
  ajaxGetJson: function(loc, callbackFunc) {
     // window.open(loc);
     // window.location.href = loc; 
    console.log(">>> ajaxGetJson(): 1");
    console.log(">>> ajaxGetJson(): " + loc);
      
     $.ajax({ 
      type : "GET",
      url : loc,
      dataType : "json", 
      success : function(jsonParam) {
        console.log(">>> ajaxGetJson(): 2");
        console.log(jsonParam);
        
        if(main.isNotEmpty(callbackFunc)) {
          console.log(">>> ajaxGetJson(): 3");
          callbackFunc(jsonParam);
        }
        
        console.log(">>> ajaxGetJson(): 4");
       } 
     }); 
  },

  //============================================================
  // 기능: ajax POST 형태로 loc를 호출하여 성공한 경우 callbackFunc를 호출한다.      
  //============================================================
  ajaxPostJson: function(loc, param, callbackSuccess, callbackFail) {
     // window.open(loc);
     // window.location.href = loc; 
    console.log(">>> ajaxPostJson(): 1---");
    console.log(">>> ajaxPostJson(): loc=" + loc + ", param="+ param);
      
    $.ajax({ 
      type : "POST",
      url : loc,
      dataType : "json", 
      data : JSON.stringify(param),   // (X) encodeURIComponent(JSON.stringify(param)), 
      contentType: "application/json; charset=UTF-8",
      success : function(jsonParam) {
        console.log(">>> ajaxPostJson(): success 1");
        console.log(jsonParam);
        
        if(main.isNotEmpty(callbackSuccess)) {
          console.log(">>> ajaxPostJson(): success 2");
          callbackSuccess(jsonParam);
        }
        
        console.log(">>> ajaxPostJson(): success 3");
      },
//       fial: function(jsonParam) {
//        console.log(">>> ajaxPostJson(): fail 1");
//        console.log(jsonParam);
//        
//        if(main.isNotEmpty(callbackFail)) {
//          console.log(">>> ajaxGetJson(): fail 2");
//          callbackFail(jsonParam);
//        }
//        
//        console.log(">>> ajaxPostJson(): fail 3");
//       },
    }); 
  },
  
  //============================================================
  // 기능: ajax GET 형태로 공통코드를 불러와 componentName(<select>)에 대입한다.      
  //============================================================
  ajaxCommonCodeToSelectBox: function(loc, componentName) {
    console.log("ajaxCommonCodeToSelectBox(): 1");
    
    main.ajaxGetJson(loc, function(jsonData) {
      console.log("ajaxCommonCodeToSelectBox(): 2");
      console.log(jsonData);
   
      var str = "<option value=''>=========</option>";
    
      $.each(jsonData, function(index, item) {
        str += "<option value='" + item["class3"] + "'>" + item["name"] + "</option>";
      });
    
      $("#" + componentName).html(str);
    });
  },
    
  // 기능: 숙박시설유형 공통코드를 불러와 componentName(<select>)에 대입한다.      
  ajaxCodeAccoToSelectBox: function(componentName) {
	main.ajaxCommonCodeToSelectBox("/main/getAccoCommonCode", componentName);
  },
    
  // 기능: 룸 유형 공통코드를 불러와 componentName(<select>)에 대입한다.      
  ajaxCodeRoomToSelectBox: function(componentName) {
	main.ajaxCommonCodeToSelectBox("/main/getRoomCommonCode", componentName);
  },
    
  // 기능: Q&A 유형 공통코드를 불러와 componentName(<select>)에 대입한다.      
  ajaxCodeQnaToSelectBox: function(componentName) {
	main.ajaxCommonCodeToSelectBox("/main/getQnaCommonCode", componentName);
  },
    

  //============================================================
  // 기능: jqGrid에 ajax를 통해 수신된 JSON Data를 출력한다.
  //============================================================
  showGridDatas: function(param) {
    console.log(">>> showGridDatas(): 1");
    
    var loc = param.loc;
    var mtype = param.mtype;
    var componentName = main.isEmpty(param.componentName) ? "#gridData" : "#" + param.componentName;
    var pagerName = main.isEmpty(param.pagerName) ? "#gridPager" : "#" + param.pagerName;
    var colNames = param.colNames;
    var colModel = param.colModel;
    var width = main.isEmpty(param.width) ? 800 : param.width;
    var height = main.isEmpty(param.height) ? 300 : param.height; 
    var rowNum = main.isEmpty(param.rowNum) ? 5 : param.rowNum;
    var onSelectRow = param.onSelectRow;
    
    console.log(">>> componentName: " + componentName 
      + ", pagerName: " + pagerName
      + ", width: " + width
      + ", height: " + height
      + ", rowNum: " + rowNum
    );

    $(componentName).jqGrid({ 
      url:          loc,                // 서버 호출 주소
      mtype:        mtype,              // "POST" 또는 "GET"   
      datatype:     "json",             // 데이터 타입("json", "xml", "array", "local", ...)
   // data:         data1,              // 출력 데이터
      width:        width,              // 그리드 넓이(폭)
      height:       height,             // 그리드 높이
   // caption:      ">>> Q & A <<<",    // Caption에 출력할 메시지
      colNames:     colNames,           // 그리드 헤더의 제목(배열 형태임)  
      colModel:     colModel,           // 그리드 행 데이터 정의(colNames의 갯수 = colModel 갯수) 
      pager:        pagerName,          // Paging 정보를 표시할 Tag의 ID명
     //pagination:   true,
      rowNum:       rowNum,             // 보여줄 행의 개수 설정
      pgbuttons:    true,
      loadtext:     "데이터 로딩 중...",   // 데이터를 불려 올 때 보여줄 메시지
      emptyrecode:  "자료가 없습니다.",     // 출력가 자료가 없는 경우 보여줄 메시지

      //repeatitems:  true,
      onSelectRow:  onSelectRow,        // row 선택시 발생하는 이벤트

      //----------------------      
      onPaging:     function(pgButton) {
        var gridPage = $(componentName).getGridParam("page");
        var totalPage = $(componentName).getGridParam("total");
 
        if(pgButton == "next"){            // 다음 페이지
            if(gridPage < totalPage){
                gridPage++;
            }else{
                gridPage = page;
            }
        } else if (pgButton == "prev") {    // 이전 페이지
            if(gridPage > 1){
                gridPage--;
            }else{
                gridPage = page;
            }
        } else if (pgButton == "first") {    // 첫 페이지
            gridPage = 1;
        } else if (pgButton == "last") {    // 마지막 페이지
            gridPage = totalPage;
        } else if (pgButton == "user") {    // 사용자 입력 페이징 처리
            var nowPage = Number($("#pager .ui-pg-input").val());
            // 입력한 값이 총 페이지수보다 크다면 수행
            if (totalPage >= nowPage && nowPage > 0) {
                gridPage = nowPage;
            }else{
                $(pagerName + " .ui-pg-input").val(page);
                gridPage = page;
            }
        } else if(pgButton == "records"){
            gridPage = 1;
        }
 
        $(componentName).setGridParam("page", gridPage);
 
        $(componentName).setGridParam({
            postData    : jqGridForm.setParam()
        });
      },
      //----------------------      
    
   // scroll:       true,               // 스크로 바 보이기(페이징 기능 X)/안 보이기 
   // rownumbers:   true, 
   // viewrecords:  true, 
   // pgbuttons:    true, 
   // pginput:      true, 
   // shrinkToFit:  true, 
   // sortable:     false, 
   // loadonce:     false, 
   // hidegrid:     true,
   // loadComplete: function(data) { }
    });
    
    console.log(">>> showGridDatas(): 2");
  },
  
  //============================================================
  // 기능: console에 log 출력. 
  //============================================================
  log: function(msg) {
    console.log(">>> " + msg);
  }
  
}
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
    return (typeof str == "undefined" || str == null || str == "") ? true : false;
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

  //============================================================
  // 기능: ajax 형태로 loc를 호출하여 성공한 경우 callbackFunc를 호출한다.      
  //============================================================
  ajaxGetJson: function(loc, callbackFunc) {
     // window.open(loc);
     // window.location.href = loc; 
    console.log(">>> ajaxGetJson(): 1");
    console.log(">>> ajaxGetJson(): " + loc);
      
     $.ajax({ 
      type : "GET", 
      dataType : "json", 
      url : loc, 
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
  // 기능: jㅂGrid에 jsonParam을 출력한다.
  //============================================================
  showGridDatas: function(loc, mtype, colNames, colModel, width, height, rowNum) {
    console.log(">>> showGridDatas(): 1");

    $("#gridData").jqGrid({ 
      url:          loc,                // 서버 호출 주소
      mtype:        mtype,              // "POST" 또는 "GET"   
      datatype:     "json",             // 데이터 타입("json", "xml", "array", "local", ...)
   // data:         data1,              // 출력 데이터
      width:        main.isEmpty(width) ? 800 : width,   // 그리드 넓이(폭)
      height:       main.isEmpty(height) ? 300 : height, // 그리드 높이
   // caption:      ">>> Q & A <<<",    // Caption에 출력할 메시지
      colNames:     colNames,           // 그리드 헤더의 제목(배열 형태임)  
      colModel:     colModel,           // 그리드 행 데이터 정의(colNames의 갯수 = colModel 갯수) 
      pager:        "#gridPager",       // Pagin 정보를 표시할 Tag의 ID명
      rowNum:       main.isEmpty(rowNum) ? 5 : rowNum, // 보여줄 행의 개수 설정
      loadtext:     "데이터 로딩 중...",   // 데이터를 불려 올 때 보여줄 메시지
      emptyrecode : "자료가 없습니다.",     // 출력가 자료가 없는 경우 보여줄 메시지
   // scroll:       true,               // 스크로 바 보이기(페이징 기능 X)/안 보이기 
   // rownumbers:   true, 
   // viewrecords:  true, 
   // pgbuttons:    true, 
   // pginput:      true, 
   // shrinkToFit:  true, 
   // sortable:     false, 
   // loadonce:     false, 
   // hidegrid:     true 
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
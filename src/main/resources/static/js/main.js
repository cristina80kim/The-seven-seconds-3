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
  // 기능: console에 log 출력. 
  //============================================================
  log: function(msg) {
    console.log(">>> " + msg);
  }
  
}
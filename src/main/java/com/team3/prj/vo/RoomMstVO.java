package com.team3.prj.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class RoomMstVO {
  private Long id;			//아이디
  private String region;	//지역
  private String title;		//숙소명
  private String zipCode;	//우편번호
  private String addr;		//주소
  private String tel;		//전화번호
  private String info;		//설명
  private String pic1Org;	//사진1 원본파일명
  private String pic1Uuid;	//사진1 UUID
  private String pic2Org;	//사진2 원본파일명
  private String pic2Uuid;	//사진2 UUID
  private String pic3Org;	//사진3 원본파일명
  private String pic3Uuid;	//사진3 UUID
  private String cUser;		//생성자 id
  private String mUser;		//수정자 id
  private String cDate;		//생성일자/시간
  private String mDate;		//수정일자/시간
  private String typeOfAcco; // 숙박시설종류/ 공통코드
  private String mainAddr;   // 00시 00구 
  private String dtlAddr;	// 00아파트000동000호
  

}

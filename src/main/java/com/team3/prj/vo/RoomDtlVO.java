package com.team3.prj.vo;

import lombok.Data;

@Data
public class RoomDtlVO {
	private String id;
	private String mst_id;
	private String room_name;
	private String num_of_guests;
	private String check_in_time;
	private String check_out_time;
	private String weekday_price;
	private String weekend_price;
	private String pic1Org;
	private String pic1Uuid;
	private String pic2Org;
	private String pic2Uuid;
	private String pic3Org;
	private String pic3Uuid;
	private String cUser;
	private String mUser;
	private String cDate;
	private String mDate;
}

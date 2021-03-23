package com.team3.prj.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team3.prj.service.RoomMstService;
import com.team3.prj.vo.RoomMstVO;

@Controller
@RequestMapping("/roomMst")
public class RoomMstController {
	private final String className = "RoomMstController";

	@Autowired
	RoomMstService service;

	// http://localhost:8081/roomMst/selectAll
	@GetMapping("/selectAll")
	public @ResponseBody List<RoomMstVO> selectAll() {
		System.out.println(className + ".selectAll()");
		return service.selectAll();
	}

	// http://localhost:8081/qna/insert?nickname=yskim&no=1&cateId=aaaa&isPub=Y&title=title&q=question&cUser=yskim
	@GetMapping("/insert")
	public @ResponseBody String insert(RoomMstVO vo) {
		System.out.println(className + ".insert(): " + vo.toString());

		/*
		 * String fileName = null; MultipartFile uploadFile1 = vo.getPic1Org();
		 * MultipartFile uploadFile2 = vo.getPic2Org(); MultipartFile uploadFile3 =
		 * vo.getPic3Org(); if (!uploadFile1.isEmpty()) { String pic1Org =
		 * uploadFile1.getOriginalFilename(); String ext =
		 * StringUtils.getFilename(pic1Org); UUID uuid = UUID.randomUUID(); fileName =
		 * uuid + "." + ext; vo.setPic1Uuid(fileName); } if (!uploadFile2.isEmpty()) {
		 * String pic2Org = uploadFile2.getOriginalFilename(); String ext =
		 * StringUtils.getFilename(pic2Org); UUID uuid = UUID.randomUUID(); fileName =
		 * uuid + "." + ext; vo.setPic2Uuid(fileName); } if (!uploadFile3.isEmpty()) {
		 * String pic3Org = uploadFile3.getOriginalFilename(); String ext =
		 * StringUtils.getFilename(pic3Org); UUID uuid = UUID.randomUUID(); fileName =
		 * uuid + "." + ext; vo.setPic3Uuid(fileName); }
		 */ // 파일 업로드 및 파일명 uuid 변환 처리 미완성

		return service.insert(vo).toString();
	}

}
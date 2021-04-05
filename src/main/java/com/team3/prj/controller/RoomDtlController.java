package com.team3.prj.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team3.prj.etc.Libs;
import com.team3.prj.service.RoomDtlService;
import com.team3.prj.vo.RoomDtlSerchVO;
import com.team3.prj.vo.RoomDtlVO;

@Controller
@RequestMapping("/roomDtl")
public class RoomDtlController {
	private final String className = "RoomDtlController";

	@Autowired
	RoomDtlService service;

	// http://localhost:8081/roomDtl/selectAll
	@GetMapping("/selectAll")
	public @ResponseBody List<RoomDtlVO> selectAll() {
		System.out.println(className + ".selectAll()");
		return service.selectAll();
	}

	
	
	@GetMapping("/search")
	public @ResponseBody List<RoomDtlVO> search(RoomDtlSerchVO svo){
		System.out.println(className + ".search()");
		return service.search(svo);
	}
	
	
	@Value("${file.upload.directory}")
	String uploadDir;

//	기능 : 숙소룸 등록
//	Param : roomDtlVO 중 - id(자동대입), mstId, roomName, typeOfRoom(공통코드),
//						  numOfGuests, checkInTime, checkOutTime, weekdayPrice,
//						  weekendPrice, pic1Org, pic1Uuid, pic2Org, pic2Uuid,
//						  pic3Org, pic3Uuid, cUser
	// http://localhost:8081/roomDtl/manager_RoomRegist
	@GetMapping("/roomInsert")
	public String roomInsert() {
		return "manager_RoomRegist";
	}

	@PostMapping(value = "/insert")
	public @ResponseBody String insert(RoomDtlVO vo, @RequestParam("files") List<MultipartFile> files)
			throws IllegalStateException, IOException {
		String uploadPath = new File("").getAbsolutePath() + uploadDir;
		String fileName = null;

		if (files != null) {
			int index = 0;
			for (MultipartFile file : files) {
				if (!file.isEmpty()) {
					UUID uuid = UUID.randomUUID();
					String destName = uuid.toString().replace("-", "");
					String orgName = file.getOriginalFilename();
					String ext = Libs.getFileExt(orgName);
					String destPath = uploadPath + destName + ext;

					System.out.println("원본파일명: " + orgName);
					System.out.println("생성된 파일: " + destPath);

					File dest = new File(destPath);
					file.transferTo(dest);

					if (index == 0) {
						String uuidPic1 = destName + ext;
						vo.setPic1Org(orgName);
						vo.setPic1Uuid(uuidPic1);
					} else if (index == 1) {
						String uuidPic2 = destName + ext;
						vo.setPic2Org(orgName);
						vo.setPic2Uuid(uuidPic2);
					} else {
						String uuidPic3 = destName + ext;
						vo.setPic3Org(orgName);
						vo.setPic3Uuid(uuidPic3);
					}
					index++;
				}
			}
		}
		System.out.println(className + ".insert(): " + vo.toString());
		return service.insert(vo).toString();
	}
	
	
	// http://localhost:8081/roomDtl/manager_RoomRegist_update
	@GetMapping("/roomUpdate")
	public String roomUpdate() {
		return "manager_RoomRegist_update";
	}

	@PostMapping(value = "/update")
	public @ResponseBody String update(RoomDtlVO vo, @RequestParam("files") List<MultipartFile> files)
			throws IllegalStateException, IOException {
		String uploadPath = new File("").getAbsolutePath() + uploadDir;
		String fileName = null;

		if (files != null) {
			int index = 0;
			for (MultipartFile file : files) {
				if (!file.isEmpty()) {
					UUID uuid = UUID.randomUUID();
					String destName = uuid.toString().replace("-", "");
					String orgName = file.getOriginalFilename();
					String ext = Libs.getFileExt(orgName);
					String destPath = uploadPath + destName + ext;

					System.out.println("원본파일명: " + orgName);
					System.out.println("생성된 파일: " + destPath);

					File dest = new File(destPath);
					file.transferTo(dest);

					if (index == 0) {
						String uuidPic1 = destName + ext;
						vo.setPic1Org(orgName);
						vo.setPic1Uuid(uuidPic1);
					} else if (index == 1) {
						String uuidPic2 = destName + ext;
						vo.setPic2Org(orgName);
						vo.setPic2Uuid(uuidPic2);
					} else {
						String uuidPic3 = destName + ext;
						vo.setPic3Org(orgName);
						vo.setPic3Uuid(uuidPic3);
					}
					index++;
				}
			}
		}
		System.out.println(className + ".update(): " + vo.toString());
		return service.update(vo).toString();
	}
	// http://localhost:8081/roomDtl/delte?id=1000000009&mstId=1000000000
	@GetMapping("/delete")
	public @ResponseBody String delete(RoomDtlVO vo) {
		return service.delete(vo).toString();

	}
}
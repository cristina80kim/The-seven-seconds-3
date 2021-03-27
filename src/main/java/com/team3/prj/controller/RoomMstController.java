package com.team3.prj.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.team3.prj.etc.Libs;
import com.team3.prj.service.RoomMstService;
import com.team3.prj.vo.RoomMstVO;

@Controller
@RequestMapping("/roomMst")
public class RoomMstController {
	private final String className = "RoomMstController";

	@Autowired
	RoomMstService service;

	// http://localhost:8081/manager_RoomMstRegist
	@GetMapping("/manager_RoomMstRegist")
	public String manager_RoomMstRegist() {
		return "manager_RoomMstRegist";
	}

	// http://localhost:8081/roomMst/selectAll
	@GetMapping("/selectAll")
	public @ResponseBody List<RoomMstVO> selectAll() {
		System.out.println(className + ".selectAll()");
		return service.selectAll();
	}

	@Value("${file.upload.directory}")
	String uploadDir;

	@PostMapping(value = "/insert")
	public @ResponseBody String insert(RoomMstVO vo, @RequestParam("files") List<MultipartFile> files)
			throws IllegalStateException, IOException {

		// ClassPathResource classPathResource = new ClassPathResource("/uploads/");
		// System.out.println("classpath = " + classPathResource.toString());
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
		String addr = vo.getMainAddr() + " , " + vo.getDtlAddr();
		vo.setAddr(addr);
		System.out.println(className + ".insert(): " + vo.toString());
		return service.insert(vo).toString();
	}

}
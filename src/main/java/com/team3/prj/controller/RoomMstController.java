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

import com.team3.prj.etc.Common;
import com.team3.prj.etc.Libs;
import com.team3.prj.service.RoomMstService;
import com.team3.prj.vo.RoomMstSearchVO;
import com.team3.prj.vo.RoomMstVO;

@Controller
@RequestMapping("/roomMst")
public class RoomMstController {
	private final String className = "RoomMstController";
    private final String className2 = className + ".";

    public String[][] getAuthorizations() {
        return new String[][] {
            {className2 + "selectAll", Common.strRoleAMUY},
            {className2 + "selectOne", Common.strRoleAMUY},
            {className2 + "search", Common.strRoleAMUY},
            {className2 + "roomInsert", Common.strRoleAMUY},
            {className2 + "insert", Common.strRoleAMUY},
            {className2 + "roomUpdate", Common.strRoleAMUY},
            {className2 + "update", Common.strRoleAMUY},
            {className2 + "delete", Common.strRoleAMUY},
            
        };
    }
	@Autowired
	RoomMstService service;

//	전체 출력
//	http://localhost:8081/roomMst/selectAll
	@GetMapping("/selectAll")
	public @ResponseBody List<RoomMstVO> selectAll() {
		System.out.println(className + ".selectAll()");
		return service.selectAll();
	}

//	1개 출력(숙소수정 누를시 저장되어있는 숙소 정보 불러오기)
//	http://localhost:8081/roomMst/oneSelect?id=1000000006
	@GetMapping("/selectOne")
	public @ResponseBody List<RoomMstVO> selectOne(RoomMstVO vo) {
		System.out.println(className + ".selectOne()");
		return service.selectOne(vo);
	}

//	검색기능
//	http://localhost:8081/roomMst/roomMstSearch?keyWord=서울
	@GetMapping("/search")
	public @ResponseBody List<RoomMstVO> search(RoomMstSearchVO svo) {
		System.out.println(className + ".search()");
		return service.search(svo);

	}

	@Value("${file.upload.directory}")
	String uploadDir;

//	 기능 : 숙소등록
//	 param : roomMstVO 중 - id(자동대입), region(mainAddr의데이터 substring), title,
//	 zipCode(api사용), addr(mainAddr+dtlAddr), tel, info,
//	 pic1Org(파일업로드1),pic1Uuid(파일업로드1의 uuid.확장자),
//	 pic2Org(파일업로드2),pic2Uuid(파일업로드2의 uuid.확장자),
//	 pic3Org(파일업로드3),pic3Uuid(파일업로드3의 uuid.확장자),
//	 cUser(로그인된 ID/자동대입), typeOfAcco(공통코드)
//	 http://localhost:8081/roomMst/manager_RoomMstRegist
	@GetMapping("/roomInsert")
	public String roonInsert() {
		return "manager_RoomMstRegist";
	}

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
		String regeion = vo.getMainAddr().substring(0, 2);
		vo.setRegion(regeion);
		String addr = vo.getMainAddr() + " , " + vo.getDtlAddr();
		vo.setAddr(addr);
		System.out.println(className + ".insert(): " + vo.toString());
		return service.insert(vo).toString();
	}

	
//	http://localhost:8081/roomMst/manager_RoomMstRegist_update
	@GetMapping("/roomUpdate")
	public String roomUpdate() {
		return "manager_RoomMstRegist_update";
	}

	@PostMapping(value = "/update")
	public @ResponseBody String update(RoomMstVO vo, @RequestParam("files") List<MultipartFile> files)
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
		String regeion = vo.getMainAddr().substring(0, 2);
		vo.setRegion(regeion);
		String addr = vo.getMainAddr() + " , " + vo.getDtlAddr();
		vo.setAddr(addr);
		System.out.println(className + ".insert(): " + vo.toString());
		return service.update(vo).toString();
	}

//	http://localhost:8081/roomMst/delete?id=
	@GetMapping("/delete")
	public @ResponseBody String delete(RoomMstVO vo) {
		return service.delete(vo).toString();

	}

}
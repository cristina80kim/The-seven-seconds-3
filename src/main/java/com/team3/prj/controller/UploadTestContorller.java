package com.team3.prj.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.team3.prj.etc.Libs;

@Controller
@RequestMapping("/test")
public class UploadTestContorller {

   @Value("${file.upload.directory}")
   String uploadDir; //application.properties에서 file.upload.directory 경로지정 값을 읽어온다
   
   
   // http://localhost:8081/test/uploadTest
   @GetMapping("/uploadTest")
   public String uploadTest() {
      System.out.println("uploadTest()");
      return "test/uploadTest";
   }

   @PostMapping(value = "/uploadExcelFile1")
   public String uploadExcelFile1(@RequestParam("files") List<MultipartFile> files) throws Exception {
      System.out.println("uploadExcelFile1()");

      // uploadPath는 실행환경의 classpath:/uploads를 이어야 함. (***) 찾아볼 것.
      // String uploadPath = "C:/TMP/uploads/"; // context.getRealPath("/uploads/");
      // TODO: classpath:uploads/를 구하는 방법 확인할 것.
      ClassPathResource classPathResource = new ClassPathResource("/uploads/"); // classpath위치의 변수명을 읽어올 때 
      System.out.println("classpath = " + classPathResource.toString());

      // System.out.println(Libs.getAbsolutePath("/uploads/"));

      String uploadPath = new File("").getAbsolutePath() + uploadDir; // "/src/main/resources/uploads/";
      System.out.println(">>> uploadPath=" + uploadPath);
      // String destPath = uploadPath + files.getOriginalFilename();
      // System.out.println(">>> destPath=" + destPath );

      if (files != null) {
         for (MultipartFile file : files) {

            if (!file.isEmpty()) {
               UUID uuid = UUID.randomUUID(); // 사용이유 - 파일의 이름을 중복 해결, 임의의 이름을 지정해주어 보안력(?)이 상승
               String destName = uuid.toString().replace("-", ""); // uuid로 바뀐 파일명
               String orgName = file.getOriginalFilename(); // 클라이언트가 가지고있는 파일명(실제파일명)
               String ext = Libs.getFileExt(orgName); // orgName의 확장자를 대입.
               String destPath = uploadPath + destName + ext; // uuid로 바뀐 파일의 위치+uuid파일명

               System.out.println("원본파일명: " + orgName);
               System.out.println("생성된 파일: " + destPath);

               File dest = new File(destPath);
               file.transferTo(dest); // 파일 업로드 작업 수행

               /*
                * 여기에 orgName, destName을 DB에 넣어야 한다. HTML 화면에 이 이미지를 보이려면 <img
                * src="C:\TMP\ uploads(이부분은 프로젝트에 넣어서 만들기)\destName(uuid)">
                */
            }
         }
      }

      return "test/uploadResult";
   }
}
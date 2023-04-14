package com.giggler.giggle.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.giggler.giggle.dto.ImageDTO;
import com.giggler.giggle.dto.ListDTO;
//import com.edu.board.controller.VueBoardController;
import com.giggler.giggle.dto.PostDTO;
import com.giggler.giggle.service.AwsS3Service;
import com.giggler.giggle.service.PostUploadService;

@RestController("postUploadController")
@RequestMapping("/post")
@CrossOrigin
public class PostUploadController {

	private static final Logger logger = LoggerFactory.getLogger(PostUploadController.class);
	
	@Inject
	private PostUploadService postUploadService;
	
	@Autowired
	private AwsS3Service awsS3Service;
	
	private int currentPostNo = -1;
	
	private int currentUserNo = -1;
	
	private static final String CLOUD_FRONT_URL = "https://d36nj4zto99jeg.cloudfront.net/raw/";
	
	
	/*
	 * Vue에서 작성한 포스트를 받아서 DB에 저장
	 */
	@PostMapping("/uploadpost")
	public String uploadPost(@RequestBody PostDTO postDTO) throws Exception {
		logger.info("PostUploadController uploadPost() => " + postDTO);
		
		if(postUploadService.uploadPost(postDTO) == 1) {
			currentPostNo = postUploadService.currentPostNo(postDTO);
			currentUserNo = postDTO.getUser_no();
			logger.info("PostUploadController currentPostNo => " + currentPostNo);
			
			return "Y";
		} else {
			return "N"; 
		}
		
	}
	
	/*
	 * Vue에서 포스트 상세 화면 표시 요청
	 */
	@GetMapping("/postdetail/{post_no}")
	public @ResponseBody HashMap<String, Object> postDetail(@PathVariable int post_no) throws Exception {
		logger.info("PostUploadController postDetail() post_no => " + post_no);
		
		HashMap<String, Object> postDetail = new HashMap<String, Object>();
		postDetail.put("post", postUploadService.postDetail(post_no));
		
		ImageDTO imgDTO = new ImageDTO();
		imgDTO.setPost_no(post_no);
		imgDTO.setIs_posting(1);
		List<ImageDTO> imageDTOs = postUploadService.postImages(imgDTO);
		logger.info("PostUploadController postDetail() imageDTOs.size() => " + imageDTOs.size());
		postDetail.put("postImages", imageDTOs);
		return postDetail;
	}
	
	/*
	 * Vue에서 이미지 파일 받아오기
	 */
	@PostMapping("/uploadimage")
	public String uploadImage(@RequestParam MultipartFile files) throws IOException {
		logger.info("PostUploadController uploadImage() files => " + files.getOriginalFilename());
		boolean result = awsS3Service.uploadObject(files, files.getOriginalFilename());
		logger.info("PostUploadController uploadImage() result => " + result);
		return CLOUD_FRONT_URL + files.getOriginalFilename();
	}
	
	/*
	 * Vue에서 이미지 파일들 받아오기
	 */
	@PostMapping("/uploadimages")
	public String uploadImages(@RequestParam List<MultipartFile> files) throws IOException {
		if (files == null)
			return "N";
		
		for (MultipartFile file : files) {
			logger.info("PostUploadController uploadImages() files => " + file.getOriginalFilename());
			boolean result = awsS3Service.uploadObject(file, file.getOriginalFilename());
			if (!result) {

				return "N";
			}
			logger.info("PostUploadController uploadImage() result => " + result);
			ImageDTO imageDTO = new ImageDTO(currentPostNo, CLOUD_FRONT_URL + file.getOriginalFilename(), 1, currentUserNo);
			postUploadService.uploadImage(imageDTO);
		}
		currentPostNo = -1;
		return "Y";
	}
	
	/*
	 * 포스트 삭제
	 */
	@DeleteMapping("/deletepost/{post_no}")
	public String deletePost(@PathVariable int post_no) throws Exception {
		logger.info("PostUploadController deletePost() post_no => " + post_no);
		
		deleteImages(currentPostNo, 1);
		// post_no로 포스트 삭제
		int delete = postUploadService.deletePost(post_no);
		if (delete < 1)
			return "N";
		
		return "Y";
	}
	
	/*
	 * 포스트 수정
	 */
	@PatchMapping("/upadtepost")
	public String updatePost(@RequestBody PostDTO postDTO) throws Exception {
		logger.info("PostUploadController updatePost() => " + postDTO);
		currentPostNo = postDTO.getPost_no();
		currentUserNo = postDTO.getUser_no();
		
		deleteImages(currentPostNo, 0);

		if(postUploadService.updatePost(postDTO) == 1) {	
			return "Y";
		} else {
			return "N"; 
		}		
	}
	
	private void deleteImages(int post_no, int is_posting) throws IOException {
		ImageDTO imgDTO = new ImageDTO();
		imgDTO.setPost_no(post_no);
		imgDTO.setIs_posting(is_posting);		
		// post_no로 먼저 이미지 파일 이름 가져오기
		List<ImageDTO> imageDTOs = postUploadService.postImages(imgDTO);
		
		// 이미지 파일 이름 가져온 걸로 서버에서 이미지 삭제
		for (ImageDTO imageDTO : imageDTOs) {
			logger.info("PostUploadController deletePost() imageDTO => " + imageDTO.getImagepath());
			awsS3Service.deleteObject(imageDTO.getImagepath());
		}
		
		// post_no로 이미지 테이블에서 데이터 삭제
		postUploadService.deletePostImages(post_no);
	}
	
	/*
	 *  삭제 예정 image 표시
	 */
	@PostMapping("/beforedeleteimage")
	@CrossOrigin
	public @ResponseBody String beforeDeleteImage(@RequestBody ImageDTO imageDTO) throws IOException {
		logger.info("PostUploadController beforeDeleteImage() files => " + imageDTO.getImagepath());
		postUploadService.beforeDeleteImage(imageDTO.getImagepath());
		return "Y";
	}
	
	/*
	 * 수정 취소
	 */
	@PostMapping("/cancelupdate")
	@CrossOrigin
	public @ResponseBody String cancelUpdate(@RequestBody ImageDTO imageDTO) throws IOException {
		logger.info("PostUploadController beforeDeleteImage() files => " + imageDTO.getImagepath());
		postUploadService.cancelUpdate(imageDTO.getPost_no());

		return "Y";
	}
	
	/*
	 * s3 이미지 삭제 
	 */
	@PostMapping("/deleteimage")
	@CrossOrigin
	public @ResponseBody String deleteImage(@RequestBody ImageDTO imageDTO) throws IOException {
		logger.info("PostUploadController deleteImage() files => " + imageDTO.getImagepath());
		awsS3Service.deleteObject(imageDTO.getImagepath());
		
		if (postUploadService.deleteImage(imageDTO.getImagepath()) < 1)
			return "N";

		return "Y";
	}
}

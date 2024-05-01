package kr.co.greenart.file;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
public class FileController {
	@Autowired
	private IFileService service;

	@GetMapping
	public String fileNames(Model model) {
		List<String> filenames = service.findAllFilenames();
		model.addAttribute("filenames", filenames);
		return "fileform";
	}

	@PostMapping
	public @ResponseBody String submit(@RequestParam MultipartFile upload) throws IllegalStateException, IOException {
		String originalFilename = upload.getOriginalFilename();

//		upload.transferTo(Paths.get("d:\\mydata", originalFilename));
		service.save(originalFilename, new ByteArrayResource(upload.getBytes()));

		return "업로드 완료";
	}
}

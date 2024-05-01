package kr.co.greenart.file;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Transactional;

public interface IFileService {

	int save(String filename, Resource resource);
	
	public List<String> findAllFilenames();
}
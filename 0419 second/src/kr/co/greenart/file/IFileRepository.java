package kr.co.greenart.file;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;

public interface IFileRepository {

	int save(String filename, Resource resource) throws IOException;
	public List<String> findAllFilenames();
}
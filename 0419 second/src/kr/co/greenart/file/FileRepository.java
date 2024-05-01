package kr.co.greenart.file;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepository implements IFileRepository {
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public int save(String filename, Resource resource) throws IOException {
		return template.update("INSERT INTO filebin (filename, filedata) VALUES (?, ?)"
				, filename, resource.getInputStream());
	}

	@Override
	public List<String> findAllFilenames() {
		return null;
	}
}

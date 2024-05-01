package kr.co.greenart.file;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class FileRepositoryEncoded implements IFileRepository {
	@Autowired
	private JdbcTemplate template;
	
	
	@Override
	public int save(String filename, Resource resource) throws IOException {
		return template.update("INSERT INTO filebase64 (filename, encoded) VALUES (?, ?)"
				, filename, resource.getInputStream());
	}
	
	@Override
	public List<String> findAllFilenames() {
        return template.query("SELECT filename FROM filebase64", (rs, rowNum) -> rs.getString("filename"));
    }
}

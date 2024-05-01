package kr.co.greenart.file;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class FileService implements IFileService {
	@Autowired
	private IFileRepository repo;
	
	@Override
	@Transactional
	public int save(String filename, Resource resource) {
		try {
			return repo.save(filename, resource);
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR
					, "현재 서버에 문제가 발생했습니다. 다시 시도해 주세요.");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<String> findAllFilenames() {
		return repo.findAllFilenames();
	}
	
}

package kr.co.greenart.file;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.server.ResponseStatusException;

@Service
@Primary
public class FileServiceEncoded implements IFileService {
	@Autowired
	private IFileRepository repo;
	
	@Override
	public int save(String filename, Resource resource) {
		byte[] bytearray = ((ByteArrayResource) resource).getByteArray();
		
		byte[] encode = Base64Utils.encode(bytearray);
		
		try {
			return repo.save(filename, new ByteArrayResource(encode));
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR
					, "작업 중 오류가 발생했습니다. 다시 시도해주세요.");
		}
	}

	@Override
	public List<String> findAllFilenames() {
		return repo.findAllFilenames();
	}

}

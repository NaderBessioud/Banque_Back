package tn.banque.Services;

import java.io.IOException;
import java.util.List;
import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import tn.banque.Helper.ExcelHelper;
import tn.banque.Entities.Action;
import tn.banque.Repositories.ActionRepository;

@Service
public class ExcelService {
  @Autowired
  ActionRepository repository;

  public void save(MultipartFile file) {
    try {
      List<Action> actions = ExcelHelper.excelToTutorials(file.getInputStream());
      repository.saveAll(actions);
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }

  public List<Action> getAllActions() {
    return (List<Action>) repository.findAll();
  }
  
  public ByteArrayInputStream load() {
	    List<Action> actions = (List<Action>) repository.findAll();

	    ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(actions);
	    return in;
	  }
  
}
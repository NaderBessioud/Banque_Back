package tn.banque.Helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import tn.banque.Entities.Action;

public class ExcelHelper {
  public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
  static String[] HEADERs = { "idAC", "titre", "prix", "nombre", "type", "total" };
  static String SHEET = "Tutorials";

  public static boolean hasExcelFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static List<Action> excelToTutorials(InputStream is) {
    try {
      Workbook workbook = new XSSFWorkbook(is);

      Sheet sheet = workbook.getSheet(SHEET);
      Iterator<Row> rows = sheet.iterator();

      List<Action> actions = new ArrayList<Action>();

      int rowNumber = 0;
      while (rows.hasNext()) {
        Row currentRow = rows.next();

        // skip header
        if (rowNumber == 0) {
          rowNumber++;
          continue;
        }

        Iterator<Cell> cellsInRow = currentRow.iterator();

        Action action = new Action();

        int cellIdx = 0;
        while (cellsInRow.hasNext()) {
          Cell currentCell = cellsInRow.next();

          switch (cellIdx) {
          case 0:
            action.setIdAC((long) currentCell.getNumericCellValue());
            break;

          case 1:
            action.setTitre(currentCell.getStringCellValue());
            break;

          case 2:
            action.setPrix((float) currentCell.getNumericCellValue());
            break;

          case 3:
            action.setNombre((int) currentCell.getNumericCellValue());
            break;
            
          case 4:
            action.setType(currentCell.getStringCellValue());
            break;

          case 5:
            action.setTotal((float) currentCell.getNumericCellValue());
            break;
              
          default:
            break;
          }

          cellIdx++;
        }

        actions.add(action);
      }

      workbook.close();

      return actions;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
    }
  }

  public static ByteArrayInputStream tutorialsToExcel(List<Action> actions) {

	    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
	      Sheet sheet = workbook.createSheet(SHEET);

	      // Header
	      Row headerRow = sheet.createRow(0);

	      for (int col = 0; col < HEADERs.length; col++) {
	        Cell cell = headerRow.createCell(col);
	        cell.setCellValue(HEADERs[col]);
	      }

	      int rowIdx = 1;
	      for (Action act : actions) {
	        Row row = sheet.createRow(rowIdx++);

	        row.createCell(0).setCellValue(act.getIdAC());
	        row.createCell(1).setCellValue(act.getTitre());
	        row.createCell(2).setCellValue(act.getPrix());
	        row.createCell(3).setCellValue(act.getNombre());
	        row.createCell(4).setCellValue(act.getType());
	        row.createCell(5).setCellValue(act.getTotal());

	      }

	      workbook.write(out);
	      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
	    }
	  }
}
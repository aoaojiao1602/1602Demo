package com.hwg.utils;

import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class POIUtils {

	/**
	 * Sheet复制
	 * @param srcSheet
	 * @param sheet2
	 * @param copyValueFlag
	 */
	@SuppressWarnings("rawtypes")
	public static void copySheet(Workbook resultWorkBook, Sheet srcSheet,
			Sheet tartgetSheet, boolean copyValueFlag) {
		// 合并区域处理
		mergerRegion(srcSheet, tartgetSheet);
		for (
		Iterator rowIt = srcSheet.rowIterator(); rowIt.hasNext();) {
			Row tmpRow = (XSSFRow) rowIt.next();
			Row newRow = tartgetSheet.createRow(tmpRow.getRowNum());
			// 行复制
			copyRow(resultWorkBook, tmpRow, newRow, copyValueFlag);
		}
		for (int j = 0; j < srcSheet.getRow(0).getLastCellNum(); j++) {
			tartgetSheet.setColumnWidth(j,srcSheet.getColumnWidth(j));
		}
	}

	/**
	 * 行复制功能
	 * 
	 * @param fromRow
	 * @param toRow
	 */
	@SuppressWarnings("rawtypes")
	public static void copyRow(Workbook wb, Row fromRow, Row toRow,
			boolean copyValueFlag) {
		for (Iterator cellIt = fromRow.cellIterator(); cellIt.hasNext();) {
			Cell tmpCell = (XSSFCell) cellIt.next();
			Cell newCell = toRow.createCell(tmpCell.getColumnIndex());
			copyCell(wb, tmpCell, newCell, copyValueFlag);
		}
	}

	/**
	 * 复制原有sheet的合并单元格到新创建的sheet
	 * 
	 * @param sheetCreat
	 *            新创建sheet
	 * @param sheet
	 *            原有的sheet
	 */
	public static void mergerRegion(Sheet fromSheet, Sheet toSheet) {
		int sheetMergerCount = fromSheet.getNumMergedRegions();
		for (int i = 0; i < sheetMergerCount; i++) {
			CellRangeAddress mergedRegionAt = fromSheet.getMergedRegion(i);
			toSheet.addMergedRegion(mergedRegionAt);
		}
	}

	/**
	 * 复制单元格
	 * 
	 * @param srcCell
	 * @param distCell
	 * @param copyValueFlag
	 *            true则连同cell的内容一起复制
	 */
	@SuppressWarnings("deprecation")
	public static void copyCell(Workbook wb, Cell srcCell,
			Cell distCell, boolean copyValueFlag) {
		CellStyle newstyle = wb.createCellStyle();
		newstyle.cloneStyleFrom(srcCell.getCellStyle());
		// 样式
		distCell.setCellStyle(newstyle);
		// 评论
		if (srcCell.getCellComment() != null) {
			distCell.setCellComment(srcCell.getCellComment());
		}
		// 不同数据类型处理
		int srcCellType = srcCell.getCellType();
		distCell.setCellType(srcCellType);
		if (copyValueFlag) {
			if (srcCellType == XSSFCell.CELL_TYPE_NUMERIC) {
				if (HSSFDateUtil.isCellDateFormatted(srcCell)) {
					distCell.setCellValue(srcCell.getDateCellValue());
				} else {
					distCell.setCellValue(srcCell.getNumericCellValue());
				}
			} else if (srcCellType == XSSFCell.CELL_TYPE_STRING) {
				distCell.setCellValue(srcCell.getRichStringCellValue());
			} else if (srcCellType == XSSFCell.CELL_TYPE_BLANK) {
				// nothing21
			} else if (srcCellType == XSSFCell.CELL_TYPE_BOOLEAN) {
				distCell.setCellValue(srcCell.getBooleanCellValue());
			} else if (srcCellType == XSSFCell.CELL_TYPE_ERROR) {
				distCell.setCellErrorValue(srcCell.getErrorCellValue());
			} else if (srcCellType == XSSFCell.CELL_TYPE_FORMULA) {
				distCell.setCellFormula(srcCell.getCellFormula());
			} else { // nothing29
			}
		}
	}
}
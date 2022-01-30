/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ustunerturizm2;

/**
 *
 * @author iserh
 */
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.filechooser.FileSystemView;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelDokumu {

    private int turid;

    ExcelDokumu(int turid) {
        this.turid = turid;
    }

    public void ExcelDokumOlustur() throws IOException, SQLException, URISyntaxException {
        File home = FileSystemView.getFileSystemView().getHomeDirectory();
        String path = home.getAbsolutePath();
        
        URL source=getClass().getResource("oturmaplani.xls");
        POIFSFileSystem fs = new POIFSFileSystem(
                
                source.openStream());
        
        HSSFWorkbook wb = new HSSFWorkbook(fs, true);
        HSSFCellStyle style = wb.createCellStyle();
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);

        HSSFSheet sheet = wb.getSheetAt(0);

        File f1 = new File(path + "\\Tur Excel Dökümleri");
        if (!f1.exists()) {
            if (f1.mkdir()) {
            } else {
            }
        }
        //Tur bilgilerini gir
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        int turotobusuid = 0;
        String turadi = "";
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from turlar WHERE ID= " + turid);
            if (resultSet.next()) {
                turadi = resultSet.getString("turadi");
                sheet.getRow(0).getCell(9).setCellValue(turadi);
                sheet.getRow(1).getCell(9).setCellValue(resultSet.getString("hareket_tarihi"));
                sheet.getRow(2).getCell(9).setCellValue(resultSet.getString("donus_tarihi"));
                sheet.getRow(3).getCell(9).setCellValue(resultSet.getString("hareket_saati"));
                sheet.getRow(4).getCell(9).setCellValue(resultSet.getString("hareket_yeri"));
                sheet.getRow(5).getCell(9).setCellValue(resultSet.getString("tur_danismani"));
                turotobusuid = resultSet.getInt("tur_otobusu_id");
            }

        } catch (SQLException e) {
            helper.showErrorMessage(e);

        } finally {
            statement.close();
            connection.close();
        }

        //Koltuk düzenini oluştur
        int koltuksayisi = 0;
        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select koltuksayisi from otobus WHERE ID=" + turotobusuid);
            if (resultSet.next()) {
                koltuksayisi = resultSet.getInt("koltuksayisi");
            }

        } catch (SQLException e) {
            helper.showErrorMessage(e);

        } finally {
            statement.close();
            connection.close();
        }
        if (koltuksayisi < 25) {
            int koltukno = 0;
            int columns = 4;
            int rows = 1 + ((koltuksayisi - 4) / 3);
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    koltukno++;
                    if (column == 2 && row + 1 != rows) {
                        koltukno--;
                    } else {
                        if (sheet.getRow(row * 3 + 15) == null) {
                            sheet.createRow(row * 3 + 15);
                        }
                        if (sheet.getRow(row * 3 + 16) == null) {
                            sheet.createRow(row * 3 + 16);
                        }
                        if (sheet.getRow(row * 3 + 15).getCell(column) == null) {
                            sheet.getRow(row * 3 + 15).createCell(column);
                        }
                        if (sheet.getRow(row * 3 + 16).getCell(column) == null) {
                            sheet.getRow(row * 3 + 16).createCell(column);
                        }

                        sheet.addMergedRegion(new CellRangeAddress(row * 3 + 15, row * 3 + 16, column, column));
                        sheet.getRow(row * 3 + 15).getCell(column).setCellValue(koltukno);
                        sheet.getRow(row * 3 + 15).getCell(column).setCellStyle(style);
                        sheet.getRow(row * 3 + 16).getCell(column).setCellStyle(style);
                    }
                }
            }
        } else if (koltuksayisi > 25 && koltuksayisi < 35) {
            int koltukno = 0;
            int columns = 5;
            int rows = 2 + ((koltuksayisi - 5) / 4);
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    koltukno++;
                    if (column == 2 && row + 1 != rows) {
                        koltukno--;
                    } else if ((column == 3 && row + 2 == rows) || (column == 4 && row + 2 == rows)) {
                        koltukno--;
                        if (sheet.getRow(row * 3 + 15) == null) {
                            sheet.createRow(row * 3 + 15);
                        }
                        if (sheet.getRow(row * 3 + 16) == null) {
                            sheet.createRow(row * 3 + 16);
                        }
                        if (sheet.getRow(row * 3 + 15).getCell(column) == null) {
                            sheet.getRow(row * 3 + 15).createCell(column);
                        }
                        if (sheet.getRow(row * 3 + 16).getCell(column) == null) {
                            sheet.getRow(row * 3 + 16).createCell(column);
                        }
                        sheet.addMergedRegion(new CellRangeAddress(row * 3 + 15, row * 3 + 16, column, column));
                        sheet.getRow(row * 3 + 15).getCell(column).setCellValue("KAPI");
                        sheet.getRow(row * 3 + 15).getCell(column).setCellStyle(style);
                        sheet.getRow(row * 3 + 16).getCell(column).setCellStyle(style);
                    } else {
                        if (sheet.getRow(row * 3 + 15) == null) {
                            sheet.createRow(row * 3 + 15);
                        }
                        if (sheet.getRow(row * 3 + 16) == null) {
                            sheet.createRow(row * 3 + 16);
                        }
                        if (sheet.getRow(row * 3 + 15).getCell(column) == null) {
                            sheet.getRow(row * 3 + 15).createCell(column);
                        }
                        if (sheet.getRow(row * 3 + 16).getCell(column) == null) {
                            sheet.getRow(row * 3 + 16).createCell(column);
                        }

                        sheet.addMergedRegion(new CellRangeAddress(row * 3 + 15, row * 3 + 16, column, column));
                        sheet.getRow(row * 3 + 15).getCell(column).setCellValue(koltukno);
                        sheet.getRow(row * 3 + 15).getCell(column).setCellStyle(style);
                        sheet.getRow(row * 3 + 16).getCell(column).setCellStyle(style);
                    }
                }
            }
        } else {
            int koltukno = 0;
            int columns = 5;
            int rows = 2 + ((koltuksayisi - 5) / 4);
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    koltukno++;
                    if (column == 2 && row + 1 != rows) {
                        koltukno--;
                    } else if ((column == 3 && row / 2 == rows) || (column == 4 && row / 2 == rows)) {
                        koltukno--;
                        if (sheet.getRow(row * 3 + 15) == null) {
                            sheet.createRow(row * 3 + 15);
                        }
                        if (sheet.getRow(row * 3 + 16) == null) {
                            sheet.createRow(row * 3 + 16);
                        }
                        if (sheet.getRow(row * 3 + 15).getCell(column) == null) {
                            sheet.getRow(row * 3 + 15).createCell(column);
                        }
                        if (sheet.getRow(row * 3 + 16).getCell(column) == null) {
                            sheet.getRow(row * 3 + 16).createCell(column);
                        }
                        sheet.addMergedRegion(new CellRangeAddress(row * 3 + 15, row * 3 + 16, column, column));
                        sheet.getRow(row * 3 + 15).getCell(column).setCellValue("KAPI");
                        sheet.getRow(row * 3 + 15).getCell(column).setCellStyle(style);
                        sheet.getRow(row * 3 + 16).getCell(column).setCellStyle(style);
                    } else {
                        if (sheet.getRow(row * 3 + 15) == null) {
                            sheet.createRow(row * 3 + 15);
                        }
                        if (sheet.getRow(row * 3 + 16) == null) {
                            sheet.createRow(row * 3 + 16);
                        }
                        if (sheet.getRow(row * 3 + 15).getCell(column) == null) {
                            sheet.getRow(row * 3 + 15).createCell(column);
                        }
                        if (sheet.getRow(row * 3 + 16).getCell(column) == null) {
                            sheet.getRow(row * 3 + 16).createCell(column);
                        }

                        sheet.addMergedRegion(new CellRangeAddress(row * 3 + 15, row * 3 + 16, column, column));
                        sheet.getRow(row * 3 + 15).getCell(column).setCellValue(koltukno);
                        sheet.getRow(row * 3 + 15).getCell(column).setCellStyle(style);
                        sheet.getRow(row * 3 + 16).getCell(column).setCellStyle(style);
                    }
                }
            }

        }

        //Yolcuları koltuklara yerleştir
        HSSFCellStyle style2 = wb.createCellStyle();
        style2.setBorderBottom(BorderStyle.THIN);
        style2.setBorderTop(BorderStyle.THIN);
        style2.setBorderRight(BorderStyle.THIN);
        style2.setBorderLeft(BorderStyle.THIN);
        style2.setAlignment(HorizontalAlignment.LEFT);
        style2.setVerticalAlignment(VerticalAlignment.CENTER);
        for (int i = 1; i <= koltuksayisi; i++) {
            if (sheet.getRow(i * 2 + 5) == null) {
                sheet.createRow(i * 2 + 5);
            }
            if (sheet.getRow(i * 2 + 6) == null) {
                sheet.createRow(i * 2 + 6);
            }
            for (int j = 5; j < 14; j++) {
                if (sheet.getRow(i * 2 + 5).getCell(j) == null) {
                    sheet.getRow(i * 2 + 5).createCell(j);
                }
                if (sheet.getRow(i * 2 + 6).getCell(j) == null) {
                    sheet.getRow(i * 2 + 6).createCell(j);

                }
            }
            sheet.addMergedRegion(new CellRangeAddress(i * 2 + 5, i * 2 + 6, 6, 6));
            sheet.getRow(i * 2 + 5).getCell(6).setCellValue(i);
            sheet.getRow(i * 2 + 5).getCell(6).setCellStyle(style2);
            sheet.getRow(i * 2 + 6).getCell(6).setCellStyle(style2);
            //Koltukta oturan yolcunun id'sini al
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select yolcuid from koltuk WHERE turid=" + turid + " AND koltuknumara=" + i);
            int yolcuid = 0;

            if (resultSet.next()) {
                yolcuid = resultSet.getInt("yolcuid");
            }
            connection.close();
            statement.close();

            //Yolcu bilgilerini al
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("Select * from musteri WHERE ID=" + yolcuid);
            String Ad = "";
            String Soyad = "";
            String TCKN = "";
            String TelNo = "";
            String HESKod = "";
            if (resultSet.next()) {
                Ad = resultSet.getString("Ad");
                Soyad = resultSet.getString("Soyad");
                TCKN = resultSet.getString("TCKN");
                TelNo = resultSet.getString("TelNo");
                HESKod = resultSet.getString("HESKod");
            }
            sheet.addMergedRegion(new CellRangeAddress(i * 2 + 5, i * 2 + 5, 7, 10));
            sheet.getRow(i * 2 + 5).getCell(7).setCellValue(Ad + " " + " " + Soyad + " " + TCKN);
            for (int j = 7; j <= 10; j++) {
                sheet.getRow(i * 2 + 5).getCell(j).setCellStyle(style2);
            }
            sheet.addMergedRegion(new CellRangeAddress(i * 2 + 5, i * 2 + 5, 11, 13));
            sheet.getRow(i * 2 + 5).getCell(11).setCellValue(TelNo);
            for (int j = 11; j <= 13; j++) {
                sheet.getRow(i * 2 + 5).getCell(j).setCellStyle(style2);
            }
            sheet.addMergedRegion(new CellRangeAddress(i * 2 + 6, i * 2 + 6, 7, 10));
            sheet.getRow(i * 2 + 6).getCell(7).setCellValue("HES KODU : " + HESKod);
            for (int j = 7; j <= 10; j++) {
                sheet.getRow(i * 2 + 6).getCell(j).setCellStyle(style2);
            }
            sheet.addMergedRegion(new CellRangeAddress(i * 2 + 6, i * 2 + 6, 11, 13));
            for (int j = 11; j <= 13; j++) {
                sheet.getRow(i * 2 + 6).getCell(j).setCellStyle(style2);
            }

        }

        try ( //Yazdır
                FileOutputStream fileOut = new FileOutputStream(path + "\\Tur Excel Dökümleri\\" + turadi + ".xls")) {
            wb.write(fileOut);
        }

    }

    /**
     * @return the turid
     */
    public int getTurid() {
        return turid;
    }

    /**
     * @param turid the turid to set
     */
    public void setTurid(int turid) {
        this.turid = turid;
    }

}

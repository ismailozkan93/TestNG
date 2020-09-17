package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    @Test
    public void test() throws IOException {
        String dosyaYolu = "src/test/Resources/ulke.xlsx";
        //Java'da bir dosyayı açmak için bu kullanılır.
        // Parametre bölümüne açmak istediğimiz dosyanın adresi (dosya yolu,path) yazılır
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // Workbook (excel) dosyasını okumaya başladık.
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // Dosya üzerinde yazma işlemi gerçekleştireceğimiz için buraya
        // FileOutputStream class'ından bir tane nesne oluşturmamız gerekiyor.
        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);

        //ÜLKELER BASKENTLER MESHURLAR NÜFUS
        //0nci indeksteki satirin,3.indeksteki hücresine NÜFUS hücresi ekleyelim.
        workbook.getSheetAt(0).getRow(0).createCell(3).setCellValue("Nüfus");
        workbook.getSheetAt(0).getRow(1).createCell(3).setCellValue("80000000");
        workbook.getSheetAt(0).getRow(2).createCell(3).setCellValue("10000000");


        //0.indexteki satirin 1.indexindeki hücreyi silelim.(neyi meshur)
        Cell delhücre =workbook.getSheetAt(0).getRow(0).getCell(2);
        workbook.getSheetAt(0).getRow(0).removeCell(delhücre);

        //1.indeksteki satiri silelim(Almanya satirini silelim)
        Row delhücre1=workbook.getSheetAt(0).getRow(1);
        workbook.getSheetAt(0).removeRow(delhücre1);


        //yaptigimiz degisiklikleri excel dosyasina aktarir,veriyi yazar ve kaydeder.
        workbook.write(fileOutputStream);

        fileOutputStream.close();
        workbook.close();
        fileInputStream.close();



    }
}
package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {

    @Test
    public void test() throws IOException {
        String dosyayolu="src/test/Resources/ulke.xlsx";

        //jAVADA bir dosyayi acmak icin kullanilir.
        FileInputStream fileInputStream=new FileInputStream(dosyayolu);

        Workbook workbook= WorkbookFactory.create(fileInputStream);

        //1nci sayfaya gider. (index degeri 0 dan baslar.)
        Sheet sheet=workbook.getSheetAt(0);

        //1.satira gidelim (index degeri 0 dan baslar.)
        Row row =sheet.getRow(0);

        //1.Hücreyi alalim (index degeri 0 dan baslar.)
        Cell ulkeler=row.getCell(0);
        Cell baskentler=row.getCell(1);
        Cell meshurlar=row.getCell(2);
        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);

        // Excel'e Git -> Sheet 0'a git -> 2. İndexteki Satıra git -> 1. İndexteki Hücre
        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(1));
        System.out.println(workbook.getSheetAt(0).getRow(7).getCell(2));
        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0));

        // Son satır(Row)'ın numarasını almak için (indexini, index 0 dan başlar)
        int satirSayisi = workbook.getSheetAt(0).getLastRowNum() + 1;
        System.out.println("Satır sayısı : " + satirSayisi);


        // İçerisinde veri olan satır sayısını almak isterseniz
        // index'i 1'den başlıyor.
        int doluSatirSayisi = workbook.getSheetAt(0).getPhysicalNumberOfRows();
        System.out.println("Dolu Satır Sayısı : " + doluSatirSayisi);

        //Ülkeleri yazdirma
        int sonsatirindexi=workbook.getSheetAt(0).getLastRowNum();
        for(int i=0;i<=sonsatirindexi;i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }
        System.out.println("-----------------------------");
        //baskentleri yazdirma
        for(int i=0;i<=sonsatirindexi;i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(1));
        }

        System.out.println("---------------------");

        //bir satirin son sütununun indeksini alma
        //index 1'den baslar

        int sonsütunindex=workbook.getSheetAt(0).getRow(0).getLastCellNum();
        System.out.println("Son sütun index: "+sonsütunindex);

        for (int i=1;i<=sonsütunindex;i++){
            System.out.print(workbook.getSheetAt(0).getRow(3).getCell(i)+" ");
        }



    }



}

package grupcalismalari;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class G08_excelsoru {
    @Test
    public void test01() throws IOException {
//Soru: isimlerden olusan bir string dizisini ülkeler.xlsx dosyasinin sayfa2,
// 1. sütununa yukaridan asagiya dogru yazdiriniz

        String[] isimler = {"Eyup", "Ertugrul", "Muammer"};

        //ilk olarak dosya yolunu lamamiz lazim
        String dosyaYolu = "src/test/java/day13_excelOtomasyonu/ulkeler.xlsx";
        //bu dosya yolundan bilgiler alincak
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //3-bu dosya yoliundan alinan bilgiler ile bir sanal  excel dosyasi olusuturulacak
        Workbook workbook = WorkbookFactory.create(fis);
        //4-bu sanal dosyalara erisecegiz
        Sheet sayfa2 = workbook.getSheet("Sayfa2");
        // sayfa2 e sanal workbook üzerinde bir hücre olusturmamiz gerek
        sayfa2.getRow(0).createCell(6);
        // olusturulan hücreye veri yazdiracagiz
        sayfa2.getRow(0).getCell(6).setCellValue("Isimler");

        for (int i = 0; i < isimler.length; i++) {
            Row row = sayfa2.createRow(i + 1);
            Cell cell = row.createCell(6);
            cell.setCellValue(isimler[i]);
            //fiziki dosyamiza yazdirmak icin önce yazdiracagimiz dosyaya erismemiz gerek
            FileOutputStream fos = new FileOutputStream(dosyaYolu);
            // yazma islemi
            workbook.write(fos);

        }
    }
}

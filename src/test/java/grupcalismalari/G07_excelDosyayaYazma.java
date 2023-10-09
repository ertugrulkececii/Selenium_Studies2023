package grupcalismalari;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class G07_excelDosyayaYazma {
    @Test
    public void readExcel() throws IOException {
        //ilk olarak dosya yolunu lamamiz lazim
        String dosyaYolu = "src/test/java/day13_excelOtomasyonu/ulkeler.xlsx";
        //bu dosya yolundan bilgiler alincak
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //3-bu dosya yoliundan alinan bilgiler ile bir sanal  excel dosyasi olusuturulacak
        Workbook workbook = WorkbookFactory.create(fis);
        //4-bu sanal dosyalara erisecegiz
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // sayfa1 e sanal workbook üzerinde bir hücre olusturmamiz gerek
        sayfa1.getRow(0).createCell(4);
        // olusturulan hücreye veri yazdiracagiz
        sayfa1.getRow(0).getCell(4).setCellValue("Para Birimi");

        //fiziki dosyamiza yazdirmak icin önce yazdiracagimiz dosyaya erismemiz gerek
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        // yazma islemi
        workbook.write(fos);

        // bütün acik dosya islemlerini kapatmamiz gerek
        fis.close();;
        fos.close();
        workbook.close();

    }
}

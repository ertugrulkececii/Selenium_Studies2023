package grupcalismalari;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class G06_excelDosyaOkuma {

    @Test
    public void readExcel() throws IOException {
        //ilk olarak dosya yolunu lamamiz lazim
        String dosyaYolu= "src/test/java/day13_excelOtomasyonu/ulkeler.xlsx";
        //bu dosya yolundan bilgiler alincak
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //3-bu dosya yoliundan alinan bilgiler ile bir sanal  excel dosyasi olusuturulacak
        Workbook workbook= WorkbookFactory.create(fis);
        //4-bu sanal dosyalara erisecegiz
        Sheet sheetUlkeler = workbook.getSheet("Sayfa1");
        //satir alinacak
        Row row = sheetUlkeler.getRow(1);// index no
        //sutun/cell
        Cell cell= row.getCell(0);//1.sutundaki hucre
        System.out.println(cell);

        String expectedIcerik= "Afghanistan";
        String actualSonuc = cell.toString();
        Assert.assertEquals(expectedIcerik,actualSonuc);

        System.out.println("---------------------");
        // ilk 10 ülke ismini ve baskent ismini türkce olarak yazdiralim
        System.out.print(sheetUlkeler.getRow(0).getCell(2));
        System.out.println(" " + sheetUlkeler.getRow(0).getCell(3));

        for (int i = 1; i <= 10; i++) {
            System.out.print(i+ ". " + sheetUlkeler.getRow(i).getCell(2));
            System.out.println(" " +sheetUlkeler.getRow(i).getCell(3));
        }

    }

    }


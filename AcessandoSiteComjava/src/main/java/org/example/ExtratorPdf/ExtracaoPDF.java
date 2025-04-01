package org.example.ExtratorPdf;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;
import com.aspose.pdf.*;
import com.aspose.pdf.facades.PdfExtractor;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.util.ArrayList;

public class ExtracaoPDF {

    public void teste() throws Exception {
        Document pdfDocument = new Document("/home/guilherme/Documentos/Anexo I.pdf");
        FiltroNomes filtroNomes = new FiltroNomes();
        ArrayList<String> alfabeto = filtroNomes.popularFiltroCOmALFABETO();
        Workbook workbook = new Workbook();
        Worksheet worksheet = workbook.getWorksheets().get(0);
        int contador = 0;
        for (Page page : pdfDocument.getPages()) {
            TableAbsorber absorber = new TableAbsorber();
            absorber.visit(page);
            for (AbsorbedTable table : absorber.getTableList()) {
                for (AbsorbedRow row : table.getRowList()) {
                    for (int i = 0; i < 12; i++) {
                        if (i >= row.getCellList().size()) break;
                        AbsorbedCell cell = row.getCellList().get(i);
                        TextFragmentCollection textFragments = cell.getTextFragments();
                        StringBuilder textoCelula = new StringBuilder();

                        for (TextFragment fragment : textFragments) {
                            for (TextSegment seg : fragment.getSegments()) {
                                textoCelula.append(seg.getText());
                            }
                        }

                        if (textoCelula.toString().trim().isEmpty()) continue;

                        String pos = alfabeto.get(i) + (contador + 1);
                        worksheet.getCells().get(pos).putValue(textoCelula.toString().trim());
                    }
                    contador++;
                }
            }
            System.out.println(page.getNumber());
        }
        workbook.save("excel.csv");
    }
}

package com.frael.federacion.pdfs;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* 
 * Probando PDFBox
 */
@RestController
@CrossOrigin
@RequestMapping("/pdf-arbitros")
public class ArbitroPdf {

    @GetMapping(value = "/generate-pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generarArbitroPdf() {
        //1ero Crear documento
        PDDocument document = new PDDocument();
        // Agregamos una pagina al document
        PDPage page = new PDPage();
        document.addPage(page);

        HttpHeaders header = new HttpHeaders();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        

        try {
            //Agregar contenido al PDF
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.HELVETICA, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700);
            contentStream.showText("Haciendo un PDF!");
            contentStream.endText();


            contentStream.close();

            document.save(baos);

            document.close();
            
            //Configurar los encabezados de la respuesta HTTP
            header.setContentType(MediaType.APPLICATION_PDF);
            header.setContentDispositionFormData("attachment", "arbitros.pdf");

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        
        return ResponseEntity.ok().headers(header).contentLength(baos.size()).body(baos.toByteArray());
    }
    
}

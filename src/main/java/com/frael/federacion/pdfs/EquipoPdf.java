package com.frael.federacion.pdfs;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frael.federacion.exceptions.EquipoException;
import com.frael.federacion.model.Equipo;
import com.frael.federacion.services.EquipoService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

/* 
 * Probando OpenPdf
 */
@RestController
@CrossOrigin
@RequestMapping("/equipo-pdf")
public class EquipoPdf {

    @Autowired
    EquipoService equipoService;

    @GetMapping("/generate-pdf")
    public ResponseEntity<byte[]> generarEquipoPdf() {

        HttpHeaders headers = new HttpHeaders();
        // Configurar los encabezados de la respuesta HTTP
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "arbitros.pdf");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 1ero Creacion de documento
        Document document = new Document();
        // Agregamos la relacion
        PdfWriter.getInstance(document, baos); // Todo lo que escribas en el documento se redirigirá al ByteArrayOutputStream (baos)

        document.open();

        PdfPTable tabla = new PdfPTable(2);
        try {
            List<Equipo> equipos = equipoService.listarEquipos();
            equipos.forEach(eq -> {
                tabla.addCell(eq.getDirector());
                tabla.addCell(eq.getNombre());

            });
        } catch (EquipoException | DocumentException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

        document.add(tabla);

        document.close();

        return ResponseEntity.ok().headers(headers).contentLength(baos.size()).body(baos.toByteArray());
    }
}
